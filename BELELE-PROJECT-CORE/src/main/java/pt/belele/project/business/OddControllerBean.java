package pt.belele.project.business;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pt.belele.project.business.ann.Ann;
import pt.belele.project.business.ann.DatasetController;
import pt.belele.project.business.ann.obj.Dataset;
import pt.belele.project.business.util.Triplet;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Odd;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class OddControllerBean implements OddController {

    private static final Logger LOG = LogManager.getLogger(OddControllerBean.class);

    @EJB
    private DatasetController datasetController;

    @Override
    public void calculateLayOddsAsBackOdds(Odd odd) {
	Double layHomeWin = (odd.getBackHomeWin() + 0.05) / ((odd.getBackHomeWin() + 0.05) - 1);
	odd.setLayHomeWin(layHomeWin);
	Double layDraw = (odd.getBackDraw() + 0.05) / ((odd.getBackDraw() + 0.05) - 1);
	odd.setLayDraw(layDraw);
	Double layAwayWin = (odd.getBackAwayWin() + 0.05) / ((odd.getBackAwayWin() + 0.05) - 1);
	odd.setLayAwayWin(layAwayWin);
    }

    @Override
    public Odd calculateAnnOddsForFixture(Fixture f, List<Fixture> oldFixtures, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception {
	Triplet<float[][], float[][], float[][]> annTriplet = getANNOddsForFixture(f, oldFixtures, winVariables, drawVariables, loseVariables);

	if (annTriplet == null) {
	    return null;
	}

	float[][] annWin = normalize(annTriplet.getA());
	float[][] annDraw = normalize(annTriplet.getB());
	float[][] annLose = normalize(annTriplet.getC());

	float[] annWinAverage = average(annWin);
	float[] annDrawAverage = average(annDraw);
	float[] annLoseAverage = average(annLose);

	Triplet<float[], float[], float[]> finalOddTriplet = getANNFinalOdds(
		annWinAverage, annDrawAverage, annLoseAverage);

	float[] annWinOdd = finalOddTriplet.getA();
	float[] annDrawOdd = finalOddTriplet.getB();
	float[] annLoseOdd = finalOddTriplet.getC();

	Odd ANNOdds = new Odd((double) annWinOdd[0], (double) annDrawOdd[0], (double) annLoseOdd[0]);
	calculateLayOddsAsBackOdds(ANNOdds);

	return ANNOdds;
    }

    @Override
    public Triplet<float[], float[], float[]> calculateAnnOddsForFixtures(List<Fixture> fixtures, List<Fixture> oldFixtures, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception {
	Triplet<float[][], float[][], float[][]> annTriplet = getANNOddsForFixtures(fixtures, oldFixtures, winVariables, drawVariables, loseVariables);
	float[][] annWin = normalize(annTriplet.getA());
	float[][] annDraw = normalize(annTriplet.getB());
	float[][] annLose = normalize(annTriplet.getC());

	float[] annWinAverage = average(annWin);
	float[] annDrawAverage = average(annDraw);
	float[] annLoseAverage = average(annLose);

	return getANNFinalOdds(annWinAverage, annDrawAverage, annLoseAverage);
    }

    private Triplet<float[][], float[][], float[][]> getANNOddsForFixtures(List<Fixture> fixtures, List<Fixture> oldFixtures, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception {
	Triplet<List<Dataset>, List<Dataset>, List<Dataset>> triplet = datasetController.generateDatasetForFixtures(oldFixtures, winVariables, drawVariables, loseVariables);

	if (triplet.getA() == null || triplet.getA().isEmpty()) {
	    return null;
	}

	float[][] inWin = calculateDataset(triplet.getA(), winVariables);
	float[][] inDraw = calculateDataset(triplet.getB(), drawVariables);
	float[][] inLose = calculateDataset(triplet.getC(), loseVariables);

	float[] taWin = calculateTarget(triplet.getA());
	float[] taDraw = calculateTarget(triplet.getB());
	float[] taLose = calculateTarget(triplet.getC());

	Triplet<List<Dataset>, List<Dataset>, List<Dataset>> teTriplet = datasetController.generateDatasetForFixtures(fixtures, winVariables, drawVariables, loseVariables);

	float[][] teWin = calculateDataset(teTriplet.getA(), winVariables);
	float[][] teDraw = calculateDataset(teTriplet.getB(), drawVariables);
	float[][] teLose = calculateDataset(teTriplet.getC(), loseVariables);

	float[][] oddWin = Ann.MLPSigmoidBP(inWin, teWin, taWin);
	float[][] oddDraw = Ann.MLPSigmoidBP(inDraw, teDraw, taDraw);
	float[][] oddLose = Ann.MLPSigmoidBP(inLose, teLose, taLose);

	return new Triplet<>(oddWin, oddDraw, oddLose);
    }

    private Triplet<float[][], float[][], float[][]> getANNOddsForFixture(Fixture f, List<Fixture> oldFixtures, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception {
	DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy");

	if (f.getDate().isBefore(formatter.parseDateTime("23/11/" + (f.getSeason().getYear() + 2000)))) {
	    return null;
	}

	Triplet<List<Dataset>, List<Dataset>, List<Dataset>> triplet = datasetController.generateDatasetForFixtures(oldFixtures, winVariables, drawVariables, loseVariables);

	if (triplet.getA() == null || triplet.getA().isEmpty()) {
	    return null;
	}

	float[][] inWin = calculateDataset(triplet.getA(), winVariables);
	float[][] inDraw = calculateDataset(triplet.getB(), drawVariables);
	float[][] inLose = calculateDataset(triplet.getC(), loseVariables);

	float[] taWin = calculateTarget(triplet.getA());
	float[] taDraw = calculateTarget(triplet.getB());
	float[] taLose = calculateTarget(triplet.getC());

	List<Fixture> teFixture = new ArrayList<>();
	teFixture.add(f);
	Triplet<List<Dataset>, List<Dataset>, List<Dataset>> teTriplet = datasetController.generateDatasetForFixtures(teFixture, winVariables, drawVariables, loseVariables);

	float[][] teWin = calculateDataset(teTriplet.getA(), winVariables);
	float[][] teDraw = calculateDataset(teTriplet.getB(), drawVariables);
	float[][] teLose = calculateDataset(teTriplet.getC(), loseVariables);

	float[][] oddWin = Ann.MLPSigmoidBP(inWin, teWin, taWin);
	float[][] oddDraw = Ann.MLPSigmoidBP(inDraw, teDraw, taDraw);
	float[][] oddLose = Ann.MLPSigmoidBP(inLose, teLose, taLose);

	return new Triplet<>(oddWin, oddDraw, oddLose);
    }

    private Triplet<float[], float[], float[]> getANNFinalOdds(float[] annWinAverage, float[] annDrawAverage, float[] annLoseAverage) {
	float[] finalAnnWinAverage = new float[annWinAverage.length];
	float[] finalAnnDrawAverage = new float[annDrawAverage.length];
	float[] finalAnnLoseAverage = new float[annLoseAverage.length];

	for (int i = 0; i < annWinAverage.length; i++) {
	    finalAnnWinAverage[i] = annWinAverage[i]
		    / (annWinAverage[i] + annDrawAverage[i] + annLoseAverage[i]);
	    finalAnnDrawAverage[i] = annDrawAverage[i]
		    / (annWinAverage[i] + annDrawAverage[i] + annLoseAverage[i]);
	    finalAnnLoseAverage[i] = annLoseAverage[i]
		    / (annWinAverage[i] + annDrawAverage[i] + annLoseAverage[i]);
	}

	return new Triplet<>(finalAnnWinAverage, finalAnnDrawAverage, finalAnnLoseAverage);
    }

    private static float[][] calculateDataset(List<Dataset> data, List<String> variables) throws Exception {
	float[][] in = new float[data.size()][variables.size()];
	for (int i = 0; i < data.size(); i++) {
	    for (int j = 0; j < variables.size(); j++) {
		try {
		    Method method;
		    method = data.get(i).getClass().getMethod("get" + variables.get(j));
		    Object value = method.invoke(data.get(i));
		    if(value instanceof Double)
		    {
			in[i][j] = ((Double) method.invoke(data.get(i))).floatValue();
		    }
		    else
		    {
			in[i][j] = ((Integer) method.invoke(data.get(i))).floatValue();
		    }
		} catch (SecurityException | NoSuchMethodException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
		    LOG.error("CALCULATE DATASET: ERROR GETTING VARIABLE " + variables.get(j));
		    throw new Exception(e);
		}
	    }
	}

	return in;
    }

    private static float[] calculateTarget(List<Dataset> data) {
	float[] ta = new float[data.size()];
	for (int i = 0; i < data.size(); i++) {
	    ta[i] = data.get(i).getResult();
	}

	return ta;
    }

    private float[][] normalize(float[][] data) {
	float[][] dataReturn = new float[data.length][data[0].length];
	for (int i = 0; i < data.length; i++) {
	    float[] row = data[i];
	    for (int j = 0; j < row.length; j++) {
		dataReturn[i][j] = (data[i][j] - getColumnMin(data, j)) / (getColumnMax(data, j) - getColumnMin(data, j));
	    }
	}

	return dataReturn;
    }

    private float[] average(float[][] data) {
	float[] averageData = new float[data.length];
	for (int i = 0; i < data.length; i++) {
	    float sum = 0;

	    for (int j = 0; j < data[i].length; j++) {
		sum += data[i][j];
	    }

	    averageData[i] = sum / data[i].length;
	}

	return averageData;
    }

    private float getColumnMin(float[][] data, int column) {
	float value = data[0][column];
	for (int row = 1; row < data.length; row++) {
	    if (value > data[row][column]) {
		value = data[row][column];
	    }
	}

	return value;
    }

    private float getColumnMax(float[][] data, int column) {
	float value = data[0][column];
	for (int row = 1; row < data.length; row++) {
	    if (value < data[row][column]) {
		value = data[row][column];
	    }
	}

	return value;
    }
}

package pt.belele.project.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import pt.belele.project.Main;
import pt.belele.project.algorithm.ExcelColumnsCalculation;
import pt.belele.project.algorithm.ExcelRow;
import pt.belele.project.ann.BetInputProvider;
import pt.belele.project.ann.OutputListener;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.FixtureDAO;
import pt.belele.project.util.Triplet;

import com.amd.aparapi.Kernel.EXECUTION_MODE;
import com.github.neuralnetworks.architecture.NeuralNetworkImpl;
import com.github.neuralnetworks.architecture.types.NNFactory;
import com.github.neuralnetworks.calculation.OutputError;
import com.github.neuralnetworks.input.MultipleNeuronsOutputError;
import com.github.neuralnetworks.training.TrainerFactory;
import com.github.neuralnetworks.training.backpropagation.BackPropagationTrainer;
import com.github.neuralnetworks.training.events.EarlyStoppingListener;
import com.github.neuralnetworks.training.random.MersenneTwisterRandomInitializer;
import com.github.neuralnetworks.training.random.NNRandomInitializer;
import com.github.neuralnetworks.util.Environment;

public class FixtureController {
	
	private FixtureDAO fixtureDAO;
	private EntityManager em;

	public FixtureController(EntityManager em) {
		fixtureDAO = new FixtureDAO(em);
		this.em = em;
	}

	public Fixture createFixture(Date date, Season s, Team home, Team away,
			Result result, Odd odd) {
		try {
			fixtureDAO.findFixture(date, s.getId(), home.getId(), away.getId());
		} catch (NoResultException e) {
			//CALCULAR BACK E LAY ODS
			OddController oddController = new OddController();
			oddController.calculateLayOddsAsBackOdds(odd);
			Fixture f = new Fixture(date, s, home, away, result, odd);
			f.setH2H(fixtureDAO.getH2H(f.getHomeTeam().getId(), f.getAwayTeam()
					.getId(), f.getDate(),10));
			f.setH2HVenue(fixtureDAO.getH2HVenue(f.getHomeTeam().getId(), f.getAwayTeam()
					.getId(), f.getDate(),10));
			f.setH2hSwitchedVenue(fixtureDAO.getH2HSwitchedVenue(f.getHomeTeam().getId(), f.getAwayTeam()
					.getId(), f.getDate(),10));
			//f.setAnnOdd(calculateAnnOdds(f));
			fixtureDAO.insert(f);
		}

		return fixtureDAO.findFixture(date, s.getId(), home.getId(),
				away.getId());
	}

	public Fixture getTeamFixtureBeforeDate(Team t, Season s, Date date) {
		return fixtureDAO.findFixtureBeforeDate(date, s.getId(), t.getId());
	}

	public List<Fixture> getTeamBeforeFixtures(Team t, Season s, Date date,
			Venue venue, Integer numberOfFixtures) {
		return fixtureDAO.findFixturesBeforeDate(date, s.getId(), t.getId(),
				venue, numberOfFixtures);
	}
	
	public Odd calculateAnnOdds(Fixture f)
	{
		Triplet<float[][], float[][], float[][]> annTriplet = getANNOdds(f);
		
		if(annTriplet==null)
			return null;
		
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

		double backANNOdds[] = { annWinOdd[0], annDrawOdd[0], annLoseOdd[0] };
		double layANNOdds[] = { 1 - backANNOdds[0], 1 - backANNOdds[1],
				1 - backANNOdds[2] };
		Odd ANNOdds = new Odd(backANNOdds[0], backANNOdds[1],
				backANNOdds[2], layANNOdds[0], layANNOdds[1], layANNOdds[2]);

		return ANNOdds;
	}
	
	private Triplet<float[][], float[][], float[][]> getANNOdds(Fixture f) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy");

		if (f.getDate().before(
				formatter.parseDateTime("23/11/" + (f.getSeason().getYear() + 2000))
						.toDate()))
			return null;
		
		Triplet<List<ExcelRow>, List<ExcelRow>, List<ExcelRow>> triplet = generateExcelFiles_PlanA(
				f.getSeason(), null, f.getDate());
		
		if(triplet.getA() == null || triplet.getA().isEmpty())
		{
			return null;
		}

		float[][] inWin = calculateDataset(triplet.getA());
		float[][] inDraw = calculateDataset(triplet.getB());
		float[][] inLose = calculateDataset(triplet.getC());

		float[] taWin = calculateTarget(triplet.getA());
		float[] taDraw = calculateTarget(triplet.getB());
		float[] taLose = calculateTarget(triplet.getC());

		Triplet<List<ExcelRow>, List<ExcelRow>, List<ExcelRow>> teTriplet = generateExcelFiles_PlanAForFixture(f);

		float[][] teWin = calculateDataset(teTriplet.getA());
		float[][] teDraw = calculateDataset(teTriplet.getB());
		float[][] teLose = calculateDataset(teTriplet.getC());

		float[][] oddWin = testMLPSigmoidBP(inWin, teWin, taWin);
		float[][] oddDraw = testMLPSigmoidBP(inDraw, teDraw, taDraw);
		float[][] oddLose = testMLPSigmoidBP(inLose, teLose, taLose);

		return new Triplet<float[][], float[][], float[][]>(oddWin, oddDraw,
				oddLose);
	}

	private float[][] calculateDataset(List<ExcelRow> data) {
		float[][] in = new float[data.size()][6];
		for (int i = 0; i < data.size(); i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(data.get(i).getData());
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);

			in[i][0] = year;
			in[i][1] = month;
			in[i][2] = data.get(i).getQLT_percentagemResultadoVisitadoVenue()
					.floatValue();
			in[i][3] = data.get(i).getQLT_percentagemResultadoVisitanteVenue()
					.floatValue();
			in[i][4] = data.get(i).getQLT_percentagemResultadoVisitadoVenue()
					.floatValue();
			in[i][5] = data.get(i)
					.getQLT_percentagemResultadoVisitanteSwitchedVenue()
					.floatValue();
		}

		return in;
	}
	
	private float[][] testMLPSigmoidBP(float[][] input, float[][] test,
			float[] target) {
		
		// execution mode
		Environment.getInstance().setExecutionMode(EXECUTION_MODE.SEQ);
		Environment.getInstance().setUseDataSharedMemory(false);
		Environment.getInstance().setUseWeightsSharedMemory(false);

		float[][] results = new float[5][];
		for (int i = 0; i < 5; i++) {
			// create the network
			NeuralNetworkImpl mlp = NNFactory.mlpSigmoid(new int[] { 4,
					4 * 2 + 2, 1 }, true);

			// training and testing data providers
			BetInputProvider trainInputProvider = new BetInputProvider(input,
					target);
			BetInputProvider testInputProvider = new BetInputProvider(test,
					target);

			OutputError outputError = new MultipleNeuronsOutputError();

			// trainer
			BackPropagationTrainer<?> bpt = TrainerFactory
					.backPropagation(mlp, trainInputProvider,
							testInputProvider, outputError,
							new NNRandomInitializer(
									new MersenneTwisterRandomInitializer(
											-0.01f, 0.01f), 0.5f), 0.02f, 0.7f,
							0f, 0f, 0f, 150, 1, 2000);

			OutputListener ltt = new OutputListener();

			// log data
			bpt.addEventListener(ltt);

			// early stopping
			bpt.addEventListener(new EarlyStoppingListener(testInputProvider,
					100, 0.015f));

			// train
			bpt.train();

			// test
			bpt.test();

			results[i] = ltt.getOutput();
		}
		return results;
	}

	private float[] calculateTarget(List<ExcelRow> data) {
		float[] ta = new float[data.size()];
		for (int i = 0; i < data.size(); i++) {
			ta[i] = data.get(i).getResultado();
		}

		return ta;
	}

	private float[][] normalize(float[][] data) {
		float[][] dataReturn = new float[data.length][data[0].length];
		for (int i = 0; i < data.length; i++) {
			float[] row = data[i];
			for (int j = 0; j < row.length; j++) {
				dataReturn[i][j] = (data[i][j] - getColumnMin(data, j))
						/ (getColumnMax(data, j) - getColumnMin(data, j));
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

	private Triplet<float[], float[], float[]> getANNFinalOdds(
			float[] annWinAverage, float[] annDrawAverage,
			float[] annLoseAverage) {
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

		return new Triplet<float[], float[], float[]>(finalAnnWinAverage,
				finalAnnDrawAverage, finalAnnLoseAverage);
	}

	private float getColumnMin(float[][] data, int column) {
		float value = data[0][column];
		for (int row = 1; row < data.length; row++) {
			if (value > data[row][column])
				value = data[row][column];
		}

		return value;
	}

	private float getColumnMax(float[][] data, int column) {
		float value = data[0][column];
		for (int row = 1; row < data.length; row++) {
			if (value < data[row][column])
				value = data[row][column];
		}

		return value;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Triplet<List<ExcelRow>, List<ExcelRow>, List<ExcelRow>> generateExcelFiles_PlanA(
			Season s, Date beginDate, Date limitDate) {

		List<ExcelRow> OurWinDataList = new ArrayList<ExcelRow>();
		List<ExcelRow> OurDrawDataList = new ArrayList<ExcelRow>();
		List<ExcelRow> OurLoseDataList = new ArrayList<ExcelRow>();

		List<String> historicos = new ArrayList<String>();
		historicos.add("Benfica");
		historicos.add("Porto");
		historicos.add("Sp Lisbon");

		List<Double> ratings = new ArrayList<Double>();
		ratings.add(0.3);
		ratings.add(0.25);
		ratings.add(0.2);
		ratings.add(0.15);
		ratings.add(0.1);

		List<Double> ratingsH2H = new ArrayList<Double>();
		ratingsH2H.add(0.2);
		ratingsH2H.add(0.19);
		ratingsH2H.add(0.17);
		ratingsH2H.add(0.14);
		ratingsH2H.add(0.1);
		ratingsH2H.add(0.06);
		ratingsH2H.add(0.05);
		ratingsH2H.add(0.04);
		ratingsH2H.add(0.03);
		ratingsH2H.add(0.02);
		ratingsH2H.add(0.01);

		double interval = 0.15;

		int numberOfFixtures = 5;

		List<Fixture> fixtureList;

		if (beginDate == null && limitDate == null) {
			fixtureList = s.getFixtures();
		} else {
			FixtureDAO fixtureDAO = new FixtureDAO(em);
			fixtureList = fixtureDAO.findCountryFixturesBetweenDates(s.getName(),
					beginDate, limitDate);
		}

		for (Fixture f : fixtureList) {
			DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy");

			if (f.getDate().before(
					formatter.parseDateTime("23/11/" + (s.getYear() + 2000))
							.toDate()))
				continue;

			List<ExcelRow> rowList = new ArrayList<ExcelRow>();

			ExcelRow winRow = new ExcelRow();
			ExcelRow drawRow = new ExcelRow();
			ExcelRow loseRow = new ExcelRow();

			ExcelColumnsCalculation homeTeam = new ExcelColumnsCalculation(
					f.getHomeTeam(), em);
			ExcelColumnsCalculation awayTeam = new ExcelColumnsCalculation(
					f.getAwayTeam(), em);

			rowList = Main.calculateGeneralVariables(f, s, homeTeam, awayTeam,
					winRow, drawRow, loseRow);
			winRow = rowList.get(0);
			drawRow = rowList.get(1);
			loseRow = rowList.get(2);
			rowList = Main.calculateCycleVariables(f, homeTeam, awayTeam,
					historicos, ratings, winRow, drawRow, loseRow);
			winRow = rowList.get(0);
			drawRow = rowList.get(1);
			loseRow = rowList.get(2);
			rowList = Main.calculateFRVariables(f, homeTeam, awayTeam, ratings,
					historicos, winRow, drawRow, loseRow, numberOfFixtures,
					interval);
			winRow = rowList.get(0);
			drawRow = rowList.get(1);
			loseRow = rowList.get(2);
			rowList = Main.calculateQLTVariables(f, homeTeam, awayTeam,
					interval, winRow, drawRow, loseRow);
			winRow = rowList.get(0);
			drawRow = rowList.get(1);
			loseRow = rowList.get(2);
			rowList = Main.calculateH2HVariables(f, ratingsH2H, homeTeam,
					awayTeam, winRow, drawRow, loseRow);
			winRow = rowList.get(0);
			drawRow = rowList.get(1);
			loseRow = rowList.get(2);

			OurWinDataList.add(winRow);
			OurDrawDataList.add(drawRow);
			OurLoseDataList.add(loseRow);

		}

		return new Triplet(OurWinDataList, OurDrawDataList, OurLoseDataList);
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Triplet<List<ExcelRow>, List<ExcelRow>, List<ExcelRow>> generateExcelFiles_PlanAForFixture(Fixture f) {

		List<ExcelRow> OurWinDataList = new ArrayList<ExcelRow>();
		List<ExcelRow> OurDrawDataList = new ArrayList<ExcelRow>();
		List<ExcelRow> OurLoseDataList = new ArrayList<ExcelRow>();

		List<String> historicos = new ArrayList<String>();
		historicos.add("Benfica");
		historicos.add("Porto");
		historicos.add("Sp Lisbon");

		List<Double> ratings = new ArrayList<Double>();
		ratings.add(0.3);
		ratings.add(0.25);
		ratings.add(0.2);
		ratings.add(0.15);
		ratings.add(0.1);

		List<Double> ratingsH2H = new ArrayList<Double>();
		ratingsH2H.add(0.2);
		ratingsH2H.add(0.19);
		ratingsH2H.add(0.17);
		ratingsH2H.add(0.14);
		ratingsH2H.add(0.1);
		ratingsH2H.add(0.06);
		ratingsH2H.add(0.05);
		ratingsH2H.add(0.04);
		ratingsH2H.add(0.03);
		ratingsH2H.add(0.02);
		ratingsH2H.add(0.01);

		double interval = 0.15;

		int numberOfFixtures = 5;

		List<ExcelRow> rowList = new ArrayList<ExcelRow>();

		ExcelRow winRow = new ExcelRow();
		ExcelRow drawRow = new ExcelRow();
		ExcelRow loseRow = new ExcelRow();

		ExcelColumnsCalculation homeTeam = new ExcelColumnsCalculation(
				f.getHomeTeam(), em);
		ExcelColumnsCalculation awayTeam = new ExcelColumnsCalculation(
				f.getAwayTeam(), em);

		rowList = Main.calculateGeneralVariables(f, f.getSeason(), homeTeam, awayTeam,
				winRow, drawRow, loseRow);
		winRow = rowList.get(0);
		drawRow = rowList.get(1);
		loseRow = rowList.get(2);
		rowList = Main.calculateCycleVariables(f, homeTeam, awayTeam,
				historicos, ratings, winRow, drawRow, loseRow);
		winRow = rowList.get(0);
		drawRow = rowList.get(1);
		loseRow = rowList.get(2);
		rowList = Main.calculateFRVariables(f, homeTeam, awayTeam, ratings,
				historicos, winRow, drawRow, loseRow, numberOfFixtures,
				interval);
		winRow = rowList.get(0);
		drawRow = rowList.get(1);
		loseRow = rowList.get(2);
		rowList = Main.calculateQLTVariables(f, homeTeam, awayTeam,
				interval, winRow, drawRow, loseRow);
		winRow = rowList.get(0);
		drawRow = rowList.get(1);
		loseRow = rowList.get(2);
		rowList = Main.calculateH2HVariables(f, ratingsH2H, homeTeam,
				awayTeam, winRow, drawRow, loseRow);
		winRow = rowList.get(0);
		drawRow = rowList.get(1);
		loseRow = rowList.get(2);

		OurWinDataList.add(winRow);
		OurDrawDataList.add(drawRow);
		OurLoseDataList.add(loseRow);

		return new Triplet(OurWinDataList, OurDrawDataList, OurLoseDataList);
	}
	
}

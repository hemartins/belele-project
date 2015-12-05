package pt.belele.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import pt.belele.project.algorithm.Algorithm;
import pt.belele.project.algorithm.ExcelColumnsCalculation;
import pt.belele.project.algorithm.ExcelRow;
import pt.belele.project.ann.BetInputProvider;
import pt.belele.project.ann.LogTrainingListener;
import pt.belele.project.controllers.SeasonController;
import pt.belele.project.entities.Bet;
import pt.belele.project.entities.CutOff;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.MultipleBet;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Week;
import pt.belele.project.persistence.FixtureDAO;
import pt.belele.project.util.MultipleMaximFunction;
import pt.belele.project.util.SimpleMaximFunction;
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

import flanagan.math.Maximisation;

public class Main2 {

	private static final Logger LOG = LogManager.getLogger(Main2.class);

	public static void main(String[] args) {
		simpleBets(1.0);
		multipleBets(1.0);
	}

	private static void simpleBets(Double investedValue) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("database.odb");
		EntityManager em = emf.createEntityManager();

		Week week = new Week();

		FixtureDAO fixtureDAO = new FixtureDAO(em);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);
		cal.set(Calendar.DAY_OF_MONTH, 4);
		cal.set(Calendar.MONTH, 12);

		Date begin = cal.getTime();
		cal.set(Calendar.DAY_OF_MONTH, 8);
		Date end = cal.getTime();

		week.setWeekNumber(cal.getWeeksInWeekYear());

		SeasonController sc = new SeasonController(em);
		Season s = sc.createSeason("I1", 14);

		List<Fixture> oldFixtures = fixtureDAO.findFixturesBetweenDates(
				s.getId(), null, begin);

		// Create instance of Maximisation
		Maximisation max = new Maximisation();

		// Create instace of class holding function to be maximised
		SimpleMaximFunction funct = new SimpleMaximFunction();

		funct.setWeek(week);

		funct.setFixtures(oldFixtures);

		funct.setInvestedValue(investedValue);

		// initial estimates
		double[] start = { 1, 1, 1, 1.5, 1.5, 0.5, 0.5 };

		// initial step sizes
		double[] step = { 2, 2, 2, 0.5, 0.5, 0.5, 0.5 };

		// convergence tolerance
		double ftol = 1e-15;

		// Nelder and Mead maximisation procedure
		LOG.info("Start of Nelder and Mead maximisation procedure");
		max.addConstraint(0, 1, start[1]);
		max.addConstraint(1, 1, start[2]);
		max.nelderMead(funct, start, step, ftol, 50000);
		LOG.info("End of Nelder and Mead maximisation procedure");

		// get the maximum value
		double maximum = max.getMaximum();

		// get values of y and z at maximum
		double[] param = max.getParamValues();

		// Print results to a text file
		max.print("MaximExampleOutput.txt");

		// Output the results to screen
		LOG.info("Maximum = " + maximum);
		LOG.info("oddWightHigherValue = " + param[0]);
		LOG.info("oddWightMediumValue = " + param[1]);
		LOG.info("oddWightLowerValue = " + param[2]);
		LOG.info("minimumLayOdd = " + param[3]);
		LOG.info("minimumBackOdd = " + param[4]);
		LOG.info("nnOddWeight = " + param[5]);
		LOG.info("minimumQualityRelation = " + param[6]);

		CutOff cutOffSimple = new CutOff(param[0], param[1], param[2],
				param[3], param[4], param[5], param[6]);

		Triplet<float[][], float[][], float[][]> annTriplet = getANNOdds(s, em,
				begin, end);
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

		List<Fixture> fixtures = fixtureDAO.findFixturesBetweenDates(s.getId(),
				begin, end);

		LOG.info("Number of Fixtures: " + fixtures.size());
		for (int i = 0; i < fixtures.size(); i++) {
			Fixture f = fixtures.get(i);
			double backANNOdds[] = { annWinOdd[i], annDrawOdd[i], annLoseOdd[i] };
			double layANNOdds[] = { 1 - backANNOdds[0], 1 - backANNOdds[1],
					1 - backANNOdds[2] };
			Odd ANNOdds = new Odd(backANNOdds[0], backANNOdds[1],
					backANNOdds[2], layANNOdds[0], layANNOdds[1], layANNOdds[2]);

			f.setAnnOdd(ANNOdds);
			fixtureDAO.update(f);
		}

		List<Bet> bets = new Algorithm().simpleBetAlgorithm(week, fixtures,
				cutOffSimple, investedValue);

		double investido = 0;
		for (Bet bet : bets) {
			investido += bet.getInvestedValue();
			LOG.info("BET:\n" + bet.toString() + "\n\n");
		}

		LOG.info("Investido: " + investido);
		LOG.info("Lucro: " + maximum);
	}

	private static void multipleBets(Double investedValue) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("database.odb");
		EntityManager em = emf.createEntityManager();

		Week week = new Week();

		FixtureDAO fixtureDAO = new FixtureDAO(em);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of
											// day !
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		cal.set(Calendar.WEEK_OF_YEAR, 4);

		Date begin = cal.getTime();
		cal.set(Calendar.WEEK_OF_YEAR, 5);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Date end = cal.getTime();

		week.setWeekNumber(cal.getWeeksInWeekYear());

		SeasonController sc = new SeasonController(em);
		Season s = sc.createSeason("I1", 14);

		List<Fixture> fixtures = fixtureDAO.findFixturesBetweenDates(s.getId(),
				begin, end);
		LOG.info("Number of Fixtures: " + fixtures.size());

		// CONSTRUIR EXCEL E IR BUSCAR AS ODDS DO PERNA
		Map<Fixture, Odd> fixtureMap = new HashMap<Fixture, Odd>();

		for (Fixture f : fixtures) {
			double backANNOdds[] = { 0.2, 0.7, 0.1 };
			double layANNOdds[] = { 0.6, 0.1, 0.3 };
			Odd ANNOdds = new Odd(backANNOdds[0], backANNOdds[1],
					backANNOdds[2], layANNOdds[0], layANNOdds[1], layANNOdds[2]);

			fixtureMap.put(f, ANNOdds);
		}

		// Create instance of Maximisation
		Maximisation max = new Maximisation();

		// Create instace of class holding function to be maximised
		MultipleMaximFunction funct = new MultipleMaximFunction();

		funct.setWeek(week);

		funct.setFixtures(fixtureMap);

		funct.setInvestedValue(investedValue);

		// initial estimates
		double[] start = { 1, 1, 1, 1.5, 1.5, 1.5, 5, 1, 1, 1, 1.5, 1.5, 1.5,
				5, 1, 1, 1, 1.5, 1.5, 1.5, 5 };

		// initial step sizes
		double[] step = { 2, 2, 2, 0.5, 0.5, 1.5, 5, 2, 2, 2, 0.5, 0.5, 1.5, 5,
				2, 2, 2, 0.5, 0.5, 1.5, 5 };

		// convergence tolerance
		double ftol = 1e-15;

		// Nelder and Mead maximisation procedure
		LOG.info("Start of Nelder and Mead maximisation procedure");
		max.addConstraint(0, 1, start[1]);
		max.addConstraint(1, 1, start[2]);
		max.addConstraint(7, 1, start[8]);
		max.addConstraint(8, 1, start[9]);
		max.addConstraint(14, 1, start[15]);
		max.addConstraint(15, 1, start[16]);
		max.nelderMead(funct, start, step, ftol, 50000);
		LOG.info("End of Nelder and Mead maximisation procedure");

		// get the maximum value
		double maximum = max.getMaximum();

		// get values of y and z at maximum
		double[] param = max.getParamValues();

		// Print results to a text file
		max.print("MaximExampleOutput.txt");

		// Output the results to screen
		LOG.info("Maximum = " + maximum);

		LOG.info("\n\nCUTOFF DOUBLE\n\n");
		LOG.info("oddWightHigherValue = " + param[0]);
		LOG.info("oddWightMediumValue = " + param[1]);
		LOG.info("oddWightLowerValue = " + param[2]);
		LOG.info("minimumLayOdd = " + param[3]);
		LOG.info("minimumBackOdd = " + param[4]);
		LOG.info("nnOddWeight = " + param[5]);
		LOG.info("minimumQualityRelation = " + param[6]);

		LOG.info("\n\nCUTOFF TRIPLE\n\n");
		LOG.info("oddWightHigherValue = " + param[7]);
		LOG.info("oddWightMediumValue = " + param[8]);
		LOG.info("oddWightLowerValue = " + param[9]);
		LOG.info("minimumLayOdd = " + param[10]);
		LOG.info("minimumBackOdd = " + param[11]);
		LOG.info("nnOddWeight = " + param[12]);
		LOG.info("minimumQualityRelation = " + param[13]);

		LOG.info("\n\nCUTOFF MULTIPLE\n\n");
		LOG.info("oddWightHigherValue = " + param[14]);
		LOG.info("oddWightMediumValue = " + param[15]);
		LOG.info("oddWightLowerValue = " + param[16]);
		LOG.info("minimumLayOdd = " + param[17]);
		LOG.info("minimumBackOdd = " + param[18]);
		LOG.info("nnOddWeight = " + param[19]);
		LOG.info("minimumQualityRelation = " + param[20]);

		CutOff cutOffDouble = new CutOff(param[0], param[1], param[2],
				param[3], param[4], param[5], param[6]);
		CutOff cutOffTriple = new CutOff(param[7], param[8], param[9],
				param[10], param[11], param[12], param[14]);
		CutOff cutOffMultiple = new CutOff(param[14], param[15], param[16],
				param[17], param[18], param[19], param[20]);

		List<MultipleBet> multipleBets = new Algorithm().multipleBetAlgorithm(
				week, fixtureMap, cutOffDouble, cutOffTriple, cutOffMultiple,
				investedValue);

		double investido = 0;
		for (MultipleBet multBet : multipleBets) {
			investido += multBet.getInvestedValue();
			LOG.info("MULTIPLEBET:\n" + multBet.toString() + "\n\n");
		}

		LOG.info("Investido: " + investido);
		LOG.info("Lucro: " + maximum);
	}

	private static float[][] testMLPSigmoidBP(float[][] input, float[][] test,
			float[] target) {
		// execution mode
		Environment.getInstance().setExecutionMode(EXECUTION_MODE.CPU);
		Environment.getInstance().setUseDataSharedMemory(true);
		Environment.getInstance().setUseWeightsSharedMemory(true);

		float[][] results = new float[10][];
		for (int i = 0; i < 10; i++) {
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

			LogTrainingListener ltt = new LogTrainingListener(Thread
					.currentThread().getStackTrace()[1].getMethodName(), true,
					true);

			// log data
			bpt.addEventListener(ltt);

			// early stopping
			bpt.addEventListener(new EarlyStoppingListener(testInputProvider,
					100, 0.015f));

			// train
			bpt.train();

			// test
			bpt.test();

			LOG.info("ANN OUTPUT:\n" + Arrays.toString(ltt.getOutput()));
			results[i] = ltt.getOutput();
		}

		LOG.info("ANN RESULTS:\n" + Arrays.deepToString(results));

		return results;
	}

	private static Triplet<float[][], float[][], float[][]> getANNOdds(
			Season s, EntityManager em, Date begin, Date end) {
		Triplet<List<ExcelRow>, List<ExcelRow>, List<ExcelRow>> triplet = generateExcelFiles_PlanA(
				s, em, null, begin);

		float[][] inWin = calculateDataset(triplet.getA());
		float[][] inDraw = calculateDataset(triplet.getB());
		float[][] inLose = calculateDataset(triplet.getC());

		float[] taWin = calculateTarget(triplet.getA());
		float[] taDraw = calculateTarget(triplet.getB());
		float[] taLose = calculateTarget(triplet.getC());

		Triplet<List<ExcelRow>, List<ExcelRow>, List<ExcelRow>> teTriplet = generateExcelFiles_PlanA(
				s, em, begin, end);

		float[][] teWin = calculateDataset(teTriplet.getA());
		float[][] teDraw = calculateDataset(teTriplet.getB());
		float[][] teLose = calculateDataset(teTriplet.getC());

		LOG.info("IN WIN:\n" + Arrays.deepToString(inWin));
		LOG.info("TA WIN:\n" + Arrays.toString(taWin));
		LOG.info("TE WIN:\n" + Arrays.deepToString(teWin));

		float[][] oddWin = testMLPSigmoidBP(inWin, teWin, taWin);
		LOG.info("ANN ODDS WIN:\n" + Arrays.deepToString(oddWin));

		LOG.info("IN DRAW:\n" + Arrays.deepToString(inDraw));
		LOG.info("TA DRAW:\n" + Arrays.toString(taDraw));
		LOG.info("TE DRAW:\n" + Arrays.deepToString(teDraw));

		float[][] oddDraw = testMLPSigmoidBP(inDraw, teDraw, taDraw);
		LOG.info("ANN ODDS DRAW:\n" + Arrays.deepToString(oddDraw));

		LOG.info("IN LOSE:\n" + Arrays.deepToString(inLose));
		LOG.info("TA LOSE:\n" + Arrays.toString(taLose));
		LOG.info("TE LOSE:\n" + Arrays.deepToString(teLose));

		float[][] oddLose = testMLPSigmoidBP(inLose, teLose, taLose);
		LOG.info("ANN ODDS LOSE:\n" + Arrays.deepToString(oddLose));

		return new Triplet<float[][], float[][], float[][]>(oddWin, oddDraw,
				oddLose);
	}

	private static float[][] calculateDataset(List<ExcelRow> data) {
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

	private static float[] calculateTarget(List<ExcelRow> data) {
		float[] ta = new float[data.size()];
		for (int i = 0; i < data.size(); i++) {
			ta[i] = data.get(i).getResultado();
		}

		return ta;
	}

	private static float[][] normalize(float[][] data) {
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

	private static float[] average(float[][] data) {
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

	private static Triplet<float[], float[], float[]> getANNFinalOdds(
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

	private static float getColumnMin(float[][] data, int column) {
		float value = data[0][column];
		for (int row = 1; row < data.length; row++) {
			if (value > data[row][column])
				value = data[row][column];
		}

		return value;
	}

	private static float getColumnMax(float[][] data, int column) {
		float value = data[0][column];
		for (int row = 1; row < data.length; row++) {
			if (value < data[row][column])
				value = data[row][column];
		}

		return value;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Triplet<List<ExcelRow>, List<ExcelRow>, List<ExcelRow>> generateExcelFiles_PlanA(
			Season s, EntityManager em, Date beginDate, Date limitDate) {

		LOG.info("BEGIN generateExcelFiles_PlanA BETWEEN " + beginDate
				+ " AND " + limitDate);

		List<ExcelRow> OurWinDataList = new ArrayList<ExcelRow>();
		List<ExcelRow> OurDrawDataList = new ArrayList<ExcelRow>();
		List<ExcelRow> OurLoseDataList = new ArrayList<ExcelRow>();

		List<String> historicos = new ArrayList<String>();
		historicos.add("Juventus");
		historicos.add("Roma");
		historicos.add("Milan");
		historicos.add("Inter");
		historicos.add("Napoli");

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
			fixtureList = fixtureDAO.findFixturesBetweenDates(s.getId(),
					beginDate, limitDate);
		}

		for (Fixture f : fixtureList) {

			LOG.trace(f.toString());

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

		LOG.info("END generateExcelFiles_PlanA BETWEEN " + beginDate + " AND "
				+ limitDate);

		return new Triplet(OurWinDataList, OurDrawDataList, OurLoseDataList);
	}
}

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
import com.github.neuralnetworks.calculation.LayerCalculatorImpl;
import com.github.neuralnetworks.calculation.OutputError;
import com.github.neuralnetworks.calculation.neuronfunctions.ConnectionCalculatorFullyConnected;
import com.github.neuralnetworks.input.MultipleNeuronsOutputError;
import com.github.neuralnetworks.training.TrainerFactory;
import com.github.neuralnetworks.training.backpropagation.BackPropagationTrainer;
import com.github.neuralnetworks.training.events.EarlyStoppingListener;
import com.github.neuralnetworks.training.events.LogTrainingListener;
import com.github.neuralnetworks.training.random.MersenneTwisterRandomInitializer;
import com.github.neuralnetworks.training.random.NNRandomInitializer;
import com.github.neuralnetworks.util.Environment;

import flanagan.math.Maximisation;

public class Main2 {

	private static final Logger LOG = LogManager.getLogger(Main2.class);

	public static void main(String[] args) {
		simpleBets(1.0);
		//multipleBets(1.0);
	}

	private static void simpleBets(Double investedValue) {
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
		cal.set(Calendar.WEEK_OF_YEAR, 5);

		Date begin = cal.getTime();
		cal.set(Calendar.WEEK_OF_YEAR, 6);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Date end = cal.getTime();

		week.setWeekNumber(cal.getWeeksInWeekYear());

		SeasonController sc = new SeasonController(em);
		Season s = sc.createSeason("I1", 14);

		List<Fixture> fixtures = fixtureDAO.findFixturesBetweenDates(s.getId(), begin,
				end);
		LOG.info("Number of Fixtures: " + fixtures.size());

		// CONSTRUIR EXCEL E IR BUSCAR AS ODDS DO PERNA
		Map<Fixture, Odd> fixtureMap = new HashMap<Fixture, Odd>();

		Triplet<List<ExcelRow>, List<ExcelRow>, List<ExcelRow>> triplet = generateExcelFiles_PlanA(
				s, em, null, begin);
		List<ExcelRow> winData = triplet.getA();
		List<ExcelRow> drawData = triplet.getB();
		List<ExcelRow> loseData = triplet.getC();

		float[] taWin = new float[winData.size()];
		float[][] inWin = new float[winData.size()][6];
		for (int i = 0; i < winData.size(); i++) {
			taWin[i] = winData.get(i).getResultado();

			cal = Calendar.getInstance();
			cal.setTime(winData.get(i).getData());
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);

			inWin[i][0] = year;
			inWin[i][1] = month;
			inWin[i][2] = winData.get(i).getQLT_percentagemResultadoVisitadoVenue().floatValue();
			inWin[i][3] = winData.get(i).getQLT_percentagemResultadoVisitanteVenue().floatValue();
			inWin[i][4] = winData.get(i).getQLT_percentagemResultadoVisitadoVenue().floatValue();
			inWin[i][5] = winData.get(i)
					.getQLT_percentagemResultadoVisitanteSwitchedVenue().floatValue();
		}

		Triplet<List<ExcelRow>, List<ExcelRow>, List<ExcelRow>> teTriplet = generateExcelFiles_PlanA(
				s, em, begin, end);
		List<ExcelRow> teWinData = teTriplet.getA();
		List<ExcelRow> teDrawData = teTriplet.getB();
		List<ExcelRow> teLoseData = teTriplet.getC();
		float[][] teWin = new float[teWinData.size()][6];
		for (int i = 0; i < teWinData.size(); i++) {
			cal = Calendar.getInstance();
			cal.setTime(winData.get(i).getData());
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			LOG.info("FIXTURE " + i + ": " + teWinData.get(i).getNomeVisitado() + " vs " + teWinData.get(i).getNomeVisitante());
			teWin[i][0] = year;
			teWin[i][1] = month;
			teWin[i][2] = teWinData.get(i)
					.getQLT_percentagemResultadoVisitadoVenue().floatValue();
			teWin[i][3] = teWinData.get(i)
					.getQLT_percentagemResultadoVisitanteVenue().floatValue();
			teWin[i][4] = teWinData.get(i)
					.getQLT_percentagemResultadoVisitadoVenue().floatValue();
			teWin[i][5] = teWinData.get(i)
					.getQLT_percentagemResultadoVisitanteSwitchedVenue().floatValue();
		}
		
		LOG.info("IN:\n"+Arrays.deepToString(inWin));
		LOG.info("TA:\n"+Arrays.toString(taWin));
		LOG.info("TE:\n"+Arrays.deepToString(teWin));

//		LOG.info("Start of MATLAB");
//		ANN ann = new ANN();
//		Object[] out = ann.nn_10(teWinData.size(), inWin, taWin, teWin);
//		LOG.info("END of MATLAB. OUT: \n" + out);

		LOG.info("Start of ANN");
		testMLPSigmoidBP(inWin, teWin, taWin);
		LOG.info("End of ANN");
		
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
		SimpleMaximFunction funct = new SimpleMaximFunction();

		funct.setWeek(week);

		funct.setFixtures(fixtureMap);

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

		List<Bet> bets = new Algorithm().simpleBetAlgorithm(week, fixtureMap,
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

		List<Fixture> fixtures = fixtureDAO.findFixturesBetweenDates(s.getId(), begin,
				end);
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
	
	private static void testMLPSigmoidBP(float[][] input, float[][] test, float[] target) {
		// execution mode
		Environment.getInstance().setExecutionMode(EXECUTION_MODE.CPU);
		Environment.getInstance().setUseDataSharedMemory(true);
		Environment.getInstance().setUseWeightsSharedMemory(true);
		
		float[][] results = new float[10][];
		for(int i = 0; i<10; i++)
		{
			// create the network
			NeuralNetworkImpl mlp = NNFactory.mlpSigmoid(new int[] { 4, 4*2+2, 1 }, true);
	
			// training and testing data providers
			BetInputProvider trainInputProvider = new BetInputProvider(input, target);
			BetInputProvider testInputProvider = new BetInputProvider(test, target);
			
			OutputError outputError = new MultipleNeuronsOutputError();
	
			// trainer
			BackPropagationTrainer<?> bpt = TrainerFactory.backPropagation(mlp, trainInputProvider, testInputProvider, outputError, new NNRandomInitializer(new MersenneTwisterRandomInitializer(-0.01f, 0.01f), 0.5f), 0.02f, 0.7f, 0f, 0f, 0f, 150, 1, 2000);
	
			LogTrainingListener ltt = new LogTrainingListener(Thread.currentThread().getStackTrace()[1].getMethodName(), true, true);
			
			// log data
			bpt.addEventListener(ltt);
	
			// early stopping
			bpt.addEventListener(new EarlyStoppingListener(testInputProvider, 100, 0.015f));
	
			// train
			bpt.train();
	
			// test
			bpt.test();
			
			LOG.info("ANN OUTPUT:\n"+Arrays.toString(ltt.getOutput()));
			results[i] = ltt.getOutput();
		}
		
		LOG.info("ANN RESULTS:\n"+Arrays.deepToString(results));
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

			rowList = Main.calculateGeneralVariables(f, s, homeTeam, awayTeam, winRow, drawRow, loseRow);
			winRow = rowList.get(0);
			drawRow = rowList.get(1);
			loseRow = rowList.get(2);
			rowList = Main.calculateCycleVariables(f, homeTeam, awayTeam, historicos, ratings, winRow, drawRow, loseRow);
			winRow = rowList.get(0);
			drawRow = rowList.get(1);
			loseRow = rowList.get(2);
			rowList = Main.calculateFRVariables(f, homeTeam, awayTeam, ratings, historicos, winRow, drawRow, loseRow,
					numberOfFixtures, interval);
			winRow = rowList.get(0);
			drawRow = rowList.get(1);
			loseRow = rowList.get(2);
			rowList = Main.calculateQLTVariables(f, homeTeam, awayTeam, interval, winRow, drawRow, loseRow);
			winRow = rowList.get(0);
			drawRow = rowList.get(1);
			loseRow = rowList.get(2);
			rowList = Main.calculateH2HVariables(f, ratingsH2H, homeTeam, awayTeam, winRow, drawRow, loseRow);
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

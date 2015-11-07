package pt.belele.project;

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

import pt.belele.project.algorithm.Algorithm;
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
import flanagan.math.Maximisation;

public class Main2 {
	
	private static final Logger LOG = LogManager.getLogger(Main2.class);

	public static void main(String[] args) {
		simpleBets(1.0);
		multipleBets(1.0);
	}
	
	private static void simpleBets(Double investedValue)
	{
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
		
		List<Fixture> fixtures = fixtureDAO.findWeekFixtures(s.getId(), begin, end);
		LOG.info("Number of Fixtures: " + fixtures.size());
		
		//CONSTRUIR EXCEL E IR BUSCAR AS ODDS DO PERNA
		Map<Fixture, Odd> fixtureMap = new HashMap<Fixture, Odd>();
		
		for(Fixture f: fixtures)
		{
			double backANNOdds[] = {0.2,0.7,0.1};
			double layANNOdds[] = {0.6,0.1,0.3};
			Odd ANNOdds = new Odd(backANNOdds[0], backANNOdds[1], backANNOdds[2], layANNOdds[0], layANNOdds[1], layANNOdds[2]);
			
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
		
		CutOff cutOffSimple = new CutOff(param[0], param[1], param[2], param[3], param[4], param[5], param[6]);
		
		List<Bet> bets = new Algorithm().simpleBetAlgorithm(week, fixtureMap, cutOffSimple, investedValue);
		
		double investido = 0;
		for(Bet bet : bets)
		{
			investido += bet.getInvestedValue();
			LOG.info("BET:\n" + bet.toString() +"\n\n");
		}
		
		LOG.info("Investido: " + investido);
		LOG.info("Lucro: " + maximum);
	}
	
	private static void multipleBets(Double investedValue)
	{
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
		
		List<Fixture> fixtures = fixtureDAO.findWeekFixtures(s.getId(), begin, end);
		LOG.info("Number of Fixtures: " + fixtures.size());
		
		//CONSTRUIR EXCEL E IR BUSCAR AS ODDS DO PERNA
		Map<Fixture, Odd> fixtureMap = new HashMap<Fixture, Odd>();
		
		for(Fixture f: fixtures)
		{
			double backANNOdds[] = {0.2,0.7,0.1};
			double layANNOdds[] = {0.6,0.1,0.3};
			Odd ANNOdds = new Odd(backANNOdds[0], backANNOdds[1], backANNOdds[2], layANNOdds[0], layANNOdds[1], layANNOdds[2]);
			
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
		double[] start = { 1, 1, 1, 1.5, 1.5, 1.5, 5, 1, 1, 1, 1.5, 1.5, 1.5, 5, 1, 1, 1, 1.5, 1.5, 1.5, 5 };

		// initial step sizes
		double[] step = { 2, 2, 2, 0.5, 0.5, 1.5, 5, 2, 2, 2, 0.5, 0.5, 1.5, 5, 2, 2, 2, 0.5, 0.5, 1.5, 5 };

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
		
		CutOff cutOffDouble = new CutOff(param[0], param[1], param[2], param[3], param[4], param[5], param[6]);
		CutOff cutOffTriple = new CutOff(param[7], param[8], param[9], param[10], param[11], param[12], param[14]);
		CutOff cutOffMultiple = new CutOff(param[14], param[15], param[16], param[17], param[18], param[19], param[20]);
		
		List<MultipleBet> multipleBets = new Algorithm().multipleBetAlgorithm(week, fixtureMap, cutOffDouble, cutOffTriple, cutOffMultiple, investedValue);
		
		double investido = 0;
		for(MultipleBet multBet : multipleBets)
		{
			investido += multBet.getInvestedValue();
			LOG.info("MULTIPLEBET:\n" + multBet.toString()+"\n\n");
		}
		
		LOG.info("Investido: " + investido);
		LOG.info("Lucro: " + maximum);
	}
}

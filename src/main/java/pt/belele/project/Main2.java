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

import pt.belele.project.controllers.SeasonController;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.PernaOdds;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Week;
import pt.belele.project.persistence.FixtureDAO;
import pt.belele.project.util.MaximFunction;
import flanagan.math.Maximisation;

public class Main2 {
	
	private static final Logger LOG = LogManager.getLogger(Main2.class);

	public static void main(String[] args) {
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
		Map<Fixture, PernaOdds> fixtureMap = new HashMap<Fixture, PernaOdds>();
		
		for(Fixture f: fixtures)
		{
			double oddsBackPerna[] = {0.2,0.7,0.1};
			double oddsLayPerna[] = {0.6,0.1,0.3};
			PernaOdds pernaOdds = new PernaOdds(oddsBackPerna[0], oddsBackPerna[1], oddsBackPerna[2], oddsLayPerna[0], oddsLayPerna[1], oddsLayPerna[2]);
			
			fixtureMap.put(f, pernaOdds);
		}
		
		// Create instance of Maximisation
		Maximisation max = new Maximisation();

		// Create instace of class holding function to be maximised
		MaximFunction funct = new MaximFunction();

		funct.setWeek(week);
		
		funct.setFixtures(fixtureMap);
		

		// initial estimates
		double[] start = { 1, 1, 1, 1.25, 1.25, 0.5, 0.5 };

		// initial step sizes
		double[] step = { 2, 2, 2, 0.25, 0.25, 0.5, 0.5 };

		// convergence tolerance
		double ftol = 1e-15;

		// Nelder and Mead maximisation procedure
		LOG.info("Start of Nelder and Mead maximisation procedure");
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
		

	}
}

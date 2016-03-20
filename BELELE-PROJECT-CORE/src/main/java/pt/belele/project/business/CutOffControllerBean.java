package pt.belele.project.business;

import flanagan.math.Maximisation;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pt.belele.project.business.cutoff.MultipleBetCutoffCalculator;
import pt.belele.project.business.cutoff.SimpleBetCutoffCalculator;
import pt.belele.project.business.util.CutOff;
import pt.belele.project.business.util.Triplet;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Odd;
import pt.belele.project.persistence.FixtureDAO;
import pt.belele.project.persistence.OddDAO;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CutOffControllerBean implements CutOffController {

    private static final Logger LOG = LogManager.getLogger(CutOffControllerBean.class);

    @EJB
    private OddController oddController;

    @EJB
    private OddDAO oddDAO;
    
    @EJB
    private FixtureDAO fixtureDAO;

    @Override
    public CutOff getSimpleCutoffForFixtures(List<Fixture> fixtures, Double investedValue, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception{
	for (Fixture f : fixtures) {
	    DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy");

	    if (f.getDate().isBefore(new DateTime(formatter.parseDateTime("23/11/" + (f.getSeason().getYear() + 2000))))) {
		continue;
	    }
	    
	    //DateTime beginOld = new DateTime(f.getDate()).minusYears(2);
	    DateTime beginOld = new DateTime(f.getDate()).minusMonths(2);
	    List<Fixture> oldFixtures = fixtureDAO.findCountryFixturesBetweenDates(f.getSeason().getName(), beginOld, f.getDate());

	    if (f.getAnnOdd() == null) {
		Odd odd = oddController.calculateAnnOddsForFixture(f, oldFixtures, winVariables, drawVariables, loseVariables);
		odd = oddDAO.insert(odd);
		f.setAnnOdd(odd);
	    }
	    fixtureDAO.update(f);
	}

	// Create instance of Maximisation
	Maximisation max = new Maximisation();

	// Create instace of class holding function to be maximised
	SimpleBetCutoffCalculator funct = new SimpleBetCutoffCalculator();

	funct.setFixtures(fixtures);
	funct.setInvestedValue(investedValue);

	// initial estimates
	double[] start = {1, 1, 1, 1.5, 1.5, 0.5, 0.5};

	// initial step sizes
	double[] step = {2, 2, 2, 0.5, 0.5, 0.5, 0.5};

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

	// Output the results to screen
	LOG.info("Maximum = " + maximum);
	LOG.info("oddWightHigherValue = " + param[0]);
	LOG.info("oddWightMediumValue = " + param[1]);
	LOG.info("oddWightLowerValue = " + param[2]);
	LOG.info("minimumLayOdd = " + param[3]);
	LOG.info("minimumBackOdd = " + param[4]);
	LOG.info("nnOddWeight = " + param[5]);
	LOG.info("minimumQualityRelation = " + param[6]);

	return new CutOff(param[0], param[1], param[2], param[3], param[4], param[5], param[6]);
    }
    
    @Override
    public Triplet<CutOff, CutOff, CutOff> getMultipleCutOffForFixtures(List<Fixture> fixtures, Double investedValue, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception
    {
	for (Fixture f : fixtures) {
	    DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy");

	    if (f.getDate().isBefore(new DateTime(formatter.parseDateTime("23/11/" + (f.getSeason().getYear() + 2000))))) {
		continue;
	    }

	    DateTime beginOld = new DateTime(f.getDate()).minusYears(2);
	    List<Fixture> oldFixtures = fixtureDAO.findCountryFixturesBetweenDates(f.getSeason().getName(), beginOld, f.getDate());

	    if (f.getAnnOdd() == null) {
		Odd odd = oddController.calculateAnnOddsForFixture(f, oldFixtures, winVariables, drawVariables, loseVariables);
		odd = oddDAO.insert(odd);
		f.setAnnOdd(odd);
	    }

	    fixtureDAO.update(f);
	}

	// Create instance of Maximisation
	Maximisation max = new Maximisation();

	// Create instace of class holding function to be maximised
	MultipleBetCutoffCalculator funct = new MultipleBetCutoffCalculator();

	funct.setFixtures(fixtures);

	funct.setInvestedValue(investedValue);

	// initial estimates
	double[] start = {1, 1, 1, 1.5, 1.5, 1.5, 5, 1, 1, 1, 1.5, 1.5, 1.5,
	    5, 1, 1, 1, 1.5, 1.5, 1.5, 5};

	// initial step sizes
	double[] step = {2, 2, 2, 0.5, 0.5, 1.5, 5, 2, 2, 2, 0.5, 0.5, 1.5, 5,
	    2, 2, 2, 0.5, 0.5, 1.5, 5};

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
	
	return new Triplet<>(cutOffDouble, cutOffTriple, cutOffMultiple);
    }
}

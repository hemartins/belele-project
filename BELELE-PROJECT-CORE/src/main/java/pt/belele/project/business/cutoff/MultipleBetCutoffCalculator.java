package pt.belele.project.business.cutoff;

import flanagan.math.MaximisationFunction;
import java.util.List;
import javax.naming.NamingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pt.belele.project.business.BetController;
import pt.belele.project.business.util.CutOff;
import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Bet.MatchOddBet;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.MultipleBet;
import pt.belele.project.util.BeanLocator;

public class MultipleBetCutoffCalculator implements MaximisationFunction {

    private static final Logger LOG = LogManager.getLogger(MultipleBetCutoffCalculator.class);

    private List<Fixture> fixtures;

    private Double investedValue;

    // evaluation function
    @Override
    public double function(double[] x) {
	CutOff cutOffDouble = new CutOff(x[0], x[1], x[2], x[3], x[4], x[5], x[6]);
	CutOff cutOffTriple = new CutOff(x[7], x[8], x[9], x[10], x[11], x[12], x[13]);
	CutOff cutOffMultiple = new CutOff(x[14], x[15], x[16], x[17], x[18], x[19], x[20]);

	BetController controller;

	try {
	    controller = BeanLocator.getBean("BetControllerBean/local");
	} catch (NamingException ex) {
	    LOG.error("Unable to locate BetControlelrBEAN");
	    return 0;
	}

	List<MultipleBet> multipleBets = controller.calculateMultipleBetForFixtures(fixtures, cutOffDouble, cutOffTriple, cutOffMultiple, investedValue);

	double lucro = 0;

	if (multipleBets == null || multipleBets.isEmpty()) {
	    return lucro;
	}

	for (MultipleBet multipleBet : multipleBets) {
	    LOG.trace(multipleBet.toString());
	    loop:
	    for (Bet bet : multipleBet.getBetsList()) {
		LOG.trace(bet.toString());
		Fixture f = bet.getFixture();
		LOG.trace(f.toString());
		switch (f.getResult().getResultType()) {
		    case WIN:
			if (!(bet.getMatchOddBet().equals(MatchOddBet.WIN)
				|| bet.getMatchOddBet().equals(MatchOddBet.DONOTDRAW)
				|| bet.getMatchOddBet().equals(MatchOddBet.DONOTLOSE))) {
			    lucro -= multipleBet.getInvestedValue();
			    break loop;
			}
			break;
		    case DRAW:
			if (!(bet.getMatchOddBet().equals(MatchOddBet.DRAW)
				|| bet.getMatchOddBet().equals(MatchOddBet.DONOTWIN)
				|| bet.getMatchOddBet().equals(MatchOddBet.DONOTLOSE))) {
			    lucro -= multipleBet.getInvestedValue();
			    break loop;
			}
			break;
		    case LOSE:
			if ((bet.getMatchOddBet().equals(MatchOddBet.LOSE)
				|| bet.getMatchOddBet().equals(MatchOddBet.DONOTDRAW)
				|| bet.getMatchOddBet().equals(MatchOddBet.DONOTWIN))) {
			    lucro -= multipleBet.getInvestedValue();
			    break loop;
			}
			break;
		    default:
			break;
		}
	    }
	    lucro += (multipleBet.getInvestedValue() * multipleBet.getOdd())
		    - multipleBet.getInvestedValue();
	    LOG.trace("Lucro: " + lucro);
	}

	return lucro;
    }

    public void setFixtures(List<Fixture> fixtures) {
	this.fixtures = fixtures;
    }

    public void setInvestedValue(Double investedValue) {
	this.investedValue = investedValue;
    }

}

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
import pt.belele.project.util.BeanLocator;

public class SimpleBetCutoffCalculator implements MaximisationFunction {

    private static final Logger LOG = LogManager.getLogger(SimpleBetCutoffCalculator.class);

    private List<Fixture> fixtures;

    private Double investedValue;

    // evaluation function
    @Override
    public double function(double[] x) {
	CutOff cutOffSimple = new CutOff(x[0], x[1], x[2], x[3], x[4], x[5], x[6]);

	BetController controller;
	
	try {
	    controller = BeanLocator.getBean("BetControllerBean/local");
	} catch (NamingException ex) {
	    LOG.error("Unable to locate BetControlelrBEAN", ex);
	    return 0;
	}
	
	List<Bet> bets = controller.calculateSimpleBetForFixtures(fixtures, cutOffSimple,
		investedValue);

	double lucro = 0;

	for (Bet bet : bets) {
	    LOG.trace(bet.toString());
	    Fixture f = bet.getFixture();
	    LOG.trace(f.toString());
	    switch (f.getResult().getResultType()) {
		case WIN:
		    if (bet.getMatchOddBet().equals(MatchOddBet.WIN)
			    || bet.getMatchOddBet().equals(MatchOddBet.DONOTDRAW)
			    || bet.getMatchOddBet().equals(MatchOddBet.DONOTLOSE)) {
			lucro += (bet.getInvestedValue() * bet.getOdd())
				- bet.getInvestedValue();
		    } else {
			lucro -= bet.getInvestedValue();
		    }
		    break;
		case DRAW:
		    if (bet.getMatchOddBet().equals(MatchOddBet.DRAW)
			    || bet.getMatchOddBet().equals(MatchOddBet.DONOTWIN)
			    || bet.getMatchOddBet().equals(MatchOddBet.DONOTLOSE)) {
			lucro += (bet.getInvestedValue() * bet.getOdd())
				- bet.getInvestedValue();
		    } else {
			lucro -= bet.getInvestedValue();
		    }
		    break;
		case LOSE:
		    if (bet.getMatchOddBet().equals(MatchOddBet.LOSE)
			    || bet.getMatchOddBet().equals(MatchOddBet.DONOTDRAW)
			    || bet.getMatchOddBet().equals(MatchOddBet.DONOTWIN)) {
			lucro += (bet.getInvestedValue() * bet.getOdd())
				- bet.getInvestedValue();
		    } else {
			lucro -= bet.getInvestedValue();
		    }
		    break;
		default:
		    break;
	    }

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

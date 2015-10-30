package pt.belele.project.util;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import flanagan.math.MaximisationFunction;
import pt.belele.project.algorithm.Algorithm;
import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Bet.MatchOddBet;
import pt.belele.project.entities.CutOff;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Week;

public class MaximFunction implements MaximisationFunction {

	private static final Logger LOG = LogManager.getLogger(MaximFunction.class);

	private Week week;

	private Map<Fixture, Odd> fixtures;

	// evaluation function
	public double function(double[] x) {
		CutOff cutOffSimple = new CutOff(x[0], x[1], x[2], x[3], x[4], x[5], x[6]);

		Algorithm alg = new Algorithm();
		List<Bet> bets = alg.simpleBetAlgorithm(week, fixtures, cutOffSimple);

		double lucro = 0;

		for (Bet bet : bets) {
			LOG.info(bet.toString());
			// APOSTAS SIMPLES
			// for (Fixture f : bet.getFixtures()) {
			Fixture f = bet.getFixture();
			LOG.info(f.toString());
			switch (f.getResult().getResultType()) {
			case WIN:
				if (bet.getMatchOddBet().equals(MatchOddBet.WIN) || bet.getMatchOddBet().equals(MatchOddBet.DONOTDRAW)
						|| bet.getMatchOddBet().equals(MatchOddBet.DONOTLOSE)) {
					lucro += (bet.getInvestedValue() * bet.getOdd()) - bet.getInvestedValue();
				} else {
					lucro -= bet.getInvestedValue();
				}
				break;
			case DRAW:
				if (bet.getMatchOddBet().equals(MatchOddBet.DRAW) || bet.getMatchOddBet().equals(MatchOddBet.DONOTWIN)
						|| bet.getMatchOddBet().equals(MatchOddBet.DONOTLOSE)) {
					lucro += (bet.getInvestedValue() * bet.getOdd()) - bet.getInvestedValue();
				} else {
					lucro -= bet.getInvestedValue();
				}
				break;
			case LOSE:
				if (bet.getMatchOddBet().equals(MatchOddBet.LOSE) || bet.getMatchOddBet().equals(MatchOddBet.DONOTDRAW)
						|| bet.getMatchOddBet().equals(MatchOddBet.DONOTWIN)) {
					lucro += (bet.getInvestedValue() * bet.getOdd()) - bet.getInvestedValue();
				} else {
					lucro -= bet.getInvestedValue();
				}
				break;
			default:
				break;
			}

			LOG.info("Lucro: " + lucro);
			// }
		}

		return lucro;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

	public void setFixtures(Map<Fixture, Odd> fixtures) {
		this.fixtures = fixtures;
	}
}

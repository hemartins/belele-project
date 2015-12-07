package pt.belele.project.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Bet.MatchOddBet;
import pt.belele.project.entities.CutOff;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.MultipleBet;
import pt.belele.project.entities.MultipleBet.BetType;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Week;
import pt.belele.project.util.Combination;
import pt.belele.project.util.Triplet;

public class Algorithm {

	private static final Logger LOG = LogManager.getLogger(Algorithm.class);

	public Algorithm() {
	}

	public List<Bet> simpleBetAlgorithm(Week w, List<Fixture> fixtures,
			CutOff cutOffSimple, Double investedValue) {

		List<Bet> bets = new ArrayList<Bet>();

		for (Fixture f : fixtures) {

			if(f.getAnnOdd() == null)
				continue;
			
			Double backHomeWin = f.getAnnOdd().getBackHomeWin();
			Double backDraw = f.getAnnOdd().getBackDraw();
			Double backAwayWin = f.getAnnOdd().getBackAwayWin();
			Double layHomeWin = f.getAnnOdd().getLayHomeWin();
			Double layDraw = f.getAnnOdd().getLayDraw();
			Double layAwayWin = f.getAnnOdd().getLayAwayWin();

			LOG.trace("###########\n" + f.toString() + "\n#####");

			if (cutOffSimple != null) {
				Odd simpleNNOdd = calculateNNOdds(f, cutOffSimple, backHomeWin,
						backDraw, backAwayWin, layHomeWin, layDraw, layAwayWin);
				Odd simpleProcessedOdd = calculateSimpleBetProcessedOdds(f,
						simpleNNOdd, cutOffSimple,
						atributeOddWeightCutOff(f, cutOffSimple));
				List<Bet> betD = betDecision(w, f, simpleProcessedOdd, cutOffSimple,
						investedValue);
				
				if(betD!=null)
					bets.addAll(betD);
			}
		}

		return bets;
	}

	public List<MultipleBet> multipleBetAlgorithm(Week w,
			List<Fixture> fixtures, CutOff cutOffDouble,
			CutOff cutOffTriple, CutOff cutOffMultiple, Double investedValue) {

		List<MultipleBet> multipleBets = new ArrayList<MultipleBet>();
		List<Bet> doubleBets = new ArrayList<Bet>();
		List<Bet> tripleBets = new ArrayList<Bet>();
		List<Bet> multipleBetList = new ArrayList<Bet>();

		for (Fixture f : fixtures) {

			if(f.getAnnOdd() == null)
				continue;
			
			Double backHomeWin = f.getAnnOdd().getBackHomeWin();
			Double backDraw = f.getAnnOdd().getBackDraw();
			Double backAwayWin = f.getAnnOdd().getBackAwayWin();
			Double layHomeWin = f.getAnnOdd().getLayHomeWin();
			Double layDraw = f.getAnnOdd().getLayDraw();
			Double layAwayWin = f.getAnnOdd().getLayAwayWin();

			LOG.trace("###########\n" + f.toString() + "\n#####");
			atributeOddWeightCutOff(f, cutOffDouble);

			if (cutOffDouble != null) {
				Odd doubleNNOdd = calculateNNOdds(f, cutOffDouble, backHomeWin,
						backDraw, backAwayWin, layHomeWin, layDraw, layAwayWin);
				Odd doubleProcessedOdd = calculateMultipleBetProcessedOdds(f,
						doubleNNOdd, cutOffDouble,
						atributeOddWeightCutOff(f, cutOffDouble));
				doubleBets.addAll(betDecision(w, f, doubleProcessedOdd,
						cutOffDouble, investedValue));
			}

			if (cutOffTriple != null) {
				Odd tripleNNOdd = calculateNNOdds(f, cutOffTriple, backHomeWin,
						backDraw, backAwayWin, layHomeWin, layDraw, layAwayWin);
				Odd tripleProcessedOdd = calculateMultipleBetProcessedOdds(f,
						tripleNNOdd, cutOffTriple,
						atributeOddWeightCutOff(f, cutOffTriple));
				tripleBets.addAll(betDecision(w, f, tripleProcessedOdd,
						cutOffTriple, investedValue));
			}

			if (cutOffMultiple != null) {
				Odd multipleNNOdd = calculateNNOdds(f, cutOffMultiple,
						backHomeWin, backDraw, backAwayWin, layHomeWin,
						layDraw, layAwayWin);
				Odd multipleProcessedOdd = calculateMultipleBetProcessedOdds(f,
						multipleNNOdd, cutOffMultiple,
						atributeOddWeightCutOff(f, cutOffMultiple));
				multipleBetList.addAll(betDecision(w, f, multipleProcessedOdd,
						cutOffMultiple, investedValue));
			}
		}

		Map<Bet, Bet> doubleBetsCombination = null;
		if (!doubleBets.isEmpty())
			doubleBetsCombination = Combination.doubleCombination(doubleBets);

		List<Triplet<Bet, Bet, Bet>> tripleBetsCombination = null;
		if (!tripleBets.isEmpty())
			tripleBetsCombination = Combination.tripleCombination(tripleBets);

		multipleBets = addMultipleBets(doubleBetsCombination,
				tripleBetsCombination, multipleBetList, investedValue);

		return multipleBets;
	}

	/****************/
	/* AUX METHODS */
	/****************/

	private List<Double> atributeOddWeightCutOff(Fixture fixture, CutOff cutOff) {
		List<Double> oddWeights = new ArrayList<Double>();

		double oddWeightWIN;

		double oddWeightDRAW;

		double oddWeightLOSE;

		Odd odd = fixture.getOdd();
		if (odd.getBackHomeWin() > odd.getBackAwayWin()
				&& odd.getBackHomeWin() > odd.getBackDraw()) {
			oddWeightWIN = cutOff.getOddWightHigherValue();
			if (odd.getBackDraw() > odd.getBackAwayWin()) {
				oddWeightDRAW = cutOff.getOddWightMediumValue();
				oddWeightLOSE = cutOff.getOddWightLowerValue();
			} else if (odd.getBackDraw() < odd.getBackAwayWin()) {
				oddWeightLOSE = cutOff.getOddWightMediumValue();
				oddWeightDRAW = cutOff.getOddWightLowerValue();
			} else {
				oddWeightLOSE = cutOff.getOddWightMediumValue();
				oddWeightDRAW = cutOff.getOddWightMediumValue();
			}
		} else if (odd.getBackDraw() > odd.getBackAwayWin()
				&& odd.getBackDraw() > odd.getBackHomeWin()) {
			oddWeightDRAW = cutOff.getOddWightHigherValue();
			if (odd.getBackHomeWin() > odd.getBackAwayWin()) {
				oddWeightWIN = cutOff.getOddWightMediumValue();
				oddWeightLOSE = cutOff.getOddWightLowerValue();
			} else if (odd.getBackHomeWin() < odd.getBackAwayWin()) {
				oddWeightLOSE = cutOff.getOddWightMediumValue();
				oddWeightWIN = cutOff.getOddWightLowerValue();
			} else {
				oddWeightWIN = cutOff.getOddWightMediumValue();
				oddWeightLOSE = cutOff.getOddWightMediumValue();
			}
		} else if (odd.getBackAwayWin() > odd.getBackHomeWin()
				&& odd.getBackAwayWin() > odd.getBackDraw()) {
			oddWeightLOSE = cutOff.getOddWightHigherValue();
			if (odd.getBackHomeWin() > odd.getBackDraw()) {
				oddWeightWIN = cutOff.getOddWightMediumValue();
				oddWeightDRAW = cutOff.getOddWightLowerValue();
			} else if (odd.getBackHomeWin() < odd.getBackDraw()) {
				oddWeightDRAW = cutOff.getOddWightMediumValue();
				oddWeightWIN = cutOff.getOddWightLowerValue();
			} else {
				oddWeightWIN = cutOff.getOddWightMediumValue();
				oddWeightDRAW = cutOff.getOddWightMediumValue();
			}
		} else if (odd.getBackHomeWin() == odd.getBackAwayWin()
				&& odd.getBackHomeWin() != odd.getBackDraw()) {
			if (odd.getBackHomeWin() > odd.getBackDraw()) {
				oddWeightWIN = cutOff.getOddWightHigherValue();
				oddWeightLOSE = cutOff.getOddWightHigherValue();
				oddWeightDRAW = cutOff.getOddWightMediumValue();
			} else {
				oddWeightDRAW = cutOff.getOddWightHigherValue();
				oddWeightWIN = cutOff.getOddWightMediumValue();
				oddWeightLOSE = cutOff.getOddWightMediumValue();
			}
		} else if (odd.getBackHomeWin() == odd.getBackDraw()
				&& odd.getBackHomeWin() != odd.getBackAwayWin()) {
			if (odd.getBackHomeWin() > odd.getBackAwayWin()) {
				oddWeightWIN = cutOff.getOddWightHigherValue();
				oddWeightDRAW = cutOff.getOddWightHigherValue();
				oddWeightLOSE = cutOff.getOddWightMediumValue();
			} else {
				oddWeightLOSE = cutOff.getOddWightHigherValue();
				oddWeightWIN = cutOff.getOddWightMediumValue();
				oddWeightDRAW = cutOff.getOddWightMediumValue();
			}
		} else if (odd.getBackAwayWin() == odd.getBackDraw()
				&& odd.getBackHomeWin() != odd.getBackAwayWin()) {
			if (odd.getBackAwayWin() > odd.getBackHomeWin()) {
				oddWeightLOSE = cutOff.getOddWightHigherValue();
				oddWeightDRAW = cutOff.getOddWightHigherValue();
				oddWeightWIN = cutOff.getOddWightMediumValue();
			} else {
				oddWeightWIN = cutOff.getOddWightHigherValue();
				oddWeightDRAW = cutOff.getOddWightMediumValue();
				oddWeightLOSE = cutOff.getOddWightMediumValue();
			}
		} else {
			oddWeightWIN = cutOff.getOddWightHigherValue();
			oddWeightDRAW = cutOff.getOddWightHigherValue();
			oddWeightLOSE = cutOff.getOddWightHigherValue();
		}

		LOG.trace("oddWeightWIN " + oddWeightWIN);
		LOG.trace("oddWeightDRAW " + oddWeightDRAW);
		LOG.trace("oddWeightLOSE " + oddWeightLOSE);

		oddWeights.add(oddWeightWIN);
		oddWeights.add(oddWeightDRAW);
		oddWeights.add(oddWeightLOSE);

		return oddWeights;
	}

	private Odd calculateNNOdds(Fixture f, CutOff cutOff,
			double neuralNetworkBackWIN, double neuralNetworkBackDRAW,
			double neuralNetworkBackLOSE, double neuralNetworkLayWIN,
			double neuralNetworkLayDRAW, double neuralNetworkLayLOSE) {

		Odd NNOdd = new Odd();

		if (f.getOdd().getBackHomeWin() < cutOff.getMinimumBackOdd()) {
			NNOdd.setBackHomeWin(0.0);
		} else {
			NNOdd.setBackHomeWin(neuralNetworkBackWIN);
		}
		if (f.getOdd().getBackDraw() < cutOff.getMinimumBackOdd()) {
			NNOdd.setBackDraw(0.0);
		} else {
			NNOdd.setBackDraw(neuralNetworkBackDRAW);
		}
		if (f.getOdd().getBackAwayWin() < cutOff.getMinimumBackOdd()) {
			NNOdd.setBackAwayWin(0.0);
		} else {
			NNOdd.setBackAwayWin(neuralNetworkBackLOSE);
		}
		if (f.getOdd().getLayHomeWin() < cutOff.getMinimumLayOdd()) {
			NNOdd.setLayHomeWin(0.0);
		} else {
			NNOdd.setLayHomeWin(neuralNetworkLayWIN);
		}
		if (f.getOdd().getLayDraw() < cutOff.getMinimumLayOdd()) {
			NNOdd.setLayDraw(0.0);
		} else {
			NNOdd.setLayDraw(neuralNetworkLayDRAW);
		}
		if (f.getOdd().getLayAwayWin() < cutOff.getMinimumLayOdd()) {
			NNOdd.setLayAwayWin(0.0);
		} else {
			NNOdd.setLayAwayWin(neuralNetworkLayLOSE);
		}

		// LOG.trace("backWinNeuralNetworkOdd " + backWinNeuralNetworkOdd);
		// LOG.trace("backDrawNeuralNetworkOdd " + backDrawNeuralNetworkOdd);
		// LOG.trace("backLoseNeuralNetworkOdd " + backLoseNeuralNetworkOdd);
		// LOG.trace("layWinNeuralNetworkOdd " + layWinNeuralNetworkOdd);
		// LOG.trace("layDrawNeuralNetworkOdd " + layDrawNeuralNetworkOdd);
		// LOG.trace("layLoseNeuralNetworkOdd " + layLoseNeuralNetworkOdd);

		return NNOdd;
	}

	private Odd calculateSimpleBetProcessedOdds(Fixture f, Odd NNOdd,
			CutOff cutOff, List<Double> oddWeights) {

		Odd processedOdds = new Odd();

		double oddWeightWIN = oddWeights.get(0);

		double oddWeightDRAW = oddWeights.get(1);

		double oddWeightLOSE = oddWeights.get(2);

		double backWinNeuralNetworkOdd = NNOdd.getBackHomeWin();

		double backDrawNeuralNetworkOdd = NNOdd.getBackDraw();

		double backLoseNeuralNetworkOdd = NNOdd.getBackAwayWin();

		double layWinNeuralNetworkOdd = NNOdd.getLayHomeWin();

		double layDrawNeuralNetworkOdd = NNOdd.getBackDraw();

		double layLoseNeuralNetworkOdd = NNOdd.getBackAwayWin();

		if (f.getOdd().getBackHomeWin() * backWinNeuralNetworkOdd == 0) {
			processedOdds.setBackHomeWin(0.0);
		} else {
			processedOdds.setBackHomeWin((oddWeightWIN
					* (f.getOdd().getBackHomeWin() - 1)
					+ f.getOdd().getBackHomeWin() - 1)
					* (f.getOdd().getBackHomeWin() * cutOff.getNnOddWeight()));
		}
		if (f.getOdd().getBackDraw() * backDrawNeuralNetworkOdd == 0) {
			processedOdds.setBackDraw(0.0);
		} else {
			processedOdds
					.setBackDraw((oddWeightDRAW
							* (f.getOdd().getBackDraw() - 1)
							+ f.getOdd().getBackDraw() - 1)
							* (f.getOdd().getBackDraw() * cutOff
									.getNnOddWeight()));
		}
		if (f.getOdd().getBackAwayWin() * backLoseNeuralNetworkOdd == 0) {
			processedOdds.setBackAwayWin(0.0);
		} else {
			processedOdds.setBackAwayWin((oddWeightLOSE
					* (f.getOdd().getBackAwayWin() - 1)
					+ f.getOdd().getBackAwayWin() - 1)
					* (f.getOdd().getBackAwayWin() * cutOff.getNnOddWeight()));
		}
		if (f.getOdd().getLayHomeWin() * layWinNeuralNetworkOdd == 0) {
			processedOdds.setLayHomeWin(0.0);
		} else {
			processedOdds.setLayHomeWin((oddWeightWIN
					* (f.getOdd().getLayHomeWin() - 1)
					+ f.getOdd().getLayHomeWin() - 1)
					* (f.getOdd().getLayHomeWin() * cutOff.getNnOddWeight()));
		}
		if (f.getOdd().getLayDraw() * layDrawNeuralNetworkOdd == 0) {
			processedOdds.setLayDraw(0.0);
		} else {
			processedOdds
					.setLayDraw((oddWeightDRAW * (f.getOdd().getLayDraw() - 1)
							+ f.getOdd().getLayDraw() - 1)
							* (f.getOdd().getLayDraw() * cutOff
									.getNnOddWeight()));
		}
		if (f.getOdd().getLayAwayWin() * layLoseNeuralNetworkOdd == 0) {
			processedOdds.setLayAwayWin(0.0);
		} else {
			processedOdds.setLayAwayWin((oddWeightLOSE
					* (f.getOdd().getLayAwayWin() - 1)
					+ f.getOdd().getLayAwayWin() - 1)
					* (f.getOdd().getLayAwayWin() * cutOff.getNnOddWeight()));
		}

		return processedOdds;
	}

	// not a void, object x
	private Odd calculateMultipleBetProcessedOdds(Fixture f, Odd NNOdd,
			CutOff cutOff, List<Double> oddWeights) {
		Odd processedOdds = new Odd();

		double oddWeightWIN = oddWeights.get(0);

		double oddWeightDRAW = oddWeights.get(1);

		double oddWeightLOSE = oddWeights.get(2);

		double backWinNeuralNetworkOdd = NNOdd.getBackHomeWin();

		double backDrawNeuralNetworkOdd = NNOdd.getBackDraw();

		double backLoseNeuralNetworkOdd = NNOdd.getBackAwayWin();

		double layWinNeuralNetworkOdd = NNOdd.getLayHomeWin();

		double layDrawNeuralNetworkOdd = NNOdd.getBackDraw();

		double layLoseNeuralNetworkOdd = NNOdd.getBackAwayWin();

		if (f.getOdd().getBackHomeWin() * backWinNeuralNetworkOdd == 0) {
			processedOdds.setBackHomeWin(0.0);
		} else {
			processedOdds.setBackHomeWin(oddWeightWIN
					* (f.getOdd().getBackHomeWin())
					+ f.getOdd().getBackHomeWin() * cutOff.getNnOddWeight());
		}
		if (f.getOdd().getBackDraw() * backDrawNeuralNetworkOdd == 0) {
			processedOdds.setBackDraw(0.0);
		} else {
			processedOdds.setBackDraw(oddWeightDRAW
					* (f.getOdd().getBackDraw()) + f.getOdd().getBackDraw()
					* cutOff.getNnOddWeight());
		}
		if (f.getOdd().getBackAwayWin() * backLoseNeuralNetworkOdd == 0) {
			processedOdds.setBackAwayWin(0.0);
		} else {
			processedOdds.setBackAwayWin(oddWeightLOSE
					* (f.getOdd().getBackAwayWin())
					+ f.getOdd().getBackAwayWin() * cutOff.getNnOddWeight());
		}
		if (f.getOdd().getLayHomeWin() * layWinNeuralNetworkOdd == 0) {
			processedOdds.setLayHomeWin(0.0);
		} else {
			processedOdds.setLayHomeWin(oddWeightWIN
					* (f.getOdd().getLayHomeWin()) + f.getOdd().getLayHomeWin()
					* cutOff.getNnOddWeight());
		}
		if (f.getOdd().getLayDraw() * layDrawNeuralNetworkOdd == 0) {
			processedOdds.setLayDraw(0.0);
		} else {
			processedOdds.setLayDraw(oddWeightWIN * (f.getOdd().getLayDraw())
					+ f.getOdd().getLayDraw() * cutOff.getNnOddWeight());
		}
		if (f.getOdd().getLayAwayWin() * layLoseNeuralNetworkOdd == 0) {
			processedOdds.setLayAwayWin(0.0);
		} else {
			processedOdds.setLayAwayWin(oddWeightWIN
					* (f.getOdd().getLayAwayWin()) + f.getOdd().getLayAwayWin()
					* cutOff.getNnOddWeight());
		}

		return processedOdds;
	}

	private List<Bet> betDecision(Week w, Fixture f, Odd processedOdds,
			CutOff cutOff, Double investedValue) {

		ArrayList<Double> processedOddsAsDoubles = new ArrayList<Double>();

		Double backWinProcessedOdd = processedOdds.getBackHomeWin();
		Double backDrawProcessedOdd = processedOdds.getBackDraw();
		Double backLoseProcessedOdd = processedOdds.getBackAwayWin();
		Double layWinProcessedOdd = processedOdds.getLayHomeWin();
		Double layDrawProcessedOdd = processedOdds.getLayDraw();
		Double layLoseProcessedOdd = processedOdds.getLayAwayWin();

		LOG.trace("backWinProcessedOdd " + backWinProcessedOdd);
		LOG.trace("backDrawProcessedOdd " + backDrawProcessedOdd);
		LOG.trace("backLoseProcessedOdd " + backLoseProcessedOdd);
		LOG.trace("layWinProcessedOdd " + layWinProcessedOdd);
		LOG.trace("layDrawProcessedOdd " + layDrawProcessedOdd);
		LOG.trace("layLoseProcessedOdd " + layLoseProcessedOdd);

		processedOddsAsDoubles.add(backWinProcessedOdd);
		processedOddsAsDoubles.add(backDrawProcessedOdd);
		processedOddsAsDoubles.add(backLoseProcessedOdd);
		processedOddsAsDoubles.add(layWinProcessedOdd);
		processedOddsAsDoubles.add(layDrawProcessedOdd);
		processedOddsAsDoubles.add(layLoseProcessedOdd);

		double maxValue = getMaxValue(processedOddsAsDoubles);

		LOG.trace(hasManyMax(processedOddsAsDoubles, maxValue));

		List<Bet> bets = new ArrayList<Bet>();

		if (backWinProcessedOdd + backDrawProcessedOdd + backLoseProcessedOdd
				+ layWinProcessedOdd + layDrawProcessedOdd
				+ layLoseProcessedOdd == 0
				|| hasManyMax(processedOddsAsDoubles, maxValue)) {

			LOG.trace("NULL");

			return null;
		} else if (backWinProcessedOdd == maxValue) {
			if (backWinProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getBackHomeWin());
				// bet.setBetType(BetType.SIMPLE);
				// List<Fixture> fixtures = new ArrayList<Fixture>();
				// fixtures.add(f);
				// bet.setFixtures(fixtures);
				bet.setFixture(f);
				bet.setMatchOddBet(MatchOddBet.WIN);
				bet.setWeek(w);
				bet.setInvestedValue(investedValue);
				bets.add(bet);
			}
		} else if (backDrawProcessedOdd == maxValue) {
			if (backDrawProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getBackDraw());
				// bet.setBetType(BetType.SIMPLE);
				// List<Fixture> fixtures = new ArrayList<Fixture>();
				// fixtures.add(f);
				// bet.setFixtures(fixtures);
				bet.setFixture(f);
				bet.setMatchOddBet(MatchOddBet.DRAW);
				bet.setWeek(w);
				bet.setInvestedValue(investedValue);
				bets.add(bet);
			}
		} else if (backLoseProcessedOdd == maxValue) {
			if (backLoseProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getBackAwayWin());
				// bet.setBetType(BetType.SIMPLE);
				// List<Fixture> fixtures = new ArrayList<Fixture>();
				// fixtures.add(f);
				// bet.setFixtures(fixtures);
				bet.setFixture(f);
				bet.setMatchOddBet(MatchOddBet.LOSE);
				bet.setWeek(w);
				bet.setInvestedValue(investedValue);
				bets.add(bet);
			}
		} else if (layWinProcessedOdd == maxValue) {
			if (layWinProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getLayHomeWin());
				// bet.setBetType(BetType.SIMPLE);
				// List<Fixture> fixtures = new ArrayList<Fixture>();
				// fixtures.add(f);
				// bet.setFixtures(fixtures);
				bet.setFixture(f);
				bet.setMatchOddBet(MatchOddBet.DONOTWIN);
				bet.setWeek(w);
				bet.setInvestedValue(investedValue);
				bets.add(bet);
			}
		} else if (layDrawProcessedOdd == maxValue) {
			if (layDrawProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getLayDraw());
				// bet.setBetType(BetType.SIMPLE);
				// List<Fixture> fixtures = new ArrayList<Fixture>();
				// fixtures.add(f);
				// bet.setFixtures(fixtures);
				bet.setFixture(f);
				bet.setMatchOddBet(MatchOddBet.DONOTDRAW);
				bet.setWeek(w);
				bet.setInvestedValue(investedValue);
				bets.add(bet);
			}
		} else if (layLoseProcessedOdd == maxValue) {
			if (layLoseProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getLayAwayWin());
				// bet.setBetType(BetType.SIMPLE);
				// List<Fixture> fixtures = new ArrayList<Fixture>();
				// fixtures.add(f);
				// bet.setFixtures(fixtures);
				bet.setFixture(f);
				bet.setMatchOddBet(MatchOddBet.DONOTLOSE);
				bet.setWeek(w);
				bet.setInvestedValue(investedValue);
				bets.add(bet);
			}
		}

		return bets;
	}

	public List<MultipleBet> addMultipleBets(
			Map<Bet, Bet> doubleBetsCombination,
			List<Triplet<Bet, Bet, Bet>> tripleBetsCombination,
			List<Bet> multipleBetList, Double investedValue) {

		if (multipleBetList == null || multipleBetList.isEmpty())
			return null;

		List<MultipleBet> bets = new ArrayList<MultipleBet>();

		// MULTIPLA
		MultipleBet bigMultipleBet = new MultipleBet();
		bigMultipleBet.setBetsList(multipleBetList);
		bigMultipleBet.setBetType(BetType.MULTIPLE);
		Double bigMultipleOdd = 0.0;
		for (Bet bet : multipleBetList) {
			bigMultipleOdd += bet.getOdd();
		}
		bigMultipleBet.setOdd(bigMultipleOdd);
		bigMultipleBet.setInvestedValue(investedValue);

		bets.add(bigMultipleBet);

		// DUPLAS
		if (doubleBetsCombination != null) {
			for (int i = 0; i < doubleBetsCombination.size(); i++) {
				MultipleBet multipleBet = new MultipleBet();
				multipleBet.setBetType(BetType.DOUBLE);
				multipleBet.setInvestedValue(investedValue);
				List<Bet> doubleBetList = new ArrayList<Bet>();
				for (Bet keyBet : doubleBetsCombination.keySet()) {
					Bet valueBet = doubleBetsCombination.get(keyBet);
					multipleBet.setOdd(keyBet.getOdd() * valueBet.getOdd());
					doubleBetList.add(keyBet);
					doubleBetList.add(valueBet);
				}
				multipleBet.setBetsList(doubleBetList);
				bets.add(multipleBet);
			}
		}

		// TRIPLAS
		if (tripleBetsCombination != null) {
			for (int i = 0; i < tripleBetsCombination.size(); i++) {
				MultipleBet multipleBet = new MultipleBet();
				multipleBet.setBetType(BetType.TRIPLE);
				multipleBet.setInvestedValue(investedValue);
				List<Bet> betsList = new ArrayList<Bet>();

				Triplet<Bet, Bet, Bet> triplet = tripleBetsCombination.get(i);
				Bet bet_1 = triplet.getA();
				Bet bet_2 = triplet.getB();
				Bet bet_3 = triplet.getC();
				betsList.add(bet_1);
				betsList.add(bet_2);
				betsList.add(bet_3);

				multipleBet.setBetsList(betsList);
				multipleBet.setOdd(bet_1.getOdd() * bet_2.getOdd()
						* bet_3.getOdd());

				bets.add(multipleBet);
			}
		}

		return bets;
	}

	private boolean hasManyMax(ArrayList<Double> list, Double max) {
		int count = 0;
		boolean hasManyMax = false;
		for (Double listUnit : list) {
			if (listUnit == max) {
				count++;
			}
			if (count > 1) {
				hasManyMax = true;
			}
		}
		return hasManyMax;
	}

	private double getMaxValue(ArrayList<Double> list) {
		int index = 0;
		Double max = 0.0;
		for (Double listUnit : list) {
			if (listUnit > list.get(index)) {
				max = listUnit;
			}
		}
		return max;
	}
}

package pt.belele.project.algorithm;

import java.util.ArrayList;
import java.util.List;

import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Bet.BetType;
import pt.belele.project.entities.Bet.MatchOddBet;
import pt.belele.project.entities.CutOff;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Week;

public class Algorithm {

	private double oddWeightWIN;

	private double oddWeightDRAW;

	private double oddWeightLOSE;

	private double backWinOdd;

	private double backDrawOdd;

	private double backLoseOdd;

	private double layWinOdd;

	private double layDrawOdd;

	private double layLoseOdd;

	private double backWinProcessedOdd;

	private double backDrawProcessedOdd;

	private double backLoseProcessedOdd;

	private double layWinProcessedOdd;

	private double layDrawProcessedOdd;

	private double layLoseProcessedOdd;

	private double backWinNeuralNetworkOdd;

	private double backDrawNeuralNetworkOdd;

	private double backLoseNeuralNetworkOdd;

	private double layWinNeuralNetworkOdd;

	private double layDrawNeuralNetworkOdd;

	private double layLoseNeuralNetworkOdd;

	public Algorithm() {
	}

	public List<Bet> runAlgorithm(Week w, List<Fixture> fixtures, CutOff cutOffSimple,
			CutOff cutOffDouble, CutOff cutOffTriple, CutOff cutOffMultiple,
			double neuralNetworkBackWIN, double neuralNetworkBackDRAW,
			double neuralNetworkBackLOSE, double neuralNetworkLayWIN,
			double neuralNetworkLayDRAW, double neuralNetworkLayLOSE) {
		
		List<Bet> bets = new ArrayList<Bet>();
		
		for(Fixture f : fixtures)
		{
			atributeOddWeightCutOff(f, cutOffSimple);
			calculateNNOdds(f, cutOffSimple, neuralNetworkBackWIN,
					neuralNetworkBackDRAW, neuralNetworkBackLOSE,
					neuralNetworkLayWIN, neuralNetworkLayDRAW, neuralNetworkLayLOSE);
			calculateSimpleBetProcessedOdds(cutOffSimple);
			bets.addAll(simpleBetDecision(w, f, cutOffSimple));
		}
		
		
		calculateMultipleBetProcessedOdds(cutOffDouble);
		doubleBetDecision(cutOffDouble);
		calculateMultipleBetProcessedOdds(cutOffTriple);
		tripleBetDecision(cutOffTriple);
		calculateMultipleBetProcessedOdds(cutOffMultiple);
		multipleBetDecision(cutOffMultiple);

		
		return bets;
	}

	/****************/
	/* AUX METHODS */
	/****************/

	private void atributeOddWeightCutOff(Fixture fixture, CutOff cutOff) {
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
	}

	private void calculateNNOdds(Fixture f, CutOff cutOff,
			double neuralNetworkBackWIN, double neuralNetworkBackDRAW,
			double neuralNetworkBackLOSE, double neuralNetworkLayWIN,
			double neuralNetworkLayDRAW, double neuralNetworkLayLOSE) {

		if (f.getOdd().getBackHomeWin() < cutOff.getMinimumBackOdd()) {
			backWinNeuralNetworkOdd = 0;
		} else {
			backWinNeuralNetworkOdd = neuralNetworkBackWIN;
		}
		if (f.getOdd().getBackDraw() < cutOff.getMinimumBackOdd()) {
			backDrawNeuralNetworkOdd = 0;
		} else {
			backDrawNeuralNetworkOdd = neuralNetworkBackDRAW;
		}
		if (f.getOdd().getBackAwayWin() < cutOff.getMinimumBackOdd()) {
			backLoseNeuralNetworkOdd = 0;
		} else {
			backLoseNeuralNetworkOdd = neuralNetworkBackLOSE;
		}
		if (f.getOdd().getLayHomeWin() < cutOff.getMinimumLayOdd()) {
			layWinNeuralNetworkOdd = 0;
		} else {
			layWinNeuralNetworkOdd = neuralNetworkLayWIN;
		}
		if (f.getOdd().getLayDraw() < cutOff.getMinimumLayOdd()) {
			layDrawNeuralNetworkOdd = 0;
		} else {
			layDrawNeuralNetworkOdd = neuralNetworkLayDRAW;
		}
		if (f.getOdd().getLayAwayWin() < cutOff.getMinimumLayOdd()) {
			layLoseNeuralNetworkOdd = 0;
		} else {
			layLoseNeuralNetworkOdd = neuralNetworkLayLOSE;
		}
	}

	private void calculateSimpleBetProcessedOdds(CutOff cutOff) {

		if (backWinOdd * backWinNeuralNetworkOdd == 0) {
			backWinProcessedOdd = 0;
		} else {
			backWinProcessedOdd = (oddWeightWIN * (backWinOdd - 1) + backWinOdd - 1)
					* (backWinOdd * cutOff.getNnOddWeight());
		}
		if (backDrawOdd * backDrawNeuralNetworkOdd == 0) {
			backDrawProcessedOdd = 0;
		} else {
			backDrawProcessedOdd = (oddWeightDRAW * (backDrawOdd - 1)
					+ backDrawOdd - 1)
					* (backDrawOdd * cutOff.getNnOddWeight());
		}
		if (backLoseOdd * backLoseNeuralNetworkOdd == 0) {
			backLoseProcessedOdd = 0;
		} else {
			backLoseProcessedOdd = (oddWeightLOSE * (backLoseOdd - 1)
					+ backLoseOdd - 1)
					* (backLoseOdd * cutOff.getNnOddWeight());
		}
		if (layWinOdd * layWinNeuralNetworkOdd == 0) {
			layWinProcessedOdd = (0);
		} else {
			layWinProcessedOdd = ((oddWeightWIN * (layWinOdd - 1) + layWinOdd - 1) * (layWinOdd * cutOff
					.getNnOddWeight()));
		}
		if (layDrawOdd * layDrawNeuralNetworkOdd == 0) {
			layDrawProcessedOdd = 0;
		} else {
			layDrawProcessedOdd = (oddWeightDRAW * (layDrawOdd - 1)
					+ layDrawOdd - 1)
					* (layDrawOdd * cutOff.getNnOddWeight());
		}
		if (layLoseOdd * layLoseNeuralNetworkOdd == 0) {
			layLoseProcessedOdd = 0;
		} else {
			layLoseProcessedOdd = (oddWeightLOSE * (layLoseOdd - 1)
					+ layLoseOdd - 1)
					* (layLoseOdd * cutOff.getNnOddWeight());
		}
	}

	private void calculateMultipleBetProcessedOdds(CutOff cutOff) {
		if (backWinOdd * backWinNeuralNetworkOdd == 0) {
			backWinProcessedOdd = 0;
		} else {
			backWinProcessedOdd = (oddWeightWIN * backWinOdd)
					+ (backWinOdd * cutOff.getNnOddWeight());
		}
		if (backDrawOdd * backDrawNeuralNetworkOdd == 0) {
			backDrawProcessedOdd = 0;
		} else {
			backDrawProcessedOdd = (oddWeightDRAW * backDrawOdd)
					+ (backDrawOdd * cutOff.getNnOddWeight());
		}
		if (backLoseOdd * backLoseNeuralNetworkOdd == 0) {
			backLoseProcessedOdd = 0;
		} else {
			backLoseProcessedOdd = (oddWeightLOSE * backLoseOdd)
					+ (backLoseOdd * cutOff.getNnOddWeight());
		}
		if (layWinOdd * layWinNeuralNetworkOdd == 0) {
			layWinProcessedOdd = 0;
		} else {
			layWinProcessedOdd = (oddWeightWIN * layWinOdd)
					+ (layWinOdd * cutOff.getNnOddWeight());
		}
		if (layDrawOdd * layDrawNeuralNetworkOdd == 0) {
			layDrawProcessedOdd = 0;
		} else {
			layDrawProcessedOdd = (oddWeightDRAW * layDrawOdd)
					+ (layDrawOdd * cutOff.getNnOddWeight());
		}
		if (layLoseOdd * layLoseNeuralNetworkOdd == 0) {
			layLoseProcessedOdd = 0;
		} else {
			layLoseProcessedOdd = (oddWeightLOSE * layLoseOdd)
					+ (layLoseOdd * cutOff.getNnOddWeight());
		}
	}

	private List<Bet> simpleBetDecision(Week w, Fixture f, CutOff cutOff) {
		ArrayList<Double> processedOdds = new ArrayList<Double>();
		processedOdds.add(backWinProcessedOdd);
		processedOdds.add(backDrawProcessedOdd);
		processedOdds.add(backLoseProcessedOdd);
		processedOdds.add(layWinProcessedOdd);
		processedOdds.add(layDrawProcessedOdd);
		processedOdds.add(layLoseProcessedOdd);

		List<Bet> bets = new ArrayList<Bet>();
		
		if (backWinProcessedOdd + backDrawProcessedOdd + backLoseProcessedOdd
				+ layWinProcessedOdd + layDrawProcessedOdd
				+ layLoseProcessedOdd == 0
				|| hasManyMax(processedOdds, getMaxValue(processedOdds))) {
			
			return null;
		} else if (backWinProcessedOdd == getMaxValue(processedOdds)) {
			if (backWinProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getBackHomeWin());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.WIN);
				bet.setWeek(w);
				
				bets.add(bet);
			}
		} else if (backDrawProcessedOdd == getMaxValue(processedOdds)) {
			if (backDrawProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getBackDraw());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.DRAW);
				bet.setWeek(w);
				
				bets.add(bet);
			}
		} else if (backLoseProcessedOdd == getMaxValue(processedOdds)) {
			if (backLoseProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getBackAwayWin());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.LOSE);
				bet.setWeek(w);
				
				bets.add(bet);
			}
		} else if (layWinProcessedOdd == getMaxValue(processedOdds)) {
			if (layWinProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getLayHomeWin());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.DONOTWIN);
				bet.setWeek(w);
				
				bets.add(bet);
			}
		} else if (layDrawProcessedOdd == getMaxValue(processedOdds)) {
			if (layDrawProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getLayDraw());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.DONOTDRAW);
				bet.setWeek(w);
				
				bets.add(bet);
			}
		} else if (layLoseProcessedOdd == getMaxValue(processedOdds)) {
			if (layLoseProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getLayAwayWin());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.DONOTLOSE);
				bet.setWeek(w);
				
				bets.add(bet);
			}
		}
		
		return bets;
	}

	
	private void doubleBetDecision(CutOff doubleBetCutoff) {

	}

	private void tripleBetDecision(CutOff tripleBetCutoff) {

	}

	private void multipleBetDecision(CutOff multipleBetCutoff) {

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

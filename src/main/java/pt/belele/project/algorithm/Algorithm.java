package pt.belele.project.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Bet.BetType;
import pt.belele.project.entities.Bet.MatchOddBet;
import pt.belele.project.entities.CutOff;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Week;
import pt.belele.project.util.Combination;
import pt.belele.project.util.Triplet;

public class Algorithm {

	private static final Logger LOG = LogManager.getLogger(Algorithm.class);

	private double oddWeightWIN;

	private double oddWeightDRAW;

	private double oddWeightLOSE;


	public Algorithm() {
	}

	public List<Bet> runAlgorithm(Week w, Map<Fixture, Odd> fixtures, CutOff cutOffSimple,
			CutOff cutOffDouble, CutOff cutOffTriple, CutOff cutOffMultiple) {

		List<Bet> bets = new ArrayList<Bet>();

		for (Fixture f : fixtures.keySet()) {
			LOG.info("###########\n" + f.toString() + "\n#####");
			atributeOddWeightCutOff(f, cutOffSimple);

			if (cutOffSimple != null) {
				Odd NNOdd = calculateNNOdds(f, cutOffSimple, fixtures.get(f).getBackHomeWin(),
						fixtures.get(f).getBackDraw(), fixtures.get(f).getBackAwayWin(),
						fixtures.get(f).getLayHomeWin(), fixtures.get(f).getLayDraw(),
						fixtures.get(f).getLayAwayWin());
				Odd processedOdds = calculateSimpleBetProcessedOdds(f, NNOdd, cutOffSimple);
				bets.addAll(simpleBetDecision(w, f, processedOdds, cutOffSimple));
			}
		}

		List<Fixture> fixtureList = new ArrayList<Fixture>();
		fixtureList.addAll(fixtures.keySet());

		if (cutOffDouble != null) {

			for (Fixture f : fixtureList) {
				Odd NNOdd = calculateNNOdds(f, cutOffDouble, fixtures.get(f).getBackHomeWin(),
						fixtures.get(f).getBackDraw(), fixtures.get(f).getBackAwayWin(),
						fixtures.get(f).getLayHomeWin(), fixtures.get(f).getLayDraw(),
						fixtures.get(f).getLayAwayWin());
			}

			Map<Fixture, Fixture> fixtureMap = Combination.doubleCombination(fixtureList);
			/*object x = */calculateDoubleBetProcessedOdds(fixtureMap, cutOffDouble);
			//bets.addAll(doubleBetDecision(w, /*x,*/ cutOffDouble));
		}
		if (cutOffTriple != null) {
			for (Fixture f : fixtureList) {
				Odd NNOdd = calculateNNOdds(f, cutOffTriple, fixtures.get(f).getBackHomeWin(),
						fixtures.get(f).getBackDraw(), fixtures.get(f).getBackAwayWin(),
						fixtures.get(f).getLayHomeWin(), fixtures.get(f).getLayDraw(),
						fixtures.get(f).getLayAwayWin());
			}
			
			List<Triplet<Fixture, Fixture, Fixture>> fixtureTriplet = Combination.tripleCombination(fixtureList);
			/*object x = */ calculateTripleBetProcessedOdds(fixtureTriplet, cutOffTriple);
			//bets.addAll(tripleBetDecision(w, fixtureTriplet, cutOffTriple));
		}
		if (cutOffMultiple != null) {
			for (Fixture f : fixtureList) {
				Odd NNOdd = calculateNNOdds(f, cutOffMultiple, fixtures.get(f).getBackHomeWin(),
						fixtures.get(f).getBackDraw(), fixtures.get(f).getBackAwayWin(),
						fixtures.get(f).getLayHomeWin(), fixtures.get(f).getLayDraw(),
						fixtures.get(f).getLayAwayWin());
			}
			
			calculateMultipleBetProcessedOdds(fixtureList, cutOffMultiple);
			//bets.addAll(multipleBetDecision(w, fixtureList, cutOffMultiple));
		}

		return bets;
	}

	/****************/
	/* AUX METHODS */
	/****************/

	private void atributeOddWeightCutOff(Fixture fixture, CutOff cutOff) {
		Odd odd = fixture.getOdd();
		if (odd.getBackHomeWin() > odd.getBackAwayWin() && odd.getBackHomeWin() > odd.getBackDraw()) {
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
		} else if (odd.getBackDraw() > odd.getBackAwayWin() && odd.getBackDraw() > odd.getBackHomeWin()) {
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
		} else if (odd.getBackAwayWin() > odd.getBackHomeWin() && odd.getBackAwayWin() > odd.getBackDraw()) {
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
		} else if (odd.getBackHomeWin() == odd.getBackAwayWin() && odd.getBackHomeWin() != odd.getBackDraw()) {
			if (odd.getBackHomeWin() > odd.getBackDraw()) {
				oddWeightWIN = cutOff.getOddWightHigherValue();
				oddWeightLOSE = cutOff.getOddWightHigherValue();
				oddWeightDRAW = cutOff.getOddWightMediumValue();
			} else {
				oddWeightDRAW = cutOff.getOddWightHigherValue();
				oddWeightWIN = cutOff.getOddWightMediumValue();
				oddWeightLOSE = cutOff.getOddWightMediumValue();
			}
		} else if (odd.getBackHomeWin() == odd.getBackDraw() && odd.getBackHomeWin() != odd.getBackAwayWin()) {
			if (odd.getBackHomeWin() > odd.getBackAwayWin()) {
				oddWeightWIN = cutOff.getOddWightHigherValue();
				oddWeightDRAW = cutOff.getOddWightHigherValue();
				oddWeightLOSE = cutOff.getOddWightMediumValue();
			} else {
				oddWeightLOSE = cutOff.getOddWightHigherValue();
				oddWeightWIN = cutOff.getOddWightMediumValue();
				oddWeightDRAW = cutOff.getOddWightMediumValue();
			}
		} else if (odd.getBackAwayWin() == odd.getBackDraw() && odd.getBackHomeWin() != odd.getBackAwayWin()) {
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
	}

	private Odd calculateNNOdds(Fixture f, CutOff cutOff, double neuralNetworkBackWIN, double neuralNetworkBackDRAW,
			double neuralNetworkBackLOSE, double neuralNetworkLayWIN, double neuralNetworkLayDRAW,
			double neuralNetworkLayLOSE) {
		
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

//		LOG.trace("backWinNeuralNetworkOdd " + backWinNeuralNetworkOdd);
//		LOG.trace("backDrawNeuralNetworkOdd " + backDrawNeuralNetworkOdd);
//		LOG.trace("backLoseNeuralNetworkOdd " + backLoseNeuralNetworkOdd);
//		LOG.trace("layWinNeuralNetworkOdd " + layWinNeuralNetworkOdd);
//		LOG.trace("layDrawNeuralNetworkOdd " + layDrawNeuralNetworkOdd);
//		LOG.trace("layLoseNeuralNetworkOdd " + layLoseNeuralNetworkOdd);
		
		return NNOdd;
	}

	private Odd calculateSimpleBetProcessedOdds(Fixture f, Odd NNOdd, CutOff cutOff) {
		
		Odd processedOdds = new Odd();
		
		double backWinNeuralNetworkOdd = NNOdd.getBackHomeWin();

		double backDrawNeuralNetworkOdd = NNOdd.getBackDraw();

		double backLoseNeuralNetworkOdd = NNOdd.getBackAwayWin();

		double layWinNeuralNetworkOdd = NNOdd.getLayHomeWin();

		double layDrawNeuralNetworkOdd = NNOdd.getBackDraw();

		double layLoseNeuralNetworkOdd = NNOdd.getBackAwayWin();
		
		if (f.getOdd().getBackHomeWin() * backWinNeuralNetworkOdd == 0) {
			processedOdds.setBackHomeWin(0.0);
		} else {
			processedOdds.setBackHomeWin((oddWeightWIN * (f.getOdd().getBackHomeWin() - 1) + f.getOdd().getBackHomeWin() - 1)
					* (f.getOdd().getBackHomeWin() * cutOff.getNnOddWeight()));
		}
		if (f.getOdd().getBackDraw() * backDrawNeuralNetworkOdd == 0) {
			processedOdds.setBackDraw(0.0);
		} else {
			processedOdds.setBackDraw((oddWeightDRAW * (f.getOdd().getBackDraw() - 1) + f.getOdd().getBackDraw() - 1)
					* (f.getOdd().getBackDraw() * cutOff.getNnOddWeight()));
		}
		if (f.getOdd().getBackAwayWin() * backLoseNeuralNetworkOdd == 0) {
			processedOdds.setBackAwayWin(0.0);
		} else {
			processedOdds.setBackAwayWin((oddWeightLOSE * (f.getOdd().getBackAwayWin() - 1) + f.getOdd().getBackAwayWin() - 1)
					* (f.getOdd().getBackAwayWin() * cutOff.getNnOddWeight()));
		}
		if (f.getOdd().getLayHomeWin() * layWinNeuralNetworkOdd == 0) {
			processedOdds.setLayHomeWin(0.0);
		} else {
			processedOdds.setLayHomeWin((oddWeightWIN * (f.getOdd().getLayHomeWin() - 1) + f.getOdd().getLayHomeWin() - 1)
					* (f.getOdd().getLayHomeWin() * cutOff.getNnOddWeight()));
		}
		if (f.getOdd().getLayDraw() * layDrawNeuralNetworkOdd == 0) {
			processedOdds.setLayDraw(0.0);
		} else {
			processedOdds.setLayDraw((oddWeightDRAW * (f.getOdd().getLayDraw() - 1) + f.getOdd().getLayDraw() - 1)
					* (f.getOdd().getLayDraw() * cutOff.getNnOddWeight()));
		}
		if (f.getOdd().getLayAwayWin() * layLoseNeuralNetworkOdd == 0) {
			processedOdds.setLayAwayWin(0.0);
		} else {
			processedOdds.setLayAwayWin((oddWeightLOSE * (f.getOdd().getLayAwayWin() - 1) + f.getOdd().getLayAwayWin() - 1)
					* (f.getOdd().getLayAwayWin() * cutOff.getNnOddWeight()));
		}
		
		return processedOdds;
	}

	//not a void, object x
	private void calculateDoubleBetProcessedOdds(Map<Fixture, Fixture> fixtureMap, CutOff cutOff) {
		//x = Object<Map(Fix,Fix),Odd>
		
		//percorrer o map e fazer o calculo
		
		//return x;
	}
	
	//not a void, object x
	private void calculateTripleBetProcessedOdds(List<Triplet<Fixture, Fixture, Fixture>> fixtureTriplet, CutOff cutOff) {
		//x = Object<Triplet(Fix,Fix,Fix),Odd>
		
		for (Triplet<Fixture, Fixture, Fixture> trip : fixtureTriplet){
			
		}
				
		//return x;
		
	}
	
	private List<Fixture> calculateMultipleBetProcessedOdds(List<Fixture> f, CutOff cutOff) {
		
		List<Double> processedOdds = new ArrayList<Double>();
		
		double backWinProcessedOdd;

		double backDrawProcessedOdd;

		double backLoseProcessedOdd;

		double layWinProcessedOdd;

		double layDrawProcessedOdd;

		double layLoseProcessedOdd;
		
		List<Fixture> fixturesToBet = new ArrayList<Fixture>();
		// if (f.getOdd().getBackHomeWin() * backWinNeuralNetworkOdd == 0) {
		// backWinProcessedOdd = 0;
		// } else {
		// backWinProcessedOdd = (oddWeightWIN * f.getOdd().getBackHomeWin())
		// + (f.getOdd().getBackHomeWin() * cutOff.getNnOddWeight());
		// }
		// if (f.getOdd().getBackDraw() * backDrawNeuralNetworkOdd == 0) {
		// backDrawProcessedOdd = 0;
		// } else {
		// backDrawProcessedOdd = (oddWeightDRAW * f.getOdd().getBackDraw())
		// + (f.getOdd().getBackDraw() * cutOff.getNnOddWeight());
		// }
		// if (f.getOdd().getBackAwayWin() * backLoseNeuralNetworkOdd == 0) {
		// backLoseProcessedOdd = 0;
		// } else {
		// backLoseProcessedOdd = (oddWeightLOSE * f.getOdd().getBackAwayWin())
		// + (f.getOdd().getBackAwayWin() * cutOff.getNnOddWeight());
		// }
		// if (f.getOdd().getLayHomeWin() * layWinNeuralNetworkOdd == 0) {
		// layWinProcessedOdd = 0;
		// } else {
		// layWinProcessedOdd = (oddWeightWIN * f.getOdd().getLayHomeWin())
		// + (f.getOdd().getLayHomeWin() * cutOff.getNnOddWeight());
		// }
		// if (f.getOdd().getLayDraw() * layDrawNeuralNetworkOdd == 0) {
		// layDrawProcessedOdd = 0;
		// } else {
		// layDrawProcessedOdd = (oddWeightDRAW * f.getOdd().getLayDraw())
		// + (f.getOdd().getLayDraw() * cutOff.getNnOddWeight());
		// }
		// if (f.getOdd().getLayAwayWin() * layLoseNeuralNetworkOdd == 0) {
		// layLoseProcessedOdd = 0;
		// } else {
		// layLoseProcessedOdd = (oddWeightLOSE * f.getOdd().getLayAwayWin())
		// + (f.getOdd().getLayAwayWin() * cutOff.getNnOddWeight());
		// }
		return fixturesToBet;
	}

	private List<Bet> simpleBetDecision(Week w, Fixture f, Odd processedOdds, CutOff cutOff) {
		
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

		if (backWinProcessedOdd + backDrawProcessedOdd + backLoseProcessedOdd + layWinProcessedOdd + layDrawProcessedOdd
				+ layLoseProcessedOdd == 0 || hasManyMax(processedOddsAsDoubles, maxValue)) {

			LOG.trace("NULL");

			return null;
		} else if (backWinProcessedOdd == maxValue) {
			if (backWinProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getBackHomeWin());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.WIN);
				bet.setWeek(w);
				bet.setInvestedValue(1);
				bets.add(bet);
			}
		} else if (backDrawProcessedOdd == maxValue) {
			if (backDrawProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getBackDraw());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.DRAW);
				bet.setWeek(w);
				bet.setInvestedValue(1);
				bets.add(bet);
			}
		} else if (backLoseProcessedOdd == maxValue) {
			if (backLoseProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getBackAwayWin());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.LOSE);
				bet.setWeek(w);
				bet.setInvestedValue(1);
				bets.add(bet);
			}
		} else if (layWinProcessedOdd == maxValue) {
			if (layWinProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getLayHomeWin());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.DONOTWIN);
				bet.setWeek(w);
				bet.setInvestedValue(1);
				bets.add(bet);
			}
		} else if (layDrawProcessedOdd == maxValue) {
			if (layDrawProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getLayDraw());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.DONOTDRAW);
				bet.setWeek(w);
				bet.setInvestedValue(1);
				bets.add(bet);
			}
		} else if (layLoseProcessedOdd == maxValue) {
			if (layLoseProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				Bet bet = new Bet();
				bet.setOdd(f.getOdd().getLayAwayWin());
				bet.setBetType(BetType.SIMPLE);
				List<Fixture> fixtures = new ArrayList<Fixture>();
				fixtures.add(f);
				bet.setFixtures(fixtures);
				bet.setMatchOddBet(MatchOddBet.DONOTLOSE);
				bet.setWeek(w);
				bet.setInvestedValue(1);
				bets.add(bet);
			}
		}

		return bets;
	}

//	private List<Bet> doubleBetDecision(Week w, Map<Fixture, Fixture> f, CutOff doubleBetCutoff) {
//
//	}

//	private List<Bet> tripleBetDecision(Week w, List<Triplet<Fixture, Fixture, Fixture>> f, CutOff tripleBetCutoff) {
//		
//	}

//	private List<Bet> multipleBetDecision(Week w, List<Fixture> f, CutOff multipleBetCutoff) {
//		
//	}

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

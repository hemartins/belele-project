package pt.belele.project.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import pt.belele.project.business.util.Combination;
import pt.belele.project.business.util.CutOff;
import pt.belele.project.business.util.Triplet;
import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Bet.MatchOddBet;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.MultipleBet;
import pt.belele.project.entities.MultipleBet.MultipleBetType;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Season;
import pt.belele.project.persistence.FixtureDAO;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class BetControllerBean implements BetController {

    private static final Logger LOG = LogManager.getLogger(BetControllerBean.class);

    @EJB
    private CutOffController cuttOffController;

    @EJB
    private OddController oddController;

    @EJB
    private SeasonController seasonController;

    @EJB
    private FixtureDAO fixtureDAO;

    @Override
    public Double calculateOdd(Bet bet, MatchOddBet matchOddsBet) {
	switch (matchOddsBet) {
	    case WIN:
		return bet.getFixture().getOdd().getBackHomeWin();
	    case DRAW:
		return bet.getFixture().getOdd().getBackDraw();
	    case LOSE:
		return bet.getFixture().getOdd().getBackAwayWin();
	    case DONOTWIN:
		return bet.getFixture().getOdd().getLayHomeWin();
	    case DONOTDRAW:
		return bet.getFixture().getOdd().getLayDraw();
	    case DONOTLOSE:
		return bet.getFixture().getOdd().getLayAwayWin();
	}
	return null;
    }

    @Override
    public List<Bet> calculateSimpleBetForFixtures(List<Fixture> fixtures, CutOff cutOffSimple, Double investedValue) {

	List<Bet> bets = new ArrayList<>();

	for (Fixture f : fixtures) {

	    if (f.getAnnOdd() == null) {
		continue;
	    }

	    Double backHomeWin = f.getAnnOdd().getBackHomeWin();
	    Double backDraw = f.getAnnOdd().getBackDraw();
	    Double backAwayWin = f.getAnnOdd().getBackAwayWin();
	    Double layHomeWin = f.getAnnOdd().getLayHomeWin();
	    Double layDraw = f.getAnnOdd().getLayDraw();
	    Double layAwayWin = f.getAnnOdd().getLayAwayWin();

	    LOG.trace("###########\n" + f.toString() + "\n#####");

	    if (cutOffSimple != null) {
		Odd simpleNNOdd = calculateNNOdds(f, cutOffSimple, backHomeWin, backDraw, backAwayWin, layHomeWin, layDraw, layAwayWin);
		Odd simpleProcessedOdd = calculateSimpleBetProcessedOdds(f, simpleNNOdd, cutOffSimple, atributeOddWeightCutOff(f, cutOffSimple));

		bets = betDecision(f, simpleProcessedOdd, cutOffSimple, investedValue);
	    }
	}

	return bets;
    }

    @Override
    public List<MultipleBet> calculateMultipleBetForFixtures(List<Fixture> fixtures, CutOff cutOffDouble, CutOff cutOffTriple, CutOff cutOffMultiple, Double investedValue) {
	List<Bet> doubleBets = new ArrayList<>();
	List<Bet> tripleBets = new ArrayList<>();
	List<Bet> multipleBetList = new ArrayList<>();

	for (Fixture f : fixtures) {

	    if (f.getAnnOdd() == null) {
		continue;
	    }

	    Double backHomeWin = f.getAnnOdd().getBackHomeWin();
	    Double backDraw = f.getAnnOdd().getBackDraw();
	    Double backAwayWin = f.getAnnOdd().getBackAwayWin();
	    Double layHomeWin = f.getAnnOdd().getLayHomeWin();
	    Double layDraw = f.getAnnOdd().getLayDraw();
	    Double layAwayWin = f.getAnnOdd().getLayAwayWin();

	    LOG.trace("###########\n" + f.toString() + "\n#####");
	    atributeOddWeightCutOff(f, cutOffDouble);

	    if (cutOffDouble != null) {
		Odd doubleNNOdd = calculateNNOdds(f, cutOffDouble, backHomeWin, backDraw, backAwayWin, layHomeWin, layDraw, layAwayWin);
		Odd doubleProcessedOdd = calculateMultipleBetProcessedOdds(f, doubleNNOdd, cutOffDouble, atributeOddWeightCutOff(f, cutOffDouble));
		doubleBets.addAll(betDecision(f, doubleProcessedOdd, cutOffDouble, investedValue));
	    }

	    if (cutOffTriple != null) {
		Odd tripleNNOdd = calculateNNOdds(f, cutOffTriple, backHomeWin, backDraw, backAwayWin, layHomeWin, layDraw, layAwayWin);
		Odd tripleProcessedOdd = calculateMultipleBetProcessedOdds(f, tripleNNOdd, cutOffTriple, atributeOddWeightCutOff(f, cutOffTriple));
		tripleBets.addAll(betDecision(f, tripleProcessedOdd, cutOffTriple, investedValue));
	    }

	    if (cutOffMultiple != null) {
		Odd multipleNNOdd = calculateNNOdds(f, cutOffMultiple, backHomeWin, backDraw, backAwayWin, layHomeWin, layDraw, layAwayWin);
		Odd multipleProcessedOdd = calculateMultipleBetProcessedOdds(f, multipleNNOdd, cutOffMultiple, atributeOddWeightCutOff(f, cutOffMultiple));
		multipleBetList.addAll(betDecision(f, multipleProcessedOdd, cutOffMultiple, investedValue));
	    }
	}

	Map<Bet, Bet> doubleBetsCombination = null;
	if (!doubleBets.isEmpty()) {
	    doubleBetsCombination = Combination.doubleCombination(doubleBets);
	}

	List<Triplet<Bet, Bet, Bet>> tripleBetsCombination = null;
	if (!tripleBets.isEmpty()) {
	    tripleBetsCombination = Combination.tripleCombination(tripleBets);
	}

	List<MultipleBet> multipleBets = addMultipleBets(doubleBetsCombination, tripleBetsCombination, multipleBetList, investedValue);

	return multipleBets;
    }

    @Override
    public List<Bet> doSimpleBetsForSeason(DateTime begin, DateTime end, Season s, Double investedValue, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception{

	LOG.info("Simple Betting for season " + s.getName() + " " + s.getYear() + " between " + begin + " and " + end);

	//DateTime beginOld = new DateTime(begin).minusYears(2);
	DateTime beginOld = new DateTime(begin).minusMonths(2);
	List<Fixture> oldFixtures = fixtureDAO.findCountryFixturesBetweenDates(s.getName(), beginOld, begin);
	LOG.info("Number of Fixtures: " + oldFixtures.size());
	LOG.info("Calculating CuttOffs");
	CutOff cutOffSimple = cuttOffController.getSimpleCutoffForFixtures(oldFixtures, investedValue, winVariables, drawVariables, loseVariables);

	beginOld = new DateTime(begin).minusYears(7);
	oldFixtures = fixtureDAO.findCountryFixturesBetweenDates(s.getName(), beginOld, begin);

	List<Fixture> fixtures = fixtureDAO.findFixturesBetweenDates(s.getId(), begin, end);
	LOG.info("Number of Fixtures: " + fixtures.size());

	Triplet<float[], float[], float[]> finalOddTriplet = oddController.calculateAnnOddsForFixtures(fixtures, oldFixtures, winVariables, drawVariables, loseVariables);

	float[] annWinOdd = finalOddTriplet.getA();
	float[] annDrawOdd = finalOddTriplet.getB();
	float[] annLoseOdd = finalOddTriplet.getC();

	LOG.info("ANNWIN: " + Arrays.toString(annWinOdd));
	LOG.info("ANNDRAW: " + Arrays.toString(annDrawOdd));
	LOG.info("ANNLOSE: " + Arrays.toString(annLoseOdd));

	for (int i = 0; i < fixtures.size(); i++) {
	    Fixture f = fixtures.get(i);

	    Odd ANNOdds = new Odd((double) annWinOdd[0], (double) annDrawOdd[0], (double) annLoseOdd[0]);
	    oddController.calculateLayOddsAsBackOdds(ANNOdds);

	    f.setAnnOdd(ANNOdds);
	    fixtureDAO.update(f);
	}

	List<Bet> bets = calculateSimpleBetForFixtures(fixtures, cutOffSimple, investedValue);

	//TODO INTERFACE BETFAIR
	
	return bets;
    }

    @Override
    public List<MultipleBet> doMultipleBetsForSeason(DateTime begin, DateTime end, Season s, Double investedValue, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception{
	LOG.info("Multiple Betting for season " + s.getName() + " " + s.getYear() + " between " + begin + " and " + end);

	DateTime beginOld = new DateTime(begin).minusYears(2);
	List<Fixture> oldFixtures = fixtureDAO.findCountryFixturesBetweenDates(s.getName(), beginOld, begin);
	Triplet<CutOff, CutOff, CutOff> multipleCutoffs = cuttOffController.getMultipleCutOffForFixtures(oldFixtures, investedValue, winVariables, drawVariables, loseVariables);

	beginOld = new DateTime(begin).minusYears(7);
	oldFixtures = fixtureDAO.findCountryFixturesBetweenDates(s.getName(), beginOld, begin);

	List<Fixture> fixtures = fixtureDAO.findFixturesBetweenDates(s.getId(), begin, end);
	LOG.info("Number of Fixtures: " + fixtures.size());

	Triplet<float[], float[], float[]> finalOddTriplet = oddController.calculateAnnOddsForFixtures(fixtures, oldFixtures, winVariables, drawVariables, loseVariables);

	float[] annWinOdd = finalOddTriplet.getA();
	float[] annDrawOdd = finalOddTriplet.getB();
	float[] annLoseOdd = finalOddTriplet.getC();

	LOG.info("ANNWIN: " + Arrays.toString(annWinOdd));
	LOG.info("ANNDRAW: " + Arrays.toString(annDrawOdd));
	LOG.info("ANNLOSE: " + Arrays.toString(annLoseOdd));

	for (int i = 0; i < fixtures.size(); i++) {
	    Fixture f = fixtures.get(i);
	    double backANNOdds[] = {annWinOdd[i], annDrawOdd[i], annLoseOdd[i]};
	    double layANNOdds[] = {1 - backANNOdds[0], 1 - backANNOdds[1],
		1 - backANNOdds[2]};
	    Odd ANNOdds = new Odd(backANNOdds[0], backANNOdds[1],
		    backANNOdds[2], layANNOdds[0], layANNOdds[1], layANNOdds[2]);

	    f.setAnnOdd(ANNOdds);
	    fixtureDAO.update(f);
	}

	List<MultipleBet> multipleBets = calculateMultipleBetForFixtures(fixtures, multipleCutoffs.getA(), multipleCutoffs.getB(), multipleCutoffs.getC(), investedValue);

	//TODO INTERFACE BETFAIR
	
	return multipleBets;
    }

    /**
     * *************
     */
    /* AUX METHODS */
    /**
     * *************
     */
    private List<Double> atributeOddWeightCutOff(Fixture fixture, CutOff cutOff) {
	List<Double> oddWeights = new ArrayList<>();

	double oddWeightWIN;

	double oddWeightDRAW;

	double oddWeightLOSE;

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
	} else if (odd.getBackHomeWin().equals(odd.getBackAwayWin()) && !odd.getBackHomeWin().equals(odd.getBackDraw())) {
	    if (odd.getBackHomeWin() > odd.getBackDraw()) {
		oddWeightWIN = cutOff.getOddWightHigherValue();
		oddWeightLOSE = cutOff.getOddWightHigherValue();
		oddWeightDRAW = cutOff.getOddWightMediumValue();
	    } else {
		oddWeightDRAW = cutOff.getOddWightHigherValue();
		oddWeightWIN = cutOff.getOddWightMediumValue();
		oddWeightLOSE = cutOff.getOddWightMediumValue();
	    }
	} else if (odd.getBackHomeWin().equals(odd.getBackDraw()) && !odd.getBackHomeWin().equals(odd.getBackAwayWin())) {
	    if (odd.getBackHomeWin() > odd.getBackAwayWin()) {
		oddWeightWIN = cutOff.getOddWightHigherValue();
		oddWeightDRAW = cutOff.getOddWightHigherValue();
		oddWeightLOSE = cutOff.getOddWightMediumValue();
	    } else {
		oddWeightLOSE = cutOff.getOddWightHigherValue();
		oddWeightWIN = cutOff.getOddWightMediumValue();
		oddWeightDRAW = cutOff.getOddWightMediumValue();
	    }
	} else if (odd.getBackAwayWin().equals(odd.getBackDraw()) && !odd.getBackHomeWin().equals(odd.getBackAwayWin())) {
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

    private Odd calculateNNOdds(Fixture f, CutOff cutOff, double neuralNetworkBackWIN, double neuralNetworkBackDRAW, double neuralNetworkBackLOSE, double neuralNetworkLayWIN, double neuralNetworkLayDRAW, double neuralNetworkLayLOSE) {
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

    private Odd calculateSimpleBetProcessedOdds(Fixture f, Odd NNOdd, CutOff cutOff, List<Double> oddWeights) {

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
	    processedOdds.setBackHomeWin((oddWeightWIN * (f.getOdd().getBackHomeWin() - 1) + f.getOdd().getBackHomeWin() - 1) * (f.getOdd().getBackHomeWin() * cutOff.getNnOddWeight()));
	}
	if (f.getOdd().getBackDraw() * backDrawNeuralNetworkOdd == 0) {
	    processedOdds.setBackDraw(0.0);
	} else {
	    processedOdds.setBackDraw((oddWeightDRAW * (f.getOdd().getBackDraw() - 1) + f.getOdd().getBackDraw() - 1) * (f.getOdd().getBackDraw() * cutOff.getNnOddWeight()));
	}
	if (f.getOdd().getBackAwayWin() * backLoseNeuralNetworkOdd == 0) {
	    processedOdds.setBackAwayWin(0.0);
	} else {
	    processedOdds.setBackAwayWin((oddWeightLOSE * (f.getOdd().getBackAwayWin() - 1) + f.getOdd().getBackAwayWin() - 1) * (f.getOdd().getBackAwayWin() * cutOff.getNnOddWeight()));
	}
	if (f.getOdd().getLayHomeWin() * layWinNeuralNetworkOdd == 0) {
	    processedOdds.setLayHomeWin(0.0);
	} else {
	    processedOdds.setLayHomeWin((oddWeightWIN * (f.getOdd().getLayHomeWin() - 1) + f.getOdd().getLayHomeWin() - 1) * (f.getOdd().getLayHomeWin() * cutOff.getNnOddWeight()));
	}
	if (f.getOdd().getLayDraw() * layDrawNeuralNetworkOdd == 0) {
	    processedOdds.setLayDraw(0.0);
	} else {
	    processedOdds.setLayDraw((oddWeightDRAW * (f.getOdd().getLayDraw() - 1) + f.getOdd().getLayDraw() - 1) * (f.getOdd().getLayDraw() * cutOff.getNnOddWeight()));
	}
	if (f.getOdd().getLayAwayWin() * layLoseNeuralNetworkOdd == 0) {
	    processedOdds.setLayAwayWin(0.0);
	} else {
	    processedOdds.setLayAwayWin((oddWeightLOSE * (f.getOdd().getLayAwayWin() - 1) + f.getOdd().getLayAwayWin() - 1) * (f.getOdd().getLayAwayWin() * cutOff.getNnOddWeight()));
	}

	return processedOdds;
    }

    private Odd calculateMultipleBetProcessedOdds(Fixture f, Odd NNOdd, CutOff cutOff, List<Double> oddWeights) {
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
	    processedOdds.setBackHomeWin(oddWeightWIN * (f.getOdd().getBackHomeWin()) + f.getOdd().getBackHomeWin() * cutOff.getNnOddWeight());
	}
	if (f.getOdd().getBackDraw() * backDrawNeuralNetworkOdd == 0) {
	    processedOdds.setBackDraw(0.0);
	} else {
	    processedOdds.setBackDraw(oddWeightDRAW * (f.getOdd().getBackDraw()) + f.getOdd().getBackDraw() * cutOff.getNnOddWeight());
	}
	if (f.getOdd().getBackAwayWin() * backLoseNeuralNetworkOdd == 0) {
	    processedOdds.setBackAwayWin(0.0);
	} else {
	    processedOdds.setBackAwayWin(oddWeightLOSE * (f.getOdd().getBackAwayWin()) + f.getOdd().getBackAwayWin() * cutOff.getNnOddWeight());
	}
	if (f.getOdd().getLayHomeWin() * layWinNeuralNetworkOdd == 0) {
	    processedOdds.setLayHomeWin(0.0);
	} else {
	    processedOdds.setLayHomeWin(oddWeightWIN * (f.getOdd().getLayHomeWin()) + f.getOdd().getLayHomeWin() * cutOff.getNnOddWeight());
	}
	if (f.getOdd().getLayDraw() * layDrawNeuralNetworkOdd == 0) {
	    processedOdds.setLayDraw(0.0);
	} else {
	    processedOdds.setLayDraw(oddWeightWIN * (f.getOdd().getLayDraw()) + f.getOdd().getLayDraw() * cutOff.getNnOddWeight());
	}
	if (f.getOdd().getLayAwayWin() * layLoseNeuralNetworkOdd == 0) {
	    processedOdds.setLayAwayWin(0.0);
	} else {
	    processedOdds.setLayAwayWin(oddWeightWIN * (f.getOdd().getLayAwayWin()) + f.getOdd().getLayAwayWin() * cutOff.getNnOddWeight());
	}

	return processedOdds;
    }

    private List<Bet> betDecision(Fixture f, Odd processedOdds, CutOff cutOff, Double investedValue) {

	ArrayList<Double> processedOddsAsDoubles = new ArrayList<>();

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

	List<Bet> bets = new ArrayList<>();

	if (backWinProcessedOdd + backDrawProcessedOdd + backLoseProcessedOdd + layWinProcessedOdd + layDrawProcessedOdd + layLoseProcessedOdd == 0 || hasManyMax(processedOddsAsDoubles, maxValue)) {

	    LOG.trace("NULL");

	    return null;
	} else if (backWinProcessedOdd == maxValue) {
	    if (backWinProcessedOdd >= cutOff.getMinimumQualityRelation()) {
		Bet bet = new Bet();
		bet.setOdd(f.getOdd().getBackHomeWin());
		bet.setFixture(f);
		bet.setMatchOddBet(MatchOddBet.WIN);
		bet.setInvestedValue(investedValue);
		bets.add(bet);
	    }
	} else if (backDrawProcessedOdd == maxValue) {
	    if (backDrawProcessedOdd >= cutOff.getMinimumQualityRelation()) {
		Bet bet = new Bet();
		bet.setOdd(f.getOdd().getBackDraw());
		bet.setFixture(f);
		bet.setMatchOddBet(MatchOddBet.DRAW);
		bet.setInvestedValue(investedValue);
		bets.add(bet);
	    }
	} else if (backLoseProcessedOdd == maxValue) {
	    if (backLoseProcessedOdd >= cutOff.getMinimumQualityRelation()) {
		Bet bet = new Bet();
		bet.setOdd(f.getOdd().getBackAwayWin());
		bet.setFixture(f);
		bet.setMatchOddBet(MatchOddBet.LOSE);
		bet.setInvestedValue(investedValue);
		bets.add(bet);
	    }
	} else if (layWinProcessedOdd == maxValue) {
	    if (layWinProcessedOdd >= cutOff.getMinimumQualityRelation()) {
		Bet bet = new Bet();
		bet.setOdd(f.getOdd().getLayHomeWin());
		bet.setFixture(f);
		bet.setMatchOddBet(MatchOddBet.DONOTWIN);
		bet.setInvestedValue(investedValue);
		bets.add(bet);
	    }
	} else if (layDrawProcessedOdd == maxValue) {
	    if (layDrawProcessedOdd >= cutOff.getMinimumQualityRelation()) {
		Bet bet = new Bet();
		bet.setOdd(f.getOdd().getLayDraw());
		bet.setFixture(f);
		bet.setMatchOddBet(MatchOddBet.DONOTDRAW);
		bet.setInvestedValue(investedValue);
		bets.add(bet);
	    }
	} else if (layLoseProcessedOdd == maxValue) {
	    if (layLoseProcessedOdd >= cutOff.getMinimumQualityRelation()) {
		Bet bet = new Bet();
		bet.setOdd(f.getOdd().getLayAwayWin());
		bet.setFixture(f);
		bet.setMatchOddBet(MatchOddBet.DONOTLOSE);
		bet.setInvestedValue(investedValue);
		bets.add(bet);
	    }
	}

	return bets;
    }

    private List<MultipleBet> addMultipleBets(Map<Bet, Bet> doubleBetsCombination, List<Triplet<Bet, Bet, Bet>> tripleBetsCombination, List<Bet> multipleBetList, Double investedValue) {

	if (multipleBetList == null || multipleBetList.isEmpty()) {
	    return null;
	}

	List<MultipleBet> bets = new ArrayList<>();

	// MULTIPLA
	MultipleBet bigMultipleBet = new MultipleBet();
	bigMultipleBet.setBetsList(multipleBetList);
	bigMultipleBet.setBetType(MultipleBetType.MULTIPLE);
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
		multipleBet.setBetType(MultipleBetType.DOUBLE);
		multipleBet.setInvestedValue(investedValue);
		List<Bet> doubleBetList = new ArrayList<>();
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
		multipleBet.setBetType(MultipleBetType.TRIPLE);
		multipleBet.setInvestedValue(investedValue);
		List<Bet> betsList = new ArrayList<>();

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
	    if (listUnit.equals(max)) {
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

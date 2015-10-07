package pt.belele.project.algorithm;

import java.util.ArrayList;

import pt.belele.project.entities.CutOff;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Odd;

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

	private boolean backWinBet;

	private boolean backDrawBet;

	private boolean backLoseBet;

	private boolean layWinBet;

	private boolean layDrawBet;

	private boolean layLoseBet;

	public Algorithm() {

	}

	public double getOddWeightWIN() {
		return oddWeightWIN;
	}

	public void setOddWeightWIN(double oddWeightWIN) {
		this.oddWeightWIN = oddWeightWIN;
	}

	public double getOddWeightDRAW() {
		return oddWeightDRAW;
	}

	public void setOddWeightDRAW(double oddWeightDRAW) {
		this.oddWeightDRAW = oddWeightDRAW;
	}

	public double getOddWeightLOSE() {
		return oddWeightLOSE;
	}

	public void setOddWeightLOSE(double oddWeightLOSE) {
		this.oddWeightLOSE = oddWeightLOSE;
	}

	public double getBackWinOdd() {
		return backWinOdd;
	}

	public void setBackWinOdd(double backWinOdd) {
		this.backWinOdd = backWinOdd;
	}

	public double getBackDrawOdd() {
		return backDrawOdd;
	}

	public void setBackDrawOdd(double backDrawOdd) {
		this.backDrawOdd = backDrawOdd;
	}

	public double getBackLoseOdd() {
		return backLoseOdd;
	}

	public void setBackLoseOdd(double backLoseOdd) {
		this.backLoseOdd = backLoseOdd;
	}

	public double getLayWinOdd() {
		return layWinOdd;
	}

	public void setLayWinOdd(double layWinOdd) {
		this.layWinOdd = layWinOdd;
	}

	public double getLayDrawOdd() {
		return layDrawOdd;
	}

	public void setLayDrawOdd(double layDrawOdd) {
		this.layDrawOdd = layDrawOdd;
	}

	public double getLayLoseOdd() {
		return layLoseOdd;
	}

	public void setLayLoseOdd(double layLoseOdd) {
		this.layLoseOdd = layLoseOdd;
	}

	public double getBackWinProcessedOdd() {
		return backWinProcessedOdd;
	}

	public void setBackWinProcessedOdd(double backWinProcessedOdd) {
		this.backWinProcessedOdd = backWinProcessedOdd;
	}

	public double getBackDrawProcessedOdd() {
		return backDrawProcessedOdd;
	}

	public void setBackDrawProcessedOdd(double backDrawProcessedOdd) {
		this.backDrawProcessedOdd = backDrawProcessedOdd;
	}

	public double getBackLoseProcessedOdd() {
		return backLoseProcessedOdd;
	}

	public void setBackLoseProcessedOdd(double backLoseProcessedOdd) {
		this.backLoseProcessedOdd = backLoseProcessedOdd;
	}

	public double getLayWinProcessedOdd() {
		return layWinProcessedOdd;
	}

	public void setLayWinProcessedOdd(double layWinProcessedOdd) {
		this.layWinProcessedOdd = layWinProcessedOdd;
	}

	public double getLayDrawProcessedOdd() {
		return layDrawProcessedOdd;
	}

	public void setLayDrawProcessedOdd(double layDrawProcessedOdd) {
		this.layDrawProcessedOdd = layDrawProcessedOdd;
	}

	public double getLayLoseProcessedOdd() {
		return layLoseProcessedOdd;
	}

	public void setLayLoseProcessedOdd(double layLoseProcessedOdd) {
		this.layLoseProcessedOdd = layLoseProcessedOdd;
	}

	public double getBackWinNeuralNetworkOdd() {
		return backWinNeuralNetworkOdd;
	}

	public void setBackWinNeuralNetworkOdd(double backWinNeuralNetworkOdd) {
		this.backWinNeuralNetworkOdd = backWinNeuralNetworkOdd;
	}

	public double getBackDrawNeuralNetworkOdd() {
		return backDrawNeuralNetworkOdd;
	}

	public void setBackDrawNeuralNetworkOdd(double backDrawNeuralNetworkOdd) {
		this.backDrawNeuralNetworkOdd = backDrawNeuralNetworkOdd;
	}

	public double getBackLoseNeuralNetworkOdd() {
		return backLoseNeuralNetworkOdd;
	}

	public void setBackLoseNeuralNetworkOdd(double backLoseNeuralNetworkOdd) {
		this.backLoseNeuralNetworkOdd = backLoseNeuralNetworkOdd;
	}

	public double getLayWinNeuralNetworkOdd() {
		return layWinNeuralNetworkOdd;
	}

	public void setLayWinNeuralNetworkOdd(double layWinNeuralNetworkOdd) {
		this.layWinNeuralNetworkOdd = layWinNeuralNetworkOdd;
	}

	public double getLayDrawNeuralNetworkOdd() {
		return layDrawNeuralNetworkOdd;
	}

	public void setLayDrawNeuralNetworkOdd(double layDrawNeuralNetworkOdd) {
		this.layDrawNeuralNetworkOdd = layDrawNeuralNetworkOdd;
	}

	public double getLayLoseNeuralNetworkOdd() {
		return layLoseNeuralNetworkOdd;
	}

	public void setLayLoseNeuralNetworkOdd(double layLoseNeuralNetworkOdd) {
		this.layLoseNeuralNetworkOdd = layLoseNeuralNetworkOdd;
	}

	public boolean isBackWinBet() {
		return backWinBet;
	}

	public void setBackWinBet(boolean backWinBet) {
		this.backWinBet = backWinBet;
	}

	public boolean isBackDrawBet() {
		return backDrawBet;
	}

	public void setBackDrawBet(boolean backDrawBet) {
		this.backDrawBet = backDrawBet;
	}

	public boolean isBackLoseBet() {
		return backLoseBet;
	}

	public void setBackLoseBet(boolean backLoseBet) {
		this.backLoseBet = backLoseBet;
	}

	public boolean isLayWinBet() {
		return layWinBet;
	}

	public void setLayWinBet(boolean layWinBet) {
		this.layWinBet = layWinBet;
	}

	public boolean isLayDrawBet() {
		return layDrawBet;
	}

	public void setLayDrawBet(boolean layDrawBet) {
		this.layDrawBet = layDrawBet;
	}

	public boolean isLayLoseBet() {
		return layLoseBet;
	}

	public void setLayLoseBet(boolean layLoseBet) {
		this.layLoseBet = layLoseBet;
	}

	public void atributeOddWeightCutOff(Fixture fixture, CutOff cutOff) {
		Odd odd = fixture.getOdd();
		if (odd.getBackHomeWin() > odd.getBackAwayWin() && odd.getBackHomeWin() > odd.getBackDraw()) {
			this.setOddWeightWIN(cutOff.getOddWightHigherValue());
			if (odd.getBackDraw() > odd.getBackAwayWin()) {
				this.setOddWeightDRAW(cutOff.getOddWightMediumValue());
				this.setOddWeightLOSE(cutOff.getOddWightLowerValue());
			} else if (odd.getBackDraw() < odd.getBackAwayWin()) {
				this.setOddWeightLOSE(cutOff.getOddWightMediumValue());
				this.setOddWeightDRAW(cutOff.getOddWightLowerValue());
			} else {
				this.setOddWeightLOSE(cutOff.getOddWightMediumValue());
				this.setOddWeightDRAW(cutOff.getOddWightMediumValue());
			}
		} else if (odd.getBackDraw() > odd.getBackAwayWin() && odd.getBackDraw() > odd.getBackHomeWin()) {
			this.setOddWeightDRAW(cutOff.getOddWightHigherValue());
			if (odd.getBackHomeWin() > odd.getBackAwayWin()) {
				this.setOddWeightWIN(cutOff.getOddWightMediumValue());
				this.setOddWeightLOSE(cutOff.getOddWightLowerValue());
			} else if (odd.getBackHomeWin() < odd.getBackAwayWin()) {
				this.setOddWeightLOSE(cutOff.getOddWightMediumValue());
				this.setOddWeightWIN(cutOff.getOddWightLowerValue());
			} else {
				this.setOddWeightWIN(cutOff.getOddWightMediumValue());
				this.setOddWeightLOSE(cutOff.getOddWightMediumValue());
			}
		} else if (odd.getBackAwayWin() > odd.getBackHomeWin() && odd.getBackAwayWin() > odd.getBackDraw()) {
			this.setOddWeightLOSE(cutOff.getOddWightHigherValue());
			if (odd.getBackHomeWin() > odd.getBackDraw()) {
				this.setOddWeightWIN(cutOff.getOddWightMediumValue());
				this.setOddWeightDRAW(cutOff.getOddWightLowerValue());
			} else if (odd.getBackHomeWin() < odd.getBackDraw()) {
				this.setOddWeightDRAW(cutOff.getOddWightMediumValue());
				this.setOddWeightWIN(cutOff.getOddWightLowerValue());
			} else {
				this.setOddWeightWIN(cutOff.getOddWightMediumValue());
				this.setOddWeightDRAW(cutOff.getOddWightMediumValue());
			}
		} else if (odd.getBackHomeWin() == odd.getBackAwayWin() && odd.getBackHomeWin() != odd.getBackDraw()) {
			if (odd.getBackHomeWin() > odd.getBackDraw()) {
				this.setOddWeightWIN(cutOff.getOddWightHigherValue());
				this.setOddWeightLOSE(cutOff.getOddWightHigherValue());
				this.setOddWeightDRAW(cutOff.getOddWightMediumValue());
			} else {
				this.setOddWeightDRAW(cutOff.getOddWightHigherValue());
				this.setOddWeightWIN(cutOff.getOddWightMediumValue());
				this.setOddWeightLOSE(cutOff.getOddWightMediumValue());
			}
		} else if (odd.getBackHomeWin() == odd.getBackDraw() && odd.getBackHomeWin() != odd.getBackAwayWin()) {
			if (odd.getBackHomeWin() > odd.getBackAwayWin()) {
				this.setOddWeightWIN(cutOff.getOddWightHigherValue());
				this.setOddWeightDRAW(cutOff.getOddWightHigherValue());
				this.setOddWeightLOSE(cutOff.getOddWightMediumValue());
			} else {
				this.setOddWeightLOSE(cutOff.getOddWightHigherValue());
				this.setOddWeightWIN(cutOff.getOddWightMediumValue());
				this.setOddWeightDRAW(cutOff.getOddWightMediumValue());
			}
		} else if (odd.getBackAwayWin() == odd.getBackDraw() && odd.getBackHomeWin() != odd.getBackAwayWin()) {
			if (odd.getBackAwayWin() > odd.getBackHomeWin()) {
				this.setOddWeightLOSE(cutOff.getOddWightHigherValue());
				this.setOddWeightDRAW(cutOff.getOddWightHigherValue());
				this.setOddWeightWIN(cutOff.getOddWightMediumValue());
			} else {
				this.setOddWeightWIN(cutOff.getOddWightHigherValue());
				this.setOddWeightDRAW(cutOff.getOddWightMediumValue());
				this.setOddWeightLOSE(cutOff.getOddWightMediumValue());
			}
		} else {
			this.setOddWeightWIN(cutOff.getOddWightHigherValue());
			this.setOddWeightDRAW(cutOff.getOddWightHigherValue());
			this.setOddWeightLOSE(cutOff.getOddWightHigherValue());
		}
	}

	public void calculateNNOdds(Fixture f, CutOff cutOff, double neuralNetworkBackWIN, double neuralNetworkBackDRAW,
			double neuralNetworkBackLOSE, double neuralNetworkLayWIN, double neuralNetworkLayDRAW,
			double neuralNetworkLayLOSE) {

		if (f.getOdd().getBackHomeWin() < cutOff.getMinimumBackOdd()) {
			this.setBackWinNeuralNetworkOdd(0);
		} else {
			this.setBackWinNeuralNetworkOdd(neuralNetworkBackWIN);
		}
		if (f.getOdd().getBackDraw() < cutOff.getMinimumBackOdd()) {
			this.setBackDrawNeuralNetworkOdd(0);
		} else {
			this.setBackDrawNeuralNetworkOdd(neuralNetworkBackDRAW);
		}
		if (f.getOdd().getBackAwayWin() < cutOff.getMinimumBackOdd()) {
			this.setBackLoseNeuralNetworkOdd(0);
		} else {
			this.setBackLoseNeuralNetworkOdd(neuralNetworkBackLOSE);
		}
		if (f.getOdd().getLayHomeWin() < cutOff.getMinimumLayOdd()) {
			this.setLayWinNeuralNetworkOdd(0);
		} else {
			this.setLayWinNeuralNetworkOdd(neuralNetworkLayWIN);
		}
		if (f.getOdd().getLayDraw() < cutOff.getMinimumLayOdd()) {
			this.setLayDrawNeuralNetworkOdd(0);
		} else {
			this.setLayDrawNeuralNetworkOdd(neuralNetworkLayDRAW);
		}
		if (f.getOdd().getLayAwayWin() < cutOff.getMinimumLayOdd()) {
			this.setLayLoseNeuralNetworkOdd(0);
		} else {
			this.setLayLoseNeuralNetworkOdd(neuralNetworkLayLOSE);
		}
	}

	public void calculateSimpleBetProcessedOdds(CutOff cutOff) {

		double backWinOdd = this.getBackWinOdd();
		double backDrawOdd = this.getBackDrawOdd();
		double backLoseOdd = this.getBackLoseOdd();
		double layWinOdd = this.getLayWinOdd();
		double layDrawOdd = this.getLayDrawOdd();
		double layLoseOdd = this.getLayLoseOdd();
		double nnBackWinOdd = this.getBackWinNeuralNetworkOdd();
		double nnBackDrawOdd = this.getBackDrawNeuralNetworkOdd();
		double nnBackLoseOdd = this.getBackLoseNeuralNetworkOdd();
		double nnLayWinOdd = this.getLayWinNeuralNetworkOdd();
		double nnLayDrawOdd = this.getLayDrawNeuralNetworkOdd();
		double nnLayLoseOdd = this.getLayLoseNeuralNetworkOdd();
		double boWin = this.getOddWeightWIN();
		double boDraw = this.getOddWeightDRAW();
		double boLose = this.getOddWeightLOSE();

		if (backWinOdd * nnBackWinOdd == 0) {
			this.setBackWinProcessedOdd(0);
		} else {
			this.setBackWinProcessedOdd((boWin * (backWinOdd - 1) + backWinOdd - 1)
					* (backWinOdd * cutOff.getNnOddWeight()));
		}
		if (backDrawOdd * nnBackDrawOdd == 0) {
			this.setBackDrawProcessedOdd(0);
		} else {
			this.setBackDrawProcessedOdd((boDraw * (backDrawOdd - 1) + backDrawOdd - 1)
					* (backDrawOdd  * cutOff.getNnOddWeight()));
		}
		if (backLoseOdd * nnBackLoseOdd == 0) {
			this.setBackLoseProcessedOdd(0);
		} else {
			this.setBackLoseProcessedOdd((boLose * (backLoseOdd - 1) + backLoseOdd - 1)
					* (backLoseOdd * cutOff.getNnOddWeight()));
		}
		if (layWinOdd * nnLayWinOdd == 0) {
			this.setLayWinProcessedOdd(0);
		} else {
			this.setLayWinProcessedOdd((boWin * (layWinOdd - 1) + layWinOdd - 1)
					* (layWinOdd * cutOff.getNnOddWeight()));
		}
		if (layDrawOdd * nnLayDrawOdd == 0) {
			this.setLayDrawProcessedOdd(0);
		} else {
			this.setLayDrawProcessedOdd((boDraw * (layDrawOdd - 1) + layDrawOdd - 1)
					* (layDrawOdd * cutOff.getNnOddWeight()));
		}
		if (layLoseOdd * nnLayLoseOdd == 0) {
			this.setLayLoseProcessedOdd(0);
		} else {
			this.setLayLoseProcessedOdd((boLose * (layLoseOdd - 1) + layLoseOdd - 1)
					* (layLoseOdd * cutOff.getNnOddWeight()));
		}
	}
	
	public void calculateMultipleBetProcessedOdds(CutOff cutOff) {

		double backWinOdd = this.getBackWinOdd();
		double backDrawOdd = this.getBackDrawOdd();
		double backLoseOdd = this.getBackLoseOdd();
		double layWinOdd = this.getLayWinOdd();
		double layDrawOdd = this.getLayDrawOdd();
		double layLoseOdd = this.getLayLoseOdd();
		double nnBackWinOdd = this.getBackWinNeuralNetworkOdd();
		double nnBackDrawOdd = this.getBackDrawNeuralNetworkOdd();
		double nnBackLoseOdd = this.getBackLoseNeuralNetworkOdd();
		double nnLayWinOdd = this.getLayWinNeuralNetworkOdd();
		double nnLayDrawOdd = this.getLayDrawNeuralNetworkOdd();
		double nnLayLoseOdd = this.getLayLoseNeuralNetworkOdd();
		double boWin = this.getOddWeightWIN();
		double boDraw = this.getOddWeightDRAW();
		double boLose = this.getOddWeightLOSE();

		if (backWinOdd * nnBackWinOdd == 0) {
			this.setBackWinProcessedOdd(0);
		} else {
			this.setBackWinProcessedOdd((boWin * backWinOdd) + (backWinOdd * cutOff.getNnOddWeight()));
		}
		if (backDrawOdd * nnBackDrawOdd == 0) {
			this.setBackDrawProcessedOdd(0);
		} else {
			this.setBackDrawProcessedOdd((boDraw * backDrawOdd)+ (backDrawOdd * cutOff.getNnOddWeight()));
		}
		if (backLoseOdd * nnBackLoseOdd == 0) {
			this.setBackLoseProcessedOdd(0);
		} else {
			this.setBackLoseProcessedOdd((boLose * backLoseOdd) + (backLoseOdd * cutOff.getNnOddWeight()));
		}
		if (layWinOdd * nnLayWinOdd == 0) {
			this.setLayWinProcessedOdd(0);
		} else {
			this.setLayWinProcessedOdd((boWin * layWinOdd) + (layWinOdd * cutOff.getNnOddWeight()));
		}
		if (layDrawOdd * nnLayDrawOdd == 0) {
			this.setLayDrawProcessedOdd(0);
		} else {
			this.setLayDrawProcessedOdd((boDraw * layDrawOdd) + (layDrawOdd * cutOff.getNnOddWeight()));
		}
		if (layLoseOdd * nnLayLoseOdd == 0) {
			this.setLayLoseProcessedOdd(0);
		} else {
			this.setLayLoseProcessedOdd((boLose * layLoseOdd) + (layLoseOdd * cutOff.getNnOddWeight()));
		}
	}
	
	public void simpleBetDecision(CutOff cutOff) {
		double backWinProcessedOdd = this.getBackWinProcessedOdd();
		double backDrawProcessedOdd = this.getBackDrawNeuralNetworkOdd();
		double backLoseProcessedOdd = this.getBackLoseProcessedOdd();
		double layWinProcessedOdd = this.getLayWinProcessedOdd();
		double layDrawProcessedOdd = this.getLayDrawProcessedOdd();
		double layLoseProcessedOdd = this.getLayLoseProcessedOdd();
		ArrayList<Double> processedOdds = new ArrayList<Double>();
		processedOdds.add(backWinProcessedOdd);
		processedOdds.add(backDrawProcessedOdd);
		processedOdds.add(backLoseProcessedOdd);
		processedOdds.add(layWinProcessedOdd);
		processedOdds.add(layDrawProcessedOdd);
		processedOdds.add(layLoseProcessedOdd);

		if (backWinProcessedOdd + backDrawProcessedOdd + backLoseProcessedOdd + layWinProcessedOdd + layDrawProcessedOdd
				+ layLoseProcessedOdd == 0 || this.hasManyMax(processedOdds, this.getMaxValue(processedOdds))) {
			this.setBackWinBet(false);
			this.setBackDrawBet(false);
			this.setBackLoseBet(false);
			this.setLayWinBet(false);
			this.setLayDrawBet(false);
			this.setLayLoseBet(false);
		} else if (backWinProcessedOdd == this.getMaxValue(processedOdds)) {
			if (backWinProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				this.setLayLoseBet(true);
			}
		} else if (backDrawProcessedOdd == this.getMaxValue(processedOdds)) {
			if (backDrawProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				this.setBackDrawBet(true);
			}
		} else if (backLoseProcessedOdd == this.getMaxValue(processedOdds)) {
			if (backLoseProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				this.setBackLoseBet(true);
			}
		} else if (layWinProcessedOdd == this.getMaxValue(processedOdds)) {
			if (layWinProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				this.setLayWinBet(true);
			}
		} else if (layDrawProcessedOdd == this.getMaxValue(processedOdds)) {
			if (layDrawProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				this.setLayDrawBet(true);
			}
		} else if (layLoseProcessedOdd == this.getMaxValue(processedOdds)) {
			if (layLoseProcessedOdd >= cutOff.getMinimumQualityRelation()) {
				this.setLayLoseBet(true);
			}
		}
	}

	public void runAlgorithm(Fixture fixture, CutOff cutOffSimple, CutOff cutOffMultiple, double neuralNetworkBackWIN, double neuralNetworkBackDRAW,
			double neuralNetworkBackLOSE, double neuralNetworkLayWIN, double neuralNetworkLayDRAW,
			double neuralNetworkLayLOSE) {
		atributeOddWeightCutOff(fixture, cutOffSimple);
		calculateNNOdds(fixture, cutOffSimple, neuralNetworkBackWIN, neuralNetworkBackDRAW, neuralNetworkBackLOSE,
				neuralNetworkLayWIN, neuralNetworkLayDRAW, neuralNetworkLayLOSE);
		calculateSimpleBetProcessedOdds(cutOffSimple);
		simpleBetDecision(cutOffSimple);
		calculateMultipleBetProcessedOdds(cutOffMultiple);
	}

	/****************/
	/* AUX METHODS */
	/****************/

	public boolean hasManyMax(ArrayList<Double> list, Double max) {
		int count = 0;
		boolean hasManyMax = false;
		for (Double listUnit : list) {
			if (listUnit == max) {
				count++;
			}
			if (count > 1){
				hasManyMax = true;
			}
		}
		return hasManyMax;
	}

	public double getMaxValue(ArrayList<Double> list) {
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

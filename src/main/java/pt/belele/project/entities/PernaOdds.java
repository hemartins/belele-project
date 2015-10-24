package pt.belele.project.entities;

public class PernaOdds {

	private double neuralNetworkBackWIN, neuralNetworkBackDRAW,
			neuralNetworkBackLOSE, neuralNetworkLayWIN, neuralNetworkLayDRAW,
			neuralNetworkLayLOSE;

	public PernaOdds(double neuralNetworkBackWIN, double neuralNetworkBackDRAW,
			double neuralNetworkBackLOSE, double neuralNetworkLayWIN,
			double neuralNetworkLayDRAW, double neuralNetworkLayLOSE) {
		this.neuralNetworkBackWIN = neuralNetworkBackWIN;
		this.neuralNetworkBackDRAW = neuralNetworkBackDRAW;
		this.neuralNetworkBackLOSE = neuralNetworkBackLOSE;
		this.neuralNetworkLayWIN = neuralNetworkLayWIN;
		this.neuralNetworkLayDRAW = neuralNetworkLayDRAW;
		this.neuralNetworkLayLOSE = neuralNetworkLayLOSE;
	}

	public double getNeuralNetworkBackWIN() {
		return neuralNetworkBackWIN;
	}

	public void setNeuralNetworkBackWIN(double neuralNetworkBackWIN) {
		this.neuralNetworkBackWIN = neuralNetworkBackWIN;
	}

	public double getNeuralNetworkBackDRAW() {
		return neuralNetworkBackDRAW;
	}

	public void setNeuralNetworkBackDRAW(double neuralNetworkBackDRAW) {
		this.neuralNetworkBackDRAW = neuralNetworkBackDRAW;
	}

	public double getNeuralNetworkBackLOSE() {
		return neuralNetworkBackLOSE;
	}

	public void setNeuralNetworkBackLOSE(double neuralNetworkBackLOSE) {
		this.neuralNetworkBackLOSE = neuralNetworkBackLOSE;
	}

	public double getNeuralNetworkLayWIN() {
		return neuralNetworkLayWIN;
	}

	public void setNeuralNetworkLayWIN(double neuralNetworkLayWIN) {
		this.neuralNetworkLayWIN = neuralNetworkLayWIN;
	}

	public double getNeuralNetworkLayDRAW() {
		return neuralNetworkLayDRAW;
	}

	public void setNeuralNetworkLayDRAW(double neuralNetworkLayDRAW) {
		this.neuralNetworkLayDRAW = neuralNetworkLayDRAW;
	}

	public double getNeuralNetworkLayLOSE() {
		return neuralNetworkLayLOSE;
	}

	public void setNeuralNetworkLayLOSE(double neuralNetworkLayLOSE) {
		this.neuralNetworkLayLOSE = neuralNetworkLayLOSE;
	}

}

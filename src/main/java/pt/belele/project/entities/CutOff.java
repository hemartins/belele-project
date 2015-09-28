package pt.belele.project.entities;

public class CutOff {
	
	Double betfairOpinionWIN;
	Double betfairOpinionDRAW;
	Double betfairOpinionLOSE;
	Double minimumLayOdd;
	Double minimumBackOdd;
	Double relationQuality;
	
	public Double getBetfairOpinionWIN() {
		return betfairOpinionWIN;
	}

	public void setBetfairOpinionWIN(Double betfairOpinionWIN) {
		this.betfairOpinionWIN = betfairOpinionWIN;
	}

	public Double getBetfairOpinionDRAW() {
		return betfairOpinionDRAW;
	}

	public void setBetfairOpinionDRAW(Double betfairOpinionDRAW) {
		this.betfairOpinionDRAW = betfairOpinionDRAW;
	}

	public Double getBetfairOpinionLOSE() {
		return betfairOpinionLOSE;
	}

	public void setBetfairOpinionLOSE(Double betfairOpinionLOSE) {
		this.betfairOpinionLOSE = betfairOpinionLOSE;
	}

	public Double getMinimumLayOdd() {
		return minimumLayOdd;
	}

	public void setMinimumLayOdd(Double minimumLayOdd) {
		this.minimumLayOdd = minimumLayOdd;
	}

	public Double getMinimumBackOdd() {
		return minimumBackOdd;
	}

	public void setMinimumBackOdd(Double minimumBackOdd) {
		this.minimumBackOdd = minimumBackOdd;
	}

	public Double getRelationQuality() {
		return relationQuality;
	}

	public void setRelationQuality(Double relationQuality) {
		this.relationQuality = relationQuality;
	}

}

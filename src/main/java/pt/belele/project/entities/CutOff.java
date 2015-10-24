package pt.belele.project.entities;

public class CutOff {

	private Double oddWightHigherValue; // ENTRE -0,9999999999 e 3

	private Double oddWightMediumValue;// ENTRE -0,9999999999 e 3

	private Double oddWightLowerValue; // ENTRE -0,9999999999 e 3

	private Double minimumLayOdd; // ENTRE 1 e 1,5

	private Double minimumBackOdd; // ENTRE 1 e 1,5 

	private Double nnOddWeight; // ENTRE 0 e 1

	private Double minimumQualityRelation; // ENTRE 0 e 1

	public CutOff() {

	}

	public CutOff(Double oddWightHigherValue, Double oddWightMediumValue,
			Double oddWightLowerValue, Double minimumLayOdd,
			Double minimumBackOdd, Double nnOddWeight,
			Double minimumQualityRelation) {
		this.oddWightHigherValue = oddWightHigherValue;
		this.oddWightMediumValue = oddWightMediumValue;
		this.oddWightLowerValue = oddWightLowerValue;
		this.minimumLayOdd = minimumLayOdd;
		this.minimumBackOdd = minimumBackOdd;
		this.nnOddWeight = nnOddWeight;
		this.minimumQualityRelation = minimumQualityRelation;
	}

	public Double getOddWightHigherValue() {
		return oddWightHigherValue;
	}

	public void setOddWightHigherValue(Double oddWightHigherValue) {
		this.oddWightHigherValue = oddWightHigherValue;
	}

	public Double getOddWightMediumValue() {
		return oddWightMediumValue;
	}

	public void setOddWightMediumValue(Double oddWightMediumValue) {
		this.oddWightMediumValue = oddWightMediumValue;
	}

	public Double getOddWightLowerValue() {
		return oddWightLowerValue;
	}

	public void setOddWightLowerValue(Double oddWightLowerValue) {
		this.oddWightLowerValue = oddWightLowerValue;
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

	public Double getNnOddWeight() {
		return nnOddWeight;
	}

	public void setNnOddWeight(Double nnOddWeight) {
		this.nnOddWeight = nnOddWeight;
	}

	public Double getMinimumQualityRelation() {
		return minimumQualityRelation;
	}

	public void setMinimumQualityRelation(Double minimumQualityRelation) {
		this.minimumQualityRelation = minimumQualityRelation;
	}
}

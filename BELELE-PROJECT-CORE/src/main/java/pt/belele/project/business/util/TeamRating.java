package pt.belele.project.business.util;

public class TeamRating {

    private Double resultPercentage;
    private Double qualityAverage;
    private Double resultIntervalPercentage;
    private Integer resultIntervalGames;
    private Double resultDificulty;
    private Double resultInvervalDificulty;

    public TeamRating(Double resultPercentage, Double qualityAverage, Double resultIntervalPercentage, Integer resultIntervalGames, Double resultDificulty, Double resultInvervalDificulty) {
	this.resultPercentage = resultPercentage;
	this.qualityAverage = qualityAverage;
	this.resultIntervalPercentage = resultIntervalPercentage;
	this.resultIntervalGames = resultIntervalGames;
	this.resultDificulty = resultDificulty;
	this.resultInvervalDificulty = resultInvervalDificulty;
    }

    public Double getResultPercentage() {
	return resultPercentage;
    }

    public void setResultPercentage(Double resultPercentage) {
	this.resultPercentage = resultPercentage;
    }

    public Double getQualityAverage() {
	return qualityAverage;
    }

    public void setQualityAverage(Double qualityAverage) {
	this.qualityAverage = qualityAverage;
    }

    public Double getResultIntervalPercentage() {
	return resultIntervalPercentage;
    }

    public void setResultIntervalPercentage(Double resultIntervalPercentage) {
	this.resultIntervalPercentage = resultIntervalPercentage;
    }

    public Integer getResultIntervalGames() {
	return resultIntervalGames;
    }

    public void setResultIntervalGames(Integer resultIntervalGames) {
	this.resultIntervalGames = resultIntervalGames;
    }

    public Double getResultDificulty() {
	return resultDificulty;
    }

    public void setResultDificulty(Double resultDificulty) {
	this.resultDificulty = resultDificulty;
    }

    public Double getResultInvervalDificulty() {
	return resultInvervalDificulty;
    }

    public void setResultInvervalDificulty(Double resultInvervalDificulty) {
	this.resultInvervalDificulty = resultInvervalDificulty;
    }

}

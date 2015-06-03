package pt.belele.project.controllers.util;

public class TeamRating
{
	private Double resultPercentage;
	private Double qualityAverage;
	private Double resultIntervalPercentage;
	private Integer resultIntervalGames;

	public TeamRating(Double resultPercentage, Double qualityAverage, Double resultIntervalPercentage, Integer resultIntervalGames)
	{
		this.resultPercentage = resultPercentage;
		this.qualityAverage = qualityAverage;
		this.resultIntervalPercentage = resultIntervalPercentage;
		this.resultIntervalGames = resultIntervalGames;
	}

	public Double getResultPercentage()
	{
		return resultPercentage;
	}

	public void setResultPercentage(Double resultPercentage)
	{
		this.resultPercentage = resultPercentage;
	}

	public Double getQualityAverage()
	{
		return qualityAverage;
	}

	public void setQualityAverage(Double qualityAverage)
	{
		this.qualityAverage = qualityAverage;
	}

	public Double getResultIntervalPercentage()
	{
		return resultIntervalPercentage;
	}

	public void setResultIntervalPercentage(Double resultIntervalPercentage)
	{
		this.resultIntervalPercentage = resultIntervalPercentage;
	}

	public Integer getResultIntervalGames()
	{
		return resultIntervalGames;
	}

	public void setResultIntervalGames(Integer resultIntervalGames)
	{
		this.resultIntervalGames = resultIntervalGames;
	}

}

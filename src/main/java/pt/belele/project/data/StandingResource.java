package pt.belele.project.data;

import ch.halarious.core.HalLink;
import ch.halarious.core.HalResource;

public class StandingResource implements HalResource
{
	@HalLink
	private String team;
	
	private Integer position;
	
	private String teamName;
	
	private Integer playedGames;
	
	private Integer points;
	
	private Integer goals;
	
	private Integer goalsAgainst;
	
	private Integer goalDifference;

	public String getTeam()
	{
		return team;
	}

	public void setTeam(String team)
	{
		this.team = team;
	}

	public Integer getPosition()
	{
		return position;
	}

	public void setPosition(Integer position)
	{
		this.position = position;
	}

	public String getTeamName()
	{
		return teamName;
	}

	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}

	public Integer getPlayedGames()
	{
		return playedGames;
	}

	public void setPlayedGames(Integer playedGames)
	{
		this.playedGames = playedGames;
	}

	public Integer getPoints()
	{
		return points;
	}

	public void setPoints(Integer points)
	{
		this.points = points;
	}

	public Integer getGoals()
	{
		return goals;
	}

	public void setGoals(Integer goals)
	{
		this.goals = goals;
	}

	public Integer getGoalsAgainst()
	{
		return goalsAgainst;
	}

	public void setGoalsAgainst(Integer goalsAgainst)
	{
		this.goalsAgainst = goalsAgainst;
	}

	public Integer getGoalDifference()
	{
		return goalDifference;
	}

	public void setGoalDifference(Integer goalDifference)
	{
		this.goalDifference = goalDifference;
	}
}

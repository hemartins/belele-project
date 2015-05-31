package pt.belele.project.data;

import pt.belele.project.resources.StandingResource;
import pt.belele.project.resources.TeamResource;
import pt.belele.project.util.HttpUtil;

public class Standing
{
	private StandingResource standing;

	private Team team;

	public Standing(StandingResource standing)
	{
		this.standing = standing;
	}

	public Team getTeam()
	{
		if (team == null)
			this.team = getTeamResource();
		return team;
	}

	public Integer getPosition()
	{
		return standing.getPosition();
	}

	public String getTeamName()
	{
		return standing.getTeamName();
	}

	public Integer getPlayedGames()
	{
		return standing.getPlayedGames();
	}

	public Integer getPoints()
	{
		return standing.getPoints();
	}

	public Integer getGoals()
	{
		return standing.getGoals();
	}

	public Integer getGoalsAgainst()
	{
		return standing.getGoalsAgainst();
	}

	public Integer getGoalDifference()
	{
		return standing.getGoalDifference();
	}

	private Team getTeamResource()
	{
		return new Team((TeamResource) HttpUtil.doGet(standing.getTeam(), TeamResource.class));
	}
}

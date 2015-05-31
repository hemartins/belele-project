package pt.belele.project.data;

import pt.belele.project.resources.SeasonResource;
import pt.belele.project.resources.TeamResource;
import pt.belele.project.resources.TeamsResource;
import pt.belele.project.util.HttpUtil;

public class SeasonTeams
{
	private TeamsResource teams;

	private Season season;

	public SeasonTeams(TeamsResource teams)
	{
		this.teams = teams;
	}

	public Season getSeason()
	{
		if (season == null)
			this.season = getSeasonResource();
		return season;
	}

	public int getCount()
	{
		return teams.getCount();
	}

	public TeamResource[] getTeams()
	{
		return teams.getTeams();
	}

	private Season getSeasonResource()
	{
		return new Season((SeasonResource) HttpUtil.doGet(teams.getSoccerseason(), SeasonResource.class));
	}
}

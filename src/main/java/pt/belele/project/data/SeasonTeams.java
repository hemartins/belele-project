package pt.belele.project.data;

import java.util.List;

import pt.belele.project.resources.SeasonResource;
import pt.belele.project.resources.TeamResource;
import pt.belele.project.resources.TeamsResource;
import pt.belele.project.util.HttpUtil;

public class SeasonTeams
{
	private TeamsResource teams;

	public SeasonTeams(TeamsResource teams)
	{
		this.teams = teams;
	}

	public Season getSeason()
	{
		return new Season((SeasonResource) HttpUtil.doGet(teams.getSoccerseason(), SeasonResource.class));
	}
	
	public int getCount(){
		return teams.getCount();
	}
	
	public List<TeamResource> getTeams(){
		return teams.getTeams();
	}
}

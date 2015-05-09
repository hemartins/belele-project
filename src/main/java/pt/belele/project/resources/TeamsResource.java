package pt.belele.project.resources;

import java.util.List;

import ch.halarious.core.HalLink;
import ch.halarious.core.HalResource;

public class TeamsResource implements HalResource
{
	@HalLink
	private String self;

	@HalLink
	private String soccerseason;

	private Integer count;

	private List<TeamResource> teams;

	public String getSelf()
	{
		return self;
	}

	public void setSelf(String self)
	{
		this.self = self;
	}

	public String getSoccerseason()
	{
		return soccerseason;
	}

	public void setSoccerseason(String soccerseason)
	{
		this.soccerseason = soccerseason;
	}

	public Integer getCount()
	{
		return count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
	}

	public List<TeamResource> getTeams()
	{
		return teams;
	}

	public void setTeams(List<TeamResource> teams)
	{
		this.teams = teams;
	}
}

package pt.belele.project.resources;

import java.util.List;

import ch.halarious.core.HalLink;
import ch.halarious.core.HalResource;

public class LeagueTableResource implements HalResource
{
	@HalLink
	private String self;
	
	@HalLink
	private String soccerseason;
	
	private String leagueCaption;
	
	private Integer matchday;
	
	private List<StandingResource> standing;

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

	public String getLeagueCaption()
	{
		return leagueCaption;
	}

	public void setLeagueCaption(String leagueCaption)
	{
		this.leagueCaption = leagueCaption;
	}

	public Integer getMatchday()
	{
		return matchday;
	}

	public void setMatchday(Integer matchday)
	{
		this.matchday = matchday;
	}

	public List<StandingResource> getStanding()
	{
		return standing;
	}

	public void setStanding(List<StandingResource> standing)
	{
		this.standing = standing;
	}
}

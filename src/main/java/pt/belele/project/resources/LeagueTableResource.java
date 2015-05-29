package pt.belele.project.resources;

import java.util.List;

public class LeagueTableResource
{
	private LeagueTableLinks _links;

	private String leagueCaption;

	private Integer matchday;

	private List<StandingResource> standing;

	public LeagueTableResource()
	{

	}

	public LeagueTableLinks get_links()
	{
		return _links;
	}

	public void set_links(LeagueTableLinks _links)
	{
		this._links = _links;
	}

	public String getSelf()
	{
		return _links.getSelf();
	}

	public String getSoccerseason()
	{
		return _links.getSoccerseason();
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

package pt.belele.project.resources;

import org.joda.time.DateTime;

import pt.belele.project.enums.FixtureStatus;

public class FixtureResource
{
	private LinksResource _links;

	private DateTime date;

	private FixtureStatus status;

	private Integer matchday;

	private String homeTeamName;

	private String awayTeamName;

	private Result result;

	public FixtureResource()
	{

	}

	public LinksResource get_links()
	{
		return _links;
	}

	public void set_links(LinksResource _links)
	{
		this._links = _links;
	}

	public String getSelf()
	{
		return _links.getSelf().getHref();
	}

	public String getSoccerseason()
	{
		return _links.getSoccerseason().getHref();
	}

	public String getHomeTeam()
	{
		return _links.getHomeTeam().getHref();
	}

	public String getAwayTeam()
	{
		return _links.getAwayTeam().getHref();
	}

	public DateTime getDate()
	{
		return date;
	}

	public void setDate(DateTime date)
	{
		this.date = date;
	}

	public FixtureStatus getStatus()
	{
		return status;
	}

	public void setStatus(FixtureStatus status)
	{
		this.status = status;
	}

	public Integer getMatchday()
	{
		return matchday;
	}

	public void setMatchday(Integer matchday)
	{
		this.matchday = matchday;
	}

	public String getHomeTeamName()
	{
		return homeTeamName;
	}

	public void setHomeTeamName(String homeTeamName)
	{
		this.homeTeamName = homeTeamName;
	}

	public String getAwayTeamName()
	{
		return awayTeamName;
	}

	public void setAwayTeamName(String awayTeamName)
	{
		this.awayTeamName = awayTeamName;
	}

	public Result getResult()
	{
		return result;
	}

	public void setResult(Result result)
	{
		this.result = result;
	}
}

package pt.belele.project.resources;

import org.joda.time.DateTime;

import pt.belele.project.enums.FixtureStatus;
import ch.halarious.core.HalLink;
import ch.halarious.core.HalResource;

public class FixtureResource implements HalResource
{
	@HalLink
	private String self;
	
	@HalLink
	private String soccerseason;
	
	@HalLink
	private String homeTeam;
	
	@HalLink
	private String awayTeam;
	
	private DateTime date;
	
	private FixtureStatus status;
	
	private Integer matchday;
	
	private String homeTeamName;
	
	private String awayTeamName;
	
	private Result result;

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

	public String getHomeTeam()
	{
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam)
	{
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam()
	{
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam)
	{
		this.awayTeam = awayTeam;
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

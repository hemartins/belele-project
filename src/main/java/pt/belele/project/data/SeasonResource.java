package pt.belele.project.data;

import org.joda.time.DateTime;

import ch.halarious.core.HalLink;
import ch.halarious.core.HalResource;

public class SeasonResource implements HalResource
{
	@HalLink
	private String self;

	@HalLink
	private String teams;

	@HalLink
	private String fixtures;

	@HalLink
	private String leagueTable;

	private String caption;

	private String league;

	private String year;

	private Integer numberOfTeams;

	private Integer numberOfGames;

	private DateTime lastUpdated;

	public String getSelf()
	{
		return self;
	}

	public void setSelf(String self)
	{
		this.self = self;
	}

	public String getTeams()
	{
		return teams;
	}

	public void setTeams(String teams)
	{
		this.teams = teams;
	}

	public String getFixtures()
	{
		return fixtures;
	}

	public void setFixtures(String fixtures)
	{
		this.fixtures = fixtures;
	}

	public String getLeagueTable()
	{
		return leagueTable;
	}

	public void setLeagueTable(String leagueTable)
	{
		this.leagueTable = leagueTable;
	}

	public String getCaption()
	{
		return caption;
	}

	public void setCaption(String caption)
	{
		this.caption = caption;
	}

	public String getLeague()
	{
		return league;
	}

	public void setLeague(String league)
	{
		this.league = league;
	}

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	public Integer getNumberOfTeams()
	{
		return numberOfTeams;
	}

	public void setNumberOfTeams(Integer numberOfTeams)
	{
		this.numberOfTeams = numberOfTeams;
	}

	public Integer getNumberOfGames()
	{
		return numberOfGames;
	}

	public void setNumberOfGames(Integer numberOfGames)
	{
		this.numberOfGames = numberOfGames;
	}

	public DateTime getLastUpdated()
	{
		return lastUpdated;
	}

	public void setLastUpdated(DateTime lastUpdated)
	{
		this.lastUpdated = lastUpdated;
	}
}

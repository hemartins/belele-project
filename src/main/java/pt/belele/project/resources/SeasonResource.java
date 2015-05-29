package pt.belele.project.resources;

import org.joda.time.DateTime;

public class SeasonResource
{
	private LinksResource _links;

	private String caption;

	private String league;

	private String year;

	private Integer numberOfTeams;

	private Integer numberOfGames;

	private DateTime lastUpdated;

	public SeasonResource()
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

	public String getTeams()
	{
		return _links.getTeams().getHref();
	}

	public String getFixtures()
	{
		return _links.getFixtures().getHref();
	}

	public String getLeagueTable()
	{
		return _links.getLeagueTable().getHref();
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

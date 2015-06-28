package pt.belele.project.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.joda.time.DateTime;

import pt.belele.project.resources.FixtureResource;
import pt.belele.project.resources.LeagueTableResource;
import pt.belele.project.resources.SeasonFixtureResource;
import pt.belele.project.resources.SeasonResource;
import pt.belele.project.resources.SeasonsResource;
import pt.belele.project.resources.TeamResource;
import pt.belele.project.resources.TeamsResource;
import pt.belele.project.util.HttpUtil;

public class Season
{
	private static String API_ENDPOINT = "http://api.football-data.org/alpha/soccerseasons/";

	private SeasonResource season;

	private List<Team> teams;

	private List<Fixture> fixtures;

	private Map<Integer, List<Fixture>> matchdayFixtures;

	private LeagueTable leagueTable;

	private Map<Integer, LeagueTable> matchdayLeagueTable;

	public Season(String league, int year)
	{
		SeasonsResource seasons = getSeasons(year);
		for (SeasonResource season : seasons.getSeasons())
		{
			if (season.getLeague().equals(league))
			{
				this.season = season;
				this.matchdayFixtures = new HashMap<Integer, List<Fixture>>();
				this.matchdayLeagueTable = new HashMap<Integer, LeagueTable>();
				break;
			}
		}
	}

	public Season(SeasonResource season)
	{
		this.season = season;
		this.matchdayFixtures = new HashMap<Integer, List<Fixture>>();
		this.matchdayLeagueTable = new HashMap<Integer, LeagueTable>();
	}

	public List<Team> getTeams()
	{
		if (teams == null)
			this.teams = getTeamsResource();
		return teams;
	}

	public List<Fixture> getFixtures()
	{
		if (fixtures == null)
			this.fixtures = getFixturesResource();
		return fixtures;
	}

	public List<Fixture> getFixtures(int matchday)
	{
		if (!matchdayFixtures.containsKey(matchday))
		{
			matchdayFixtures.put(matchday, getFixturesResource(matchday));
		}
		return matchdayFixtures.get(matchday);
	}

	public LeagueTable getLeagueTable()
	{
		if (leagueTable == null)
			this.leagueTable = getLeagueTableResource();
		return leagueTable;
	}

	public LeagueTable getLeagueTable(int matchday)
	{
		if (!matchdayLeagueTable.containsKey(matchday))
		{
			matchdayLeagueTable.put(matchday, getLeagueTableResource(matchday));
		}
		return matchdayLeagueTable.get(matchday);
	}
	
	public Integer getId()
	{
		String self = season.get_links().getSelf().getHref();
		int pos =  self.lastIndexOf('/');
		return Integer.valueOf(self.substring(pos+1));
	}

	public String getCaption()
	{
		return season.getCaption();
	}

	public String getLeague()
	{
		return season.getLeague();
	}

	public String getYear()
	{
		return season.getYear();
	}

	public Integer getNumberOfTeams()
	{
		return season.getNumberOfTeams();
	}

	public Integer getNumberOfGames()
	{
		return season.getNumberOfGames();
	}

	public DateTime getLastUpdated()
	{
		return season.getLastUpdated();
	}

	private List<Team> getTeamsResource()
	{
		TeamsResource teams = (TeamsResource) HttpUtil.doGet(season.getTeams(), TeamsResource.class);
		List<Team> teamsList = new ArrayList<Team>();
		for (TeamResource t : teams.getTeams())
		{
			teamsList.add(new Team(t));
		}
		return teamsList;
	}

	private List<Fixture> getFixturesResource()
	{
		SeasonFixtureResource fixtures = (SeasonFixtureResource) HttpUtil.doGet(season.getFixtures(), SeasonFixtureResource.class);

		List<Fixture> fixtureList = new ArrayList<Fixture>();
		for (FixtureResource fix : fixtures.getFixtures())
		{
			fixtureList.add(new Fixture(fix));
		}

		return fixtureList;
	}

	private List<Fixture> getFixturesResource(int matchday)
	{
		MultivaluedMap<String, Object> params = new MultivaluedHashMap<String, Object>();
		params.add("matchday", matchday);
		SeasonFixtureResource fixtures = (SeasonFixtureResource) HttpUtil.doGet(season.getFixtures(), SeasonFixtureResource.class, params);

		List<Fixture> fixtureList = new ArrayList<Fixture>();
		for (FixtureResource fix : fixtures.getFixtures())
		{
			fixtureList.add(new Fixture(fix));
		}

		return fixtureList;
	}

	private LeagueTable getLeagueTableResource()
	{
		return new LeagueTable((LeagueTableResource) HttpUtil.doGet(season.getLeagueTable(), LeagueTableResource.class));
	}

	private LeagueTable getLeagueTableResource(int matchday)
	{
		MultivaluedMap<String, Object> params = new MultivaluedHashMap<String, Object>();
		params.add("matchday", matchday);
		return new LeagueTable((LeagueTableResource) HttpUtil.doGet(season.getLeagueTable(), LeagueTableResource.class, params));
	}

	private SeasonsResource getSeasons(int year)
	{
		MultivaluedMap<String, Object> params = new MultivaluedHashMap<String, Object>();
		params.add("season", year);
		SeasonResource[] arr = (SeasonResource[]) HttpUtil.doGet(API_ENDPOINT, SeasonResource[].class, params);
		SeasonsResource sr = new SeasonsResource();
		sr.setSeasons(arr);
		return sr;
	}
}

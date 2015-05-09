package pt.belele.project.data;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import pt.belele.project.resources.FixtureResource;
import pt.belele.project.resources.FixturesResource;
import pt.belele.project.resources.LeagueTableResource;
import pt.belele.project.resources.SeasonResource;
import pt.belele.project.resources.SeasonsResource;
import pt.belele.project.resources.TeamResource;
import pt.belele.project.resources.TeamsResource;
import pt.belele.project.util.HttpUtil;

public class Season
{
	private static String API_ENDPOINT = "http://api.football-data.org/alpha/soccerseasons/";

	private SeasonResource season;

	public Season(String league, int year)
	{
		SeasonsResource seasons = getSeasons(year);
		for (SeasonResource season : seasons.getSeasons())
		{
			if (season.getLeague().equals(league))
			{
				this.season = season;
			}
		}
		System.out.println("SEASON " + league + year + "NOT FOUND!");
	}

	public Season(SeasonResource season)
	{
		this.season = season;
	}

	public List<Team> getTeams()
	{
		TeamsResource teams = (TeamsResource) HttpUtil.doGet(season.getTeams(), TeamsResource.class);
		List<Team> teamsList = new ArrayList<Team>();
		for (TeamResource t : teams.getTeams())
		{
			teamsList.add(new Team(t));
		}
		return teamsList;
	}

	public List<Fixture> getFixtures()
	{
		FixturesResource fixtures = (FixturesResource) HttpUtil.doGet(season.getFixtures(), FixturesResource.class);

		List<Fixture> fixtureList = new ArrayList<Fixture>();
		for (FixtureResource fix : fixtures.getFixtures())
		{
			fixtureList.add(new Fixture(fix));
		}

		return fixtureList;
	}

	public LeagueTable getLeagueTable()
	{
		return new LeagueTable((LeagueTableResource) HttpUtil.doGet(season.getLeagueTable(), LeagueTableResource.class));
	}

	private SeasonsResource getSeasons(int year)
	{
		MultivaluedMap<String, Object> params = new MultivaluedHashMap<String, Object>();
		params.add("season", year);
		return (SeasonsResource) HttpUtil.doGet(API_ENDPOINT, SeasonResource.class, params);
	}
}

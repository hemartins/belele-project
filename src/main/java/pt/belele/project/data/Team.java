package pt.belele.project.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import pt.belele.project.enums.Venue;
import pt.belele.project.resources.FixtureResource;
import pt.belele.project.resources.TeamFixtureResource;
import pt.belele.project.resources.TeamResource;
import pt.belele.project.util.HttpUtil;

public class Team
{
	private TeamResource team;

	private List<Fixture> fixtures;

	private Map<Integer, List<Fixture>> seasonFixtures;

	private Map<Integer, List<Fixture>> seasonHomeFixtures;

	private Map<Integer, List<Fixture>> seasonAwayFixtures;

	public Team(TeamResource team)
	{
		this.team = team;
		this.seasonFixtures = new HashMap<Integer, List<Fixture>>();
		this.seasonHomeFixtures = new HashMap<Integer, List<Fixture>>();
		this.seasonAwayFixtures = new HashMap<Integer, List<Fixture>>();
	}

	public List<Fixture> getFixtures()
	{
		if (fixtures == null)
			this.fixtures = getFixturesResource();
		return fixtures;
	}

	public List<Fixture> getFixtures(int season, Venue venue)
	{
		if (venue == null)
		{
			if (!seasonFixtures.containsKey(season))
				seasonFixtures.put(season, getFixturesResource(season, venue));
			return seasonFixtures.get(season);
		} else
		{
			switch (venue)
			{
			case away:
				if (!seasonAwayFixtures.containsKey(season))
					seasonAwayFixtures.put(season, getFixturesResource(season, venue));
				return seasonAwayFixtures.get(season);
			case home:
				if (!seasonHomeFixtures.containsKey(season))
					seasonHomeFixtures.put(season, getFixturesResource(season, venue));
				return seasonHomeFixtures.get(season);
			default:
				return null;
			}
		}
	}

	// public List<Player> getPlayers(){}

	public String getName()
	{
		return team.getName();
	}

	public String getCode()
	{
		return team.getCode();
	}

	public String getShortName()
	{
		return team.getShortName();
	}

	public String getSquadMarketValue()
	{
		return team.getSquadMarketValue();
	}

	private List<Fixture> getFixturesResource()
	{
		TeamFixtureResource fixtures = (TeamFixtureResource) HttpUtil.doGet(team.getFixtures(), TeamFixtureResource.class);
		List<Fixture> fixtureList = new ArrayList<Fixture>();
		for (FixtureResource fix : fixtures.getFixtures())
		{
			fixtureList.add(new Fixture(fix));
		}

		return fixtureList;
	}

	private List<Fixture> getFixturesResource(int season, Venue venue)
	{
		MultivaluedMap<String, Object> params = new MultivaluedHashMap<String, Object>();
		params.add("season", season);
		params.add("venue", venue);
		TeamFixtureResource fixtures = (TeamFixtureResource) HttpUtil.doGet(team.getFixtures(), TeamFixtureResource.class);
		List<Fixture> fixtureList = new ArrayList<Fixture>();
		for (FixtureResource fix : fixtures.getFixtures())
		{
			fixtureList.add(new Fixture(fix));
		}

		return fixtureList;
	}
}
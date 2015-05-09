package pt.belele.project.data;

import java.util.ArrayList;
import java.util.List;

import pt.belele.project.resources.FixtureResource;
import pt.belele.project.resources.FixturesResource;
import pt.belele.project.resources.TeamResource;
import pt.belele.project.util.HttpUtil;

public class Team
{
	private TeamResource team;

	public Team(TeamResource team)
	{
		this.team = team;
	}

	public List<Fixture> getFixtures()
	{
		FixturesResource fixtures = (FixturesResource) HttpUtil.doGet(team.getFixtures(), FixturesResource.class);
		List<Fixture> fixtureList = new ArrayList<Fixture>();
		for (FixtureResource fix : fixtures.getFixtures())
		{
			fixtureList.add(new Fixture(fix));
		}

		return fixtureList;
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
}
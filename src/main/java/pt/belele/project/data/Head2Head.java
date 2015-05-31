package pt.belele.project.data;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import pt.belele.project.resources.FixtureResource;
import pt.belele.project.resources.Head2HeadResource;

public class Head2Head
{
	private Head2HeadResource h2hResource;

	public Head2Head(Head2HeadResource h2hResource)
	{
		this.h2hResource = h2hResource;
	}

	public Integer getCount()
	{
		return h2hResource.getCount();
	}

	public DateTime getTimeFrameStart()
	{
		return h2hResource.getTimeFrameStart();
	}

	public DateTime getTimeFrameEnd()
	{
		return h2hResource.getTimeFrameEnd();
	}

	public Integer getHomeTeamWins()
	{
		return h2hResource.getHomeTeamWins();
	}

	public Integer getAwayTeamWins()
	{
		return h2hResource.getAwayTeamWins();
	}

	public Integer getDraws()
	{
		return h2hResource.getDraws();
	}

	public FixtureResource getLastHomeWinHomeTeam()
	{
		return h2hResource.getLastHomeWinHomeTeam();
	}

	public FixtureResource getLastWinHomeTeam()
	{
		return h2hResource.getLastWinHomeTeam();
	}

	public FixtureResource getLastAwayWinAwayTeam()
	{
		return h2hResource.getLastAwayWinAwayTeam();
	}

	public FixtureResource getLastWinAwayTeam()
	{
		return h2hResource.getLastWinAwayTeam();
	}

	public List<Fixture> getFixtures()
	{
		List<Fixture> fixtures = new ArrayList<Fixture>();
		for (FixtureResource fixRes : h2hResource.getFixtures())
		{
			fixtures.add(new Fixture(fixRes));
		}
		return fixtures;
	}
}

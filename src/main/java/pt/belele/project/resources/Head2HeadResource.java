package pt.belele.project.resources;

import java.util.List;

import org.joda.time.DateTime;

public class Head2HeadResource
{
	private Integer count;

	private DateTime timeFrameStart;

	private DateTime timeFrameEnd;

	private Integer homeTeamWins;

	private Integer awayTeamWins;

	private Integer draws;

	private FixtureResource lastHomeWinHomeTeam;

	private FixtureResource lastWinHomeTeam;

	private FixtureResource lastAwayWinAwayTeam;

	private FixtureResource lastWinAwayTeam;

	private List<FixtureResource> fixtures;

	public Head2HeadResource()
	{

	}

	public Integer getCount()
	{
		return count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
	}

	public DateTime getTimeFrameStart()
	{
		return timeFrameStart;
	}

	public void setTimeFrameStart(DateTime timeFrameStart)
	{
		this.timeFrameStart = timeFrameStart;
	}

	public DateTime getTimeFrameEnd()
	{
		return timeFrameEnd;
	}

	public void setTimeFrameEnd(DateTime timeFrameEnd)
	{
		this.timeFrameEnd = timeFrameEnd;
	}

	public Integer getHomeTeamWins()
	{
		return homeTeamWins;
	}

	public void setHomeTeamWins(Integer homeTeamWins)
	{
		this.homeTeamWins = homeTeamWins;
	}

	public Integer getAwayTeamWins()
	{
		return awayTeamWins;
	}

	public void setAwayTeamWins(Integer awayTeamWins)
	{
		this.awayTeamWins = awayTeamWins;
	}

	public Integer getDraws()
	{
		return draws;
	}

	public void setDraws(Integer draws)
	{
		this.draws = draws;
	}

	public FixtureResource getLastHomeWinHomeTeam()
	{
		return lastHomeWinHomeTeam;
	}

	public void setLastHomeWinHomeTeam(FixtureResource lastHomeWinHomeTeam)
	{
		this.lastHomeWinHomeTeam = lastHomeWinHomeTeam;
	}

	public FixtureResource getLastWinHomeTeam()
	{
		return lastWinHomeTeam;
	}

	public void setLastWinHomeTeam(FixtureResource lastWinHomeTeam)
	{
		this.lastWinHomeTeam = lastWinHomeTeam;
	}

	public FixtureResource getLastAwayWinAwayTeam()
	{
		return lastAwayWinAwayTeam;
	}

	public void setLastAwayWinAwayTeam(FixtureResource lastAwayWinAwayTeam)
	{
		this.lastAwayWinAwayTeam = lastAwayWinAwayTeam;
	}

	public FixtureResource getLastWinAwayTeam()
	{
		return lastWinAwayTeam;
	}

	public void setLastWinAwayTeam(FixtureResource lastWinAwayTeam)
	{
		this.lastWinAwayTeam = lastWinAwayTeam;
	}

	public List<FixtureResource> getFixtures()
	{
		return fixtures;
	}

	public void setFixtures(List<FixtureResource> fixtures)
	{
		this.fixtures = fixtures;
	}
}

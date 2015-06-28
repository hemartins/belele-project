package pt.belele.project.data;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.joda.time.DateTime;

import pt.belele.project.enums.FixtureStatus;
import pt.belele.project.resources.FixtureResource;
import pt.belele.project.resources.Result;
import pt.belele.project.resources.SeasonResource;
import pt.belele.project.resources.TeamResource;
import pt.belele.project.util.HttpUtil;

public class Fixture
{
	private FixtureResource fixture;

	private Season season;

	private Team homeTeam;

	private Team awayTeam;

	private Head2Head head2head;

	public Fixture(FixtureResource fixture)
	{
		this.fixture = fixture;
	}

	public Season getSeason()
	{
		if (season == null)
			this.season = getSeasonResource();
		return season;
	}

	public Integer getSeasonId()
	{
		String self = fixture.getSoccerseason();
		int pos =  self.lastIndexOf('/');
		return Integer.valueOf(self.substring(pos+1));
	}
	
	public Team getHomeTeam()
	{
		if (homeTeam == null)
			this.homeTeam = getHomeTeamResource();
		return homeTeam;
	}
	
	public Integer getHomeTeamId()
	{
		String self = fixture.getHomeTeam();
		int pos =  self.lastIndexOf('/');
		return Integer.valueOf(self.substring(pos+1));
	}

	public Team getAwayTeam()
	{
		if (awayTeam == null)
			this.awayTeam = getAwayTeamResource();
		return awayTeam;
	}
	
	public Integer getAwayTeamId()
	{
		String self = fixture.getAwayTeam();
		int pos =  self.lastIndexOf('/');
		return Integer.valueOf(self.substring(pos+1));
	}

	public DateTime getDate()
	{
		return fixture.getDate();
	}

	public FixtureStatus getStatus()
	{
		return fixture.getStatus();
	}

	public Integer getMatchday()
	{
		return fixture.getMatchday();
	}

	public String getHomeTeamName()
	{
		return fixture.getHomeTeamName();
	}

	public String getAwayTeamName()
	{
		return fixture.getAwayTeamName();
	}

	public Result getResult()
	{
		return fixture.getResult();
	}

	public Head2Head getHead2Head()
	{
		if (head2head == null)
			this.head2head = getHead2HeadResource(5);
		return head2head;
	}

	private Season getSeasonResource()
	{
		return new Season((SeasonResource) HttpUtil.doGet(fixture.getSoccerseason(), SeasonResource.class));
	}

	private Team getHomeTeamResource()
	{
		return new Team((TeamResource) HttpUtil.doGet(fixture.getHomeTeam(), TeamResource.class));
	}

	private Team getAwayTeamResource()
	{
		return new Team((TeamResource) HttpUtil.doGet(fixture.getAwayTeam(), TeamResource.class));
	}

	private Head2Head getHead2HeadResource(Integer numberOfFixtures)
	{
		MultivaluedMap<String, Object> params = new MultivaluedHashMap<String, Object>();
		params.add("head2head", numberOfFixtures);
		pt.belele.project.resources.Fixture fixt = (pt.belele.project.resources.Fixture) HttpUtil.doGet(fixture.getSelf(),
				pt.belele.project.resources.Fixture.class);
		return new Head2Head(fixt.getHead2head());
	}
}

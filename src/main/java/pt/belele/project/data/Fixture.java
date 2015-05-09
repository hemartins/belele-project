package pt.belele.project.data;

import org.joda.time.DateTime;

import pt.belele.project.enums.FixtureStatus;
import pt.belele.project.resources.FixtureResource;
import pt.belele.project.resources.Head2Head;
import pt.belele.project.resources.Result;
import pt.belele.project.resources.SeasonResource;
import pt.belele.project.resources.TeamResource;
import pt.belele.project.util.HttpUtil;

public class Fixture
{
	private FixtureResource fixture;

	public Fixture(FixtureResource fixture)
	{
		this.fixture = fixture;
	}
	
	public Season getSeason()
	{
		return new Season((SeasonResource) HttpUtil.doGet(fixture.getSoccerseason(), SeasonResource.class));
	}
	
	public Team getHomeTeam(){
		return new Team((TeamResource) HttpUtil.doGet(fixture.getHomeTeam(), TeamResource.class));
	}
	
	public Team getAwayTeam(){
		return new Team((TeamResource) HttpUtil.doGet(fixture.getAwayTeam(), TeamResource.class));
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
	
	public Head2Head getHead2Head(){
		pt.belele.project.resources.Fixture fixt = (pt.belele.project.resources.Fixture) HttpUtil.doGet(fixture.getSelf(), pt.belele.project.resources.Fixture.class);
		return fixt.getHead2head();
	}
}

package pt.belele.project.data;

import java.util.ArrayList;
import java.util.List;

import pt.belele.project.resources.LeagueTableResource;
import pt.belele.project.resources.SeasonResource;
import pt.belele.project.resources.StandingResource;
import pt.belele.project.util.HttpUtil;

public class LeagueTable
{
	private LeagueTableResource leagueTable;

	public LeagueTable(LeagueTableResource leagueTable)
	{
		this.leagueTable = leagueTable;
	}

	public Season getSeason()
	{
		return new Season((SeasonResource) HttpUtil.doGet(leagueTable.getSoccerseason(), SeasonResource.class));
	}

	public String getLeagueCaption()
	{
		return leagueTable.getLeagueCaption();
	}

	public Integer getMatchday()
	{
		return leagueTable.getMatchday();
	}

	public List<Standing> getStanding()
	{
		List<StandingResource> standings = leagueTable.getStanding();
		List<Standing> standingList = new ArrayList<Standing>();
		for (StandingResource sta : standings)
		{
			standingList.add(new Standing(sta));
		}
		return standingList;
	}

}

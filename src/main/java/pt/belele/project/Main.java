package pt.belele.project;

import java.util.List;

import pt.belele.project.data.Fixture;
import pt.belele.project.data.LeagueTable;
import pt.belele.project.data.Season;
import pt.belele.project.data.Team;
import pt.belele.project.enums.League;

public class Main
{

	public static void main(String[] args)
	{   
		Season s = new Season(League.Portugal.PRIMEIRA_LIGA, 2014);
		LeagueTable table = s.getLeagueTable();
		List<Fixture> fixtures = s.getFixtures();
		List<Team> teams = s.getTeams();
	}

}

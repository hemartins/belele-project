package pt.belele.project;

import java.util.Date;
import java.util.List;

import pt.belele.project.controllers.FixtureController;
import pt.belele.project.controllers.ResultController;
import pt.belele.project.controllers.SeasonController;
import pt.belele.project.controllers.TeamController;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;
import pt.belele.project.util.CSVReader;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SeasonController seasonController = new SeasonController();
		TeamController teamController = new TeamController();
		FixtureController fixtureController = new FixtureController();
		ResultController resultController = new ResultController();

		List<String[]> list = CSVReader
				.readFromCSV("http://www.football-data.co.uk/mmz4281/1516/P1.csv");

		for (String[] arr : list) {
			Season s = seasonController.createSeason(arr[0], 15);
			Team t1 = teamController.createTeam(arr[2]);
			Team t2 = teamController.createTeam(arr[3]);
			seasonController.addTeam(s, t1);
			seasonController.addTeam(s, t2);
			Fixture fixture = fixtureController.createFixture(new Date(arr[1]),
					s, t1, t2);
			resultController.createResult(fixture, arr[4], arr[5], arr[7],
					arr[8]);
		}

	}
}
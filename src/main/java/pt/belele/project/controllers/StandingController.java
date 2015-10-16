package pt.belele.project.controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Standing;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.StandingDAO;

public class StandingController {

	private StandingDAO standingDAO;

	public StandingController(EntityManager em) {
		standingDAO = new StandingDAO(em);
	}

	public Standing createStanding(Team team, Season season, Fixture fixture) {

		try {
			standingDAO.findStanding(team.getId(), fixture.getDate(), season.getId());
		} catch (NoResultException e) {
			Standing newStanding = new Standing(season, team, fixture.getDate());
			calculateStandingValues(newStanding, fixture);
			standingDAO.insert(newStanding);
		}
		return standingDAO.findStanding(team.getId(), fixture.getDate(), season.getId());
	}

	public Standing getTeamStanding(Season season, Team team, Date date) {
		return standingDAO.findNewestByNameAndDate(team.getId(), date, season.getId());
	}

	public void calculateStandingValues(Standing standing, Fixture fixture) {
		Standing oldStanding = standingDAO.findNewestByNameAndDate(standing.getTeam().getId(), standing.getDate(),
				standing.getSeason().getId());
		if (oldStanding != null) {
			if (fixture.getHomeTeam().equals(standing.getTeam())) {
				standing.setPoints(calculatePoints(fixture, "Home") + oldStanding.getPoints());
				standing.setHomePoints(calculateHomePoints(fixture) + oldStanding.getHomePoints());
				standing.setGoals(oldStanding.getGoals() + fixture.getResult().getFullTimeHomeTeamGoals());
				standing.setGoalsAgainst(
						oldStanding.getGoalsAgainst() + fixture.getResult().getFullTimeAwayTeamGoals());
				standing.setHomeGoals(oldStanding.getGoals() + fixture.getResult().getFullTimeHomeTeamGoals());
				standing.setHomeGoalsAgainst(
						oldStanding.getGoalsAgainst() + fixture.getResult().getFullTimeAwayTeamGoals());
				standing.setHomePlayedGames(oldStanding.getHomePlayedGames() + 1);
				standing.setHomeGoalsDifference(standing.getHomeGoals() - standing.getHomeGoalsAgainst());
			} else if (fixture.getAwayTeam().equals(standing.getTeam())) {
				standing.setPoints(calculatePoints(fixture, "Away") + oldStanding.getPoints());
				standing.setAwayPoints(calculateHomePoints(fixture) + oldStanding.getAwayPoints());
				standing.setGoals(oldStanding.getGoals() + fixture.getResult().getFullTimeAwayTeamGoals());
				standing.setGoalsAgainst(
						oldStanding.getGoalsAgainst() + fixture.getResult().getFullTimeHomeTeamGoals());
				standing.setAwayGoals(oldStanding.getGoals() + fixture.getResult().getFullTimeHomeTeamGoals());
				standing.setAwayGoalsAgainst(
						oldStanding.getGoalsAgainst() + fixture.getResult().getFullTimeAwayTeamGoals());
				standing.setAwayPlayedGames(oldStanding.getAwayPlayedGames() + 1);
				standing.setAwayGoalsDifference(standing.getAwayGoals() - standing.getAwayGoalsAgainst());
			}
			standing.setPlayedGames(oldStanding.getPlayedGames() + 1);
			standing.setGoalsDifference(standing.getGoals() - standing.getGoalsAgainst());
		} else {
			if (fixture.getHomeTeam().equals(standing.getTeam())) {
				standing.setPoints(calculatePoints(fixture, "Home"));
				standing.setHomePoints(calculateHomePoints(fixture));
				standing.setGoals(fixture.getResult().getFullTimeHomeTeamGoals());
				standing.setGoalsAgainst(fixture.getResult().getFullTimeAwayTeamGoals());
				standing.setHomeGoals(fixture.getResult().getFullTimeHomeTeamGoals());
				standing.setHomeGoalsAgainst(fixture.getResult().getFullTimeAwayTeamGoals());
				standing.setHomePlayedGames(1);
				standing.setHomeGoalsDifference(standing.getHomeGoals() - standing.getHomeGoalsAgainst());
			} else if (fixture.getAwayTeam().equals(standing.getTeam())) {
				standing.setPoints(calculatePoints(fixture, "Away"));
				standing.setHomePoints(calculateAwayPoints(fixture));
				standing.setGoals(fixture.getResult().getFullTimeAwayTeamGoals());
				standing.setGoalsAgainst(fixture.getResult().getFullTimeHomeTeamGoals());
				standing.setAwayGoals(fixture.getResult().getFullTimeAwayTeamGoals());
				standing.setAwayGoalsAgainst(fixture.getResult().getFullTimeHomeTeamGoals());
				standing.setAwayPlayedGames(1);
				standing.setAwayGoalsDifference(standing.getAwayGoals() - standing.getAwayGoalsAgainst());
			}
			standing.setPlayedGames(1);
			standing.setGoalsDifference(standing.getGoals() - standing.getGoalsAgainst());
		}
	}

	public int calculatePoints(Fixture fixture, String HomeAway) {

		Result result = fixture.getResult();

		if (result.getFullTimeHomeTeamGoals() > result.getFullTimeAwayTeamGoals()) {
			if (HomeAway.equals("Home")) {
				return 3;
			} else {
				return 0;
			}
		} else if (result.getFullTimeHomeTeamGoals() == fixture.getResult().getFullTimeAwayTeamGoals()) {
			return 1;
		} else {
			if (HomeAway.equals("Home")) {
				return 0;
			} else {
				return 3;
			}
		}
	}

	public int calculateHomePoints(Fixture fixture) {
		
		Result result = fixture.getResult();
		
		if (result.getFullTimeHomeTeamGoals() > result.getFullTimeAwayTeamGoals()) {
			return 3;
		} else if (result.getFullTimeHomeTeamGoals() == fixture.getResult().getFullTimeAwayTeamGoals()) {
			return 1;
		} else {
			return 0;
		}
	}

	public int calculateAwayPoints(Fixture fixture) {
		Result result = fixture.getResult();
		
		if (result.getFullTimeHomeTeamGoals() > result.getFullTimeAwayTeamGoals()) {
			return 0;
		} else if (result.getFullTimeHomeTeamGoals() == fixture.getResult().getFullTimeAwayTeamGoals()) {
			return 1;
		} else {
			return 3;
		}
	}
	
	public List<Standing> getStandingsByClassification(Season s, Team t, Date date){
		return standingDAO.getStandingsByPoints(date, s.getId());
	}

}

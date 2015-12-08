package pt.belele.project.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.joda.time.DateTime;
import pt.belele.project.business.exception.BeleleException;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Standing;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.StandingDAO;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class StandingControllerBean implements StandingController {

    @EJB
    private StandingDAO standingDAO;

    @Override
    public Standing createStanding(Team team, Season season, Fixture fixture) {
	Standing standing;
	try {
	    standing = standingDAO.findStanding(team.getId(), fixture.getDate(), season.getId());
	} catch (BeleleException e) {
	    Standing newStanding = new Standing(season, team, fixture.getDate());
	    calculateStandingValues(newStanding, fixture);
	    standing = standingDAO.insert(newStanding);
	}
	return standing;
    }

    @Override
    public Standing getTeamStanding(Season season, Team team, DateTime date) {
	return standingDAO.findNewestByNameAndDate(team.getId(), date, season.getId());
    }

    @Override
    public void calculateStandingValues(Standing standing, Fixture fixture) {
	Standing oldStanding = standingDAO.findNewestByNameAndDate(standing.getTeam().getId(), standing.getDate(), standing.getSeason().getId());
	if (oldStanding != null) {
	    if (fixture.getHomeTeam().equals(standing.getTeam())) {
		standing.setPoints(calculatePoints(fixture, "Home") + oldStanding.getPoints());
		standing.setHomePoints(calculateHomePoints(fixture) + oldStanding.getHomePoints());
		standing.setGoals(oldStanding.getGoals() + fixture.getResult().getFullTimeHomeTeamGoals());
		standing.setGoalsAgainst(oldStanding.getGoalsAgainst() + fixture.getResult().getFullTimeAwayTeamGoals());
		standing.setHomeGoals(oldStanding.getHomeGoals() + fixture.getResult().getFullTimeHomeTeamGoals());
		standing.setHomeGoalsAgainst(oldStanding.getHomeGoalsAgainst() + fixture.getResult().getFullTimeAwayTeamGoals());
		standing.setHomePlayedGames(oldStanding.getHomePlayedGames() + 1);
		standing.setAwayGoals(oldStanding.getAwayGoals());
		standing.setAwayGoalsAgainst(oldStanding.getAwayGoalsAgainst());
		standing.setAwayPlayedGames(oldStanding.getAwayPlayedGames());
		standing.setAwayPoints(oldStanding.getAwayPoints());
	    } else if (fixture.getAwayTeam().equals(standing.getTeam())) {
		standing.setPoints(calculatePoints(fixture, "Away") + oldStanding.getPoints());
		standing.setAwayPoints(calculateAwayPoints(fixture) + oldStanding.getAwayPoints());
		standing.setGoals(oldStanding.getGoals() + fixture.getResult().getFullTimeAwayTeamGoals());
		standing.setGoalsAgainst(oldStanding.getGoalsAgainst() + fixture.getResult().getFullTimeHomeTeamGoals());
		standing.setAwayGoals(oldStanding.getAwayGoals() + fixture.getResult().getFullTimeAwayTeamGoals());
		standing.setAwayGoalsAgainst(oldStanding.getAwayGoalsAgainst() + fixture.getResult().getFullTimeHomeTeamGoals());
		standing.setAwayPlayedGames(oldStanding.getAwayPlayedGames() + 1);
		standing.setHomeGoals(oldStanding.getHomeGoals());
		standing.setHomeGoalsAgainst(oldStanding.getHomeGoalsAgainst());
		standing.setHomePlayedGames(oldStanding.getHomePlayedGames());
		standing.setHomePoints(oldStanding.getHomePoints());
	    }
	    standing.setPlayedGames(oldStanding.getPlayedGames() + 1);
	} else {
	    if (fixture.getHomeTeam().equals(standing.getTeam())) {
		standing.setPoints(calculatePoints(fixture, "Home"));
		standing.setHomePoints(calculateHomePoints(fixture));
		standing.setAwayPoints(0);
		standing.setGoals(fixture.getResult().getFullTimeHomeTeamGoals());
		standing.setGoalsAgainst(fixture.getResult().getFullTimeAwayTeamGoals());
		standing.setHomeGoals(fixture.getResult().getFullTimeHomeTeamGoals());
		standing.setHomeGoalsAgainst(fixture.getResult().getFullTimeAwayTeamGoals());
		standing.setHomePlayedGames(1);
		standing.setAwayGoals(0);
		standing.setAwayGoalsAgainst(0);
		standing.setAwayPlayedGames(0);
	    } else if (fixture.getAwayTeam().equals(standing.getTeam())) {
		standing.setPoints(calculatePoints(fixture, "Away"));
		standing.setAwayPoints(calculateAwayPoints(fixture));
		standing.setHomePoints(0);
		standing.setGoals(fixture.getResult().getFullTimeAwayTeamGoals());
		standing.setGoalsAgainst(fixture.getResult().getFullTimeHomeTeamGoals());
		standing.setAwayGoals(fixture.getResult().getFullTimeAwayTeamGoals());
		standing.setAwayGoalsAgainst(fixture.getResult().getFullTimeHomeTeamGoals());
		standing.setAwayPlayedGames(1);
		standing.setHomeGoals(0);
		standing.setHomeGoalsAgainst(0);
		standing.setHomePlayedGames(0);
	    }
	    standing.setPlayedGames(1);
	}
    }

    @Override
    public Integer calculatePoints(Fixture fixture, String HomeAway) {

	Result result = fixture.getResult();

	if (result.getFullTimeHomeTeamGoals() > result.getFullTimeAwayTeamGoals()) {
	    if (HomeAway.equals("Home")) {
		return 3;
	    } else {
		return 0;
	    }
	} else if (result.getFullTimeHomeTeamGoals().equals(fixture.getResult().getFullTimeAwayTeamGoals())) {
	    return 1;
	} else if (HomeAway.equals("Home")) {
	    return 0;
	} else {
	    return 3;
	}
    }

    @Override
    public Integer calculateHomePoints(Fixture fixture) {

	Result result = fixture.getResult();

	if (result.getFullTimeHomeTeamGoals() > result.getFullTimeAwayTeamGoals()) {
	    return 3;
	} else if (result.getFullTimeHomeTeamGoals().equals(fixture.getResult().getFullTimeAwayTeamGoals())) {
	    return 1;
	} else {
	    return 0;
	}
    }

    @Override
    public Integer calculateAwayPoints(Fixture fixture) {
	Result result = fixture.getResult();

	if (result.getFullTimeHomeTeamGoals() > result.getFullTimeAwayTeamGoals()) {
	    return 0;
	} else if (result.getFullTimeHomeTeamGoals().equals(fixture.getResult().getFullTimeAwayTeamGoals())) {
	    return 1;
	} else {
	    return 3;
	}
    }

    @Override
    public List<Team> getTeamsOrderedByClassification(Season s, DateTime date) {
	return standingDAO.getStandingsByPoints(date, s.getId());
    }

    @Override
    public List<Team> getTeamsOrderedByQuality(Season s, DateTime date) {
	return standingDAO.getStandingsByQuality(date, s.getId());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business.ann.obj;

import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.joda.time.DateTime;
import org.joda.time.Days;
import pt.belele.project.business.FixtureController;
import pt.belele.project.business.StandingController;
import pt.belele.project.business.util.ResultCycle;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Result.ResultType;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Standing;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.TeamDAO;

/**
 *
 * @author P056913
 */
public class DataSetCalculator {

    private TeamDAO teamDAO;
    private FixtureController fixtureController;
    private StandingController standingController;

    public DataSetCalculator() {
	try {
	    InitialContext ctx=new InitialContext();
	    this.teamDAO = (TeamDAO) ctx.lookup("java:global/BELELE-PROJECT-EAR/BELELE-PROJECT-CORE/TeamDAOBean!pt.belele.project.persistence.TeamDAO");
	    this.fixtureController = (FixtureController) ctx.lookup("java:global/BELELE-PROJECT-EAR/BELELE-PROJECT-CORE/FixtureControllerBean!pt.belele.project.business.FixtureController");
	    this.standingController = (StandingController) ctx.lookup("java:global/BELELE-PROJECT-EAR/BELELE-PROJECT-CORE/StandingControllerBean!pt.belele.project.business.StandingController");
	} catch (NamingException ex) {
	    
	}
    }

    public Double getHomeTeamQuality(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	Standing s = standingController.getTeamStanding(fixture.getSeason(), homeTeam, fixture.getDate());
	if (s != null) {
	    return (double) s.getPlayedGames() > 0 ? (double) s.getPoints() / s.getPlayedGames() : 0;
	} else {
	    return null;
	}
    }

    public Double getAwayTeamQuality(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	Standing s = standingController.getTeamStanding(fixture.getSeason(), awayTeam, fixture.getDate());
	if (s != null) {
	    return (double) s.getPlayedGames() > 0 ? (double) s.getPoints() / s.getPlayedGames() : 0;
	} else {
	    return null;
	}
    }

    public Integer getHomeTeamRestingDays(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	Fixture f = fixtureController.getTeamFixtureBeforeDate(homeTeam, fixture.getSeason(), fixture.getDate());
	DateTime fixtureDate = new DateTime(f.getDate());
	Days days = Days.daysBetween(fixtureDate, new DateTime(fixture.getDate()));
	int nmrDays = days.getDays();
	return nmrDays + 1;
    }

    public Integer getAwayTeamRestingDays(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	Fixture f = fixtureController.getTeamFixtureBeforeDate(awayTeam, fixture.getSeason(), fixture.getDate());
	DateTime fixtureDate = new DateTime(f.getDate());
	Days days = Days.daysBetween(fixtureDate, new DateTime(fixture.getDate()));
	int nmrDays = days.getDays();
	return nmrDays + 1;
    }

    public Integer getHomeTeamPosition(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	List<Team> ls = standingController.getTeamsOrderedByClassification(fixture.getSeason(), fixture.getDate());

	return ls.indexOf(homeTeam) + 1;
    }

    public Integer getAwayTeamPosition(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	List<Team> ls = standingController.getTeamsOrderedByClassification(fixture.getSeason(), fixture.getDate());

	return ls.indexOf(awayTeam) + 1;
    }

    public Double getHomeTeamQualityVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	Standing s = standingController.getTeamStanding(fixture.getSeason(), homeTeam, fixture.getDate());
	if (s != null) {
	    return (double) s.getHomePlayedGames() > 0 ? (double) s.getHomePoints() / s.getHomePlayedGames() : 0;
	} else {
	    return null;
	}
    }

    public Double getAwayTeamQualityVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	Standing s = standingController.getTeamStanding(fixture.getSeason(), awayTeam, fixture.getDate());
	if (s != null) {
	    return (double) s.getAwayPlayedGames() > 0 ? (double) s.getAwayPoints() / s.getAwayPlayedGames() : 0;
	} else {
	    return null;
	}
    }

    public Double getHomeTeamQualitySwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	Standing s = standingController.getTeamStanding(fixture.getSeason(), awayTeam, fixture.getDate());
	if (s != null) {
	    return (double) s.getHomePlayedGames() > 0 ? (double) s.getHomePoints() / s.getHomePlayedGames() : 0;
	} else {
	    return null;
	}
    }

    public Double getAwayTeamQualitySwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	Standing s = standingController.getTeamStanding(fixture.getSeason(), homeTeam, fixture.getDate());
	if (s != null) {
	    return (double) s.getAwayPlayedGames() > 0 ? (double) s.getAwayPoints() / s.getAwayPlayedGames() : 0;
	} else {
	    return null;
	}
    }

    public Integer getHomeTeamCycleNotResultNumberFixtures(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getHomeTeamCycle(homeTeam, fixture, null, result).getCycle();
    }

    public Integer getAwayTeamCycleNotResultNumberFixtures(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getAwayTeamCycle(awayTeam, fixture, null, result).getCycle();
    }

    public Double getHomeTeamCycleNotResultOpponentAverageQuality(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCycle(homeTeam, fixture, null, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Double getAwayTeamCycleNotResultOpponentAverageQuality(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCycle(awayTeam, fixture, null, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Integer getHomeTeamCycleNotResultHardFixturesNumber(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCycle(homeTeam, fixture, null, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }

    public Integer getAwayTeamCycleNotResultHardFixturesNumber(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCycle(awayTeam, fixture, null, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }
    
    public Integer getHomeTeamCycleNumberFixtures(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getHomeTeamCyclePerna(homeTeam, fixture, null, result).getCycle();
    }

    public Integer getAwayTeamCycleNumberFixtures(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getAwayTeamCyclePerna(awayTeam, fixture, null, result).getCycle();
    }

    public Double getHomeTeamCycleOpponentAverageQuality(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCyclePerna(homeTeam, fixture, null, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Double getAwayTeamCycleOpponentAverageQuality(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCyclePerna(awayTeam, fixture, null, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Integer getHomeTeamCycleHardFixturesNumber(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCyclePerna(homeTeam, fixture, null, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }

    public Integer getAwayTeamCycleHardFixturesNumber(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCyclePerna(awayTeam, fixture, null, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }
    
    public Integer getHomeTeamCycleNotResultNumberFixturesVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getHomeTeamCycle(homeTeam, fixture, Venue.HOME, result).getCycle();
    }

    public Integer getAwayTeamCycleNotResultNumberFixturesVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getAwayTeamCycle(awayTeam, fixture, Venue.AWAY, result).getCycle();
    }

    public Double getHomeTeamCycleNotResultOpponentAverageQualityVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCycle(homeTeam, fixture, Venue.HOME, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Double getAwayTeamCycleNotResultOpponentAverageQualityVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCycle(awayTeam, fixture, Venue.AWAY, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Integer getHomeTeamCycleNotResultHardFixturesNumberVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCycle(homeTeam, fixture, Venue.HOME, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }

    public Integer getAwayTeamCycleNotResultHardFixturesNumberVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCycle(awayTeam, fixture, Venue.AWAY, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }
    
    public Integer getHomeTeamCycleNumberFixturesVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getHomeTeamCyclePerna(homeTeam, fixture, Venue.HOME, result).getCycle();
    }

    public Integer getAwayTeamCycleNumberFixturesVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getAwayTeamCyclePerna(awayTeam, fixture, Venue.AWAY, result).getCycle();
    }

    public Double getHomeTeamCycleOpponentAverageQualityVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCyclePerna(homeTeam, fixture, Venue.HOME, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Double getAwayTeamCycleOpponentAverageQualityVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCyclePerna(awayTeam, fixture, Venue.AWAY, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Integer getHomeTeamCycleHardFixturesNumberVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCyclePerna(homeTeam, fixture, Venue.HOME, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }

    public Integer getAwayTeamCycleHardFixturesNumberVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCyclePerna(awayTeam, fixture, Venue.AWAY, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }
    
    public Integer getHomeTeamCycleNotResultNumberFixturesSwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getHomeTeamCycle(homeTeam, fixture, Venue.AWAY, result).getCycle();
    }

    public Integer getAwayTeamCycleNotResultNumberFixturesSwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getAwayTeamCycle(awayTeam, fixture, Venue.HOME, result).getCycle();
    }

    public Double getHomeTeamCycleNotResultOpponentAverageQualitySwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCycle(homeTeam, fixture, Venue.AWAY, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Double getAwayTeamCycleNotResultOpponentAverageQualitySwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCycle(awayTeam, fixture, Venue.HOME, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Integer getHomeTeamCycleNotResultHardFixturesNumberSwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCycle(homeTeam, fixture, Venue.AWAY, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }

    public Integer getAwayTeamCycleNotResultHardFixturesNumberSwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCycle(awayTeam, fixture, Venue.HOME, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }
    
    public Integer getHomeTeamCycleNumberFixturesSwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getHomeTeamCyclePerna(homeTeam, fixture, Venue.AWAY, result).getCycle();
    }

    public Integer getAwayTeamCycleNumberFixturesSwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	return getAwayTeamCyclePerna(awayTeam, fixture, Venue.HOME, result).getCycle();
    }

    public Double getHomeTeamCycleOpponentAverageQualitySwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCyclePerna(homeTeam, fixture, Venue.AWAY, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Double getAwayTeamCycleOpponentAverageQualitySwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCyclePerna(awayTeam, fixture, Venue.HOME, result);

	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    public Integer getHomeTeamCycleHardFixturesNumberSwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getHomeTeamCyclePerna(homeTeam, fixture, Venue.AWAY, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }

    public Integer getAwayTeamCycleHardFixturesNumberSwitchedVenue(Team homeTeam, Team awayTeam, Fixture fixture, String result) {
	ResultCycle cycle = getAwayTeamCyclePerna(awayTeam, fixture, Venue.HOME, result);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }

//    ############################################################################
//    PRIVATE METHODS
//    ############################################################################
    private ResultType getResultType(Team team, Fixture fixture) {
	Result r = fixture.getResult();
	if (fixture.getHomeTeam().equals(team)) {
	    if (r.getFullTimeHomeTeamGoals() > r.getFullTimeAwayTeamGoals()) {
		return ResultType.WIN;
	    } else if (r.getFullTimeHomeTeamGoals() < r.getFullTimeAwayTeamGoals()) {
		return ResultType.LOSE;
	    } else {
		return ResultType.DRAW;
	    }
	} else if (r.getFullTimeAwayTeamGoals() > r.getFullTimeHomeTeamGoals()) {
	    return ResultType.WIN;
	} else if (r.getFullTimeAwayTeamGoals() < r.getFullTimeHomeTeamGoals()) {
	    return ResultType.LOSE;
	} else {
	    return ResultType.DRAW;
	}
    }

    private Double getTeamQuality(Team team, Season season, DateTime date) {
	Standing s = standingController.getTeamStanding(season, team, date);
	if (s != null) {
	    return (double) s.getPlayedGames() > 0 ? (double) s.getPoints() / s.getPlayedGames() : 0;
	} else {
	    return null;
	}
    }

    private ResultCycle getHomeTeamCycle(Team team, Fixture nextFixture, Venue venue, String result) {
	ResultType type;
	switch (result) {
	    case "1":
		type = ResultType.WIN;
		break;
	    case "X":
		type = ResultType.DRAW;
		break;
	    case "2":
		type = ResultType.LOSE;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, null);
	boolean positive = false;
	ResultType actualResult = null;
	int sum = 0;
	List<Team> teams = new ArrayList<>();
	for (Fixture f : fixtures) {
	    if (actualResult == null) {
		actualResult = getResultType(team, f);
		if (actualResult.equals(type)) {
		    sum++;
		    positive = true;
		} else {
		    sum--;
		}
	    } else if (actualResult.equals(getResultType(team, f)) && positive) {
		sum++;
	    } else if (!actualResult.equals(getResultType(team, f)) && positive) {
		break;
	    } else if (!positive) {
		if (getResultType(team, f).equals(type)) {
		    break;
		}
		sum--;
	    }

	    if (f.getHomeTeam().equals(team)) {
		teams.add(f.getAwayTeam());
	    } else {
		teams.add(f.getHomeTeam());
	    }
	}

	return new ResultCycle(nextFixture.getSeason(), type, teams, sum, new DateTime(nextFixture.getDate()));
    }

    private ResultCycle getAwayTeamCycle(Team team, Fixture nextFixture, Venue venue, String result) {
	ResultType type;
	switch (result) {
	    case "1":
		type = ResultType.LOSE;
		break;
	    case "X":
		type = ResultType.DRAW;
		break;
	    case "2":
		type = ResultType.WIN;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, null);
	boolean positive = false;
	ResultType actualResult = null;
	int sum = 0;
	List<Team> teams = new ArrayList<>();
	for (Fixture f : fixtures) {
	    if (actualResult == null) {
		actualResult = getResultType(team, f);
		if (actualResult.equals(type)) {
		    sum++;
		    positive = true;
		} else {
		    sum--;
		}
	    } else if (actualResult.equals(getResultType(team, f)) && positive) {
		sum++;
	    } else if (!actualResult.equals(getResultType(team, f)) && positive) {
		break;
	    } else if (!positive) {
		if (getResultType(team, f).equals(type)) {
		    break;
		}
		sum--;
	    }

	    if (f.getHomeTeam().equals(team)) {
		teams.add(f.getAwayTeam());
	    } else {
		teams.add(f.getHomeTeam());
	    }
	}

	return new ResultCycle(nextFixture.getSeason(), type, teams, sum, new DateTime(nextFixture.getDate()));
    }

    private ResultCycle getHomeTeamCyclePerna(Team team, Fixture nextFixture, Venue venue, String result) {

	ResultType type;
	switch (result) {
	    case "1":
		type = ResultType.WIN;
		break;
	    case "X":
		type = ResultType.DRAW;
		break;
	    case "2":
		type = ResultType.LOSE;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, null);
	ResultType firstResult = null;
	int sum = 0;
	List<Team> teams = new ArrayList<>();
	for (Fixture f : fixtures) {
	    if (firstResult == null) {
		firstResult = getResultType(team, f);
		if (firstResult.equals(type)) {
		    sum++;
		} else {
		    sum--;
		}
	    } else {
		if (!firstResult.equals(getResultType(team, f))) {
		    break;
		}

		if (firstResult.equals(type)) {
		    sum++;
		} else {
		    sum--;
		}
	    }

	    if (f.getHomeTeam().equals(team)) {
		teams.add(f.getAwayTeam());
	    } else {
		teams.add(f.getHomeTeam());
	    }
	}

	return new ResultCycle(nextFixture.getSeason(), type, teams, sum, new DateTime(nextFixture.getDate()));
    }
    
    private ResultCycle getAwayTeamCyclePerna(Team team, Fixture nextFixture, Venue venue, String result) {

	ResultType type;
	switch (result) {
	    case "1":
		type = ResultType.LOSE;
		break;
	    case "X":
		type = ResultType.DRAW;
		break;
	    case "2":
		type = ResultType.WIN;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, null);
	ResultType firstResult = null;
	int sum = 0;
	List<Team> teams = new ArrayList<>();
	for (Fixture f : fixtures) {
	    if (firstResult == null) {
		firstResult = getResultType(team, f);
		if (firstResult.equals(type)) {
		    sum++;
		} else {
		    sum--;
		}
	    } else {
		if (!firstResult.equals(getResultType(team, f))) {
		    break;
		}

		if (firstResult.equals(type)) {
		    sum++;
		} else {
		    sum--;
		}
	    }

	    if (f.getHomeTeam().equals(team)) {
		teams.add(f.getAwayTeam());
	    } else {
		teams.add(f.getHomeTeam());
	    }
	}

	return new ResultCycle(nextFixture.getSeason(), type, teams, sum, new DateTime(nextFixture.getDate()));
    }
}

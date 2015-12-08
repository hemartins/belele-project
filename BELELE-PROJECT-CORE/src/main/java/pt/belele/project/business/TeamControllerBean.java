package pt.belele.project.business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import pt.belele.project.business.exception.BeleleException;
import pt.belele.project.business.util.H2H;
import pt.belele.project.business.util.ResultCycle;
import pt.belele.project.business.util.TeamRating;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Result.ResultType;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Standing;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.TeamDAO;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class TeamControllerBean implements TeamController {

    private static final Logger LOG = LogManager.getLogger(TeamControllerBean.class);

    @EJB
    private TeamDAO teamDAO;

    @EJB
    private FixtureController fixtureController;

    @EJB
    private StandingController standingController;

    @Override
    public Team createTeam(String name) {
	Team t;
	try {
	    t = teamDAO.findByName(name);
	} catch (BeleleException e) {
	    t = teamDAO.insert(new Team(name));
	}
	return t;
    }

    // Qualidade da equipa consoante competicao
    @Override
    public Double getTeamQuality(Team team, Season season, DateTime date) {
	Standing s = standingController.getTeamStanding(season, team, date);
	if (s != null) {
	    return (double) s.getPlayedGames() > 0 ? (double) s.getPoints() / s.getPlayedGames() : 0;
	} else {
	    return null;
	}
    }

    @Override
    public Double getHomeTeamQuality(Team team, Season season, DateTime date) {
	Standing s = standingController.getTeamStanding(season, team, date);
	if (s != null) {
	    return (double) s.getHomePlayedGames() > 0 ? (double) s.getHomePoints() / s.getHomePlayedGames() : 0;
	} else {
	    return null;
	}
    }

    @Override
    public Double getAwayTeamQuality(Team team, Season season, DateTime date) {
	Standing s = standingController.getTeamStanding(season, team, date);
	if (s != null) {
	    return (double) s.getAwayPlayedGames() > 0 ? (double) s.getAwayPoints() / s.getAwayPlayedGames() : 0;
	} else {
	    return null;
	}
    }

    // Dias de descanso antes do jogo
    @Override
    public Integer getRestingDays(Team team, Fixture nextFixture) {
	Fixture f = fixtureController.getTeamFixtureBeforeDate(team, nextFixture.getSeason(), nextFixture.getDate());
	DateTime fixtureDate = new DateTime(f.getDate());
	Days days = Days.daysBetween(fixtureDate, new DateTime(nextFixture.getDate()));
	int nmrDays = days.getDays();
	return nmrDays + 1;
    }

    // Rating dos ultimos jogos, venue opcional, ratings ordenados por ordem
    // decrescente
    @Override
    public Double getLastFixturesRating(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures, List<Double> ratings, ResultType type) {
	if (ratings.size() != numberOfFixtures) {
	    LOG.debug("RATINGS SIZE != NUMBER OF FIXTURES");
	    return null;
	}

	double rating = 0;

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, numberOfFixtures);
	for (int i = 0; i < fixtures.size(); i++) {
	    Fixture f = fixtures.get(i);
	    if (getResultType(team, f).equals(type)) {
		rating += ratings.get(i);
	    }
	}

	return rating;
    }

    //Pontuação Forma Recente
    @Override
    public Integer getFRPontuation(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures) {

	int pontuation = 0;

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, numberOfFixtures);
	for (int i = 0; i < fixtures.size(); i++) {
	    Fixture f = fixtures.get(i);
	    switch (getResultType(team, f)) {
		case WIN:
		    pontuation += 3;
		    break;
		case DRAW:
		    pontuation += 1;
		    break;
		default:
		    pontuation += 0;
		    break;
	    }
	}

	return pontuation;
    }

    //Pontuação Forma Recente Com Qualidade
    @Override
    public Double getFRPontuationQuality(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures) {

	double rating = 0;

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, numberOfFixtures);
	for (int i = 0; i < fixtures.size(); i++) {
	    Fixture f = fixtures.get(i);
	    if (f.getHomeTeam().equals(team)) {
		Team opponent = f.getAwayTeam();
		switch (getResultType(team, f)) {
		    case WIN:
			rating += 3 * getTeamQuality(opponent, nextFixture.getSeason(), nextFixture.getDate());
			break;
		    case DRAW:
			rating += 1 * getTeamQuality(opponent, nextFixture.getSeason(), nextFixture.getDate());
			break;
		    default:
			rating += 0;
			break;
		}
	    } else {
		Team opponent = f.getHomeTeam();
		switch (getResultType(team, f)) {
		    case WIN:
			rating += 3 * getTeamQuality(opponent, nextFixture.getSeason(), nextFixture.getDate());
			break;
		    case DRAW:
			rating += 1 * getTeamQuality(opponent, nextFixture.getSeason(), nextFixture.getDate());
			break;
		    default:
			rating += 0;
			break;
		}
	    }
	}

	return rating;
    }

    //Pontuação Forma Recente Com Qualidade e Aproximação à data do jogo
    @Override
    public Double getFRPontuationQualityAndTime(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures) {

	double rating = 0;
	double temporal = 1;

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, numberOfFixtures);
	for (int i = 0; i < fixtures.size(); i++) {
	    Fixture f = fixtures.get(i);
	    if (f.getHomeTeam().equals(team)) {
		Team opponent = f.getAwayTeam();
		switch (getResultType(team, f)) {
		    case WIN:
			rating += 3 * getTeamQuality(opponent, nextFixture.getSeason(), nextFixture.getDate()) * temporal;
			break;
		    case DRAW:
			rating += 1 * getTeamQuality(opponent, nextFixture.getSeason(), nextFixture.getDate()) * temporal;
			break;
		    default:
			rating += 0;
			break;
		}
	    } else {
		Team opponent = f.getHomeTeam();
		switch (getResultType(team, f)) {
		    case WIN:
			rating += 3 * getTeamQuality(opponent, nextFixture.getSeason(), nextFixture.getDate()) * temporal;
			break;
		    case DRAW:
			rating += 1 * getTeamQuality(opponent, nextFixture.getSeason(), nextFixture.getDate()) * temporal;
			break;
		    default:
			rating += 0;
			break;
		}
	    }
	    temporal = temporal - 0.2;
	}

	return rating;
    }

    @Override
    public Integer getLastFixturesResults(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures, List<Double> ratings, ResultType type) {
	if (ratings.size() != numberOfFixtures) {
	    LOG.debug("RATINGS SIZE != NUMBER OF FIXTURES");
	    return null;
	}

	int results = 0;

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, numberOfFixtures);
	for (int i = 0; i < fixtures.size(); i++) {
	    Fixture f = fixtures.get(i);
	    if (getResultType(team, f).equals(type)) {
		results++;
	    }
	}

	return results;
    }

    @Override
    public Double[] getRecentFormResultPercentage(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures, Double interval, ResultType type) {

	Double[] percentages = new Double[4];
	Double percentageHomeTeamCasa;
	Double percentageAwayTeamFora;
	Double percentageIntervalHomeTeamCasa;
	Double percentageIntervalAwayTeamFora;
	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, numberOfFixtures);
	Double resultTypeHomeTeamCasa = 0.0;
	Double resultTypeAwayTeamFora = 0.0;
	Double resultTypeIntervalHomeTeamCasa = 0.0;
	Double resultTypeIntervalAwayTeamFora = 0.0;
	Double homeGames = 0.0;
	Double awayGames = 0.0;
	Double homeIntervalGames = 0.0;
	Double awayIntervalGames = 0.0;
	Double inferiorLimit;
	Double superiorLimit;

	Team opponent;
	if (nextFixture.getHomeTeam().equals(team)) {
	    opponent = nextFixture.getAwayTeam();
	} else {
	    opponent = nextFixture.getHomeTeam();
	}

	Double opponentQuality = getTeamQuality(opponent, nextFixture.getSeason(), nextFixture.getDate());

	inferiorLimit = opponentQuality - 0.15;
	superiorLimit = opponentQuality + 0.15;

	for (Fixture f : fixtures) {

	    if (f.getHomeTeam().equals(team)) {
		homeGames++;

		Double fixtureOpponentQuality = getTeamQuality(f.getAwayTeam(), nextFixture.getSeason(), nextFixture.getDate());

		if (fixtureOpponentQuality >= inferiorLimit && fixtureOpponentQuality <= superiorLimit) {
		    homeIntervalGames++;

		    if (getResultType(team, f).equals(type)) {
			resultTypeIntervalHomeTeamCasa++;
		    }
		}

		if (f.getResult().getResultType().equals(type)) {
		    resultTypeHomeTeamCasa++;
		}
	    } else {
		awayGames++;

		Double fixtureOpponentQuality = getTeamQuality(f.getHomeTeam(), nextFixture.getSeason(), nextFixture.getDate());

		if (fixtureOpponentQuality >= inferiorLimit
			&& fixtureOpponentQuality <= superiorLimit) {
		    awayIntervalGames++;

		    if (type.equals(ResultType.WIN)) {
			if (f.getResult().getResultType().equals(ResultType.LOSE)) {
			    resultTypeIntervalAwayTeamFora++;
			}
		    } else if (type.equals(ResultType.LOSE)) {
			if (f.getResult().getResultType().equals(ResultType.WIN)) {
			    resultTypeIntervalAwayTeamFora++;
			}
		    } else if (f.getResult().getResultType().equals(ResultType.DRAW)) {
			resultTypeIntervalAwayTeamFora++;
		    }
		}
		if (type.equals(ResultType.WIN)) {
		    if (f.getResult().getResultType().equals(ResultType.LOSE)) {
			resultTypeAwayTeamFora++;
		    }
		} else if (type.equals(ResultType.LOSE)) {
		    if (f.getResult().getResultType().equals(ResultType.WIN)) {
			resultTypeAwayTeamFora++;
		    }
		} else if (f.getResult().getResultType().equals(ResultType.DRAW)) {
		    resultTypeAwayTeamFora++;
		}

	    }
	}

	if (homeGames == 0) {
	    percentageHomeTeamCasa = 0.0;
	} else {
	    percentageHomeTeamCasa = resultTypeHomeTeamCasa / homeGames;
	}
	if (awayGames == 0) {
	    percentageAwayTeamFora = 0.0;
	} else {
	    percentageAwayTeamFora = resultTypeAwayTeamFora / awayGames;
	}
	if (homeIntervalGames == 0) {
	    percentageIntervalHomeTeamCasa = 0.0;
	} else {
	    percentageIntervalHomeTeamCasa = resultTypeIntervalHomeTeamCasa / homeIntervalGames;
	}
	if (awayIntervalGames == 0) {
	    percentageIntervalAwayTeamFora = 0.0;
	} else {
	    percentageIntervalAwayTeamFora = resultTypeIntervalAwayTeamFora / awayIntervalGames;
	}

	percentages[0] = percentageHomeTeamCasa;
	percentages[1] = percentageAwayTeamFora;
	percentages[2] = percentageIntervalHomeTeamCasa;
	percentages[3] = percentageIntervalAwayTeamFora;

	return percentages;
    }

    @Override
    public Integer[] getHomeAndAwayGames(Team team, Fixture nextFixture, Integer numberOfFixtures, ResultType type) {

	Integer[] numberOfGames = new Integer[2];
	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), null, numberOfFixtures);
	Integer homeGames = 0;
	Integer awayGames = 0;

	for (Fixture f : fixtures) {
	    if (f.getHomeTeam().equals(team)) {
		homeGames++;
	    } else {
		awayGames++;
	    }
	}

	numberOfGames[0] = homeGames;
	numberOfGames[1] = awayGames;

	return numberOfGames;
    }

    // Media da qualidade das ultimas equipas defrontadas
    @Override
    public Double getLastFixturesOpponentAverageQuality(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures) {
	double sum = 0;
	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, numberOfFixtures);
	for (Fixture f : fixtures) {
	    if (f.getHomeTeam().equals(team)) {
		sum += getTeamQuality(f.getAwayTeam(), nextFixture.getSeason(), nextFixture.getDate());
	    } else {
		sum += getTeamQuality(f.getHomeTeam(), nextFixture.getSeason(), nextFixture.getDate());
	    }
	}
	return fixtures.size() > 0 ? sum / fixtures.size() : 0;
    }

    // Numero de historicos defrontados
    @Override
    public Integer getLastHardGamesFixturesNumber(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures) {

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(), nextFixture.getDate(), venue, numberOfFixtures);

	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(nextFixture.getSeason().getId());

	for (Fixture f : fixtures) {
	    if ((hardTeams.contains(f.getAwayTeam()) && !f.getAwayTeam().equals(team)) || (hardTeams.contains(f.getHomeTeam()) && !f.getHomeTeam().equals(team))) {
		sum++;
	    }
	}
	return sum;
    }

    // Calculo ciclos
    @Override
    public ResultCycle getTeamCycle(Team team, Fixture nextFixture, Venue venue, ResultType type) {
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

    // Calculo ciclos à sapateiro que o perna pediu para testar a correlacao
    @Override
    public ResultCycle getTeamCyclePerna(Team team, Fixture nextFixture, Venue venue, ResultType type) {

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

    // Media da qualidade das equipas dum ciclo
    @Override
    public Double getCycleOpponentAverageQuality(ResultCycle cycle) {
	double sum = 0;
	for (Team t : cycle.getTeams()) {
	    sum += getTeamQuality(t, cycle.getSeason(), cycle.getDate());
	}
	return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
    }

    // Numero de historicos defrontados num ciclo
    @Override
    public Integer getCycleHardGamesNumber(ResultCycle cycle) {
	int sum = 0;

	List<Team> hardTeams = teamDAO.findHardTeamsBySeasonId(cycle.getSeason().getId());

	for (Team t : cycle.getTeams()) {
	    if (hardTeams.contains(t)) {
		sum++;
	    }
	}

	return sum;
    }

    // Rating do h2h - PROBLEMA! Se houver 2 jogos no mesmo ano, como proceder?
    /*
	 * public H2H getH2HRating(Fixture nextFixture, List<Double> ratings, Venue
	 * venue, ResultType type) { double rating = 0; int rat = 0; if
	 * (nextFixture.getH2h() != null) { if (!nextFixture.getH2h().isEmpty()) {
	 * for (Fixture f : nextFixture.getH2h()) { rat =
	 * nextFixture.getSeason().getYear() - f.getSeason().getYear() - 1; if (rat
	 * >= ratings.size()) break;
	 * 
	 * if (getResultType(f).equals(type)) rating += ratings.get(rat); } } } //
	 * return new H2H(rating, rat); return new H2H(rating,
	 * nextFixture.getH2h().size()); }
     */
    @Override
    public H2H getH2HRating(Team team, Fixture nextFixture, List<Double> ratings, Venue venue, ResultType type) {
	double rating = 0;
	double ratingSum = 0;
	double resultTypeRating = 0;
	int numberResults = 0;
	int timeInYears;
	if (nextFixture.getH2h() != null) {
	    if (!nextFixture.getH2h().isEmpty()) {
		for (Fixture f : nextFixture.getH2h()) {
		    timeInYears = nextFixture.getSeason().getYear() - f.getSeason().getYear();
		    if (timeInYears >= ratings.size()) {
			continue;
		    }

		    ratingSum += ratings.get(timeInYears);

		    if (getResultType(team, f).equals(type)) {
			rating += ratings.get(timeInYears);
			numberResults++;
		    }
		}

		if (rating != 0) {
		    resultTypeRating = rating / ratingSum;
		} else {
		    resultTypeRating = 0;
		}
	    }

	}
	return new H2H(resultTypeRating, nextFixture.getH2h().size(), numberResults);
    }

    @Override
    public H2H getH2HRatingVenue(Team team, Fixture nextFixture, List<Double> ratings, Venue venue, ResultType type) {
	double rating = 0;
	double ratingSum = 0;
	double resultTypeRating = 0;
	int numberResults = 0;
	int timeInYears;
	if (nextFixture.getH2HVenue() != null) {
	    if (!nextFixture.getH2HVenue().isEmpty()) {
		for (Fixture f : nextFixture.getH2HVenue()) {
		    timeInYears = nextFixture.getSeason().getYear() - f.getSeason().getYear();
		    if (timeInYears >= ratings.size()) {
			continue;
		    }

		    ratingSum += ratings.get(timeInYears);

		    if (getResultType(team, f).equals(type)) {
			rating += ratings.get(timeInYears);
			numberResults++;
		    }
		}

		if (rating != 0) {
		    resultTypeRating = rating / ratingSum;
		} else {
		    resultTypeRating = 0;
		}
	    }

	}
	return new H2H(resultTypeRating, nextFixture.getH2HVenue().size(), numberResults);
    }

    @Override
    public H2H getH2HRatingSwitchedVenue(Team team, Fixture nextFixture, List<Double> ratings, Venue venue, ResultType type) {
	double rating = 0;
	double ratingSum = 0;
	double resultTypeRating = 0;
	int numberResults = 0;
	int timeInYears;
	if (nextFixture.getH2HSwitchedVenue() != null) {
	    if (!nextFixture.getH2HSwitchedVenue().isEmpty()) {
		for (Fixture f : nextFixture.getH2HSwitchedVenue()) {
		    timeInYears = nextFixture.getSeason().getYear() - f.getSeason().getYear();
		    if (timeInYears >= ratings.size()) {
			continue;
		    }

		    ratingSum += ratings.get(timeInYears);

		    if (getResultType(team, f).equals(type)) {
			rating += ratings.get(timeInYears);
			numberResults++;
		    }
		}

		if (rating != 0) {
		    resultTypeRating = rating / ratingSum;
		} else {
		    resultTypeRating = 0;
		}
	    }

	}
	return new H2H(resultTypeRating, nextFixture.getH2HSwitchedVenue().size(), numberResults);
    }

    @Override
    public TeamRating getResultPercentage(Team team, Fixture nextFixture, Venue venue, ResultType type, Double interval, Integer numerberOfGames) {

	Season s = nextFixture.getSeason();
	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, numerberOfGames);
	Double resultSum = 0.0;
	Double opponentSum = 0.0;
	Double intervalSum = 0.0;
	Double resultIntervalSum = 0.0;
	Double resultDificultSum = 0.0;
	Double intervalResultDificultSum = 0.0;

	Double opponentQuality;
	if (nextFixture.getHomeTeam() == team) {
	    opponentQuality = getTeamQuality(nextFixture.getAwayTeam(), s, nextFixture.getDate());
	} else {
	    opponentQuality = getTeamQuality(nextFixture.getHomeTeam(), s, nextFixture.getDate());
	}

	Double inferiorLimit = opponentQuality - interval;
	Double superiorLimit = opponentQuality + interval;

	for (Fixture f : fixtures) {
	    Double fixtureOpponentQuality;
	    if (f.getHomeTeam() == team) {
		fixtureOpponentQuality = getTeamQuality(nextFixture.getAwayTeam(), s, nextFixture.getDate());
	    } else {
		fixtureOpponentQuality = getTeamQuality(nextFixture.getHomeTeam(), s, nextFixture.getDate());
	    }

	    if (fixtureOpponentQuality != null) {
		if (getResultType(team, f).equals(type)) {
		    resultSum++;
		    resultDificultSum += fixtureOpponentQuality;
		}

		if (interval != null) {
		    if (fixtureOpponentQuality >= inferiorLimit && fixtureOpponentQuality <= superiorLimit) {
			intervalSum++;
			intervalResultDificultSum += fixtureOpponentQuality;

			if (getResultType(team, f).equals(type)) {
			    resultIntervalSum++;
			}

		    }
		}

		opponentSum += fixtureOpponentQuality;
	    }

	}
	int size = fixtures.size();
	return new TeamRating(size > 0 ? resultSum / size : 0, size > 0 ? opponentSum / size : 0,
		intervalSum > 0 ? resultIntervalSum / intervalSum : 0, intervalSum.intValue(),
		resultSum > 0 ? resultDificultSum / resultSum : 0,
		resultIntervalSum > 0 ? intervalResultDificultSum / resultIntervalSum : 0);
    }

    @Override
    public Integer getNumberOfFixtures(Team team, Fixture nextFixture, Venue venue) {
	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, null);
	return fixtures.size();
    }

    // Rating dos ultimos jogos, venue opcional, ratings ordenados por ordem
    // decrescente
    @Override
    public Double getLastFixturesRatingQuality(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures, List<Double> ratings, ResultType type) {
	if (ratings.size() != numberOfFixtures) {
	    LOG.debug("RATINGS SIZE != NUMBER OF FIXTURES");
	    return null;
	}

	double rating = 0;

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, numberOfFixtures);

	for (int i = 0; i < fixtures.size(); i++) {
	    Fixture f = fixtures.get(i);
	    if (getResultType(team, f).equals(type)) {
		if (f.getHomeTeam().equals(team)) {
		    rating += ratings.get(i) * getTeamQuality(f.getAwayTeam(), nextFixture.getSeason(), nextFixture.getDate());
		} else {
		    rating += ratings.get(i) * getTeamQuality(f.getHomeTeam(), nextFixture.getSeason(), nextFixture.getDate());
		}
	    }
	}

	return rating;
    }

    @Override
    public Integer getGoals(Team team, Season season, DateTime date) {
	Standing s = standingController.getTeamStanding(season, team, date);
	if (s != null) {
	    return s.getGoals();
	} else {
	    return null;
	}
    }

    @Override
    public Integer getGoalsAgainst(Team team, Season season, DateTime date) {
	Standing s = standingController.getTeamStanding(season, team, date);
	if (s != null) {
	    return s.getGoalsAgainst();
	} else {
	    return null;
	}
    }

    @Override
    public Integer getHomeGoals(Team team, Season season, DateTime date) {
	Standing s = standingController.getTeamStanding(season, team, date);
	if (s != null) {
	    return s.getHomeGoals();
	} else {
	    return null;
	}
    }

    @Override
    public Integer getHomeGoalsAgainst(Team team, Season season, DateTime date) {
	Standing s = standingController.getTeamStanding(season, team, date);
	if (s != null) {
	    return s.getHomeGoalsAgainst();
	} else {
	    return null;
	}
    }

    @Override
    public Integer getAwayGoals(Team team, Season season, DateTime date) {
	Standing s = standingController.getTeamStanding(season, team, date);
	if (s != null) {
	    return s.getAwayGoals();
	} else {
	    return null;
	}
    }

    @Override
    public Integer getAwayGoalsAgainst(Team team, Season season, DateTime date) {
	Standing s = standingController.getTeamStanding(season, team, date);
	if (s != null) {
	    return s.getAwayGoalsAgainst();
	} else {
	    return null;
	}
    }

    @Override
    public Integer getClassification(Team team, Season season, DateTime date) {
	List<Team> ls = standingController.getTeamsOrderedByClassification(season, date);

	return ls.indexOf(team) + 1;
    }

    @Override
    public Integer getQualityClassification(Team team, Season season, DateTime date) {
	List<Team> ls = standingController.getTeamsOrderedByQuality(season, date);

	return ls.indexOf(team) + 1;
    }

    @Override
    public Double[] averageGoalsLastGames(Team team, Fixture nextFixture, Venue venue, Integer numerberOfGames) {

	Double[] avgGoalsFR = new Double[6];

	Double avgGoalsScoredTotal;
	Double avgGoalsConcededTotal;
	Double avgGoalsScoredHome;
	Double avgGoalsConcededHome;
	Double avgGoalsScoredAway;
	Double avgGoalsConcededAway;
	Double nrGoalsScoredTotal;
	Double nrGoalsConcededTotal;

	Double nrGoalsScoredHome = 0.0;
	Double nrGoalsConcededHome = 0.0;
	Double nrGoalsScoredAway = 0.0;
	Double nrGoalsConcededAway = 0.0;

	int nrGamesHome = 0;
	int nrGamesAway = 0;

	List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
		nextFixture.getDate(), venue, numerberOfGames);
	for (Fixture f : fixtures) {
	    if (f.getHomeTeam().equals(team)) {
		nrGamesHome++;
		nrGoalsScoredHome += f.getResult().getFullTimeHomeTeamGoals();
		nrGoalsConcededHome += f.getResult().getFullTimeAwayTeamGoals();
	    } else {
		nrGamesAway++;
		nrGoalsScoredAway += f.getResult().getFullTimeAwayTeamGoals();
		nrGoalsConcededAway += f.getResult().getFullTimeHomeTeamGoals();
	    }
	}

	nrGoalsScoredTotal = nrGoalsScoredHome + nrGoalsScoredAway;
	nrGoalsConcededTotal = nrGoalsConcededHome + nrGoalsConcededAway;

	if (nrGamesHome == 0) {
	    avgGoalsScoredHome = 0.0;
	    avgGoalsConcededHome = 0.0;
	} else {
	    avgGoalsScoredHome = nrGoalsScoredHome / nrGamesHome;
	    avgGoalsConcededHome = nrGoalsConcededHome / nrGamesHome;
	}

	if (nrGamesAway == 0) {
	    avgGoalsScoredAway = 0.0;
	    avgGoalsConcededAway = 0.0;
	} else {
	    avgGoalsScoredAway = nrGoalsScoredAway / nrGamesAway;
	    avgGoalsConcededAway = nrGoalsConcededAway / nrGamesAway;
	}

	if (fixtures.isEmpty()) {
	    avgGoalsScoredTotal = 0.0;
	    avgGoalsConcededTotal = 0.0;
	} else {
	    avgGoalsScoredTotal = nrGoalsScoredTotal / fixtures.size();
	    avgGoalsConcededTotal = nrGoalsConcededTotal / fixtures.size();
	}

	avgGoalsFR[0] = avgGoalsScoredTotal;

	avgGoalsFR[1] = avgGoalsConcededTotal;

	avgGoalsFR[2] = avgGoalsScoredHome;

	avgGoalsFR[3] = avgGoalsConcededHome;

	avgGoalsFR[4] = avgGoalsScoredAway;

	avgGoalsFR[5] = avgGoalsConcededAway;

	return avgGoalsFR;
    }

    // PLANO B
    public List<Integer> getTopNumberOfGames(Team team, Season s, DateTime d, Venue v) {
	List<Integer> nrDeJogosTop = new ArrayList<>();
	Integer nrVit = 0;
	Integer nrEmp = 0;
	Integer nrDer = 0;
	List<Fixture> f = fixtureController.getTeamBeforeFixtures(team, s, d, v, null);

	for (int i = 0; i < f.size(); i++) {
	    ResultType res = getResultType(team, f.get(i));
	    Team oponnent;
	    if (v == Venue.HOME) {
		oponnent = f.get(i).getAwayTeam();
	    } else {
		oponnent = f.get(i).getHomeTeam();
	    }
	    Integer pos = getClassification(oponnent, s, d);

	    if (pos <= 5) {
		if (res.getValue() == 0) {
		    nrVit++;
		}
		if (res.getValue() == 1) {
		    nrEmp++;
		}
		if (res.getValue() == 2) {
		    nrDer++;
		}
	    }
	}

	nrDeJogosTop.add(nrVit);
	nrDeJogosTop.add(nrEmp);
	nrDeJogosTop.add(nrDer);

	return nrDeJogosTop;
    }

    public List<Integer> getMsNumberOfGames(Team team, Season s, DateTime d, Venue v) {
	List<Integer> nrDeJogosMs = new ArrayList<>();
	Integer nrVit = 0;
	Integer nrEmp = 0;
	Integer nrDer = 0;
	List<Fixture> f = fixtureController.getTeamBeforeFixtures(team, s, d, v, null);

	for (int i = 0; i < f.size(); i++) {
	    ResultType res = getResultType(team, f.get(i));
	    Team oponnent;
	    if (v == Venue.HOME) {
		oponnent = f.get(i).getAwayTeam();
	    } else {
		oponnent = f.get(i).getHomeTeam();
	    }
	    Integer pos = getClassification(oponnent, s, d);

	    if (5 < pos && pos <= 10) {
		if (res.getValue() == 0) {
		    nrVit++;
		}
		if (res.getValue() == 1) {
		    nrEmp++;
		}
		if (res.getValue() == 2) {
		    nrDer++;
		}
	    }
	}

	nrDeJogosMs.add(nrVit);
	nrDeJogosMs.add(nrEmp);
	nrDeJogosMs.add(nrDer);

	return nrDeJogosMs;
    }

    public List<Integer> getMiNumberOfGames(Team team, Season s, DateTime d, Venue v) {
	List<Integer> nrDeJogosMi = new ArrayList<>();
	Integer nrVit = 0;
	Integer nrEmp = 0;
	Integer nrDer = 0;
	List<Fixture> f = fixtureController.getTeamBeforeFixtures(team, s, d, v, null);

	for (int i = 0; i < f.size(); i++) {
	    ResultType res = getResultType(team, f.get(i));
	    Team oponnent;
	    if (v == Venue.HOME) {
		oponnent = f.get(i).getAwayTeam();
	    } else {
		oponnent = f.get(i).getHomeTeam();
	    }
	    Integer pos = getClassification(oponnent, s, d);

	    if (10 < pos && pos <= 15) {
		if (res.getValue() == 0) {
		    nrVit++;
		}
		if (res.getValue() == 1) {
		    nrEmp++;
		}
		if (res.getValue() == 2) {
		    nrDer++;
		}
	    }
	}

	nrDeJogosMi.add(nrVit);
	nrDeJogosMi.add(nrEmp);
	nrDeJogosMi.add(nrDer);

	return nrDeJogosMi;
    }

    public List<Integer> getFracoNumberOfGames(Team team, Season s, DateTime d, Venue v) {
	List<Integer> nrDeJogosFraco = new ArrayList<>();
	Integer nrVit = 0;
	Integer nrEmp = 0;
	Integer nrDer = 0;
	List<Fixture> f = fixtureController.getTeamBeforeFixtures(team, s, d, v, null);

	for (int i = 0; i < f.size(); i++) {
	    ResultType res = getResultType(team, f.get(i));
	    Team oponnent;
	    if (v == Venue.HOME) {
		oponnent = f.get(i).getAwayTeam();
	    } else {
		oponnent = f.get(i).getHomeTeam();
	    }
	    Integer pos = getClassification(oponnent, s, d);

	    if (15 < pos) {
		if (res.getValue() == 0) {
		    nrVit++;
		}
		if (res.getValue() == 1) {
		    nrEmp++;
		}
		if (res.getValue() == 2) {
		    nrDer++;
		}
	    }
	}

	nrDeJogosFraco.add(nrVit);
	nrDeJogosFraco.add(nrEmp);
	nrDeJogosFraco.add(nrDer);

	return nrDeJogosFraco;
    }

    public List<Integer> getCycleInfo(Team team, Fixture nextFixture, Venue venue, ResultType res, Season s, DateTime date) {
	ResultCycle resCyc = getTeamCycle(team, nextFixture, venue, res);
	List<Team> teamsOp = resCyc.getTeams();
	int cicloTop, cicloMs, cicloMi, cicloFraco;
	cicloTop = cicloMs = cicloMi = cicloFraco = 0;
	List<Integer> listCy = new ArrayList<>();

	if (resCyc.getCycle() > 0) {
	    if (!teamsOp.isEmpty()) {
		for (int i = 0; i < teamsOp.size(); i++) {
		    Team opponent = teamsOp.get(i);
		    int posOp = getClassification(opponent, s, date);
		    if (posOp <= 5) {
			cicloTop++;
		    } else if (5 < posOp && posOp <= 10) {
			cicloMs++;
		    } else if (10 < posOp && posOp <= 15) {
			cicloMi++;
		    } else if (15 < posOp) {
			cicloFraco++;
		    }
		}
	    }
	}
	listCy.add(cicloTop);
	listCy.add(cicloMs);
	listCy.add(cicloMi);
	listCy.add(cicloFraco);

	return listCy;
    }

    @Override
    public ResultType getResultType(Team team, Fixture fixture) {
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
}

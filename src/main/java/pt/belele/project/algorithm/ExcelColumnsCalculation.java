package pt.belele.project.algorithm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;

import pt.belele.project.controllers.FixtureController;
import pt.belele.project.controllers.StandingController;
import pt.belele.project.controllers.util.H2H;
import pt.belele.project.controllers.util.ResultCycle;
import pt.belele.project.controllers.util.TeamRating;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Result.ResultType;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Standing;
import pt.belele.project.entities.Team;

public class ExcelColumnsCalculation {
	private Team team;
	private FixtureController fixtureController;
	private StandingController standingController;
	private EntityManager em;

	private static final Logger logger = LogManager.getLogger(ExcelColumnsCalculation.class);

	public ExcelColumnsCalculation(Team team, EntityManager em) {
		this.team = team;
		this.em = em;
		this.fixtureController = new FixtureController(em);
		this.standingController = new StandingController(em);
	}

	// Qualidade da equipa consoante competicao
	public Double getTeamQuality(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return (double) s.getPlayedGames() > 0 ? (double) s.getPoints() / s.getPlayedGames() : 0;
		} else
			return null;
	}

	public Double getHomeTeamQuality(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return (double) s.getHomePlayedGames() > 0 ? (double) s.getHomePoints() / s.getHomePlayedGames() : 0;
		} else
			return null;
	}

	public Double getAwayTeamQuality(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return (double) s.getAwayPlayedGames() > 0 ? (double) s.getAwayPoints() / s.getAwayPlayedGames() : 0;
		} else
			return null;
	}

	// Dias de descanso antes do jogo
	public Integer getRestingDays(Fixture nextFixture) {
		Fixture f = fixtureController.getTeamFixtureBeforeDate(team, nextFixture.getSeason(), nextFixture.getDate());
		DateTime fixtureDate = new DateTime(f.getDate());
		Days days = Days.daysBetween(fixtureDate, new DateTime(nextFixture.getDate()));
		int nmrDays = days.getDays();
		return nmrDays + 1;
	}

	// Rating dos ultimos jogos, venue opcional, ratings ordenados por ordem
	// decrescente
	public Double getLastFixturesRating(Fixture nextFixture, Venue venue, Integer numberOfFixtures,
			List<Double> ratings, ResultType type) {
		if (ratings.size() != numberOfFixtures) {
			logger.debug("RATINGS SIZE != NUMBER OF FIXTURES");
			return null;
		}

		double rating = 0;

		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
				nextFixture.getDate(), venue, numberOfFixtures);
		for (int i = 0; i < fixtures.size(); i++) {
			Fixture f = fixtures.get(i);
			if (getResultType(f).equals(type))
				rating += ratings.get(i);
		}

		return rating;
	}

	public Integer getLastFixturesResults(Fixture nextFixture, Venue venue, Integer numberOfFixtures,
			List<Double> ratings, ResultType type) {
		if (ratings.size() != numberOfFixtures) {
			logger.debug("RATINGS SIZE != NUMBER OF FIXTURES");
			return null;
		}

		int results = 0;

		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
				nextFixture.getDate(), venue, numberOfFixtures);
		for (int i = 0; i < fixtures.size(); i++) {
			Fixture f = fixtures.get(i);
			if (getResultType(f).equals(type))
				results++;
		}

		return results;
	}

	// Media da qualidade das ultimas equipas defrontadas
	public Double getLastFixturesOpponentAverageQuality(Fixture nextFixture, Venue venue, Integer numberOfFixtures) {
		double sum = 0;
		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
				nextFixture.getDate(), venue, numberOfFixtures);
		for (Fixture f : fixtures) {
			if (f.getHomeTeam().getId() == team.getId()) {
				ExcelColumnsCalculation tc = new ExcelColumnsCalculation(f.getAwayTeam(), em);
				sum += tc.getTeamQuality(nextFixture.getSeason(), nextFixture.getDate());
			} else {
				ExcelColumnsCalculation tc = new ExcelColumnsCalculation(f.getHomeTeam(), em);
				sum += tc.getTeamQuality(nextFixture.getSeason(), nextFixture.getDate());
			}
		}
		return fixtures.size() > 0 ? sum / fixtures.size() : 0;
	}

	// Numero de historicos defrontados
	public Integer getLastHardGamesFixturesNumber(Fixture nextFixture, Venue venue, Integer numberOfFixtures,
			List<String> hardTeamsIds) {

		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
				nextFixture.getDate(), venue, numberOfFixtures);

		int sum = 0;

		for (Fixture f : fixtures) {
			if ((hardTeamsIds.contains(f.getAwayTeam().getName()) && f.getAwayTeam().getId() != team.getId())
					|| (hardTeamsIds.contains(f.getHomeTeam().getName()) && f.getHomeTeam().getId() != team.getId())) {
				sum++;
			}
		}
		return sum;
	}

	// Calculo ciclos
	public ResultCycle getTeamCycle(Fixture nextFixture, Venue venue, ResultType type) {
		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
				nextFixture.getDate(), venue, null);
		boolean positive = false;
		ResultType actualResult = null;
		int sum = 0;
		List<Team> teams = new ArrayList<Team>();
		for (Fixture f : fixtures) {
			if (actualResult == null) {
				actualResult = getResultType(f);
				if (actualResult.equals(type)) {
					sum++;
					positive = true;
				} else
					sum--;
			} else {
				if (actualResult.equals(getResultType(f)) && positive) {
					sum++;
				} else if (!actualResult.equals(getResultType(f)) && positive) {
					break;
				} else if (!positive) {
					if (getResultType(f).equals(type))
						break;
					sum--;
				}
			}

			if (f.getHomeTeam().getId() == team.getId())
				teams.add(f.getAwayTeam());
			else
				teams.add(f.getHomeTeam());
		}

		return new ResultCycle(nextFixture.getSeason(), type, teams, sum, new DateTime(nextFixture.getDate()));
	}

	// Calculo ciclos à sapateiro que o perna pediu para testar a correlacao
	public ResultCycle getTeamCyclePerna(Fixture nextFixture, Venue venue, ResultType type) {
		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
				nextFixture.getDate(), venue, null);
		ResultType firstResult = null;
		int sum = 0;
		List<Team> teams = new ArrayList<Team>();
		for (Fixture f : fixtures) {
			if (firstResult == null) {
				firstResult = getResultType(f);
				if (firstResult.equals(type))
					sum++;
				else
					sum--;
			} else {
				if (!firstResult.equals(getResultType(f)))
					break;

				if (firstResult.equals(type))
					sum++;
				else
					sum--;
			}

			if (f.getHomeTeam().getId() == team.getId())
				teams.add(f.getAwayTeam());
			else
				teams.add(f.getHomeTeam());
		}

		return new ResultCycle(nextFixture.getSeason(), type, teams, sum, new DateTime(nextFixture.getDate()));
	}

	
	
	// Media da qualidade das equipas dum ciclo
	public Double getCycleOpponentAverageQuality(ResultCycle cycle) {
		double sum = 0;
		for (Team t : cycle.getTeams()) {
			ExcelColumnsCalculation tc = new ExcelColumnsCalculation(t, em);
			sum += tc.getTeamQuality(cycle.getSeason(), cycle.getDate().toDate());
		}
		return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
	}

	// Numero de historicos defrontados num ciclo
	public Integer getCycleHardGamesNumber(ResultCycle cycle, List<String> hardTeamsIds) {
		int sum = 0;

		for (Team t : cycle.getTeams()) {
			if (hardTeamsIds.contains(t.getName())) {
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

	public H2H getH2HRating(Fixture nextFixture, List<Double> ratings, Venue venue, ResultType type) {
		double rating = 0;
		double ratingSum = 0;
		double resultTypeRating = 0;
		int numberResults = 0;
		int timeInYears = 0;
		if (nextFixture.getH2h() != null) {
			if (!nextFixture.getH2h().isEmpty()) {
				for (Fixture f : nextFixture.getH2h()) {
					timeInYears = nextFixture.getSeason().getYear() - f.getSeason().getYear() - 1;
					if (timeInYears >= ratings.size())
						continue;

					ratingSum += ratings.get(timeInYears);

					if (getResultType(f).equals(type))
					{
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

	public TeamRating getResultPercentage(Fixture nextFixture, Venue venue, ResultType type, Double interval) {
		Season s = nextFixture.getSeason();
		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
				nextFixture.getDate(), venue, null);
		Double resultSum = 0.0;
		Double opponentSum = 0.0;
		Double intervalSum = 0.0;
		Double resultIntervalSum = 0.0;
		ExcelColumnsCalculation tc = new ExcelColumnsCalculation(
				venue == Venue.HOME ? nextFixture.getAwayTeam() : nextFixture.getHomeTeam(), em);
		Double opponentQuality = tc.getTeamQuality(s, nextFixture.getDate());

		for (Fixture f : fixtures) {
			ExcelColumnsCalculation tec = new ExcelColumnsCalculation(
					venue == Venue.HOME ? f.getAwayTeam() : f.getHomeTeam(), em);
			Double fixtureOpponentQuality = tec.getTeamQuality(s, nextFixture.getDate());

			if (fixtureOpponentQuality != null) {

				if (getResultType(f).equals(type))
					resultSum++;

				if (interval != null) {
					if (opponentQuality + interval >= fixtureOpponentQuality
							&& opponentQuality - interval <= fixtureOpponentQuality) {
						intervalSum++;

						if (getResultType(f).equals(type))
							resultIntervalSum++;
					}
				}

				opponentSum += fixtureOpponentQuality;
			}

		}
		int size = fixtures.size();
		return new TeamRating(size > 0 ? resultSum / size : 0, size > 0 ? opponentSum / size : 0,
				intervalSum > 0 ? resultIntervalSum / intervalSum : 0, intervalSum.intValue());
	}

	public Integer getNumberOfFixtures(Fixture nextFixture, Venue venue) {
		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
				nextFixture.getDate(), venue, null);
		return fixtures.size();
	}

	// Rating dos ultimos jogos, venue opcional, ratings ordenados por ordem
	// decrescente
	public Double getLastFixturesRatingQuality(Fixture nextFixture, Venue venue, Integer numberOfFixtures,
			List<Double> ratings, ResultType type) {
		if (ratings.size() != numberOfFixtures) {
			logger.debug("RATINGS SIZE != NUMBER OF FIXTURES");
			return null;
		}

		double rating = 0;

		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
				nextFixture.getDate(), venue, numberOfFixtures);

		for (int i = 0; i < fixtures.size(); i++) {
			Fixture f = fixtures.get(i);
			if (getResultType(f).equals(type)) {
				if (f.getHomeTeam().equals(team)) {
					ExcelColumnsCalculation opponentTeam = new ExcelColumnsCalculation(f.getAwayTeam(), em);
					rating += ratings.get(i)
							* opponentTeam.getTeamQuality(nextFixture.getSeason(), nextFixture.getDate());
				} else {
					ExcelColumnsCalculation opponentTeam = new ExcelColumnsCalculation(f.getHomeTeam(), em);
					rating += ratings.get(i)
							* opponentTeam.getTeamQuality(nextFixture.getSeason(), nextFixture.getDate());
				}
			}
		}

		return rating;
	}

	public Integer getGoals(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return s.getGoals();
		} else
			return null;
	}

	public Integer getGoalsAgainst(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return s.getGoalsAgainst();
		} else
			return null;
	}

	public Integer getGoalsDifference(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return s.getGoalsDifference();
		} else
			return null;
	}

	public Integer getHomeGoals(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return s.getHomeGoals();
		} else
			return null;
	}

	public Integer getHomeGoalsAgainst(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return s.getHomeGoalsAgainst();
		} else
			return null;
	}

	public Integer getHomeGoalsDifference(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return s.getHomeGoalsDifference();
		} else
			return null;
	}

	public Integer getAwayGoals(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return s.getAwayGoals();
		} else
			return null;
	}

	public Integer getAwayGoalsAgainst(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return s.getAwayGoalsAgainst();
		} else
			return null;
	}

	public Integer getAwayGoalsDifference(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return s.getAwayGoalsDifference();
		} else
			return null;
	}

	public Integer getClassification(Season season, Date date) {
		List<Team> ls = standingController.getTeamsOrderedByClassification(season, date);

		return ls.indexOf(team)+1;
	}

	/****************/
	/* AUX METHODS */
	/****************/

	public ResultType getResultType(Fixture fixture) {
		Result r = fixture.getResult();
		if (fixture.getHomeTeam().getId() == team.getId()) {
			if (r.getFullTimeHomeTeamGoals() > r.getFullTimeAwayTeamGoals())
				return ResultType.WIN;
			else if (r.getFullTimeHomeTeamGoals() < r.getFullTimeAwayTeamGoals())
				return ResultType.LOSE;
			else
				return ResultType.DRAW;
		} else {
			if (r.getFullTimeAwayTeamGoals() > r.getFullTimeHomeTeamGoals())
				return ResultType.WIN;
			else if (r.getFullTimeAwayTeamGoals() < r.getFullTimeHomeTeamGoals())
				return ResultType.LOSE;
			else
				return ResultType.DRAW;
		}
	}
}

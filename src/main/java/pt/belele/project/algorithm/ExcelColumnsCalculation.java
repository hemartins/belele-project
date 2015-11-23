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

	public Double[] getRecentFormResultPercentage(Fixture nextFixture, Venue venue, Integer numberOfFixtures,
			Double interval, ResultType type) {

		Double[] percentages = new Double[4];
		Double percentageHomeTeamCasa = 0.0;
		Double percentageAwayTeamFora = 0.0;
		Double percentageIntervalHomeTeamCasa = 0.0;
		Double percentageIntervalAwayTeamFora = 0.0;
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
		ExcelColumnsCalculation ecc;

		if (nextFixture.getHomeTeam().equals(team)) {
			ecc = new ExcelColumnsCalculation(nextFixture.getAwayTeam(), em);
		} else {
			ecc = new ExcelColumnsCalculation(nextFixture.getHomeTeam(), em);
		}

		Double opponentQuality = ecc.getTeamQuality(nextFixture.getSeason(), nextFixture.getDate());

		inferiorLimit = opponentQuality - 0.15;
		superiorLimit = opponentQuality + 0.15;

		for (Fixture f : fixtures) {

			if (f.getHomeTeam().equals(team)) {
				homeGames++;

				ExcelColumnsCalculation excc = new ExcelColumnsCalculation(f.getAwayTeam(), em);
				Double fixtureOpponentQuality = excc.getTeamQuality(f.getSeason(), f.getDate());

				if (fixtureOpponentQuality >= inferiorLimit && fixtureOpponentQuality <= superiorLimit) {
					homeIntervalGames++;

					if (getResultType(f).equals(type)) {
						resultTypeIntervalHomeTeamCasa++;
					}
				}

				if (f.getResult().getResultType().equals(type)) {
					resultTypeHomeTeamCasa++;
				}
			} else {
				awayGames++;

				ExcelColumnsCalculation excc = new ExcelColumnsCalculation(f.getHomeTeam(), em);
				Double fixtureOpponentQuality = excc.getTeamQuality(f.getSeason(), f.getDate());

				if (opponentQuality + interval >= fixtureOpponentQuality
						&& opponentQuality - interval <= fixtureOpponentQuality) {
					awayIntervalGames++;

					if (type.equals(ResultType.WIN)) {
						if (f.getResult().getResultType().equals(ResultType.LOSE)) {
							resultTypeIntervalAwayTeamFora++;
						}
					} else if (type.equals(ResultType.LOSE)) {
						if (f.getResult().getResultType().equals(ResultType.WIN)) {
							resultTypeIntervalAwayTeamFora++;
						}
					} else {
						if (f.getResult().getResultType().equals(ResultType.DRAW)) {
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
					} else {
						if (f.getResult().getResultType().equals(ResultType.DRAW)) {
							resultTypeAwayTeamFora++;
						}
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
		}
		percentages[0] = percentageHomeTeamCasa;
		percentages[1] = percentageAwayTeamFora;
		percentages[2] = percentageIntervalHomeTeamCasa;
		percentages[3] = percentageIntervalAwayTeamFora;

		return percentages;
	}

	public Integer[] getHomeAndAwayGames(Fixture nextFixture, Integer numberOfFixtures, ResultType type) {

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
					timeInYears = nextFixture.getSeason().getYear() - f.getSeason().getYear();
					if (timeInYears >= ratings.size())
						continue;

					ratingSum += ratings.get(timeInYears);

					if (getResultType(f).equals(type)) {
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

	public H2H getH2HRatingVenue(Fixture nextFixture, List<Double> ratings, Venue venue, ResultType type) {
		double rating = 0;
		double ratingSum = 0;
		double resultTypeRating = 0;
		int numberResults = 0;
		int timeInYears = 0;
		if (nextFixture.getH2HVenue() != null) {
			if (!nextFixture.getH2HVenue().isEmpty()) {
				for (Fixture f : nextFixture.getH2HVenue()) {
					timeInYears = nextFixture.getSeason().getYear() - f.getSeason().getYear();
					if (timeInYears >= ratings.size())
						continue;

					ratingSum += ratings.get(timeInYears);

					if (getResultType(f).equals(type)) {
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

	public H2H getH2HRatingSwitchedVenue(Fixture nextFixture, List<Double> ratings, Venue venue, ResultType type) {
		double rating = 0;
		double ratingSum = 0;
		double resultTypeRating = 0;
		int numberResults = 0;
		int timeInYears = 0;
		if (nextFixture.getH2HSwitchedVenue() != null) {
			if (!nextFixture.getH2HSwitchedVenue().isEmpty()) {
				for (Fixture f : nextFixture.getH2HSwitchedVenue()) {
					timeInYears = nextFixture.getSeason().getYear() - f.getSeason().getYear();
					if (timeInYears >= ratings.size())
						continue;

					ratingSum += ratings.get(timeInYears);

					if (getResultType(f).equals(type)) {
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

	// public H2H getH2HRating(Fixture nextFixture, List<Double> ratings, Venue
	// venue, ResultType type) {
	// double rating = 0;
	// double ratingSum = 0;
	// double resultTypeRating = 0;
	// int numberResults = 0;
	// double ratingVenue = 0;
	// double ratingSumVenue = 0;
	// double resultTypeRatingVenue = 0;
	// int numberResultsVenue = 0;
	// double ratingSwitchedVenue = 0;
	// double ratingSumSwitchedVenue = 0;
	// double resultTypeRatingSwitchedVenue = 0;
	// int numberResultsSwitchedVenue = 0;
	// int timeInYears = 0;
	// if (nextFixture.getH2h() != null) {
	// if (!nextFixture.getH2h().isEmpty()) {
	// for (Fixture f : nextFixture.getH2h()) {
	// timeInYears = nextFixture.getSeason().getYear() -
	// f.getSeason().getYear();
	// if (timeInYears >= ratings.size())
	// continue;
	//
	// ratingSum += ratings.get(timeInYears);
	// if (venue == Venue.HOME) {
	// if (f.getHomeTeam() == nextFixture.getHomeTeam()) {
	// if (getResultType(f).equals(type)) {
	// ratingVenue += ratings.get(timeInYears);
	// numberResultsVenue++;
	// } else {
	// ratingSwitchedVenue += ratings.get(timeInYears);
	// numberResultsSwitchedVenue++;
	// }
	// }
	// } else if (venue == Venue.AWAY) {
	// if (f.getAwayTeam() == nextFixture.getAwayTeam()) {
	// if (getResultType(f).equals(type)) {
	// rating += ratings.get(timeInYears);
	// numberResults++;
	// } else {
	// ratingSwitchedVenue += ratings.get(timeInYears);
	// numberResultsSwitchedVenue++;
	// }
	// }
	// } else {
	// if (getResultType(f).equals(type)) {
	// rating += ratings.get(timeInYears);
	// numberResults++;
	// }
	// }
	// }
	//
	// if (rating != 0) {
	// resultTypeRating = rating / ratingSum;
	// resultTypeRatingVenue = ratingVenue / ratingSumVenue;
	// resultTypeRatingSwitchedVenue = ratingSwitchedVenue /
	// ratingSumSwitchedVenue;
	// } else {
	// resultTypeRating = 0;
	// }
	// }
	// }
	// return new H2H(resultTypeRating, nextFixture.getH2h().size(),
	// numberResults, resultTypeRatingVenue,
	// nextFixture.getH2h().size(), numberResultsVenue,
	// resultTypeRatingSwitchedVenue,
	// nextFixture.getH2h().size(), numberResultsSwitchedVenue);
	// }

	public TeamRating getResultPercentage(Fixture nextFixture, Venue venue, ResultType type, Double interval,
			Integer numerberOfGames) {

		Season s = nextFixture.getSeason();
		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team, nextFixture.getSeason(),
				nextFixture.getDate(), venue, numerberOfGames);
		Double resultSum = 0.0;
		Double opponentSum = 0.0;
		Double intervalSum = 0.0;
		Double resultIntervalSum = 0.0;
		Double resultDificultSum = 0.0;
		Double intervalResultDificultSum = 0.0;
		ExcelColumnsCalculation tc;
		ExcelColumnsCalculation tec;

		// if (venue == Venue.HOME){
		// tc = new ExcelColumnsCalculation(nextFixture.getAwayTeam(), em);
		// }
		// else if (venue == Venue.AWAY){
		// tc = new ExcelColumnsCalculation(nextFixture.getHomeTeam(), em);
		// }
		// else{
		if (nextFixture.getHomeTeam() == team) {
			tc = new ExcelColumnsCalculation(nextFixture.getAwayTeam(), em);
		} else {
			tc = new ExcelColumnsCalculation(nextFixture.getHomeTeam(), em);
		}
		// }

		Double opponentQuality = tc.getTeamQuality(s, nextFixture.getDate());
		Double inferiorLimit = opponentQuality - interval;
		Double superiorLimit = opponentQuality + interval;

		for (Fixture f : fixtures) {
			// if (venue == Venue.HOME){
			// tec = new ExcelColumnsCalculation(f.getAwayTeam(), em);
			// }
			// else if (venue == Venue.AWAY){
			// tec = new ExcelColumnsCalculation(f.getHomeTeam(), em);
			// }
			// else{
			if (f.getHomeTeam() == team) {
				tec = new ExcelColumnsCalculation(f.getAwayTeam(), em);
			} else {
				tec = new ExcelColumnsCalculation(f.getHomeTeam(), em);
			}
			// }
			Double fixtureOpponentQuality = tec.getTeamQuality(s, nextFixture.getDate());

			if (fixtureOpponentQuality != null) {
				if (getResultType(f).equals(type)) {
					resultSum++;
					resultDificultSum += fixtureOpponentQuality;
				}

				if (interval != null) {
					if (fixtureOpponentQuality >= inferiorLimit && fixtureOpponentQuality <= superiorLimit) {
						intervalSum++;
						intervalResultDificultSum += fixtureOpponentQuality;

						if (getResultType(f).equals(type))
							resultIntervalSum++;

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

	public Integer getClassification(Season season, Date date) {
		List<Team> ls = standingController.getTeamsOrderedByClassification(season, date);

		return ls.indexOf(team) + 1;
	}

	public Double[] averageGoalsLastGames(Fixture nextFixture, Venue venue, Integer numerberOfGames) {

		Double[] avgGoalsFR = new Double[6];

		Double avgGoalsScoredTotal = 0.0;
		Double avgGoalsConcededTotal = 0.0;
		Double avgGoalsScoredHome = 0.0;
		Double avgGoalsConcededHome = 0.0;
		Double avgGoalsScoredAway = 0.0;
		Double avgGoalsConcededAway = 0.0;

		Double nrGoalsScoredTotal = 0.0;
		Double nrGoalsConcededTotal = 0.0;
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

		if (fixtures.size() == 0) {
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

	public List<Integer> getTopNumberOfGames(Team team, Season s, Date d, Venue v) {
		List<Integer> nrDeJogosTop = new ArrayList<Integer>();
		Integer nrVit = 0;
		Integer nrEmp = 0;
		Integer nrDer = 0;
		List<Fixture> f = fixtureController.getTeamBeforeFixtures(team, s, d, v, null);

		for (int i = 0; i < f.size(); i++) {
			ResultType res = getResultType(f.get(i));
			Team oponnent;
			if (v == Venue.HOME) {
				oponnent = f.get(i).getAwayTeam();
			} else {
				oponnent = f.get(i).getHomeTeam();
			}
			ExcelColumnsCalculation e = new ExcelColumnsCalculation(oponnent, em);
			Integer pos = e.getClassification(s, d);

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

	public List<Integer> getMsNumberOfGames(Team team, Season s, Date d, Venue v) {
		List<Integer> nrDeJogosMs = new ArrayList<Integer>();
		Integer nrVit = 0;
		Integer nrEmp = 0;
		Integer nrDer = 0;
		List<Fixture> f = fixtureController.getTeamBeforeFixtures(team, s, d, v, null);

		for (int i = 0; i < f.size(); i++) {
			ResultType res = getResultType(f.get(i));
			Team oponnent;
			if (v == Venue.HOME) {
				oponnent = f.get(i).getAwayTeam();
			} else {
				oponnent = f.get(i).getHomeTeam();
			}
			ExcelColumnsCalculation e = new ExcelColumnsCalculation(oponnent, em);
			Integer pos = e.getClassification(s, d);

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

	public List<Integer> getMiNumberOfGames(Team team, Season s, Date d, Venue v) {
		List<Integer> nrDeJogosMi = new ArrayList<Integer>();
		Integer nrVit = 0;
		Integer nrEmp = 0;
		Integer nrDer = 0;
		List<Fixture> f = fixtureController.getTeamBeforeFixtures(team, s, d, v, null);

		for (int i = 0; i < f.size(); i++) {
			ResultType res = getResultType(f.get(i));
			Team oponnent;
			if (v == Venue.HOME) {
				oponnent = f.get(i).getAwayTeam();
			} else {
				oponnent = f.get(i).getHomeTeam();
			}
			ExcelColumnsCalculation e = new ExcelColumnsCalculation(oponnent, em);
			Integer pos = e.getClassification(s, d);

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

	public List<Integer> getFracoNumberOfGames(Team team, Season s, Date d, Venue v) {
		List<Integer> nrDeJogosFraco = new ArrayList<Integer>();
		Integer nrVit = 0;
		Integer nrEmp = 0;
		Integer nrDer = 0;
		List<Fixture> f = fixtureController.getTeamBeforeFixtures(team, s, d, v, null);

		for (int i = 0; i < f.size(); i++) {
			ResultType res = getResultType(f.get(i));
			Team oponnent;
			if (v == Venue.HOME) {
				oponnent = f.get(i).getAwayTeam();
			} else {
				oponnent = f.get(i).getHomeTeam();
			}
			ExcelColumnsCalculation e = new ExcelColumnsCalculation(oponnent, em);
			Integer pos = e.getClassification(s, d);

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

	public List<Integer> getCycleInfo(Fixture nextFixture, Venue venue, ResultType res, Season s, Date date) {
		ResultCycle resCyc = this.getTeamCycle(nextFixture, venue, res);
		List<Team> teamsOp = resCyc.getTeams();
		int cicloTop, cicloMs, cicloMi, cicloFraco;
		cicloTop = cicloMs = cicloMi = cicloFraco = 0;
		List<Integer> listCy = new ArrayList<Integer>();

		if (resCyc.getCycle() > 0) {
			if (teamsOp.size() != 0) {
				for (int i = 0; i < teamsOp.size(); i++) {
					Team opponent = teamsOp.get(i);
					ExcelColumnsCalculation ex = new ExcelColumnsCalculation(opponent, em);
					int posOp = ex.getClassification(s, date);
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

		// System.out.println("Ciclo: "+resCyc.getCycle()+" Resultado =
		// "+resCyc.getType()+" Equipa: "+team+" Equipas:
		// "+resCyc.getTeams().toString());

		return listCy;
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

package pt.belele.project.alg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.joda.time.DateTime;
import org.joda.time.Days;

import pt.belele.project.controllers.FixtureController;
import pt.belele.project.controllers.StandingController;
import pt.belele.project.controllers.util.H2H;
import pt.belele.project.controllers.util.ResultCycle;
import pt.belele.project.controllers.util.TeamRating;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Head2Head;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Result.ResultType;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Standing;
import pt.belele.project.entities.Team;

public class Algorithm {
	private Team team;
	private FixtureController fixtureController;
	private StandingController standingController;
	private EntityManager em;

	public Algorithm(Team team, EntityManager em) {
		this.team = team;
		this.em = em;
		this.fixtureController = new FixtureController(em);
		this.standingController = new StandingController(em);
	}

	// Qualidade da equipa consoante competicao
	public Double getTeamQuality(Season season, Date date) {
		Standing s = standingController.getTeamStanding(season, team, date);
		if (s != null) {
			return (double) s.getPlayedGames() > 0 ? (double) s.getPoints()
					/ s.getPlayedGames() : 0;
		} else
			return null;

	}

	// Dias de descanso antes do jogo
	public Integer getRestingDays(Fixture nextFixture) {
		Fixture f = fixtureController.getTeamFixtureBeforeDate(team,
				nextFixture.getSeason(), nextFixture.getDate());
		DateTime fixtureDate = new DateTime(f.getDate());
		Days days = Days.daysBetween(fixtureDate,
				new DateTime(nextFixture.getDate()));
		int nmrDays = days.getDays();
		return nmrDays + 1;
	}

	// Rating dos ultimos jogos, venue opcional, ratings ordenados por ordem
	// decrescente
	public Double getLastFixturesRating(Fixture nextFixture, Venue venue,
			Integer numberOfFixtures, List<Double> ratings, ResultType type) {
		if (ratings.size() != numberOfFixtures) {
			System.out.println("RATINGS SIZE != NUMBER OF FIXTURES");
			return null;
		}

		double rating = 0;

		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team,
				nextFixture.getSeason(), nextFixture.getDate(), venue,
				numberOfFixtures);
		for (int i = 0; i < fixtures.size(); i++) {
			Fixture f = fixtures.get(i);
			if (getResultType(f).equals(type))
				rating += ratings.get(ratings.size() - 1 - i);
		}

		return rating;
	}

	// Media da qualidade das ultimas equipas defrontadas
	public Double getLastFixturesOpponentAverageQuality(Fixture nextFixture,
			Venue venue, Integer numberOfFixtures) {
		double sum = 0;
		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team,
				nextFixture.getSeason(), nextFixture.getDate(), venue,
				numberOfFixtures);
		for (Fixture f : fixtures) {
			if (f.getHomeTeam().getId() == team.getId()) {
				Algorithm tc = new Algorithm(f.getAwayTeam(), em);
				sum += tc.getTeamQuality(nextFixture.getSeason(),
						nextFixture.getDate());
			} else {
				Algorithm tc = new Algorithm(f.getHomeTeam(), em);
				sum += tc.getTeamQuality(nextFixture.getSeason(),
						nextFixture.getDate());
			}
		}
		return fixtures.size() > 0 ? sum / fixtures.size() : 0;
	}

	// Numero de historicos defrontados
	public Integer getLastHardGamesFixturesNumber(Fixture nextFixture,
			Venue venue, Integer numberOfFixtures, List<String> hardTeamsIds) {

		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team,
				nextFixture.getSeason(), nextFixture.getDate(), venue,
				numberOfFixtures);

		int sum = 0;

		for (Fixture f : fixtures) {
			if ((hardTeamsIds.contains(f.getAwayTeam().getName()) && f
					.getAwayTeam().getId() != team.getId())
					|| (hardTeamsIds.contains(f.getHomeTeam().getName()) && f
							.getHomeTeam().getId() != team.getId())) {
				sum++;
			}
		}
		return sum;
	}

	// Calculo ciclos
	public ResultCycle getTeamCycle(Fixture nextFixture, Venue venue,
			ResultType type) {
		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team,
				nextFixture.getSeason(), nextFixture.getDate(), venue, null);
		boolean equals = false;
		ResultType actualResult = null;
		int sum = 0;
		List<Team> teams = new ArrayList<Team>();
		for (int i = fixtures.size() - 1; i >= 0; i--) {
			Fixture f = fixtures.get(i);
			if (actualResult == null) {
				actualResult = getResultType(f);
				if (actualResult.equals(type)) {
					sum++;
					equals = true;
				} else
					sum--;
			} else {
				if (!actualResult.equals(getResultType(f))) {
					actualResult = getResultType(f);
					equals = false;
				}

				if (actualResult.equals(type) && equals)
					sum++;
				else if (!actualResult.equals(type) && equals)
					sum--;
				else
					break;
			}

			if (f.getHomeTeam().getId() == team.getId())
				teams.add(f.getAwayTeam());
			else
				teams.add(f.getHomeTeam());
		}

		return new ResultCycle(nextFixture.getSeason(), type, teams, sum,
				new DateTime(nextFixture.getDate()));
	}

	// Media da qualidade das equipas dum ciclo
	public Double getCycleOpponentAverageQuality(ResultCycle cycle) {
		double sum = 0;
		for (Team t : cycle.getTeams()) {
			Algorithm tc = new Algorithm(t, em);
			sum += tc.getTeamQuality(cycle.getSeason(), cycle.getDate()
					.toDate());
		}
		return cycle.getTeams().size() > 0 ? sum / cycle.getTeams().size() : 0;
	}

	// Numero de historicos defrontados num ciclo
	public Integer getCycleHardGamesNumber(ResultCycle cycle,
			List<String> hardTeamsIds) {
		int sum = 0;

		for (Team t : cycle.getTeams()) {
			if (hardTeamsIds.contains(t.getName())) {
				sum++;
			}
		}

		return sum;
	}

	// Rating do h2h
	@SuppressWarnings("deprecation")
	public H2H getH2HRating(Fixture nextFixture, List<Double> ratings,
			Venue venue, ResultType type) {
		double rating = 0;
		Head2Head h2h = nextFixture.getHead2Head();
		int rat = 0;
		if (h2h != null) {
			for (int i = 0; i < h2h.getFixtures().size()
					&& rat < ratings.size(); i++) {
				Fixture f = h2h.getFixtures().get(i);
				if (f.getDate().getYear() + ratings.size() + 2 < nextFixture
						.getDate().getYear())
					break;
				boolean isVenue = venue.equals(Venue.HOME) ? f.getHomeTeam()
						.getId() == team.getId()
						: f.getAwayTeam().getId() == team.getId();
				boolean seasonBefore = f.getSeason().getYear() >= nextFixture
						.getSeason().getYear() - (ratings.size());
				boolean isBefore = new DateTime(f.getDate())
						.isBefore(new DateTime(nextFixture.getDate()));
				if (isVenue && seasonBefore && isBefore) {
					if (getResultType(f).equals(type))
						rating += ratings.get(rat);
					rat++;
				}
			}
		}

		return new H2H(rating, rat);
	}

	public TeamRating getResultPercentage(Fixture nextFixture, Venue venue,
			ResultType type, Double interval) {
		Season s = nextFixture.getSeason();
		List<Fixture> fixtures = fixtureController.getTeamBeforeFixtures(team,
				nextFixture.getSeason(), nextFixture.getDate(), venue, null);
		Double resultSum = 0.0;
		Double opponentSum = 0.0;
		Double intervalSum = 0.0;
		Double resultIntervalSum = 0.0;
		Algorithm tc = new Algorithm(
				venue == Venue.HOME ? nextFixture.getAwayTeam()
						: nextFixture.getHomeTeam(), em);
		Double opponentQuality = tc.getTeamQuality(s, nextFixture.getDate());

		for (Fixture f : fixtures) {
			Algorithm tec = new Algorithm(venue == Venue.HOME ? f.getAwayTeam()
					: f.getHomeTeam(), em);
			Double fixtureOpponentQuality = tec.getTeamQuality(s,
					nextFixture.getDate());

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
		return new TeamRating(size > 0 ? resultSum / size : 0,
				size > 0 ? opponentSum / size : 0,
				intervalSum > 0 ? resultIntervalSum / intervalSum : 0,
				intervalSum.intValue());
	}

	/****************/
	/* AUX METHODS */
	/****************/

	public ResultType getResultType(Fixture fixture) {
		Result r = fixture.getResult();
		if (fixture.getHomeTeam().getId() == team.getId()) {
			if (r.getFullTimeHomeTeamGoals() > r.getFullTimeAwayTeamGoals())
				return ResultType.WIN;
			else if (r.getFullTimeHomeTeamGoals() < r
					.getFullTimeAwayTeamGoals())
				return ResultType.LOSE;
			else
				return ResultType.DRAW;
		} else {
			if (r.getFullTimeAwayTeamGoals() > r.getFullTimeHomeTeamGoals())
				return ResultType.WIN;
			else if (r.getFullTimeAwayTeamGoals() < r
					.getFullTimeHomeTeamGoals())
				return ResultType.LOSE;
			else
				return ResultType.DRAW;
		}
	}
}

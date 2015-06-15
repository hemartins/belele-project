package pt.belele.project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

import pt.belele.project.controllers.util.ResultCycle;
import pt.belele.project.controllers.util.TeamRating;
import pt.belele.project.data.Fixture;
import pt.belele.project.data.Head2Head;
import pt.belele.project.data.Season;
import pt.belele.project.data.Standing;
import pt.belele.project.data.Team;
import pt.belele.project.enums.FixtureStatus;
import pt.belele.project.enums.ResultType;
import pt.belele.project.enums.Venue;
import pt.belele.project.resources.Result;

public class TeamController {
	private Team team;

	public TeamController(Team team) {
		this.team = team;
	}

	// Qualidade da equipa consoante competicao
	public Double getTeamQuality(Season season) {
		Standing s = getTeamStanding(season);
		if (s != null) {
			return s.getPoints().doubleValue()
					/ s.getPlayedGames().doubleValue();
		} else
			return null;

	}

	// Dias de descanso antes do jogo
	public Integer getRestingDays(Fixture nextFixture) {
		return Days.daysBetween(
				getBeforeFixture(
						Integer.valueOf(nextFixture.getSeason().getYear()),
						nextFixture.getDate(), null).getDate(),
				nextFixture.getDate()).getDays();
	}

	// Rating dos ultimos jogos, venue opcional, ratings ordenados por ordem
	// crescente
	public Double getLastFixturesRating(Fixture nextFixture, Venue venue,
			Integer numberOfFixtures, List<Double> ratings, ResultType type) {
		if (ratings.size() != numberOfFixtures) {
			System.out.println("RATINGS SIZE != NUMBER OF FIXTURES");
			return null;
		}

		double rating = 0;

		List<Fixture> fixtures = getBeforeFixtures(nextFixture.getSeason(),
				nextFixture.getMatchday(), venue, numberOfFixtures);
		for (int i = 0; i < fixtures.size(); i++) {
			Fixture f = fixtures.get(i);
			if (getResultType(f).equals(type))
				rating += ratings.get(i);
		}

		return rating;
	}

	// Media da qualidade das ultimas equipas defrontadas
	public Double getLastFixturesOpponentAverageQuality(Fixture nextFixture,
			Venue venue, Integer numberOfFixtures) {
		double sum = 0;
		List<Fixture> fixtures = getBeforeFixtures(nextFixture.getSeason(),
				nextFixture.getMatchday(), venue, numberOfFixtures);
		for (Fixture f : fixtures) {
			if (f.getHomeTeam().equals(team)) {
				TeamController tc = new TeamController(f.getAwayTeam());
				sum += tc.getTeamQuality(nextFixture.getSeason());
			} else {
				TeamController tc = new TeamController(f.getHomeTeam());
				sum += tc.getTeamQuality(nextFixture.getSeason());
			}
		}
		return sum / fixtures.size();
	}

	// Numero de historicos defrontados
	public Integer getLastHardGamesFixturesNumber(Fixture nextFixture,
			Venue venue, Integer numberOfFixtures) {
		System.out.println("NOT YET IMPLEMENTED");
		return null;
	}

	// Calculo ciclos
	public ResultCycle getTeamCycle(Fixture nextFixture, Venue venue,
			ResultType type) {
		List<Fixture> fixtures = getBeforeFixtures(nextFixture.getSeason(),
				nextFixture.getMatchday(), venue, nextFixture.getMatchday());
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
				else if (!actualResult.equals(type) && !equals)
					sum--;
				else
					break;
			}

			if (f.getHomeTeam().equals(team))
				teams.add(f.getAwayTeam());
			else
				teams.add(f.getHomeTeam());
		}

		return new ResultCycle(nextFixture.getSeason(), type, teams, sum);
	}

	// Media da qualidade das equipas dum ciclo
	public Double getCycleOpponentAverageQuality(ResultCycle cycle) {
		double sum = 0;
		for (Team t : cycle.getTeams()) {
			TeamController tc = new TeamController(t);
			sum += tc.getTeamQuality(cycle.getSeason());
		}
		return sum / cycle.getTeams().size();
	}

	// Numero de historicos defrontados num ciclo
	public Integer getCycleHardGamesNumber(ResultCycle cycle) {
		System.out.println("NOT YET IMPLEMENTED");
		return null;
	}

	// Rating do h2h
	public Double getH2HRating(Fixture nextFixture, List<Double> ratings,
			ResultType type) {
		double rating = 0;
		Head2Head h2h = nextFixture.getHead2Head();
		for (int i = 0; i < h2h.getFixtures().size(); i++) {
			if (i < ratings.size()) {
				Fixture f = h2h.getFixtures().get(i);
				if (getResultType(f).equals(type))
					rating += ratings.get(i);
			}
		}

		return rating;
	}

	public TeamRating getResultPercentage(Fixture nextFixture, Venue venue,
			ResultType type, Double interval) {
		Season s = nextFixture.getSeason();
		List<Fixture> fixtures = team.getFixtures(Integer.valueOf(s.getYear()),
				venue);
		Double resultSum = 0.0;
		Double opponentSum = 0.0;
		Double intervalSum = 0.0;
		TeamController tc = new TeamController(
				venue == Venue.home ? nextFixture.getAwayTeam()
						: nextFixture.getHomeTeam());
		Double opponentQuality = tc.getTeamQuality(s);

		for (Fixture f : fixtures) {
			TeamController tec = new TeamController(
					venue == Venue.home ? f.getAwayTeam() : f.getHomeTeam());
			Double fixtureOpponentQuality = tec.getTeamQuality(s);

			if (fixtureOpponentQuality != null) {

				if (getResultType(f).equals(type)) {
					resultSum++;
					if (interval != null) {
						if (opponentQuality + interval >= fixtureOpponentQuality
								&& opponentQuality - interval <= fixtureOpponentQuality)
							intervalSum++;
					}
				}

				opponentSum += fixtureOpponentQuality;
			}

		}
		int size = fixtures.size();
		return new TeamRating(resultSum / size, opponentSum / size, intervalSum
				/ resultSum, resultSum.intValue());
	}

	/****************/
	/* AUX METHODS */
	/****************/

	// Ultimo jogo antes da data, venue é opcional
	public Fixture getBeforeFixture(Integer year, DateTime date, Venue venue) {
		Fixture fixture = null;
		for (Fixture f : team.getFixtures(year, venue)) {
			if (fixture == null)
				fixture = f;
			else {
				if (f.getDate().isAfter(fixture.getDate())
						&& f.getDate().isBefore(date))
					fixture = f;
			}
		}
		return fixture;
	}

	// Ultimos jogos antes da data, por competição, venue é opcional
	public List<Fixture> getBeforeFixtures(Season season, Integer matchday,
			Venue venue, Integer numberOfFixtures) {
		List<Fixture> fixtures = new ArrayList<Fixture>();
		for (Fixture f : team.getFixtures(Integer.valueOf(season.getYear()),
				venue)) {
			if (f.getMatchday() < matchday
					&& f.getSeason().getCaption().equals(season.getCaption()))
				fixtures.add(f);
		}
		return fixtures.subList(
				fixtures.size() - 1 - numberOfFixtures > 0 ? fixtures.size()
						- 1 - numberOfFixtures : 0, fixtures.size() - 1);
	}

	// Ultimo jogo jogado
	public Fixture getLastFixturePlayed() {
		Fixture fixture = null;
		for (Fixture f : team.getFixtures()) {
			if (f.getStatus().equals(FixtureStatus.FINISHED)) {
				if (fixture == null)
					fixture = f;
				else {
					if (f.getDate().isAfter(fixture.getDate()))
						fixture = f;
				}
			}
		}
		return fixture;
	}

	// Classificação da equipa consoante competicao e epoca
	public Standing getTeamStanding(Season season) {
		List<Standing> standings = season.getLeagueTable().getStanding();
		for (Standing s : standings) {
			if (s.getTeamName().equals(team.getName())) {
				return s;
			}
		}
		System.out.println("STANDING NOT FOUND!");
		return null;
	}

	public ResultType getResultType(Fixture fixture) {
		Result r = fixture.getResult();
		if (fixture.getHomeTeam().equals(team)) {
			if (r.getGoalsHomeTeam() > r.getGoalsAwayTeam())
				return ResultType.WIN;
			else if (r.getGoalsHomeTeam() < r.getGoalsAwayTeam())
				return ResultType.LOSE;
			else
				return ResultType.DRAW;
		} else {
			if (r.getGoalsAwayTeam() > r.getGoalsHomeTeam())
				return ResultType.WIN;
			else if (r.getGoalsAwayTeam() < r.getGoalsHomeTeam())
				return ResultType.LOSE;
			else
				return ResultType.DRAW;
		}
	}
}

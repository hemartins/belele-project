package pt.belele.project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

import pt.belele.project.controllers.util.H2H;
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
	public Double getTeamQuality(Season season, int matchday) {
		Standing s = getTeamStanding(season, matchday);
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
				nextFixture.getDate()).getDays() + 1;
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

		List<Fixture> fixtures = getBeforeFixtures(nextFixture.getSeason(),
				nextFixture.getMatchday(), venue, numberOfFixtures);
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
		List<Fixture> fixtures = getBeforeFixtures(nextFixture.getSeason(),
				nextFixture.getMatchday(), venue, numberOfFixtures);
		for (Fixture f : fixtures) {
			if (f.getHomeTeamId().equals(team.getId())) {
				TeamController tc = new TeamController(f.getAwayTeam());
				sum += tc.getTeamQuality(nextFixture.getSeason(),
						nextFixture.getMatchday() - 1);
			} else {
				TeamController tc = new TeamController(f.getHomeTeam());
				sum += tc.getTeamQuality(nextFixture.getSeason(),
						nextFixture.getMatchday() - 1);
			}
		}
		return sum / fixtures.size();
	}

	// Numero de historicos defrontados
	public Integer getLastHardGamesFixturesNumber(Fixture nextFixture,
			Venue venue, Integer numberOfFixtures, List<Integer> hardTeamsIds) {

		List<Fixture> fixtures = getBeforeFixtures(nextFixture.getSeason(),
				nextFixture.getMatchday(), venue, numberOfFixtures);

		int sum = 0;

		for (Fixture f : fixtures) {
			if (hardTeamsIds.contains(f.getAwayTeamId())
					|| hardTeamsIds.contains(f.getHomeTeamId())) {
				sum++;
			}
		}
		return sum;
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
				else if (!actualResult.equals(type) && equals)
					sum--;
				else
					break;
			}

			if (f.getHomeTeam().getId().equals(team.getId()))
				teams.add(f.getAwayTeam());
			else
				teams.add(f.getHomeTeam());
		}

		return new ResultCycle(nextFixture.getSeason(), type, teams, sum,
				nextFixture.getMatchday());
	}

	// Media da qualidade das equipas dum ciclo
	public Double getCycleOpponentAverageQuality(ResultCycle cycle) {
		double sum = 0;
		for (Team t : cycle.getTeams()) {
			TeamController tc = new TeamController(t);
			sum += tc
					.getTeamQuality(cycle.getSeason(), cycle.getMatchday() - 1);
		}
		return sum / cycle.getTeams().size();
	}

	// Numero de historicos defrontados num ciclo
	public Integer getCycleHardGamesNumber(ResultCycle cycle,
			List<Integer> hardTeamsIds) {
		int sum = 0;

		for (Team t : cycle.getTeams()) {
			if (hardTeamsIds.contains(t.getId())) {
				sum++;
			}
		}

		return sum;
	}

	// Rating do h2h
	public H2H getH2HRating(Fixture nextFixture, List<Double> ratings,
			Venue venue, ResultType type) {
		double rating = 0;
		Head2Head h2h = nextFixture.getHead2Head();
		int rat = 0;
		for (int i = 0; i < h2h.getFixtures().size() && rat < ratings.size(); i++) {
			Fixture f = h2h.getFixtures().get(i);
			if (venue.equals(Venue.home) ? f.getHomeTeamId().equals(
					team.getId()) : f.getAwayTeamId().equals(team.getId())) {
				if (getResultType(f).equals(type))
					rating += ratings.get(rat);
				rat++;
			}
		}

		return new H2H(rating, rat);
	}

	public TeamRating getResultPercentage(Fixture nextFixture, Venue venue,
			ResultType type, Double interval) {
		Season s = nextFixture.getSeason();
		List<Fixture> fixtures = getBeforeFixtures(nextFixture.getSeason(),
				nextFixture.getMatchday(), venue, nextFixture.getMatchday());
		Double resultSum = 0.0;
		Double opponentSum = 0.0;
		Double intervalSum = 0.0;
		Double resultIntervalSum = 0.0;
		TeamController tc = new TeamController(
				venue == Venue.home ? nextFixture.getAwayTeam()
						: nextFixture.getHomeTeam());
		Double opponentQuality = tc.getTeamQuality(s,
				nextFixture.getMatchday() - 1);

		for (Fixture f : fixtures) {
			TeamController tec = new TeamController(
					venue == Venue.home ? f.getAwayTeam() : f.getHomeTeam());
			Double fixtureOpponentQuality = tec.getTeamQuality(s,
					nextFixture.getMatchday() - 1);

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
		return new TeamRating(resultSum / size, opponentSum / size,
				resultIntervalSum / intervalSum, intervalSum.intValue());
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
					&& f.getSeasonId().equals(season.getId()))
				fixtures.add(f);
		}
		return fixtures.subList(
				fixtures.size() - numberOfFixtures > 0 ? fixtures.size()
						- numberOfFixtures : 0, fixtures.size());
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
	public Standing getTeamStanding(Season season, int matchday) {
		List<Standing> standings = season.getLeagueTable(matchday)
				.getStanding();
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
		if (fixture.getHomeTeamId().equals(team.getId())) {
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

package pt.belele.project;

import java.util.ArrayList;
import java.util.List;

import pt.belele.project.alg.ProfHomeWinRow;
import pt.belele.project.controllers.TeamController;
import pt.belele.project.controllers.util.ResultCycle;
import pt.belele.project.data.Fixture;
import pt.belele.project.data.Season;
import pt.belele.project.enums.League;
import pt.belele.project.enums.ResultType;
import pt.belele.project.enums.Venue;

public class Main
{

	public static void main(String[] args)
	{
		Season s = new Season(League.Italy.SERIE_A, 2014);
		List<Fixture> fixtures = s.getFixtures();
		Fixture f = fixtures.get(fixtures.size() - 2);

		TeamController homeTeam = new TeamController(f.getHomeTeam());
		TeamController awayTeam = new TeamController(f.getAwayTeam());
		List<Double> ratings = new ArrayList<Double>();
		ratings.add(0.1);
		ratings.add(0.15);
		ratings.add(0.2);
		ratings.add(0.25);
		ratings.add(0.3);

		Integer jornada = f.getMatchday();
		String idVisitado = f.getHomeTeamName();
		String idVisitante = f.getAwayTeamName();
		Double qualidadeVisitado = homeTeam.getTeamQuality(s);
		Double qualidadeVisitante = awayTeam.getTeamQuality(s);
		Integer fR_diasDescansoVisitado = homeTeam.getRestingDays(f);
		Integer fR_diasDescansoFRVisitante = awayTeam.getRestingDays(f);
		Double fR_ratingVitoriasFRVisitado = homeTeam.getLastFixturesRating(f, Venue.home, 5, ratings, ResultType.WIN);
		Double fR_ratingDerrotasFRVisitante = awayTeam.getLastFixturesRating(f, Venue.away, 5, ratings, ResultType.LOSE);
		Double fR_dificuldadeVisitado = homeTeam.getLastFixturesOpponentAverageQuality(f, Venue.home, 5);
		Double fR_dificuldadeVisistante = awayTeam.getLastFixturesOpponentAverageQuality(f, Venue.away, 5);
		Integer fR_HistoricosVisitado = homeTeam.getLastHardGamesFixturesNumber(f, Venue.home, 5);
		Integer fR_HistoricosVisitante = awayTeam.getLastHardGamesFixturesNumber(f, Venue.home, 5);
		ResultCycle homeCycle = homeTeam.getTeamCycle(f, Venue.home, ResultType.WIN);
		ResultCycle awayCycle = awayTeam.getTeamCycle(f, Venue.away, ResultType.LOSE);
		Integer ciclo_numeroJogosVisitado = homeCycle.getCycle();
		Integer ciclo_numeroJogosVisitante = awayCycle.getCycle();
		Double ciclo_dificuldadeVisitado = homeTeam.getCycleOpponentAverageQuality(homeCycle);
		Double ciclo_dificuldadeVisitante = awayTeam.getCycleOpponentAverageQuality(awayCycle);
		Integer ciclo_HistoricosVisitado = homeTeam.getCycleHardGamesNumber(homeCycle);
		Integer ciclo_HistoricosVisitante = awayTeam.getCycleHardGamesNumber(awayCycle);
		Double h2h_ratingVitorias = homeTeam.getH2HRating(f, ratings, ResultType.WIN);
		Integer h2h_numeroJogos = ratings.size();

		ProfHomeWinRow phwr = new ProfHomeWinRow(jornada, idVisitado, idVisitante, qualidadeVisitado, qualidadeVisitante, fR_diasDescansoVisitado,
				fR_diasDescansoFRVisitante, fR_ratingVitoriasFRVisitado, fR_ratingDerrotasFRVisitante, fR_dificuldadeVisitado, fR_dificuldadeVisistante,
				fR_HistoricosVisitado, fR_HistoricosVisitante, ciclo_numeroJogosVisitado, ciclo_numeroJogosVisitante, ciclo_dificuldadeVisitado,
				ciclo_dificuldadeVisitante, ciclo_HistoricosVisitado, ciclo_HistoricosVisitante, h2h_ratingVitorias, h2h_numeroJogos);
		System.out.println(phwr.toString());
	}
}

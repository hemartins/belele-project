package pt.belele.project;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import pt.belele.project.alg.OurRow;
import pt.belele.project.alg.ProfRow;
import pt.belele.project.controllers.TeamController;
import pt.belele.project.controllers.util.H2H;
import pt.belele.project.controllers.util.ResultCycle;
import pt.belele.project.controllers.util.TeamRating;
import pt.belele.project.data.Fixture;
import pt.belele.project.data.Season;
import pt.belele.project.enums.League;
import pt.belele.project.enums.ResultType;
import pt.belele.project.enums.Venue;
import pt.belele.project.util.WriteToExcel;

public class Main {

	public static void main(String[] args) {
		boolean generateProf = true;
		boolean generateOurs = false;
		String filePath = "/Users/p056913/Desktop/";

		if (args.length != 3) {
			System.out
					.println("USAGE java -jar belele-project.jar generateProf(true or false) generateOurs(true or false) fileGenerationPath");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			generateProf = Boolean.valueOf(args[0]);
			generateOurs = Boolean.valueOf(args[1]);
			filePath = args[2];
		}
		System.out.println("RUNNING AS: java -jar belele-project.jar "
				+ generateProf + " " + generateOurs + " " + filePath);

		WriteToExcel writeToExcelObj = new WriteToExcel(filePath);

		List<OurRow> OurWinDataList = new ArrayList<OurRow>();
		List<OurRow> OurDrawDataList = new ArrayList<OurRow>();
		List<OurRow> OurLoseDataList = new ArrayList<OurRow>();

		List<ProfRow> ProfWinDataList = new ArrayList<ProfRow>();
		List<ProfRow> ProfDrawDataList = new ArrayList<ProfRow>();
		List<ProfRow> ProfLoseDataList = new ArrayList<ProfRow>();

		Season s = new Season(League.Italy.SERIE_A, 2014);

		List<Integer> historicos = new ArrayList<Integer>();
		historicos.add(109);// JUVENTUS
		historicos.add(100);// ROMA
		historicos.add(98);// MILAN
		historicos.add(113);// NAPOLI
		historicos.add(108);// INTER

		for (int round = 38; round >= 14; round--) {

			for (Fixture f : s.getFixtures(round)) {

				TeamController homeTeam = new TeamController(f.getHomeTeam());
				TeamController awayTeam = new TeamController(f.getAwayTeam());
				List<Double> ratings = new ArrayList<Double>();
				ratings.add(0.3);
				ratings.add(0.25);
				ratings.add(0.2);
				ratings.add(0.15);
				ratings.add(0.1);

				Integer jornada = f.getMatchday();
				Integer idVisitado = f.getHomeTeam().getId();
				Integer idVisitante = f.getAwayTeam().getId();
				Double qualidadeVisitado = homeTeam.getTeamQuality(s,
						f.getMatchday() - 1);
				Double qualidadeVisitante = awayTeam.getTeamQuality(s,
						f.getMatchday() - 1);
				Integer fR_diasDescansoVisitado = homeTeam.getRestingDays(f);
				Integer fR_diasDescansoVisitante = awayTeam.getRestingDays(f);
				Double fR_ratingVitoriasVisitado = homeTeam
						.getLastFixturesRating(f, null, 5, ratings,
								ResultType.WIN);
				Double fR_ratingDerrotasVisitante = awayTeam
						.getLastFixturesRating(f, null, 5, ratings,
								ResultType.LOSE);
				Double fR_dificuldadeVisitado = homeTeam
						.getLastFixturesOpponentAverageQuality(f, null, 5);
				Double fR_dificuldadeVisistante = awayTeam
						.getLastFixturesOpponentAverageQuality(f, null, 5);
				Integer fR_HistoricosVisitado = homeTeam
						.getLastHardGamesFixturesNumber(f, null, 5,
								historicos);
				Integer fR_HistoricosVisitante = awayTeam
						.getLastHardGamesFixturesNumber(f, null, 5,
								historicos);
				ResultCycle homeWinCycle = homeTeam.getTeamCycle(f, Venue.home,
						ResultType.WIN);
				ResultCycle awayLoseCycle = awayTeam.getTeamCycle(f,
						Venue.away, ResultType.LOSE);
				Integer homeWinCycle_numeroJogosVisitado = homeWinCycle
						.getCycle();
				Integer awayLoseCycle_numeroJogosVisitante = awayLoseCycle
						.getCycle();
				Double homeWinCycle_dificuldadeVisitado = homeTeam
						.getCycleOpponentAverageQuality(homeWinCycle);
				Double awayLoseCycle_dificuldadeVisitante = awayTeam
						.getCycleOpponentAverageQuality(awayLoseCycle);
				Integer homeWinCycle_HistoricosVisitado = homeTeam
						.getCycleHardGamesNumber(homeWinCycle, historicos);
				Integer awayLoseCycle_HistoricosVisitante = awayTeam
						.getCycleHardGamesNumber(awayLoseCycle, historicos);
				H2H h2hRatings = homeTeam.getH2HRating(f, ratings, Venue.home,
						ResultType.WIN);
				Double h2hWin_ratingVitorias = h2hRatings.getRating();
				Integer h2hWin_numeroJogos = h2hRatings.getSize();
				ResultType result = homeTeam.getResultType(f);

				Double fR_ratingEmpatesVisitado = homeTeam
						.getLastFixturesRating(f, null, 5, ratings,
								ResultType.DRAW);
				Double fR_ratingEmpatesVisitante = awayTeam
						.getLastFixturesRating(f, null, 5, ratings,
								ResultType.DRAW);
				ResultCycle homeDrawCycle = homeTeam.getTeamCycle(f,
						Venue.home, ResultType.DRAW);
				ResultCycle awayDrawCycle = awayTeam.getTeamCycle(f,
						Venue.away, ResultType.DRAW);
				Integer homeDrawCycle_numeroJogosVisitado = homeDrawCycle
						.getCycle();
				Integer awayDrawCycle_numeroJogosVisitante = awayDrawCycle
						.getCycle();
				Double homeDrawCycle_dificuldadeVisitado = homeTeam
						.getCycleOpponentAverageQuality(homeDrawCycle);
				Double awayDrawCycle_dificuldadeVisitante = awayTeam
						.getCycleOpponentAverageQuality(awayDrawCycle);
				Integer homeDrawCycle_HistoricosVisitado = homeTeam
						.getCycleHardGamesNumber(homeDrawCycle, historicos);
				Integer awayDrawCycle_HistoricosVisitante = awayTeam
						.getCycleHardGamesNumber(awayDrawCycle, historicos);
				h2hRatings = homeTeam.getH2HRating(f, ratings, Venue.home,
						ResultType.DRAW);
				Double h2hDraw_rating = h2hRatings.getRating();
				Integer h2hDraw_numeroJogos = h2hRatings.getSize();

				Double fR_ratingDerrotasVisitado = homeTeam
						.getLastFixturesRating(f, null, 5, ratings,
								ResultType.LOSE);
				Double fR_ratingVitoriasVisitante = awayTeam
						.getLastFixturesRating(f, null, 5, ratings,
								ResultType.WIN);
				ResultCycle homeLoseCycle = homeTeam.getTeamCycle(f,
						Venue.home, ResultType.LOSE);
				ResultCycle awayWinCycle = awayTeam.getTeamCycle(f, Venue.away,
						ResultType.WIN);
				Integer homeLoseCycle_numeroJogosVisitado = homeLoseCycle
						.getCycle();
				Integer awayWinCycle_numeroJogosVisitante = awayWinCycle
						.getCycle();
				Double homeLoseCycle_dificuldadeVisitado = homeTeam
						.getCycleOpponentAverageQuality(homeLoseCycle);
				Double awayWinCycle_dificuldadeVisitante = awayTeam
						.getCycleOpponentAverageQuality(awayWinCycle);
				Integer homeLoseCycle_HistoricosVisitado = homeTeam
						.getCycleHardGamesNumber(homeLoseCycle, historicos);
				Integer awayWinCycle_HistoricosVisitante = awayTeam
						.getCycleHardGamesNumber(awayWinCycle, historicos);
				h2hRatings = homeTeam.getH2HRating(f, ratings, Venue.home,
						ResultType.LOSE);
				Double h2hLose_rating = h2hRatings.getRating();
				Integer h2hLose_numeroJogos = h2hRatings.getSize();
				if (generateOurs) {
					TeamRating homeTR = homeTeam.getResultPercentage(f,
							Venue.home, ResultType.WIN, 0.15);
					TeamRating awayTR = awayTeam.getResultPercentage(f,
							Venue.away, ResultType.LOSE, 0.15);
					Double qLT_percentagemVitoriasVisitado = homeTR
							.getResultPercentage();
					Double qLT_percentagemDerrotasVisitante = awayTR
							.getResultPercentage();
					Double qLT_dificuldadeVitoriasVisitado = homeTR
							.getQualityAverage();
					Double qLT_dificuldadeDerrotasVisitante = awayTR
							.getQualityAverage();
					Double qLT_percentagemVitoriasVisitadoNoIntervalo = homeTR
							.getResultIntervalPercentage();
					Double qLT_percentagemDerrotasVisitanteNoIntervalo = awayTR
							.getResultIntervalPercentage();
					Integer qLT_numeroJogosVisitado = homeTR
							.getResultIntervalGames();
					Integer qLT_numeroJogosVisitante = awayTR
							.getResultIntervalGames();

					OurRow wohwr = new OurRow(jornada, idVisitado, idVisitante,
							f.getHomeTeamName(), f.getAwayTeamName(),
							qualidadeVisitado, qualidadeVisitante,
							fR_diasDescansoVisitado, fR_diasDescansoVisitante,
							fR_ratingVitoriasVisitado,
							fR_ratingDerrotasVisitante, fR_dificuldadeVisitado,
							fR_dificuldadeVisistante, fR_HistoricosVisitado,
							fR_HistoricosVisitante,
							homeWinCycle_numeroJogosVisitado,
							awayLoseCycle_numeroJogosVisitante,
							homeWinCycle_dificuldadeVisitado,
							awayLoseCycle_dificuldadeVisitante,
							homeWinCycle_HistoricosVisitado,
							awayLoseCycle_HistoricosVisitante,
							h2hWin_ratingVitorias, h2hWin_numeroJogos,
							qLT_percentagemVitoriasVisitado,
							qLT_percentagemDerrotasVisitante,
							qLT_dificuldadeVitoriasVisitado,
							qLT_dificuldadeDerrotasVisitante,
							qLT_percentagemVitoriasVisitadoNoIntervalo,
							qLT_percentagemDerrotasVisitanteNoIntervalo,
							qLT_numeroJogosVisitado, qLT_numeroJogosVisitante,
							result.equals(ResultType.WIN) ? 1 : 0);

					OurWinDataList.add(wohwr);

					homeTR = homeTeam.getResultPercentage(f, Venue.home,
							ResultType.DRAW, 0.15);
					awayTR = awayTeam.getResultPercentage(f, Venue.away,
							ResultType.DRAW, 0.15);
					Double qLT_percentagemEmpatesVisitado = homeTR
							.getResultPercentage();
					Double qLT_percentagemEmpatesVisitante = awayTR
							.getResultPercentage();
					Double qLT_dificuldadeEmpatesVisitado = homeTR
							.getQualityAverage();
					Double qLT_dificuldadeEmpatesVisitante = awayTR
							.getQualityAverage();
					Double qLT_percentagemEmpatesVisitadoNoIntervalo = homeTR
							.getResultIntervalPercentage();
					Double qLT_percentagemEmpatesVisitanteNoIntervalo = awayTR
							.getResultIntervalPercentage();
					qLT_numeroJogosVisitado = homeTR.getResultIntervalGames();
					qLT_numeroJogosVisitante = awayTR.getResultIntervalGames();

					OurRow dohwr = new OurRow(jornada, idVisitado, idVisitante,
							f.getHomeTeamName(), f.getAwayTeamName(),
							qualidadeVisitado, qualidadeVisitante,
							fR_diasDescansoVisitado, fR_diasDescansoVisitante,
							fR_ratingEmpatesVisitado,
							fR_ratingEmpatesVisitante, fR_dificuldadeVisitado,
							fR_dificuldadeVisistante, fR_HistoricosVisitado,
							fR_HistoricosVisitante,
							homeDrawCycle_numeroJogosVisitado,
							awayDrawCycle_numeroJogosVisitante,
							homeDrawCycle_dificuldadeVisitado,
							awayDrawCycle_dificuldadeVisitante,
							homeDrawCycle_HistoricosVisitado,
							awayDrawCycle_HistoricosVisitante, h2hDraw_rating,
							h2hDraw_numeroJogos,
							qLT_percentagemEmpatesVisitado,
							qLT_percentagemEmpatesVisitante,
							qLT_dificuldadeEmpatesVisitado,
							qLT_dificuldadeEmpatesVisitante,
							qLT_percentagemEmpatesVisitadoNoIntervalo,
							qLT_percentagemEmpatesVisitanteNoIntervalo,
							qLT_numeroJogosVisitado, qLT_numeroJogosVisitante,
							result.equals(ResultType.DRAW) ? 1 : 0);

					OurDrawDataList.add(dohwr);

					homeTR = homeTeam.getResultPercentage(f, Venue.home,
							ResultType.LOSE, 0.15);
					awayTR = awayTeam.getResultPercentage(f, Venue.away,
							ResultType.WIN, 0.15);
					Double qLT_percentagemDerrotasVisitado = homeTR
							.getResultPercentage();
					Double qLT_percentagemVitoriasVisitante = awayTR
							.getResultPercentage();
					Double qLT_dificuldadeDerrotasVisitado = homeTR
							.getQualityAverage();
					Double qLT_dificuldadeVitoriasVisitante = awayTR
							.getQualityAverage();
					Double qLT_percentagemDerrotasVisitadoNoIntervalo = homeTR
							.getResultIntervalPercentage();
					Double qLT_percentagemVitoriasVisitanteNoIntervalo = awayTR
							.getResultIntervalPercentage();
					qLT_numeroJogosVisitado = homeTR.getResultIntervalGames();
					qLT_numeroJogosVisitante = awayTR.getResultIntervalGames();

					OurRow lohwr = new OurRow(jornada, idVisitado, idVisitante,
							f.getHomeTeamName(), f.getAwayTeamName(),
							qualidadeVisitado, qualidadeVisitante,
							fR_diasDescansoVisitado, fR_diasDescansoVisitante,
							fR_ratingDerrotasVisitado,
							fR_ratingVitoriasVisitante, fR_dificuldadeVisitado,
							fR_dificuldadeVisistante, fR_HistoricosVisitado,
							fR_HistoricosVisitante,
							homeLoseCycle_numeroJogosVisitado,
							awayWinCycle_numeroJogosVisitante,
							homeLoseCycle_dificuldadeVisitado,
							awayWinCycle_dificuldadeVisitante,
							homeLoseCycle_HistoricosVisitado,
							awayWinCycle_HistoricosVisitante, h2hLose_rating,
							h2hLose_numeroJogos,
							qLT_percentagemDerrotasVisitado,
							qLT_percentagemVitoriasVisitante,
							qLT_dificuldadeDerrotasVisitado,
							qLT_dificuldadeVitoriasVisitante,
							qLT_percentagemDerrotasVisitadoNoIntervalo,
							qLT_percentagemVitoriasVisitanteNoIntervalo,
							qLT_numeroJogosVisitado, qLT_numeroJogosVisitante,
							result.equals(ResultType.LOSE) ? 1 : 0);

					OurLoseDataList.add(lohwr);
				}

				if (generateProf) {
					ProfRow wphwr = new ProfRow(jornada, idVisitado,
							idVisitante, f.getHomeTeamName(),
							f.getAwayTeamName(), qualidadeVisitado,
							qualidadeVisitante, fR_diasDescansoVisitado,
							fR_diasDescansoVisitante,
							fR_ratingVitoriasVisitado,
							fR_ratingDerrotasVisitante, fR_dificuldadeVisitado,
							fR_dificuldadeVisistante, fR_HistoricosVisitado,
							fR_HistoricosVisitante,
							homeWinCycle_numeroJogosVisitado,
							awayLoseCycle_numeroJogosVisitante,
							homeWinCycle_dificuldadeVisitado,
							awayLoseCycle_dificuldadeVisitante,
							homeWinCycle_HistoricosVisitado,
							awayLoseCycle_HistoricosVisitante,
							h2hWin_ratingVitorias, h2hWin_numeroJogos,
							result.equals(ResultType.WIN) ? 1 : 0);

					ProfWinDataList.add(wphwr);

					ProfRow dphwr = new ProfRow(jornada, idVisitado,
							idVisitante, f.getHomeTeamName(),
							f.getAwayTeamName(), qualidadeVisitado,
							qualidadeVisitante, fR_diasDescansoVisitado,
							fR_diasDescansoVisitante, fR_ratingEmpatesVisitado,
							fR_ratingEmpatesVisitante, fR_dificuldadeVisitado,
							fR_dificuldadeVisistante, fR_HistoricosVisitado,
							fR_HistoricosVisitante,
							homeDrawCycle_numeroJogosVisitado,
							awayDrawCycle_numeroJogosVisitante,
							homeDrawCycle_dificuldadeVisitado,
							awayDrawCycle_dificuldadeVisitante,
							homeDrawCycle_HistoricosVisitado,
							awayDrawCycle_HistoricosVisitante, h2hDraw_rating,
							h2hDraw_numeroJogos,
							result.equals(ResultType.DRAW) ? 1 : 0);

					ProfDrawDataList.add(dphwr);

					ProfRow lphwr = new ProfRow(jornada, idVisitado,
							idVisitante, f.getHomeTeamName(),
							f.getAwayTeamName(), qualidadeVisitado,
							qualidadeVisitante, fR_diasDescansoVisitado,
							fR_diasDescansoVisitante,
							fR_ratingDerrotasVisitado,
							fR_ratingVitoriasVisitante, fR_dificuldadeVisitado,
							fR_dificuldadeVisistante, fR_HistoricosVisitado,
							fR_HistoricosVisitante,
							homeLoseCycle_numeroJogosVisitado,
							awayWinCycle_numeroJogosVisitante,
							homeLoseCycle_dificuldadeVisitado,
							awayWinCycle_dificuldadeVisitante,
							homeLoseCycle_HistoricosVisitado,
							awayWinCycle_HistoricosVisitante, h2hLose_rating,
							h2hLose_numeroJogos,
							result.equals(ResultType.LOSE) ? 1 : 0);

					ProfLoseDataList.add(lphwr);

				}
			}
			System.out.println("FINISHED PROCESSING ROUND " + round);
		}

		Workbook NossoWorkbook = writeToExcelObj.newWorkbook();

		writeToExcelObj.writeOurDataExcelTable(OurWinDataList, NossoWorkbook,
				"Vitoria");
		writeToExcelObj.writeOurDataExcelTable(OurDrawDataList, NossoWorkbook,
				"Empate");
		writeToExcelObj.writeOurDataExcelTable(OurLoseDataList, NossoWorkbook,
				"Derrota");
		writeToExcelObj.writeWorkbookToExcelFile("NossoItalia", NossoWorkbook);

		Workbook ProfWorkbook = writeToExcelObj.newWorkbook();

		writeToExcelObj.writeProfDataExcelTable(ProfWinDataList, ProfWorkbook,
				"Vitoria");
		writeToExcelObj.writeProfDataExcelTable(ProfDrawDataList, ProfWorkbook,
				"Empate");
		writeToExcelObj.writeProfDataExcelTable(ProfLoseDataList, ProfWorkbook,
				"Derrota");
		writeToExcelObj.writeWorkbookToExcelFile("ProfItalia", ProfWorkbook);
	}
}
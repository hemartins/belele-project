package pt.belele.project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import pt.belele.project.alg.Algorithm;
import pt.belele.project.alg.OurRow;
import pt.belele.project.alg.ProfRow;
import pt.belele.project.controllers.FixtureController;
import pt.belele.project.controllers.SeasonController;
import pt.belele.project.controllers.StandingController;
import pt.belele.project.controllers.TeamController;
import pt.belele.project.controllers.util.H2H;
import pt.belele.project.controllers.util.ResultCycle;
import pt.belele.project.controllers.util.TeamRating;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.FixtureStatus;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Result.ResultType;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;
import pt.belele.project.util.CSVReader;
import pt.belele.project.util.WriteToExcel;

public class Main {

	private static DateTimeFormatter formatter = DateTimeFormat
			.forPattern("dd/MM/yy");

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("database.odb");
		EntityManager em = emf.createEntityManager();

//		populateDatabase(em, "I2.csv", "0203", 2);
//		populateDatabase(em, "I2.csv", "0304", 3);
//		populateDatabase(em, "I2.csv", "0405", 4);
//		populateDatabase(em, "I2.csv", "0506", 5);
//		populateDatabase(em, "I2.csv", "0607", 6);
//		populateDatabase(em, "I2.csv", "0708", 7);
//		populateDatabase(em, "I2.csv", "0809", 8);
//		populateDatabase(em, "I2.csv", "0910", 9);
//		populateDatabase(em, "I2.csv", "1011", 10);
//		populateDatabase(em, "I2.csv", "1112", 11);
//		populateDatabase(em, "I2.csv", "1213", 12);
//		populateDatabase(em, "I2.csv", "1314", 13);
//		populateDatabase(em, "I2.csv", "1415", 14);
//		
//		populateDatabase(em, "I1.csv", "0203", 2);
//		populateDatabase(em, "I1.csv", "0304", 3);
//		populateDatabase(em, "I1.csv", "0405", 4);
//		populateDatabase(em, "I1.csv", "0506", 5);
//		populateDatabase(em, "I1.csv", "0607", 6);
//		populateDatabase(em, "I1.csv", "0708", 7);
//		populateDatabase(em, "I1.csv", "0809", 8);
//		populateDatabase(em, "I1.csv", "0910", 9);
//		populateDatabase(em, "I1.csv", "1011", 10);
//		populateDatabase(em, "I1.csv", "1112", 11);
//		populateDatabase(em, "I1.csv", "1213", 12);
//		populateDatabase(em, "I1.csv", "1314", 13);
//		populateDatabase(em, "I1.csv", "1415", 14);
		
		SeasonController sc = new SeasonController(em);
		Season s = sc.createSeason("I1", 14);
		runAlgorithm(s, em, "/Users/p056913/Desktop/", true, true);
		
		s = sc.createSeason("I1", 13);
		runAlgorithm(s, em, "/Users/p056913/Desktop/", true, true);
	}

	private static void runAlgorithm(Season s, EntityManager em,
			String filePath, boolean generateProf, boolean generateOurs) {
		WriteToExcel writeToExcelObj = new WriteToExcel(filePath);

		List<OurRow> OurWinDataList = new ArrayList<OurRow>();
		List<OurRow> OurDrawDataList = new ArrayList<OurRow>();
		List<OurRow> OurLoseDataList = new ArrayList<OurRow>();

		List<ProfRow> ProfWinDataList = new ArrayList<ProfRow>();
		List<ProfRow> ProfDrawDataList = new ArrayList<ProfRow>();
		List<ProfRow> ProfLoseDataList = new ArrayList<ProfRow>();

		List<String> historicos = new ArrayList<String>();
		historicos.add("Juventus");
		historicos.add("Roma");
		historicos.add("Milan");
		historicos.add("Napoli");
		historicos.add("Inter");

		for (Fixture f : s.getFixtures()) {

			System.out.println(f.toString());

			if (f.getDate()
					.before(formatter.parseDateTime("01/11/"+s.getYear()).toDate()))
				continue;

			Algorithm homeTeam = new Algorithm(f.getHomeTeam(), em);
			Algorithm awayTeam = new Algorithm(f.getAwayTeam(), em);
			List<Double> ratings = new ArrayList<Double>();
			ratings.add(0.3);
			ratings.add(0.25);
			ratings.add(0.2);
			ratings.add(0.15);
			ratings.add(0.1);
			
			List<Double> ratingsH2H = new ArrayList<Double>();
			ratingsH2H.add(0.3);
			ratingsH2H.add(0.25);
			ratingsH2H.add(0.2);
			ratingsH2H.add(0.15);
			ratingsH2H.add(0.1);

			Integer jornada = 0;
			Long idVisitado = f.getHomeTeam().getId();
			Long idVisitante = f.getAwayTeam().getId();
			Double qualidadeVisitado = homeTeam.getTeamQuality(s, f.getDate());
			Double qualidadeVisitante = awayTeam.getTeamQuality(s, f.getDate());
			Integer fR_diasDescansoVisitado = homeTeam.getRestingDays(f);
			Integer fR_diasDescansoVisitante = awayTeam.getRestingDays(f);
			Double fR_ratingVitoriasVisitado = homeTeam.getLastFixturesRating(
					f, null, 5, ratings, ResultType.WIN);
			Double fR_ratingDerrotasVisitante = awayTeam.getLastFixturesRating(
					f, null, 5, ratings, ResultType.LOSE);
			Double fR_dificuldadeVisitado = homeTeam
					.getLastFixturesOpponentAverageQuality(f, null, 5);
			Double fR_dificuldadeVisistante = awayTeam
					.getLastFixturesOpponentAverageQuality(f, null, 5);
			Integer fR_HistoricosVisitado = homeTeam
					.getLastHardGamesFixturesNumber(f, null, 5, historicos);
			Integer fR_HistoricosVisitante = awayTeam
					.getLastHardGamesFixturesNumber(f, null, 5, historicos);
			ResultCycle homeWinCycle = homeTeam.getTeamCycle(f, Venue.HOME,
					ResultType.WIN);
			ResultCycle awayLoseCycle = awayTeam.getTeamCycle(f, Venue.AWAY,
					ResultType.LOSE);
			Integer homeWinCycle_numeroJogosVisitado = homeWinCycle.getCycle();
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
			H2H h2hRatings = homeTeam.getH2HRating(f, ratingsH2H, Venue.HOME,
					ResultType.WIN);
			Double h2hWin_ratingVitorias = h2hRatings.getRating();
			Integer h2hWin_numeroJogos = h2hRatings.getSize();
			ResultType result = homeTeam.getResultType(f);

			Double fR_ratingEmpatesVisitado = homeTeam.getLastFixturesRating(f,
					null, 5, ratings, ResultType.DRAW);
			Double fR_ratingEmpatesVisitante = awayTeam.getLastFixturesRating(
					f, null, 5, ratings, ResultType.DRAW);
			ResultCycle homeDrawCycle = homeTeam.getTeamCycle(f, Venue.HOME,
					ResultType.DRAW);
			ResultCycle awayDrawCycle = awayTeam.getTeamCycle(f, Venue.AWAY,
					ResultType.DRAW);
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
			h2hRatings = homeTeam.getH2HRating(f, ratingsH2H, Venue.HOME,
					ResultType.DRAW);
			Double h2hDraw_rating = h2hRatings.getRating();
			Integer h2hDraw_numeroJogos = h2hRatings.getSize();

			Double fR_ratingDerrotasVisitado = homeTeam.getLastFixturesRating(
					f, null, 5, ratings, ResultType.LOSE);
			Double fR_ratingVitoriasVisitante = awayTeam.getLastFixturesRating(
					f, null, 5, ratings, ResultType.WIN);
			ResultCycle homeLoseCycle = homeTeam.getTeamCycle(f, Venue.HOME,
					ResultType.LOSE);
			ResultCycle awayWinCycle = awayTeam.getTeamCycle(f, Venue.AWAY,
					ResultType.WIN);
			Integer homeLoseCycle_numeroJogosVisitado = homeLoseCycle
					.getCycle();
			Integer awayWinCycle_numeroJogosVisitante = awayWinCycle.getCycle();
			Double homeLoseCycle_dificuldadeVisitado = homeTeam
					.getCycleOpponentAverageQuality(homeLoseCycle);
			Double awayWinCycle_dificuldadeVisitante = awayTeam
					.getCycleOpponentAverageQuality(awayWinCycle);
			Integer homeLoseCycle_HistoricosVisitado = homeTeam
					.getCycleHardGamesNumber(homeLoseCycle, historicos);
			Integer awayWinCycle_HistoricosVisitante = awayTeam
					.getCycleHardGamesNumber(awayWinCycle, historicos);
			h2hRatings = homeTeam.getH2HRating(f, ratingsH2H, Venue.HOME,
					ResultType.LOSE);
			Double h2hLose_rating = h2hRatings.getRating();
			Integer h2hLose_numeroJogos = h2hRatings.getSize();
			
			
			
			//CICLO PERNA
			
			
			ResultCycle homeWinCyclePerna = homeTeam.getTeamCyclePerna(f, Venue.HOME,
					ResultType.WIN);
			ResultCycle awayLoseCyclePerna = awayTeam.getTeamCyclePerna(f, Venue.AWAY,
					ResultType.LOSE);
			Integer homeWinCyclePerna_numeroJogosVisitado = homeWinCyclePerna.getCycle();
			Integer awayLoseCyclePerna_numeroJogosVisitante = awayLoseCyclePerna
					.getCycle();
			Double homeWinCyclePerna_dificuldadeVisitado = homeTeam
					.getCycleOpponentAverageQuality(homeWinCyclePerna);
			Double awayLoseCyclePerna_dificuldadeVisitante = awayTeam
					.getCycleOpponentAverageQuality(awayLoseCyclePerna);
			Integer homeWinCyclePerna_HistoricosVisitado = homeTeam
					.getCycleHardGamesNumber(homeWinCyclePerna, historicos);
			Integer awayLoseCyclePerna_HistoricosVisitante = awayTeam
					.getCycleHardGamesNumber(awayLoseCyclePerna, historicos);
			
			ResultCycle homeDrawCyclePerna = homeTeam.getTeamCyclePerna(f, Venue.HOME,
					ResultType.DRAW);
			ResultCycle awayDrawCyclePerna = awayTeam.getTeamCyclePerna(f, Venue.AWAY,
					ResultType.DRAW);
			Integer homeDrawCyclePerna_numeroJogosVisitado = homeDrawCyclePerna
					.getCycle();
			Integer awayDrawCyclePerna_numeroJogosVisitante = awayDrawCyclePerna
					.getCycle();
			Double homeDrawCyclePerna_dificuldadeVisitado = homeTeam
					.getCycleOpponentAverageQuality(homeDrawCyclePerna);
			Double awayDrawCyclePerna_dificuldadeVisitante = awayTeam
					.getCycleOpponentAverageQuality(awayDrawCyclePerna);
			Integer homeDrawCyclePerna_HistoricosVisitado = homeTeam
					.getCycleHardGamesNumber(homeDrawCyclePerna, historicos);
			Integer awayDrawCyclePerna_HistoricosVisitante = awayTeam
					.getCycleHardGamesNumber(awayDrawCyclePerna, historicos);
			
			ResultCycle homeLoseCyclePerna = homeTeam.getTeamCyclePerna(f, Venue.HOME,
					ResultType.LOSE);
			ResultCycle awayWinCyclePerna = awayTeam.getTeamCyclePerna(f, Venue.AWAY,
					ResultType.WIN);
			Integer homeLoseCyclePerna_numeroJogosVisitado = homeLoseCyclePerna
					.getCycle();
			Integer awayWinCyclePerna_numeroJogosVisitante = awayWinCyclePerna.getCycle();
			Double homeLoseCyclePerna_dificuldadeVisitado = homeTeam
					.getCycleOpponentAverageQuality(homeLoseCyclePerna);
			Double awayWinCyclePerna_dificuldadeVisitante = awayTeam
					.getCycleOpponentAverageQuality(awayWinCyclePerna);
			Integer homeLoseCyclePerna_HistoricosVisitado = homeTeam
					.getCycleHardGamesNumber(homeLoseCyclePerna, historicos);
			Integer awayWinCyclePerna_HistoricosVisitante = awayTeam
					.getCycleHardGamesNumber(awayWinCyclePerna, historicos);
			
			
			//FIM CICLO PERNA
			
			
			if (generateOurs) {
				TeamRating homeTR = homeTeam.getResultPercentage(f, Venue.HOME,
						ResultType.WIN, 0.15);
				TeamRating awayTR = awayTeam.getResultPercentage(f, Venue.AWAY,
						ResultType.LOSE, 0.15);
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

				OurRow wohwr = new OurRow(jornada, idVisitado, idVisitante, f
						.getHomeTeam().getName(), f.getAwayTeam().getName(),
						qualidadeVisitado, qualidadeVisitante,
						fR_diasDescansoVisitado, fR_diasDescansoVisitante,
						fR_ratingVitoriasVisitado, fR_ratingDerrotasVisitante,
						fR_dificuldadeVisitado, fR_dificuldadeVisistante,
						fR_HistoricosVisitado, fR_HistoricosVisitante,
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
						result.equals(ResultType.WIN) ? 1 : 0,
						homeWinCyclePerna_numeroJogosVisitado,
						awayLoseCyclePerna_numeroJogosVisitante,
						homeWinCyclePerna_dificuldadeVisitado,
						awayLoseCyclePerna_dificuldadeVisitante,
						homeWinCyclePerna_HistoricosVisitado,
						awayLoseCyclePerna_HistoricosVisitante);

				OurWinDataList.add(wohwr);

				homeTR = homeTeam.getResultPercentage(f, Venue.HOME,
						ResultType.DRAW, 0.15);
				awayTR = awayTeam.getResultPercentage(f, Venue.AWAY,
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

				OurRow dohwr = new OurRow(jornada, idVisitado, idVisitante, f
						.getHomeTeam().getName(), f.getAwayTeam().getName(),
						qualidadeVisitado, qualidadeVisitante,
						fR_diasDescansoVisitado, fR_diasDescansoVisitante,
						fR_ratingEmpatesVisitado, fR_ratingEmpatesVisitante,
						fR_dificuldadeVisitado, fR_dificuldadeVisistante,
						fR_HistoricosVisitado, fR_HistoricosVisitante,
						homeDrawCycle_numeroJogosVisitado,
						awayDrawCycle_numeroJogosVisitante,
						homeDrawCycle_dificuldadeVisitado,
						awayDrawCycle_dificuldadeVisitante,
						homeDrawCycle_HistoricosVisitado,
						awayDrawCycle_HistoricosVisitante, h2hDraw_rating,
						h2hDraw_numeroJogos, qLT_percentagemEmpatesVisitado,
						qLT_percentagemEmpatesVisitante,
						qLT_dificuldadeEmpatesVisitado,
						qLT_dificuldadeEmpatesVisitante,
						qLT_percentagemEmpatesVisitadoNoIntervalo,
						qLT_percentagemEmpatesVisitanteNoIntervalo,
						qLT_numeroJogosVisitado, qLT_numeroJogosVisitante,
						result.equals(ResultType.DRAW) ? 1 : 0,
						homeDrawCyclePerna_numeroJogosVisitado,
						awayDrawCyclePerna_numeroJogosVisitante,
						homeDrawCyclePerna_dificuldadeVisitado,
						awayDrawCyclePerna_dificuldadeVisitante,
						homeDrawCyclePerna_HistoricosVisitado,
						awayDrawCyclePerna_HistoricosVisitante);

				OurDrawDataList.add(dohwr);

				homeTR = homeTeam.getResultPercentage(f, Venue.HOME,
						ResultType.LOSE, 0.15);
				awayTR = awayTeam.getResultPercentage(f, Venue.AWAY,
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

				OurRow lohwr = new OurRow(jornada, idVisitado, idVisitante, f
						.getHomeTeam().getName(), f.getAwayTeam().getName(),
						qualidadeVisitado, qualidadeVisitante,
						fR_diasDescansoVisitado, fR_diasDescansoVisitante,
						fR_ratingDerrotasVisitado, fR_ratingVitoriasVisitante,
						fR_dificuldadeVisitado, fR_dificuldadeVisistante,
						fR_HistoricosVisitado, fR_HistoricosVisitante,
						homeLoseCycle_numeroJogosVisitado,
						awayWinCycle_numeroJogosVisitante,
						homeLoseCycle_dificuldadeVisitado,
						awayWinCycle_dificuldadeVisitante,
						homeLoseCycle_HistoricosVisitado,
						awayWinCycle_HistoricosVisitante, h2hLose_rating,
						h2hLose_numeroJogos, qLT_percentagemDerrotasVisitado,
						qLT_percentagemVitoriasVisitante,
						qLT_dificuldadeDerrotasVisitado,
						qLT_dificuldadeVitoriasVisitante,
						qLT_percentagemDerrotasVisitadoNoIntervalo,
						qLT_percentagemVitoriasVisitanteNoIntervalo,
						qLT_numeroJogosVisitado, qLT_numeroJogosVisitante,
						result.equals(ResultType.LOSE) ? 1 : 0,
						homeLoseCyclePerna_numeroJogosVisitado,
						awayWinCyclePerna_numeroJogosVisitante,
						homeLoseCyclePerna_dificuldadeVisitado,
						awayWinCyclePerna_dificuldadeVisitante,
						homeLoseCyclePerna_HistoricosVisitado,
						awayWinCyclePerna_HistoricosVisitante);

				OurLoseDataList.add(lohwr);
			}

			if (generateProf) {
				ProfRow wphwr = new ProfRow(jornada, idVisitado, idVisitante, f
						.getHomeTeam().getName(), f.getAwayTeam().getName(),
						qualidadeVisitado, qualidadeVisitante,
						fR_diasDescansoVisitado, fR_diasDescansoVisitante,
						fR_ratingVitoriasVisitado, fR_ratingDerrotasVisitante,
						fR_dificuldadeVisitado, fR_dificuldadeVisistante,
						fR_HistoricosVisitado, fR_HistoricosVisitante,
						homeWinCycle_numeroJogosVisitado,
						awayLoseCycle_numeroJogosVisitante,
						homeWinCycle_dificuldadeVisitado,
						awayLoseCycle_dificuldadeVisitante,
						homeWinCycle_HistoricosVisitado,
						awayLoseCycle_HistoricosVisitante,
						h2hWin_ratingVitorias, h2hWin_numeroJogos,
						result.equals(ResultType.WIN) ? 1 : 0);

				ProfWinDataList.add(wphwr);

				ProfRow dphwr = new ProfRow(jornada, idVisitado, idVisitante, f
						.getHomeTeam().getName(), f.getAwayTeam().getName(),
						qualidadeVisitado, qualidadeVisitante,
						fR_diasDescansoVisitado, fR_diasDescansoVisitante,
						fR_ratingEmpatesVisitado, fR_ratingEmpatesVisitante,
						fR_dificuldadeVisitado, fR_dificuldadeVisistante,
						fR_HistoricosVisitado, fR_HistoricosVisitante,
						homeDrawCycle_numeroJogosVisitado,
						awayDrawCycle_numeroJogosVisitante,
						homeDrawCycle_dificuldadeVisitado,
						awayDrawCycle_dificuldadeVisitante,
						homeDrawCycle_HistoricosVisitado,
						awayDrawCycle_HistoricosVisitante, h2hDraw_rating,
						h2hDraw_numeroJogos, result.equals(ResultType.DRAW) ? 1
								: 0);

				ProfDrawDataList.add(dphwr);

				ProfRow lphwr = new ProfRow(jornada, idVisitado, idVisitante, f
						.getHomeTeam().getName(), f.getAwayTeam().getName(),
						qualidadeVisitado, qualidadeVisitante,
						fR_diasDescansoVisitado, fR_diasDescansoVisitante,
						fR_ratingDerrotasVisitado, fR_ratingVitoriasVisitante,
						fR_dificuldadeVisitado, fR_dificuldadeVisistante,
						fR_HistoricosVisitado, fR_HistoricosVisitante,
						homeLoseCycle_numeroJogosVisitado,
						awayWinCycle_numeroJogosVisitante,
						homeLoseCycle_dificuldadeVisitado,
						awayWinCycle_dificuldadeVisitante,
						homeLoseCycle_HistoricosVisitado,
						awayWinCycle_HistoricosVisitante, h2hLose_rating,
						h2hLose_numeroJogos, result.equals(ResultType.LOSE) ? 1
								: 0);

				ProfLoseDataList.add(lphwr);

			}
		}

		Workbook NossoWorkbook = writeToExcelObj.newWorkbook();

		writeToExcelObj.writeOurDataExcelTable(OurWinDataList, NossoWorkbook,
				"Vitoria");
		writeToExcelObj.writeOurDataExcelTable(OurDrawDataList, NossoWorkbook,
				"Empate");
		writeToExcelObj.writeOurDataExcelTable(OurLoseDataList, NossoWorkbook,
				"Derrota");
		writeToExcelObj.writeWorkbookToExcelFile("Nosso"+s.getName()+s.getYear(), NossoWorkbook);

		Workbook ProfWorkbook = writeToExcelObj.newWorkbook();

		writeToExcelObj.writeProfDataExcelTable(ProfWinDataList, ProfWorkbook,
				"Vitoria");
		writeToExcelObj.writeProfDataExcelTable(ProfDrawDataList, ProfWorkbook,
				"Empate");
		writeToExcelObj.writeProfDataExcelTable(ProfLoseDataList, ProfWorkbook,
				"Derrota");
		writeToExcelObj.writeWorkbookToExcelFile("Prof"+s.getName()+s.getYear(), ProfWorkbook);
	}

	private static Season populateDatabase(EntityManager em,
			String competitionFile, String season, Integer year) {
		SeasonController seasonController = new SeasonController(em);
		TeamController teamController = new TeamController(em);
		FixtureController fixtureController = new FixtureController(em);
		StandingController standingController = new StandingController(em);

		List<String[]> list = CSVReader
				.readFromCSV("http://www.football-data.co.uk/mmz4281/" + season
						+ "/" + competitionFile);

		Season s = null;
		for (String[] arr : list) {
			s = seasonController.createSeason(arr[0], year);
			Team t1 = teamController.createTeam(arr[2]);
			Team t2 = teamController.createTeam(arr[3]);
			seasonController.addTeam(s, t1);
			seasonController.addTeam(s, t2);

			Result result = null;
			try {
//				result = new Result(Integer.valueOf(arr[4]),
//						Integer.valueOf(arr[5]), Integer.valueOf(arr[7]),
//						Integer.valueOf(arr[8]));
				
				result = new Result(Integer.valueOf(arr[4]),
						Integer.valueOf(arr[5]), null,
						null);
				
			} catch (NumberFormatException e) {
				e.printStackTrace(System.out);
				System.out.println(arr[0]);
				System.out.println(arr[1]);
				System.out.println(arr[2]);
				System.out.println(arr[3]);
				System.out.println(arr[4]);
				System.out.println(arr[5]);
//				System.out.println(arr[7]);
//				System.out.println(arr[8]);
				result = new Result(Integer.valueOf(arr[4]),
						Integer.valueOf(arr[5]), 0, 0);
			}

			Fixture fixture = fixtureController.createFixture(formatter
					.parseDateTime(arr[1]).toDate(), s, t1, t2, result);
			if (fixture.getStatus().equals(FixtureStatus.FINISHED)) {
				standingController.createStanding(t1, s, fixture);
				standingController.createStanding(t2, s, fixture);
			}
		}

		return s;
	}
}
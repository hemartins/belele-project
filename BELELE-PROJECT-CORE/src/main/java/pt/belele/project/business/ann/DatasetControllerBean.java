/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business.ann;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pt.belele.project.business.TeamController;
import pt.belele.project.business.ann.obj.Dataset;
import pt.belele.project.business.ann.obj.DatasetProperties;
import pt.belele.project.business.util.H2H;
import pt.belele.project.business.util.ResultCycle;
import pt.belele.project.business.util.TeamRating;
import pt.belele.project.business.util.Triplet;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Result.ResultType;
import pt.belele.project.entities.Team;

/**
 *
 * @author P056913
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class DatasetControllerBean implements DatasetController {

    private final Logger LOG = LogManager.getLogger(DatasetControllerBean.class);

    private final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy");

    @EJB
    private TeamController teamController;

    @Override
    public Triplet<List<Dataset>, List<Dataset>, List<Dataset>> generateDatasetForFixtures(List<Fixture> fixtures, DatasetProperties properties) {

	List<Dataset> winDataset = new ArrayList<>();
	List<Dataset> drawDataset = new ArrayList<>();
	List<Dataset> loseDataset = new ArrayList<>();

	List<Double> ratings = new ArrayList<>();
	ratings.add(0.3);
	ratings.add(0.25);
	ratings.add(0.2);
	ratings.add(0.15);
	ratings.add(0.1);

	List<Double> ratingsH2H = new ArrayList<>();
	ratingsH2H.add(0.2);
	ratingsH2H.add(0.19);
	ratingsH2H.add(0.17);
	ratingsH2H.add(0.14);
	ratingsH2H.add(0.1);
	ratingsH2H.add(0.06);
	ratingsH2H.add(0.05);
	ratingsH2H.add(0.04);
	ratingsH2H.add(0.03);
	ratingsH2H.add(0.02);
	ratingsH2H.add(0.01);

	double interval = 0.15;

	int numberOfFixtures = 5;

	for (Fixture f : fixtures) {

	    LOG.debug(f.toString());

	    if (f.getDate().isBefore(formatter.parseDateTime("23/11/" + (f.getSeason().getYear() + 2000)))) {
		continue;
	    }

	    Dataset winRow = new Dataset();
	    Dataset drawRow = new Dataset();
	    Dataset loseRow = new Dataset();

	    Team homeTeam = f.getHomeTeam();
	    Team awayTeam = f.getAwayTeam();

	    if (properties.isIncludeGeneralVariables()) {
		List<Dataset> rowList = calculateGeneralVariables(f, homeTeam, awayTeam, winRow, drawRow, loseRow);
		winRow = rowList.get(0);
		drawRow = rowList.get(1);
		loseRow = rowList.get(2);
	    }
	    if (properties.isIncludeCycleVariables()) {
		List<Dataset> rowList = calculateCycleVariables(f, homeTeam, awayTeam, winRow, drawRow, loseRow);
		winRow = rowList.get(0);
		drawRow = rowList.get(1);
		loseRow = rowList.get(2);
	    }
	    if (properties.isIncludeFRVariables()) {
		List<Dataset> rowList = calculateFRVariables(f, homeTeam, awayTeam, ratings, winRow, drawRow, loseRow, numberOfFixtures, interval);
		winRow = rowList.get(0);
		drawRow = rowList.get(1);
		loseRow = rowList.get(2);
	    }
	    if (properties.isIncludeQLTVariables()) {
		List<Dataset> rowList = calculateQLTVariables(f, homeTeam, awayTeam, interval, winRow, drawRow, loseRow);
		winRow = rowList.get(0);
		drawRow = rowList.get(1);
		loseRow = rowList.get(2);
	    }

	    if (properties.isIncludeH2HVariables()) {
		//TODO AWAY TEAM DESAPARECEU!!!
		List<Dataset> rowList = calculateH2HVariables(f, ratingsH2H, homeTeam, winRow, drawRow, loseRow);
		winRow = rowList.get(0);
		drawRow = rowList.get(1);
		loseRow = rowList.get(2);
	    }

	    winDataset.add(winRow);
	    drawDataset.add(drawRow);
	    loseDataset.add(loseRow);

	}

	return new Triplet<>(winDataset, drawDataset, loseDataset);
    }

    private List<Dataset> calculateGeneralVariables(Fixture f, Team homeTeam, Team awayTeam, Dataset winRow, Dataset drawRow, Dataset loseRow) {

	List<Dataset> excelRows = new ArrayList<>();

	winRow = generalOverall(f, homeTeam, awayTeam, winRow, "1");
	drawRow = generalOverall(f, homeTeam, awayTeam, drawRow, "X");
	loseRow = generalOverall(f, homeTeam, awayTeam, loseRow, "2");
	winRow = generalVenue(f, homeTeam, awayTeam, winRow);
	drawRow = generalVenue(f, homeTeam, awayTeam, drawRow);
	loseRow = generalVenue(f, homeTeam, awayTeam, loseRow);
	winRow = generalSwitchedVenue(f, homeTeam, awayTeam, winRow);
	drawRow = generalSwitchedVenue(f, homeTeam, awayTeam, drawRow);
	loseRow = generalSwitchedVenue(f, homeTeam, awayTeam, loseRow);

	excelRows.add(winRow);
	excelRows.add(drawRow);
	excelRows.add(loseRow);

	return excelRows;
    }

    private Dataset generalOverall(Fixture f, Team homeTeam, Team awayTeam, Dataset row, String resultado) {

	row.setData(f.getDate());
	row.setNomeVisitado(f.getHomeTeam().getName());
	row.setNomeVisitante(f.getAwayTeam().getName());
	row.setQualidadeVisitado(teamController.getTeamQuality(homeTeam, f.getSeason(), f.getDate()));
	row.setQualidadeVisitante(teamController.getTeamQuality(awayTeam, f.getSeason(), f.getDate()));
	row.setDiasDescansoVisitado(teamController.getRestingDays(homeTeam, f));
	row.setDiasDescansoVisitante(teamController.getRestingDays(awayTeam, f));

	ResultType result = teamController.getResultType(homeTeam, f);

	switch (resultado) {
	    case "1":
		row.setResultado(result.equals(ResultType.WIN) ? 1 : 0);
		break;
	    case "X":
		row.setResultado(result.equals(ResultType.DRAW) ? 1 : 0);
		break;
	    case "2":
		row.setResultado(result.equals(ResultType.LOSE) ? 1 : 0);
		break;
	    default:
		// INVALIDO
		return null;
	}

	row.setClassificacaoVisitado(teamController.getClassification(homeTeam, f.getSeason(), f.getDate()));
	row.setClassificacaoVisitante(teamController.getClassification(awayTeam, f.getSeason(), f.getDate()));

	return row;
    }

    private Dataset generalVenue(Fixture f, Team homeTeam, Team awayTeam, Dataset row) {

	row.setQualidadeVisitadoVenue(teamController.getHomeTeamQuality(homeTeam, f.getSeason(), f.getDate()));
	row.setQualidadeVisitanteVenue(teamController.getAwayTeamQuality(awayTeam, f.getSeason(), f.getDate()));

	return row;
    }

    private Dataset generalSwitchedVenue(Fixture f, Team homeTeam, Team awayTeam, Dataset row) {

	row.setQualidadeVisitadoSwitchedVenue(teamController.getHomeTeamQuality(awayTeam, f.getSeason(), f.getDate()));
	row.setQualidadeVisitanteSwitchedVenue(teamController.getAwayTeamQuality(homeTeam, f.getSeason(), f.getDate()));

	return row;
    }

    private List<Dataset> calculateCycleVariables(Fixture f, Team homeTeam, Team awayTeam, Dataset winRow, Dataset drawRow, Dataset loseRow) {

	List<Dataset> excelRows = new ArrayList<>();

	winRow = cycleOverall(f, homeTeam, awayTeam, "1", winRow);
	drawRow = cycleOverall(f, homeTeam, awayTeam, "X", drawRow);
	loseRow = cycleOverall(f, homeTeam, awayTeam, "2", loseRow);
	winRow = cycleVenue(f, homeTeam, awayTeam, "1", winRow);
	drawRow = cycleVenue(f, homeTeam, awayTeam, "X", drawRow);
	loseRow = cycleVenue(f, homeTeam, awayTeam, "2", loseRow);
	winRow = cycleSwitchedVenue(f, homeTeam, awayTeam, "1", winRow);
	drawRow = cycleSwitchedVenue(f, homeTeam, awayTeam, "X", drawRow);
	loseRow = cycleSwitchedVenue(f, homeTeam, awayTeam, "2", loseRow);

	excelRows.add(winRow);
	excelRows.add(drawRow);
	excelRows.add(loseRow);

	return excelRows;
    }

    private Dataset cycleOverall(Fixture f, Team homeTeam, Team awayTeam, String result, Dataset row) {

	ResultType homeResult;
	ResultType awayResult;

	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		awayResult = ResultType.LOSE;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		awayResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		awayResult = ResultType.WIN;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	ResultCycle homeTeamCycleNotResult = teamController.getTeamCycle(homeTeam, f, null, homeResult);
	ResultCycle awayTeamCycleNotResult = teamController.getTeamCycle(awayTeam, f, null, awayResult);
	ResultCycle homeTeamCycleResult = teamController.getTeamCyclePerna(homeTeam, f, null, homeResult);
	ResultCycle awayTeamCycleResult = teamController.getTeamCyclePerna(awayTeam, f, null, awayResult);

	row.setCicloNaoResultado_numeroJogosVisitado(homeTeamCycleNotResult.getCycle());
	row.setCicloNaoResultado_numeroJogosVisitante(awayTeamCycleNotResult.getCycle());
	row.setCicloNaoResultado_dificuldadeVisitado(teamController.getCycleOpponentAverageQuality(homeTeamCycleNotResult));
	row.setCicloNaoResultado_dificuldadeVisitante(teamController.getCycleOpponentAverageQuality(awayTeamCycleNotResult));
	row.setCicloNaoResultado_historicosVisitado(teamController.getCycleHardGamesNumber(homeTeamCycleNotResult));
	row.setCicloNaoResultado_historicosVisitante(teamController.getCycleHardGamesNumber(awayTeamCycleNotResult));
	row.setCicloResultado_numeroJogosVisitado(homeTeamCycleResult.getCycle());
	row.setCicloResultado_numeroJogosVisitante(awayTeamCycleResult.getCycle());
	row.setCicloResultado_dificuldadeVisitado(teamController.getCycleOpponentAverageQuality(homeTeamCycleResult));
	row.setCicloResultado_dificuldadeVisitante(teamController.getCycleOpponentAverageQuality(awayTeamCycleResult));
	row.setCicloResultado_historicosVisitado(teamController.getCycleHardGamesNumber(homeTeamCycleResult));
	row.setCicloResultado_historicosVisitante(teamController.getCycleHardGamesNumber(awayTeamCycleResult));

	return row;
    }

    private Dataset cycleVenue(Fixture f, Team homeTeam, Team awayTeam, String result, Dataset row) {

	ResultType homeResult;
	ResultType awayResult;

	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		awayResult = ResultType.LOSE;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		awayResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		awayResult = ResultType.WIN;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	ResultCycle homeTeamCycleNotResult = teamController.getTeamCycle(homeTeam, f, Venue.HOME, homeResult);
	ResultCycle awayTeamCycleNotResult = teamController.getTeamCycle(awayTeam, f, Venue.AWAY, awayResult);
	ResultCycle homeTeamCycleResult = teamController.getTeamCyclePerna(homeTeam, f, Venue.HOME, homeResult);
	ResultCycle awayTeamCycleResult = teamController.getTeamCyclePerna(awayTeam, f, Venue.AWAY, awayResult);

	row.setCicloNaoResultado_numeroJogosVisitadoVenue(homeTeamCycleNotResult.getCycle());
	row.setCicloNaoResultado_numeroJogosVisitanteVenue(awayTeamCycleNotResult.getCycle());
	row.setCicloNaoResultado_dificuldadeVisitadoVenue(teamController.getCycleOpponentAverageQuality(homeTeamCycleNotResult));
	row.setCicloNaoResultado_dificuldadeVisitanteVenue(teamController.getCycleOpponentAverageQuality(awayTeamCycleNotResult));
	row.setCicloNaoResultado_historicosVisitadoVenue(teamController.getCycleHardGamesNumber(homeTeamCycleNotResult));
	row.setCicloNaoResultado_historicosVisitanteVenue(teamController.getCycleHardGamesNumber(awayTeamCycleNotResult));
	row.setCicloResultado_numeroJogosVisitadoVenue(homeTeamCycleResult.getCycle());
	row.setCicloResultado_numeroJogosVisitanteVenue(awayTeamCycleResult.getCycle());
	row.setCicloResultado_dificuldadeVisitadoVenue(teamController.getCycleOpponentAverageQuality(homeTeamCycleResult));
	row.setCicloResultado_dificuldadeVisitanteVenue(teamController.getCycleOpponentAverageQuality(awayTeamCycleResult));
	row.setCicloResultado_historicosVisitadoVenue(teamController.getCycleHardGamesNumber(homeTeamCycleResult));
	row.setCicloResultado_historicosVisitanteVenue(teamController.getCycleHardGamesNumber(awayTeamCycleResult));
	return row;
    }

    private Dataset cycleSwitchedVenue(Fixture f, Team homeTeam, Team awayTeam, String result, Dataset row) {
	ResultType homeResult;
	ResultType awayResult;

	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		awayResult = ResultType.LOSE;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		awayResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		awayResult = ResultType.WIN;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	ResultCycle homeTeamCycleNotResult = teamController.getTeamCycle(homeTeam, f, Venue.AWAY, homeResult);
	ResultCycle awayTeamCycleNotResult = teamController.getTeamCycle(awayTeam, f, Venue.HOME, awayResult);
	ResultCycle homeTeamCycleResult = teamController.getTeamCyclePerna(homeTeam, f, Venue.AWAY, homeResult);
	ResultCycle awayTeamCycleResult = teamController.getTeamCyclePerna(awayTeam, f, Venue.HOME, awayResult);

	row.setCicloNaoResultado_numeroJogosVisitadoSwitchedVenue(homeTeamCycleNotResult.getCycle());
	row.setCicloNaoResultado_numeroJogosVisitanteSwitchedVenue(awayTeamCycleNotResult.getCycle());
	row.setCicloNaoResultado_dificuldadeVisitadoSwitchedVenue(teamController.getCycleOpponentAverageQuality(homeTeamCycleNotResult));
	row.setCicloNaoResultado_dificuldadeVisitanteSwitchedVenue(teamController.getCycleOpponentAverageQuality(awayTeamCycleNotResult));
	row.setCicloNaoResultado_historicosVisitadoSwitchedVenue(teamController.getCycleHardGamesNumber(homeTeamCycleNotResult));
	row.setCicloNaoResultado_historicosVisitanteSwitchedVenue(teamController.getCycleHardGamesNumber(awayTeamCycleNotResult));
	row.setCicloResultado_numeroJogosVisitadoSwitchedVenue(homeTeamCycleResult.getCycle());
	row.setCicloResultado_numeroJogosVisitanteSwitchedVenue(awayTeamCycleResult.getCycle());
	row.setCicloResultado_dificuldadeVisitadoSwitchedVenue(teamController.getCycleOpponentAverageQuality(homeTeamCycleResult));
	row.setCicloResultado_dificuldadeVisitanteSwitchedVenue(teamController.getCycleOpponentAverageQuality(awayTeamCycleResult));
	row.setCicloResultado_historicosVisitadoSwitchedVenue(teamController.getCycleHardGamesNumber(homeTeamCycleResult));
	row.setCicloResultado_historicosVisitanteSwitchedVenue(teamController.getCycleHardGamesNumber(awayTeamCycleResult));

	return row;
    }

    private List<Dataset> calculateFRVariables(Fixture f, Team homeTeam, Team awayTeam, List<Double> ratings, Dataset winRow, Dataset drawRow, Dataset loseRow, Integer numberOfFixtures, Double interval) {

	List<Dataset> excelRows = new ArrayList<>();

	winRow = FROverall(f, homeTeam, awayTeam, ratings, "1", winRow, numberOfFixtures, interval);
	drawRow = FROverall(f, homeTeam, awayTeam, ratings, "X", drawRow, numberOfFixtures, interval);
	loseRow = FROverall(f, homeTeam, awayTeam, ratings, "2", loseRow, numberOfFixtures, interval);
	winRow = FRVenue(f, homeTeam, awayTeam, ratings, "1", winRow, numberOfFixtures, interval);
	drawRow = FRVenue(f, homeTeam, awayTeam, ratings, "X", drawRow, numberOfFixtures, interval);
	loseRow = FRVenue(f, homeTeam, awayTeam, ratings, "2", loseRow, numberOfFixtures, interval);
	winRow = FRSwitchedVenue(f, homeTeam, awayTeam, ratings, "1", winRow, numberOfFixtures, interval);
	drawRow = FRSwitchedVenue(f, homeTeam, awayTeam, ratings, "X", drawRow, numberOfFixtures, interval);
	loseRow = FRSwitchedVenue(f, homeTeam, awayTeam, ratings, "2", loseRow, numberOfFixtures, interval);

	excelRows.add(winRow);
	excelRows.add(drawRow);
	excelRows.add(loseRow);

	return excelRows;
    }

    private Dataset FROverall(Fixture f, Team homeTeam, Team awayTeam, List<Double> ratings, String result, Dataset row, Integer numberOfFixtures, Double interval) {

	ResultType homeResult;
	ResultType awayResult;

	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		awayResult = ResultType.LOSE;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		awayResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		awayResult = ResultType.WIN;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	Double[] percentagemFRResultadoVisitado = teamController.getRecentFormResultPercentage(homeTeam, f, null, numberOfFixtures, interval, homeResult);
	Double[] percentagemFRResultadoVisitante = teamController.getRecentFormResultPercentage(awayTeam, f, null, numberOfFixtures, interval, awayResult);

	Double[] percentagensGolosFRVisitado = teamController.averageGoalsLastGames(homeTeam, f, null, numberOfFixtures);
	Double[] percentagensGolosFRVisitante = teamController.averageGoalsLastGames(awayTeam, f, null, numberOfFixtures);

	Integer[] numberOfGamesVisitado = teamController.getHomeAndAwayGames(homeTeam, f, numberOfFixtures, null);
	Integer[] numberOfGamesVisitante = teamController.getHomeAndAwayGames(awayTeam, f, numberOfFixtures, null);

	TeamRating homeTR = teamController.getResultPercentage(homeTeam, f, null, homeResult, interval, numberOfFixtures);
	TeamRating awayTR = teamController.getResultPercentage(awayTeam, f, null, awayResult, interval, numberOfFixtures);
	row.setFR_dificuldadeVisitado(teamController.getLastFixturesOpponentAverageQuality(homeTeam, f, null, numberOfFixtures));
	row.setFR_dificuldadeVisitante(teamController.getLastFixturesOpponentAverageQuality(awayTeam, f, null, numberOfFixtures));

	row.setFR_historicosVisitado(teamController.getLastHardGamesFixturesNumber(homeTeam, f, null, numberOfFixtures));
	row.setFR_historicosVisitante(teamController.getLastHardGamesFixturesNumber(awayTeam, f, null, numberOfFixtures));
	row.setFR_ratingTemporalResultadoVisitado(teamController.getLastFixturesRating(homeTeam, f, null, numberOfFixtures, ratings, homeResult));
	row.setFR_ratingTemporalResultadoVisitante(teamController.getLastFixturesRating(awayTeam, f, null, numberOfFixtures, ratings, awayResult));
	row.setFR_numeroResultadosVisitado(teamController.getLastFixturesResults(homeTeam, f, null, numberOfFixtures, ratings, homeResult));
	row.setFR_numeroResultadosVisitante(teamController.getLastFixturesResults(awayTeam, f, null, numberOfFixtures, ratings, awayResult));
	row.setFR_numeroResultadosNoIntervaloVisitado(homeTR.getResultIntervalGames());
	row.setFR_numeroResultadosNoIntervaloVisitante(awayTR.getResultIntervalGames());
	row.setFR_percentagemResultadoVisitadoCasa(percentagemFRResultadoVisitado[0]);
	row.setFR_percentagemResultadoVisitanteFora(percentagemFRResultadoVisitante[1]);
	row.setFR_percentagemResultadoVisitadoFora(percentagemFRResultadoVisitado[1]);
	row.setFR_percentagemResultadoVisitanteCasa(percentagemFRResultadoVisitante[0]);
	row.setFR_percentagemResultadoVisitado(homeTR.getResultPercentage());
	row.setFR_percentagemResultadoVisitante(awayTR.getResultPercentage());
	row.setFR_percentagemResultadoNoIntervaloVisitado(homeTR.getResultIntervalPercentage());
	row.setFR_percentagemResultadoNoIntervaloVisitante(awayTR.getResultIntervalPercentage());
	row.setFR_percentagemResultadoNoIntervaloVisitadoCasa(percentagemFRResultadoVisitado[2]);
	row.setFR_percentagemResultadoNoIntervaloVisitanteFora(percentagemFRResultadoVisitante[3]);
	row.setFR_percentagemResultadoNoIntervaloVisitadoFora(percentagemFRResultadoVisitado[3]);
	row.setFR_percentagemResultadoNoIntervaloVisitanteCasa(percentagemFRResultadoVisitante[2]);
	row.setFR_numeroJogosVisitadoCasa(numberOfGamesVisitado[0]);
	row.setFR_numeroJogosVisitanteFora(numberOfGamesVisitante[1]);
	Double FR_golosMarcadosVisitado = percentagensGolosFRVisitado[0] * numberOfFixtures;
	row.setFR_golosMarcadosVisitado(FR_golosMarcadosVisitado.intValue());
	Double FR_golosSofridosVisitado = percentagensGolosFRVisitado[1] * numberOfFixtures;
	row.setFR_golosSofridosVisitado(FR_golosSofridosVisitado.intValue());
	Double FR_diferencaGolosVisitado = FR_golosMarcadosVisitado - FR_golosSofridosVisitado;
	row.setFR_diferencaGolosVisitado(FR_diferencaGolosVisitado.intValue());
	Double FR_golosMarcadosVisitante = percentagensGolosFRVisitante[0] * numberOfFixtures;
	row.setFR_golosMarcadosVisitante(FR_golosMarcadosVisitante.intValue());
	Double FR_golosSofridosVisitante = percentagensGolosFRVisitante[1] * numberOfFixtures;
	row.setFR_golosSofridosVisitante(FR_golosSofridosVisitante.intValue());
	Double FR_diferencaGolosVisitante = FR_golosMarcadosVisitante - FR_golosSofridosVisitante;
	row.setFR_diferencaGolosVisitante(FR_diferencaGolosVisitante.intValue());
	row.setFR_mediaGolosMarcadosVisitado(percentagensGolosFRVisitado[0]);
	row.setFR_mediaGolosSofridosVisitado(percentagensGolosFRVisitado[1]);
	row.setFR_mediaGolosMarcadosVisitante(percentagensGolosFRVisitante[0]);
	row.setFR_mediaGolosSofridosVisitante(percentagensGolosFRVisitante[1]);
	Double FR_golosMarcadosVisitadoCasa = percentagensGolosFRVisitado[2] * numberOfGamesVisitado[0];
	row.setFR_golosMarcadosVisitadoCasa(FR_golosMarcadosVisitadoCasa.intValue());
	Double FR_golosSofridosVisitadoCasa = percentagensGolosFRVisitado[3] * numberOfGamesVisitado[0];
	row.setFR_golosSofridosVisitadoCasa(FR_golosSofridosVisitadoCasa.intValue());
	Double FR_diferencaGolosVisitadoCasa = FR_golosMarcadosVisitadoCasa - FR_golosSofridosVisitadoCasa;
	row.setFR_diferencaGolosVisitadoCasa(FR_diferencaGolosVisitadoCasa.intValue());
	Double FR_golosMarcadosVisitanteFora = percentagensGolosFRVisitante[4] * numberOfGamesVisitante[1];
	row.setFR_golosMarcadosVisitanteFora(FR_golosMarcadosVisitanteFora.intValue());
	Double FR_golosSofridosVisitanteFora = percentagensGolosFRVisitante[5] * numberOfGamesVisitante[1];
	row.setFR_golosSofridosVisitanteFora(FR_golosSofridosVisitanteFora.intValue());
	Double FR_diferencaGolosVisitanteFora = FR_golosMarcadosVisitanteFora - FR_golosSofridosVisitanteFora;
	row.setFR_diferencaGolosVisitanteFora(FR_diferencaGolosVisitanteFora.intValue());
	row.setFR_mediaGolosMarcadosVisitadoCasa(percentagensGolosFRVisitado[2]);
	row.setFR_mediaGolosSofridosVisitadoCasa(percentagensGolosFRVisitado[3]);
	row.setFR_mediaGolosMarcadosVisitanteFora(percentagensGolosFRVisitante[4]);
	row.setFR_mediaGolosSofridosVisitanteFora(percentagensGolosFRVisitante[5]);
	Double FR_golosMarcadosVisitadoFora = percentagensGolosFRVisitado[4] * numberOfGamesVisitado[1];
	row.setFR_golosMarcadosVisitadoFora(FR_golosMarcadosVisitadoFora.intValue());
	Double FR_golosSofridosVisitadoFora = percentagensGolosFRVisitado[5] * numberOfGamesVisitado[1];
	row.setFR_golosSofridosVisitadoFora(FR_golosSofridosVisitadoFora.intValue());
	Double FR_diferencaGolosVisitadoFora = FR_golosMarcadosVisitadoFora - FR_golosSofridosVisitadoFora;
	row.setFR_diferencaGolosVisitadoFora(FR_diferencaGolosVisitadoFora.intValue());
	Double FR_golosMarcadosVisitanteCasa = percentagensGolosFRVisitante[2] * numberOfGamesVisitante[0];
	row.setFR_golosMarcadosVisitanteCasa(FR_golosMarcadosVisitanteCasa.intValue());
	Double FR_golosSofridosVisitanteCasa = percentagensGolosFRVisitante[3] * numberOfGamesVisitante[0];
	row.setFR_golosSofridosVisitanteCasa(FR_golosSofridosVisitanteCasa.intValue());
	Double FR_diferencaGolosVisitanteCasa = FR_golosMarcadosVisitanteCasa - FR_golosSofridosVisitanteCasa;
	row.setFR_diferencaGolosVisitanteCasa(FR_diferencaGolosVisitanteCasa.intValue());
	row.setFR_mediaGolosMarcadosVisitadoFora(percentagensGolosFRVisitado[4]);
	row.setFR_mediaGolosSofridosVisitadoFora(percentagensGolosFRVisitado[5]);
	row.setFR_mediaGolosMarcadosVisitanteCasa(percentagensGolosFRVisitante[2]);
	row.setFR_mediaGolosSofridosVisitanteCasa(percentagensGolosFRVisitante[3]);
	row.setFR_pontuacaoCasa(teamController.getFRPontuation(homeTeam, f, null, numberOfFixtures));
	row.setFR_pontuacaoCasaQualidade(teamController.getFRPontuationQuality(homeTeam, f, null, numberOfFixtures));
	row.setFR_pontuacaoCasaQualidadeTempo(teamController.getFRPontuationQualityAndTime(homeTeam, f, null, numberOfFixtures));
	row.setFR_pontuacaoFora(teamController.getFRPontuation(awayTeam, f, null, numberOfFixtures));
	row.setFR_pontuacaoForaQualidade(teamController.getFRPontuationQuality(awayTeam, f, null, numberOfFixtures));
	row.setFR_pontuacaoForaQualidadeTempo(teamController.getFRPontuationQualityAndTime(awayTeam, f, null, numberOfFixtures));

	return row;
    }

    private Dataset FRVenue(Fixture f, Team homeTeam, Team awayTeam, List<Double> ratings, String result, Dataset row, Integer numberOfFixtures,
	    Double interval) {

	ResultType homeResult;
	ResultType awayResult;

	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		awayResult = ResultType.LOSE;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		awayResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		awayResult = ResultType.WIN;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	TeamRating homeTR = teamController.getResultPercentage(homeTeam, f, Venue.HOME, homeResult, interval, numberOfFixtures);
	TeamRating awayTR = teamController.getResultPercentage(awayTeam, f, Venue.AWAY, awayResult, interval, numberOfFixtures);

	Double[] percentagensGolosFRVisitado = teamController.averageGoalsLastGames(homeTeam, f, Venue.HOME, numberOfFixtures);
	Double[] percentagensGolosFRVisitante = teamController.averageGoalsLastGames(awayTeam, f, Venue.AWAY, numberOfFixtures);

	row.setFR_dificuldadeVisitadoVenue(teamController.getLastFixturesOpponentAverageQuality(homeTeam, f, Venue.HOME, numberOfFixtures));
	row.setFR_dificuldadeVisitanteVenue(teamController.getLastFixturesOpponentAverageQuality(awayTeam, f, Venue.AWAY, numberOfFixtures));

	row.setFR_historicosVisitadoVenue(teamController.getLastHardGamesFixturesNumber(homeTeam, f, Venue.HOME, numberOfFixtures));
	row.setFR_historicosVisitanteVenue(teamController.getLastHardGamesFixturesNumber(awayTeam, f, Venue.AWAY, numberOfFixtures));
	row.setFR_ratingTemporalResultadoVisitadoVenue(teamController.getLastFixturesRating(homeTeam, f, Venue.HOME, numberOfFixtures, ratings, homeResult));
	row.setFR_ratingTemporalResultadoVisitanteVenue(teamController.getLastFixturesRating(awayTeam, f, Venue.AWAY, numberOfFixtures, ratings, awayResult));
	row.setFR_numeroResultadosVisitadoVenue(teamController.getLastFixturesResults(homeTeam, f, Venue.HOME, numberOfFixtures, ratings, homeResult));
	row.setFR_numeroResultadosVisitanteVenue(teamController.getLastFixturesResults(awayTeam, f, Venue.AWAY, numberOfFixtures, ratings, awayResult));
	row.setFR_numeroResultadosNoIntervaloVisitadoVenue(homeTR.getResultIntervalGames());
	row.setFR_numeroResultadosNoIntervaloVisitanteVenue(awayTR.getResultIntervalGames());
	row.setFR_percentagemResultadoVisitadoVenue(homeTR.getResultPercentage());
	row.setFR_percentagemResultadoVisitanteVenue(awayTR.getResultPercentage());
	row.setFR_percentagemResultadoNoIntervaloVisitadoVenue(homeTR.getResultIntervalPercentage());
	row.setFR_percentagemResultadoNoIntervaloVisitanteVenue(awayTR.getResultIntervalPercentage());
	Double FR_golosMarcadosVisitadoVenue = percentagensGolosFRVisitado[2] * numberOfFixtures;
	row.setFR_golosMarcadosVisitadoVenue(FR_golosMarcadosVisitadoVenue.intValue());
	Double FR_golosSofridosVisitadoVenue = percentagensGolosFRVisitado[3] * numberOfFixtures;
	row.setFR_golosSofridosVisitadoVenue(FR_golosSofridosVisitadoVenue.intValue());
	Double FR_diferencaGolosVisitadoVenue = FR_golosMarcadosVisitadoVenue - FR_golosSofridosVisitadoVenue;
	row.setFR_diferencaGolosVisitadoVenue(FR_diferencaGolosVisitadoVenue.intValue());
	Double FR_golosMarcadosVisitanteVenue = percentagensGolosFRVisitante[4] * numberOfFixtures;
	row.setFR_golosMarcadosVisitanteVenue(FR_golosMarcadosVisitanteVenue.intValue());
	Double FR_golosSofridosVisitanteVenue = percentagensGolosFRVisitante[5] * numberOfFixtures;
	row.setFR_golosSofridosVisitanteVenue(FR_golosSofridosVisitanteVenue.intValue());
	Double FR_diferencaGolosVisitanteVenue = FR_golosMarcadosVisitanteVenue - FR_golosSofridosVisitanteVenue;
	row.setFR_diferencaGolosVisitanteVenue(FR_diferencaGolosVisitanteVenue.intValue());
	row.setFR_mediaGolosMarcadosVisitadoVenue(percentagensGolosFRVisitado[2]);
	row.setFR_mediaGolosSofridosVisitadoVenue(percentagensGolosFRVisitado[3]);
	row.setFR_mediaGolosMarcadosVisitanteVenue(percentagensGolosFRVisitante[5]);
	row.setFR_mediaGolosSofridosVisitanteVenue(percentagensGolosFRVisitante[4]);
	row.setFR_pontuacaoCasaVenue(teamController.getFRPontuation(homeTeam, f, Venue.HOME, numberOfFixtures));
	row.setFR_pontuacaoCasaQualidadeVenue(teamController.getFRPontuationQuality(homeTeam, f, Venue.HOME, numberOfFixtures));
	row.setFR_pontuacaoCasaQualidadeTempoVenue(teamController.getFRPontuationQualityAndTime(homeTeam, f, Venue.HOME, numberOfFixtures));
	row.setFR_pontuacaoForaVenue(teamController.getFRPontuation(awayTeam, f, Venue.AWAY, numberOfFixtures));
	row.setFR_pontuacaoForaQualidadeVenue(teamController.getFRPontuationQuality(awayTeam, f, Venue.AWAY, numberOfFixtures));
	row.setFR_pontuacaoForaQualidadeTempoVenue(teamController.getFRPontuationQualityAndTime(awayTeam, f, Venue.AWAY, numberOfFixtures));

	return row;
    }

    private Dataset FRSwitchedVenue(Fixture f, Team homeTeam, Team awayTeam, List<Double> ratings, String result, Dataset row, Integer numberOfFixtures, Double interval) {

	ResultType homeResult;
	ResultType awayResult;

	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		awayResult = ResultType.LOSE;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		awayResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		awayResult = ResultType.WIN;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

//		Double[] percentagemFRResultadoVisitado = teamController.getRecentFormResultPercentage(homeTeam, f, null, numberOfFixtures, interval,
//				homeResult);
//		Double[] percentagemFRResultadoVisitante = teamController.getRecentFormResultPercentage(awayTeam, f, null, numberOfFixtures, interval,
//				awayResult);
	Double[] percentagensGolosFRVisitado = teamController.averageGoalsLastGames(homeTeam, f, Venue.AWAY, numberOfFixtures);
	Double[] percentagensGolosFRVisitante = teamController.averageGoalsLastGames(awayTeam, f, Venue.HOME, numberOfFixtures);

	TeamRating homeTR = teamController.getResultPercentage(homeTeam, f, Venue.AWAY, homeResult, interval, numberOfFixtures);
	TeamRating awayTR = teamController.getResultPercentage(awayTeam, f, Venue.HOME, awayResult, interval, numberOfFixtures);

	row.setFR_dificuldadeVisitadoSwitchedVenue(teamController.getLastFixturesOpponentAverageQuality(homeTeam, f, Venue.AWAY, numberOfFixtures));
	row.setFR_dificuldadeVisitanteSwitchedVenue(teamController.getLastFixturesOpponentAverageQuality(awayTeam, f, Venue.HOME, numberOfFixtures));
	//row.setFR_dificuldadeVisitadoSwitchedVenue(homeTR.getQualityAverage());
	//row.setFR_dificuldadeVisitanteSwitchedVenue(awayTR.getQualityAverage());
	row.setFR_historicosVisitadoSwitchedVenue(teamController.getLastHardGamesFixturesNumber(homeTeam, f, Venue.AWAY, numberOfFixtures));
	row.setFR_historicosVisitanteSwitchedVenue(teamController.getLastHardGamesFixturesNumber(awayTeam, f, Venue.HOME, numberOfFixtures));
	row.setFR_ratingTemporalResultadoVisitadoSwitchedVenue(teamController.getLastFixturesRating(homeTeam, f, Venue.AWAY, numberOfFixtures, ratings, homeResult));
	row.setFR_ratingTemporalResultadoVisitanteSwitchedVenue(teamController.getLastFixturesRating(awayTeam, f, Venue.HOME, numberOfFixtures, ratings, awayResult));
	row.setFR_numeroResultadosVisitadoSwitchedVenue(teamController.getLastFixturesResults(homeTeam, f, Venue.AWAY, numberOfFixtures, ratings, homeResult));
	row.setFR_numeroResultadosVisitanteSwitchedVenue(teamController.getLastFixturesResults(awayTeam, f, Venue.HOME, numberOfFixtures, ratings, awayResult));
	row.setFR_numeroResultadosNoIntervaloVisitadoSwitchedVenue(homeTR.getResultIntervalGames());
	row.setFR_numeroResultadosNoIntervaloVisitanteSwitchedVenue(awayTR.getResultIntervalGames());
	row.setFR_percentagemResultadoVisitadoSwitchedVenue(homeTR.getResultPercentage());
	row.setFR_percentagemResultadoVisitanteSwitchedVenue(awayTR.getResultPercentage());
	row.setFR_percentagemResultadoNoIntervaloVisitadoSwitchedVenue(homeTR.getResultIntervalPercentage());
	row.setFR_percentagemResultadoNoIntervaloVisitanteSwitchedVenue(awayTR.getResultIntervalPercentage());
	Double FR_golosMarcadosVisitadoSwitchedVenue = percentagensGolosFRVisitado[4] * numberOfFixtures;
	row.setFR_golosMarcadosVisitadoSwitchedVenue(FR_golosMarcadosVisitadoSwitchedVenue.intValue());
	Double FR_golosSofridosVisitadoSwitchedVenue = percentagensGolosFRVisitado[5] * numberOfFixtures;
	row.setFR_golosSofridosVisitadoSwitchedVenue(FR_golosSofridosVisitadoSwitchedVenue.intValue());
	Double FR_diferencaGolosVisitadoSwitchedVenue = FR_golosMarcadosVisitadoSwitchedVenue - FR_golosSofridosVisitadoSwitchedVenue;
	row.setFR_diferencaGolosVisitadoSwitchedVenue(FR_diferencaGolosVisitadoSwitchedVenue.intValue());
	Double FR_golosMarcadosVisitanteSwitchedVenue = percentagensGolosFRVisitante[2] * numberOfFixtures;
	row.setFR_golosMarcadosVisitanteSwitchedVenue(FR_golosMarcadosVisitanteSwitchedVenue.intValue());
	Double FR_golosSofridosVisitanteSwitchedVenue = percentagensGolosFRVisitante[3] * numberOfFixtures;
	row.setFR_golosSofridosVisitanteSwitchedVenue(FR_golosSofridosVisitanteSwitchedVenue.intValue());
	Double FR_diferencaGolosVisitanteSwitchedVenue = FR_golosMarcadosVisitanteSwitchedVenue - FR_golosSofridosVisitanteSwitchedVenue;
	row.setFR_diferencaGolosVisitanteSwitchedVenue(FR_diferencaGolosVisitanteSwitchedVenue.intValue());
	row.setFR_mediaGolosMarcadosVisitadoSwitchedVenue(percentagensGolosFRVisitado[4]);
	row.setFR_mediaGolosSofridosVisitadoSwitchedVenue(percentagensGolosFRVisitado[5]);
	row.setFR_mediaGolosMarcadosVisitanteSwitchedVenue(percentagensGolosFRVisitante[2]);
	row.setFR_mediaGolosSofridosVisitanteSwitchedVenue(percentagensGolosFRVisitante[3]);
	row.setFR_pontuacaoCasaSwitchedVenue(teamController.getFRPontuation(homeTeam, f, Venue.AWAY, numberOfFixtures));
	row.setFR_pontuacaoCasaQualidadeSwitchedVenue(teamController.getFRPontuationQuality(homeTeam, f, Venue.AWAY, numberOfFixtures));
	row.setFR_pontuacaoCasaQualidadeTempoSwitchedVenue(teamController.getFRPontuationQualityAndTime(homeTeam, f, Venue.AWAY, numberOfFixtures));
	row.setFR_pontuacaoForaSwitchedVenue(teamController.getFRPontuation(awayTeam, f, Venue.HOME, numberOfFixtures));
	row.setFR_pontuacaoForaQualidadeSwitchedVenue(teamController.getFRPontuationQuality(awayTeam, f, Venue.HOME, numberOfFixtures));
	row.setFR_pontuacaoForaQualidadeTempoSwitchedVenue(teamController.getFRPontuationQualityAndTime(awayTeam, f, Venue.HOME, numberOfFixtures));

	return row;
    }

    private List<Dataset> calculateQLTVariables(Fixture f, Team homeTeam,
	    Team awayTeam, Double interval, Dataset winRow, Dataset drawRow, Dataset loseRow) {

	List<Dataset> excelRows = new ArrayList<>();

	winRow = QLTOverall(f, homeTeam, awayTeam, interval, "1", winRow);
	drawRow = QLTOverall(f, homeTeam, awayTeam, interval, "X", drawRow);
	loseRow = QLTOverall(f, homeTeam, awayTeam, interval, "2", loseRow);
	winRow = QLTVenue(f, homeTeam, awayTeam, interval, "1", winRow);
	drawRow = QLTVenue(f, homeTeam, awayTeam, interval, "X", drawRow);
	loseRow = QLTVenue(f, homeTeam, awayTeam, interval, "2", loseRow);
	winRow = QLTSwitchedVenue(f, homeTeam, awayTeam, interval, "1", winRow);
	drawRow = QLTSwitchedVenue(f, homeTeam, awayTeam, interval, "X", drawRow);
	loseRow = QLTSwitchedVenue(f, homeTeam, awayTeam, interval, "2", loseRow);

	excelRows.add(winRow);
	excelRows.add(drawRow);
	excelRows.add(loseRow);

	return excelRows;
    }

    private Dataset QLTOverall(Fixture f, Team homeTeam, Team awayTeam, Double interval, String result, Dataset row) {

	ResultType homeResult;
	ResultType awayResult;

	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		awayResult = ResultType.LOSE;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		awayResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		awayResult = ResultType.WIN;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	TeamRating homeTR = teamController.getResultPercentage(homeTeam, f, null, homeResult, interval, null);
	TeamRating awayTR = teamController.getResultPercentage(awayTeam, f, null, awayResult, interval, null);

	Double[] percentagensGolosQLTVisitado = teamController.averageGoalsLastGames(homeTeam, f, null, null);
	Double[] percentagensGolosQLTVisitante = teamController.averageGoalsLastGames(awayTeam, f, null, null);

	row.setQLT_numeroJogosVisitado(teamController.getNumberOfFixtures(homeTeam, f, null));
	row.setQLT_numeroJogosVisitante(teamController.getNumberOfFixtures(awayTeam, f, null));
	row.setQLT_percentagemResultadoVisitado(homeTR.getResultPercentage());
	row.setQLT_percentagemResultadoVisitante(awayTR.getResultPercentage());
	row.setQLT_dificuldadeJogosVisitado(homeTR.getQualityAverage());
	row.setQLT_dificuldadeJogosVisitante(awayTR.getQualityAverage());
	row.setQLT_dificuldadeResultadoVisitado(homeTR.getResultDificulty());
	row.setQLT_dificuldadeResultadoVisitante(awayTR.getResultDificulty());
	row.setQLT_percentagemResultadoNoIntervaloVisitado(homeTR.getResultIntervalPercentage());
	row.setQLT_percentagemResultadoNoIntervaloVisitante(awayTR.getResultIntervalPercentage());
	row.setQLT_numeroJogosNoIntervaloVisitado(homeTR.getResultIntervalGames());
	row.setQLT_numeroJogosNoIntervaloVisitante(awayTR.getResultIntervalGames());
	row.setQLT_golosMarcadosVisitado(teamController.getGoals(homeTeam, f.getSeason(), f.getDate()));
	row.setQLT_golosSofridosVisitado(teamController.getGoalsAgainst(homeTeam, f.getSeason(), f.getDate()));
	row.setQLT_diferencaGolosVisitado(teamController.getGoals(homeTeam, f.getSeason(), f.getDate()) - teamController.getGoalsAgainst(homeTeam, f.getSeason(), f.getDate()));
	row.setQLT_golosMarcadosVisitante(teamController.getGoals(awayTeam, f.getSeason(), f.getDate()));
	row.setQLT_golosSofridosVisitante(teamController.getGoalsAgainst(awayTeam, f.getSeason(), f.getDate()));
	row.setQLT_diferencaGolosVisitante(teamController.getGoals(awayTeam, f.getSeason(), f.getDate()) - teamController.getGoalsAgainst(awayTeam, f.getSeason(), f.getDate()));
	row.setQLT_mediaGolosMarcadosVisitado(percentagensGolosQLTVisitado[0]);
	row.setQLT_mediaGolosSofridosVisitado(percentagensGolosQLTVisitado[1]);
	row.setQLT_mediaGolosMarcadosVisitante(percentagensGolosQLTVisitante[0]);
	row.setQLT_mediaGolosSofridosVisitante(percentagensGolosQLTVisitante[1]);

	return row;

    }

    private Dataset QLTVenue(Fixture f, Team homeTeam, Team awayTeam, Double interval, String result, Dataset row) {

	ResultType homeResult;
	ResultType awayResult;

	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		awayResult = ResultType.LOSE;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		awayResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		awayResult = ResultType.WIN;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	TeamRating homeTR = teamController.getResultPercentage(homeTeam, f, Venue.HOME, homeResult, interval, null);
	TeamRating awayTR = teamController.getResultPercentage(awayTeam, f, Venue.AWAY, awayResult, interval, null);

	Double[] percentagensGolosQLTVisitado = teamController.averageGoalsLastGames(homeTeam, f, Venue.HOME, null);
	Double[] percentagensGolosQLTVisitante = teamController.averageGoalsLastGames(awayTeam, f, Venue.AWAY, null);

	row.setQLT_numeroJogosVisitadoVenue(teamController.getNumberOfFixtures(homeTeam, f, Venue.HOME));
	row.setQLT_numeroJogosVisitanteVenue(teamController.getNumberOfFixtures(awayTeam, f, Venue.AWAY)); // CORRIGIR
	row.setQLT_percentagemResultadoVisitadoVenue(homeTR.getResultPercentage());
	row.setQLT_percentagemResultadoVisitanteVenue(awayTR.getResultPercentage());
	row.setQLT_dificuldadeJogosVisitadoVenue(homeTR.getQualityAverage());
	row.setQLT_dificuldadeJogosVisitanteVenue(awayTR.getQualityAverage());
	row.setQLT_dificuldadeResultadoVisitadoVenue(homeTR.getResultDificulty());
	row.setQLT_dificuldadeResultadoVisitanteVenue(awayTR.getResultDificulty());
	row.setQLT_percentagemResultadoNoIntervaloVisitadoVenue(homeTR.getResultIntervalPercentage());
	row.setQLT_percentagemResultadoNoIntervaloVisitanteVenue(awayTR.getResultIntervalPercentage());
	row.setQLT_numeroJogosNoIntervaloVisitadoVenue(homeTR.getResultIntervalGames());
	row.setQLT_numeroJogosNoIntervaloVisitanteVenue(awayTR.getResultIntervalGames());
	row.setQLT_golosMarcadosVisitadoVenue(teamController.getHomeGoals(homeTeam, f.getSeason(), f.getDate()));
	row.setQLT_golosSofridosVisitadoVenue(teamController.getHomeGoalsAgainst(homeTeam, f.getSeason(), f.getDate()));
	row.setQLT_diferencaGolosVisitadoVenue(teamController.getHomeGoals(homeTeam, f.getSeason(), f.getDate()) - teamController.getHomeGoalsAgainst(homeTeam, f.getSeason(), f.getDate()));
	row.setQLT_golosMarcadosVisitanteVenue(teamController.getAwayGoals(awayTeam, f.getSeason(), f.getDate()));
	row.setQLT_golosSofridosVisitanteVenue(teamController.getAwayGoalsAgainst(awayTeam, f.getSeason(), f.getDate()));
	row.setQLT_diferencaGolosVisitanteVenue(teamController.getAwayGoals(awayTeam, f.getSeason(), f.getDate()) - teamController.getAwayGoalsAgainst(awayTeam, f.getSeason(), f.getDate()));
	row.setQLT_mediaGolosMarcadosVisitadoVenue(percentagensGolosQLTVisitado[2]);
	row.setQLT_mediaGolosSofridosVisitadoVenue(percentagensGolosQLTVisitado[3]);
	row.setQLT_mediaGolosMarcadosVisitanteVenue(percentagensGolosQLTVisitante[4]);
	row.setQLT_mediaGolosSofridosVisitanteVenue(percentagensGolosQLTVisitante[5]);

	return row;
    }

    private Dataset QLTSwitchedVenue(Fixture f, Team homeTeam,
	    Team awayTeam, Double interval, String result, Dataset row) {

	ResultType homeResult;
	ResultType awayResult;

	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		awayResult = ResultType.LOSE;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		awayResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		awayResult = ResultType.WIN;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	TeamRating homeTR = teamController.getResultPercentage(homeTeam, f, Venue.AWAY, homeResult, interval, null);
	TeamRating awayTR = teamController.getResultPercentage(awayTeam, f, Venue.HOME, awayResult, interval, null);

	Double[] percentagensGolosQLTVisitado = teamController.averageGoalsLastGames(homeTeam, f, Venue.AWAY, null);
	Double[] percentagensGolosQLTVisitante = teamController.averageGoalsLastGames(awayTeam, f, Venue.HOME, null);

	row.setQLT_numeroJogosVisitadoSwitchedVenue(teamController.getNumberOfFixtures(homeTeam, f, Venue.AWAY));
	row.setQLT_numeroJogosVisitanteSwitchedVenue(teamController.getNumberOfFixtures(awayTeam, f, Venue.HOME)); // CORRIGIR
	row.setQLT_percentagemResultadoVisitadoSwitchedVenue(homeTR.getResultPercentage());
	row.setQLT_percentagemResultadoVisitanteSwitchedVenue(awayTR.getResultPercentage());
	row.setQLT_dificuldadeJogosVisitadoSwitchedVenue(homeTR.getQualityAverage());
	row.setQLT_dificuldadeJogosVisitanteSwitchedVenue(awayTR.getQualityAverage());
	row.setQLT_dificuldadeResultadoVisitadoSwitchedVenue(homeTR.getResultDificulty());
	row.setQLT_dificuldadeResultadoVisitanteSwitchedVenue(awayTR.getResultDificulty());
	row.setQLT_percentagemResultadoNoIntervaloVisitadoSwitchedVenue(homeTR.getResultIntervalPercentage());
	row.setQLT_percentagemResultadoNoIntervaloVisitanteSwitchedVenue(awayTR.getResultIntervalPercentage());
	row.setQLT_numeroJogosNoIntervaloVisitadoSwitchedVenue(homeTR.getResultIntervalGames());
	row.setQLT_numeroJogosNoIntervaloVisitanteSwitchedVenue(awayTR.getResultIntervalGames());

	row.setQLT_golosMarcadosVisitadoSwitchedVenue(teamController.getAwayGoals(homeTeam, f.getSeason(), f.getDate()));
	row.setQLT_golosSofridosVisitadoSwitchedVenue(teamController.getAwayGoalsAgainst(homeTeam, f.getSeason(), f.getDate()));
	row.setQLT_diferencaGolosVisitadoSwitchedVenue(teamController.getAwayGoals(homeTeam, f.getSeason(), f.getDate()) - teamController.getAwayGoalsAgainst(homeTeam, f.getSeason(), f.getDate()));
	row.setQLT_golosMarcadosVisitanteSwitchedVenue(teamController.getHomeGoals(awayTeam, f.getSeason(), f.getDate()));
	row.setQLT_golosSofridosVisitanteSwitchedVenue(teamController.getHomeGoalsAgainst(awayTeam, f.getSeason(), f.getDate()));
	row.setQLT_diferencaGolosVisitanteSwitchedVenue(teamController.getHomeGoals(awayTeam, f.getSeason(), f.getDate()) - teamController.getHomeGoalsAgainst(awayTeam, f.getSeason(), f.getDate()));
	row.setQLT_mediaGolosMarcadosVisitadoSwitchedVenue(percentagensGolosQLTVisitado[4]);
	row.setQLT_mediaGolosSofridosVisitadoSwitchedVenue(percentagensGolosQLTVisitado[5]);
	row.setQLT_mediaGolosMarcadosVisitanteSwitchedVenue(percentagensGolosQLTVisitante[2]);
	row.setQLT_mediaGolosSofridosVisitanteSwitchedVenue(percentagensGolosQLTVisitante[3]);

	return row;
    }

    private List<Dataset> calculateH2HVariables(Fixture f, List<Double> ratingsH2H, Team homeTeam, Dataset winRow, Dataset drawRow, Dataset loseRow) {

	List<Dataset> excelRows = new ArrayList<>();

	winRow = H2HOverall(f, ratingsH2H, homeTeam, "1", winRow);
	drawRow = H2HOverall(f, ratingsH2H, homeTeam, "X", drawRow);
	loseRow = H2HOverall(f, ratingsH2H, homeTeam, "2", loseRow);
	winRow = H2HVenue(f, ratingsH2H, homeTeam, "1", winRow);
	drawRow = H2HVenue(f, ratingsH2H, homeTeam, "X", drawRow);
	loseRow = H2HVenue(f, ratingsH2H, homeTeam, "2", loseRow);
	winRow = H2HSwitchedVenue(f, ratingsH2H, homeTeam, "1", winRow);
	drawRow = H2HSwitchedVenue(f, ratingsH2H, homeTeam, "X", drawRow);
	loseRow = H2HSwitchedVenue(f, ratingsH2H, homeTeam, "2", loseRow);

	excelRows.add(winRow);
	excelRows.add(drawRow);
	excelRows.add(loseRow);

	return excelRows;
    }

    private Dataset H2HOverall(Fixture f, List<Double> ratingsH2H, Team homeTeam, String result, Dataset row) {

	ResultType homeResult;

	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	H2H h2hRatings = teamController.getH2HRating(homeTeam, f, ratingsH2H, null, homeResult);

	row.setH2H_ratingTemporalResultado(h2hRatings.getRating());
	row.setH2H_numeroJogos(h2hRatings.getSize());
	row.setH2H_numeroResultados(h2hRatings.getNumberResults());
	if (h2hRatings.getSize() == 0) {
	    row.setH2H_percentagemResultados(0.0);
	} else {
	    row.setH2H_percentagemResultados((double) h2hRatings.getNumberResults() / h2hRatings.getSize());
	}

	return row;
    }

    private Dataset H2HVenue(Fixture f, List<Double> ratingsH2H, Team homeTeam, String result, Dataset row) {

	ResultType homeResult;
	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	H2H h2hRatings = teamController.getH2HRatingVenue(homeTeam, f, ratingsH2H, Venue.HOME, homeResult);

	row.setH2H_ratingTemporalResultadoVenue(h2hRatings.getRating());
	row.setH2H_numeroJogosVenue(h2hRatings.getSize());
	row.setH2H_numeroResultadosVenue(h2hRatings.getNumberResults());
	if (h2hRatings.getSize() == 0) {
	    row.setH2H_percentagemResultadosVenue(0.0);
	} else {
	    row.setH2H_percentagemResultadosVenue((double) h2hRatings.getNumberResults() / h2hRatings.getSize());
	}

	return row;
    }

    private Dataset H2HSwitchedVenue(Fixture f, List<Double> ratingsH2H, Team homeTeam, String result, Dataset row) {

	ResultType homeResult;

	switch (result) {
	    case "1":
		homeResult = ResultType.WIN;
		break;
	    case "X":
		homeResult = ResultType.DRAW;
		break;
	    case "2":
		homeResult = ResultType.LOSE;
		break;
	    default:
		// INVALID RESULT
		return null;
	}

	H2H h2hRatings = teamController.getH2HRatingSwitchedVenue(homeTeam, f, ratingsH2H, Venue.AWAY, homeResult);

	row.setH2H_ratingTemporalResultadoSwitchedVenue(h2hRatings.getRating());
	row.setH2H_numeroJogosSwitchedVenue(h2hRatings.getSize());
	row.setH2H_numeroResultadosSwitchedVenue(h2hRatings.getNumberResults());
	if (h2hRatings.getSize() == 0) {
	    row.setH2H_percentagemResultadosSwitchedVenue(0.0);
	} else {
	    row.setH2H_percentagemResultadosSwitchedVenue((double) h2hRatings.getNumberResults() / h2hRatings.getSize());
	}

	return row;
    }
}

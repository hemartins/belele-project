package pt.belele.project.algorithm;

import java.util.Date;

public class ExcelRow {

	// Date data;
	// Long idVisitado;
	// Long idVisitante;
	// String homeTeamName;
	// String awayTeamName;
	//
	// Double qualidadeVisitado; // pontos por jogo da equipa
	// Double qualidadeVisitante;
	// Integer FR_diasDescansoVisitado; // diferença entra a data do jogo a
	// // calcular e do jogo anterior
	// Integer FR_diasDescansoVisitante;
	// Double FR_ratingResultadoVisitado; // pontuação por cada vitória obtida
	// nos
	// // últimos 5 jogos, consoante o quão
	// // recente o jogo é
	// Double FR_ratingResultadoVisitante;
	// // recente o jogo é [0.3, 0.25, 0.2, 0.15, 0.1]
	// Double FR_dificuldadeVisitado; // média das qualidades dos adversários
	// dos
	// // últimos 5 jogos
	// Double FR_dificuldadeVisitante;
	// Integer FR_HistoricosVisitado; // número de históricos que a equipa
	// // enfrentou nos últimos 5 jogos
	// Integer FR_HistoricosVisitante;
	// Integer Ciclo_numeroJogosVisitado; // número de jogos que a equipa venceu
	// // seguidos (ex: caso não tenha vencido
	// // nenhum dos últimos 3 jogos é =-3;
	// // caso tenha vencido os últimos 5 jogos
	// // =5;
	// Integer Ciclo_numeroJogosVisitante;
	// Double Ciclo_dificuldadeVisitado; // média das qualidades dos adversários
	// // desse que a equipa enfrentou nesse
	// // ciclo
	// Double Ciclo_dificuldadeVisitante;
	// Integer Ciclo_HistoricosVisitado; // número de históricos que a equipa
	// // enfrentou durante esse ciclo
	// Integer Ciclo_HistoricosVisitante;
	//
	// Double H2H_ratingResultado; // pontuação por cada vitória obtida nos
	// últimos
	// // jogos entre essas equipas
	// Integer H2H_numeroJogos;
	//
	// Double QLT_percentagemResultadoVisitado; // percentagem total de vitórias
	// da
	// // equipa em casa
	// Double QLT_percentagemResultadoVisitante;
	// Double QLT_dificuldadeResultadoVisitado; // média das qualidades dos
	// // adversários que enfrentou em
	// // casa
	// // até à data
	// Double QLT_dificuldadeResultadoVisitante;
	// Double QLT_percentagemResultadoVisitadoNoIntervalo; // percentagem de
	// // vitórias frente a
	// // equipas cuja
	// // qualidade se encontra
	// // entre
	// // [qualidade_do_adversário
	// // - x ,
	// // qualidade_do_adversário
	// // + x]
	// Double QLT_percentagemResultadoVisitanteNoIntervalo;
	//
	// Integer QLT_numeroJogosVisitadoNoIntervalo;
	// Integer QLT_numeroJogosVisitanteNoIntervalo;
	//
	// Integer QLT_numeroJogosVisitado; // quantas equipas enfrentou no
	// intervalo
	// // citado em cima
	// Integer QLT_numeroJogosVisitante;
	//
	// Integer result;
	//
	// Integer CicloPerna_numeroJogosVisitado; // número de jogos que a equipa
	// // venceu
	// // seguidos (ex: caso não tenha vencido
	// // nenhum dos últimos 3 jogos é =-3;
	// // caso tenha vencido os últimos 5 jogos
	// // =5;
	// Integer CicloPerna_numeroJogosVisitante;
	// Double CicloPerna_dificuldadeVisitado; // média das qualidades dos
	// // adversários
	// // desse que a equipa enfrentou nesse
	// // ciclo
	// Double CicloPerna_dificuldadeVisitante;
	// Integer CicloPerna_HistoricosVisitado; // número de históricos que a
	// equipa
	// // enfrentou durante esse ciclo
	// Integer CicloPerna_HistoricosVisitante;
	//
	// Double FR_ratingQualidadeResultadoVisitado;
	// Double FR_ratingQualidadeResultadoVisitante;
	//
	// Integer QLT_numeroJogosVisitadoDaPercentagem;
	// Integer QLT_numeroJogosVisitanteDaPercentagem;
	//
	// Integer QLT_numeroJogosVisitadoVenue;
	// Integer QLT_numeroJogosVisitanteVenue;
	// Double QLT_percentagemResultadoVisitadoVenue;
	// Double QLT_percentagemResultadoVisitanteVenue;
	// Double QLT_dificuldadeResultadoVisitadoVenue;
	// Double QLT_dificuldadeResultadoVisitanteVenue;
	// Double QLT_percentagemResultadoVisitadoNoIntervaloVenue;
	// Double QLT_percentagemResultadoVisitanteNoIntervaloVenue;
	// Integer QLT_numeroJogosVisitadoNoIntervaloVenue;
	// Integer QLT_numeroJogosVisitanteNoIntervaloVenue;
	//
	// Integer QLT_numeroJogosVisitadoTrocado;
	// Integer QLT_numeroJogosVisitanteTrocado;
	// Double QLT_percentagemResultadoVisitadoTrocado;
	// Double QLT_percentagemResultadoVisitanteTrocado;
	// Double QLT_dificuldadeResultadoVisitadoTrocado;
	// Double QLT_dificuldadeResultadoVisitanteTrocado;
	// Double QLT_percentagemResultadoVisitadoNoIntervaloTrocado;
	// Double QLT_percentagemResultadoVisitanteNoIntervaloTrocado;
	// Integer QLT_numeroJogosVisitadoNoIntervaloTrocado;
	// Integer QLT_numeroJogosVisitanteNoIntervaloTrocado;
	//
	// Integer H2h_Results;
	//
	// Integer FR_ResultadosVisitado;
	// Integer FR_ResultadosVisitante;
	//
	// Integer QLT_homeTeamNumeroJogosTrocado;
	// Integer QLT_awayTeamNumeroJogosTrocado;
	//
	// Integer golosVisitado;
	// Integer golosSofridosVisitado;
	// Integer diferencaGolosVisitado;
	// Integer golosVisitante;
	// Integer golosSofridosVisitante;
	// Integer diferencaGolosVisitante;
	// Integer golosVisitadoCasa;
	// Integer golosSofridosVisitadoCasa;
	// Integer diferencaGolosVisitadoCasa;
	// Integer golosVisitanteFora;
	// Integer golosSofridosVisitanteFora;
	// Integer diferencaGolosVisitanteFora;
	// Integer classificacaoVisitado;
	// Integer classificacaoVisitante;
	//
	// Double qualidadeVisitadoCasa;
	// Double qualidadeVisitanteFora;
	//
	// Double qualidadeVisitadoFora;
	// Double qualidadeVisitanteCasa;
	//
	// Integer Ciclo_numeroJogosVisitadoTotal; // número de jogos que a equipa
	// // venceu
	// // seguidos (ex: caso não tenha vencido
	// // nenhum dos últimos 3 jogos é =-3;
	// // caso tenha vencido os últimos 5 jogos
	// // =5;
	// Integer Ciclo_numeroJogosVisitanteTotal;
	// Double Ciclo_dificuldadeVisitadoTotal; // média das qualidades dos
	// // adversários
	// // desse que a equipa enfrentou nesse
	// // ciclo
	// Double Ciclo_dificuldadeVisitanteTotal;
	// Integer Ciclo_HistoricosVisitadoTotal; // número de históricos que a
	// equipa
	// // enfrentou durante esse ciclo
	// Integer Ciclo_HistoricosVisitanteTotal;
	//
	// Integer CicloPerna_numeroJogosVisitadoTotal; // número de jogos que a
	// equipa
	// // venceu
	// // seguidos (ex: caso não tenha vencido
	// // nenhum dos últimos 3 jogos é =-3;
	// // caso tenha vencido os últimos 5 jogos
	// // =5;
	// Integer CicloPerna_numeroJogosVisitanteTotal;
	// Double CicloPerna_dificuldadeVisitadoTotal; // média das qualidades dos
	// // adversários
	// // desse que a equipa enfrentou nesse
	// // ciclo
	// Double CicloPerna_dificuldadeVisitanteTotal;
	// Integer CicloPerna_HistoricosVisitadoTotal; // número de históricos que a
	// // equipa
	// // enfrentou durante esse ciclo
	// Integer CicloPerna_HistoricosVisitanteTotal;
	//
	// Double FR_dificuldadeVisitadoHome;
	// Double FR_dificuldadeVisitanteAway;
	// Integer FR_HistoricosVisitadoHome;
	// Integer FR_HistoricosVisitanteAway;
	// Double FR_ratingResultadoVisitadoHome;
	// Double FR_ratingResultadoVisitanteAway;
	// Integer FR_ResultadoVisitadoHome;
	// Integer FR_ResultadoVisitanteAway;
	//
	// // últimos 5 jogos
	// Double QLT_percentagemResultadoVisitado_5jogos;
	// Double QLT_percentagemResultadoVisitante_5jogos;
	// Double QLT_dificuldadeResultadoVisitado_5jogos;
	// Double QLT_dificuldadeResultadoVisitante_5jogos;
	// Double QLT_percentagemResultadoVisitadoNoIntervalo_5jogos;
	// Double QLT_percentagemResultadoVisitanteNoIntervalo_5jogos;
	// Integer QLT_numeroJogosVisitado_5jogos;
	// Integer QLT_numeroJogosVisitante_5jogos;
	//
	// //VENUE
	// Double QLT_percentagemResultadoVisitadoVenue_5jogos;
	// Double QLT_percentagemResultadoVisitanteVenue_5jogos;
	// Double QLT_dificuldadeResultadoVisitadoVenue_5jogos;
	// Double QLT_dificuldadeResultadoVisitanteVenue_5jogos;
	// Double QLT_percentagemResultadoVisitadoNoIntervaloVenue_5jogos;
	// Double QLT_percentagemResultadoVisitanteNoIntervaloVenue_5jogos;
	// Integer QLT_numeroJogosVisitadoVenue_5jogos;
	// Integer QLT_numeroJogosVisitanteVenue_5jogos;
	//
	// //SWITCHED VENUE últimos 5 jogos
	// Double QLT_percentagemResultadoVisitadoTrocado_5jogos;
	// Double QLT_percentagemResultadoVisitanteTrocado_5jogos;
	// Double QLT_dificuldadeResultadoVisitadoTrocado_5jogos;
	// Double QLT_dificuldadeResultadoVisitanteTrocado_5jogos;
	// Double QLT_percentagemResultadoVisitadoNoIntervaloTrocado_5jogos;
	// Double QLT_percentagemResultadoVisitanteNoIntervaloTrocado_5jogos;
	// Integer QLT_numeroJogosVisitadoTrocado_5jogos;
	// Integer QLT_numeroJogosVisitanteTrocado_5jogos;
	//
	// Double percFRResultadoVisitadoCasa;
	// Double percFRResultadoVisitadoFora;
	// Double percFRResultadoVisitanteCasa;
	// Double percFRResultadoVisitanteFora;
	//
	// Double mediaGolosMarcadosVisitadoTotal;
	// Double mediaGolosSofridosVisitadoTotal;
	// Double mediaGolosMarcadosVisitadoCasa;
	// Double mediaGolosSofridosVisitadoCasa;
	// Double mediaGolosMarcadosVisitadoFora;
	// Double mediaGolosSofridosVisitadoFora;
	// Double mediaGolosMarcadosVisitanteTotal;
	// Double mediaGolosSofridosVisitanteTotal;
	// Double mediaGolosMarcadosVisitanteCasa;
	// Double mediaGolosSofridosVisitanteCasa;
	// Double mediaGolosMarcadosVisitanteFora;
	// Double mediaGolosSofridosVisitanteFora;
	//
	// public ExcelRow() {
	//
	// }
	//
	// public ExcelRow(Date data, Long idVisitado, Long idVisitante, String
	// homeTeamName, String awayTeamName,
	// Double qualidadeVisitado, Double qualidadeVisitante, Integer
	// fR_diasDescansoVisitado,
	// Integer fR_diasDescansoVisitante, Double fR_ratingResultadoVisitado,
	// Double fR_ratingResultadoVisitante,
	// Double fR_dificuldadeVisitado, Double fR_dificuldadeVisitante, Integer
	// fR_HistoricosVisitado,
	// Integer fR_HistoricosVisitante, Integer ciclo_numeroJogosVisitado,
	// Integer ciclo_numeroJogosVisitante,
	// Double ciclo_dificuldadeVisitado, Double ciclo_dificuldadeVisitante,
	// Integer ciclo_HistoricosVisitado,
	// Integer ciclo_HistoricosVisitante, Double h2h_ratingResultado, Integer
	// h2h_numeroJogos,
	// Double qLT_percentagemResultadoVisitado, Double
	// qLT_percentagemResultadoVisitante,
	// Double qLT_dificuldadeResultadoVisitado, Double
	// qLT_dificuldadeResultadoVisitante,
	// Double qLT_percentagemResultadoVisitadoNoIntervalo, Double
	// qLT_percentagemResultadoVisitanteNoIntervalo,
	// Integer qLT_numeroJogosVisitado, Integer qLT_numeroJogosVisitante,
	// Integer result,
	// Integer cicloPerna_numeroJogosVisitado, Integer
	// cicloPerna_numeroJogosVisitante,
	// Double cicloPerna_dificuldadeVisitado, Double
	// cicloPerna_dificuldadeVisitante,
	// Integer cicloPerna_HistoricosVisitado, Integer
	// cicloPerna_HistoricosVisitante,
	// Double fR_ratingQualidadeResultadoVisitado, Double
	// fR_ratingQualidadeResultadoVisitante,
	// Integer qLT_numeroJogosVisitadoDaPercentagem, Integer
	// qLT_numeroJogosVisitanteDaPercentagem,
	// Integer qLT_homeTeamNumeroJogos2, Integer qLT_awayTeamNumeroJogos2,
	// Double qLT_percentagemResultadoVisitado2, Double
	// qLT_percentagemResultadoVisitante2,
	// Double qLT_dificuldadeResultadoVisitado2, Double
	// qLT_dificuldadeResultadoVisitante2,
	// Double qLT_percentagemResultadoVisitadoNoIntervalo2, Double
	// qLT_percentagemResultadoVisitanteNoIntervalo2,
	// Integer qLT_numeroJogosVisitado2, Integer qLT_numeroJogosVisitante2,
	// Integer h2h_Results,
	// Integer fR_ResultadosVisitado, Integer fR_ResultadosVisitante, Integer
	// golosVisitado,
	// Integer golosContraVisitado, Integer diferencaGolosVisitado, Integer
	// golosVisitante,
	// Integer golosContraVisitante, Integer diferencaGolosVisitante, Integer
	// golosVisitadoCasa,
	// Integer golosContraVisitadoCasa, Integer diferencaGolosVisitadoCasa,
	// Integer golosVisitanteFora,
	// Integer golosContraVisitanteFora, Integer diferencaGolosVisitanteFora,
	// Integer classificacaoVisitado,
	// Integer classificacaoVisitante, Double qualidadeVisitadoCasa, Double
	// qualidadeVisitanteFora,
	// Integer ciclo_numeroJogosVisitadoTotal, Integer
	// ciclo_numeroJogosVisitanteTotal,
	// Double ciclo_dificuldadeVisitadoTotal, Double
	// ciclo_dificuldadeVisitanteTotal,
	// Integer ciclo_HistoricosVisitadoTotal, Integer
	// ciclo_HistoricosVisitanteTotal,
	// Integer cicloPerna_numeroJogosVisitadoTotal, Integer
	// cicloPerna_numeroJogosVisitanteTotal,
	// Double cicloPerna_dificuldadeVisitadoTotal, Double
	// cicloPerna_dificuldadeVisitanteTotal,
	// Integer cicloPerna_HistoricosVisitadoTotal, Integer
	// cicloPerna_HistoricosVisitanteTotal,
	// Double fR_dificuldadeVisitadoHome, Double fR_dificuldadeVisitanteAway,
	// Integer fR_HistoricosVisitadoHome,
	// Integer fR_HistoricosVisitanteAway, Double
	// fR_ratingResultadoVisitadoHome,
	// Double fR_ratingResultadoVisitanteAway, Integer fR_ResultadoVisitadoHome,
	// Integer fR_ResultadoVisitanteAway,
	// Double qLT_percentagemResultadoVisitado_5jogos, Double
	// qLT_percentagemResultadoVisitante_5jogos,
	// Double qLT_dificuldadeResultadoVisitado_5jogos, Double
	// qLT_dificuldadeResultadoVisitante_5jogos,
	// Double qLT_percentagemResultadoVisitadoNoIntervalo_5jogos,
	// Double qLT_percentagemResultadoVisitanteNoIntervalo_5jogos, Integer
	// qLT_numeroJogosVisitado_5jogos,
	// Integer qLT_numeroJogosVisitante_5jogos, Double
	// qLT_percentagemResultadoVisitado2_5jogos,
	// Double qLT_percentagemResultadoVisitante2_5jogos, Double
	// qLT_dificuldadeResultadoVisitado2_5jogos,
	// Double qLT_dificuldadeResultadoVisitante2_5jogos,
	// Double qLT_percentagemResultadoVisitadoNoIntervalo2_5jogos,
	// Double qLT_percentagemResultadoVisitanteNoIntervalo2_5jogos, Integer
	// qLT_numeroJogosVisitado2_5jogos,
	// Integer qLT_numeroJogosVisitante2_5jogos, Double
	// percFRResultadoVisitadoCasa,
	// Double percFRResultadoVisitadoFora, Double percFRResultadoVisitanteCasa,
	// Double percFRResultadoVisitanteFora, Double
	// mediaGolosMarcadosVisitadoTotal,
	// Double mediaGolosSofridosVisitadoTotal, Double
	// mediaGolosMarcadosVisitadoCasa,
	// Double mediaGolosSofridosVisitadoCasa, Double
	// mediaGolosMarcadosVisitadoFora,
	// Double mediaGolosSofridosVisitadoFora, Double
	// mediaGolosMarcadosVisitanteTotal,
	// Double mediaGolosSofridosVisitanteTotal, Double
	// mediaGolosMarcadosVisitanteCasa,
	// Double mediaGolosSofridosVisitanteCasa, Double
	// mediaGolosMarcadosVisitanteFora,
	// Double mediaGolosSofridosVisitanteFora) {
	//
	// this.percFRResultadoVisitadoCasa = percFRResultadoVisitadoCasa;
	// this.percFRResultadoVisitadoFora = percFRResultadoVisitadoFora;
	// this.percFRResultadoVisitanteCasa = percFRResultadoVisitanteCasa;
	// this.percFRResultadoVisitanteFora = percFRResultadoVisitanteFora;
	//
	// this.mediaGolosMarcadosVisitadoTotal = mediaGolosMarcadosVisitadoTotal;
	// this.mediaGolosSofridosVisitadoTotal = mediaGolosSofridosVisitadoTotal;
	// this.mediaGolosMarcadosVisitadoCasa = mediaGolosMarcadosVisitadoCasa;
	// this.mediaGolosSofridosVisitadoCasa = mediaGolosSofridosVisitadoCasa;
	// this.mediaGolosMarcadosVisitadoFora = mediaGolosMarcadosVisitadoFora;
	// this.mediaGolosSofridosVisitadoFora = mediaGolosSofridosVisitadoFora;
	// this.mediaGolosMarcadosVisitanteTotal = mediaGolosMarcadosVisitanteTotal;
	// this.mediaGolosSofridosVisitanteTotal = mediaGolosSofridosVisitanteTotal;
	// this.mediaGolosMarcadosVisitanteCasa = mediaGolosMarcadosVisitanteCasa;
	// this.mediaGolosSofridosVisitanteCasa = mediaGolosSofridosVisitanteCasa;
	// this.mediaGolosMarcadosVisitanteFora = mediaGolosMarcadosVisitanteFora;
	// this.mediaGolosSofridosVisitanteFora = mediaGolosSofridosVisitanteFora;
	//
	// this.data = data;
	// this.idVisitado = idVisitado;
	// this.idVisitante = idVisitante;
	// this.homeTeamName = homeTeamName;
	// this.awayTeamName = awayTeamName;
	// this.qualidadeVisitado = qualidadeVisitado;
	// this.qualidadeVisitante = qualidadeVisitante;
	// FR_diasDescansoVisitado = fR_diasDescansoVisitado;
	// FR_diasDescansoVisitante = fR_diasDescansoVisitante;
	// FR_ratingResultadoVisitado = fR_ratingResultadoVisitado;
	// FR_ratingResultadoVisitante = fR_ratingResultadoVisitante;
	// FR_dificuldadeVisitado = fR_dificuldadeVisitado;
	// FR_dificuldadeVisitante = fR_dificuldadeVisitante;
	// FR_HistoricosVisitado = fR_HistoricosVisitado;
	// FR_HistoricosVisitante = fR_HistoricosVisitante;
	// Ciclo_numeroJogosVisitado = ciclo_numeroJogosVisitado;
	// Ciclo_numeroJogosVisitante = ciclo_numeroJogosVisitante;
	// Ciclo_dificuldadeVisitado = ciclo_dificuldadeVisitado;
	// Ciclo_dificuldadeVisitante = ciclo_dificuldadeVisitante;
	// Ciclo_HistoricosVisitado = ciclo_HistoricosVisitado;
	// Ciclo_HistoricosVisitante = ciclo_HistoricosVisitante;
	// H2H_ratingResultado = h2h_ratingResultado;
	// H2H_numeroJogos = h2h_numeroJogos;
	// QLT_percentagemResultadoVisitado = qLT_percentagemResultadoVisitado;
	// QLT_percentagemResultadoVisitante = qLT_percentagemResultadoVisitante;
	// QLT_dificuldadeResultadoVisitado = qLT_dificuldadeResultadoVisitado;
	// QLT_dificuldadeResultadoVisitante = qLT_dificuldadeResultadoVisitante;
	// QLT_percentagemResultadoVisitadoNoIntervalo =
	// qLT_percentagemResultadoVisitadoNoIntervalo;
	// QLT_percentagemResultadoVisitanteNoIntervalo =
	// qLT_percentagemResultadoVisitanteNoIntervalo;
	// QLT_numeroJogosVisitado = qLT_numeroJogosVisitado;
	// QLT_numeroJogosVisitante = qLT_numeroJogosVisitante;
	// this.result = result;
	//
	// CicloPerna_numeroJogosVisitado = cicloPerna_numeroJogosVisitado;
	// CicloPerna_numeroJogosVisitante = cicloPerna_numeroJogosVisitante;
	// CicloPerna_dificuldadeVisitado = cicloPerna_dificuldadeVisitado;
	// CicloPerna_dificuldadeVisitante = cicloPerna_dificuldadeVisitante;
	// CicloPerna_HistoricosVisitado = cicloPerna_HistoricosVisitado;
	// CicloPerna_HistoricosVisitante = cicloPerna_HistoricosVisitante;
	// FR_ratingQualidadeResultadoVisitado =
	// fR_ratingQualidadeResultadoVisitado;
	// FR_ratingQualidadeResultadoVisitante =
	// fR_ratingQualidadeResultadoVisitante;
	// QLT_numeroJogosVisitadoDaPercentagem =
	// qLT_numeroJogosVisitadoDaPercentagem;
	// QLT_numeroJogosVisitanteDaPercentagem =
	// qLT_numeroJogosVisitanteDaPercentagem;
	//
	// QLT_homeTeamNumeroJogosTrocado = qLT_homeTeamNumeroJogos2;
	// QLT_awayTeamNumeroJogosTrocado = qLT_awayTeamNumeroJogos2;
	// QLT_percentagemResultadoVisitadoTrocado =
	// qLT_percentagemResultadoVisitado2;
	// QLT_percentagemResultadoVisitanteTrocado =
	// qLT_percentagemResultadoVisitante2;
	// QLT_dificuldadeResultadoVisitadoTrocado =
	// qLT_dificuldadeResultadoVisitado2;
	// QLT_dificuldadeResultadoVisitanteTrocado =
	// qLT_dificuldadeResultadoVisitante2;
	// QLT_percentagemResultadoVisitadoNoIntervaloTrocado =
	// qLT_percentagemResultadoVisitadoNoIntervalo2;
	// QLT_percentagemResultadoVisitanteNoIntervaloTrocado =
	// qLT_percentagemResultadoVisitanteNoIntervalo2;
	// QLT_numeroJogosVisitadoNoIntervalo = qLT_numeroJogosVisitado2;
	// QLT_numeroJogosVisitanteNoIntervalo = qLT_numeroJogosVisitante2;
	//
	// H2h_Results = h2h_Results;
	//
	// FR_ResultadosVisitado = fR_ResultadosVisitado;
	// FR_ResultadosVisitante = fR_ResultadosVisitante;
	//
	// this.golosVisitado = golosVisitado;
	// this.golosSofridosVisitado = golosContraVisitado;
	// this.diferencaGolosVisitado = diferencaGolosVisitado;
	// this.golosVisitante = golosVisitante;
	// this.golosSofridosVisitante = golosContraVisitante;
	// this.diferencaGolosVisitante = diferencaGolosVisitante;
	// this.golosVisitadoCasa = golosVisitadoCasa;
	// this.golosSofridosVisitadoCasa = golosContraVisitadoCasa;
	// this.diferencaGolosVisitadoCasa = diferencaGolosVisitadoCasa;
	// this.golosVisitanteFora = golosVisitanteFora;
	// this.golosSofridosVisitanteFora = golosContraVisitanteFora;
	// this.diferencaGolosVisitanteFora = diferencaGolosVisitanteFora;
	// this.classificacaoVisitado = classificacaoVisitado;
	// this.classificacaoVisitante = classificacaoVisitante;
	// this.qualidadeVisitadoCasa = qualidadeVisitadoCasa;
	// this.qualidadeVisitanteFora = qualidadeVisitanteFora;
	//
	// Ciclo_numeroJogosVisitadoTotal = ciclo_numeroJogosVisitadoTotal;
	// Ciclo_numeroJogosVisitanteTotal = ciclo_numeroJogosVisitanteTotal;
	// Ciclo_dificuldadeVisitadoTotal = ciclo_dificuldadeVisitadoTotal;
	// Ciclo_dificuldadeVisitanteTotal = ciclo_dificuldadeVisitanteTotal;
	// Ciclo_HistoricosVisitadoTotal = ciclo_HistoricosVisitadoTotal;
	// Ciclo_HistoricosVisitanteTotal = ciclo_HistoricosVisitanteTotal;
	// CicloPerna_numeroJogosVisitadoTotal =
	// cicloPerna_numeroJogosVisitadoTotal;
	// CicloPerna_numeroJogosVisitanteTotal =
	// cicloPerna_numeroJogosVisitanteTotal;
	// CicloPerna_dificuldadeVisitadoTotal =
	// cicloPerna_dificuldadeVisitadoTotal;
	// CicloPerna_dificuldadeVisitanteTotal =
	// cicloPerna_dificuldadeVisitanteTotal;
	// CicloPerna_HistoricosVisitadoTotal = cicloPerna_HistoricosVisitadoTotal;
	// CicloPerna_HistoricosVisitanteTotal =
	// cicloPerna_HistoricosVisitanteTotal;
	//
	// FR_dificuldadeVisitadoHome = fR_dificuldadeVisitadoHome;
	// FR_dificuldadeVisitanteAway = fR_dificuldadeVisitanteAway;
	// FR_HistoricosVisitadoHome = fR_HistoricosVisitadoHome;
	// FR_HistoricosVisitanteAway = fR_HistoricosVisitanteAway;
	// FR_ratingResultadoVisitadoHome = fR_ratingResultadoVisitadoHome;
	// FR_ratingResultadoVisitanteAway = fR_ratingResultadoVisitanteAway;
	// FR_ResultadoVisitadoHome = fR_ResultadoVisitadoHome;
	// FR_ResultadoVisitanteAway = fR_ResultadoVisitanteAway;
	//
	// QLT_percentagemResultadoVisitado_5jogos =
	// qLT_percentagemResultadoVisitado_5jogos;
	// QLT_percentagemResultadoVisitante_5jogos =
	// qLT_percentagemResultadoVisitante_5jogos;
	// QLT_dificuldadeResultadoVisitado_5jogos =
	// qLT_dificuldadeResultadoVisitado_5jogos;
	// QLT_dificuldadeResultadoVisitante_5jogos =
	// qLT_dificuldadeResultadoVisitante_5jogos;
	// QLT_percentagemResultadoVisitadoNoIntervalo_5jogos =
	// qLT_percentagemResultadoVisitadoNoIntervalo_5jogos;
	// QLT_percentagemResultadoVisitanteNoIntervalo_5jogos =
	// qLT_percentagemResultadoVisitanteNoIntervalo_5jogos;
	// QLT_numeroJogosVisitado_5jogos = qLT_numeroJogosVisitado_5jogos;
	// QLT_numeroJogosVisitante_5jogos = qLT_numeroJogosVisitante_5jogos;
	// QLT_percentagemResultadoVisitadoTrocado_5jogos =
	// qLT_percentagemResultadoVisitado2_5jogos;
	// QLT_percentagemResultadoVisitanteTrocado_5jogos =
	// qLT_percentagemResultadoVisitante2_5jogos;
	// QLT_dificuldadeResultadoVisitadoTrocado_5jogos =
	// qLT_dificuldadeResultadoVisitado2_5jogos;
	// QLT_dificuldadeResultadoVisitanteTrocado_5jogos =
	// qLT_dificuldadeResultadoVisitante2_5jogos;
	// QLT_percentagemResultadoVisitadoNoIntervaloTrocado_5jogos =
	// qLT_percentagemResultadoVisitadoNoIntervalo2_5jogos;
	// QLT_percentagemResultadoVisitanteNoIntervaloTrocado_5jogos =
	// qLT_percentagemResultadoVisitanteNoIntervalo2_5jogos;
	// QLT_numeroJogosVisitadoTrocado_5jogos = qLT_numeroJogosVisitado2_5jogos;
	// QLT_numeroJogosVisitanteTrocado_5jogos =
	// qLT_numeroJogosVisitante2_5jogos;
	//
	// }
	//
	// public Date getData() {
	// return data;
	// }
	//
	// public void setData(Date data) {
	// this.data = data;
	// }
	//
	// public Long getIdVisitado() {
	// return idVisitado;
	// }
	//
	// public void setIdVisitado(Long idVisitado) {
	// this.idVisitado = idVisitado;
	// }
	//
	// public Long getIdVisitante() {
	// return idVisitante;
	// }
	//
	// public void setIdVisitante(Long idVisitante) {
	// this.idVisitante = idVisitante;
	// }
	//
	// public String getHomeTeamName() {
	// return homeTeamName;
	// }
	//
	// public void setHomeTeamName(String homeTeamName) {
	// this.homeTeamName = homeTeamName;
	// }
	//
	// public String getAwayTeamName() {
	// return awayTeamName;
	// }
	//
	// public void setAwayTeamName(String awayTeamName) {
	// this.awayTeamName = awayTeamName;
	// }
	//
	// public Double getQualidadeVisitado() {
	// return qualidadeVisitado;
	// }
	//
	// public void setQualidadeVisitado(Double qualidadeVisitado) {
	// this.qualidadeVisitado = qualidadeVisitado;
	// }
	//
	// public Double getQualidadeVisitante() {
	// return qualidadeVisitante;
	// }
	//
	// public void setQualidadeVisitante(Double qualidadeVisitante) {
	// this.qualidadeVisitante = qualidadeVisitante;
	// }
	//
	// public Integer getFR_diasDescansoVisitado() {
	// return FR_diasDescansoVisitado;
	// }
	//
	// public void setFR_diasDescansoVisitado(Integer fR_diasDescansoVisitado) {
	// FR_diasDescansoVisitado = fR_diasDescansoVisitado;
	// }
	//
	// public Integer getFR_diasDescansoVisitante() {
	// return FR_diasDescansoVisitante;
	// }
	//
	// public void setFR_diasDescansoVisitante(Integer fR_diasDescansoVisitante)
	// {
	// FR_diasDescansoVisitante = fR_diasDescansoVisitante;
	// }
	//
	// public Double getFR_ratingResultadoVisitado() {
	// return FR_ratingResultadoVisitado;
	// }
	//
	// public void setFR_ratingResultadoVisitado(Double
	// fR_ratingResultadoVisitado) {
	// FR_ratingResultadoVisitado = fR_ratingResultadoVisitado;
	// }
	//
	// public Double getFR_ratingResultadoVisitante() {
	// return FR_ratingResultadoVisitante;
	// }
	//
	// public void setFR_ratingResultadoVisitante(Double
	// fR_ratingResultadoVisitante) {
	// FR_ratingResultadoVisitante = fR_ratingResultadoVisitante;
	// }
	//
	// public Double getFR_dificuldadeVisitado() {
	// return FR_dificuldadeVisitado;
	// }
	//
	// public void setFR_dificuldadeVisitado(Double fR_dificuldadeVisitado) {
	// FR_dificuldadeVisitado = fR_dificuldadeVisitado;
	// }
	//
	// public Double getFR_dificuldadeVisitante() {
	// return FR_dificuldadeVisitante;
	// }
	//
	// public void setFR_dificuldadeVisitante(Double fR_dificuldadeVisitante) {
	// FR_dificuldadeVisitante = fR_dificuldadeVisitante;
	// }
	//
	// public Integer getFR_HistoricosVisitado() {
	// return FR_HistoricosVisitado;
	// }
	//
	// public void setFR_HistoricosVisitado(Integer fR_HistoricosVisitado) {
	// FR_HistoricosVisitado = fR_HistoricosVisitado;
	// }
	//
	// public Integer getFR_HistoricosVisitante() {
	// return FR_HistoricosVisitante;
	// }
	//
	// public void setFR_HistoricosVisitante(Integer fR_HistoricosVisitante) {
	// FR_HistoricosVisitante = fR_HistoricosVisitante;
	// }
	//
	// public Integer getCiclo_numeroJogosVisitado() {
	// return Ciclo_numeroJogosVisitado;
	// }
	//
	// public void setCiclo_numeroJogosVisitado(Integer
	// ciclo_numeroJogosVisitado) {
	// Ciclo_numeroJogosVisitado = ciclo_numeroJogosVisitado;
	// }
	//
	// public Integer getCiclo_numeroJogosVisitante() {
	// return Ciclo_numeroJogosVisitante;
	// }
	//
	// public void setCiclo_numeroJogosVisitante(Integer
	// ciclo_numeroJogosVisitante) {
	// Ciclo_numeroJogosVisitante = ciclo_numeroJogosVisitante;
	// }
	//
	// public Double getCiclo_dificuldadeVisitado() {
	// return Ciclo_dificuldadeVisitado;
	// }
	//
	// public void setCiclo_dificuldadeVisitado(Double
	// ciclo_dificuldadeVisitado) {
	// Ciclo_dificuldadeVisitado = ciclo_dificuldadeVisitado;
	// }
	//
	// public Double getCiclo_dificuldadeVisitante() {
	// return Ciclo_dificuldadeVisitante;
	// }
	//
	// public void setCiclo_dificuldadeVisitante(Double
	// ciclo_dificuldadeVisitante) {
	// Ciclo_dificuldadeVisitante = ciclo_dificuldadeVisitante;
	// }
	//
	// public Integer getCiclo_HistoricosVisitado() {
	// return Ciclo_HistoricosVisitado;
	// }
	//
	// public void setCiclo_HistoricosVisitado(Integer ciclo_HistoricosVisitado)
	// {
	// Ciclo_HistoricosVisitado = ciclo_HistoricosVisitado;
	// }
	//
	// public Integer getCiclo_HistoricosVisitante() {
	// return Ciclo_HistoricosVisitante;
	// }
	//
	// public void setCiclo_HistoricosVisitante(Integer
	// ciclo_HistoricosVisitante) {
	// Ciclo_HistoricosVisitante = ciclo_HistoricosVisitante;
	// }
	//
	// public Integer getCicloPerna_numeroJogosVisitado() {
	// return CicloPerna_numeroJogosVisitado;
	// }
	//
	// public void setCicloPerna_numeroJogosVisitado(Integer
	// cicloPerna_numeroJogosVisitado) {
	// CicloPerna_numeroJogosVisitado = cicloPerna_numeroJogosVisitado;
	// }
	//
	// public Integer getCicloPerna_numeroJogosVisitante() {
	// return CicloPerna_numeroJogosVisitante;
	// }
	//
	// public void setCicloPerna_numeroJogosVisitante(Integer
	// cicloPerna_numeroJogosVisitante) {
	// CicloPerna_numeroJogosVisitante = cicloPerna_numeroJogosVisitante;
	// }
	//
	// public Double getCicloPerna_dificuldadeVisitado() {
	// return CicloPerna_dificuldadeVisitado;
	// }
	//
	// public void setCicloPerna_dificuldadeVisitado(Double
	// cicloPerna_dificuldadeVisitado) {
	// CicloPerna_dificuldadeVisitado = cicloPerna_dificuldadeVisitado;
	// }
	//
	// public Double getCicloPerna_dificuldadeVisitante() {
	// return CicloPerna_dificuldadeVisitante;
	// }
	//
	// public void setCicloPerna_dificuldadeVisitante(Double
	// cicloPerna_dificuldadeVisitante) {
	// CicloPerna_dificuldadeVisitante = cicloPerna_dificuldadeVisitante;
	// }
	//
	// public Integer getCicloPerna_HistoricosVisitado() {
	// return CicloPerna_HistoricosVisitado;
	// }
	//
	// public void setCicloPerna_HistoricosVisitado(Integer
	// cicloPerna_HistoricosVisitado) {
	// CicloPerna_HistoricosVisitado = cicloPerna_HistoricosVisitado;
	// }
	//
	// public Integer getCicloPerna_HistoricosVisitante() {
	// return CicloPerna_HistoricosVisitante;
	// }
	//
	// public void setCicloPerna_HistoricosVisitante(Integer
	// cicloPerna_HistoricosVisitante) {
	// CicloPerna_HistoricosVisitante = cicloPerna_HistoricosVisitante;
	// }
	//
	// public Double getH2H_ratingResultado() {
	// return H2H_ratingResultado;
	// }
	//
	// public void setH2H_ratingResultado(Double h2h_ratingResultado) {
	// H2H_ratingResultado = h2h_ratingResultado;
	// }
	//
	// public Integer getH2H_numeroJogos() {
	// return H2H_numeroJogos;
	// }
	//
	// public void setH2H_numeroJogos(Integer h2h_numeroJogos) {
	// H2H_numeroJogos = h2h_numeroJogos;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitado() {
	// return QLT_percentagemResultadoVisitado;
	// }
	//
	// public void setQLT_percentagemResultadoVisitado(Double
	// qLT_percentagemResultadoVisitado) {
	// QLT_percentagemResultadoVisitado = qLT_percentagemResultadoVisitado;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitante() {
	// return QLT_percentagemResultadoVisitante;
	// }
	//
	// public void setQLT_percentagemResultadoVisitante(Double
	// qLT_percentagemResultadoVisitante) {
	// QLT_percentagemResultadoVisitante = qLT_percentagemResultadoVisitante;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitado() {
	// return QLT_dificuldadeResultadoVisitado;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitado(Double
	// qLT_dificuldadeResultadoVisitado) {
	// QLT_dificuldadeResultadoVisitado = qLT_dificuldadeResultadoVisitado;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitante() {
	// return QLT_dificuldadeResultadoVisitante;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitante(Double
	// qLT_dificuldadeResultadoVisitante) {
	// QLT_dificuldadeResultadoVisitante = qLT_dificuldadeResultadoVisitante;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitadoNoIntervalo() {
	// return QLT_percentagemResultadoVisitadoNoIntervalo;
	// }
	//
	// public void setQLT_percentagemResultadoVisitadoNoIntervalo(Double
	// qLT_percentagemResultadoVisitadoNoIntervalo) {
	// QLT_percentagemResultadoVisitadoNoIntervalo =
	// qLT_percentagemResultadoVisitadoNoIntervalo;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitanteNoIntervalo() {
	// return QLT_percentagemResultadoVisitanteNoIntervalo;
	// }
	//
	// public void setQLT_percentagemResultadoVisitanteNoIntervalo(Double
	// qLT_percentagemResultadoVisitanteNoIntervalo) {
	// QLT_percentagemResultadoVisitanteNoIntervalo =
	// qLT_percentagemResultadoVisitanteNoIntervalo;
	// }
	//
	// public Integer getQLT_numeroJogosVisitado() {
	// return QLT_numeroJogosVisitado;
	// }
	//
	// public void setQLT_numeroJogosVisitado(Integer qLT_numeroJogosVisitado) {
	// QLT_numeroJogosVisitado = qLT_numeroJogosVisitado;
	// }
	//
	// public Integer getQLT_numeroJogosVisitante() {
	// return QLT_numeroJogosVisitante;
	// }
	//
	// public void setQLT_numeroJogosVisitante(Integer qLT_numeroJogosVisitante)
	// {
	// QLT_numeroJogosVisitante = qLT_numeroJogosVisitante;
	// }
	//
	// public Integer getResult() {
	// return result;
	// }
	//
	// public void setResult(Integer result) {
	// this.result = result;
	// }
	//
	// public Double getFR_ratingQualidadeResultadoVisitado() {
	// return FR_ratingQualidadeResultadoVisitado;
	// }
	//
	// public void setFR_ratingQualidadeResultadoVisitado(Double
	// fR_ratingQualidadeResultadoVisitado) {
	// this.FR_ratingQualidadeResultadoVisitado =
	// fR_ratingQualidadeResultadoVisitado;
	// }
	//
	// public Double getFR_ratingQualidadeResultadoVisitante() {
	// return FR_ratingQualidadeResultadoVisitante;
	// }
	//
	// public void setFR_ratingQualidadeResultadoVisitante(Double
	// fR_ratingQualidadeResultadoVisitante) {
	// this.FR_ratingQualidadeResultadoVisitante =
	// fR_ratingQualidadeResultadoVisitante;
	// }
	//
	// public Integer getQLT_numeroJogosVisitadoDaPercentagem() {
	// return QLT_numeroJogosVisitadoDaPercentagem;
	// }
	//
	// public void setQLT_numeroJogosVisitadoDaPercentagem(Integer
	// qLT_numeroJogosVisitadoDaPercentagem) {
	// QLT_numeroJogosVisitadoDaPercentagem =
	// qLT_numeroJogosVisitadoDaPercentagem;
	// }
	//
	// public Integer getQLT_numeroJogosVisitanteDaPercentagem() {
	// return QLT_numeroJogosVisitanteDaPercentagem;
	// }
	//
	// public void setQLT_numeroJogosVisitanteDaPercentagem(Integer
	// qLT_numeroJogosVisitanteDaPercentagem) {
	// QLT_numeroJogosVisitanteDaPercentagem =
	// qLT_numeroJogosVisitanteDaPercentagem;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitado2() {
	// return QLT_percentagemResultadoVisitadoTrocado;
	// }
	//
	// public void setQLT_percentagemResultadoVisitado2(Double
	// qLT_percentagemResultadoVisitado2) {
	// QLT_percentagemResultadoVisitadoTrocado =
	// qLT_percentagemResultadoVisitado2;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitante2() {
	// return QLT_percentagemResultadoVisitanteTrocado;
	// }
	//
	// public void setQLT_percentagemResultadoVisitante2(Double
	// qLT_percentagemResultadoVisitante2) {
	// QLT_percentagemResultadoVisitanteTrocado =
	// qLT_percentagemResultadoVisitante2;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitado2() {
	// return QLT_dificuldadeResultadoVisitadoTrocado;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitado2(Double
	// qLT_dificuldadeResultadoVisitado2) {
	// QLT_dificuldadeResultadoVisitadoTrocado =
	// qLT_dificuldadeResultadoVisitado2;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitante2() {
	// return QLT_dificuldadeResultadoVisitanteTrocado;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitante2(Double
	// qLT_dificuldadeResultadoVisitante2) {
	// QLT_dificuldadeResultadoVisitanteTrocado =
	// qLT_dificuldadeResultadoVisitante2;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitadoNoIntervalo2() {
	// return QLT_percentagemResultadoVisitadoNoIntervaloTrocado;
	// }
	//
	// public void setQLT_percentagemResultadoVisitadoNoIntervalo2(Double
	// qLT_percentagemResultadoVisitadoNoIntervalo2) {
	// QLT_percentagemResultadoVisitadoNoIntervaloTrocado =
	// qLT_percentagemResultadoVisitadoNoIntervalo2;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitanteNoIntervalo2() {
	// return QLT_percentagemResultadoVisitanteNoIntervaloTrocado;
	// }
	//
	// public void setQLT_percentagemResultadoVisitanteNoIntervalo2(Double
	// qLT_percentagemResultadoVisitanteNoIntervalo2) {
	// QLT_percentagemResultadoVisitanteNoIntervaloTrocado =
	// qLT_percentagemResultadoVisitanteNoIntervalo2;
	// }
	//
	// public Integer getQLT_numeroJogosVisitadoNoIntervalo() {
	// return QLT_numeroJogosVisitadoNoIntervalo;
	// }
	//
	// public void setQLT_numeroJogosVisitadoNoIntervalo(Integer
	// qLT_numeroJogosVisitadoNoIntervalo) {
	// QLT_numeroJogosVisitadoNoIntervalo = qLT_numeroJogosVisitadoNoIntervalo;
	// }
	//
	// public Integer getQLT_numeroJogosVisitanteNoIntervalo() {
	// return QLT_numeroJogosVisitanteNoIntervalo;
	// }
	//
	// public void setQLT_numeroJogosVisitanteNoIntervalo(Integer
	// qLT_numeroJogosVisitanteNoIntervalo) {
	// QLT_numeroJogosVisitanteNoIntervalo =
	// qLT_numeroJogosVisitanteNoIntervalo;
	// }
	//
	// public Integer getH2h_Results() {
	// return H2h_Results;
	// }
	//
	// public void setH2h_Results(Integer h2h_Results) {
	// H2h_Results = h2h_Results;
	// }
	//
	// public Integer getFR_ResultadosVisitado() {
	// return FR_ResultadosVisitado;
	// }
	//
	// public void setFR_ResultadosVisitado(Integer fR_ResultadosVisitado) {
	// FR_ResultadosVisitado = fR_ResultadosVisitado;
	// }
	//
	// public Integer getFR_ResultadosVisitante() {
	// return FR_ResultadosVisitante;
	// }
	//
	// public void setFR_ResultadosVisitante(Integer fR_ResultadosVisitante) {
	// FR_ResultadosVisitante = fR_ResultadosVisitante;
	// }
	//
	// public Integer getQLT_homeTeamNumeroJogosTrocado() {
	// return QLT_homeTeamNumeroJogosTrocado;
	// }
	//
	// public void setQLT_homeTeamNumeroJogosTrocado(Integer
	// qLT_homeTeamNumeroJogosTrocado) {
	// QLT_homeTeamNumeroJogosTrocado = qLT_homeTeamNumeroJogosTrocado;
	// }
	//
	// public Integer getQLT_awayTeamNumeroJogosTrocado() {
	// return QLT_awayTeamNumeroJogosTrocado;
	// }
	//
	// public void setQLT_awayTeamNumeroJogosTrocado(Integer
	// qLT_awayTeamNumeroJogosTrocado) {
	// QLT_awayTeamNumeroJogosTrocado = qLT_awayTeamNumeroJogosTrocado;
	// }
	//
	// public Integer getGolosVisitado() {
	// return golosVisitado;
	// }
	//
	// public void setGolosVisitado(Integer golosVisitado) {
	// this.golosVisitado = golosVisitado;
	// }
	//
	// public Integer getGolosSofridosVisitado() {
	// return golosSofridosVisitado;
	// }
	//
	// public void setGolosSofridosVisitado(Integer golosSofridosVisitado) {
	// this.golosSofridosVisitado = golosSofridosVisitado;
	// }
	//
	// public Integer getDiferencaGolosVisitado() {
	// return diferencaGolosVisitado;
	// }
	//
	// public void setDiferencaGolosVisitado(Integer diferencaGolosVisitado) {
	// this.diferencaGolosVisitado = diferencaGolosVisitado;
	// }
	//
	// public Integer getGolosVisitante() {
	// return golosVisitante;
	// }
	//
	// public void setGolosVisitante(Integer golosVisitante) {
	// this.golosVisitante = golosVisitante;
	// }
	//
	// public Integer getGolosSofridosVisitante() {
	// return golosSofridosVisitante;
	// }
	//
	// public void setGolosSofridosVisitante(Integer golosSofridosVisitante) {
	// this.golosSofridosVisitante = golosSofridosVisitante;
	// }
	//
	// public Integer getDiferencaGolosVisitante() {
	// return diferencaGolosVisitante;
	// }
	//
	// public void setDiferencaGolosVisitante(Integer diferencaGolosVisitante) {
	// this.diferencaGolosVisitante = diferencaGolosVisitante;
	// }
	//
	// public Integer getGolosVisitadoCasa() {
	// return golosVisitadoCasa;
	// }
	//
	// public void setGolosVisitadoCasa(Integer golosVisitadoCasa) {
	// this.golosVisitadoCasa = golosVisitadoCasa;
	// }
	//
	// public Integer getGolosSofridosVisitadoCasa() {
	// return golosSofridosVisitadoCasa;
	// }
	//
	// public void setGolosSofridosVisitadoCasa(Integer
	// golosSofridosVisitadoCasa) {
	// this.golosSofridosVisitadoCasa = golosSofridosVisitadoCasa;
	// }
	//
	// public Integer getDiferencaGolosVisitadoCasa() {
	// return diferencaGolosVisitadoCasa;
	// }
	//
	// public void setDiferencaGolosVisitadoCasa(Integer
	// diferencaGolosVisitadoCasa) {
	// this.diferencaGolosVisitadoCasa = diferencaGolosVisitadoCasa;
	// }
	//
	// public Integer getGolosVisitanteFora() {
	// return golosVisitanteFora;
	// }
	//
	// public void setGolosVisitanteFora(Integer golosVisitanteFora) {
	// this.golosVisitanteFora = golosVisitanteFora;
	// }
	//
	// public Integer getGolosSofridosVisitanteFora() {
	// return golosSofridosVisitanteFora;
	// }
	//
	// public void setGolosSofridosVisitanteFora(Integer
	// golosSofridosVisitanteFora) {
	// this.golosSofridosVisitanteFora = golosSofridosVisitanteFora;
	// }
	//
	// public Integer getDiferencaGolosVisitanteFora() {
	// return diferencaGolosVisitanteFora;
	// }
	//
	// public void setDiferencaGolosVisitanteFora(Integer
	// diferencaGolosVisitanteFora) {
	// this.diferencaGolosVisitanteFora = diferencaGolosVisitanteFora;
	// }
	//
	// public Integer getClassificacaoVisitado() {
	// return classificacaoVisitado;
	// }
	//
	// public void setClassificacaoVisitado(Integer classificacaoVisitado) {
	// this.classificacaoVisitado = classificacaoVisitado;
	// }
	//
	// public Integer getClassificacaoVisitante() {
	// return classificacaoVisitante;
	// }
	//
	// public void setClassificacaoVisitante(Integer classificacaoVisitante) {
	// this.classificacaoVisitante = classificacaoVisitante;
	// }
	//
	// public Double getQualidadeVisitadoCasa() {
	// return qualidadeVisitadoCasa;
	// }
	//
	// public void setQualidadeVisitadoCasa(Double qualidadeVisitadoCasa) {
	// this.qualidadeVisitadoCasa = qualidadeVisitadoCasa;
	// }
	//
	// public Double getQualidadeVisitadoFora() {
	// return qualidadeVisitadoFora;
	// }
	//
	// public void setQualidadeVisitadoFora(Double qualidadeVisitadoFora) {
	// this.qualidadeVisitadoFora = qualidadeVisitadoFora;
	// }
	//
	// public Double getQualidadeVisitanteCasa() {
	// return qualidadeVisitanteCasa;
	// }
	//
	// public void setQualidadeVisitanteCasa(Double qualidadeVisitanteCasa) {
	// this.qualidadeVisitanteCasa = qualidadeVisitanteCasa;
	// }
	//
	// public Double getQualidadeVisitanteFora() {
	// return qualidadeVisitanteFora;
	// }
	//
	// public void setQualidadeVisitanteFora(Double qualidadeVisitanteFora) {
	// this.qualidadeVisitanteFora = qualidadeVisitanteFora;
	// }
	//
	// public Integer getCiclo_numeroJogosVisitadoTotal() {
	// return Ciclo_numeroJogosVisitadoTotal;
	// }
	//
	// public void setCiclo_numeroJogosVisitadoTotal(Integer
	// ciclo_numeroJogosVisitadoTotal) {
	// Ciclo_numeroJogosVisitadoTotal = ciclo_numeroJogosVisitadoTotal;
	// }
	//
	// public Integer getCiclo_numeroJogosVisitanteTotal() {
	// return Ciclo_numeroJogosVisitanteTotal;
	// }
	//
	// public void setCiclo_numeroJogosVisitanteTotal(Integer
	// ciclo_numeroJogosVisitanteTotal) {
	// Ciclo_numeroJogosVisitanteTotal = ciclo_numeroJogosVisitanteTotal;
	// }
	//
	// public Double getCiclo_dificuldadeVisitadoTotal() {
	// return Ciclo_dificuldadeVisitadoTotal;
	// }
	//
	// public void setCiclo_dificuldadeVisitadoTotal(Double
	// ciclo_dificuldadeVisitadoTotal) {
	// Ciclo_dificuldadeVisitadoTotal = ciclo_dificuldadeVisitadoTotal;
	// }
	//
	// public Double getCiclo_dificuldadeVisitanteTotal() {
	// return Ciclo_dificuldadeVisitanteTotal;
	// }
	//
	// public void setCiclo_dificuldadeVisitanteTotal(Double
	// ciclo_dificuldadeVisitanteTotal) {
	// Ciclo_dificuldadeVisitanteTotal = ciclo_dificuldadeVisitanteTotal;
	// }
	//
	// public Integer getCiclo_HistoricosVisitadoTotal() {
	// return Ciclo_HistoricosVisitadoTotal;
	// }
	//
	// public void setCiclo_HistoricosVisitadoTotal(Integer
	// ciclo_HistoricosVisitadoTotal) {
	// Ciclo_HistoricosVisitadoTotal = ciclo_HistoricosVisitadoTotal;
	// }
	//
	// public Integer getCiclo_HistoricosVisitanteTotal() {
	// return Ciclo_HistoricosVisitanteTotal;
	// }
	//
	// public void setCiclo_HistoricosVisitanteTotal(Integer
	// ciclo_HistoricosVisitanteTotal) {
	// Ciclo_HistoricosVisitanteTotal = ciclo_HistoricosVisitanteTotal;
	// }
	//
	// public Integer getCicloPerna_numeroJogosVisitadoTotal() {
	// return CicloPerna_numeroJogosVisitadoTotal;
	// }
	//
	// public void setCicloPerna_numeroJogosVisitadoTotal(Integer
	// cicloPerna_numeroJogosVisitadoTotal) {
	// CicloPerna_numeroJogosVisitadoTotal =
	// cicloPerna_numeroJogosVisitadoTotal;
	// }
	//
	// public Integer getCicloPerna_numeroJogosVisitanteTotal() {
	// return CicloPerna_numeroJogosVisitanteTotal;
	// }
	//
	// public void setCicloPerna_numeroJogosVisitanteTotal(Integer
	// cicloPerna_numeroJogosVisitanteTotal) {
	// CicloPerna_numeroJogosVisitanteTotal =
	// cicloPerna_numeroJogosVisitanteTotal;
	// }
	//
	// public Double getCicloPerna_dificuldadeVisitadoTotal() {
	// return CicloPerna_dificuldadeVisitadoTotal;
	// }
	//
	// public void setCicloPerna_dificuldadeVisitadoTotal(Double
	// cicloPerna_dificuldadeVisitadoTotal) {
	// CicloPerna_dificuldadeVisitadoTotal =
	// cicloPerna_dificuldadeVisitadoTotal;
	// }
	//
	// public Double getCicloPerna_dificuldadeVisitanteTotal() {
	// return CicloPerna_dificuldadeVisitanteTotal;
	// }
	//
	// public void setCicloPerna_dificuldadeVisitanteTotal(Double
	// cicloPerna_dificuldadeVisitanteTotal) {
	// CicloPerna_dificuldadeVisitanteTotal =
	// cicloPerna_dificuldadeVisitanteTotal;
	// }
	//
	// public Integer getCicloPerna_HistoricosVisitadoTotal() {
	// return CicloPerna_HistoricosVisitadoTotal;
	// }
	//
	// public void setCicloPerna_HistoricosVisitadoTotal(Integer
	// cicloPerna_HistoricosVisitadoTotal) {
	// CicloPerna_HistoricosVisitadoTotal = cicloPerna_HistoricosVisitadoTotal;
	// }
	//
	// public Integer getCicloPerna_HistoricosVisitanteTotal() {
	// return CicloPerna_HistoricosVisitanteTotal;
	// }
	//
	// public void setCicloPerna_HistoricosVisitanteTotal(Integer
	// cicloPerna_HistoricosVisitanteTotal) {
	// CicloPerna_HistoricosVisitanteTotal =
	// cicloPerna_HistoricosVisitanteTotal;
	// }
	//
	// public Double getFR_dificuldadeVisitadoHome() {
	// return FR_dificuldadeVisitadoHome;
	// }
	//
	// public void setFR_dificuldadeVisitadoHome(Double
	// fR_dificuldadeVisitadoHome) {
	// FR_dificuldadeVisitadoHome = fR_dificuldadeVisitadoHome;
	// }
	//
	// public Double getFR_dificuldadeVisitanteAway() {
	// return FR_dificuldadeVisitanteAway;
	// }
	//
	// public void setFR_dificuldadeVisitanteAway(Double
	// fR_dificuldadeVisitanteAway) {
	// FR_dificuldadeVisitanteAway = fR_dificuldadeVisitanteAway;
	// }
	//
	// public Integer getFR_HistoricosVisitadoHome() {
	// return FR_HistoricosVisitadoHome;
	// }
	//
	// public void setFR_HistoricosVisitadoHome(Integer
	// fR_HistoricosVisitadoHome) {
	// FR_HistoricosVisitadoHome = fR_HistoricosVisitadoHome;
	// }
	//
	// public Integer getFR_HistoricosVisitanteAway() {
	// return FR_HistoricosVisitanteAway;
	// }
	//
	// public void setFR_HistoricosVisitanteAway(Integer
	// fR_HistoricosVisitanteAway) {
	// FR_HistoricosVisitanteAway = fR_HistoricosVisitanteAway;
	// }
	//
	// public Double getFR_ratingResultadoVisitadoHome() {
	// return FR_ratingResultadoVisitadoHome;
	// }
	//
	// public void setFR_ratingResultadoVisitadoHome(Double
	// fR_ratingResultadoVisitadoHome) {
	// FR_ratingResultadoVisitadoHome = fR_ratingResultadoVisitadoHome;
	// }
	//
	// public Double getFR_ratingResultadoVisitanteAway() {
	// return FR_ratingResultadoVisitanteAway;
	// }
	//
	// public void setFR_ratingResultadoVisitanteAway(Double
	// fR_ratingResultadoVisitanteAway) {
	// FR_ratingResultadoVisitanteAway = fR_ratingResultadoVisitanteAway;
	// }
	//
	// public Integer getFR_ResultadoVisitadoHome() {
	// return FR_ResultadoVisitadoHome;
	// }
	//
	// public void setFR_ResultadoVisitadoHome(Integer fR_ResultadoVisitadoHome)
	// {
	// FR_ResultadoVisitadoHome = fR_ResultadoVisitadoHome;
	// }
	//
	// public Integer getFR_ResultadoVisitanteAway() {
	// return FR_ResultadoVisitanteAway;
	// }
	//
	// public void setFR_ResultadoVisitanteAway(Integer
	// fR_ResultadoVisitanteAway) {
	// FR_ResultadoVisitanteAway = fR_ResultadoVisitanteAway;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitado_5jogos() {
	// return QLT_percentagemResultadoVisitado_5jogos;
	// }
	//
	// public void setQLT_percentagemResultadoVisitado_5jogos(Double
	// qLT_percentagemResultadoVisitado_5jogos) {
	// QLT_percentagemResultadoVisitado_5jogos =
	// qLT_percentagemResultadoVisitado_5jogos;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitante_5jogos() {
	// return QLT_percentagemResultadoVisitante_5jogos;
	// }
	//
	// public void setQLT_percentagemResultadoVisitante_5jogos(Double
	// qLT_percentagemResultadoVisitante_5jogos) {
	// QLT_percentagemResultadoVisitante_5jogos =
	// qLT_percentagemResultadoVisitante_5jogos;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitado_5jogos() {
	// return QLT_dificuldadeResultadoVisitado_5jogos;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitado_5jogos(Double
	// qLT_dificuldadeResultadoVisitado_5jogos) {
	// QLT_dificuldadeResultadoVisitado_5jogos =
	// qLT_dificuldadeResultadoVisitado_5jogos;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitante_5jogos() {
	// return QLT_dificuldadeResultadoVisitante_5jogos;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitante_5jogos(Double
	// qLT_dificuldadeResultadoVisitante_5jogos) {
	// QLT_dificuldadeResultadoVisitante_5jogos =
	// qLT_dificuldadeResultadoVisitante_5jogos;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitadoNoIntervalo_5jogos() {
	// return QLT_percentagemResultadoVisitadoNoIntervalo_5jogos;
	// }
	//
	// public void setQLT_percentagemResultadoVisitadoNoIntervalo_5jogos(
	// Double qLT_percentagemResultadoVisitadoNoIntervalo_5jogos) {
	// QLT_percentagemResultadoVisitadoNoIntervalo_5jogos =
	// qLT_percentagemResultadoVisitadoNoIntervalo_5jogos;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitanteNoIntervalo_5jogos() {
	// return QLT_percentagemResultadoVisitanteNoIntervalo_5jogos;
	// }
	//
	// public void setQLT_percentagemResultadoVisitanteNoIntervalo_5jogos(
	// Double qLT_percentagemResultadoVisitanteNoIntervalo_5jogos) {
	// QLT_percentagemResultadoVisitanteNoIntervalo_5jogos =
	// qLT_percentagemResultadoVisitanteNoIntervalo_5jogos;
	// }
	//
	// public Integer getQLT_numeroJogosVisitado_5jogos() {
	// return QLT_numeroJogosVisitado_5jogos;
	// }
	//
	// public void setQLT_numeroJogosVisitado_5jogos(Integer
	// qLT_numeroJogosVisitado_5jogos) {
	// QLT_numeroJogosVisitado_5jogos = qLT_numeroJogosVisitado_5jogos;
	// }
	//
	// public Integer getQLT_numeroJogosVisitante_5jogos() {
	// return QLT_numeroJogosVisitante_5jogos;
	// }
	//
	// public void setQLT_numeroJogosVisitante_5jogos(Integer
	// qLT_numeroJogosVisitante_5jogos) {
	// QLT_numeroJogosVisitante_5jogos = qLT_numeroJogosVisitante_5jogos;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitadoTrocado_5jogos() {
	// return QLT_percentagemResultadoVisitadoTrocado_5jogos;
	// }
	//
	// public void setQLT_percentagemResultadoVisitadoTrocado_5jogos(Double
	// qLT_percentagemResultadoVisitadoTrocado_5jogos) {
	// QLT_percentagemResultadoVisitadoTrocado_5jogos =
	// qLT_percentagemResultadoVisitadoTrocado_5jogos;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitanteTrocado_5jogos() {
	// return QLT_percentagemResultadoVisitanteTrocado_5jogos;
	// }
	//
	// public void setQLT_percentagemResultadoVisitanteTrocado_5jogos(Double
	// qLT_percentagemResultadoVisitanteTrocado_5jogos) {
	// QLT_percentagemResultadoVisitanteTrocado_5jogos =
	// qLT_percentagemResultadoVisitanteTrocado_5jogos;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitadoTrocado_5jogos() {
	// return QLT_dificuldadeResultadoVisitadoTrocado_5jogos;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitadoTrocado_5jogos(Double
	// qLT_dificuldadeResultadoVisitadoTrocado_5jogos) {
	// QLT_dificuldadeResultadoVisitadoTrocado_5jogos =
	// qLT_dificuldadeResultadoVisitadoTrocado_5jogos;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitanteTrocado_5jogos() {
	// return QLT_dificuldadeResultadoVisitanteTrocado_5jogos;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitanteTrocado_5jogos(Double
	// qLT_dificuldadeResultadoVisitanteTrocado_5jogos) {
	// QLT_dificuldadeResultadoVisitanteTrocado_5jogos =
	// qLT_dificuldadeResultadoVisitanteTrocado_5jogos;
	// }
	//
	// public Double
	// getQLT_percentagemResultadoVisitadoNoIntervaloTrocado_5jogos() {
	// return QLT_percentagemResultadoVisitadoNoIntervaloTrocado_5jogos;
	// }
	//
	// public void setQLT_percentagemResultadoVisitadoNoIntervaloTrocado_5jogos(
	// Double qLT_percentagemResultadoVisitadoNoIntervaloTrocado_5jogos) {
	// QLT_percentagemResultadoVisitadoNoIntervaloTrocado_5jogos =
	// qLT_percentagemResultadoVisitadoNoIntervaloTrocado_5jogos;
	// }
	//
	// public Double
	// getQLT_percentagemResultadoVisitanteNoIntervaloTrocado_5jogos() {
	// return QLT_percentagemResultadoVisitanteNoIntervaloTrocado_5jogos;
	// }
	//
	// public void
	// setQLT_percentagemResultadoVisitanteNoIntervaloTrocado_5jogos(
	// Double qLT_percentagemResultadoVisitanteNoIntervaloTrocado_5jogos) {
	// QLT_percentagemResultadoVisitanteNoIntervaloTrocado_5jogos =
	// qLT_percentagemResultadoVisitanteNoIntervaloTrocado_5jogos;
	// }
	//
	// public Integer getQLT_numeroJogosVisitadoTrocado_5jogos() {
	// return QLT_numeroJogosVisitadoTrocado_5jogos;
	// }
	//
	// public void setQLT_numeroJogosVisitadoTrocado_5jogos(Integer
	// qLT_numeroJogosVisitadoTrocado_5jogos) {
	// QLT_numeroJogosVisitadoTrocado_5jogos =
	// qLT_numeroJogosVisitadoTrocado_5jogos;
	// }
	//
	// public Integer getQLT_numeroJogosVisitanteTrocado_5jogos() {
	// return QLT_numeroJogosVisitanteTrocado_5jogos;
	// }
	//
	// public void setQLT_numeroJogosVisitanteTrocado_5jogos(Integer
	// qLT_numeroJogosVisitanteTrocado_5jogos) {
	// QLT_numeroJogosVisitanteTrocado_5jogos =
	// qLT_numeroJogosVisitanteTrocado_5jogos;
	// }
	//
	// public Double getPercFRResultadoVisitadoCasa() {
	// return percFRResultadoVisitadoCasa;
	// }
	//
	// public void setPercFRResultadoVisitadoCasa(Double
	// percFRResultadoVisitadoCasa) {
	// this.percFRResultadoVisitadoCasa = percFRResultadoVisitadoCasa;
	// }
	//
	// public Double getPercFRResultadoVisitadoFora() {
	// return percFRResultadoVisitadoFora;
	// }
	//
	// public void setPercFRResultadoVisitadoFora(Double
	// percFRResultadoVisitadoFora) {
	// this.percFRResultadoVisitadoFora = percFRResultadoVisitadoFora;
	// }
	//
	// public Double getPercFRResultadoVisitanteCasa() {
	// return percFRResultadoVisitanteCasa;
	// }
	//
	// public void setPercFRResultadoVisitanteCasa(Double
	// percFRResultadoVisitanteCasa) {
	// this.percFRResultadoVisitanteCasa = percFRResultadoVisitanteCasa;
	// }
	//
	// public Double getPercFRResultadoVisitanteFora() {
	// return percFRResultadoVisitanteFora;
	// }
	//
	// public void setPercFRResultadoVisitanteFora(Double
	// percFRResultadoVisitanteFora) {
	// this.percFRResultadoVisitanteFora = percFRResultadoVisitanteFora;
	// }
	//
	// public Double getMediaGolosMarcadosVisitadoTotal() {
	// return mediaGolosMarcadosVisitadoTotal;
	// }
	//
	// public void setMediaGolosMarcadosVisitadoTotal(Double
	// mediaGolosMarcadosVisitadoTotal) {
	// this.mediaGolosMarcadosVisitadoTotal = mediaGolosMarcadosVisitadoTotal;
	// }
	//
	// public Double getMediaGolosSofridosVisitadoTotal() {
	// return mediaGolosSofridosVisitadoTotal;
	// }
	//
	// public void setMediaGolosSofridosVisitadoTotal(Double
	// mediaGolosSofridosVisitadoTotal) {
	// this.mediaGolosSofridosVisitadoTotal = mediaGolosSofridosVisitadoTotal;
	// }
	//
	// public Double getMediaGolosMarcadosVisitadoCasa() {
	// return mediaGolosMarcadosVisitadoCasa;
	// }
	//
	// public void setMediaGolosMarcadosVisitadoCasa(Double
	// mediaGolosMarcadosVisitadoCasa) {
	// this.mediaGolosMarcadosVisitadoCasa = mediaGolosMarcadosVisitadoCasa;
	// }
	//
	// public Double getMediaGolosSofridosVisitadoCasa() {
	// return mediaGolosSofridosVisitadoCasa;
	// }
	//
	// public void setMediaGolosSofridosVisitadoCasa(Double
	// mediaGolosSofridosVisitadoCasa) {
	// this.mediaGolosSofridosVisitadoCasa = mediaGolosSofridosVisitadoCasa;
	// }
	//
	// public Double getMediaGolosMarcadosVisitadoFora() {
	// return mediaGolosMarcadosVisitadoFora;
	// }
	//
	// public void setMediaGolosMarcadosVisitadoFora(Double
	// mediaGolosMarcadosVisitadoFora) {
	// this.mediaGolosMarcadosVisitadoFora = mediaGolosMarcadosVisitadoFora;
	// }
	//
	// public Double getMediaGolosSofridosVisitadoFora() {
	// return mediaGolosSofridosVisitadoFora;
	// }
	//
	// public void setMediaGolosSofridosVisitadoFora(Double
	// mediaGolosSofridosVisitadoFora) {
	// this.mediaGolosSofridosVisitadoFora = mediaGolosSofridosVisitadoFora;
	// }
	//
	// public Double getMediaGolosMarcadosVisitanteTotal() {
	// return mediaGolosMarcadosVisitanteTotal;
	// }
	//
	// public void setMediaGolosMarcadosVisitanteTotal(Double
	// mediaGolosMarcadosVisitanteTotal) {
	// this.mediaGolosMarcadosVisitanteTotal = mediaGolosMarcadosVisitanteTotal;
	// }
	//
	// public Double getMediaGolosSofridosVisitanteTotal() {
	// return mediaGolosSofridosVisitanteTotal;
	// }
	//
	// public void setMediaGolosSofridosVisitanteTotal(Double
	// mediaGolosSofridosVisitanteTotal) {
	// this.mediaGolosSofridosVisitanteTotal = mediaGolosSofridosVisitanteTotal;
	// }
	//
	// public Double getMediaGolosMarcadosVisitanteCasa() {
	// return mediaGolosMarcadosVisitanteCasa;
	// }
	//
	// public void setMediaGolosMarcadosVisitanteCasa(Double
	// mediaGolosMarcadosVisitanteCasa) {
	// this.mediaGolosMarcadosVisitanteCasa = mediaGolosMarcadosVisitanteCasa;
	// }
	//
	// public Double getMediaGolosSofridosVisitanteCasa() {
	// return mediaGolosSofridosVisitanteCasa;
	// }
	//
	// public void setMediaGolosSofridosVisitanteCasa(Double
	// mediaGolosSofridosVisitanteCasa) {
	// this.mediaGolosSofridosVisitanteCasa = mediaGolosSofridosVisitanteCasa;
	// }
	//
	// public Double getMediaGolosMarcadosVisitanteFora() {
	// return mediaGolosMarcadosVisitanteFora;
	// }
	//
	// public void setMediaGolosMarcadosVisitanteFora(Double
	// mediaGolosMarcadosVisitanteFora) {
	// this.mediaGolosMarcadosVisitanteFora = mediaGolosMarcadosVisitanteFora;
	// }
	//
	// public Double getMediaGolosSofridosVisitanteFora() {
	// return mediaGolosSofridosVisitanteFora;
	// }
	//
	// public void setMediaGolosSofridosVisitanteFora(Double
	// mediaGolosSofridosVisitanteFora) {
	// this.mediaGolosSofridosVisitanteFora = mediaGolosSofridosVisitanteFora;
	// }
	//
	// public Integer getQLT_numeroJogosVisitadoVenue() {
	// return QLT_numeroJogosVisitadoVenue;
	// }
	//
	// public void setQLT_numeroJogosVisitadoVenue(Integer
	// qLT_numeroJogosVisitadoVenue) {
	// QLT_numeroJogosVisitadoVenue = qLT_numeroJogosVisitadoVenue;
	// }
	//
	// public Integer getQLT_numeroJogosVisitanteVenue() {
	// return QLT_numeroJogosVisitanteVenue;
	// }
	//
	// public void setQLT_numeroJogosVisitanteVenue(Integer
	// qLT_numeroJogosVisitanteVenue) {
	// QLT_numeroJogosVisitanteVenue = qLT_numeroJogosVisitanteVenue;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitadoVenue() {
	// return QLT_percentagemResultadoVisitadoVenue;
	// }
	//
	// public void setQLT_percentagemResultadoVisitadoVenue(Double
	// qLT_percentagemResultadoVisitadoVenue) {
	// QLT_percentagemResultadoVisitadoVenue =
	// qLT_percentagemResultadoVisitadoVenue;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitanteVenue() {
	// return QLT_percentagemResultadoVisitanteVenue;
	// }
	//
	// public void setQLT_percentagemResultadoVisitanteVenue(Double
	// qLT_percentagemResultadoVisitanteVenue) {
	// QLT_percentagemResultadoVisitanteVenue =
	// qLT_percentagemResultadoVisitanteVenue;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitadoVenue() {
	// return QLT_dificuldadeResultadoVisitadoVenue;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitadoVenue(Double
	// qLT_dificuldadeResultadoVisitadoVenue) {
	// QLT_dificuldadeResultadoVisitadoVenue =
	// qLT_dificuldadeResultadoVisitadoVenue;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitanteVenue() {
	// return QLT_dificuldadeResultadoVisitanteVenue;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitanteVenue(Double
	// qLT_dificuldadeResultadoVisitanteVenue) {
	// QLT_dificuldadeResultadoVisitanteVenue =
	// qLT_dificuldadeResultadoVisitanteVenue;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitadoNoIntervaloVenue() {
	// return QLT_percentagemResultadoVisitadoNoIntervaloVenue;
	// }
	//
	// public void setQLT_percentagemResultadoVisitadoNoIntervaloVenue(
	// Double qLT_percentagemResultadoVisitadoNoIntervaloVenue) {
	// QLT_percentagemResultadoVisitadoNoIntervaloVenue =
	// qLT_percentagemResultadoVisitadoNoIntervaloVenue;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitanteNoIntervaloVenue() {
	// return QLT_percentagemResultadoVisitanteNoIntervaloVenue;
	// }
	//
	// public void setQLT_percentagemResultadoVisitanteNoIntervaloVenue(
	// Double qLT_percentagemResultadoVisitanteNoIntervaloVenue) {
	// QLT_percentagemResultadoVisitanteNoIntervaloVenue =
	// qLT_percentagemResultadoVisitanteNoIntervaloVenue;
	// }
	//
	// public Integer getQLT_numeroJogosVisitadoNoIntervaloVenue() {
	// return QLT_numeroJogosVisitadoNoIntervaloVenue;
	// }
	//
	// public void setQLT_numeroJogosVisitadoNoIntervaloVenue(Integer
	// qLT_numeroJogosVisitadoNoIntervaloVenue) {
	// QLT_numeroJogosVisitadoNoIntervaloVenue =
	// qLT_numeroJogosVisitadoNoIntervaloVenue;
	// }
	//
	// public Integer getQLT_numeroJogosVisitanteNoIntervaloVenue() {
	// return QLT_numeroJogosVisitanteNoIntervaloVenue;
	// }
	//
	// public void setQLT_numeroJogosVisitanteNoIntervaloVenue(Integer
	// qLT_numeroJogosVisitanteNoIntervaloVenue) {
	// QLT_numeroJogosVisitanteNoIntervaloVenue =
	// qLT_numeroJogosVisitanteNoIntervaloVenue;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitadoTrocado() {
	// return QLT_percentagemResultadoVisitadoTrocado;
	// }
	//
	// public void setQLT_percentagemResultadoVisitadoTrocado(Double
	// qLT_percentagemResultadoVisitadoTrocado) {
	// QLT_percentagemResultadoVisitadoTrocado =
	// qLT_percentagemResultadoVisitadoTrocado;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitanteTrocado() {
	// return QLT_percentagemResultadoVisitanteTrocado;
	// }
	//
	// public void setQLT_percentagemResultadoVisitanteTrocado(Double
	// qLT_percentagemResultadoVisitanteTrocado) {
	// QLT_percentagemResultadoVisitanteTrocado =
	// qLT_percentagemResultadoVisitanteTrocado;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitadoTrocado() {
	// return QLT_dificuldadeResultadoVisitadoTrocado;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitadoTrocado(Double
	// qLT_dificuldadeResultadoVisitadoTrocado) {
	// QLT_dificuldadeResultadoVisitadoTrocado =
	// qLT_dificuldadeResultadoVisitadoTrocado;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitanteTrocado() {
	// return QLT_dificuldadeResultadoVisitanteTrocado;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitanteTrocado(Double
	// qLT_dificuldadeResultadoVisitanteTrocado) {
	// QLT_dificuldadeResultadoVisitanteTrocado =
	// qLT_dificuldadeResultadoVisitanteTrocado;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitadoNoIntervaloTrocado() {
	// return QLT_percentagemResultadoVisitadoNoIntervaloTrocado;
	// }
	//
	// public void setQLT_percentagemResultadoVisitadoNoIntervaloTrocado(
	// Double qLT_percentagemResultadoVisitadoNoIntervaloTrocado) {
	// QLT_percentagemResultadoVisitadoNoIntervaloTrocado =
	// qLT_percentagemResultadoVisitadoNoIntervaloTrocado;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitanteNoIntervaloTrocado() {
	// return QLT_percentagemResultadoVisitanteNoIntervaloTrocado;
	// }
	//
	// public void setQLT_percentagemResultadoVisitanteNoIntervaloTrocado(
	// Double qLT_percentagemResultadoVisitanteNoIntervaloTrocado) {
	// QLT_percentagemResultadoVisitanteNoIntervaloTrocado =
	// qLT_percentagemResultadoVisitanteNoIntervaloTrocado;
	// }
	//
	// public Integer getQLT_numeroJogosVisitadoNoIntervaloTrocado() {
	// return QLT_numeroJogosVisitadoNoIntervaloTrocado;
	// }
	//
	// public void setQLT_numeroJogosVisitadoNoIntervaloTrocado(Integer
	// qLT_numeroJogosVisitadoNoIntervaloTrocado) {
	// QLT_numeroJogosVisitadoNoIntervaloTrocado =
	// qLT_numeroJogosVisitadoNoIntervaloTrocado;
	// }
	//
	// public Integer getQLT_numeroJogosVisitanteNoIntervaloTrocado() {
	// return QLT_numeroJogosVisitanteNoIntervaloTrocado;
	// }
	//
	// public void setQLT_numeroJogosVisitanteNoIntervaloTrocado(Integer
	// qLT_numeroJogosVisitanteNoIntervaloTrocado) {
	// QLT_numeroJogosVisitanteNoIntervaloTrocado =
	// qLT_numeroJogosVisitanteNoIntervaloTrocado;
	// }
	//
	// public Integer getQLT_numeroJogosVisitadoTrocado() {
	// return QLT_numeroJogosVisitadoTrocado;
	// }
	//
	// public void setQLT_numeroJogosVisitadoTrocado(Integer
	// qLT_numeroJogosVisitadoTrocado) {
	// QLT_numeroJogosVisitadoTrocado = qLT_numeroJogosVisitadoTrocado;
	// }
	//
	// public Integer getQLT_numeroJogosVisitanteTrocado() {
	// return QLT_numeroJogosVisitanteTrocado;
	// }
	//
	// public void setQLT_numeroJogosVisitanteTrocado(Integer
	// qLT_numeroJogosVisitanteTrocado) {
	// QLT_numeroJogosVisitanteTrocado = qLT_numeroJogosVisitanteTrocado;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitadoVenue_5jogos() {
	// return QLT_percentagemResultadoVisitadoVenue_5jogos;
	// }
	//
	// public void setQLT_percentagemResultadoVisitadoVenue_5jogos(Double
	// qLT_percentagemResultadoVisitadoVenue_5jogos) {
	// QLT_percentagemResultadoVisitadoVenue_5jogos =
	// qLT_percentagemResultadoVisitadoVenue_5jogos;
	// }
	//
	// public Double getQLT_percentagemResultadoVisitanteVenue_5jogos() {
	// return QLT_percentagemResultadoVisitanteVenue_5jogos;
	// }
	//
	// public void setQLT_percentagemResultadoVisitanteVenue_5jogos(Double
	// qLT_percentagemResultadoVisitanteVenue_5jogos) {
	// QLT_percentagemResultadoVisitanteVenue_5jogos =
	// qLT_percentagemResultadoVisitanteVenue_5jogos;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitadoVenue_5jogos() {
	// return QLT_dificuldadeResultadoVisitadoVenue_5jogos;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitadoVenue_5jogos(Double
	// qLT_dificuldadeResultadoVisitadoVenue_5jogos) {
	// QLT_dificuldadeResultadoVisitadoVenue_5jogos =
	// qLT_dificuldadeResultadoVisitadoVenue_5jogos;
	// }
	//
	// public Double getQLT_dificuldadeResultadoVisitanteVenue_5jogos() {
	// return QLT_dificuldadeResultadoVisitanteVenue_5jogos;
	// }
	//
	// public void setQLT_dificuldadeResultadoVisitanteVenue_5jogos(Double
	// qLT_dificuldadeResultadoVisitanteVenue_5jogos) {
	// QLT_dificuldadeResultadoVisitanteVenue_5jogos =
	// qLT_dificuldadeResultadoVisitanteVenue_5jogos;
	// }
	//
	// public Double
	// getQLT_percentagemResultadoVisitadoNoIntervaloVenue_5jogos() {
	// return QLT_percentagemResultadoVisitadoNoIntervaloVenue_5jogos;
	// }
	//
	// public void setQLT_percentagemResultadoVisitadoNoIntervaloVenue_5jogos(
	// Double qLT_percentagemResultadoVisitadoNoIntervaloVenue_5jogos) {
	// QLT_percentagemResultadoVisitadoNoIntervaloVenue_5jogos =
	// qLT_percentagemResultadoVisitadoNoIntervaloVenue_5jogos;
	// }
	//
	// public Double
	// getQLT_percentagemResultadoVisitanteNoIntervaloVenue_5jogos() {
	// return QLT_percentagemResultadoVisitanteNoIntervaloVenue_5jogos;
	// }
	//
	// public void setQLT_percentagemResultadoVisitanteNoIntervaloVenue_5jogos(
	// Double qLT_percentagemResultadoVisitanteNoIntervaloVenue_5jogos) {
	// QLT_percentagemResultadoVisitanteNoIntervaloVenue_5jogos =
	// qLT_percentagemResultadoVisitanteNoIntervaloVenue_5jogos;
	// }
	//
	// public Integer getQLT_numeroJogosVisitadoVenue_5jogos() {
	// return QLT_numeroJogosVisitadoVenue_5jogos;
	// }
	//
	// public void setQLT_numeroJogosVisitadoVenue_5jogos(Integer
	// qLT_numeroJogosVisitadoVenue_5jogos) {
	// QLT_numeroJogosVisitadoVenue_5jogos =
	// qLT_numeroJogosVisitadoVenue_5jogos;
	// }
	//
	// public Integer getQLT_numeroJogosVisitanteVenue_5jogos() {
	// return QLT_numeroJogosVisitanteVenue_5jogos;
	// }
	//
	// public void setQLT_numeroJogosVisitanteVenue_5jogos(Integer
	// qLT_numeroJogosVisitanteVenue_5jogos) {
	// QLT_numeroJogosVisitanteVenue_5jogos =
	// qLT_numeroJogosVisitanteVenue_5jogos;
	// }

	// General variables

	// Overall
	Date data;
	String nomeVisitado, nomeVisitante;
	Long idVisitado, idVisitante;
	Double qualidadeVisitado, qualidadeVisitante;
	Integer classificacaoVisitado, classificacaoVisitante;

	// Venue
	Double qualidadeVisitadoVenue, qualidadeVisitanteVenue;

	// Switched Venue
	Double qualidadeVisitadoSwitchedVenue, qualidadeVisitanteSwitchedVenue;

	// Cycle variables

	// Overall
	Integer cicloNaoResultado_numeroJogosVisitado, cicloNaoResultado_numeroJogosVisitante;
	Double cicloNaoResultado_dificuldadeVisitado, cicloNaoResultado_dificuldadeVisitante;
	Integer cicloNaoResultado_historicosVisitado, cicloNaoResultado_historicosVisitante;

	Integer cicloResultado_numeroJogosVisitado, cicloResultado_numeroJogosVisitante;
	Double cicloResultado_dificuldadeVisitado, cicloResultado_dificuldadeVisitante;
	Integer cicloResultado_historicosVisitado, cicloResultado_historicosVisitante;

	// Venue
	Integer cicloNaoResultado_numeroJogosVisitadoVenue, cicloNaoResultado_numeroJogosVisitanteVenue;
	Double cicloNaoResultado_dificuldadeVisitadoVenue, cicloNaoResultado_dificuldadeVisitanteVenue;
	Integer cicloNaoResultado_historicosVisitadoVenue, cicloNaoResultado_historicosVisitanteVenue;

	Integer cicloResultado_numeroJogosVisitadoVenue, cicloResultado_numeroJogosVisitanteVenue;
	Double cicloResultado_dificuldadeVisitadoVenue, cicloResultado_dificuldadeVisitanteVenue;
	Integer cicloResultado_historicosVisitadoVenue, cicloResultado_historicosVisitanteVenue;

	// Switched Venue
	Integer cicloNaoResultado_numeroJogosVisitadoSwitchedVenue, cicloNaoResultado_numeroJogosVisitanteSwitchedVenue;
	Double cicloNaoResultado_dificuldadeVisitadoSwitchedVenue, cicloNaoResultado_dificuldadeVisitanteSwitchedVenue;
	Integer cicloNaoResultado_historicosVisitadoSwitchedVenue, cicloNaoResultado_historicosVisitanteSwitchedVenue;

	Integer cicloResultado_numeroJogosVisitadoSwitchedVenue, cicloResultado_numeroJogosVisitanteSwitchedVenue;
	Double cicloResultado_dificuldadeVisitadoSwitchedVenue, cicloResultado_dificuldadeVisitanteSwitchedVenue;
	Integer cicloResultado_historicosVisitadoSwitchedVenue, cicloResultado_historicosVisitanteSwitchedVenue;

	// FR variables

	// Overall
	Double FR_dificuldadeVisitado, FR_dificuldadeVisitante;
	Integer FR_historicosVisitado, FR_historicosVisitante;
	Double FR_ratingTemporalResultadoVisitado, FR_ratingTemporalResultadoVisitante;
	Integer FR_numeroResultadosVisitado, FR_numeroResultadosVisitante;
	Double FR_percentagemResultadoVisitado, FR_percentagemResultadoVisitante;
	Double FR_percentagemResultadoVisitadoCasa, FR_percentagemResultadoVisitanteFora;
	Double FR_percentagemResultadoNoIntervaloVisitado, FR_percentagemResultadoNoIntervaloVisitante;
	Double FR_percentagemResultadoNoIntervaloVisitadoCasa, FR_percentagemResultadoNoIntervaloVisitanteFora;
	Integer FR_numeroJogosVisitadoCasa, FR_numeroJogosVisitanteFora;
	Integer FR_golosMarcadosVisitado, FR_golosSofridosVisitado, FR_diferencaGolosVisitado;
	Integer FR_golosMarcadosVisitante, FR_golosSofridosVisitante, FR_diferencaGolosVisitante;
	Double FR_mediaGolosMarcadosVisitado, FR_mediaGolosSofridosVisitado;
	Double FR_mediaGolosMarcadosVisitante, FR_mediaGolosSofridosVisitante;

	// Venue
	Double FR_dificuldadeVisitadoVenue, FR_dificuldadeVisitanteVenue;
	Integer FR_historicosVisitadoVenue, FR_historicosVisitanteVenue;
	Double FR_ratingTemporalResultadoVisitadoVenue, FR_ratingTemporalResultadoVisitanteVenue;
	Integer FR_numeroResultadosVisitadoVenue, FR_numeroResultadosVisitanteVenue;
	Double FR_percentagemResultadoVisitadoVenue, FR_percentagemResultadoVisitanteVenue;
	Double FR_percentagemResultadoNoIntervaloVisitadoVenue, FR_percentagemResultadoNoIntervaloVisitanteVenue;
	Integer FR_golosMarcadosVisitadoVenue, FR_golosSofridosVisitadoVenue, FR_diferencaGolosVisitadoVenue;
	Integer FR_golosMarcadosVisitanteVenue, FR_golosSofridosVisitanteVenue, FR_diferencaGolosVisitanteVenue;
	Double FR_mediaGolosMarcadosVisitadoVenue, FR_mediaGolosSofridosVisitadoVenue;
	Double FR_mediaGolosMarcadosVisitanteVenue, FR_mediaGolosSofridosVisitanteVenue;

	// Switched Venue
	Double FR_dificuldadeVisitadoSwitchedVenue, FR_dificuldadeVisitanteSwitchedVenue;
	Integer FR_historicosVisitadoSwitchedVenue, FR_historicosVisitanteSwitchedVenue;
	Double FR_ratingTemporalResultadoVisitadoSwitchedVenue, FR_ratingTemporalResultadoVisitanteSwitchedVenue;
	Integer FR_numeroResultadosVisitadoSwitchedVenue, FR_numeroResultadosVisitanteSwitchedVenue;
	Double FR_percentagemResultadoVisitadoSwitchedVenue, FR_percentagemResultadoVisitanteSwitchedVenue;
	Double FR_percentagemResultadoNoIntervaloVisitadoSwitchedVenue,
			FR_percentagemResultadoNoIntervaloVisitanteSwitchedVenue;
	Integer FR_golosMarcadosVisitadoSwitchedVenue, FR_golosSofridosVisitadoSwitchedVenue,
			FR_diferencaGolosVisitadoSwitchedVenue;
	Integer FR_golosMarcadosVisitanteSwitchedVenue, FR_golosSofridosVisitanteSwitchedVenue,
			FR_diferencaGolosVisitanteSwitchedVenue;
	Double FR_mediaGolosMarcadosVisitadoSwitchedVenue, FR_mediaGolosSofridosVisitadoSwitchedVenue;
	Double FR_mediaGolosMarcadosVisitanteSwitchedVenue, FR_mediaGolosSofridosVisitanteSwitchedVenue;

	// QLT variables

	// Overall
	Integer QLT_numeroJogosVisitado, QLT_numeroJogosVisitante;
	Double QLT_percentagemResultadoVisitado, QLT_percentagemResultadoVisitante;
	Double QLT_dificuldadeResultadoVisitado, QLT_dificuldadeResultadoVisitante;
	Double QLT_percentagemResultadoNoIntervaloVisitado, QLT_percentagemResultadoNoIntervaloVisitante;
	Integer QLT_numeroJogosNoIntervaloVisitado, QLT_numeroJogosNoIntervaloVisitante;

	// Venue
	Integer QLT_numeroJogosVisitadoVenue, QLT_numeroJogosVisitanteVenue;
	Double QLT_percentagemResultadoVisitadoVenue, QLT_percentagemResultadoVisitanteVenue;
	Double QLT_dificuldadeResultadoVisitadoVenue, QLT_dificuldadeResultadoVisitanteVenue;
	Double QLT_percentagemResultadoNoIntervaloVisitadoVenue, QLT_percentagemResultadoNoIntervaloVisitanteVenue;
	Integer QLT_numeroJogosNoIntervaloVisitadoVenue, QLT_numeroJogosNoIntervaloVisitanteVenue;

	// Switched Venue
	Integer QLT_numeroJogosVisitadoSwitchedVenue, QLT_numeroJogosVisitanteSwitchedVenue;
	Double QLT_percentagemResultadoVisitadoSwitchedVenue, QLT_percentagemResultadoVisitanteSwitchedVenue;
	Double QLT_dificuldadeResultadoVisitadoSwitchedVenue, QLT_dificuldadeResultadoVisitanteSwitchedVenue;
	Double QLT_percentagemResultadoNoIntervaloVisitadoSwitchedVenue,
			QLT_percentagemResultadoNoIntervaloVisitanteSwitchedVenue;
	Integer QLT_numeroJogosNoIntervaloVisitadoSwitchedVenue, QLT_numeroJogosNoIntervaloVisitanteSwitchedVenue;

	// H2H variables

	// Overall
	Double h2h_ratingTemporalResultado;
	Integer h2h_numeroJogos;
	Integer h2h_numeroResultados;
	Double h2h_percentagemResultados;

	// Venue
	Double h2h_ratingTemporalResultadoVenue;
	Integer h2h_numeroJogosVenue;
	Integer h2h_numeroResultadosVenue;
	Double h2h_percentagemResultadosVenue;

	// Switched Venue
	Double h2h_ratingTemporalResultadoSwitchedVenue;
	Integer h2h_numeroJogosSwitchedVenue;
	Integer h2h_numeroResultadosSwitchedVenue;
	Double h2h_percentagemResultadosSwitchedVenue;

	// Goal variables

	// Overall
	Integer golosMarcadosVisitado, golosSofridosVisitado, diferencaGolosVisitado;
	Integer golosMarcadosVisitante, golosSofridosVisitante, diferencaGolosVisitante;
	Double mediaGolosMarcadosVisitado, mediaGolosSofridosVisitado;
	Double mediaGolosMarcadosVisitante, mediaGolosSofridosVisitante;

	// Venue
	Integer golosMarcadosVisitadoVenue, golosSofridosVisitadoVenue, diferencaGolosVisitadoVenue;
	Integer golosMarcadosVisitanteVenue, golosSofridosVisitanteVenue, diferencaGolosVisitanteVenue;
	Double mediaGolosMarcadosVisitadoVenue, mediaGolosSofridosVisitadoVenue;
	Double mediaGolosMarcadosVisitanteVenue, mediaGolosSofridosVisitanteVenue;

	// Switched Venue
	Integer golosMarcadosVisitadoSwitchedVenue, golosSofridosVisitadoSwitchedVenue, diferencaGolosVisitadoSwitchedVenue;
	Integer golosMarcadosVisitanteSwitchedVenue, golosSofridosVisitanteSwitchedVenue,
			diferencaGolosVisitanteSwitchedVenue;
	Double mediaGolosMarcadosVisitadoSwitchedVenue, mediaGolosSofridosVisitadoSwitchedVenue;
	Double mediaGolosMarcadosVisitanteSwitchedVenue, mediaGolosSofridosVisitanteSwitchedVenue;

	///////////////////

	public ExcelRow() {
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNomeVisitado() {
		return nomeVisitado;
	}

	public void setNomeVisitado(String nomeVisitado) {
		this.nomeVisitado = nomeVisitado;
	}

	public String getNomeVisitante() {
		return nomeVisitante;
	}

	public void setNomeVisitante(String nomeVisitante) {
		this.nomeVisitante = nomeVisitante;
	}

	public Long getIdVisitado() {
		return idVisitado;
	}

	public void setIdVisitado(Long idVisitado) {
		this.idVisitado = idVisitado;
	}

	public Long getIdVisitante() {
		return idVisitante;
	}

	public void setIdVisitante(Long idVisitante) {
		this.idVisitante = idVisitante;
	}

	public Double getQualidadeVisitado() {
		return qualidadeVisitado;
	}

	public void setQualidadeVisitado(Double qualidadeVisitado) {
		this.qualidadeVisitado = qualidadeVisitado;
	}

	public Double getQualidadeVisitante() {
		return qualidadeVisitante;
	}

	public void setQualidadeVisitante(Double qualidadeVisitante) {
		this.qualidadeVisitante = qualidadeVisitante;
	}

	public Integer getClassificacaoVisitado() {
		return classificacaoVisitado;
	}

	public void setClassificacaoVisitado(Integer classificacaoVisitado) {
		this.classificacaoVisitado = classificacaoVisitado;
	}

	public Integer getClassificacaoVisitante() {
		return classificacaoVisitante;
	}

	public void setClassificacaoVisitante(Integer classificacaoVisitante) {
		this.classificacaoVisitante = classificacaoVisitante;
	}

	public Double getQualidadeVisitadoVenue() {
		return qualidadeVisitadoVenue;
	}

	public void setQualidadeVisitadoVenue(Double qualidadeVisitadoVenue) {
		this.qualidadeVisitadoVenue = qualidadeVisitadoVenue;
	}

	public Double getQualidadeVisitanteVenue() {
		return qualidadeVisitanteVenue;
	}

	public void setQualidadeVisitanteVenue(Double qualidadeVisitanteVenue) {
		this.qualidadeVisitanteVenue = qualidadeVisitanteVenue;
	}

	public Double getQualidadeVisitadoSwitchedVenue() {
		return qualidadeVisitadoSwitchedVenue;
	}

	public void setQualidadeVisitadoSwitchedVenue(Double qualidadeVisitadoSwitchedVenue) {
		this.qualidadeVisitadoSwitchedVenue = qualidadeVisitadoSwitchedVenue;
	}

	public Double getQualidadeVisitanteSwitchedVenue() {
		return qualidadeVisitanteSwitchedVenue;
	}

	public void setQualidadeVisitanteSwitchedVenue(Double qualidadeVisitanteSwitchedVenue) {
		this.qualidadeVisitanteSwitchedVenue = qualidadeVisitanteSwitchedVenue;
	}

	public Integer getCicloNaoResultado_numeroJogosVisitado() {
		return cicloNaoResultado_numeroJogosVisitado;
	}

	public void setCicloNaoResultado_numeroJogosVisitado(Integer cicloNaoResultado_numeroJogosVisitado) {
		this.cicloNaoResultado_numeroJogosVisitado = cicloNaoResultado_numeroJogosVisitado;
	}

	public Integer getCicloNaoResultado_numeroJogosVisitante() {
		return cicloNaoResultado_numeroJogosVisitante;
	}

	public void setCicloNaoResultado_numeroJogosVisitante(Integer cicloNaoResultado_numeroJogosVisitante) {
		this.cicloNaoResultado_numeroJogosVisitante = cicloNaoResultado_numeroJogosVisitante;
	}

	public Double getCicloNaoResultado_dificuldadeVisitado() {
		return cicloNaoResultado_dificuldadeVisitado;
	}

	public void setCicloNaoResultado_dificuldadeVisitado(Double cicloNaoResultado_dificuldadeVisitado) {
		this.cicloNaoResultado_dificuldadeVisitado = cicloNaoResultado_dificuldadeVisitado;
	}

	public Double getCicloNaoResultado_dificuldadeVisitante() {
		return cicloNaoResultado_dificuldadeVisitante;
	}

	public void setCicloNaoResultado_dificuldadeVisitante(Double cicloNaoResultado_dificuldadeVisitante) {
		this.cicloNaoResultado_dificuldadeVisitante = cicloNaoResultado_dificuldadeVisitante;
	}

	public Integer getCicloNaoResultado_historicosVisitado() {
		return cicloNaoResultado_historicosVisitado;
	}

	public void setCicloNaoResultado_historicosVisitado(Integer cicloNaoResultado_historicosVisitado) {
		this.cicloNaoResultado_historicosVisitado = cicloNaoResultado_historicosVisitado;
	}

	public Integer getCicloNaoResultado_historicosVisitante() {
		return cicloNaoResultado_historicosVisitante;
	}

	public void setCicloNaoResultado_historicosVisitante(Integer cicloNaoResultado_historicosVisitante) {
		this.cicloNaoResultado_historicosVisitante = cicloNaoResultado_historicosVisitante;
	}

	public Integer getCicloResultado_numeroJogosVisitado() {
		return cicloResultado_numeroJogosVisitado;
	}

	public void setCicloResultado_numeroJogosVisitado(Integer cicloResultado_numeroJogosVisitado) {
		this.cicloResultado_numeroJogosVisitado = cicloResultado_numeroJogosVisitado;
	}

	public Integer getCicloResultado_numeroJogosVisitante() {
		return cicloResultado_numeroJogosVisitante;
	}

	public void setCicloResultado_numeroJogosVisitante(Integer cicloResultado_numeroJogosVisitante) {
		this.cicloResultado_numeroJogosVisitante = cicloResultado_numeroJogosVisitante;
	}

	public Double getCicloResultado_dificuldadeVisitado() {
		return cicloResultado_dificuldadeVisitado;
	}

	public void setCicloResultado_dificuldadeVisitado(Double cicloResultado_dificuldadeVisitado) {
		this.cicloResultado_dificuldadeVisitado = cicloResultado_dificuldadeVisitado;
	}

	public Double getCicloResultado_dificuldadeVisitante() {
		return cicloResultado_dificuldadeVisitante;
	}

	public void setCicloResultado_dificuldadeVisitante(Double cicloResultado_dificuldadeVisitante) {
		this.cicloResultado_dificuldadeVisitante = cicloResultado_dificuldadeVisitante;
	}

	public Integer getCicloResultado_historicosVisitado() {
		return cicloResultado_historicosVisitado;
	}

	public void setCicloResultado_historicosVisitado(Integer cicloResultado_historicosVisitado) {
		this.cicloResultado_historicosVisitado = cicloResultado_historicosVisitado;
	}

	public Integer getCicloResultado_historicosVisitante() {
		return cicloResultado_historicosVisitante;
	}

	public void setCicloResultado_historicosVisitante(Integer cicloResultado_historicosVisitante) {
		this.cicloResultado_historicosVisitante = cicloResultado_historicosVisitante;
	}

	public Integer getCicloNaoResultado_numeroJogosVisitadoVenue() {
		return cicloNaoResultado_numeroJogosVisitadoVenue;
	}

	public void setCicloNaoResultado_numeroJogosVisitadoVenue(Integer cicloNaoResultado_numeroJogosVisitadoVenue) {
		this.cicloNaoResultado_numeroJogosVisitadoVenue = cicloNaoResultado_numeroJogosVisitadoVenue;
	}

	public Integer getCicloNaoResultado_numeroJogosVisitanteVenue() {
		return cicloNaoResultado_numeroJogosVisitanteVenue;
	}

	public void setCicloNaoResultado_numeroJogosVisitanteVenue(Integer cicloNaoResultado_numeroJogosVisitanteVenue) {
		this.cicloNaoResultado_numeroJogosVisitanteVenue = cicloNaoResultado_numeroJogosVisitanteVenue;
	}

	public Double getCicloNaoResultado_dificuldadeVisitadoVenue() {
		return cicloNaoResultado_dificuldadeVisitadoVenue;
	}

	public void setCicloNaoResultado_dificuldadeVisitadoVenue(Double cicloNaoResultado_dificuldadeVisitadoVenue) {
		this.cicloNaoResultado_dificuldadeVisitadoVenue = cicloNaoResultado_dificuldadeVisitadoVenue;
	}

	public Double getCicloNaoResultado_dificuldadeVisitanteVenue() {
		return cicloNaoResultado_dificuldadeVisitanteVenue;
	}

	public void setCicloNaoResultado_dificuldadeVisitanteVenue(Double cicloNaoResultado_dificuldadeVisitanteVenue) {
		this.cicloNaoResultado_dificuldadeVisitanteVenue = cicloNaoResultado_dificuldadeVisitanteVenue;
	}

	public Integer getCicloNaoResultado_historicosVisitadoVenue() {
		return cicloNaoResultado_historicosVisitadoVenue;
	}

	public void setCicloNaoResultado_historicosVisitadoVenue(Integer cicloNaoResultado_historicosVisitadoVenue) {
		this.cicloNaoResultado_historicosVisitadoVenue = cicloNaoResultado_historicosVisitadoVenue;
	}

	public Integer getCicloNaoResultado_historicosVisitanteVenue() {
		return cicloNaoResultado_historicosVisitanteVenue;
	}

	public void setCicloNaoResultado_historicosVisitanteVenue(Integer cicloNaoResultado_historicosVisitanteVenue) {
		this.cicloNaoResultado_historicosVisitanteVenue = cicloNaoResultado_historicosVisitanteVenue;
	}

	public Integer getCicloResultado_numeroJogosVisitadoVenue() {
		return cicloResultado_numeroJogosVisitadoVenue;
	}

	public void setCicloResultado_numeroJogosVisitadoVenue(Integer cicloResultado_numeroJogosVisitadoVenue) {
		this.cicloResultado_numeroJogosVisitadoVenue = cicloResultado_numeroJogosVisitadoVenue;
	}

	public Integer getCicloResultado_numeroJogosVisitanteVenue() {
		return cicloResultado_numeroJogosVisitanteVenue;
	}

	public void setCicloResultado_numeroJogosVisitanteVenue(Integer cicloResultado_numeroJogosVisitanteVenue) {
		this.cicloResultado_numeroJogosVisitanteVenue = cicloResultado_numeroJogosVisitanteVenue;
	}

	public Double getCicloResultado_dificuldadeVisitadoVenue() {
		return cicloResultado_dificuldadeVisitadoVenue;
	}

	public void setCicloResultado_dificuldadeVisitadoVenue(Double cicloResultado_dificuldadeVisitadoVenue) {
		this.cicloResultado_dificuldadeVisitadoVenue = cicloResultado_dificuldadeVisitadoVenue;
	}

	public Double getCicloResultado_dificuldadeVisitanteVenue() {
		return cicloResultado_dificuldadeVisitanteVenue;
	}

	public void setCicloResultado_dificuldadeVisitanteVenue(Double cicloResultado_dificuldadeVisitanteVenue) {
		this.cicloResultado_dificuldadeVisitanteVenue = cicloResultado_dificuldadeVisitanteVenue;
	}

	public Integer getCicloResultado_historicosVisitadoVenue() {
		return cicloResultado_historicosVisitadoVenue;
	}

	public void setCicloResultado_historicosVisitadoVenue(Integer cicloResultado_historicosVisitadoVenue) {
		this.cicloResultado_historicosVisitadoVenue = cicloResultado_historicosVisitadoVenue;
	}

	public Integer getCicloResultado_historicosVisitanteVenue() {
		return cicloResultado_historicosVisitanteVenue;
	}

	public void setCicloResultado_historicosVisitanteVenue(Integer cicloResultado_historicosVisitanteVenue) {
		this.cicloResultado_historicosVisitanteVenue = cicloResultado_historicosVisitanteVenue;
	}

	public Integer getCicloNaoResultado_numeroJogosVisitadoSwitchedVenue() {
		return cicloNaoResultado_numeroJogosVisitadoSwitchedVenue;
	}

	public void setCicloNaoResultado_numeroJogosVisitadoSwitchedVenue(
			Integer cicloNaoResultado_numeroJogosVisitadoSwitchedVenue) {
		this.cicloNaoResultado_numeroJogosVisitadoSwitchedVenue = cicloNaoResultado_numeroJogosVisitadoSwitchedVenue;
	}

	public Integer getCicloNaoResultado_numeroJogosVisitanteSwitchedVenue() {
		return cicloNaoResultado_numeroJogosVisitanteSwitchedVenue;
	}

	public void setCicloNaoResultado_numeroJogosVisitanteSwitchedVenue(
			Integer cicloNaoResultado_numeroJogosVisitanteSwitchedVenue) {
		this.cicloNaoResultado_numeroJogosVisitanteSwitchedVenue = cicloNaoResultado_numeroJogosVisitanteSwitchedVenue;
	}

	public Double getCicloNaoResultado_dificuldadeVisitadoSwitchedVenue() {
		return cicloNaoResultado_dificuldadeVisitadoSwitchedVenue;
	}

	public void setCicloNaoResultado_dificuldadeVisitadoSwitchedVenue(
			Double cicloNaoResultado_dificuldadeVisitadoSwitchedVenue) {
		this.cicloNaoResultado_dificuldadeVisitadoSwitchedVenue = cicloNaoResultado_dificuldadeVisitadoSwitchedVenue;
	}

	public Double getCicloNaoResultado_dificuldadeVisitanteSwitchedVenue() {
		return cicloNaoResultado_dificuldadeVisitanteSwitchedVenue;
	}

	public void setCicloNaoResultado_dificuldadeVisitanteSwitchedVenue(
			Double cicloNaoResultado_dificuldadeVisitanteSwitchedVenue) {
		this.cicloNaoResultado_dificuldadeVisitanteSwitchedVenue = cicloNaoResultado_dificuldadeVisitanteSwitchedVenue;
	}

	public Integer getCicloNaoResultado_historicosVisitadoSwitchedVenue() {
		return cicloNaoResultado_historicosVisitadoSwitchedVenue;
	}

	public void setCicloNaoResultado_historicosVisitadoSwitchedVenue(
			Integer cicloNaoResultado_historicosVisitadoSwitchedVenue) {
		this.cicloNaoResultado_historicosVisitadoSwitchedVenue = cicloNaoResultado_historicosVisitadoSwitchedVenue;
	}

	public Integer getCicloNaoResultado_historicosVisitanteSwitchedVenue() {
		return cicloNaoResultado_historicosVisitanteSwitchedVenue;
	}

	public void setCicloNaoResultado_historicosVisitanteSwitchedVenue(
			Integer cicloNaoResultado_historicosVisitanteSwitchedVenue) {
		this.cicloNaoResultado_historicosVisitanteSwitchedVenue = cicloNaoResultado_historicosVisitanteSwitchedVenue;
	}

	public Integer getCicloResultado_numeroJogosVisitadoSwitchedVenue() {
		return cicloResultado_numeroJogosVisitadoSwitchedVenue;
	}

	public void setCicloResultado_numeroJogosVisitadoSwitchedVenue(
			Integer cicloResultado_numeroJogosVisitadoSwitchedVenue) {
		this.cicloResultado_numeroJogosVisitadoSwitchedVenue = cicloResultado_numeroJogosVisitadoSwitchedVenue;
	}

	public Integer getCicloResultado_numeroJogosVisitanteSwitchedVenue() {
		return cicloResultado_numeroJogosVisitanteSwitchedVenue;
	}

	public void setCicloResultado_numeroJogosVisitanteSwitchedVenue(
			Integer cicloResultado_numeroJogosVisitanteSwitchedVenue) {
		this.cicloResultado_numeroJogosVisitanteSwitchedVenue = cicloResultado_numeroJogosVisitanteSwitchedVenue;
	}

	public Double getCicloResultado_dificuldadeVisitadoSwitchedVenue() {
		return cicloResultado_dificuldadeVisitadoSwitchedVenue;
	}

	public void setCicloResultado_dificuldadeVisitadoSwitchedVenue(
			Double cicloResultado_dificuldadeVisitadoSwitchedVenue) {
		this.cicloResultado_dificuldadeVisitadoSwitchedVenue = cicloResultado_dificuldadeVisitadoSwitchedVenue;
	}

	public Double getCicloResultado_dificuldadeVisitanteSwitchedVenue() {
		return cicloResultado_dificuldadeVisitanteSwitchedVenue;
	}

	public void setCicloResultado_dificuldadeVisitanteSwitchedVenue(
			Double cicloResultado_dificuldadeVisitanteSwitchedVenue) {
		this.cicloResultado_dificuldadeVisitanteSwitchedVenue = cicloResultado_dificuldadeVisitanteSwitchedVenue;
	}

	public Integer getCicloResultado_historicosVisitadoSwitchedVenue() {
		return cicloResultado_historicosVisitadoSwitchedVenue;
	}

	public void setCicloResultado_historicosVisitadoSwitchedVenue(
			Integer cicloResultado_historicosVisitadoSwitchedVenue) {
		this.cicloResultado_historicosVisitadoSwitchedVenue = cicloResultado_historicosVisitadoSwitchedVenue;
	}

	public Integer getCicloResultado_historicosVisitanteSwitchedVenue() {
		return cicloResultado_historicosVisitanteSwitchedVenue;
	}

	public void setCicloResultado_historicosVisitanteSwitchedVenue(
			Integer cicloResultado_historicosVisitanteSwitchedVenue) {
		this.cicloResultado_historicosVisitanteSwitchedVenue = cicloResultado_historicosVisitanteSwitchedVenue;
	}

	public Double getFR_dificuldadeVisitado() {
		return FR_dificuldadeVisitado;
	}

	public void setFR_dificuldadeVisitado(Double fR_dificuldadeVisitado) {
		FR_dificuldadeVisitado = fR_dificuldadeVisitado;
	}

	public Double getFR_dificuldadeVisitante() {
		return FR_dificuldadeVisitante;
	}

	public void setFR_dificuldadeVisitante(Double fR_dificuldadeVisitante) {
		FR_dificuldadeVisitante = fR_dificuldadeVisitante;
	}

	public Integer getFR_historicosVisitado() {
		return FR_historicosVisitado;
	}

	public void setFR_historicosVisitado(Integer fR_historicosVisitado) {
		FR_historicosVisitado = fR_historicosVisitado;
	}

	public Integer getFR_historicosVisitante() {
		return FR_historicosVisitante;
	}

	public void setFR_historicosVisitante(Integer fR_historicosVisitante) {
		FR_historicosVisitante = fR_historicosVisitante;
	}

	public Double getFR_ratingTemporalResultadoVisitado() {
		return FR_ratingTemporalResultadoVisitado;
	}

	public void setFR_ratingTemporalResultadoVisitado(Double fR_ratingTemporalResultadoVisitado) {
		FR_ratingTemporalResultadoVisitado = fR_ratingTemporalResultadoVisitado;
	}

	public Double getFR_ratingTemporalResultadoVisitante() {
		return FR_ratingTemporalResultadoVisitante;
	}

	public void setFR_ratingTemporalResultadoVisitante(Double fR_ratingTemporalResultadoVisitante) {
		FR_ratingTemporalResultadoVisitante = fR_ratingTemporalResultadoVisitante;
	}

	public Integer getFR_numeroResultadosVisitado() {
		return FR_numeroResultadosVisitado;
	}

	public void setFR_numeroResultadosVisitado(Integer fR_numeroResultadosVisitado) {
		FR_numeroResultadosVisitado = fR_numeroResultadosVisitado;
	}

	public Integer getFR_numeroResultadosVisitante() {
		return FR_numeroResultadosVisitante;
	}

	public void setFR_numeroResultadosVisitante(Integer fR_numeroResultadosVisitante) {
		FR_numeroResultadosVisitante = fR_numeroResultadosVisitante;
	}

	public Double getFR_percentagemResultadoVisitado() {
		return FR_percentagemResultadoVisitado;
	}

	public void setFR_percentagemResultadoVisitado(Double fR_percentagemResultadoVisitado) {
		FR_percentagemResultadoVisitado = fR_percentagemResultadoVisitado;
	}

	public Double getFR_percentagemResultadoVisitante() {
		return FR_percentagemResultadoVisitante;
	}

	public void setFR_percentagemResultadoVisitante(Double fR_percentagemResultadoVisitante) {
		FR_percentagemResultadoVisitante = fR_percentagemResultadoVisitante;
	}

	public Double getFR_percentagemResultadoVisitadoCasa() {
		return FR_percentagemResultadoVisitadoCasa;
	}

	public void setFR_percentagemResultadoVisitadoCasa(Double fR_percentagemResultadoVisitadoCasa) {
		FR_percentagemResultadoVisitadoCasa = fR_percentagemResultadoVisitadoCasa;
	}

	public Double getFR_percentagemResultadoVisitanteFora() {
		return FR_percentagemResultadoVisitanteFora;
	}

	public void setFR_percentagemResultadoVisitanteFora(Double fR_percentagemResultadoVisitanteFora) {
		FR_percentagemResultadoVisitanteFora = fR_percentagemResultadoVisitanteFora;
	}

	public Double getFR_percentagemResultadoNoIntervaloVisitado() {
		return FR_percentagemResultadoNoIntervaloVisitado;
	}

	public void setFR_percentagemResultadoNoIntervaloVisitado(Double fR_percentagemResultadoNoIntervaloVisitado) {
		FR_percentagemResultadoNoIntervaloVisitado = fR_percentagemResultadoNoIntervaloVisitado;
	}

	public Double getFR_percentagemResultadoNoIntervaloVisitante() {
		return FR_percentagemResultadoNoIntervaloVisitante;
	}

	public void setFR_percentagemResultadoNoIntervaloVisitante(Double fR_percentagemResultadoNoIntervaloVisitante) {
		FR_percentagemResultadoNoIntervaloVisitante = fR_percentagemResultadoNoIntervaloVisitante;
	}

	public Double getFR_percentagemResultadoNoIntervaloVisitadoCasa() {
		return FR_percentagemResultadoNoIntervaloVisitadoCasa;
	}

	public void setFR_percentagemResultadoNoIntervaloVisitadoCasa(
			Double fR_percentagemResultadoNoIntervaloVisitadoCasa) {
		FR_percentagemResultadoNoIntervaloVisitadoCasa = fR_percentagemResultadoNoIntervaloVisitadoCasa;
	}

	public Double getFR_percentagemResultadoNoIntervaloVisitanteFora() {
		return FR_percentagemResultadoNoIntervaloVisitanteFora;
	}

	public void setFR_percentagemResultadoNoIntervaloVisitanteFora(
			Double fR_percentagemResultadoNoIntervaloVisitanteFora) {
		FR_percentagemResultadoNoIntervaloVisitanteFora = fR_percentagemResultadoNoIntervaloVisitanteFora;
	}

	public Integer getFR_numeroJogosVisitadoCasa() {
		return FR_numeroJogosVisitadoCasa;
	}

	public void setFR_numeroJogosVisitadoCasa(Integer fR_numeroJogosVisitadoCasa) {
		FR_numeroJogosVisitadoCasa = fR_numeroJogosVisitadoCasa;
	}

	public Integer getFR_numeroJogosVisitanteFora() {
		return FR_numeroJogosVisitanteFora;
	}

	public void setFR_numeroJogosVisitanteFora(Integer fR_numeroJogosVisitanteFora) {
		FR_numeroJogosVisitanteFora = fR_numeroJogosVisitanteFora;
	}

	public Integer getFR_golosMarcadosVisitado() {
		return FR_golosMarcadosVisitado;
	}

	public void setFR_golosMarcadosVisitado(Integer fR_golosMarcadosVisitado) {
		FR_golosMarcadosVisitado = fR_golosMarcadosVisitado;
	}

	public Integer getFR_golosSofridosVisitado() {
		return FR_golosSofridosVisitado;
	}

	public void setFR_golosSofridosVisitado(Integer fR_golosSofridosVisitado) {
		FR_golosSofridosVisitado = fR_golosSofridosVisitado;
	}

	public Integer getFR_diferencaGolosVisitado() {
		return FR_diferencaGolosVisitado;
	}

	public void setFR_diferencaGolosVisitado(Integer fR_diferencaGolosVisitado) {
		FR_diferencaGolosVisitado = fR_diferencaGolosVisitado;
	}

	public Integer getFR_golosMarcadosVisitante() {
		return FR_golosMarcadosVisitante;
	}

	public void setFR_golosMarcadosVisitante(Integer fR_golosMarcadosVisitante) {
		FR_golosMarcadosVisitante = fR_golosMarcadosVisitante;
	}

	public Integer getFR_golosSofridosVisitante() {
		return FR_golosSofridosVisitante;
	}

	public void setFR_golosSofridosVisitante(Integer fR_golosSofridosVisitante) {
		FR_golosSofridosVisitante = fR_golosSofridosVisitante;
	}

	public Integer getFR_diferencaGolosVisitante() {
		return FR_diferencaGolosVisitante;
	}

	public void setFR_diferencaGolosVisitante(Integer fR_diferencaGolosVisitante) {
		FR_diferencaGolosVisitante = fR_diferencaGolosVisitante;
	}

	public Double getFR_mediaGolosMarcadosVisitado() {
		return FR_mediaGolosMarcadosVisitado;
	}

	public void setFR_mediaGolosMarcadosVisitado(Double fR_mediaGolosMarcadosVisitado) {
		FR_mediaGolosMarcadosVisitado = fR_mediaGolosMarcadosVisitado;
	}

	public Double getFR_mediaGolosSofridosVisitado() {
		return FR_mediaGolosSofridosVisitado;
	}

	public void setFR_mediaGolosSofridosVisitado(Double fR_mediaGolosSofridosVisitado) {
		FR_mediaGolosSofridosVisitado = fR_mediaGolosSofridosVisitado;
	}

	public Double getFR_mediaGolosMarcadosVisitante() {
		return FR_mediaGolosMarcadosVisitante;
	}

	public void setFR_mediaGolosMarcadosVisitante(Double fR_mediaGolosMarcadosVisitante) {
		FR_mediaGolosMarcadosVisitante = fR_mediaGolosMarcadosVisitante;
	}

	public Double getFR_mediaGolosSofridosVisitante() {
		return FR_mediaGolosSofridosVisitante;
	}

	public void setFR_mediaGolosSofridosVisitante(Double fR_mediaGolosSofridosVisitante) {
		FR_mediaGolosSofridosVisitante = fR_mediaGolosSofridosVisitante;
	}

	public Double getFR_dificuldadeVisitadoVenue() {
		return FR_dificuldadeVisitadoVenue;
	}

	public void setFR_dificuldadeVisitadoVenue(Double fR_dificuldadeVisitadoVenue) {
		FR_dificuldadeVisitadoVenue = fR_dificuldadeVisitadoVenue;
	}

	public Double getFR_dificuldadeVisitanteVenue() {
		return FR_dificuldadeVisitanteVenue;
	}

	public void setFR_dificuldadeVisitanteVenue(Double fR_dificuldadeVisitanteVenue) {
		FR_dificuldadeVisitanteVenue = fR_dificuldadeVisitanteVenue;
	}

	public Integer getFR_historicosVisitadoVenue() {
		return FR_historicosVisitadoVenue;
	}

	public void setFR_historicosVisitadoVenue(Integer fR_historicosVisitadoVenue) {
		FR_historicosVisitadoVenue = fR_historicosVisitadoVenue;
	}

	public Integer getFR_historicosVisitanteVenue() {
		return FR_historicosVisitanteVenue;
	}

	public void setFR_historicosVisitanteVenue(Integer fR_historicosVisitanteVenue) {
		FR_historicosVisitanteVenue = fR_historicosVisitanteVenue;
	}

	public Double getFR_ratingTemporalResultadoVisitadoVenue() {
		return FR_ratingTemporalResultadoVisitadoVenue;
	}

	public void setFR_ratingTemporalResultadoVisitadoVenue(Double fR_ratingTemporalResultadoVisitadoVenue) {
		FR_ratingTemporalResultadoVisitadoVenue = fR_ratingTemporalResultadoVisitadoVenue;
	}

	public Double getFR_ratingTemporalResultadoVisitanteVenue() {
		return FR_ratingTemporalResultadoVisitanteVenue;
	}

	public void setFR_ratingTemporalResultadoVisitanteVenue(Double fR_ratingTemporalResultadoVisitanteVenue) {
		FR_ratingTemporalResultadoVisitanteVenue = fR_ratingTemporalResultadoVisitanteVenue;
	}

	public Integer getFR_numeroResultadosVisitadoVenue() {
		return FR_numeroResultadosVisitadoVenue;
	}

	public void setFR_numeroResultadosVisitadoVenue(Integer fR_numeroResultadosVisitadoVenue) {
		FR_numeroResultadosVisitadoVenue = fR_numeroResultadosVisitadoVenue;
	}

	public Integer getFR_numeroResultadosVisitanteVenue() {
		return FR_numeroResultadosVisitanteVenue;
	}

	public void setFR_numeroResultadosVisitanteVenue(Integer fR_numeroResultadosVisitanteVenue) {
		FR_numeroResultadosVisitanteVenue = fR_numeroResultadosVisitanteVenue;
	}

	public Double getFR_percentagemResultadoVisitadoVenue() {
		return FR_percentagemResultadoVisitadoVenue;
	}

	public void setFR_percentagemResultadoVisitadoVenue(Double fR_percentagemResultadoVisitadoVenue) {
		FR_percentagemResultadoVisitadoVenue = fR_percentagemResultadoVisitadoVenue;
	}

	public Double getFR_percentagemResultadoVisitanteVenue() {
		return FR_percentagemResultadoVisitanteVenue;
	}

	public void setFR_percentagemResultadoVisitanteVenue(Double fR_percentagemResultadoVisitanteVenue) {
		FR_percentagemResultadoVisitanteVenue = fR_percentagemResultadoVisitanteVenue;
	}

	public Double getFR_percentagemResultadoNoIntervaloVisitadoVenue() {
		return FR_percentagemResultadoNoIntervaloVisitadoVenue;
	}

	public void setFR_percentagemResultadoNoIntervaloVisitadoVenue(
			Double fR_percentagemResultadoNoIntervaloVisitadoVenue) {
		FR_percentagemResultadoNoIntervaloVisitadoVenue = fR_percentagemResultadoNoIntervaloVisitadoVenue;
	}

	public Double getFR_percentagemResultadoNoIntervaloVisitanteVenue() {
		return FR_percentagemResultadoNoIntervaloVisitanteVenue;
	}

	public void setFR_percentagemResultadoNoIntervaloVisitanteVenue(
			Double fR_percentagemResultadoNoIntervaloVisitanteVenue) {
		FR_percentagemResultadoNoIntervaloVisitanteVenue = fR_percentagemResultadoNoIntervaloVisitanteVenue;
	}

	public Integer getFR_golosMarcadosVisitadoVenue() {
		return FR_golosMarcadosVisitadoVenue;
	}

	public void setFR_golosMarcadosVisitadoVenue(Integer fR_golosMarcadosVisitadoVenue) {
		FR_golosMarcadosVisitadoVenue = fR_golosMarcadosVisitadoVenue;
	}

	public Integer getFR_golosSofridosVisitadoVenue() {
		return FR_golosSofridosVisitadoVenue;
	}

	public void setFR_golosSofridosVisitadoVenue(Integer fR_golosSofridosVisitadoVenue) {
		FR_golosSofridosVisitadoVenue = fR_golosSofridosVisitadoVenue;
	}

	public Integer getFR_diferencaGolosVisitadoVenue() {
		return FR_diferencaGolosVisitadoVenue;
	}

	public void setFR_diferencaGolosVisitadoVenue(Integer fR_diferencaGolosVisitadoVenue) {
		FR_diferencaGolosVisitadoVenue = fR_diferencaGolosVisitadoVenue;
	}

	public Integer getFR_golosMarcadosVisitanteVenue() {
		return FR_golosMarcadosVisitanteVenue;
	}

	public void setFR_golosMarcadosVisitanteVenue(Integer fR_golosMarcadosVisitanteVenue) {
		FR_golosMarcadosVisitanteVenue = fR_golosMarcadosVisitanteVenue;
	}

	public Integer getFR_golosSofridosVisitanteVenue() {
		return FR_golosSofridosVisitanteVenue;
	}

	public void setFR_golosSofridosVisitanteVenue(Integer fR_golosSofridosVisitanteVenue) {
		FR_golosSofridosVisitanteVenue = fR_golosSofridosVisitanteVenue;
	}

	public Integer getFR_diferencaGolosVisitanteVenue() {
		return FR_diferencaGolosVisitanteVenue;
	}

	public void setFR_diferencaGolosVisitanteVenue(Integer fR_diferencaGolosVisitanteVenue) {
		FR_diferencaGolosVisitanteVenue = fR_diferencaGolosVisitanteVenue;
	}

	public Double getFR_mediaGolosMarcadosVisitadoVenue() {
		return FR_mediaGolosMarcadosVisitadoVenue;
	}

	public void setFR_mediaGolosMarcadosVisitadoVenue(Double fR_mediaGolosMarcadosVisitadoVenue) {
		FR_mediaGolosMarcadosVisitadoVenue = fR_mediaGolosMarcadosVisitadoVenue;
	}

	public Double getFR_mediaGolosSofridosVisitadoVenue() {
		return FR_mediaGolosSofridosVisitadoVenue;
	}

	public void setFR_mediaGolosSofridosVisitadoVenue(Double fR_mediaGolosSofridosVisitadoVenue) {
		FR_mediaGolosSofridosVisitadoVenue = fR_mediaGolosSofridosVisitadoVenue;
	}

	public Double getFR_mediaGolosMarcadosVisitanteVenue() {
		return FR_mediaGolosMarcadosVisitanteVenue;
	}

	public void setFR_mediaGolosMarcadosVisitanteVenue(Double fR_mediaGolosMarcadosVisitanteVenue) {
		FR_mediaGolosMarcadosVisitanteVenue = fR_mediaGolosMarcadosVisitanteVenue;
	}

	public Double getFR_mediaGolosSofridosVisitanteVenue() {
		return FR_mediaGolosSofridosVisitanteVenue;
	}

	public void setFR_mediaGolosSofridosVisitanteVenue(Double fR_mediaGolosSofridosVisitanteVenue) {
		FR_mediaGolosSofridosVisitanteVenue = fR_mediaGolosSofridosVisitanteVenue;
	}

	public Double getFR_dificuldadeVisitadoSwitchedVenue() {
		return FR_dificuldadeVisitadoSwitchedVenue;
	}

	public void setFR_dificuldadeVisitadoSwitchedVenue(Double fR_dificuldadeVisitadoSwitchedVenue) {
		FR_dificuldadeVisitadoSwitchedVenue = fR_dificuldadeVisitadoSwitchedVenue;
	}

	public Double getFR_dificuldadeVisitanteSwitchedVenue() {
		return FR_dificuldadeVisitanteSwitchedVenue;
	}

	public void setFR_dificuldadeVisitanteSwitchedVenue(Double fR_dificuldadeVisitanteSwitchedVenue) {
		FR_dificuldadeVisitanteSwitchedVenue = fR_dificuldadeVisitanteSwitchedVenue;
	}

	public Integer getFR_historicosVisitadoSwitchedVenue() {
		return FR_historicosVisitadoSwitchedVenue;
	}

	public void setFR_historicosVisitadoSwitchedVenue(Integer fR_historicosVisitadoSwitchedVenue) {
		FR_historicosVisitadoSwitchedVenue = fR_historicosVisitadoSwitchedVenue;
	}

	public Integer getFR_historicosVisitanteSwitchedVenue() {
		return FR_historicosVisitanteSwitchedVenue;
	}

	public void setFR_historicosVisitanteSwitchedVenue(Integer fR_historicosVisitanteSwitchedVenue) {
		FR_historicosVisitanteSwitchedVenue = fR_historicosVisitanteSwitchedVenue;
	}

	public Double getFR_ratingTemporalResultadoVisitadoSwitchedVenue() {
		return FR_ratingTemporalResultadoVisitadoSwitchedVenue;
	}

	public void setFR_ratingTemporalResultadoVisitadoSwitchedVenue(
			Double fR_ratingTemporalResultadoVisitadoSwitchedVenue) {
		FR_ratingTemporalResultadoVisitadoSwitchedVenue = fR_ratingTemporalResultadoVisitadoSwitchedVenue;
	}

	public Double getFR_ratingTemporalResultadoVisitanteSwitchedVenue() {
		return FR_ratingTemporalResultadoVisitanteSwitchedVenue;
	}

	public void setFR_ratingTemporalResultadoVisitanteSwitchedVenue(
			Double fR_ratingTemporalResultadoVisitanteSwitchedVenue) {
		FR_ratingTemporalResultadoVisitanteSwitchedVenue = fR_ratingTemporalResultadoVisitanteSwitchedVenue;
	}

	public Integer getFR_numeroResultadosVisitadoSwitchedVenue() {
		return FR_numeroResultadosVisitadoSwitchedVenue;
	}

	public void setFR_numeroResultadosVisitadoSwitchedVenue(Integer fR_numeroResultadosVisitadoSwitchedVenue) {
		FR_numeroResultadosVisitadoSwitchedVenue = fR_numeroResultadosVisitadoSwitchedVenue;
	}

	public Integer getFR_numeroResultadosVisitanteSwitchedVenue() {
		return FR_numeroResultadosVisitanteSwitchedVenue;
	}

	public void setFR_numeroResultadosVisitanteSwitchedVenue(Integer fR_numeroResultadosVisitanteSwitchedVenue) {
		FR_numeroResultadosVisitanteSwitchedVenue = fR_numeroResultadosVisitanteSwitchedVenue;
	}

	public Double getFR_percentagemResultadoVisitadoSwitchedVenue() {
		return FR_percentagemResultadoVisitadoSwitchedVenue;
	}

	public void setFR_percentagemResultadoVisitadoSwitchedVenue(Double fR_percentagemResultadoVisitadoSwitchedVenue) {
		FR_percentagemResultadoVisitadoSwitchedVenue = fR_percentagemResultadoVisitadoSwitchedVenue;
	}

	public Double getFR_percentagemResultadoVisitanteSwitchedVenue() {
		return FR_percentagemResultadoVisitanteSwitchedVenue;
	}

	public void setFR_percentagemResultadoVisitanteSwitchedVenue(Double fR_percentagemResultadoVisitanteSwitchedVenue) {
		FR_percentagemResultadoVisitanteSwitchedVenue = fR_percentagemResultadoVisitanteSwitchedVenue;
	}

	public Double getFR_percentagemResultadoNoIntervaloVisitadoSwitchedVenue() {
		return FR_percentagemResultadoNoIntervaloVisitadoSwitchedVenue;
	}

	public void setFR_percentagemResultadoNoIntervaloVisitadoSwitchedVenue(
			Double fR_percentagemResultadoNoIntervaloVisitadoSwitchedVenue) {
		FR_percentagemResultadoNoIntervaloVisitadoSwitchedVenue = fR_percentagemResultadoNoIntervaloVisitadoSwitchedVenue;
	}

	public Double getFR_percentagemResultadoNoIntervaloVisitanteSwitchedVenue() {
		return FR_percentagemResultadoNoIntervaloVisitanteSwitchedVenue;
	}

	public void setFR_percentagemResultadoNoIntervaloVisitanteSwitchedVenue(
			Double fR_percentagemResultadoNoIntervaloVisitanteSwitchedVenue) {
		FR_percentagemResultadoNoIntervaloVisitanteSwitchedVenue = fR_percentagemResultadoNoIntervaloVisitanteSwitchedVenue;
	}

	public Integer getFR_golosMarcadosVisitadoSwitchedVenue() {
		return FR_golosMarcadosVisitadoSwitchedVenue;
	}

	public void setFR_golosMarcadosVisitadoSwitchedVenue(Integer fR_golosMarcadosVisitadoSwitchedVenue) {
		FR_golosMarcadosVisitadoSwitchedVenue = fR_golosMarcadosVisitadoSwitchedVenue;
	}

	public Integer getFR_golosSofridosVisitadoSwitchedVenue() {
		return FR_golosSofridosVisitadoSwitchedVenue;
	}

	public void setFR_golosSofridosVisitadoSwitchedVenue(Integer fR_golosSofridosVisitadoSwitchedVenue) {
		FR_golosSofridosVisitadoSwitchedVenue = fR_golosSofridosVisitadoSwitchedVenue;
	}

	public Integer getFR_diferencaGolosVisitadoSwitchedVenue() {
		return FR_diferencaGolosVisitadoSwitchedVenue;
	}

	public void setFR_diferencaGolosVisitadoSwitchedVenue(Integer fR_diferencaGolosVisitadoSwitchedVenue) {
		FR_diferencaGolosVisitadoSwitchedVenue = fR_diferencaGolosVisitadoSwitchedVenue;
	}

	public Integer getFR_golosMarcadosVisitanteSwitchedVenue() {
		return FR_golosMarcadosVisitanteSwitchedVenue;
	}

	public void setFR_golosMarcadosVisitanteSwitchedVenue(Integer fR_golosMarcadosVisitanteSwitchedVenue) {
		FR_golosMarcadosVisitanteSwitchedVenue = fR_golosMarcadosVisitanteSwitchedVenue;
	}

	public Integer getFR_golosSofridosVisitanteSwitchedVenue() {
		return FR_golosSofridosVisitanteSwitchedVenue;
	}

	public void setFR_golosSofridosVisitanteSwitchedVenue(Integer fR_golosSofridosVisitanteSwitchedVenue) {
		FR_golosSofridosVisitanteSwitchedVenue = fR_golosSofridosVisitanteSwitchedVenue;
	}

	public Integer getFR_diferencaGolosVisitanteSwitchedVenue() {
		return FR_diferencaGolosVisitanteSwitchedVenue;
	}

	public void setFR_diferencaGolosVisitanteSwitchedVenue(Integer fR_diferencaGolosVisitanteSwitchedVenue) {
		FR_diferencaGolosVisitanteSwitchedVenue = fR_diferencaGolosVisitanteSwitchedVenue;
	}

	public Double getFR_mediaGolosMarcadosVisitadoSwitchedVenue() {
		return FR_mediaGolosMarcadosVisitadoSwitchedVenue;
	}

	public void setFR_mediaGolosMarcadosVisitadoSwitchedVenue(Double fR_mediaGolosMarcadosVisitadoSwitchedVenue) {
		FR_mediaGolosMarcadosVisitadoSwitchedVenue = fR_mediaGolosMarcadosVisitadoSwitchedVenue;
	}

	public Double getFR_mediaGolosSofridosVisitadoSwitchedVenue() {
		return FR_mediaGolosSofridosVisitadoSwitchedVenue;
	}

	public void setFR_mediaGolosSofridosVisitadoSwitchedVenue(Double fR_mediaGolosSofridosVisitadoSwitchedVenue) {
		FR_mediaGolosSofridosVisitadoSwitchedVenue = fR_mediaGolosSofridosVisitadoSwitchedVenue;
	}

	public Double getFR_mediaGolosMarcadosVisitanteSwitchedVenue() {
		return FR_mediaGolosMarcadosVisitanteSwitchedVenue;
	}

	public void setFR_mediaGolosMarcadosVisitanteSwitchedVenue(Double fR_mediaGolosMarcadosVisitanteSwitchedVenue) {
		FR_mediaGolosMarcadosVisitanteSwitchedVenue = fR_mediaGolosMarcadosVisitanteSwitchedVenue;
	}

	public Double getFR_mediaGolosSofridosVisitanteSwitchedVenue() {
		return FR_mediaGolosSofridosVisitanteSwitchedVenue;
	}

	public void setFR_mediaGolosSofridosVisitanteSwitchedVenue(Double fR_mediaGolosSofridosVisitanteSwitchedVenue) {
		FR_mediaGolosSofridosVisitanteSwitchedVenue = fR_mediaGolosSofridosVisitanteSwitchedVenue;
	}

	public Integer getQLT_numeroJogosVisitado() {
		return QLT_numeroJogosVisitado;
	}

	public void setQLT_numeroJogosVisitado(Integer qLT_numeroJogosVisitado) {
		QLT_numeroJogosVisitado = qLT_numeroJogosVisitado;
	}

	public Integer getQLT_numeroJogosVisitante() {
		return QLT_numeroJogosVisitante;
	}

	public void setQLT_numeroJogosVisitante(Integer qLT_numeroJogosVisitante) {
		QLT_numeroJogosVisitante = qLT_numeroJogosVisitante;
	}

	public Double getQLT_percentagemResultadoVisitado() {
		return QLT_percentagemResultadoVisitado;
	}

	public void setQLT_percentagemResultadoVisitado(Double qLT_percentagemResultadoVisitado) {
		QLT_percentagemResultadoVisitado = qLT_percentagemResultadoVisitado;
	}

	public Double getQLT_percentagemResultadoVisitante() {
		return QLT_percentagemResultadoVisitante;
	}

	public void setQLT_percentagemResultadoVisitante(Double qLT_percentagemResultadoVisitante) {
		QLT_percentagemResultadoVisitante = qLT_percentagemResultadoVisitante;
	}

	public Double getQLT_dificuldadeResultadoVisitado() {
		return QLT_dificuldadeResultadoVisitado;
	}

	public void setQLT_dificuldadeResultadoVisitado(Double qLT_dificuldadeResultadoVisitado) {
		QLT_dificuldadeResultadoVisitado = qLT_dificuldadeResultadoVisitado;
	}

	public Double getQLT_dificuldadeResultadoVisitante() {
		return QLT_dificuldadeResultadoVisitante;
	}

	public void setQLT_dificuldadeResultadoVisitante(Double qLT_dificuldadeResultadoVisitante) {
		QLT_dificuldadeResultadoVisitante = qLT_dificuldadeResultadoVisitante;
	}

	public Double getQLT_percentagemResultadoNoIntervaloVisitado() {
		return QLT_percentagemResultadoNoIntervaloVisitado;
	}

	public void setQLT_percentagemResultadoNoIntervaloVisitado(Double qLT_percentagemResultadoNoIntervaloVisitado) {
		QLT_percentagemResultadoNoIntervaloVisitado = qLT_percentagemResultadoNoIntervaloVisitado;
	}

	public Double getQLT_percentagemResultadoNoIntervaloVisitante() {
		return QLT_percentagemResultadoNoIntervaloVisitante;
	}

	public void setQLT_percentagemResultadoNoIntervaloVisitante(Double qLT_percentagemResultadoNoIntervaloVisitante) {
		QLT_percentagemResultadoNoIntervaloVisitante = qLT_percentagemResultadoNoIntervaloVisitante;
	}

	public Integer getQLT_numeroJogosNoIntervaloVisitado() {
		return QLT_numeroJogosNoIntervaloVisitado;
	}

	public void setQLT_numeroJogosNoIntervaloVisitado(Integer qLT_numeroJogosNoIntervaloVisitado) {
		QLT_numeroJogosNoIntervaloVisitado = qLT_numeroJogosNoIntervaloVisitado;
	}

	public Integer getQLT_numeroJogosNoIntervaloVisitante() {
		return QLT_numeroJogosNoIntervaloVisitante;
	}

	public void setQLT_numeroJogosNoIntervaloVisitante(Integer qLT_numeroJogosNoIntervaloVisitante) {
		QLT_numeroJogosNoIntervaloVisitante = qLT_numeroJogosNoIntervaloVisitante;
	}

	public Integer getQLT_numeroJogosVisitadoVenue() {
		return QLT_numeroJogosVisitadoVenue;
	}

	public void setQLT_numeroJogosVisitadoVenue(Integer qLT_numeroJogosVisitadoVenue) {
		QLT_numeroJogosVisitadoVenue = qLT_numeroJogosVisitadoVenue;
	}

	public Integer getQLT_numeroJogosVisitanteVenue() {
		return QLT_numeroJogosVisitanteVenue;
	}

	public void setQLT_numeroJogosVisitanteVenue(Integer qLT_numeroJogosVisitanteVenue) {
		QLT_numeroJogosVisitanteVenue = qLT_numeroJogosVisitanteVenue;
	}

	public Double getQLT_percentagemResultadoVisitadoVenue() {
		return QLT_percentagemResultadoVisitadoVenue;
	}

	public void setQLT_percentagemResultadoVisitadoVenue(Double qLT_percentagemResultadoVisitadoVenue) {
		QLT_percentagemResultadoVisitadoVenue = qLT_percentagemResultadoVisitadoVenue;
	}

	public Double getQLT_percentagemResultadoVisitanteVenue() {
		return QLT_percentagemResultadoVisitanteVenue;
	}

	public void setQLT_percentagemResultadoVisitanteVenue(Double qLT_percentagemResultadoVisitanteVenue) {
		QLT_percentagemResultadoVisitanteVenue = qLT_percentagemResultadoVisitanteVenue;
	}

	public Double getQLT_dificuldadeResultadoVisitadoVenue() {
		return QLT_dificuldadeResultadoVisitadoVenue;
	}

	public void setQLT_dificuldadeResultadoVisitadoVenue(Double qLT_dificuldadeResultadoVisitadoVenue) {
		QLT_dificuldadeResultadoVisitadoVenue = qLT_dificuldadeResultadoVisitadoVenue;
	}

	public Double getQLT_dificuldadeResultadoVisitanteVenue() {
		return QLT_dificuldadeResultadoVisitanteVenue;
	}

	public void setQLT_dificuldadeResultadoVisitanteVenue(Double qLT_dificuldadeResultadoVisitanteVenue) {
		QLT_dificuldadeResultadoVisitanteVenue = qLT_dificuldadeResultadoVisitanteVenue;
	}

	public Double getQLT_percentagemResultadoNoIntervaloVisitadoVenue() {
		return QLT_percentagemResultadoNoIntervaloVisitadoVenue;
	}

	public void setQLT_percentagemResultadoNoIntervaloVisitadoVenue(
			Double qLT_percentagemResultadoNoIntervaloVisitadoVenue) {
		QLT_percentagemResultadoNoIntervaloVisitadoVenue = qLT_percentagemResultadoNoIntervaloVisitadoVenue;
	}

	public Double getQLT_percentagemResultadoNoIntervaloVisitanteVenue() {
		return QLT_percentagemResultadoNoIntervaloVisitanteVenue;
	}

	public void setQLT_percentagemResultadoNoIntervaloVisitanteVenue(
			Double qLT_percentagemResultadoNoIntervaloVisitanteVenue) {
		QLT_percentagemResultadoNoIntervaloVisitanteVenue = qLT_percentagemResultadoNoIntervaloVisitanteVenue;
	}

	public Integer getQLT_numeroJogosNoIntervaloVisitadoVenue() {
		return QLT_numeroJogosNoIntervaloVisitadoVenue;
	}

	public void setQLT_numeroJogosNoIntervaloVisitadoVenue(Integer qLT_numeroJogosNoIntervaloVisitadoVenue) {
		QLT_numeroJogosNoIntervaloVisitadoVenue = qLT_numeroJogosNoIntervaloVisitadoVenue;
	}

	public Integer getQLT_numeroJogosNoIntervaloVisitanteVenue() {
		return QLT_numeroJogosNoIntervaloVisitanteVenue;
	}

	public void setQLT_numeroJogosNoIntervaloVisitanteVenue(Integer qLT_numeroJogosNoIntervaloVisitanteVenue) {
		QLT_numeroJogosNoIntervaloVisitanteVenue = qLT_numeroJogosNoIntervaloVisitanteVenue;
	}

	public Integer getQLT_numeroJogosVisitadoSwitchedVenue() {
		return QLT_numeroJogosVisitadoSwitchedVenue;
	}

	public void setQLT_numeroJogosVisitadoSwitchedVenue(Integer qLT_numeroJogosVisitadoSwitchedVenue) {
		QLT_numeroJogosVisitadoSwitchedVenue = qLT_numeroJogosVisitadoSwitchedVenue;
	}

	public Integer getQLT_numeroJogosVisitanteSwitchedVenue() {
		return QLT_numeroJogosVisitanteSwitchedVenue;
	}

	public void setQLT_numeroJogosVisitanteSwitchedVenue(Integer qLT_numeroJogosVisitanteSwitchedVenue) {
		QLT_numeroJogosVisitanteSwitchedVenue = qLT_numeroJogosVisitanteSwitchedVenue;
	}

	public Double getQLT_percentagemResultadoVisitadoSwitchedVenue() {
		return QLT_percentagemResultadoVisitadoSwitchedVenue;
	}

	public void setQLT_percentagemResultadoVisitadoSwitchedVenue(Double qLT_percentagemResultadoVisitadoSwitchedVenue) {
		QLT_percentagemResultadoVisitadoSwitchedVenue = qLT_percentagemResultadoVisitadoSwitchedVenue;
	}

	public Double getQLT_percentagemResultadoVisitanteSwitchedVenue() {
		return QLT_percentagemResultadoVisitanteSwitchedVenue;
	}

	public void setQLT_percentagemResultadoVisitanteSwitchedVenue(
			Double qLT_percentagemResultadoVisitanteSwitchedVenue) {
		QLT_percentagemResultadoVisitanteSwitchedVenue = qLT_percentagemResultadoVisitanteSwitchedVenue;
	}

	public Double getQLT_dificuldadeResultadoVisitadoSwitchedVenue() {
		return QLT_dificuldadeResultadoVisitadoSwitchedVenue;
	}

	public void setQLT_dificuldadeResultadoVisitadoSwitchedVenue(Double qLT_dificuldadeResultadoVisitadoSwitchedVenue) {
		QLT_dificuldadeResultadoVisitadoSwitchedVenue = qLT_dificuldadeResultadoVisitadoSwitchedVenue;
	}

	public Double getQLT_dificuldadeResultadoVisitanteSwitchedVenue() {
		return QLT_dificuldadeResultadoVisitanteSwitchedVenue;
	}

	public void setQLT_dificuldadeResultadoVisitanteSwitchedVenue(
			Double qLT_dificuldadeResultadoVisitanteSwitchedVenue) {
		QLT_dificuldadeResultadoVisitanteSwitchedVenue = qLT_dificuldadeResultadoVisitanteSwitchedVenue;
	}

	public Double getQLT_percentagemResultadoNoIntervaloVisitadoSwitchedVenue() {
		return QLT_percentagemResultadoNoIntervaloVisitadoSwitchedVenue;
	}

	public void setQLT_percentagemResultadoNoIntervaloVisitadoSwitchedVenue(
			Double qLT_percentagemResultadoNoIntervaloVisitadoSwitchedVenue) {
		QLT_percentagemResultadoNoIntervaloVisitadoSwitchedVenue = qLT_percentagemResultadoNoIntervaloVisitadoSwitchedVenue;
	}

	public Double getQLT_percentagemResultadoNoIntervaloVisitanteSwitchedVenue() {
		return QLT_percentagemResultadoNoIntervaloVisitanteSwitchedVenue;
	}

	public void setQLT_percentagemResultadoNoIntervaloVisitanteSwitchedVenue(
			Double qLT_percentagemResultadoNoIntervaloVisitanteSwitchedVenue) {
		QLT_percentagemResultadoNoIntervaloVisitanteSwitchedVenue = qLT_percentagemResultadoNoIntervaloVisitanteSwitchedVenue;
	}

	public Integer getQLT_numeroJogosNoIntervaloVisitadoSwitchedVenue() {
		return QLT_numeroJogosNoIntervaloVisitadoSwitchedVenue;
	}

	public void setQLT_numeroJogosNoIntervaloVisitadoSwitchedVenue(
			Integer qLT_numeroJogosNoIntervaloVisitadoSwitchedVenue) {
		QLT_numeroJogosNoIntervaloVisitadoSwitchedVenue = qLT_numeroJogosNoIntervaloVisitadoSwitchedVenue;
	}

	public Integer getQLT_numeroJogosNoIntervaloVisitanteSwitchedVenue() {
		return QLT_numeroJogosNoIntervaloVisitanteSwitchedVenue;
	}

	public void setQLT_numeroJogosNoIntervaloVisitanteSwitchedVenue(
			Integer qLT_numeroJogosNoIntervaloVisitanteSwitchedVenue) {
		QLT_numeroJogosNoIntervaloVisitanteSwitchedVenue = qLT_numeroJogosNoIntervaloVisitanteSwitchedVenue;
	}

	public Double getH2h_ratingTemporalResultado() {
		return h2h_ratingTemporalResultado;
	}

	public void setH2h_ratingTemporalResultado(Double h2h_ratingTemporalResultado) {
		this.h2h_ratingTemporalResultado = h2h_ratingTemporalResultado;
	}

	public Integer getH2h_numeroJogos() {
		return h2h_numeroJogos;
	}

	public void setH2h_numeroJogos(Integer h2h_numeroJogos) {
		this.h2h_numeroJogos = h2h_numeroJogos;
	}

	public Integer getH2h_numeroResultados() {
		return h2h_numeroResultados;
	}

	public void setH2h_numeroResultados(Integer h2h_numeroResultados) {
		this.h2h_numeroResultados = h2h_numeroResultados;
	}

	public Double getH2h_percentagemResultados() {
		return h2h_percentagemResultados;
	}

	public void setH2h_percentagemResultados(Double h2h_percentagemResultados) {
		this.h2h_percentagemResultados = h2h_percentagemResultados;
	}

	public Double getH2h_ratingTemporalResultadoVenue() {
		return h2h_ratingTemporalResultadoVenue;
	}

	public void setH2h_ratingTemporalResultadoVenue(Double h2h_ratingTemporalResultadoVenue) {
		this.h2h_ratingTemporalResultadoVenue = h2h_ratingTemporalResultadoVenue;
	}

	public Integer getH2h_numeroJogosVenue() {
		return h2h_numeroJogosVenue;
	}

	public void setH2h_numeroJogosVenue(Integer h2h_numeroJogosVenue) {
		this.h2h_numeroJogosVenue = h2h_numeroJogosVenue;
	}

	public Integer getH2h_numeroResultadosVenue() {
		return h2h_numeroResultadosVenue;
	}

	public void setH2h_numeroResultadosVenue(Integer h2h_numeroResultadosVenue) {
		this.h2h_numeroResultadosVenue = h2h_numeroResultadosVenue;
	}

	public Double getH2h_percentagemResultadosVenue() {
		return h2h_percentagemResultadosVenue;
	}

	public void setH2h_percentagemResultadosVenue(Double h2h_percentagemResultadosVenue) {
		this.h2h_percentagemResultadosVenue = h2h_percentagemResultadosVenue;
	}

	public Double getH2h_ratingTemporalResultadoSwitchedVenue() {
		return h2h_ratingTemporalResultadoSwitchedVenue;
	}

	public void setH2h_ratingTemporalResultadoSwitchedVenue(Double h2h_ratingTemporalResultadoSwitchedVenue) {
		this.h2h_ratingTemporalResultadoSwitchedVenue = h2h_ratingTemporalResultadoSwitchedVenue;
	}

	public Integer getH2h_numeroJogosSwitchedVenue() {
		return h2h_numeroJogosSwitchedVenue;
	}

	public void setH2h_numeroJogosSwitchedVenue(Integer h2h_numeroJogosSwitchedVenue) {
		this.h2h_numeroJogosSwitchedVenue = h2h_numeroJogosSwitchedVenue;
	}

	public Integer getH2h_numeroResultadosSwitchedVenue() {
		return h2h_numeroResultadosSwitchedVenue;
	}

	public void setH2h_numeroResultadosSwitchedVenue(Integer h2h_numeroResultadosSwitchedVenue) {
		this.h2h_numeroResultadosSwitchedVenue = h2h_numeroResultadosSwitchedVenue;
	}

	public Double getH2h_percentagemResultadosSwitchedVenue() {
		return h2h_percentagemResultadosSwitchedVenue;
	}

	public void setH2h_percentagemResultadosSwitchedVenue(Double h2h_percentagemResultadosSwitchedVenue) {
		this.h2h_percentagemResultadosSwitchedVenue = h2h_percentagemResultadosSwitchedVenue;
	}

	public Integer getGolosMarcadosVisitado() {
		return golosMarcadosVisitado;
	}

	public void setGolosMarcadosVisitado(Integer golosMarcadosVisitado) {
		this.golosMarcadosVisitado = golosMarcadosVisitado;
	}

	public Integer getGolosSofridosVisitado() {
		return golosSofridosVisitado;
	}

	public void setGolosSofridosVisitado(Integer golosSofridosVisitado) {
		this.golosSofridosVisitado = golosSofridosVisitado;
	}

	public Integer getDiferencaGolosVisitado() {
		return diferencaGolosVisitado;
	}

	public void setDiferencaGolosVisitado(Integer diferencaGolosVisitado) {
		this.diferencaGolosVisitado = diferencaGolosVisitado;
	}

	public Integer getGolosMarcadosVisitante() {
		return golosMarcadosVisitante;
	}

	public void setGolosMarcadosVisitante(Integer golosMarcadosVisitante) {
		this.golosMarcadosVisitante = golosMarcadosVisitante;
	}

	public Integer getGolosSofridosVisitante() {
		return golosSofridosVisitante;
	}

	public void setGolosSofridosVisitante(Integer golosSofridosVisitante) {
		this.golosSofridosVisitante = golosSofridosVisitante;
	}

	public Integer getDiferencaGolosVisitante() {
		return diferencaGolosVisitante;
	}

	public void setDiferencaGolosVisitante(Integer diferencaGolosVisitante) {
		this.diferencaGolosVisitante = diferencaGolosVisitante;
	}

	public Double getMediaGolosMarcadosVisitado() {
		return mediaGolosMarcadosVisitado;
	}

	public void setMediaGolosMarcadosVisitado(Double mediaGolosMarcadosVisitado) {
		this.mediaGolosMarcadosVisitado = mediaGolosMarcadosVisitado;
	}

	public Double getMediaGolosSofridosVisitado() {
		return mediaGolosSofridosVisitado;
	}

	public void setMediaGolosSofridosVisitado(Double mediaGolosSofridosVisitado) {
		this.mediaGolosSofridosVisitado = mediaGolosSofridosVisitado;
	}

	public Double getMediaGolosMarcadosVisitante() {
		return mediaGolosMarcadosVisitante;
	}

	public void setMediaGolosMarcadosVisitante(Double mediaGolosMarcadosVisitante) {
		this.mediaGolosMarcadosVisitante = mediaGolosMarcadosVisitante;
	}

	public Double getMediaGolosSofridosVisitante() {
		return mediaGolosSofridosVisitante;
	}

	public void setMediaGolosSofridosVisitante(Double mediaGolosSofridosVisitante) {
		this.mediaGolosSofridosVisitante = mediaGolosSofridosVisitante;
	}

	public Integer getGolosMarcadosVisitadoVenue() {
		return golosMarcadosVisitadoVenue;
	}

	public void setGolosMarcadosVisitadoVenue(Integer golosMarcadosVisitadoVenue) {
		this.golosMarcadosVisitadoVenue = golosMarcadosVisitadoVenue;
	}

	public Integer getGolosSofridosVisitadoVenue() {
		return golosSofridosVisitadoVenue;
	}

	public void setGolosSofridosVisitadoVenue(Integer golosSofridosVisitadoVenue) {
		this.golosSofridosVisitadoVenue = golosSofridosVisitadoVenue;
	}

	public Integer getDiferencaGolosVisitadoVenue() {
		return diferencaGolosVisitadoVenue;
	}

	public void setDiferencaGolosVisitadoVenue(Integer diferencaGolosVisitadoVenue) {
		this.diferencaGolosVisitadoVenue = diferencaGolosVisitadoVenue;
	}

	public Integer getGolosMarcadosVisitanteVenue() {
		return golosMarcadosVisitanteVenue;
	}

	public void setGolosMarcadosVisitanteVenue(Integer golosMarcadosVisitanteVenue) {
		this.golosMarcadosVisitanteVenue = golosMarcadosVisitanteVenue;
	}

	public Integer getGolosSofridosVisitanteVenue() {
		return golosSofridosVisitanteVenue;
	}

	public void setGolosSofridosVisitanteVenue(Integer golosSofridosVisitanteVenue) {
		this.golosSofridosVisitanteVenue = golosSofridosVisitanteVenue;
	}

	public Integer getDiferencaGolosVisitanteVenue() {
		return diferencaGolosVisitanteVenue;
	}

	public void setDiferencaGolosVisitanteVenue(Integer diferencaGolosVisitanteVenue) {
		this.diferencaGolosVisitanteVenue = diferencaGolosVisitanteVenue;
	}

	public Double getMediaGolosMarcadosVisitadoVenue() {
		return mediaGolosMarcadosVisitadoVenue;
	}

	public void setMediaGolosMarcadosVisitadoVenue(Double mediaGolosMarcadosVisitadoVenue) {
		this.mediaGolosMarcadosVisitadoVenue = mediaGolosMarcadosVisitadoVenue;
	}

	public Double getMediaGolosSofridosVisitadoVenue() {
		return mediaGolosSofridosVisitadoVenue;
	}

	public void setMediaGolosSofridosVisitadoVenue(Double mediaGolosSofridosVisitadoVenue) {
		this.mediaGolosSofridosVisitadoVenue = mediaGolosSofridosVisitadoVenue;
	}

	public Double getMediaGolosMarcadosVisitanteVenue() {
		return mediaGolosMarcadosVisitanteVenue;
	}

	public void setMediaGolosMarcadosVisitanteVenue(Double mediaGolosMarcadosVisitanteVenue) {
		this.mediaGolosMarcadosVisitanteVenue = mediaGolosMarcadosVisitanteVenue;
	}

	public Double getMediaGolosSofridosVisitanteVenue() {
		return mediaGolosSofridosVisitanteVenue;
	}

	public void setMediaGolosSofridosVisitanteVenue(Double mediaGolosSofridosVisitanteVenue) {
		this.mediaGolosSofridosVisitanteVenue = mediaGolosSofridosVisitanteVenue;
	}

	public Integer getGolosMarcadosVisitadoSwitchedVenue() {
		return golosMarcadosVisitadoSwitchedVenue;
	}

	public void setGolosMarcadosVisitadoSwitchedVenue(Integer golosMarcadosVisitadoSwitchedVenue) {
		this.golosMarcadosVisitadoSwitchedVenue = golosMarcadosVisitadoSwitchedVenue;
	}

	public Integer getGolosSofridosVisitadoSwitchedVenue() {
		return golosSofridosVisitadoSwitchedVenue;
	}

	public void setGolosSofridosVisitadoSwitchedVenue(Integer golosSofridosVisitadoSwitchedVenue) {
		this.golosSofridosVisitadoSwitchedVenue = golosSofridosVisitadoSwitchedVenue;
	}

	public Integer getDiferencaGolosVisitadoSwitchedVenue() {
		return diferencaGolosVisitadoSwitchedVenue;
	}

	public void setDiferencaGolosVisitadoSwitchedVenue(Integer diferencaGolosVisitadoSwitchedVenue) {
		this.diferencaGolosVisitadoSwitchedVenue = diferencaGolosVisitadoSwitchedVenue;
	}

	public Integer getGolosMarcadosVisitanteSwitchedVenue() {
		return golosMarcadosVisitanteSwitchedVenue;
	}

	public void setGolosMarcadosVisitanteSwitchedVenue(Integer golosMarcadosVisitanteSwitchedVenue) {
		this.golosMarcadosVisitanteSwitchedVenue = golosMarcadosVisitanteSwitchedVenue;
	}

	public Integer getGolosSofridosVisitanteSwitchedVenue() {
		return golosSofridosVisitanteSwitchedVenue;
	}

	public void setGolosSofridosVisitanteSwitchedVenue(Integer golosSofridosVisitanteSwitchedVenue) {
		this.golosSofridosVisitanteSwitchedVenue = golosSofridosVisitanteSwitchedVenue;
	}

	public Integer getDiferencaGolosVisitanteSwitchedVenue() {
		return diferencaGolosVisitanteSwitchedVenue;
	}

	public void setDiferencaGolosVisitanteSwitchedVenue(Integer diferencaGolosVisitanteSwitchedVenue) {
		this.diferencaGolosVisitanteSwitchedVenue = diferencaGolosVisitanteSwitchedVenue;
	}

	public Double getMediaGolosMarcadosVisitadoSwitchedVenue() {
		return mediaGolosMarcadosVisitadoSwitchedVenue;
	}

	public void setMediaGolosMarcadosVisitadoSwitchedVenue(Double mediaGolosMarcadosVisitadoSwitchedVenue) {
		this.mediaGolosMarcadosVisitadoSwitchedVenue = mediaGolosMarcadosVisitadoSwitchedVenue;
	}

	public Double getMediaGolosSofridosVisitadoSwitchedVenue() {
		return mediaGolosSofridosVisitadoSwitchedVenue;
	}

	public void setMediaGolosSofridosVisitadoSwitchedVenue(Double mediaGolosSofridosVisitadoSwitchedVenue) {
		this.mediaGolosSofridosVisitadoSwitchedVenue = mediaGolosSofridosVisitadoSwitchedVenue;
	}

	public Double getMediaGolosMarcadosVisitanteSwitchedVenue() {
		return mediaGolosMarcadosVisitanteSwitchedVenue;
	}

	public void setMediaGolosMarcadosVisitanteSwitchedVenue(Double mediaGolosMarcadosVisitanteSwitchedVenue) {
		this.mediaGolosMarcadosVisitanteSwitchedVenue = mediaGolosMarcadosVisitanteSwitchedVenue;
	}

	public Double getMediaGolosSofridosVisitanteSwitchedVenue() {
		return mediaGolosSofridosVisitanteSwitchedVenue;
	}

	public void setMediaGolosSofridosVisitanteSwitchedVenue(Double mediaGolosSofridosVisitanteSwitchedVenue) {
		this.mediaGolosSofridosVisitanteSwitchedVenue = mediaGolosSofridosVisitanteSwitchedVenue;
	}
}

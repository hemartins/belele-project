package pt.belele.project.algorithm;

import java.util.Date;

public class ExcelRow {

	Date data;
	Long idVisitado;
	Long idVisitante;
	String homeTeamName;
	String awayTeamName;

	Double qualidadeVisitado; // pontos por jogo da equipa
	Double qualidadeVisitante;
	Integer FR_diasDescansoVisitado; // diferença entra a data do jogo a
										// calcular e do jogo anterior
	Integer FR_diasDescansoVisitante;
	Double FR_ratingResultadoVisitado; // pontuação por cada vitória obtida nos
										// últimos 5 jogos, consoante o quão
										// recente o jogo é
	Double FR_ratingResultadoVisitante;
	// recente o jogo é [0.3, 0.25, 0.2, 0.15, 0.1]
	Double FR_dificuldadeVisitado; // média das qualidades dos adversários dos
									// últimos 5 jogos
	Double FR_dificuldadeVisitante;
	Integer FR_HistoricosVisitado; // número de históricos que a equipa
									// enfrentou nos últimos 5 jogos
	Integer FR_HistoricosVisitante;
	Integer Ciclo_numeroJogosVisitado; // número de jogos que a equipa venceu
										// seguidos (ex: caso não tenha vencido
										// nenhum dos últimos 3 jogos é =-3;
										// caso tenha vencido os últimos 5 jogos
										// =5;
	Integer Ciclo_numeroJogosVisitante;
	Double Ciclo_dificuldadeVisitado; // média das qualidades dos adversários
										// desse que a equipa enfrentou nesse
										// ciclo
	Double Ciclo_dificuldadeVisitante;
	Integer Ciclo_HistoricosVisitado; // número de históricos que a equipa
										// enfrentou durante esse ciclo
	Integer Ciclo_HistoricosVisitante;

	Double H2H_ratingResultado; // pontuação por cada vitória obtida nos últimos
								// jogos entre essas equipas
	Integer H2H_numeroJogos;
	Double QLT_percentagemResultadoVisitado; // percentagem total de vitórias da
												// equipa em casa
	Double QLT_percentagemResultadoVisitante;
	Double QLT_dificuldadeResultadoVisitado; // média das qualidades dos
												// adversários que enfrentou em
												// casa
												// até à data
	Double QLT_dificuldadeResultadoVisitante;
	Double QLT_percentagemResultadoVisitadoNoIntervalo; // percentagem de
														// vitórias frente a
														// equipas cuja
														// qualidade se encontra
														// entre
														// [qualidade_do_adversário
														// - x ,
														// qualidade_do_adversário
														// + x]
	Double QLT_percentagemResultadoVisitanteNoIntervalo;
	Integer QLT_numeroJogosVisitado; // quantas equipas enfrentou no intervalo
										// citado em cima
	Integer QLT_numeroJogosVisitante;
	Integer result;

	Integer CicloPerna_numeroJogosVisitado; // número de jogos que a equipa
											// venceu
	// seguidos (ex: caso não tenha vencido
	// nenhum dos últimos 3 jogos é =-3;
	// caso tenha vencido os últimos 5 jogos
	// =5;
	Integer CicloPerna_numeroJogosVisitante;
	Double CicloPerna_dificuldadeVisitado; // média das qualidades dos
											// adversários
	// desse que a equipa enfrentou nesse
	// ciclo
	Double CicloPerna_dificuldadeVisitante;
	Integer CicloPerna_HistoricosVisitado; // número de históricos que a equipa
	// enfrentou durante esse ciclo
	Integer CicloPerna_HistoricosVisitante;

	Double FR_ratingQualidadeResultadoVisitado;
	Double FR_ratingQualidadeResultadoVisitante;

	Integer QLT_numeroJogosVisitadoDaPercentagem;
	Integer QLT_numeroJogosVisitanteDaPercentagem;

	Double QLT_percentagemResultadoVisitado2;
	Double QLT_percentagemResultadoVisitante2;
	Double QLT_dificuldadeResultadoVisitado2;
	Double QLT_dificuldadeResultadoVisitante2;
	Double QLT_percentagemResultadoVisitadoNoIntervalo2;
	Double QLT_percentagemResultadoVisitanteNoIntervalo2;
	Integer QLT_numeroJogosVisitado2;
	Integer QLT_numeroJogosVisitante2;

	Integer H2h_Results;

	Integer FR_ResultadosVisitado;
	Integer FR_ResultadosVisitante;

	Integer QLT_homeTeamNumeroJogos2;
	Integer QLT_awayTeamNumeroJogos2;

	Integer golosVisitado;
	Integer golosSofridosVisitado;
	Integer diferencaGolosVisitado;
	Integer golosVisitante;
	Integer golosSofridosVisitante;
	Integer diferencaGolosVisitante;
	Integer golosVisitadoCasa;
	Integer golosSofridosVisitadoCasa;
	Integer diferencaGolosVisitadoCasa;
	Integer golosVisitanteFora;
	Integer golosSofridosVisitanteFora;
	Integer diferencaGolosVisitanteFora;
	Integer classificacaoVisitado;
	Integer classificacaoVisitante;

	Double qualidadeVisitadoCasa;
	Double qualidadeVisitanteFora;
	
	Double qualidadeVisitadoFora;
	Double qualidadeVisitanteCasa;

	Integer Ciclo_numeroJogosVisitadoTotal; // número de jogos que a equipa
											// venceu
	// seguidos (ex: caso não tenha vencido
	// nenhum dos últimos 3 jogos é =-3;
	// caso tenha vencido os últimos 5 jogos
	// =5;
	Integer Ciclo_numeroJogosVisitanteTotal;
	Double Ciclo_dificuldadeVisitadoTotal; // média das qualidades dos
											// adversários
	// desse que a equipa enfrentou nesse
	// ciclo
	Double Ciclo_dificuldadeVisitanteTotal;
	Integer Ciclo_HistoricosVisitadoTotal; // número de históricos que a equipa
	// enfrentou durante esse ciclo
	Integer Ciclo_HistoricosVisitanteTotal;

	Integer CicloPerna_numeroJogosVisitadoTotal; // número de jogos que a equipa
	// venceu
	// seguidos (ex: caso não tenha vencido
	// nenhum dos últimos 3 jogos é =-3;
	// caso tenha vencido os últimos 5 jogos
	// =5;
	Integer CicloPerna_numeroJogosVisitanteTotal;
	Double CicloPerna_dificuldadeVisitadoTotal; // média das qualidades dos
	// adversários
	// desse que a equipa enfrentou nesse
	// ciclo
	Double CicloPerna_dificuldadeVisitanteTotal;
	Integer CicloPerna_HistoricosVisitadoTotal; // número de históricos que a
												// equipa
	// enfrentou durante esse ciclo
	Integer CicloPerna_HistoricosVisitanteTotal;

	Double FR_dificuldadeVisitadoHome;
	Double FR_dificuldadeVisitanteAway;
	Integer FR_HistoricosVisitadoHome;
	Integer FR_HistoricosVisitanteAway;
	Double FR_ratingResultadoVisitadoHome;
	Double FR_ratingResultadoVisitanteAway;
	Integer FR_ResultadoVisitadoHome;
	Integer FR_ResultadoVisitanteAway;
	
	
	//últimos 5 jogos
	Double QLT_percentagemResultadoVisitado_5jogos;
	Double QLT_percentagemResultadoVisitante_5jogos;
	Double QLT_dificuldadeResultadoVisitado_5jogos;
	Double QLT_dificuldadeResultadoVisitante_5jogos;
	Double QLT_percentagemResultadoVisitadoNoIntervalo_5jogos;
	Double QLT_percentagemResultadoVisitanteNoIntervalo_5jogos;
	Integer QLT_numeroJogosVisitado_5jogos;
	Integer QLT_numeroJogosVisitante_5jogos;
	
	//TROCADO últimos 5 jogos
	Double QLT_percentagemResultadoVisitado2_5jogos;
	Double QLT_percentagemResultadoVisitante2_5jogos;
	Double QLT_dificuldadeResultadoVisitado2_5jogos;
	Double QLT_dificuldadeResultadoVisitante2_5jogos;
	Double QLT_percentagemResultadoVisitadoNoIntervalo2_5jogos;
	Double QLT_percentagemResultadoVisitanteNoIntervalo2_5jogos;
	Integer QLT_numeroJogosVisitado2_5jogos;
	Integer QLT_numeroJogosVisitante2_5jogos;
	
	public ExcelRow(){
		
	}

	public ExcelRow(Date data, Long idVisitado, Long idVisitante, String homeTeamName, String awayTeamName,
			Double qualidadeVisitado, Double qualidadeVisitante, Integer fR_diasDescansoVisitado,
			Integer fR_diasDescansoVisitante, Double fR_ratingResultadoVisitado, Double fR_ratingResultadoVisitante,
			Double fR_dificuldadeVisitado, Double fR_dificuldadeVisitante, Integer fR_HistoricosVisitado,
			Integer fR_HistoricosVisitante, Integer ciclo_numeroJogosVisitado, Integer ciclo_numeroJogosVisitante,
			Double ciclo_dificuldadeVisitado, Double ciclo_dificuldadeVisitante, Integer ciclo_HistoricosVisitado,
			Integer ciclo_HistoricosVisitante, Double h2h_ratingResultado, Integer h2h_numeroJogos,
			Double qLT_percentagemResultadoVisitado, Double qLT_percentagemResultadoVisitante,
			Double qLT_dificuldadeResultadoVisitado, Double qLT_dificuldadeResultadoVisitante,
			Double qLT_percentagemResultadoVisitadoNoIntervalo, Double qLT_percentagemResultadoVisitanteNoIntervalo,
			Integer qLT_numeroJogosVisitado, Integer qLT_numeroJogosVisitante, Integer result,
			Integer cicloPerna_numeroJogosVisitado, Integer cicloPerna_numeroJogosVisitante,
			Double cicloPerna_dificuldadeVisitado, Double cicloPerna_dificuldadeVisitante,
			Integer cicloPerna_HistoricosVisitado, Integer cicloPerna_HistoricosVisitante,
			Double fR_ratingQualidadeResultadoVisitado, Double fR_ratingQualidadeResultadoVisitante,
			Integer qLT_numeroJogosVisitadoDaPercentagem, Integer qLT_numeroJogosVisitanteDaPercentagem,
			Integer qLT_homeTeamNumeroJogos2, Integer qLT_awayTeamNumeroJogos2,
			Double qLT_percentagemResultadoVisitado2, Double qLT_percentagemResultadoVisitante2,
			Double qLT_dificuldadeResultadoVisitado2, Double qLT_dificuldadeResultadoVisitante2,
			Double qLT_percentagemResultadoVisitadoNoIntervalo2, Double qLT_percentagemResultadoVisitanteNoIntervalo2,
			Integer qLT_numeroJogosVisitado2, Integer qLT_numeroJogosVisitante2, Integer h2h_Results,
			Integer fR_ResultadosVisitado, Integer fR_ResultadosVisitante, Integer golosVisitado,
			Integer golosContraVisitado, Integer diferencaGolosVisitado, Integer golosVisitante,
			Integer golosContraVisitante, Integer diferencaGolosVisitante, Integer golosVisitadoCasa,
			Integer golosContraVisitadoCasa, Integer diferencaGolosVisitadoCasa, Integer golosVisitanteFora,
			Integer golosContraVisitanteFora, Integer diferencaGolosVisitanteFora, Integer classificacaoVisitado,
			Integer classificacaoVisitante, Double qualidadeVisitadoCasa, Double qualidadeVisitanteFora,
			Integer ciclo_numeroJogosVisitadoTotal, Integer ciclo_numeroJogosVisitanteTotal,
			Double ciclo_dificuldadeVisitadoTotal, Double ciclo_dificuldadeVisitanteTotal,
			Integer ciclo_HistoricosVisitadoTotal, Integer ciclo_HistoricosVisitanteTotal, Integer cicloPerna_numeroJogosVisitadoTotal,
			Integer cicloPerna_numeroJogosVisitanteTotal, Double cicloPerna_dificuldadeVisitadoTotal,
			Double cicloPerna_dificuldadeVisitanteTotal, Integer cicloPerna_HistoricosVisitadoTotal,
			Integer cicloPerna_HistoricosVisitanteTotal,Double fR_dificuldadeVisitadoHome, Double fR_dificuldadeVisitanteAway, 
			Integer fR_HistoricosVisitadoHome, Integer fR_HistoricosVisitanteAway, Double fR_ratingResultadoVisitadoHome,
			Double fR_ratingResultadoVisitanteAway, Integer fR_ResultadoVisitadoHome, Integer fR_ResultadoVisitanteAway,Double qLT_percentagemResultadoVisitado_5jogos,
			Double qLT_percentagemResultadoVisitante_5jogos, Double qLT_dificuldadeResultadoVisitado_5jogos, Double qLT_dificuldadeResultadoVisitante_5jogos,Double qLT_percentagemResultadoVisitadoNoIntervalo_5jogos,
			Double qLT_percentagemResultadoVisitanteNoIntervalo_5jogos, Integer qLT_numeroJogosVisitado_5jogos, Integer qLT_numeroJogosVisitante_5jogos, Double qLT_percentagemResultadoVisitado2_5jogos,
			Double qLT_percentagemResultadoVisitante2_5jogos, Double qLT_dificuldadeResultadoVisitado2_5jogos, Double qLT_dificuldadeResultadoVisitante2_5jogos,Double qLT_percentagemResultadoVisitadoNoIntervalo2_5jogos,
			Double qLT_percentagemResultadoVisitanteNoIntervalo2_5jogos, Integer qLT_numeroJogosVisitado2_5jogos, Integer qLT_numeroJogosVisitante2_5jogos) {

		this.data = data;
		this.idVisitado = idVisitado;
		this.idVisitante = idVisitante;
		this.homeTeamName = homeTeamName;
		this.awayTeamName = awayTeamName;
		this.qualidadeVisitado = qualidadeVisitado;
		this.qualidadeVisitante = qualidadeVisitante;
		FR_diasDescansoVisitado = fR_diasDescansoVisitado;
		FR_diasDescansoVisitante = fR_diasDescansoVisitante;
		FR_ratingResultadoVisitado = fR_ratingResultadoVisitado;
		FR_ratingResultadoVisitante = fR_ratingResultadoVisitante;
		FR_dificuldadeVisitado = fR_dificuldadeVisitado;
		FR_dificuldadeVisitante = fR_dificuldadeVisitante;
		FR_HistoricosVisitado = fR_HistoricosVisitado;
		FR_HistoricosVisitante = fR_HistoricosVisitante;
		Ciclo_numeroJogosVisitado = ciclo_numeroJogosVisitado;
		Ciclo_numeroJogosVisitante = ciclo_numeroJogosVisitante;
		Ciclo_dificuldadeVisitado = ciclo_dificuldadeVisitado;
		Ciclo_dificuldadeVisitante = ciclo_dificuldadeVisitante;
		Ciclo_HistoricosVisitado = ciclo_HistoricosVisitado;
		Ciclo_HistoricosVisitante = ciclo_HistoricosVisitante;
		H2H_ratingResultado = h2h_ratingResultado;
		H2H_numeroJogos = h2h_numeroJogos;
		QLT_percentagemResultadoVisitado = qLT_percentagemResultadoVisitado;
		QLT_percentagemResultadoVisitante = qLT_percentagemResultadoVisitante;
		QLT_dificuldadeResultadoVisitado = qLT_dificuldadeResultadoVisitado;
		QLT_dificuldadeResultadoVisitante = qLT_dificuldadeResultadoVisitante;
		QLT_percentagemResultadoVisitadoNoIntervalo = qLT_percentagemResultadoVisitadoNoIntervalo;
		QLT_percentagemResultadoVisitanteNoIntervalo = qLT_percentagemResultadoVisitanteNoIntervalo;
		QLT_numeroJogosVisitado = qLT_numeroJogosVisitado;
		QLT_numeroJogosVisitante = qLT_numeroJogosVisitante;
		this.result = result;

		CicloPerna_numeroJogosVisitado = cicloPerna_numeroJogosVisitado;
		CicloPerna_numeroJogosVisitante = cicloPerna_numeroJogosVisitante;
		CicloPerna_dificuldadeVisitado = cicloPerna_dificuldadeVisitado;
		CicloPerna_dificuldadeVisitante = cicloPerna_dificuldadeVisitante;
		CicloPerna_HistoricosVisitado = cicloPerna_HistoricosVisitado;
		CicloPerna_HistoricosVisitante = cicloPerna_HistoricosVisitante;
		FR_ratingQualidadeResultadoVisitado = fR_ratingQualidadeResultadoVisitado;
		FR_ratingQualidadeResultadoVisitante = fR_ratingQualidadeResultadoVisitante;
		QLT_numeroJogosVisitadoDaPercentagem = qLT_numeroJogosVisitadoDaPercentagem;
		QLT_numeroJogosVisitanteDaPercentagem = qLT_numeroJogosVisitanteDaPercentagem;

		QLT_homeTeamNumeroJogos2 = qLT_homeTeamNumeroJogos2;
		QLT_awayTeamNumeroJogos2 = qLT_awayTeamNumeroJogos2;
		QLT_percentagemResultadoVisitado2 = qLT_percentagemResultadoVisitado2;
		QLT_percentagemResultadoVisitante2 = qLT_percentagemResultadoVisitante2;
		QLT_dificuldadeResultadoVisitado2 = qLT_dificuldadeResultadoVisitado2;
		QLT_dificuldadeResultadoVisitante2 = qLT_dificuldadeResultadoVisitante2;
		QLT_percentagemResultadoVisitadoNoIntervalo2 = qLT_percentagemResultadoVisitadoNoIntervalo2;
		QLT_percentagemResultadoVisitanteNoIntervalo2 = qLT_percentagemResultadoVisitanteNoIntervalo2;
		QLT_numeroJogosVisitado2 = qLT_numeroJogosVisitado2;
		QLT_numeroJogosVisitante2 = qLT_numeroJogosVisitante2;

		H2h_Results = h2h_Results;

		FR_ResultadosVisitado = fR_ResultadosVisitado;
		FR_ResultadosVisitante = fR_ResultadosVisitante;

		this.golosVisitado = golosVisitado;
		this.golosSofridosVisitado = golosContraVisitado;
		this.diferencaGolosVisitado = diferencaGolosVisitado;
		this.golosVisitante = golosVisitante;
		this.golosSofridosVisitante = golosContraVisitante;
		this.diferencaGolosVisitante = diferencaGolosVisitante;
		this.golosVisitadoCasa = golosVisitadoCasa;
		this.golosSofridosVisitadoCasa = golosContraVisitadoCasa;
		this.diferencaGolosVisitadoCasa = diferencaGolosVisitadoCasa;
		this.golosVisitanteFora = golosVisitanteFora;
		this.golosSofridosVisitanteFora = golosContraVisitanteFora;
		this.diferencaGolosVisitanteFora = diferencaGolosVisitanteFora;
		this.classificacaoVisitado = classificacaoVisitado;
		this.classificacaoVisitante = classificacaoVisitante;
		this.qualidadeVisitadoCasa = qualidadeVisitadoCasa;
		this.qualidadeVisitanteFora = qualidadeVisitanteFora;

		Ciclo_numeroJogosVisitadoTotal = ciclo_numeroJogosVisitadoTotal;
		Ciclo_numeroJogosVisitanteTotal = ciclo_numeroJogosVisitanteTotal;
		Ciclo_dificuldadeVisitadoTotal = ciclo_dificuldadeVisitadoTotal;
		Ciclo_dificuldadeVisitanteTotal = ciclo_dificuldadeVisitanteTotal;
		Ciclo_HistoricosVisitadoTotal = ciclo_HistoricosVisitadoTotal;
		Ciclo_HistoricosVisitanteTotal = ciclo_HistoricosVisitanteTotal;
		CicloPerna_numeroJogosVisitadoTotal = cicloPerna_numeroJogosVisitadoTotal;
		CicloPerna_numeroJogosVisitanteTotal = cicloPerna_numeroJogosVisitanteTotal;
		CicloPerna_dificuldadeVisitadoTotal = cicloPerna_dificuldadeVisitadoTotal;
		CicloPerna_dificuldadeVisitanteTotal = cicloPerna_dificuldadeVisitanteTotal;
		CicloPerna_HistoricosVisitadoTotal = cicloPerna_HistoricosVisitadoTotal;
		CicloPerna_HistoricosVisitanteTotal = cicloPerna_HistoricosVisitanteTotal;
		
		FR_dificuldadeVisitadoHome = fR_dificuldadeVisitadoHome;
		FR_dificuldadeVisitanteAway = fR_dificuldadeVisitanteAway;
		FR_HistoricosVisitadoHome = fR_HistoricosVisitadoHome;
		FR_HistoricosVisitanteAway = fR_HistoricosVisitanteAway;
		FR_ratingResultadoVisitadoHome = fR_ratingResultadoVisitadoHome;
		FR_ratingResultadoVisitanteAway = fR_ratingResultadoVisitanteAway;
		FR_ResultadoVisitadoHome = fR_ResultadoVisitadoHome;
		FR_ResultadoVisitanteAway = fR_ResultadoVisitanteAway;
		
		QLT_percentagemResultadoVisitado_5jogos = qLT_percentagemResultadoVisitado_5jogos;
		QLT_percentagemResultadoVisitante_5jogos = qLT_percentagemResultadoVisitante_5jogos;
		QLT_dificuldadeResultadoVisitado_5jogos = qLT_dificuldadeResultadoVisitado_5jogos;
		QLT_dificuldadeResultadoVisitante_5jogos = qLT_dificuldadeResultadoVisitante_5jogos;
		QLT_percentagemResultadoVisitadoNoIntervalo_5jogos = qLT_percentagemResultadoVisitadoNoIntervalo_5jogos;
		QLT_percentagemResultadoVisitanteNoIntervalo_5jogos = qLT_percentagemResultadoVisitanteNoIntervalo_5jogos;
		QLT_numeroJogosVisitado_5jogos = qLT_numeroJogosVisitado_5jogos;
		QLT_numeroJogosVisitante_5jogos = qLT_numeroJogosVisitante_5jogos;
		QLT_percentagemResultadoVisitado2_5jogos = qLT_percentagemResultadoVisitado2_5jogos;
		QLT_percentagemResultadoVisitante2_5jogos = qLT_percentagemResultadoVisitante2_5jogos;
		QLT_dificuldadeResultadoVisitado2_5jogos = qLT_dificuldadeResultadoVisitado2_5jogos;
		QLT_dificuldadeResultadoVisitante2_5jogos = qLT_dificuldadeResultadoVisitante2_5jogos;
		QLT_percentagemResultadoVisitadoNoIntervalo2_5jogos = qLT_percentagemResultadoVisitadoNoIntervalo2_5jogos;
		QLT_percentagemResultadoVisitanteNoIntervalo2_5jogos = qLT_percentagemResultadoVisitanteNoIntervalo2_5jogos;
		QLT_numeroJogosVisitado2_5jogos = qLT_numeroJogosVisitado2_5jogos;
		QLT_numeroJogosVisitante2_5jogos = qLT_numeroJogosVisitante2_5jogos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public String getHomeTeamName() {
		return homeTeamName;
	}

	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}

	public String getAwayTeamName() {
		return awayTeamName;
	}

	public void setAwayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
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

	public Integer getFR_diasDescansoVisitado() {
		return FR_diasDescansoVisitado;
	}

	public void setFR_diasDescansoVisitado(Integer fR_diasDescansoVisitado) {
		FR_diasDescansoVisitado = fR_diasDescansoVisitado;
	}

	public Integer getFR_diasDescansoVisitante() {
		return FR_diasDescansoVisitante;
	}

	public void setFR_diasDescansoVisitante(Integer fR_diasDescansoVisitante) {
		FR_diasDescansoVisitante = fR_diasDescansoVisitante;
	}

	public Double getFR_ratingResultadoVisitado() {
		return FR_ratingResultadoVisitado;
	}

	public void setFR_ratingResultadoVisitado(Double fR_ratingResultadoVisitado) {
		FR_ratingResultadoVisitado = fR_ratingResultadoVisitado;
	}

	public Double getFR_ratingResultadoVisitante() {
		return FR_ratingResultadoVisitante;
	}

	public void setFR_ratingResultadoVisitante(Double fR_ratingResultadoVisitante) {
		FR_ratingResultadoVisitante = fR_ratingResultadoVisitante;
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

	public Integer getFR_HistoricosVisitado() {
		return FR_HistoricosVisitado;
	}

	public void setFR_HistoricosVisitado(Integer fR_HistoricosVisitado) {
		FR_HistoricosVisitado = fR_HistoricosVisitado;
	}

	public Integer getFR_HistoricosVisitante() {
		return FR_HistoricosVisitante;
	}

	public void setFR_HistoricosVisitante(Integer fR_HistoricosVisitante) {
		FR_HistoricosVisitante = fR_HistoricosVisitante;
	}

	public Integer getCiclo_numeroJogosVisitado() {
		return Ciclo_numeroJogosVisitado;
	}

	public void setCiclo_numeroJogosVisitado(Integer ciclo_numeroJogosVisitado) {
		Ciclo_numeroJogosVisitado = ciclo_numeroJogosVisitado;
	}

	public Integer getCiclo_numeroJogosVisitante() {
		return Ciclo_numeroJogosVisitante;
	}

	public void setCiclo_numeroJogosVisitante(Integer ciclo_numeroJogosVisitante) {
		Ciclo_numeroJogosVisitante = ciclo_numeroJogosVisitante;
	}

	public Double getCiclo_dificuldadeVisitado() {
		return Ciclo_dificuldadeVisitado;
	}

	public void setCiclo_dificuldadeVisitado(Double ciclo_dificuldadeVisitado) {
		Ciclo_dificuldadeVisitado = ciclo_dificuldadeVisitado;
	}

	public Double getCiclo_dificuldadeVisitante() {
		return Ciclo_dificuldadeVisitante;
	}

	public void setCiclo_dificuldadeVisitante(Double ciclo_dificuldadeVisitante) {
		Ciclo_dificuldadeVisitante = ciclo_dificuldadeVisitante;
	}

	public Integer getCiclo_HistoricosVisitado() {
		return Ciclo_HistoricosVisitado;
	}

	public void setCiclo_HistoricosVisitado(Integer ciclo_HistoricosVisitado) {
		Ciclo_HistoricosVisitado = ciclo_HistoricosVisitado;
	}

	public Integer getCiclo_HistoricosVisitante() {
		return Ciclo_HistoricosVisitante;
	}

	public void setCiclo_HistoricosVisitante(Integer ciclo_HistoricosVisitante) {
		Ciclo_HistoricosVisitante = ciclo_HistoricosVisitante;
	}

	public Integer getCicloPerna_numeroJogosVisitado() {
		return CicloPerna_numeroJogosVisitado;
	}

	public void setCicloPerna_numeroJogosVisitado(Integer cicloPerna_numeroJogosVisitado) {
		CicloPerna_numeroJogosVisitado = cicloPerna_numeroJogosVisitado;
	}

	public Integer getCicloPerna_numeroJogosVisitante() {
		return CicloPerna_numeroJogosVisitante;
	}

	public void setCicloPerna_numeroJogosVisitante(Integer cicloPerna_numeroJogosVisitante) {
		CicloPerna_numeroJogosVisitante = cicloPerna_numeroJogosVisitante;
	}

	public Double getCicloPerna_dificuldadeVisitado() {
		return CicloPerna_dificuldadeVisitado;
	}

	public void setCicloPerna_dificuldadeVisitado(Double cicloPerna_dificuldadeVisitado) {
		CicloPerna_dificuldadeVisitado = cicloPerna_dificuldadeVisitado;
	}

	public Double getCicloPerna_dificuldadeVisitante() {
		return CicloPerna_dificuldadeVisitante;
	}

	public void setCicloPerna_dificuldadeVisitante(Double cicloPerna_dificuldadeVisitante) {
		CicloPerna_dificuldadeVisitante = cicloPerna_dificuldadeVisitante;
	}

	public Integer getCicloPerna_HistoricosVisitado() {
		return CicloPerna_HistoricosVisitado;
	}

	public void setCicloPerna_HistoricosVisitado(Integer cicloPerna_HistoricosVisitado) {
		CicloPerna_HistoricosVisitado = cicloPerna_HistoricosVisitado;
	}

	public Integer getCicloPerna_HistoricosVisitante() {
		return CicloPerna_HistoricosVisitante;
	}

	public void setCicloPerna_HistoricosVisitante(Integer cicloPerna_HistoricosVisitante) {
		CicloPerna_HistoricosVisitante = cicloPerna_HistoricosVisitante;
	}

	public Double getH2H_ratingResultado() {
		return H2H_ratingResultado;
	}

	public void setH2H_ratingResultado(Double h2h_ratingResultado) {
		H2H_ratingResultado = h2h_ratingResultado;
	}

	public Integer getH2H_numeroJogos() {
		return H2H_numeroJogos;
	}

	public void setH2H_numeroJogos(Integer h2h_numeroJogos) {
		H2H_numeroJogos = h2h_numeroJogos;
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

	public Double getQLT_percentagemResultadoVisitadoNoIntervalo() {
		return QLT_percentagemResultadoVisitadoNoIntervalo;
	}

	public void setQLT_percentagemResultadoVisitadoNoIntervalo(Double qLT_percentagemResultadoVisitadoNoIntervalo) {
		QLT_percentagemResultadoVisitadoNoIntervalo = qLT_percentagemResultadoVisitadoNoIntervalo;
	}

	public Double getQLT_percentagemResultadoVisitanteNoIntervalo() {
		return QLT_percentagemResultadoVisitanteNoIntervalo;
	}

	public void setQLT_percentagemResultadoVisitanteNoIntervalo(Double qLT_percentagemResultadoVisitanteNoIntervalo) {
		QLT_percentagemResultadoVisitanteNoIntervalo = qLT_percentagemResultadoVisitanteNoIntervalo;
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

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Double getFR_ratingQualidadeResultadoVisitado() {
		return FR_ratingQualidadeResultadoVisitado;
	}

	public void setFR_ratingQualidadeResultadoVisitado(Double fR_ratingQualidadeResultadoVisitado) {
		this.FR_ratingQualidadeResultadoVisitado = fR_ratingQualidadeResultadoVisitado;
	}

	public Double getFR_ratingQualidadeResultadoVisitante() {
		return FR_ratingQualidadeResultadoVisitante;
	}

	public void setFR_ratingQualidadeResultadoVisitante(Double fR_ratingQualidadeResultadoVisitante) {
		this.FR_ratingQualidadeResultadoVisitante = fR_ratingQualidadeResultadoVisitante;
	}

	public Integer getQLT_numeroJogosVisitadoDaPercentagem() {
		return QLT_numeroJogosVisitadoDaPercentagem;
	}

	public void setQLT_numeroJogosVisitadoDaPercentagem(Integer qLT_numeroJogosVisitadoDaPercentagem) {
		QLT_numeroJogosVisitadoDaPercentagem = qLT_numeroJogosVisitadoDaPercentagem;
	}

	public Integer getQLT_numeroJogosVisitanteDaPercentagem() {
		return QLT_numeroJogosVisitanteDaPercentagem;
	}

	public void setQLT_numeroJogosVisitanteDaPercentagem(Integer qLT_numeroJogosVisitanteDaPercentagem) {
		QLT_numeroJogosVisitanteDaPercentagem = qLT_numeroJogosVisitanteDaPercentagem;
	}

	public Double getQLT_percentagemResultadoVisitado2() {
		return QLT_percentagemResultadoVisitado2;
	}

	public void setQLT_percentagemResultadoVisitado2(Double qLT_percentagemResultadoVisitado2) {
		QLT_percentagemResultadoVisitado2 = qLT_percentagemResultadoVisitado2;
	}

	public Double getQLT_percentagemResultadoVisitante2() {
		return QLT_percentagemResultadoVisitante2;
	}

	public void setQLT_percentagemResultadoVisitante2(Double qLT_percentagemResultadoVisitante2) {
		QLT_percentagemResultadoVisitante2 = qLT_percentagemResultadoVisitante2;
	}

	public Double getQLT_dificuldadeResultadoVisitado2() {
		return QLT_dificuldadeResultadoVisitado2;
	}

	public void setQLT_dificuldadeResultadoVisitado2(Double qLT_dificuldadeResultadoVisitado2) {
		QLT_dificuldadeResultadoVisitado2 = qLT_dificuldadeResultadoVisitado2;
	}

	public Double getQLT_dificuldadeResultadoVisitante2() {
		return QLT_dificuldadeResultadoVisitante2;
	}

	public void setQLT_dificuldadeResultadoVisitante2(Double qLT_dificuldadeResultadoVisitante2) {
		QLT_dificuldadeResultadoVisitante2 = qLT_dificuldadeResultadoVisitante2;
	}

	public Double getQLT_percentagemResultadoVisitadoNoIntervalo2() {
		return QLT_percentagemResultadoVisitadoNoIntervalo2;
	}

	public void setQLT_percentagemResultadoVisitadoNoIntervalo2(Double qLT_percentagemResultadoVisitadoNoIntervalo2) {
		QLT_percentagemResultadoVisitadoNoIntervalo2 = qLT_percentagemResultadoVisitadoNoIntervalo2;
	}

	public Double getQLT_percentagemResultadoVisitanteNoIntervalo2() {
		return QLT_percentagemResultadoVisitanteNoIntervalo2;
	}

	public void setQLT_percentagemResultadoVisitanteNoIntervalo2(Double qLT_percentagemResultadoVisitanteNoIntervalo2) {
		QLT_percentagemResultadoVisitanteNoIntervalo2 = qLT_percentagemResultadoVisitanteNoIntervalo2;
	}

	public Integer getQLT_numeroJogosVisitado2() {
		return QLT_numeroJogosVisitado2;
	}

	public void setQLT_numeroJogosVisitado2(Integer qLT_numeroJogosVisitado2) {
		QLT_numeroJogosVisitado2 = qLT_numeroJogosVisitado2;
	}

	public Integer getQLT_numeroJogosVisitante2() {
		return QLT_numeroJogosVisitante2;
	}

	public void setQLT_numeroJogosVisitante2(Integer qLT_numeroJogosVisitante2) {
		QLT_numeroJogosVisitante2 = qLT_numeroJogosVisitante2;
	}

	public Integer getH2h_Results() {
		return H2h_Results;
	}

	public void setH2h_Results(Integer h2h_Results) {
		H2h_Results = h2h_Results;
	}

	public Integer getFR_ResultadosVisitado() {
		return FR_ResultadosVisitado;
	}

	public void setFR_ResultadosVisitado(Integer fR_ResultadosVisitado) {
		FR_ResultadosVisitado = fR_ResultadosVisitado;
	}

	public Integer getFR_ResultadosVisitante() {
		return FR_ResultadosVisitante;
	}

	public void setFR_ResultadosVisitante(Integer fR_ResultadosVisitante) {
		FR_ResultadosVisitante = fR_ResultadosVisitante;
	}

	public Integer getQLT_homeTeamNumeroJogos2() {
		return QLT_homeTeamNumeroJogos2;
	}

	public void setQLT_homeTeamNumeroJogos2(Integer qLT_homeTeamNumeroJogos2) {
		QLT_homeTeamNumeroJogos2 = qLT_homeTeamNumeroJogos2;
	}

	public Integer getQLT_awayTeamNumeroJogos2() {
		return QLT_awayTeamNumeroJogos2;
	}

	public void setQLT_awayTeamNumeroJogos2(Integer qLT_awayTeamNumeroJogos2) {
		QLT_awayTeamNumeroJogos2 = qLT_awayTeamNumeroJogos2;
	}

	public Integer getGolosVisitado() {
		return golosVisitado;
	}

	public void setGolosVisitado(Integer golosVisitado) {
		this.golosVisitado = golosVisitado;
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

	public Integer getGolosVisitante() {
		return golosVisitante;
	}

	public void setGolosVisitante(Integer golosVisitante) {
		this.golosVisitante = golosVisitante;
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

	public Integer getGolosVisitadoCasa() {
		return golosVisitadoCasa;
	}

	public void setGolosVisitadoCasa(Integer golosVisitadoCasa) {
		this.golosVisitadoCasa = golosVisitadoCasa;
	}

	public Integer getGolosSofridosVisitadoCasa() {
		return golosSofridosVisitadoCasa;
	}

	public void setGolosSofridosVisitadoCasa(Integer golosSofridosVisitadoCasa) {
		this.golosSofridosVisitadoCasa = golosSofridosVisitadoCasa;
	}

	public Integer getDiferencaGolosVisitadoCasa() {
		return diferencaGolosVisitadoCasa;
	}

	public void setDiferencaGolosVisitadoCasa(Integer diferencaGolosVisitadoCasa) {
		this.diferencaGolosVisitadoCasa = diferencaGolosVisitadoCasa;
	}

	public Integer getGolosVisitanteFora() {
		return golosVisitanteFora;
	}

	public void setGolosVisitanteFora(Integer golosVisitanteFora) {
		this.golosVisitanteFora = golosVisitanteFora;
	}

	public Integer getGolosSofridosVisitanteFora() {
		return golosSofridosVisitanteFora;
	}

	public void setGolosSofridosVisitanteFora(Integer golosSofridosVisitanteFora) {
		this.golosSofridosVisitanteFora = golosSofridosVisitanteFora;
	}

	public Integer getDiferencaGolosVisitanteFora() {
		return diferencaGolosVisitanteFora;
	}

	public void setDiferencaGolosVisitanteFora(Integer diferencaGolosVisitanteFora) {
		this.diferencaGolosVisitanteFora = diferencaGolosVisitanteFora;
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

	public Double getQualidadeVisitadoCasa() {
		return qualidadeVisitadoCasa;
	}

	public void setQualidadeVisitadoCasa(Double qualidadeVisitadoCasa) {
		this.qualidadeVisitadoCasa = qualidadeVisitadoCasa;
	}

	public Double getQualidadeVisitadoFora() {
		return qualidadeVisitadoFora;
	}

	public void setQualidadeVisitadoFora(Double qualidadeVisitadoFora) {
		this.qualidadeVisitadoFora = qualidadeVisitadoFora;
	}

	public Double getQualidadeVisitanteCasa() {
		return qualidadeVisitanteCasa;
	}

	public void setQualidadeVisitanteCasa(Double qualidadeVisitanteCasa) {
		this.qualidadeVisitanteCasa = qualidadeVisitanteCasa;
	}

	public Double getQualidadeVisitanteFora() {
		return qualidadeVisitanteFora;
	}

	public void setQualidadeVisitanteFora(Double qualidadeVisitanteFora) {
		this.qualidadeVisitanteFora = qualidadeVisitanteFora;
	}

	public Integer getCiclo_numeroJogosVisitadoTotal() {
		return Ciclo_numeroJogosVisitadoTotal;
	}

	public void setCiclo_numeroJogosVisitadoTotal(Integer ciclo_numeroJogosVisitadoTotal) {
		Ciclo_numeroJogosVisitadoTotal = ciclo_numeroJogosVisitadoTotal;
	}

	public Integer getCiclo_numeroJogosVisitanteTotal() {
		return Ciclo_numeroJogosVisitanteTotal;
	}

	public void setCiclo_numeroJogosVisitanteTotal(Integer ciclo_numeroJogosVisitanteTotal) {
		Ciclo_numeroJogosVisitanteTotal = ciclo_numeroJogosVisitanteTotal;
	}

	public Double getCiclo_dificuldadeVisitadoTotal() {
		return Ciclo_dificuldadeVisitadoTotal;
	}

	public void setCiclo_dificuldadeVisitadoTotal(Double ciclo_dificuldadeVisitadoTotal) {
		Ciclo_dificuldadeVisitadoTotal = ciclo_dificuldadeVisitadoTotal;
	}

	public Double getCiclo_dificuldadeVisitanteTotal() {
		return Ciclo_dificuldadeVisitanteTotal;
	}

	public void setCiclo_dificuldadeVisitanteTotal(Double ciclo_dificuldadeVisitanteTotal) {
		Ciclo_dificuldadeVisitanteTotal = ciclo_dificuldadeVisitanteTotal;
	}

	public Integer getCiclo_HistoricosVisitadoTotal() {
		return Ciclo_HistoricosVisitadoTotal;
	}

	public void setCiclo_HistoricosVisitadoTotal(Integer ciclo_HistoricosVisitadoTotal) {
		Ciclo_HistoricosVisitadoTotal = ciclo_HistoricosVisitadoTotal;
	}

	public Integer getCiclo_HistoricosVisitanteTotal() {
		return Ciclo_HistoricosVisitanteTotal;
	}

	public void setCiclo_HistoricosVisitanteTotal(Integer ciclo_HistoricosVisitanteTotal) {
		Ciclo_HistoricosVisitanteTotal = ciclo_HistoricosVisitanteTotal;
	}

	public Integer getCicloPerna_numeroJogosVisitadoTotal() {
		return CicloPerna_numeroJogosVisitadoTotal;
	}

	public void setCicloPerna_numeroJogosVisitadoTotal(Integer cicloPerna_numeroJogosVisitadoTotal) {
		CicloPerna_numeroJogosVisitadoTotal = cicloPerna_numeroJogosVisitadoTotal;
	}

	public Integer getCicloPerna_numeroJogosVisitanteTotal() {
		return CicloPerna_numeroJogosVisitanteTotal;
	}

	public void setCicloPerna_numeroJogosVisitanteTotal(Integer cicloPerna_numeroJogosVisitanteTotal) {
		CicloPerna_numeroJogosVisitanteTotal = cicloPerna_numeroJogosVisitanteTotal;
	}

	public Double getCicloPerna_dificuldadeVisitadoTotal() {
		return CicloPerna_dificuldadeVisitadoTotal;
	}

	public void setCicloPerna_dificuldadeVisitadoTotal(Double cicloPerna_dificuldadeVisitadoTotal) {
		CicloPerna_dificuldadeVisitadoTotal = cicloPerna_dificuldadeVisitadoTotal;
	}

	public Double getCicloPerna_dificuldadeVisitanteTotal() {
		return CicloPerna_dificuldadeVisitanteTotal;
	}

	public void setCicloPerna_dificuldadeVisitanteTotal(Double cicloPerna_dificuldadeVisitanteTotal) {
		CicloPerna_dificuldadeVisitanteTotal = cicloPerna_dificuldadeVisitanteTotal;
	}

	public Integer getCicloPerna_HistoricosVisitadoTotal() {
		return CicloPerna_HistoricosVisitadoTotal;
	}

	public void setCicloPerna_HistoricosVisitadoTotal(Integer cicloPerna_HistoricosVisitadoTotal) {
		CicloPerna_HistoricosVisitadoTotal = cicloPerna_HistoricosVisitadoTotal;
	}

	public Integer getCicloPerna_HistoricosVisitanteTotal() {
		return CicloPerna_HistoricosVisitanteTotal;
	}

	public void setCicloPerna_HistoricosVisitanteTotal(Integer cicloPerna_HistoricosVisitanteTotal) {
		CicloPerna_HistoricosVisitanteTotal = cicloPerna_HistoricosVisitanteTotal;
	}

	public Double getFR_dificuldadeVisitadoHome() {
		return FR_dificuldadeVisitadoHome;
	}

	public void setFR_dificuldadeVisitadoHome(Double fR_dificuldadeVisitadoHome) {
		FR_dificuldadeVisitadoHome = fR_dificuldadeVisitadoHome;
	}

	public Double getFR_dificuldadeVisitanteAway() {
		return FR_dificuldadeVisitanteAway;
	}

	public void setFR_dificuldadeVisitanteAway(Double fR_dificuldadeVisitanteAway) {
		FR_dificuldadeVisitanteAway = fR_dificuldadeVisitanteAway;
	}

	public Integer getFR_HistoricosVisitadoHome() {
		return FR_HistoricosVisitadoHome;
	}

	public void setFR_HistoricosVisitadoHome(Integer fR_HistoricosVisitadoHome) {
		FR_HistoricosVisitadoHome = fR_HistoricosVisitadoHome;
	}

	public Integer getFR_HistoricosVisitanteAway() {
		return FR_HistoricosVisitanteAway;
	}

	public void setFR_HistoricosVisitanteAway(Integer fR_HistoricosVisitanteAway) {
		FR_HistoricosVisitanteAway = fR_HistoricosVisitanteAway;
	}

	public Double getFR_ratingResultadoVisitadoHome() {
		return FR_ratingResultadoVisitadoHome;
	}

	public void setFR_ratingResultadoVisitadoHome(Double fR_ratingResultadoVisitadoHome) {
		FR_ratingResultadoVisitadoHome = fR_ratingResultadoVisitadoHome;
	}

	public Double getFR_ratingResultadoVisitanteAway() {
		return FR_ratingResultadoVisitanteAway;
	}

	public void setFR_ratingResultadoVisitanteAway(Double fR_ratingResultadoVisitanteAway) {
		FR_ratingResultadoVisitanteAway = fR_ratingResultadoVisitanteAway;
	}

	public Integer getFR_ResultadoVisitadoHome() {
		return FR_ResultadoVisitadoHome;
	}

	public void setFR_ResultadoVisitadoHome(Integer fR_ResultadoVisitadoHome) {
		FR_ResultadoVisitadoHome = fR_ResultadoVisitadoHome;
	}

	public Integer getFR_ResultadoVisitanteAway() {
		return FR_ResultadoVisitanteAway;
	}

	public void setFR_ResultadoVisitanteAway(Integer fR_ResultadoVisitanteAway) {
		FR_ResultadoVisitanteAway = fR_ResultadoVisitanteAway;
	}

	public Double getQLT_percentagemResultadoVisitado_5jogos() {
		return QLT_percentagemResultadoVisitado_5jogos;
	}

	public void setQLT_percentagemResultadoVisitado_5jogos(Double qLT_percentagemResultadoVisitado_5jogos) {
		QLT_percentagemResultadoVisitado_5jogos = qLT_percentagemResultadoVisitado_5jogos;
	}

	public Double getQLT_percentagemResultadoVisitante_5jogos() {
		return QLT_percentagemResultadoVisitante_5jogos;
	}

	public void setQLT_percentagemResultadoVisitante_5jogos(Double qLT_percentagemResultadoVisitante_5jogos) {
		QLT_percentagemResultadoVisitante_5jogos = qLT_percentagemResultadoVisitante_5jogos;
	}

	public Double getQLT_dificuldadeResultadoVisitado_5jogos() {
		return QLT_dificuldadeResultadoVisitado_5jogos;
	}

	public void setQLT_dificuldadeResultadoVisitado_5jogos(Double qLT_dificuldadeResultadoVisitado_5jogos) {
		QLT_dificuldadeResultadoVisitado_5jogos = qLT_dificuldadeResultadoVisitado_5jogos;
	}

	public Double getQLT_dificuldadeResultadoVisitante_5jogos() {
		return QLT_dificuldadeResultadoVisitante_5jogos;
	}

	public void setQLT_dificuldadeResultadoVisitante_5jogos(Double qLT_dificuldadeResultadoVisitante_5jogos) {
		QLT_dificuldadeResultadoVisitante_5jogos = qLT_dificuldadeResultadoVisitante_5jogos;
	}

	public Double getQLT_percentagemResultadoVisitadoNoIntervalo_5jogos() {
		return QLT_percentagemResultadoVisitadoNoIntervalo_5jogos;
	}

	public void setQLT_percentagemResultadoVisitadoNoIntervalo_5jogos(
			Double qLT_percentagemResultadoVisitadoNoIntervalo_5jogos) {
		QLT_percentagemResultadoVisitadoNoIntervalo_5jogos = qLT_percentagemResultadoVisitadoNoIntervalo_5jogos;
	}

	public Double getQLT_percentagemResultadoVisitanteNoIntervalo_5jogos() {
		return QLT_percentagemResultadoVisitanteNoIntervalo_5jogos;
	}

	public void setQLT_percentagemResultadoVisitanteNoIntervalo_5jogos(
			Double qLT_percentagemResultadoVisitanteNoIntervalo_5jogos) {
		QLT_percentagemResultadoVisitanteNoIntervalo_5jogos = qLT_percentagemResultadoVisitanteNoIntervalo_5jogos;
	}

	public Integer getQLT_numeroJogosVisitado_5jogos() {
		return QLT_numeroJogosVisitado_5jogos;
	}

	public void setQLT_numeroJogosVisitado_5jogos(Integer qLT_numeroJogosVisitado_5jogos) {
		QLT_numeroJogosVisitado_5jogos = qLT_numeroJogosVisitado_5jogos;
	}

	public Integer getQLT_numeroJogosVisitante_5jogos() {
		return QLT_numeroJogosVisitante_5jogos;
	}

	public void setQLT_numeroJogosVisitante_5jogos(Integer qLT_numeroJogosVisitante_5jogos) {
		QLT_numeroJogosVisitante_5jogos = qLT_numeroJogosVisitante_5jogos;
	}

	public Double getQLT_percentagemResultadoVisitado2_5jogos() {
		return QLT_percentagemResultadoVisitado2_5jogos;
	}

	public void setQLT_percentagemResultadoVisitado2_5jogos(Double qLT_percentagemResultadoVisitado2_5jogos) {
		QLT_percentagemResultadoVisitado2_5jogos = qLT_percentagemResultadoVisitado2_5jogos;
	}

	public Double getQLT_percentagemResultadoVisitante2_5jogos() {
		return QLT_percentagemResultadoVisitante2_5jogos;
	}

	public void setQLT_percentagemResultadoVisitante2_5jogos(Double qLT_percentagemResultadoVisitante2_5jogos) {
		QLT_percentagemResultadoVisitante2_5jogos = qLT_percentagemResultadoVisitante2_5jogos;
	}

	public Double getQLT_dificuldadeResultadoVisitado2_5jogos() {
		return QLT_dificuldadeResultadoVisitado2_5jogos;
	}

	public void setQLT_dificuldadeResultadoVisitado2_5jogos(Double qLT_dificuldadeResultadoVisitado2_5jogos) {
		QLT_dificuldadeResultadoVisitado2_5jogos = qLT_dificuldadeResultadoVisitado2_5jogos;
	}

	public Double getQLT_dificuldadeResultadoVisitante2_5jogos() {
		return QLT_dificuldadeResultadoVisitante2_5jogos;
	}

	public void setQLT_dificuldadeResultadoVisitante2_5jogos(Double qLT_dificuldadeResultadoVisitante2_5jogos) {
		QLT_dificuldadeResultadoVisitante2_5jogos = qLT_dificuldadeResultadoVisitante2_5jogos;
	}

	public Double getQLT_percentagemResultadoVisitadoNoIntervalo2_5jogos() {
		return QLT_percentagemResultadoVisitadoNoIntervalo2_5jogos;
	}

	public void setQLT_percentagemResultadoVisitadoNoIntervalo2_5jogos(
			Double qLT_percentagemResultadoVisitadoNoIntervalo2_5jogos) {
		QLT_percentagemResultadoVisitadoNoIntervalo2_5jogos = qLT_percentagemResultadoVisitadoNoIntervalo2_5jogos;
	}

	public Double getQLT_percentagemResultadoVisitanteNoIntervalo2_5jogos() {
		return QLT_percentagemResultadoVisitanteNoIntervalo2_5jogos;
	}

	public void setQLT_percentagemResultadoVisitanteNoIntervalo2_5jogos(
			Double qLT_percentagemResultadoVisitanteNoIntervalo2_5jogos) {
		QLT_percentagemResultadoVisitanteNoIntervalo2_5jogos = qLT_percentagemResultadoVisitanteNoIntervalo2_5jogos;
	}

	public Integer getQLT_numeroJogosVisitado2_5jogos() {
		return QLT_numeroJogosVisitado2_5jogos;
	}

	public void setQLT_numeroJogosVisitado2_5jogos(Integer qLT_numeroJogosVisitado2_5jogos) {
		QLT_numeroJogosVisitado2_5jogos = qLT_numeroJogosVisitado2_5jogos;
	}

	public Integer getQLT_numeroJogosVisitante2_5jogos() {
		return QLT_numeroJogosVisitante2_5jogos;
	}

	public void setQLT_numeroJogosVisitante2_5jogos(Integer qLT_numeroJogosVisitante2_5jogos) {
		QLT_numeroJogosVisitante2_5jogos = qLT_numeroJogosVisitante2_5jogos;
	}

}

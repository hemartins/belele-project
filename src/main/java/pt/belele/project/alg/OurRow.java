package pt.belele.project.alg;


public class OurRow {

	Integer jornada;
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
	Double FR_dificuldadeVisistante;
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
	
	
	
	
	Integer CicloPerna_numeroJogosVisitado; // número de jogos que a equipa venceu
	// seguidos (ex: caso não tenha vencido
	// nenhum dos últimos 3 jogos é =-3;
	// caso tenha vencido os últimos 5 jogos
	// =5;
	Integer CicloPerna_numeroJogosVisitante;
	Double CicloPerna_dificuldadeVisitado; // média das qualidades dos adversários
	// desse que a equipa enfrentou nesse
	// ciclo
	Double CicloPerna_dificuldadeVisitante;
	Integer CicloPerna_HistoricosVisitado; // número de históricos que a equipa
	// enfrentou durante esse ciclo
	Integer CicloPerna_HistoricosVisitante;
	
	
	
	
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

	public OurRow(Integer jornada, Long idVisitado, Long idVisitante, String homeTeamName, String awayTeamName,
			Double qualidadeVisitado, Double qualidadeVisitante,
			Integer fR_diasDescansoVisitado, Integer fR_diasDescansoVisitante,
			Double fR_ratingResultadoVisitado,
			Double fR_ratingResultadoVisitante, Double fR_dificuldadeVisitado,
			Double fR_dificuldadeVisistante, Integer fR_HistoricosVisitado,
			Integer fR_HistoricosVisitante, Integer ciclo_numeroJogosVisitado,
			Integer ciclo_numeroJogosVisitante,
			Double ciclo_dificuldadeVisitado,
			Double ciclo_dificuldadeVisitante,
			Integer ciclo_HistoricosVisitado,
			Integer ciclo_HistoricosVisitante, Double h2h_ratingResultado,
			Integer h2h_numeroJogos, Double qLT_percentagemResultadoVisitado,
			Double qLT_percentagemResultadoVisitante,
			Double qLT_dificuldadeResultadoVisitado,
			Double qLT_dificuldadeResultadoVisitante,
			Double qLT_percentagemResultadoVisitadoNoIntervalo,
			Double qLT_percentagemResultadoVisitanteNoIntervalo,
			Integer qLT_numeroJogosVisitado, Integer qLT_numeroJogosVisitante, Integer result,
			Integer cicloPerna_numeroJogosVisitado,
			Integer cicloPerna_numeroJogosVisitante,
			Double cicloPerna_dificuldadeVisitado,
			Double cicloPerna_dificuldadeVisitante,
			Integer cicloPerna_HistoricosVisitado,
			Integer cicloPerna_HistoricosVisitante) {

		this.jornada = jornada;
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
		FR_dificuldadeVisistante = fR_dificuldadeVisistante;
		FR_HistoricosVisitado = fR_HistoricosVisitado;
		FR_HistoricosVisitante = fR_HistoricosVisitante;
		Ciclo_numeroJogosVisitado = ciclo_numeroJogosVisitado;
		Ciclo_numeroJogosVisitante = ciclo_numeroJogosVisitante;
		Ciclo_dificuldadeVisitado = ciclo_dificuldadeVisitado;
		Ciclo_dificuldadeVisitante = ciclo_dificuldadeVisitante;
		Ciclo_HistoricosVisitado = ciclo_HistoricosVisitado;
		Ciclo_HistoricosVisitante = ciclo_HistoricosVisitante;
		
		
		CicloPerna_numeroJogosVisitado = ciclo_numeroJogosVisitado;
		CicloPerna_numeroJogosVisitante = ciclo_numeroJogosVisitante;
		CicloPerna_dificuldadeVisitado = ciclo_dificuldadeVisitado;
		CicloPerna_dificuldadeVisitante = ciclo_dificuldadeVisitante;
		CicloPerna_HistoricosVisitado = ciclo_HistoricosVisitado;
		CicloPerna_HistoricosVisitante = ciclo_HistoricosVisitante;
		
		
		
		
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
	}

	public Integer getJornada() {
		return jornada;
	}

	public void setJornada(Integer jornada) {
		this.jornada = jornada;
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

	public void setFR_ratingResultadoVisitante(
			Double fR_ratingResultadoVisitante) {
		FR_ratingResultadoVisitante = fR_ratingResultadoVisitante;
	}

	public Double getFR_dificuldadeVisitado() {
		return FR_dificuldadeVisitado;
	}

	public void setFR_dificuldadeVisitado(Double fR_dificuldadeVisitado) {
		FR_dificuldadeVisitado = fR_dificuldadeVisitado;
	}

	public Double getFR_dificuldadeVisistante() {
		return FR_dificuldadeVisistante;
	}

	public void setFR_dificuldadeVisistante(Double fR_dificuldadeVisistante) {
		FR_dificuldadeVisistante = fR_dificuldadeVisistante;
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

	public void setCicloPerna_numeroJogosVisitado(Integer ciclo_numeroJogosVisitado) {
		CicloPerna_numeroJogosVisitado = ciclo_numeroJogosVisitado;
	}

	public Integer getCicloPerna_numeroJogosVisitante() {
		return CicloPerna_numeroJogosVisitante;
	}

	public void setCicloPerna_numeroJogosVisitante(Integer ciclo_numeroJogosVisitante) {
		CicloPerna_numeroJogosVisitante = ciclo_numeroJogosVisitante;
	}

	public Double getCicloPerna_dificuldadeVisitado() {
		return CicloPerna_dificuldadeVisitado;
	}

	public void setCicloPerna_dificuldadeVisitado(Double ciclo_dificuldadeVisitado) {
		CicloPerna_dificuldadeVisitado = ciclo_dificuldadeVisitado;
	}

	public Double getCicloPerna_dificuldadeVisitante() {
		return CicloPerna_dificuldadeVisitante;
	}

	public void setCicloPerna_dificuldadeVisitante(Double ciclo_dificuldadeVisitante) {
		CicloPerna_dificuldadeVisitante = ciclo_dificuldadeVisitante;
	}

	public Integer getCicloPerna_HistoricosVisitado() {
		return CicloPerna_HistoricosVisitado;
	}

	public void setCicloPerna_HistoricosVisitado(Integer ciclo_HistoricosVisitado) {
		CicloPerna_HistoricosVisitado = ciclo_HistoricosVisitado;
	}

	public Integer getCicloPerna_HistoricosVisitante() {
		return CicloPerna_HistoricosVisitante;
	}

	public void setCicloPerna_HistoricosVisitante(Integer ciclo_HistoricosVisitante) {
		CicloPerna_HistoricosVisitante = ciclo_HistoricosVisitante;
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

	public void setQLT_percentagemResultadoVisitado(
			Double qLT_percentagemResultadoVisitado) {
		QLT_percentagemResultadoVisitado = qLT_percentagemResultadoVisitado;
	}

	public Double getQLT_percentagemResultadoVisitante() {
		return QLT_percentagemResultadoVisitante;
	}

	public void setQLT_percentagemResultadoVisitante(
			Double qLT_percentagemResultadoVisitante) {
		QLT_percentagemResultadoVisitante = qLT_percentagemResultadoVisitante;
	}

	public Double getQLT_dificuldadeResultadoVisitado() {
		return QLT_dificuldadeResultadoVisitado;
	}

	public void setQLT_dificuldadeResultadoVisitado(
			Double qLT_dificuldadeResultadoVisitado) {
		QLT_dificuldadeResultadoVisitado = qLT_dificuldadeResultadoVisitado;
	}

	public Double getQLT_dificuldadeResultadoVisitante() {
		return QLT_dificuldadeResultadoVisitante;
	}

	public void setQLT_dificuldadeResultadoVisitante(
			Double qLT_dificuldadeResultadoVisitante) {
		QLT_dificuldadeResultadoVisitante = qLT_dificuldadeResultadoVisitante;
	}

	public Double getQLT_percentagemResultadoVisitadoNoIntervalo() {
		return QLT_percentagemResultadoVisitadoNoIntervalo;
	}

	public void setQLT_percentagemResultadoVisitadoNoIntervalo(
			Double qLT_percentagemResultadoVisitadoNoIntervalo) {
		QLT_percentagemResultadoVisitadoNoIntervalo = qLT_percentagemResultadoVisitadoNoIntervalo;
	}

	public Double getQLT_percentagemResultadoVisitanteNoIntervalo() {
		return QLT_percentagemResultadoVisitanteNoIntervalo;
	}

	public void setQLT_percentagemResultadoVisitanteNoIntervalo(
			Double qLT_percentagemResultadoVisitanteNoIntervalo) {
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


}

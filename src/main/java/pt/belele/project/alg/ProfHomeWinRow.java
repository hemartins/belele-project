package pt.belele.project.alg;

public class ProfHomeWinRow {

	Integer jornada;
	String idVisitado;
	String idVisitante;
	Double qualidadeVisitado; // pontos por jogo da equipa na jornada que se
								// quer prever
	Double qualidadeVisitante;
	Integer FR_diasDescansoVisitado; // diferença entre a data do jogo a
										// calcular e do jogo anterior
	Integer FR_diasDescansoFRVisitante;
	Double FR_ratingVitoriasFRVisitado; // pontuação por cada vitória obtida nos
										// últimos 5 jogos, consoante o quão
										// recente o jogo é
	Double FR_ratingDerrotasFRVisitante;
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
	Double H2H_ratingVitorias; // pontuação por cada vitória obtida nos últimos
								// jogos entre essas equipas
	Integer H2H_numeroJogos;

	public ProfHomeWinRow(Integer jornada, String idVisitado,
			String idVisitante, Double qualidadeVisitado,
			Double qualidadeVisitante, Integer fR_diasDescansoVisitado,
			Integer fR_diasDescansoFRVisitante,
			Double fR_ratingVitoriasFRVisitado,
			Double fR_ratingDerrotasFRVisitante, Double fR_dificuldadeVisitado,
			Double fR_dificuldadeVisistante, Integer fR_HistoricosVisitado,
			Integer fR_HistoricosVisitante, Integer ciclo_numeroJogosVisitado,
			Integer ciclo_numeroJogosVisitante,
			Double ciclo_dificuldadeVisitado,
			Double ciclo_dificuldadeVisitante,
			Integer ciclo_HistoricosVisitado,
			Integer ciclo_HistoricosVisitante, Double h2h_ratingVitorias,
			Integer h2h_numeroJogos) {

		this.jornada = jornada;
		this.idVisitado = idVisitado;
		this.idVisitante = idVisitante;
		this.qualidadeVisitado = qualidadeVisitado;
		this.qualidadeVisitante = qualidadeVisitante;
		FR_diasDescansoVisitado = fR_diasDescansoVisitado;
		FR_diasDescansoFRVisitante = fR_diasDescansoFRVisitante;
		FR_ratingVitoriasFRVisitado = fR_ratingVitoriasFRVisitado;
		FR_ratingDerrotasFRVisitante = fR_ratingDerrotasFRVisitante;
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
		H2H_ratingVitorias = h2h_ratingVitorias;
		H2H_numeroJogos = h2h_numeroJogos;
	}

	public Integer getJornada() {
		return jornada;
	}

	public void setJornada(Integer jornada) {
		this.jornada = jornada;
	}

	public String getIdVisitado() {
		return idVisitado;
	}

	public void setIdVisitado(String idVisitado) {
		this.idVisitado = idVisitado;
	}

	public String getIdVisitante() {
		return idVisitante;
	}

	public void setIdVisitante(String idVisitante) {
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

	public Integer getFR_diasDescansoVisitado() {
		return FR_diasDescansoVisitado;
	}

	public void setFR_diasDescansoVisitado(Integer fR_diasDescansoVisitado) {
		FR_diasDescansoVisitado = fR_diasDescansoVisitado;
	}

	public Integer getFR_diasDescansoFRVisitante() {
		return FR_diasDescansoFRVisitante;
	}

	public void setFR_diasDescansoFRVisitante(Integer fR_diasDescansoFRVisitante) {
		FR_diasDescansoFRVisitante = fR_diasDescansoFRVisitante;
	}

	public Double getFR_ratingVitoriasFRVisitado() {
		return FR_ratingVitoriasFRVisitado;
	}

	public void setFR_ratingVitoriasFRVisitado(
			Double fR_ratingVitoriasFRVisitado) {
		FR_ratingVitoriasFRVisitado = fR_ratingVitoriasFRVisitado;
	}

	public Double getFR_ratingDerrotasFRVisitante() {
		return FR_ratingDerrotasFRVisitante;
	}

	public void setFR_ratingDerrotasFRVisitante(
			Double fR_ratingDerrotasFRVisitante) {
		FR_ratingDerrotasFRVisitante = fR_ratingDerrotasFRVisitante;
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

	public Double getH2H_ratingVitorias() {
		return H2H_ratingVitorias;
	}

	public void setH2H_ratingVitorias(Double h2h_ratingVitorias) {
		H2H_ratingVitorias = h2h_ratingVitorias;
	}

	public Integer getH2H_numeroJogos() {
		return H2H_numeroJogos;
	}

	public void setH2H_numeroJogos(Integer h2h_numeroJogos) {
		H2H_numeroJogos = h2h_numeroJogos;
	}

	@Override
	public String toString()
	{
		return "ProfHomeWinRow [jornada=" + jornada + ", idVisitado=" + idVisitado + ", idVisitante=" + idVisitante + ", qualidadeVisitado="
				+ qualidadeVisitado + ", qualidadeVisitante=" + qualidadeVisitante + ", FR_diasDescansoVisitado=" + FR_diasDescansoVisitado
				+ ", FR_diasDescansoFRVisitante=" + FR_diasDescansoFRVisitante + ", FR_ratingVitoriasFRVisitado=" + FR_ratingVitoriasFRVisitado
				+ ", FR_ratingDerrotasFRVisitante=" + FR_ratingDerrotasFRVisitante + ", FR_dificuldadeVisitado=" + FR_dificuldadeVisitado
				+ ", FR_dificuldadeVisistante=" + FR_dificuldadeVisistante + ", FR_HistoricosVisitado=" + FR_HistoricosVisitado + ", FR_HistoricosVisitante="
				+ FR_HistoricosVisitante + ", Ciclo_numeroJogosVisitado=" + Ciclo_numeroJogosVisitado + ", Ciclo_numeroJogosVisitante="
				+ Ciclo_numeroJogosVisitante + ", Ciclo_dificuldadeVisitado=" + Ciclo_dificuldadeVisitado + ", Ciclo_dificuldadeVisitante="
				+ Ciclo_dificuldadeVisitante + ", Ciclo_HistoricosVisitado=" + Ciclo_HistoricosVisitado + ", Ciclo_HistoricosVisitante="
				+ Ciclo_HistoricosVisitante + ", H2H_ratingVitorias=" + H2H_ratingVitorias + ", H2H_numeroJogos=" + H2H_numeroJogos + "]";
	}
	
	

}
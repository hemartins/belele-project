package pt.belele.project.alg;

public class ProfHomeLossRow {

	Integer jornada;
	Integer idVisitado;
	Integer idVisitante;
	Double qualidadeVisitado;
	Double qualidadeVisitante;
	Integer FR_diasDescansoVisitado;
	Integer FR_diasDescansoFRVisitante;
	Double FR_ratingDerrotasFRVisitado;
	Double FR_ratingVitoriasFRVisitante;
	Double FR_dificuldadeVisitado;
	Double FR_dificuldadeVisistante;
	Integer FR_HistoricosVisitado;
	Integer FR_HistoricosVisitante;
	Integer Ciclo_numeroJogosVisitado;
	Integer Ciclo_numeroJogosVisitante;
	Integer Ciclo_dificuldadeVisitado;
	Integer Ciclo_dificuldadeVisitante;
	Integer Ciclo_HistoricosVisitado;
	Integer Ciclo_HistoricosVisitante;
	Double H2H_ratingDerrotas;
	Integer H2H_numeroJogos;

	public ProfHomeLossRow(Integer jornada, Integer idVisitado,
			Integer idVisitante, Double qualidadeVisitado,
			Double qualidadeVisitante, Integer fR_diasDescansoVisitado,
			Integer fR_diasDescansoFRVisitante,
			Double fR_ratingDerrotasFRVisitado,
			Double fR_ratingVitoriasFRVisitante, Double fR_dificuldadeVisitado,
			Double fR_dificuldadeVisistante, Integer fR_HistoricosVisitado,
			Integer fR_HistoricosVisitante, Integer ciclo_numeroJogosVisitado,
			Integer ciclo_numeroJogosVisitante,
			Integer ciclo_dificuldadeVisitado,
			Integer ciclo_dificuldadeVisitante,
			Integer ciclo_HistoricosVisitado,
			Integer ciclo_HistoricosVisitante, Double h2h_ratingDerrotas,
			Integer h2h_numeroJogos) {

		this.jornada = jornada;
		this.idVisitado = idVisitado;
		this.idVisitante = idVisitante;
		this.qualidadeVisitado = qualidadeVisitado;
		this.qualidadeVisitante = qualidadeVisitante;
		FR_diasDescansoVisitado = fR_diasDescansoVisitado;
		FR_diasDescansoFRVisitante = fR_diasDescansoFRVisitante;
		FR_ratingDerrotasFRVisitado = fR_ratingDerrotasFRVisitado;
		FR_ratingVitoriasFRVisitante = fR_ratingVitoriasFRVisitante;
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
		H2H_ratingDerrotas = h2h_ratingDerrotas;
		H2H_numeroJogos = h2h_numeroJogos;
	}

	public Integer getJornada() {
		return jornada;
	}

	public void setJornada(Integer jornada) {
		this.jornada = jornada;
	}

	public Integer getIdVisitado() {
		return idVisitado;
	}

	public void setIdVisitado(Integer idVisitado) {
		this.idVisitado = idVisitado;
	}

	public Integer getIdVisitante() {
		return idVisitante;
	}

	public void setIdVisitante(Integer idVisitante) {
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

	public Double getFR_ratingDerrotasFRVisitado() {
		return FR_ratingDerrotasFRVisitado;
	}

	public void setFR_ratingDerrotasFRVisitado(
			Double fR_ratingDerrotasFRVisitado) {
		FR_ratingDerrotasFRVisitado = fR_ratingDerrotasFRVisitado;
	}

	public Double getFR_ratingVitoriasFRVisitante() {
		return FR_ratingVitoriasFRVisitante;
	}

	public void setFR_ratingVitoriasFRVisitante(
			Double fR_ratingVitoriasFRVisitante) {
		FR_ratingVitoriasFRVisitante = fR_ratingVitoriasFRVisitante;
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

	public Integer getCiclo_dificuldadeVisitado() {
		return Ciclo_dificuldadeVisitado;
	}

	public void setCiclo_dificuldadeVisitado(Integer ciclo_dificuldadeVisitado) {
		Ciclo_dificuldadeVisitado = ciclo_dificuldadeVisitado;
	}

	public Integer getCiclo_dificuldadeVisitante() {
		return Ciclo_dificuldadeVisitante;
	}

	public void setCiclo_dificuldadeVisitante(Integer ciclo_dificuldadeVisitante) {
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

	public Double getH2H_ratingDerrotas() {
		return H2H_ratingDerrotas;
	}

	public void setH2H_ratingDerrotas(Double h2h_ratingDerrotas) {
		H2H_ratingDerrotas = h2h_ratingDerrotas;
	}

	public Integer getH2H_numeroJogos() {
		return H2H_numeroJogos;
	}

	public void setH2H_numeroJogos(Integer h2h_numeroJogos) {
		H2H_numeroJogos = h2h_numeroJogos;
	}

}

package pt.belele.project.alg;

public class OurDrawRow {

	Integer jornada;
	Double qualidadeVisitado;
	Double qualidadeVisitante;
	Integer FR_diasDescansoVisitado;
	Integer FR_diasDescansoFRVisitante;
	Double FR_ratingEmpatesFRVisitado;
	Double FR_ratingEmpatesFRVisitante;
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
	Double H2H_ratingVitorias;
	Integer H2H_numeroJogos;
	Double QLT_percentagemEmpatesVisitado;
	Double QLT_percentagemEmpatesVisitante;
	Double QLT_dificuldadeEmpatesVisitado;
	Double QLT_dificuldadeEmpatesVisitante;
	Double QLT_percentagemEmpatesVisitadoNoIntervalo;
	Double QLT_percentagemEmpatesVisitanteNoIntervalo;
	Double QLT_numeroJogosVisitado;
	Double QLT_numeroJogosVisitante;

	public OurDrawRow(Integer jornada, Double qualidadeVisitado,
			Double qualidadeVisitante, Integer fR_diasDescansoVisitado,
			Integer fR_diasDescansoFRVisitante,
			Double fR_ratingEmpatesFRVisitado,
			Double fR_ratingEmpatesFRVisitante, Double fR_dificuldadeVisitado,
			Double fR_dificuldadeVisistante, Integer fR_HistoricosVisitado,
			Integer fR_HistoricosVisitante, Integer ciclo_numeroJogosVisitado,
			Integer ciclo_numeroJogosVisitante,
			Integer ciclo_dificuldadeVisitado,
			Integer ciclo_dificuldadeVisitante,
			Integer ciclo_HistoricosVisitado,
			Integer ciclo_HistoricosVisitante, Double h2h_ratingVitorias,
			Integer h2h_numeroJogos, Double qLT_percentagemEmpatesVisitado,
			Double qLT_percentagemEmpatesVisitante,
			Double qLT_dificuldadeEmpatesVisitado,
			Double qLT_dificuldadeEmpatesVisitante,
			Double qLT_percentagemEmpatesVisitadoNoIntervalo,
			Double qLT_percentagemEmpatesVisitanteNoIntervalo,
			Double qLT_numeroJogosVisitado, Double qLT_numeroJogosVisitante) {

		this.jornada = jornada;
		this.qualidadeVisitado = qualidadeVisitado;
		this.qualidadeVisitante = qualidadeVisitante;
		FR_diasDescansoVisitado = fR_diasDescansoVisitado;
		FR_diasDescansoFRVisitante = fR_diasDescansoFRVisitante;
		FR_ratingEmpatesFRVisitado = fR_ratingEmpatesFRVisitado;
		FR_ratingEmpatesFRVisitante = fR_ratingEmpatesFRVisitante;
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
		QLT_percentagemEmpatesVisitado = qLT_percentagemEmpatesVisitado;
		QLT_percentagemEmpatesVisitante = qLT_percentagemEmpatesVisitante;
		QLT_dificuldadeEmpatesVisitado = qLT_dificuldadeEmpatesVisitado;
		QLT_dificuldadeEmpatesVisitante = qLT_dificuldadeEmpatesVisitante;
		QLT_percentagemEmpatesVisitadoNoIntervalo = qLT_percentagemEmpatesVisitadoNoIntervalo;
		QLT_percentagemEmpatesVisitanteNoIntervalo = qLT_percentagemEmpatesVisitanteNoIntervalo;
		QLT_numeroJogosVisitado = qLT_numeroJogosVisitado;
		QLT_numeroJogosVisitante = qLT_numeroJogosVisitante;
	}

	public Integer getJornada() {
		return jornada;
	}

	public void setJornada(Integer jornada) {
		this.jornada = jornada;
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

	public Double getFR_ratingEmpatesFRVisitado() {
		return FR_ratingEmpatesFRVisitado;
	}

	public void setFR_ratingEmpatesFRVisitado(Double fR_ratingEmpatesFRVisitado) {
		FR_ratingEmpatesFRVisitado = fR_ratingEmpatesFRVisitado;
	}

	public Double getFR_ratingEmpatesFRVisitante() {
		return FR_ratingEmpatesFRVisitante;
	}

	public void setFR_ratingEmpatesFRVisitante(
			Double fR_ratingEmpatesFRVisitante) {
		FR_ratingEmpatesFRVisitante = fR_ratingEmpatesFRVisitante;
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

	public Double getQLT_percentagemEmpatesVisitado() {
		return QLT_percentagemEmpatesVisitado;
	}

	public void setQLT_percentagemEmpatesVisitado(
			Double qLT_percentagemEmpatesVisitado) {
		QLT_percentagemEmpatesVisitado = qLT_percentagemEmpatesVisitado;
	}

	public Double getQLT_percentagemEmpatesVisitante() {
		return QLT_percentagemEmpatesVisitante;
	}

	public void setQLT_percentagemEmpatesVisitante(
			Double qLT_percentagemEmpatesVisitante) {
		QLT_percentagemEmpatesVisitante = qLT_percentagemEmpatesVisitante;
	}

	public Double getQLT_dificuldadeEmpatesVisitado() {
		return QLT_dificuldadeEmpatesVisitado;
	}

	public void setQLT_dificuldadeEmpatesVisitado(
			Double qLT_dificuldadeEmpatesVisitado) {
		QLT_dificuldadeEmpatesVisitado = qLT_dificuldadeEmpatesVisitado;
	}

	public Double getQLT_dificuldadeEmpatesVisitante() {
		return QLT_dificuldadeEmpatesVisitante;
	}

	public void setQLT_dificuldadeEmpatesVisitante(
			Double qLT_dificuldadeEmpatesVisitante) {
		QLT_dificuldadeEmpatesVisitante = qLT_dificuldadeEmpatesVisitante;
	}

	public Double getQLT_percentagemEmpatesVisitadoNoIntervalo() {
		return QLT_percentagemEmpatesVisitadoNoIntervalo;
	}

	public void setQLT_percentagemEmpatesVisitadoNoIntervalo(
			Double qLT_percentagemEmpatesVisitadoNoIntervalo) {
		QLT_percentagemEmpatesVisitadoNoIntervalo = qLT_percentagemEmpatesVisitadoNoIntervalo;
	}

	public Double getQLT_percentagemEmpatesVisitanteNoIntervalo() {
		return QLT_percentagemEmpatesVisitanteNoIntervalo;
	}

	public void setQLT_percentagemEmpatesVisitanteNoIntervalo(
			Double qLT_percentagemEmpatesVisitanteNoIntervalo) {
		QLT_percentagemEmpatesVisitanteNoIntervalo = qLT_percentagemEmpatesVisitanteNoIntervalo;
	}

	public Double getQLT_numeroJogosVisitado() {
		return QLT_numeroJogosVisitado;
	}

	public void setQLT_numeroJogosVisitado(Double qLT_numeroJogosVisitado) {
		QLT_numeroJogosVisitado = qLT_numeroJogosVisitado;
	}

	public Double getQLT_numeroJogosVisitante() {
		return QLT_numeroJogosVisitante;
	}

	public void setQLT_numeroJogosVisitante(Double qLT_numeroJogosVisitante) {
		QLT_numeroJogosVisitante = qLT_numeroJogosVisitante;
	}

}
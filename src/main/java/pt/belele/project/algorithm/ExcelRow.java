package pt.belele.project.algorithm;

import java.util.Date;

public class ExcelRow {
	
	//// General variables \\\\

	// Overall
	Date data;
	String nomeVisitado, nomeVisitante;
	Long idVisitado, idVisitante;
	Double qualidadeVisitado, qualidadeVisitante;
	Integer diasDescansoVisitado, diasDescansoVisitante;
	Integer classificacaoVisitado, classificacaoVisitante;
	Integer resultado;

	// Venue
	Double qualidadeVisitadoVenue, qualidadeVisitanteVenue;

	// Switched Venue
	Double qualidadeVisitadoSwitchedVenue, qualidadeVisitanteSwitchedVenue;
	

	//// Cycle variables \\\\

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

	
	//// FR variables \\\\

	// Overall
	Double FR_dificuldadeVisitado, FR_dificuldadeVisitante;
	Integer FR_historicosVisitado, FR_historicosVisitante;
	Double FR_ratingTemporalResultadoVisitado, FR_ratingTemporalResultadoVisitante;
	Integer FR_numeroResultadosVisitado, FR_numeroResultadosVisitante;
	Integer FR_numeroResultadosNoIntervaloVisitado, FR_numeroResultadosNoIntervaloVisitante;
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
	public Integer getFR_numeroResultadosNoIntervaloVisitadoVenue() {
		return FR_numeroResultadosNoIntervaloVisitadoVenue;
	}

	public void setFR_numeroResultadosNoIntervaloVisitadoVenue(Integer fR_numeroResultadosNoIntervaloVisitadoVenue) {
		FR_numeroResultadosNoIntervaloVisitadoVenue = fR_numeroResultadosNoIntervaloVisitadoVenue;
	}

	public Integer getFR_numeroResultadosNoIntervaloVisitanteVenue() {
		return FR_numeroResultadosNoIntervaloVisitanteVenue;
	}

	public void setFR_numeroResultadosNoIntervaloVisitanteVenue(Integer fR_numeroResultadosNoIntervaloVisitanteVenue) {
		FR_numeroResultadosNoIntervaloVisitanteVenue = fR_numeroResultadosNoIntervaloVisitanteVenue;
	}

	Double FR_ratingTemporalResultadoVisitadoVenue, FR_ratingTemporalResultadoVisitanteVenue;
	Integer FR_numeroResultadosVisitadoVenue, FR_numeroResultadosVisitanteVenue;
	Integer FR_numeroResultadosNoIntervaloVisitadoVenue, FR_numeroResultadosNoIntervaloVisitanteVenue;
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
	Integer FR_numeroResultadosNoIntervaloVisitadoSwitchedVenue, FR_numeroResultadosNoIntervaloVisitanteSwitchedVenue;
	Double FR_percentagemResultadoVisitadoSwitchedVenue, FR_percentagemResultadoVisitanteSwitchedVenue;
	Double FR_percentagemResultadoNoIntervaloVisitadoSwitchedVenue,
			FR_percentagemResultadoNoIntervaloVisitanteSwitchedVenue;
	Integer FR_golosMarcadosVisitadoSwitchedVenue, FR_golosSofridosVisitadoSwitchedVenue,
			FR_diferencaGolosVisitadoSwitchedVenue;
	Integer FR_golosMarcadosVisitanteSwitchedVenue, FR_golosSofridosVisitanteSwitchedVenue,
			FR_diferencaGolosVisitanteSwitchedVenue;
	Double FR_mediaGolosMarcadosVisitadoSwitchedVenue, FR_mediaGolosSofridosVisitadoSwitchedVenue;
	Double FR_mediaGolosMarcadosVisitanteSwitchedVenue, FR_mediaGolosSofridosVisitanteSwitchedVenue;

	
	//// QLT variables\\\\

	// Overall
	Integer QLT_numeroJogosVisitado, QLT_numeroJogosVisitante;
	Double QLT_percentagemResultadoVisitado, QLT_percentagemResultadoVisitante;
	Double QLT_dificuldadeResultadoVisitado, QLT_dificuldadeResultadoVisitante;
	Double QLT_percentagemResultadoNoIntervaloVisitado, QLT_percentagemResultadoNoIntervaloVisitante;
	Integer QLT_numeroJogosNoIntervaloVisitado, QLT_numeroJogosNoIntervaloVisitante;
	Integer QLT_golosMarcadosVisitado, QLT_golosSofridosVisitado, QLT_diferencaGolosVisitado;
	Integer QLT_golosMarcadosVisitante, QLT_golosSofridosVisitante, QLT_diferencaGolosVisitante;
	Double QLT_mediaGolosMarcadosVisitado, QLT_mediaGolosSofridosVisitado;
	Double QLT_mediaGolosMarcadosVisitante, QLT_mediaGolosSofridosVisitante;

	// Venue
	Integer QLT_numeroJogosVisitadoVenue, QLT_numeroJogosVisitanteVenue;
	Double QLT_percentagemResultadoVisitadoVenue, QLT_percentagemResultadoVisitanteVenue;
	Double QLT_dificuldadeResultadoVisitadoVenue, QLT_dificuldadeResultadoVisitanteVenue;
	Double QLT_percentagemResultadoNoIntervaloVisitadoVenue, QLT_percentagemResultadoNoIntervaloVisitanteVenue;
	Integer QLT_numeroJogosNoIntervaloVisitadoVenue, QLT_numeroJogosNoIntervaloVisitanteVenue;
	Integer QLT_golosMarcadosVisitadoVenue, QLT_golosSofridosVisitadoVenue, QLT_diferencaGolosVisitadoVenue;
	Integer QLT_golosMarcadosVisitanteVenue, QLT_golosSofridosVisitanteVenue, QLT_diferencaGolosVisitanteVenue;
	Double QLT_mediaGolosMarcadosVisitadoVenue, QLT_mediaGolosSofridosVisitadoVenue;
	Double QLT_mediaGolosMarcadosVisitanteVenue, QLT_mediaGolosSofridosVisitanteVenue;

	// Switched Venue
	Integer QLT_numeroJogosVisitadoSwitchedVenue, QLT_numeroJogosVisitanteSwitchedVenue;
	Double QLT_percentagemResultadoVisitadoSwitchedVenue, QLT_percentagemResultadoVisitanteSwitchedVenue;
	Double QLT_dificuldadeResultadoVisitadoSwitchedVenue, QLT_dificuldadeResultadoVisitanteSwitchedVenue;
	Double QLT_percentagemResultadoNoIntervaloVisitadoSwitchedVenue, QLT_percentagemResultadoNoIntervaloVisitanteSwitchedVenue;
	Integer QLT_numeroJogosNoIntervaloVisitadoSwitchedVenue, QLT_numeroJogosNoIntervaloVisitanteSwitchedVenue;
	Integer QLT_golosMarcadosVisitadoSwitchedVenue, QLT_golosSofridosVisitadoSwitchedVenue, QLT_diferencaGolosVisitadoSwitchedVenue;
	Integer QLT_golosMarcadosVisitanteSwitchedVenue, QLT_golosSofridosVisitanteSwitchedVenue, QLT_diferencaGolosVisitanteSwitchedVenue;
	Double QLT_mediaGolosMarcadosVisitadoSwitchedVenue, QLT_mediaGolosSofridosVisitadoSwitchedVenue;
	Double QLT_mediaGolosMarcadosVisitanteSwitchedVenue, QLT_mediaGolosSofridosVisitanteSwitchedVenue;
	

	//// H2H variables \\\\

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

	
	///////////////////////// Construtor e Getters e Setters \\\\\\\\\\\\\\\\\\\\\\\\\\\

	
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

	public Integer getDiasDescansoVisitado() {
		return diasDescansoVisitado;
	}

	public void setDiasDescansoVisitado(Integer diasDescansoVisitado) {
		this.diasDescansoVisitado = diasDescansoVisitado;
	}

	public Integer getDiasDescansoVisitante() {
		return diasDescansoVisitante;
	}

	public void setDiasDescansoVisitante(Integer diasDescansoVisitante) {
		this.diasDescansoVisitante = diasDescansoVisitante;
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

	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
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

	public Integer getFR_numeroResultadosNoIntervaloVisitado() {
		return FR_numeroResultadosNoIntervaloVisitado;
	}

	public void setFR_numeroResultadosNoIntervaloVisitado(Integer fR_numeroResultadosNoIntervaloVisitado) {
		FR_numeroResultadosNoIntervaloVisitado = fR_numeroResultadosNoIntervaloVisitado;
	}

	public Integer getFR_numeroResultadosNoIntervaloVisitante() {
		return FR_numeroResultadosNoIntervaloVisitante;
	}

	public void setFR_numeroResultadosNoIntervaloVisitante(Integer fR_numeroResultadosNoIntervaloVisitante) {
		FR_numeroResultadosNoIntervaloVisitante = fR_numeroResultadosNoIntervaloVisitante;
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

	public Integer getFR_numeroResultadosNoIntervaloVisitadoSwitchedVenue() {
		return FR_numeroResultadosNoIntervaloVisitadoSwitchedVenue;
	}

	public void setFR_numeroResultadosNoIntervaloVisitadoSwitchedVenue(
			Integer fR_numeroResultadosNoIntervaloVisitadoSwitchedVenue) {
		FR_numeroResultadosNoIntervaloVisitadoSwitchedVenue = fR_numeroResultadosNoIntervaloVisitadoSwitchedVenue;
	}

	public Integer getFR_numeroResultadosNoIntervaloVisitanteSwitchedVenue() {
		return FR_numeroResultadosNoIntervaloVisitanteSwitchedVenue;
	}

	public void setFR_numeroResultadosNoIntervaloVisitanteSwitchedVenue(
			Integer fR_numeroResultadosNoIntervaloVisitanteSwitchedVenue) {
		FR_numeroResultadosNoIntervaloVisitanteSwitchedVenue = fR_numeroResultadosNoIntervaloVisitanteSwitchedVenue;
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

	public Integer getQLT_golosMarcadosVisitado() {
		return QLT_golosMarcadosVisitado;
	}

	public void setQLT_golosMarcadosVisitado(Integer qLT_golosMarcadosVisitado) {
		QLT_golosMarcadosVisitado = qLT_golosMarcadosVisitado;
	}

	public Integer getQLT_golosSofridosVisitado() {
		return QLT_golosSofridosVisitado;
	}

	public void setQLT_golosSofridosVisitado(Integer qLT_golosSofridosVisitado) {
		QLT_golosSofridosVisitado = qLT_golosSofridosVisitado;
	}

	public Integer getQLT_diferencaGolosVisitado() {
		return QLT_diferencaGolosVisitado;
	}

	public void setQLT_diferencaGolosVisitado(Integer qLT_diferencaGolosVisitado) {
		QLT_diferencaGolosVisitado = qLT_diferencaGolosVisitado;
	}

	public Integer getQLT_golosMarcadosVisitante() {
		return QLT_golosMarcadosVisitante;
	}

	public void setQLT_golosMarcadosVisitante(Integer qLT_golosMarcadosVisitante) {
		QLT_golosMarcadosVisitante = qLT_golosMarcadosVisitante;
	}

	public Integer getQLT_golosSofridosVisitante() {
		return QLT_golosSofridosVisitante;
	}

	public void setQLT_golosSofridosVisitante(Integer qLT_golosSofridosVisitante) {
		QLT_golosSofridosVisitante = qLT_golosSofridosVisitante;
	}

	public Integer getQLT_diferencaGolosVisitante() {
		return QLT_diferencaGolosVisitante;
	}

	public void setQLT_diferencaGolosVisitante(Integer qLT_diferencaGolosVisitante) {
		QLT_diferencaGolosVisitante = qLT_diferencaGolosVisitante;
	}

	public Double getQLT_mediaGolosMarcadosVisitado() {
		return QLT_mediaGolosMarcadosVisitado;
	}

	public void setQLT_mediaGolosMarcadosVisitado(Double qLT_mediaGolosMarcadosVisitado) {
		QLT_mediaGolosMarcadosVisitado = qLT_mediaGolosMarcadosVisitado;
	}

	public Double getQLT_mediaGolosSofridosVisitado() {
		return QLT_mediaGolosSofridosVisitado;
	}

	public void setQLT_mediaGolosSofridosVisitado(Double qLT_mediaGolosSofridosVisitado) {
		QLT_mediaGolosSofridosVisitado = qLT_mediaGolosSofridosVisitado;
	}

	public Double getQLT_mediaGolosMarcadosVisitante() {
		return QLT_mediaGolosMarcadosVisitante;
	}

	public void setQLT_mediaGolosMarcadosVisitante(Double qLT_mediaGolosMarcadosVisitante) {
		QLT_mediaGolosMarcadosVisitante = qLT_mediaGolosMarcadosVisitante;
	}

	public Double getQLT_mediaGolosSofridosVisitante() {
		return QLT_mediaGolosSofridosVisitante;
	}

	public void setQLT_mediaGolosSofridosVisitante(Double qLT_mediaGolosSofridosVisitante) {
		QLT_mediaGolosSofridosVisitante = qLT_mediaGolosSofridosVisitante;
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

	public Integer getQLT_golosMarcadosVisitadoVenue() {
		return QLT_golosMarcadosVisitadoVenue;
	}

	public void setQLT_golosMarcadosVisitadoVenue(Integer qLT_golosMarcadosVisitadoVenue) {
		QLT_golosMarcadosVisitadoVenue = qLT_golosMarcadosVisitadoVenue;
	}

	public Integer getQLT_golosSofridosVisitadoVenue() {
		return QLT_golosSofridosVisitadoVenue;
	}

	public void setQLT_golosSofridosVisitadoVenue(Integer qLT_golosSofridosVisitadoVenue) {
		QLT_golosSofridosVisitadoVenue = qLT_golosSofridosVisitadoVenue;
	}

	public Integer getQLT_diferencaGolosVisitadoVenue() {
		return QLT_diferencaGolosVisitadoVenue;
	}

	public void setQLT_diferencaGolosVisitadoVenue(Integer qLT_diferencaGolosVisitadoVenue) {
		QLT_diferencaGolosVisitadoVenue = qLT_diferencaGolosVisitadoVenue;
	}

	public Integer getQLT_golosMarcadosVisitanteVenue() {
		return QLT_golosMarcadosVisitanteVenue;
	}

	public void setQLT_golosMarcadosVisitanteVenue(Integer qLT_golosMarcadosVisitanteVenue) {
		QLT_golosMarcadosVisitanteVenue = qLT_golosMarcadosVisitanteVenue;
	}

	public Integer getQLT_golosSofridosVisitanteVenue() {
		return QLT_golosSofridosVisitanteVenue;
	}

	public void setQLT_golosSofridosVisitanteVenue(Integer qLT_golosSofridosVisitanteVenue) {
		QLT_golosSofridosVisitanteVenue = qLT_golosSofridosVisitanteVenue;
	}

	public Integer getQLT_diferencaGolosVisitanteVenue() {
		return QLT_diferencaGolosVisitanteVenue;
	}

	public void setQLT_diferencaGolosVisitanteVenue(Integer qLT_diferencaGolosVisitanteVenue) {
		QLT_diferencaGolosVisitanteVenue = qLT_diferencaGolosVisitanteVenue;
	}

	public Double getQLT_mediaGolosMarcadosVisitadoVenue() {
		return QLT_mediaGolosMarcadosVisitadoVenue;
	}

	public void setQLT_mediaGolosMarcadosVisitadoVenue(Double qLT_mediaGolosMarcadosVisitadoVenue) {
		QLT_mediaGolosMarcadosVisitadoVenue = qLT_mediaGolosMarcadosVisitadoVenue;
	}

	public Double getQLT_mediaGolosSofridosVisitadoVenue() {
		return QLT_mediaGolosSofridosVisitadoVenue;
	}

	public void setQLT_mediaGolosSofridosVisitadoVenue(Double qLT_mediaGolosSofridosVisitadoVenue) {
		QLT_mediaGolosSofridosVisitadoVenue = qLT_mediaGolosSofridosVisitadoVenue;
	}

	public Double getQLT_mediaGolosMarcadosVisitanteVenue() {
		return QLT_mediaGolosMarcadosVisitanteVenue;
	}

	public void setQLT_mediaGolosMarcadosVisitanteVenue(Double qLT_mediaGolosMarcadosVisitanteVenue) {
		QLT_mediaGolosMarcadosVisitanteVenue = qLT_mediaGolosMarcadosVisitanteVenue;
	}

	public Double getQLT_mediaGolosSofridosVisitanteVenue() {
		return QLT_mediaGolosSofridosVisitanteVenue;
	}

	public void setQLT_mediaGolosSofridosVisitanteVenue(Double qLT_mediaGolosSofridosVisitanteVenue) {
		QLT_mediaGolosSofridosVisitanteVenue = qLT_mediaGolosSofridosVisitanteVenue;
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

	public Integer getQLT_golosMarcadosVisitadoSwitchedVenue() {
		return QLT_golosMarcadosVisitadoSwitchedVenue;
	}

	public void setQLT_golosMarcadosVisitadoSwitchedVenue(Integer qLT_golosMarcadosVisitadoSwitchedVenue) {
		QLT_golosMarcadosVisitadoSwitchedVenue = qLT_golosMarcadosVisitadoSwitchedVenue;
	}

	public Integer getQLT_golosSofridosVisitadoSwitchedVenue() {
		return QLT_golosSofridosVisitadoSwitchedVenue;
	}

	public void setQLT_golosSofridosVisitadoSwitchedVenue(Integer qLT_golosSofridosVisitadoSwitchedVenue) {
		QLT_golosSofridosVisitadoSwitchedVenue = qLT_golosSofridosVisitadoSwitchedVenue;
	}

	public Integer getQLT_diferencaGolosVisitadoSwitchedVenue() {
		return QLT_diferencaGolosVisitadoSwitchedVenue;
	}

	public void setQLT_diferencaGolosVisitadoSwitchedVenue(Integer qLT_diferencaGolosVisitadoSwitchedVenue) {
		QLT_diferencaGolosVisitadoSwitchedVenue = qLT_diferencaGolosVisitadoSwitchedVenue;
	}

	public Integer getQLT_golosMarcadosVisitanteSwitchedVenue() {
		return QLT_golosMarcadosVisitanteSwitchedVenue;
	}

	public void setQLT_golosMarcadosVisitanteSwitchedVenue(Integer qLT_golosMarcadosVisitanteSwitchedVenue) {
		QLT_golosMarcadosVisitanteSwitchedVenue = qLT_golosMarcadosVisitanteSwitchedVenue;
	}

	public Integer getQLT_golosSofridosVisitanteSwitchedVenue() {
		return QLT_golosSofridosVisitanteSwitchedVenue;
	}

	public void setQLT_golosSofridosVisitanteSwitchedVenue(Integer qLT_golosSofridosVisitanteSwitchedVenue) {
		QLT_golosSofridosVisitanteSwitchedVenue = qLT_golosSofridosVisitanteSwitchedVenue;
	}

	public Integer getQLT_diferencaGolosVisitanteSwitchedVenue() {
		return QLT_diferencaGolosVisitanteSwitchedVenue;
	}

	public void setQLT_diferencaGolosVisitanteSwitchedVenue(Integer qLT_diferencaGolosVisitanteSwitchedVenue) {
		QLT_diferencaGolosVisitanteSwitchedVenue = qLT_diferencaGolosVisitanteSwitchedVenue;
	}

	public Double getQLT_mediaGolosMarcadosVisitadoSwitchedVenue() {
		return QLT_mediaGolosMarcadosVisitadoSwitchedVenue;
	}

	public void setQLT_mediaGolosMarcadosVisitadoSwitchedVenue(Double qLT_mediaGolosMarcadosVisitadoSwitchedVenue) {
		QLT_mediaGolosMarcadosVisitadoSwitchedVenue = qLT_mediaGolosMarcadosVisitadoSwitchedVenue;
	}

	public Double getQLT_mediaGolosSofridosVisitadoSwitchedVenue() {
		return QLT_mediaGolosSofridosVisitadoSwitchedVenue;
	}

	public void setQLT_mediaGolosSofridosVisitadoSwitchedVenue(Double qLT_mediaGolosSofridosVisitadoSwitchedVenue) {
		QLT_mediaGolosSofridosVisitadoSwitchedVenue = qLT_mediaGolosSofridosVisitadoSwitchedVenue;
	}

	public Double getQLT_mediaGolosMarcadosVisitanteSwitchedVenue() {
		return QLT_mediaGolosMarcadosVisitanteSwitchedVenue;
	}

	public void setQLT_mediaGolosMarcadosVisitanteSwitchedVenue(Double qLT_mediaGolosMarcadosVisitanteSwitchedVenue) {
		QLT_mediaGolosMarcadosVisitanteSwitchedVenue = qLT_mediaGolosMarcadosVisitanteSwitchedVenue;
	}

	public Double getQLT_mediaGolosSofridosVisitanteSwitchedVenue() {
		return QLT_mediaGolosSofridosVisitanteSwitchedVenue;
	}

	public void setQLT_mediaGolosSofridosVisitanteSwitchedVenue(Double qLT_mediaGolosSofridosVisitanteSwitchedVenue) {
		QLT_mediaGolosSofridosVisitanteSwitchedVenue = qLT_mediaGolosSofridosVisitanteSwitchedVenue;
	}

	public Double getH2H_ratingTemporalResultado() {
		return h2h_ratingTemporalResultado;
	}

	public void setH2H_ratingTemporalResultado(Double h2h_ratingTemporalResultado) {
		this.h2h_ratingTemporalResultado = h2h_ratingTemporalResultado;
	}

	public Integer getH2H_numeroJogos() {
		return h2h_numeroJogos;
	}

	public void setH2H_numeroJogos(Integer h2h_numeroJogos) {
		this.h2h_numeroJogos = h2h_numeroJogos;
	}

	public Integer getH2H_numeroResultados() {
		return h2h_numeroResultados;
	}

	public void setH2H_numeroResultados(Integer h2h_numeroResultados) {
		this.h2h_numeroResultados = h2h_numeroResultados;
	}

	public Double getH2H_percentagemResultados() {
		return h2h_percentagemResultados;
	}

	public void setH2H_percentagemResultados(Double h2h_percentagemResultados) {
		this.h2h_percentagemResultados = h2h_percentagemResultados;
	}

	public Double getH2H_ratingTemporalResultadoVenue() {
		return h2h_ratingTemporalResultadoVenue;
	}

	public void setH2H_ratingTemporalResultadoVenue(Double h2h_ratingTemporalResultadoVenue) {
		this.h2h_ratingTemporalResultadoVenue = h2h_ratingTemporalResultadoVenue;
	}

	public Integer getH2H_numeroJogosVenue() {
		return h2h_numeroJogosVenue;
	}

	public void setH2H_numeroJogosVenue(Integer h2h_numeroJogosVenue) {
		this.h2h_numeroJogosVenue = h2h_numeroJogosVenue;
	}

	public Integer getH2H_numeroResultadosVenue() {
		return h2h_numeroResultadosVenue;
	}

	public void setH2H_numeroResultadosVenue(Integer h2h_numeroResultadosVenue) {
		this.h2h_numeroResultadosVenue = h2h_numeroResultadosVenue;
	}

	public Double getH2H_percentagemResultadosVenue() {
		return h2h_percentagemResultadosVenue;
	}

	public void setH2H_percentagemResultadosVenue(Double h2h_percentagemResultadosVenue) {
		this.h2h_percentagemResultadosVenue = h2h_percentagemResultadosVenue;
	}

	public Double getH2H_ratingTemporalResultadoSwitchedVenue() {
		return h2h_ratingTemporalResultadoSwitchedVenue;
	}

	public void setH2H_ratingTemporalResultadoSwitchedVenue(Double h2h_ratingTemporalResultadoSwitchedVenue) {
		this.h2h_ratingTemporalResultadoSwitchedVenue = h2h_ratingTemporalResultadoSwitchedVenue;
	}

	public Integer getH2H_numeroJogosSwitchedVenue() {
		return h2h_numeroJogosSwitchedVenue;
	}

	public void setH2H_numeroJogosSwitchedVenue(Integer h2h_numeroJogosSwitchedVenue) {
		this.h2h_numeroJogosSwitchedVenue = h2h_numeroJogosSwitchedVenue;
	}

	public Integer getH2H_numeroResultadosSwitchedVenue() {
		return h2h_numeroResultadosSwitchedVenue;
	}

	public void setH2H_numeroResultadosSwitchedVenue(Integer h2h_numeroResultadosSwitchedVenue) {
		this.h2h_numeroResultadosSwitchedVenue = h2h_numeroResultadosSwitchedVenue;
	}

	public Double getH2H_percentagemResultadosSwitchedVenue() {
		return h2h_percentagemResultadosSwitchedVenue;
	}

	public void setH2H_percentagemResultadosSwitchedVenue(Double h2h_percentagemResultadosSwitchedVenue) {
		this.h2h_percentagemResultadosSwitchedVenue = h2h_percentagemResultadosSwitchedVenue;
	}

}

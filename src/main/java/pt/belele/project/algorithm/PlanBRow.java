package pt.belele.project.algorithm;

import java.util.Date;

public class PlanBRow {
	
	Date data;
	String visitado, visitante;
	Integer class_visitado, class_visitante, result;
	Integer QLT_Top_Visitado;     
	Integer QLT_Ms_Visitado;      
	Integer QLT_Mi_Visitado;      
	Integer QLT_Fraco_Visitado; 
	Integer QLT_Top_Visitante;    
	Integer QLT_Ms_Visitante;     
	Integer QLT_Mi_Visitante;     
	Integer QLT_Fraco_Visitante;  
	Integer Ciclo_Top_Visitado;   
	Integer Ciclo_Ms_Visitado;    
	Integer Ciclo_Mi_Visitado;    
	Integer Ciclo_Fraco_Visitado; 
	Integer Ciclo_Top_Visitante;  
	Integer Ciclo_Ms_Visitante;   
	Integer Ciclo_Mi_Visitante;   
	Integer Ciclo_Fraco_Visitante;
	Integer FR_Top_Visitado_1;    
	Integer FR_Top_Visitado_2;    
	Integer FR_Top_Visitado_3;    
	Integer FR_Top_Visitado_4;    
	Integer FR_Top_Visitado_5;    
	Integer FR_Ms_Visitado_1;     
	Integer FR_Ms_Visitado_2;     
	Integer FR_Ms_Visitado_3;     
	Integer FR_Ms_Visitado_4;     
	Integer FR_Ms_Visitado_5;     
	Integer FR_Mi_Visitado_1;     
	Integer FR_Mi_Visitado_2;     
	Integer FR_Mi_Visitado_3;     
	Integer FR_Mi_Visitado_4;     
	Integer FR_Mi_Visitado_5;     
	Integer FR_Fraco_Visitado_1;  
	Integer FR_Fraco_Visitado_2;  
	Integer FR_Fraco_Visitado_3;  
	Integer FR_Fraco_Visitado_4;  
	Integer FR_Fraco_Visitado_5;  
	Integer FR_Top_Visitante_1;   
	Integer FR_Top_Visitante_2;   
	Integer FR_Top_Visitante_3;   
	Integer FR_Top_Visitante_4;   
	Integer FR_Top_Visitante_5;   
	Integer FR_Ms_Visitante_1;    
	Integer FR_Ms_Visitante_2;    
	Integer FR_Ms_Visitante_3;    
	Integer FR_Ms_Visitante_4;    
	Integer FR_Ms_Visitante_5;    
	Integer FR_Mi_Visitante_1;    
	Integer FR_Mi_Visitante_2;    
	Integer FR_Mi_Visitante_3;    
	Integer FR_Mi_Visitante_4;    
	Integer FR_Mi_Visitante_5;    
	Integer FR_Fraco_Visitante_1; 
	Integer FR_Fraco_Visitante_2; 
	Integer FR_Fraco_Visitante_3; 
	Integer FR_Fraco_Visitante_4; 
	Integer FR_Fraco_Visitante_5; 
	Integer H2h_1, H2h_2, H2h_3, H2h_4, H2h_5, H2h_6, H2h_7, H2h_8, H2h_9, H2h_10;
	Double Odd_favor, Odd_contra;
	
	public PlanBRow(Date data, String visitado, String visitante, Integer class_visitado, Integer class_visitante,
			Integer result, Integer qLT_Top_Visitado, Integer qLT_Ms_Visitado, Integer qLT_Mi_Visitado,
			Integer qLT_Fraco_Visitado, Integer qLT_Top_Visitante, Integer qLT_Ms_Visitante, Integer qLT_Mi_Visitante,
			Integer qLT_Fraco_Visitante, Integer ciclo_Top_Visitado, Integer ciclo_Ms_Visitado,
			Integer ciclo_Mi_Visitado, Integer ciclo_Fraco_Visitado, Integer ciclo_Top_Visitante,
			Integer ciclo_Ms_Visitante, Integer ciclo_Mi_Visitante, Integer ciclo_Fraco_Visitante,
			Integer fR_Top_Visitado_1, Integer fR_Top_Visitado_2, Integer fR_Top_Visitado_3, Integer fR_Top_Visitado_4,
			Integer fR_Top_Visitado_5, Integer fR_Ms_Visitado_1, Integer fR_Ms_Visitado_2, Integer fR_Ms_Visitado_3,
			Integer fR_Ms_Visitado_4, Integer fR_Ms_Visitado_5, Integer fR_Mi_Visitado_1, Integer fR_Mi_Visitado_2,
			Integer fR_Mi_Visitado_3, Integer fR_Mi_Visitado_4, Integer fR_Mi_Visitado_5, Integer fR_Fraco_Visitado_1,
			Integer fR_Fraco_Visitado_2, Integer fR_Fraco_Visitado_3, Integer fR_Fraco_Visitado_4,
			Integer fR_Fraco_Visitado_5, Integer fR_Top_Visitante_1, Integer fR_Top_Visitante_2,
			Integer fR_Top_Visitante_3, Integer fR_Top_Visitante_4, Integer fR_Top_Visitante_5,
			Integer fR_Ms_Visitante_1, Integer fR_Ms_Visitante_2, Integer fR_Ms_Visitante_3, Integer fR_Ms_Visitante_4,
			Integer fR_Ms_Visitante_5, Integer fR_Mi_Visitante_1, Integer fR_Mi_Visitante_2, Integer fR_Mi_Visitante_3,
			Integer fR_Mi_Visitante_4, Integer fR_Mi_Visitante_5, Integer fR_Fraco_Visitante_1,
			Integer fR_Fraco_Visitante_2, Integer fR_Fraco_Visitante_3, Integer fR_Fraco_Visitante_4,
			Integer fR_Fraco_Visitante_5, Integer h2h_1, Integer h2h_2, Integer h2h_3, Integer h2h_4, Integer h2h_5,
			Integer h2h_6, Integer h2h_7, Integer h2h_8, Integer h2h_9, Integer h2h_10, Double odd_favor,
			Double odd_contra) {
		super();
		this.data = data;
		this.visitado = visitado;
		this.visitante = visitante;
		this.class_visitado = class_visitado;
		this.class_visitante = class_visitante;
		this.result = result;
		QLT_Top_Visitado = qLT_Top_Visitado;
		QLT_Ms_Visitado = qLT_Ms_Visitado;
		QLT_Mi_Visitado = qLT_Mi_Visitado;
		QLT_Fraco_Visitado = qLT_Fraco_Visitado;
		QLT_Top_Visitante = qLT_Top_Visitante;
		QLT_Ms_Visitante = qLT_Ms_Visitante;
		QLT_Mi_Visitante = qLT_Mi_Visitante;
		QLT_Fraco_Visitante = qLT_Fraco_Visitante;
		Ciclo_Top_Visitado = ciclo_Top_Visitado;
		Ciclo_Ms_Visitado = ciclo_Ms_Visitado;
		Ciclo_Mi_Visitado = ciclo_Mi_Visitado;
		Ciclo_Fraco_Visitado = ciclo_Fraco_Visitado;
		Ciclo_Top_Visitante = ciclo_Top_Visitante;
		Ciclo_Ms_Visitante = ciclo_Ms_Visitante;
		Ciclo_Mi_Visitante = ciclo_Mi_Visitante;
		Ciclo_Fraco_Visitante = ciclo_Fraco_Visitante;
		FR_Top_Visitado_1 = fR_Top_Visitado_1;
		FR_Top_Visitado_2 = fR_Top_Visitado_2;
		FR_Top_Visitado_3 = fR_Top_Visitado_3;
		FR_Top_Visitado_4 = fR_Top_Visitado_4;
		FR_Top_Visitado_5 = fR_Top_Visitado_5;
		FR_Ms_Visitado_1 = fR_Ms_Visitado_1;
		FR_Ms_Visitado_2 = fR_Ms_Visitado_2;
		FR_Ms_Visitado_3 = fR_Ms_Visitado_3;
		FR_Ms_Visitado_4 = fR_Ms_Visitado_4;
		FR_Ms_Visitado_5 = fR_Ms_Visitado_5;
		FR_Mi_Visitado_1 = fR_Mi_Visitado_1;
		FR_Mi_Visitado_2 = fR_Mi_Visitado_2;
		FR_Mi_Visitado_3 = fR_Mi_Visitado_3;
		FR_Mi_Visitado_4 = fR_Mi_Visitado_4;
		FR_Mi_Visitado_5 = fR_Mi_Visitado_5;
		FR_Fraco_Visitado_1 = fR_Fraco_Visitado_1;
		FR_Fraco_Visitado_2 = fR_Fraco_Visitado_2;
		FR_Fraco_Visitado_3 = fR_Fraco_Visitado_3;
		FR_Fraco_Visitado_4 = fR_Fraco_Visitado_4;
		FR_Fraco_Visitado_5 = fR_Fraco_Visitado_5;
		FR_Top_Visitante_1 = fR_Top_Visitante_1;
		FR_Top_Visitante_2 = fR_Top_Visitante_2;
		FR_Top_Visitante_3 = fR_Top_Visitante_3;
		FR_Top_Visitante_4 = fR_Top_Visitante_4;
		FR_Top_Visitante_5 = fR_Top_Visitante_5;
		FR_Ms_Visitante_1 = fR_Ms_Visitante_1;
		FR_Ms_Visitante_2 = fR_Ms_Visitante_2;
		FR_Ms_Visitante_3 = fR_Ms_Visitante_3;
		FR_Ms_Visitante_4 = fR_Ms_Visitante_4;
		FR_Ms_Visitante_5 = fR_Ms_Visitante_5;
		FR_Mi_Visitante_1 = fR_Mi_Visitante_1;
		FR_Mi_Visitante_2 = fR_Mi_Visitante_2;
		FR_Mi_Visitante_3 = fR_Mi_Visitante_3;
		FR_Mi_Visitante_4 = fR_Mi_Visitante_4;
		FR_Mi_Visitante_5 = fR_Mi_Visitante_5;
		FR_Fraco_Visitante_1 = fR_Fraco_Visitante_1;
		FR_Fraco_Visitante_2 = fR_Fraco_Visitante_2;
		FR_Fraco_Visitante_3 = fR_Fraco_Visitante_3;
		FR_Fraco_Visitante_4 = fR_Fraco_Visitante_4;
		FR_Fraco_Visitante_5 = fR_Fraco_Visitante_5;
		H2h_1 = h2h_1;
		H2h_2 = h2h_2;
		H2h_3 = h2h_3;
		H2h_4 = h2h_4;
		H2h_5 = h2h_5;
		H2h_6 = h2h_6;
		H2h_7 = h2h_7;
		H2h_8 = h2h_8;
		H2h_9 = h2h_9;
		H2h_10 = h2h_10;
		Odd_favor = odd_favor;
		Odd_contra = odd_contra;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getVisitado() {
		return visitado;
	}

	public void setVisitado(String visitado) {
		this.visitado = visitado;
	}

	public String getVisitante() {
		return visitante;
	}

	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	public Integer getClass_visitado() {
		return class_visitado;
	}

	public void setClass_visitado(Integer class_visitado) {
		this.class_visitado = class_visitado;
	}

	public Integer getClass_visitante() {
		return class_visitante;
	}

	public void setClass_visitante(Integer class_visitante) {
		this.class_visitante = class_visitante;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Integer getQLT_Top_Visitado() {
		return QLT_Top_Visitado;
	}

	public void setQLT_Top_Visitado(Integer qLT_Top_Visitado) {
		QLT_Top_Visitado = qLT_Top_Visitado;
	}

	public Integer getQLT_Ms_Visitado() {
		return QLT_Ms_Visitado;
	}

	public void setQLT_Ms_Visitado(Integer qLT_Ms_Visitado) {
		QLT_Ms_Visitado = qLT_Ms_Visitado;
	}

	public Integer getQLT_Mi_Visitado() {
		return QLT_Mi_Visitado;
	}

	public void setQLT_Mi_Visitado(Integer qLT_Mi_Visitado) {
		QLT_Mi_Visitado = qLT_Mi_Visitado;
	}

	public Integer getQLT_Fraco_Visitado() {
		return QLT_Fraco_Visitado;
	}

	public void setQLT_Fraco_Visitado(Integer qLT_Fraco_Visitado) {
		QLT_Fraco_Visitado = qLT_Fraco_Visitado;
	}

	public Integer getQLT_Top_Visitante() {
		return QLT_Top_Visitante;
	}

	public void setQLT_Top_Visitante(Integer qLT_Top_Visitante) {
		QLT_Top_Visitante = qLT_Top_Visitante;
	}

	public Integer getQLT_Ms_Visitante() {
		return QLT_Ms_Visitante;
	}

	public void setQLT_Ms_Visitante(Integer qLT_Ms_Visitante) {
		QLT_Ms_Visitante = qLT_Ms_Visitante;
	}

	public Integer getQLT_Mi_Visitante() {
		return QLT_Mi_Visitante;
	}

	public void setQLT_Mi_Visitante(Integer qLT_Mi_Visitante) {
		QLT_Mi_Visitante = qLT_Mi_Visitante;
	}

	public Integer getQLT_Fraco_Visitante() {
		return QLT_Fraco_Visitante;
	}

	public void setQLT_Fraco_Visitante(Integer qLT_Fraco_Visitante) {
		QLT_Fraco_Visitante = qLT_Fraco_Visitante;
	}

	public Integer getCiclo_Top_Visitado() {
		return Ciclo_Top_Visitado;
	}

	public void setCiclo_Top_Visitado(Integer ciclo_Top_Visitado) {
		Ciclo_Top_Visitado = ciclo_Top_Visitado;
	}

	public Integer getCiclo_Ms_Visitado() {
		return Ciclo_Ms_Visitado;
	}

	public void setCiclo_Ms_Visitado(Integer ciclo_Ms_Visitado) {
		Ciclo_Ms_Visitado = ciclo_Ms_Visitado;
	}

	public Integer getCiclo_Mi_Visitado() {
		return Ciclo_Mi_Visitado;
	}

	public void setCiclo_Mi_Visitado(Integer ciclo_Mi_Visitado) {
		Ciclo_Mi_Visitado = ciclo_Mi_Visitado;
	}

	public Integer getCiclo_Fraco_Visitado() {
		return Ciclo_Fraco_Visitado;
	}

	public void setCiclo_Fraco_Visitado(Integer ciclo_Fraco_Visitado) {
		Ciclo_Fraco_Visitado = ciclo_Fraco_Visitado;
	}

	public Integer getCiclo_Top_Visitante() {
		return Ciclo_Top_Visitante;
	}

	public void setCiclo_Top_Visitante(Integer ciclo_Top_Visitante) {
		Ciclo_Top_Visitante = ciclo_Top_Visitante;
	}

	public Integer getCiclo_Ms_Visitante() {
		return Ciclo_Ms_Visitante;
	}

	public void setCiclo_Ms_Visitante(Integer ciclo_Ms_Visitante) {
		Ciclo_Ms_Visitante = ciclo_Ms_Visitante;
	}

	public Integer getCiclo_Mi_Visitante() {
		return Ciclo_Mi_Visitante;
	}

	public void setCiclo_Mi_Visitante(Integer ciclo_Mi_Visitante) {
		Ciclo_Mi_Visitante = ciclo_Mi_Visitante;
	}

	public Integer getCiclo_Fraco_Visitante() {
		return Ciclo_Fraco_Visitante;
	}

	public void setCiclo_Fraco_Visitante(Integer ciclo_Fraco_Visitante) {
		Ciclo_Fraco_Visitante = ciclo_Fraco_Visitante;
	}

	public Integer getFR_Top_Visitado_1() {
		return FR_Top_Visitado_1;
	}

	public void setFR_Top_Visitado_1(Integer fR_Top_Visitado_1) {
		FR_Top_Visitado_1 = fR_Top_Visitado_1;
	}

	public Integer getFR_Top_Visitado_2() {
		return FR_Top_Visitado_2;
	}

	public void setFR_Top_Visitado_2(Integer fR_Top_Visitado_2) {
		FR_Top_Visitado_2 = fR_Top_Visitado_2;
	}

	public Integer getFR_Top_Visitado_3() {
		return FR_Top_Visitado_3;
	}

	public void setFR_Top_Visitado_3(Integer fR_Top_Visitado_3) {
		FR_Top_Visitado_3 = fR_Top_Visitado_3;
	}

	public Integer getFR_Top_Visitado_4() {
		return FR_Top_Visitado_4;
	}

	public void setFR_Top_Visitado_4(Integer fR_Top_Visitado_4) {
		FR_Top_Visitado_4 = fR_Top_Visitado_4;
	}

	public Integer getFR_Top_Visitado_5() {
		return FR_Top_Visitado_5;
	}

	public void setFR_Top_Visitado_5(Integer fR_Top_Visitado_5) {
		FR_Top_Visitado_5 = fR_Top_Visitado_5;
	}

	public Integer getFR_Ms_Visitado_1() {
		return FR_Ms_Visitado_1;
	}

	public void setFR_Ms_Visitado_1(Integer fR_Ms_Visitado_1) {
		FR_Ms_Visitado_1 = fR_Ms_Visitado_1;
	}

	public Integer getFR_Ms_Visitado_2() {
		return FR_Ms_Visitado_2;
	}

	public void setFR_Ms_Visitado_2(Integer fR_Ms_Visitado_2) {
		FR_Ms_Visitado_2 = fR_Ms_Visitado_2;
	}

	public Integer getFR_Ms_Visitado_3() {
		return FR_Ms_Visitado_3;
	}

	public void setFR_Ms_Visitado_3(Integer fR_Ms_Visitado_3) {
		FR_Ms_Visitado_3 = fR_Ms_Visitado_3;
	}

	public Integer getFR_Ms_Visitado_4() {
		return FR_Ms_Visitado_4;
	}

	public void setFR_Ms_Visitado_4(Integer fR_Ms_Visitado_4) {
		FR_Ms_Visitado_4 = fR_Ms_Visitado_4;
	}

	public Integer getFR_Ms_Visitado_5() {
		return FR_Ms_Visitado_5;
	}

	public void setFR_Ms_Visitado_5(Integer fR_Ms_Visitado_5) {
		FR_Ms_Visitado_5 = fR_Ms_Visitado_5;
	}

	public Integer getFR_Mi_Visitado_1() {
		return FR_Mi_Visitado_1;
	}

	public void setFR_Mi_Visitado_1(Integer fR_Mi_Visitado_1) {
		FR_Mi_Visitado_1 = fR_Mi_Visitado_1;
	}

	public Integer getFR_Mi_Visitado_2() {
		return FR_Mi_Visitado_2;
	}

	public void setFR_Mi_Visitado_2(Integer fR_Mi_Visitado_2) {
		FR_Mi_Visitado_2 = fR_Mi_Visitado_2;
	}

	public Integer getFR_Mi_Visitado_3() {
		return FR_Mi_Visitado_3;
	}

	public void setFR_Mi_Visitado_3(Integer fR_Mi_Visitado_3) {
		FR_Mi_Visitado_3 = fR_Mi_Visitado_3;
	}

	public Integer getFR_Mi_Visitado_4() {
		return FR_Mi_Visitado_4;
	}

	public void setFR_Mi_Visitado_4(Integer fR_Mi_Visitado_4) {
		FR_Mi_Visitado_4 = fR_Mi_Visitado_4;
	}

	public Integer getFR_Mi_Visitado_5() {
		return FR_Mi_Visitado_5;
	}

	public void setFR_Mi_Visitado_5(Integer fR_Mi_Visitado_5) {
		FR_Mi_Visitado_5 = fR_Mi_Visitado_5;
	}

	public Integer getFR_Fraco_Visitado_1() {
		return FR_Fraco_Visitado_1;
	}

	public void setFR_Fraco_Visitado_1(Integer fR_Fraco_Visitado_1) {
		FR_Fraco_Visitado_1 = fR_Fraco_Visitado_1;
	}

	public Integer getFR_Fraco_Visitado_2() {
		return FR_Fraco_Visitado_2;
	}

	public void setFR_Fraco_Visitado_2(Integer fR_Fraco_Visitado_2) {
		FR_Fraco_Visitado_2 = fR_Fraco_Visitado_2;
	}

	public Integer getFR_Fraco_Visitado_3() {
		return FR_Fraco_Visitado_3;
	}

	public void setFR_Fraco_Visitado_3(Integer fR_Fraco_Visitado_3) {
		FR_Fraco_Visitado_3 = fR_Fraco_Visitado_3;
	}

	public Integer getFR_Fraco_Visitado_4() {
		return FR_Fraco_Visitado_4;
	}

	public void setFR_Fraco_Visitado_4(Integer fR_Fraco_Visitado_4) {
		FR_Fraco_Visitado_4 = fR_Fraco_Visitado_4;
	}

	public Integer getFR_Fraco_Visitado_5() {
		return FR_Fraco_Visitado_5;
	}

	public void setFR_Fraco_Visitado_5(Integer fR_Fraco_Visitado_5) {
		FR_Fraco_Visitado_5 = fR_Fraco_Visitado_5;
	}

	public Integer getFR_Top_Visitante_1() {
		return FR_Top_Visitante_1;
	}

	public void setFR_Top_Visitante_1(Integer fR_Top_Visitante_1) {
		FR_Top_Visitante_1 = fR_Top_Visitante_1;
	}

	public Integer getFR_Top_Visitante_2() {
		return FR_Top_Visitante_2;
	}

	public void setFR_Top_Visitante_2(Integer fR_Top_Visitante_2) {
		FR_Top_Visitante_2 = fR_Top_Visitante_2;
	}

	public Integer getFR_Top_Visitante_3() {
		return FR_Top_Visitante_3;
	}

	public void setFR_Top_Visitante_3(Integer fR_Top_Visitante_3) {
		FR_Top_Visitante_3 = fR_Top_Visitante_3;
	}

	public Integer getFR_Top_Visitante_4() {
		return FR_Top_Visitante_4;
	}

	public void setFR_Top_Visitante_4(Integer fR_Top_Visitante_4) {
		FR_Top_Visitante_4 = fR_Top_Visitante_4;
	}

	public Integer getFR_Top_Visitante_5() {
		return FR_Top_Visitante_5;
	}

	public void setFR_Top_Visitante_5(Integer fR_Top_Visitante_5) {
		FR_Top_Visitante_5 = fR_Top_Visitante_5;
	}

	public Integer getFR_Ms_Visitante_1() {
		return FR_Ms_Visitante_1;
	}

	public void setFR_Ms_Visitante_1(Integer fR_Ms_Visitante_1) {
		FR_Ms_Visitante_1 = fR_Ms_Visitante_1;
	}

	public Integer getFR_Ms_Visitante_2() {
		return FR_Ms_Visitante_2;
	}

	public void setFR_Ms_Visitante_2(Integer fR_Ms_Visitante_2) {
		FR_Ms_Visitante_2 = fR_Ms_Visitante_2;
	}

	public Integer getFR_Ms_Visitante_3() {
		return FR_Ms_Visitante_3;
	}

	public void setFR_Ms_Visitante_3(Integer fR_Ms_Visitante_3) {
		FR_Ms_Visitante_3 = fR_Ms_Visitante_3;
	}

	public Integer getFR_Ms_Visitante_4() {
		return FR_Ms_Visitante_4;
	}

	public void setFR_Ms_Visitante_4(Integer fR_Ms_Visitante_4) {
		FR_Ms_Visitante_4 = fR_Ms_Visitante_4;
	}

	public Integer getFR_Ms_Visitante_5() {
		return FR_Ms_Visitante_5;
	}

	public void setFR_Ms_Visitante_5(Integer fR_Ms_Visitante_5) {
		FR_Ms_Visitante_5 = fR_Ms_Visitante_5;
	}

	public Integer getFR_Mi_Visitante_1() {
		return FR_Mi_Visitante_1;
	}

	public void setFR_Mi_Visitante_1(Integer fR_Mi_Visitante_1) {
		FR_Mi_Visitante_1 = fR_Mi_Visitante_1;
	}

	public Integer getFR_Mi_Visitante_2() {
		return FR_Mi_Visitante_2;
	}

	public void setFR_Mi_Visitante_2(Integer fR_Mi_Visitante_2) {
		FR_Mi_Visitante_2 = fR_Mi_Visitante_2;
	}

	public Integer getFR_Mi_Visitante_3() {
		return FR_Mi_Visitante_3;
	}

	public void setFR_Mi_Visitante_3(Integer fR_Mi_Visitante_3) {
		FR_Mi_Visitante_3 = fR_Mi_Visitante_3;
	}

	public Integer getFR_Mi_Visitante_4() {
		return FR_Mi_Visitante_4;
	}

	public void setFR_Mi_Visitante_4(Integer fR_Mi_Visitante_4) {
		FR_Mi_Visitante_4 = fR_Mi_Visitante_4;
	}

	public Integer getFR_Mi_Visitante_5() {
		return FR_Mi_Visitante_5;
	}

	public void setFR_Mi_Visitante_5(Integer fR_Mi_Visitante_5) {
		FR_Mi_Visitante_5 = fR_Mi_Visitante_5;
	}

	public Integer getFR_Fraco_Visitante_1() {
		return FR_Fraco_Visitante_1;
	}

	public void setFR_Fraco_Visitante_1(Integer fR_Fraco_Visitante_1) {
		FR_Fraco_Visitante_1 = fR_Fraco_Visitante_1;
	}

	public Integer getFR_Fraco_Visitante_2() {
		return FR_Fraco_Visitante_2;
	}

	public void setFR_Fraco_Visitante_2(Integer fR_Fraco_Visitante_2) {
		FR_Fraco_Visitante_2 = fR_Fraco_Visitante_2;
	}

	public Integer getFR_Fraco_Visitante_3() {
		return FR_Fraco_Visitante_3;
	}

	public void setFR_Fraco_Visitante_3(Integer fR_Fraco_Visitante_3) {
		FR_Fraco_Visitante_3 = fR_Fraco_Visitante_3;
	}

	public Integer getFR_Fraco_Visitante_4() {
		return FR_Fraco_Visitante_4;
	}

	public void setFR_Fraco_Visitante_4(Integer fR_Fraco_Visitante_4) {
		FR_Fraco_Visitante_4 = fR_Fraco_Visitante_4;
	}

	public Integer getFR_Fraco_Visitante_5() {
		return FR_Fraco_Visitante_5;
	}

	public void setFR_Fraco_Visitante_5(Integer fR_Fraco_Visitante_5) {
		FR_Fraco_Visitante_5 = fR_Fraco_Visitante_5;
	}

	public Integer getH2h_1() {
		return H2h_1;
	}

	public void setH2h_1(Integer h2h_1) {
		H2h_1 = h2h_1;
	}

	public Integer getH2h_2() {
		return H2h_2;
	}

	public void setH2h_2(Integer h2h_2) {
		H2h_2 = h2h_2;
	}

	public Integer getH2h_3() {
		return H2h_3;
	}

	public void setH2h_3(Integer h2h_3) {
		H2h_3 = h2h_3;
	}

	public Integer getH2h_4() {
		return H2h_4;
	}

	public void setH2h_4(Integer h2h_4) {
		H2h_4 = h2h_4;
	}

	public Integer getH2h_5() {
		return H2h_5;
	}

	public void setH2h_5(Integer h2h_5) {
		H2h_5 = h2h_5;
	}

	public Integer getH2h_6() {
		return H2h_6;
	}

	public void setH2h_6(Integer h2h_6) {
		H2h_6 = h2h_6;
	}

	public Integer getH2h_7() {
		return H2h_7;
	}

	public void setH2h_7(Integer h2h_7) {
		H2h_7 = h2h_7;
	}

	public Integer getH2h_8() {
		return H2h_8;
	}

	public void setH2h_8(Integer h2h_8) {
		H2h_8 = h2h_8;
	}

	public Integer getH2h_9() {
		return H2h_9;
	}

	public void setH2h_9(Integer h2h_9) {
		H2h_9 = h2h_9;
	}

	public Integer getH2h_10() {
		return H2h_10;
	}

	public void setH2h_10(Integer h2h_10) {
		H2h_10 = h2h_10;
	}

	public Double getOdd_favor() {
		return Odd_favor;
	}

	public void setOdd_favor(Double odd_favor) {
		Odd_favor = odd_favor;
	}

	public Double getOdd_contra() {
		return Odd_contra;
	}

	public void setOdd_contra(Double odd_contra) {
		Odd_contra = odd_contra;
	}
	
	
	
}

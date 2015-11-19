package pt.belele.project.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pt.belele.project.algorithm.ExcelRow;
import pt.belele.project.algorithm.PlanBRow;
import pt.belele.project.algorithm.ProfRow;

public class WriteToExcel {

	private static final Logger logger = LogManager.getLogger(WriteToExcel.class);

	private String filePath = "/Users/Ricardo/Desktop/";
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public WriteToExcel(String filePath) {
		this.filePath = filePath;
	}

	public Workbook newWorkbook() {
		// Using XSSF for xlsx format, for xls use HSSF
		Workbook workbook = new XSSFWorkbook();
		return workbook;
	}

	public void writeOurDataExcelTable(List<ExcelRow> dataList, Workbook workbook, String sheetName) {

		Sheet ourSheet = workbook.createSheet(sheetName);

		int rowIndex = 0;

		Row row = ourSheet.createRow(rowIndex++);

		int cellIndex = 0;

		row.createCell(cellIndex++).setCellValue("Data");

		row.createCell(cellIndex++).setCellValue("Nome do Visitado");

		row.createCell(cellIndex++).setCellValue("Nome do Visitante");

		row.createCell(cellIndex++).setCellValue("Id do Visitado");

		row.createCell(cellIndex++).setCellValue("Id do Visitante");

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitado");

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitante");

		row.createCell(cellIndex++).setCellValue("Dias de Descanso do Visitado");

		row.createCell(cellIndex++).setCellValue("Dias de Descanso do Visitante");

		row.createCell(cellIndex++).setCellValue("Classificacao do Visitado");

		row.createCell(cellIndex++).setCellValue("Classificacao do Visitante");

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Jogos do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Jogos do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Dificuldade do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Dificuldade do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Históricos do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Históricos do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Jogos do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Jogos do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Dificuldade do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Dificuldade do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Históricos do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Históricos do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Jogos do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Jogos do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Dificuldade do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Dificuldade do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Históricos do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo não Resultado] Número de Históricos do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Jogos do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Jogos do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Dificuldade do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Dificuldade do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Históricos do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Históricos do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Jogos do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Jogos do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Dificuldade do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Dificuldade do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Históricos do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Históricos do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Jogos do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Jogos do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Dificuldade do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Dificuldade do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Históricos do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[Ciclo Resultado] Número de Históricos do Visitante - SWITCHED VENUE");		
		
		row.createCell(cellIndex++).setCellValue("[FR] Dificuldade do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Dificuldade do Visitante");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitante");

		row.createCell(cellIndex++).setCellValue("[FR] Rating Temporal de Resultados do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Rating Temporal de Resultados do Visitante");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados do Visitante");
		
		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados no Intervalo do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados no Intervalo do Visitante");
		
		row.createCell(cellIndex++).setCellValue("[FR] Número de Jogos do Visitado em Casa");
		
		row.createCell(cellIndex++).setCellValue("[FR] Número de Jogos do Visitante Fora");

		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados do Visitante");
		
		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados do Visitado em Casa");

		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados do Visitante Fora");
		
		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados no Intervalo do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados no Intervalo do Visitante");
		
		row.createCell(cellIndex++).setCellValue("[FR] Golos Marcados pelo Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Golos Sofridos pelo Visitado");
		
		row.createCell(cellIndex++).setCellValue("[FR] Diferença de Golos do Visitado");
		
		row.createCell(cellIndex++).setCellValue("[FR] Golos Marcados pelo Visitante");

		row.createCell(cellIndex++).setCellValue("[FR] Golos Sofridos pelo Visitante");
		
		row.createCell(cellIndex++).setCellValue("[FR] Diferença de Golos do Visitante");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Marcados do Visitado");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Sofridos do Visitado");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Marcados do Visitante");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Sofridos do Visitante");
		
		row.createCell(cellIndex++).setCellValue("[FR] Dificuldade do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Dificuldade do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Rating Temporal de Resultados do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Rating Temporal de Resultados do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados do Visitante - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados no Intervalo do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados no Intervalo do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados do Visitante - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados no Intervalo do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados no Intervalo do Visitante - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Golos Marcados pelo Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Golos Sofridos pelo Visitado - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Diferença de Golos do Visitado - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Golos Marcados pelo Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Golos Sofridos pelo Visitante - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Diferença de Golos do Visitante - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Marcados do Visitado - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Sofridos do Visitado - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Marcados do Visitante - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Sofridos do Visitado - VENUE");
				
		row.createCell(cellIndex++).setCellValue("[FR] Dificuldade do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Dificuldade do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Rating Temporal de Resultados do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Rating Temporal de Resultados do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados do Visitante - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados no Intervalo do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Resultados no Intervalo do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados do Visitante - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados no Intervalo do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Percentagem de Resultados no Intervalo do Visitante - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Golos Marcados pelo Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Golos Sofridos pelo Visitado - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Diferença de Golos do Visitado - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Golos Marcados pelo Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[FR] Golos Sofridos pelo Visitante - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Diferença de Golos do Visitante - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Marcados do Visitado - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Sofridos do Visitado - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Marcados do Visitante - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[FR] Média de Golos Sofridos do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Número de Jogos do Visitado");

		row.createCell(cellIndex++).setCellValue("[QLT] Número de Jogos do Visitante");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitado");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitante");

		row.createCell(cellIndex++).setCellValue("[QLT] Dificuldade dos Resultados do Visitado");

		row.createCell(cellIndex++).setCellValue("[QLT] Dificuldade dos Resultados do Visitante");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitado no Intervalo");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitante no Intervalo");

		row.createCell(cellIndex++).setCellValue("[QLT] Numero de Jogos do Visitado no Intervalo");

		row.createCell(cellIndex++).setCellValue("[QLT] Numero de Jogos do Visitante no Intervalo");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Marcados pelo Visitado");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Sofridos pelo Visitado");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Diferençade Golos do Visitado");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Marcados pelo Visitante");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Sofridos pelo Visitante");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Diferença de Golos do Visitante");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Marcados pelo Visitado");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Sofridos pelo Visitado");

		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Marcados pelo Visitante");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Sofridos pelo Visitante");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Número de Jogos do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Número de Jogos do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Dificuldade dos Resultados do Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Dificuldade dos Resultados do Visitante - VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitado no Intervalo - VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitante no Intervalo - VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Numero de Jogos do Visitado no Intervalo - VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Numero de Jogos do Visitante no Intervalo - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Marcados pelo Visitado - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Sofridos pelo Visitado - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Diferençade Golos do Visitado - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Marcados pelo Visitante - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Sofridos pelo Visitante - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Diferença de Golos do Visitante - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Marcados pelo Visitado - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Sofridos pelo Visitado - VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Marcados pelo Visitante - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Sofridos pelo Visitante - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Número de Jogos do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Número de Jogos do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Dificuldade dos Resultados do Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Dificuldade dos Resultados do Visitante - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitado no Intervalo - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitante no Intervalo - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Numero de Jogos do Visitado no Intervalo - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Numero de Jogos do Visitante no Intervalo - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Marcados pelo Visitado - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Sofridos pelo Visitado - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Diferençade Golos do Visitado - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Marcados pelo Visitante - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Golos Sofridos pelo Visitante - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Diferença de Golos do Visitante - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Marcados pelo Visitado - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Sofridos pelo Visitado - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Marcados pelo Visitante - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[QLT] Média de Golos Sofridos pelo Visitante - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[H2H] Número de Jogos");
		
		row.createCell(cellIndex++).setCellValue("[H2H] Número de Resultados");
		
		row.createCell(cellIndex++).setCellValue("[H2H] Percentagem de Resultados");

		row.createCell(cellIndex++).setCellValue("[H2H] Rating Temporal de Resultados");
		
		row.createCell(cellIndex++).setCellValue("[H2H] Número de Jogos - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[H2H] Número de Resultados - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[H2H] Percentagem de Resultados - VENUE");

		row.createCell(cellIndex++).setCellValue("[H2H] Rating Temporal de Resultados - VENUE");
		
		row.createCell(cellIndex++).setCellValue("[H2H] Número de Jogos - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[H2H] Número de Resultados - SWITCHED VENUE");
		
		row.createCell(cellIndex++).setCellValue("[H2H] Percentagem de Resultados - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[H2H] Rating Temporal de Resultados - SWITCHED VENUE");

		row.createCell(cellIndex++).setCellValue("[OUTPUT] Resultado");

		row.createCell(cellIndex++).setCellValue("Mês");

		row.createCell(cellIndex++).setCellValue("Ano");
		
		row.createCell(cellIndex++).setCellValue("Semana");

		rowIndex++;

		for (ExcelRow excelrow : dataList) {

			row = ourSheet.createRow(rowIndex++);

			cellIndex = 0;

			row.createCell(cellIndex++).setCellValue(sdf.format(excelrow.getData()));

			row.createCell(cellIndex++).setCellValue(excelrow.getNomeVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getNomeVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getIdVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getIdVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getQualidadeVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQualidadeVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getDiasDescansoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getDiasDescansoVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getClassificacaoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getClassificacaoVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getQualidadeVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQualidadeVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQualidadeVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQualidadeVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_numeroJogosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_numeroJogosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_dificuldadeVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_dificuldadeVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_historicosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_historicosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_numeroJogosVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_numeroJogosVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_dificuldadeVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_dificuldadeVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_historicosVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_historicosVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_numeroJogosVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_numeroJogosVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_dificuldadeVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_dificuldadeVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_historicosVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloNaoResultado_historicosVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_numeroJogosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_numeroJogosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_dificuldadeVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_dificuldadeVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_historicosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_historicosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_numeroJogosVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_numeroJogosVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_dificuldadeVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_dificuldadeVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_historicosVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_historicosVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_numeroJogosVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_numeroJogosVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_dificuldadeVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_dificuldadeVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_historicosVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloResultado_historicosVisitanteSwitchedVenue());		
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_dificuldadeVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_dificuldadeVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_historicosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_historicosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingTemporalResultadoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingTemporalResultadoVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosNoIntervaloVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosNoIntervaloVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroJogosVisitadoCasa());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroJogosVisitanteFora());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoVisitadoCasa());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoVisitanteFora());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoNoIntervaloVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoNoIntervaloVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosMarcadosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosSofridosVisitado());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_diferencaGolosVisitado());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosMarcadosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosSofridosVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_diferencaGolosVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosMarcadosVisitado());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosSofridosVisitado());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosMarcadosVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosSofridosVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_dificuldadeVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_dificuldadeVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_historicosVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_historicosVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingTemporalResultadoVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingTemporalResultadoVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosNoIntervaloVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosNoIntervaloVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoNoIntervaloVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoNoIntervaloVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosMarcadosVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosSofridosVisitadoVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_diferencaGolosVisitadoVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosMarcadosVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosSofridosVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_diferencaGolosVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosMarcadosVisitadoVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosSofridosVisitadoVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosMarcadosVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosSofridosVisitanteVenue());
					
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_dificuldadeVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_dificuldadeVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_historicosVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_historicosVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingTemporalResultadoVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingTemporalResultadoVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosNoIntervaloVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_numeroResultadosNoIntervaloVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoNoIntervaloVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_percentagemResultadoNoIntervaloVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosMarcadosVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosSofridosVisitadoSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_diferencaGolosVisitadoSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosMarcadosVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_golosSofridosVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_diferencaGolosVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosMarcadosVisitadoSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosSofridosVisitadoSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosMarcadosVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_mediaGolosSofridosVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_dificuldadeResultadoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_dificuldadeResultadoVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoNoIntervaloVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoNoIntervaloVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosNoIntervaloVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosNoIntervaloVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosMarcadosVisitado());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosSofridosVisitado());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_diferencaGolosVisitado());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosMarcadosVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosSofridosVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_diferencaGolosVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosMarcadosVisitado());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosSofridosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosMarcadosVisitante());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosSofridosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_dificuldadeResultadoVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_dificuldadeResultadoVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoNoIntervaloVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoNoIntervaloVisitanteVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosNoIntervaloVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosNoIntervaloVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosMarcadosVisitadoVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosSofridosVisitadoVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_diferencaGolosVisitadoVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosMarcadosVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosSofridosVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_diferencaGolosVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosMarcadosVisitadoVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosSofridosVisitadoVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosMarcadosVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosSofridosVisitanteVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_dificuldadeResultadoVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_dificuldadeResultadoVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoNoIntervaloVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoNoIntervaloVisitanteSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosNoIntervaloVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosNoIntervaloVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosMarcadosVisitadoSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosSofridosVisitadoSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_diferencaGolosVisitadoSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosMarcadosVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_golosSofridosVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_diferencaGolosVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosMarcadosVisitadoSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosSofridosVisitadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosMarcadosVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_mediaGolosSofridosVisitanteSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_numeroJogos());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_numeroResultados());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_percentagemResultados());

			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_ratingTemporalResultado());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_numeroJogosVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_numeroResultadosVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_percentagemResultadosVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_ratingTemporalResultadoVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_numeroJogosSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_numeroResultadosSwitchedVenue());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_percentagemResultadosSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_ratingTemporalResultadoSwitchedVenue());

			row.createCell(cellIndex++).setCellValue(excelrow.getResultado());
			
			row.createCell(cellIndex++).setCellValue(excelrow.getData().getMonth() + 1);
			 
			row.createCell(cellIndex++).setCellValue(excelrow.getData().getYear() + 1900);

			Calendar cal = Calendar.getInstance();
			cal.setTime(excelrow.getData());
			int week = cal.get(Calendar.WEEK_OF_YEAR);
			
			row.createCell(cellIndex++).setCellValue(week);

		}

	}

	public void writeProfDataExcelTable(List<ProfRow> dataList, Workbook workbook, String sheetName) {

		Sheet ourSheet = workbook.createSheet(sheetName);

		int rowIndex = 0;

		Row row = ourSheet.createRow(rowIndex++);

		int cellIndex = 0;

		row.createCell(cellIndex++).setCellValue("Data");

		row.createCell(cellIndex++).setCellValue("Nome do Visitado");

		row.createCell(cellIndex++).setCellValue("Nome do Visitante");

		row.createCell(cellIndex++).setCellValue("Id do Visitado");

		row.createCell(cellIndex++).setCellValue("Id do Visitante");

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitado");

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitante");

		row.createCell(cellIndex++).setCellValue("[FR] Dias de Descanso do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Dias de Descanso do Visitante");

		row.createCell(cellIndex++).setCellValue("[FR] Rating de Resultados do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Rating de Resultados do Visitante");

		row.createCell(cellIndex++).setCellValue("[FR] Dificuldade do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Rating de Resultados do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Jogos do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Jogos do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Dificuldade do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Dificuldade do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Historicos do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Historicos do Visitante");

		row.createCell(cellIndex++).setCellValue("[H2H] Número de Jogos");

		row.createCell(cellIndex++).setCellValue("[H2H] Rating de Resultado");

		rowIndex++;

		for (ProfRow profrow : dataList) {

			row = ourSheet.createRow(rowIndex++);

			cellIndex = 0;

			row.createCell(cellIndex++).setCellValue(profrow.getData());

			row.createCell(cellIndex++).setCellValue(profrow.getHomeTeamName());

			row.createCell(cellIndex++).setCellValue(profrow.getAwayTeamName());

			row.createCell(cellIndex++).setCellValue(profrow.getIdVisitado());

			row.createCell(cellIndex++).setCellValue(profrow.getIdVisitante());

			row.createCell(cellIndex++).setCellValue(profrow.getQualidadeVisitado());

			row.createCell(cellIndex++).setCellValue(profrow.getQualidadeVisitante());

			row.createCell(cellIndex++).setCellValue(profrow.getFR_diasDescansoVisitado());

			row.createCell(cellIndex++).setCellValue(profrow.getFR_diasDescansoVisitante());

			row.createCell(cellIndex++).setCellValue(profrow.getFR_ratingResultadoVisitado());

			row.createCell(cellIndex++).setCellValue(profrow.getFR_ratingResultadoVisitante());

			row.createCell(cellIndex++).setCellValue(profrow.getFR_dificuldadeVisitado());

			row.createCell(cellIndex++).setCellValue(profrow.getFR_dificuldadeVisistante());

			row.createCell(cellIndex++).setCellValue(profrow.getFR_HistoricosVisitado());

			row.createCell(cellIndex++).setCellValue(profrow.getFR_HistoricosVisitante());

			row.createCell(cellIndex++).setCellValue(profrow.getCiclo_numeroJogosVisitado());

			row.createCell(cellIndex++).setCellValue(profrow.getCiclo_numeroJogosVisitante());

			row.createCell(cellIndex++).setCellValue(profrow.getCiclo_dificuldadeVisitado());

			row.createCell(cellIndex++).setCellValue(profrow.getCiclo_dificuldadeVisitante());

			row.createCell(cellIndex++).setCellValue(profrow.getCiclo_HistoricosVisitado());

			row.createCell(cellIndex++).setCellValue(profrow.getCiclo_HistoricosVisitante());

			row.createCell(cellIndex++).setCellValue(profrow.getH2H_numeroJogos());

			row.createCell(cellIndex++).setCellValue(profrow.getH2H_ratingResultado());

			row.createCell(cellIndex++).setCellValue(profrow.getResult());

		}

	}

	public void writePlanBToExcel(List<PlanBRow> dataList, Workbook workbook, String sheetName) {

		Sheet planBSheet = workbook.createSheet(sheetName);

		int rowIndex = 0;

		Row row = planBSheet.createRow(rowIndex++);

		int cellIndex = 0;

		row.createCell(cellIndex++).setCellValue("Data");
		row.createCell(cellIndex++).setCellValue("Visitado");
		row.createCell(cellIndex++).setCellValue("Visitante");
		row.createCell(cellIndex++).setCellValue("Classificação visitado");
		row.createCell(cellIndex++).setCellValue("Classificação visitado");
		row.createCell(cellIndex++).setCellValue("Resultado");
		row.createCell(cellIndex++).setCellValue("QLT Top Visitado");
		row.createCell(cellIndex++).setCellValue("QLT Ms Visitado");
		row.createCell(cellIndex++).setCellValue("QLT Mi Visitado");
		row.createCell(cellIndex++).setCellValue("QLT Fraco Visitado");
		row.createCell(cellIndex++).setCellValue("QLT Top Visitante");
		row.createCell(cellIndex++).setCellValue("QLT Ms Visitante");
		row.createCell(cellIndex++).setCellValue("QLT Mi Visitante");
		row.createCell(cellIndex++).setCellValue("QLT Fraco Visitante");
		row.createCell(cellIndex++).setCellValue("Ciclo Top Visitado");
		row.createCell(cellIndex++).setCellValue("Ciclo Ms Visitado");
		row.createCell(cellIndex++).setCellValue("Ciclo Mi Visitado");
		row.createCell(cellIndex++).setCellValue("Ciclo Fraco Visitado");
		row.createCell(cellIndex++).setCellValue("Ciclo Top Visitante");
		row.createCell(cellIndex++).setCellValue("Ciclo Ms Visitante");
		row.createCell(cellIndex++).setCellValue("Ciclo Mi Visitante");
		row.createCell(cellIndex++).setCellValue("Ciclo Fraco Visitante");
		row.createCell(cellIndex++).setCellValue("Fr Top Visitado 1");
		row.createCell(cellIndex++).setCellValue("Fr Top Visitado 2");
		row.createCell(cellIndex++).setCellValue("Fr Top Visitado 3");
		row.createCell(cellIndex++).setCellValue("Fr Top Visitado 4");
		row.createCell(cellIndex++).setCellValue("Fr Top Visitado 5");
		row.createCell(cellIndex++).setCellValue("Fr Ms Visitado 1");
		row.createCell(cellIndex++).setCellValue("Fr Ms Visitado 2");
		row.createCell(cellIndex++).setCellValue("Fr Ms Visitado 3");
		row.createCell(cellIndex++).setCellValue("Fr Ms Visitado 4");
		row.createCell(cellIndex++).setCellValue("Fr Ms Visitado 5");
		row.createCell(cellIndex++).setCellValue("Fr Mi Visitado 1");
		row.createCell(cellIndex++).setCellValue("Fr Mi Visitado 2");
		row.createCell(cellIndex++).setCellValue("Fr Mi Visitado 3");
		row.createCell(cellIndex++).setCellValue("Fr Mi Visitado 4");
		row.createCell(cellIndex++).setCellValue("Fr Mi Visitado 5");
		row.createCell(cellIndex++).setCellValue("Fr Fraco Visitado 1");
		row.createCell(cellIndex++).setCellValue("Fr Fraco Visitado 2");
		row.createCell(cellIndex++).setCellValue("Fr Fraco Visitado 3");
		row.createCell(cellIndex++).setCellValue("Fr Fraco Visitado 4");
		row.createCell(cellIndex++).setCellValue("Fr Fraco Visitado 5");
		row.createCell(cellIndex++).setCellValue("Fr Top Visitante 1");
		row.createCell(cellIndex++).setCellValue("Fr Top Visitante 2");
		row.createCell(cellIndex++).setCellValue("Fr Top Visitante 3");
		row.createCell(cellIndex++).setCellValue("Fr Top Visitante 4");
		row.createCell(cellIndex++).setCellValue("Fr Top Visitante 5");
		row.createCell(cellIndex++).setCellValue("Fr Ms Visitante 1");
		row.createCell(cellIndex++).setCellValue("Fr Ms Visitante 2");
		row.createCell(cellIndex++).setCellValue("Fr Ms Visitante 3");
		row.createCell(cellIndex++).setCellValue("Fr Ms Visitante 4");
		row.createCell(cellIndex++).setCellValue("Fr Ms Visitante 5");
		row.createCell(cellIndex++).setCellValue("Fr Mi Visitante 1");
		row.createCell(cellIndex++).setCellValue("Fr Mi Visitante 2");
		row.createCell(cellIndex++).setCellValue("Fr Mi Visitante 3");
		row.createCell(cellIndex++).setCellValue("Fr Mi Visitante 4");
		row.createCell(cellIndex++).setCellValue("Fr Mi Visitante 5");
		row.createCell(cellIndex++).setCellValue("Fr Fraco Visitante 1");
		row.createCell(cellIndex++).setCellValue("Fr Fraco Visitante 2");
		row.createCell(cellIndex++).setCellValue("Fr Fraco Visitante 3");
		row.createCell(cellIndex++).setCellValue("Fr Fraco Visitante 4");
		row.createCell(cellIndex++).setCellValue("Fr Fraco Visitante 5");
		row.createCell(cellIndex++).setCellValue("h2h 1");
		row.createCell(cellIndex++).setCellValue("h2h 2");
		row.createCell(cellIndex++).setCellValue("h2h 3");
		row.createCell(cellIndex++).setCellValue("h2h 4");
		row.createCell(cellIndex++).setCellValue("h2h 5");
		row.createCell(cellIndex++).setCellValue("h2h 6");
		row.createCell(cellIndex++).setCellValue("h2h 7");
		row.createCell(cellIndex++).setCellValue("h2h 8");
		row.createCell(cellIndex++).setCellValue("h2h 9");
		row.createCell(cellIndex++).setCellValue("h2h 10");
		row.createCell(cellIndex++).setCellValue("Odd favor");
		row.createCell(cellIndex++).setCellValue("Odd contra");

		rowIndex++;

		for (PlanBRow excelrow : dataList) {

			row = planBSheet.createRow(rowIndex++);

			cellIndex = 0;

			row.createCell(cellIndex++).setCellValue(sdf.format(excelrow.getData()));
			row.createCell(cellIndex++).setCellValue(excelrow.getVisitado());
			row.createCell(cellIndex++).setCellValue(excelrow.getVisitante());
			row.createCell(cellIndex++).setCellValue(excelrow.getClass_visitado());
			row.createCell(cellIndex++).setCellValue(excelrow.getClass_visitante());
			row.createCell(cellIndex++).setCellValue(excelrow.getResult());
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_Top_Visitado());
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_Ms_Visitado());
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_Mi_Visitado());
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_Fraco_Visitado());
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_Top_Visitante());
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_Ms_Visitante());
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_Mi_Visitante());
			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_Fraco_Visitante());
			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_Top_Visitado());
			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_Ms_Visitado());
			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_Mi_Visitado());
			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_Fraco_Visitado());
			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_Top_Visitante());
			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_Ms_Visitante());
			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_Mi_Visitante());
			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_Fraco_Visitante());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Top_Visitado_1());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Top_Visitado_2());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Top_Visitado_3());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Top_Visitado_4());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Top_Visitado_5());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Ms_Visitado_1());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Ms_Visitado_2());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Ms_Visitado_3());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Ms_Visitado_4());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Ms_Visitado_5());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Mi_Visitado_1());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Mi_Visitado_2());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Mi_Visitado_3());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Mi_Visitado_4());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Mi_Visitado_5());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Fraco_Visitado_1());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Fraco_Visitado_2());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Fraco_Visitado_3());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Fraco_Visitado_4());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Fraco_Visitado_5());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Top_Visitante_1());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Top_Visitante_2());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Top_Visitante_3());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Top_Visitante_4());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Top_Visitante_5());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Ms_Visitante_1());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Ms_Visitante_2());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Ms_Visitante_3());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Ms_Visitante_4());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Ms_Visitante_5());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Mi_Visitante_1());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Mi_Visitante_2());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Mi_Visitante_3());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Mi_Visitante_4());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Mi_Visitante_5());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Fraco_Visitante_1());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Fraco_Visitante_2());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Fraco_Visitante_3());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Fraco_Visitante_4());
			row.createCell(cellIndex++).setCellValue(excelrow.getFR_Fraco_Visitante_5());
			row.createCell(cellIndex++).setCellValue(excelrow.getH2h_1());
			row.createCell(cellIndex++).setCellValue(excelrow.getH2h_2());
			row.createCell(cellIndex++).setCellValue(excelrow.getH2h_3());
			row.createCell(cellIndex++).setCellValue(excelrow.getH2h_4());
			row.createCell(cellIndex++).setCellValue(excelrow.getH2h_5());
			row.createCell(cellIndex++).setCellValue(excelrow.getH2h_6());
			row.createCell(cellIndex++).setCellValue(excelrow.getH2h_7());
			row.createCell(cellIndex++).setCellValue(excelrow.getH2h_8());
			row.createCell(cellIndex++).setCellValue(excelrow.getH2h_9());
			row.createCell(cellIndex++).setCellValue(excelrow.getH2h_10());
			row.createCell(cellIndex++).setCellValue(excelrow.getOdd_favor());
			row.createCell(cellIndex++).setCellValue(excelrow.getOdd_contra());

		}
	}

	public void writeWorkbookToExcelFile(String path, Workbook workbook) {
		// write this workbook in excel file.
		try {
			FileOutputStream fos = new FileOutputStream(filePath + path + ".xlsx");
			workbook.write(fos);
			fos.close();

			logger.debug(filePath + path + ".xlsx" + " is successfully written");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
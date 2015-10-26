package pt.belele.project.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

	private String filePath = "/Users/JRicardoRG/Desktop/";
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

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitado");

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitante");

		row.createCell(cellIndex++).setCellValue("Dias de Descanso do Visitado");

		row.createCell(cellIndex++).setCellValue("Dias de Descanso do Visitante");

		row.createCell(cellIndex++).setCellValue("[FR] Rating de Resultados do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Rating de Resultados do Visitante");

		row.createCell(cellIndex++).setCellValue("[FR] Dificuldade do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Dificuldade do Visitante");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Jogos do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Jogos do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Dificuldade do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Dificuldade do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Historicos do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Historicos do Visitante");

		row.createCell(cellIndex++).setCellValue("[H2H] Número de Jogos");

		row.createCell(cellIndex++).setCellValue("[H2H] Rating de Resultado");

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

		row.createCell(cellIndex++).setCellValue("Resultado");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Jogos do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Jogos do Visitante");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Dificuldade do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Dificuldade do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Historicos do Visitado");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Historicos do Visitante");

		row.createCell(cellIndex++).setCellValue("[FR] Rating com Qualidade de Resultados do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Rating com Qualidade de Resultados do Visitante");

		row.createCell(cellIndex++).setCellValue("[QLT] Número de Jogos do Visitado Trocado");

		row.createCell(cellIndex++).setCellValue("[QLT] Número de Jogos do Visitante  Trocado");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitado Trocado");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitante Trocado");

		row.createCell(cellIndex++).setCellValue("[QLT] Dificuldade dos Resultados do Visitado Trocado");

		row.createCell(cellIndex++).setCellValue("[QLT] Dificuldade dos Resultados do Visitante Trocado");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitado no Intervalo Trocado");

		row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitante no Intervalo Trocado");

		row.createCell(cellIndex++).setCellValue("[QLT] Numero de Jogos do Visitado Trocado no Intervalo");

		row.createCell(cellIndex++).setCellValue("[QLT] Numero de Jogos do Visitante Trocado no Intervalo");

		row.createCell(cellIndex++).setCellValue("[H2H] Total Resultados");

		row.createCell(cellIndex++).setCellValue("[FR] Total Resultados do Visitado");

		row.createCell(cellIndex++).setCellValue("[FR] Total Resultados do Visitante");

		row.createCell(cellIndex++).setCellValue("Golos do Visitado");

		row.createCell(cellIndex++).setCellValue("Golos Sofridos pelo Visitado");

		row.createCell(cellIndex++).setCellValue("Diferença de Golos do Visitado");

		row.createCell(cellIndex++).setCellValue("Golos do Visitante");

		row.createCell(cellIndex++).setCellValue("Golos Sofridos pelo Visitante");

		row.createCell(cellIndex++).setCellValue("Diferença de Golos do Visitante");

		row.createCell(cellIndex++).setCellValue("Golos do Visitado em Casa");

		row.createCell(cellIndex++).setCellValue("Golos Sofridos pelo Visitado em Casa");

		row.createCell(cellIndex++).setCellValue("Diferença de Golos do Visitado em Casa");

		row.createCell(cellIndex++).setCellValue("Golos do Visitante Fora");

		row.createCell(cellIndex++).setCellValue("Golos Sofridos pelo Visitante Fora");

		row.createCell(cellIndex++).setCellValue("Diferença de Golos do Visitante Fora");

		row.createCell(cellIndex++).setCellValue("Classificação do Visitado");

		row.createCell(cellIndex++).setCellValue("Classificação do Visitante");

		row.createCell(cellIndex++).setCellValue("Mês");

		row.createCell(cellIndex++).setCellValue("Ano");

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitado em Casa");

		row.createCell(cellIndex++).setCellValue("Qualidade do Visitante Fora");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Jogos do Visitado Total");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Jogos do Visitante Total");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Dificuldade do Visitado Total");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Dificuldade do Visitante Total");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Historicos do Visitado Total");

		row.createCell(cellIndex++).setCellValue("[Ciclo] Número de Historicos do Visitante Total");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Jogos do Visitado Total");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Jogos do Visitante Total");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Dificuldade do Visitado Total");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Dificuldade do Visitado Total");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Historicos do Visitado Total");

		row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Historicos do Visitante Total");

		row.createCell(cellIndex++).setCellValue("[FR] Dificuldade do Visitado em Casa");

		row.createCell(cellIndex++).setCellValue("[FR] Dificuldade do Visitante Fora");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitado em Casa");

		row.createCell(cellIndex++).setCellValue("[FR] Número de Historicos do Visitante Fora");

		row.createCell(cellIndex++).setCellValue("[FR] Rating de Resultados do Visitado em Casa");

		row.createCell(cellIndex++).setCellValue("[FR] Rating de Resultados do Visitante Fora");

		row.createCell(cellIndex++).setCellValue("[FR] Total Resultados do Visitado em Casa");

		row.createCell(cellIndex++).setCellValue("[FR] Total Resultados do Visitante Fora");

		rowIndex++;

		for (ExcelRow excelrow : dataList) {

			row = ourSheet.createRow(rowIndex++);

			cellIndex = 0;

			row.createCell(cellIndex++).setCellValue(sdf.format(excelrow.getData()));

			row.createCell(cellIndex++).setCellValue(excelrow.getHomeTeamName());

			row.createCell(cellIndex++).setCellValue(excelrow.getAwayTeamName());

			row.createCell(cellIndex++).setCellValue(excelrow.getQualidadeVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQualidadeVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_diasDescansoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_diasDescansoVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingResultadoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingResultadoVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_dificuldadeVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_dificuldadeVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_HistoricosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_HistoricosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_numeroJogosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_numeroJogosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_dificuldadeVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_dificuldadeVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_HistoricosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_HistoricosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_numeroJogos());

			row.createCell(cellIndex++).setCellValue(excelrow.getH2H_ratingResultado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitadoDaPercentagem());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitanteDaPercentagem());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_dificuldadeResultadoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_dificuldadeResultadoVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitadoNoIntervalo());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitanteNoIntervalo());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getResult());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_numeroJogosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_numeroJogosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_dificuldadeVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_dificuldadeVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_HistoricosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_HistoricosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingQualidadeResultadoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingQualidadeResultadoVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_homeTeamNumeroJogos2());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_awayTeamNumeroJogos2());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitado2());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitante2());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_dificuldadeResultadoVisitado2());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_dificuldadeResultadoVisitante2());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitadoNoIntervalo2());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_percentagemResultadoVisitanteNoIntervalo2());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitado2());

			row.createCell(cellIndex++).setCellValue(excelrow.getQLT_numeroJogosVisitante2());

			row.createCell(cellIndex++).setCellValue(excelrow.getH2h_Results());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ResultadosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ResultadosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getGolosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getGolosSofridosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getDiferencaGolosVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getGolosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getGolosSofridosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getDiferencaGolosVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getGolosVisitadoCasa());

			row.createCell(cellIndex++).setCellValue(excelrow.getGolosSofridosVisitadoCasa());

			row.createCell(cellIndex++).setCellValue(excelrow.getDiferencaGolosVisitadoCasa());

			row.createCell(cellIndex++).setCellValue(excelrow.getGolosVisitanteFora());

			row.createCell(cellIndex++).setCellValue(excelrow.getGolosSofridosVisitanteFora());

			row.createCell(cellIndex++).setCellValue(excelrow.getDiferencaGolosVisitanteFora());

			row.createCell(cellIndex++).setCellValue(excelrow.getClassificacaoVisitado());

			row.createCell(cellIndex++).setCellValue(excelrow.getClassificacaoVisitante());

			row.createCell(cellIndex++).setCellValue(excelrow.getData().getMonth() + 1);

			row.createCell(cellIndex++).setCellValue(excelrow.getData().getYear() + 1900);

			row.createCell(cellIndex++).setCellValue(excelrow.getQualidadeVisitadoCasa());

			row.createCell(cellIndex++).setCellValue(excelrow.getQualidadeVisitanteFora());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_numeroJogosVisitadoTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_numeroJogosVisitanteTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_dificuldadeVisitadoTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_dificuldadeVisitanteTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_HistoricosVisitadoTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getCiclo_HistoricosVisitanteTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_numeroJogosVisitadoTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_numeroJogosVisitanteTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_dificuldadeVisitadoTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_dificuldadeVisitanteTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_HistoricosVisitadoTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getCicloPerna_HistoricosVisitanteTotal());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_dificuldadeVisitadoHome());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_dificuldadeVisitanteAway());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_HistoricosVisitadoHome());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_HistoricosVisitanteAway());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingResultadoVisitadoHome());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ratingResultadoVisitanteAway());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ResultadoVisitadoHome());

			row.createCell(cellIndex++).setCellValue(excelrow.getFR_ResultadoVisitanteAway());

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

		row.createCell(cellIndex++).setCellValue("Equipa da Casa");

		rowIndex++;

		for (PlanBRow excelrow : dataList) {

			row = planBSheet.createRow(rowIndex++);

			cellIndex = 0;

			row.createCell(cellIndex++).setCellValue("teste");
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
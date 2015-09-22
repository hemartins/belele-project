package pt.belele.project.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pt.belele.project.alg.OurRow;
import pt.belele.project.alg.ProfRow;

public class WriteToExcel {
	
	private String filePath = "/Users/JRicardoRG/Desktop/";
	
	public WriteToExcel(String filePath)
	{
		this.filePath = filePath;
	}
	
	public Workbook newWorkbook(){
		// Using XSSF for xlsx format, for xls use HSSF
        Workbook workbook = new XSSFWorkbook();
		return workbook;
	}
	
	public void writeOurDataExcelTable(List<OurRow> dataList, Workbook workbook, String sheetName){
		
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
               
        row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitado");
        
        row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitante");

        row.createCell(cellIndex++).setCellValue("[QLT] Dificuldade dos Resultados do Visitado");
        
        row.createCell(cellIndex++).setCellValue("[QLT] Dificuldade dos Resultados do Visitante");
        
        row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitado no Intervalo");

        row.createCell(cellIndex++).setCellValue("[QLT] Percentagem de Resultados do Visitante no Intervalo");
        
        row.createCell(cellIndex++).setCellValue("[QLT] Numero de Jogos do Visitado");
        
        row.createCell(cellIndex++).setCellValue("[QLT] Numero de Jogos do Visitante");
        
        row.createCell(cellIndex++).setCellValue("[QLT] Resultado");
        
        row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Jogos do Visitado");
        
        row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Jogos do Visitante");
        
        row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Dificuldade do Visitado");
        
        row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Dificuldade do Visitado");
        
        row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Historicos do Visitado");
        
        row.createCell(cellIndex++).setCellValue("[Ciclo Perna] Número de Historicos do Visitante");
        
        row.createCell(cellIndex++).setCellValue("[FR] Rating com Qualidade de Resultados do Visitado");

        row.createCell(cellIndex++).setCellValue("[FR] Rating com Qualidade de Resultados do Visitante");
        
        rowIndex++;
        
        
        for(OurRow winrow : dataList){
        	
        	row = ourSheet.createRow(rowIndex++);
        	
        	cellIndex = 0;
            
        	row.createCell(cellIndex++).setCellValue(winrow.getData());
        	
            row.createCell(cellIndex++).setCellValue(winrow.getHomeTeamName());
            
            row.createCell(cellIndex++).setCellValue(winrow.getAwayTeamName());
            
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitante());

            row.createCell(cellIndex++).setCellValue(winrow.getQualidadeVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQualidadeVisitante());

            row.createCell(cellIndex++).setCellValue(winrow.getFR_diasDescansoVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_diasDescansoVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_ratingResultadoVisitado());

            row.createCell(cellIndex++).setCellValue(winrow.getFR_ratingResultadoVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_dificuldadeVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_dificuldadeVisistante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_HistoricosVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_HistoricosVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_numeroJogosVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_numeroJogosVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_dificuldadeVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_dificuldadeVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_HistoricosVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_HistoricosVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_numeroJogos());
            
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_ratingResultado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitante());

            row.createCell(cellIndex++).setCellValue(winrow.getQLT_dificuldadeResultadoVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_dificuldadeResultadoVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitadoNoIntervalo());

            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitanteNoIntervalo());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_numeroJogosVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_numeroJogosVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getResult());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCicloPerna_numeroJogosVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCicloPerna_numeroJogosVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCicloPerna_dificuldadeVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCicloPerna_dificuldadeVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCicloPerna_HistoricosVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCicloPerna_HistoricosVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getfR_ratingQualidadeResultadoVisitado());

            row.createCell(cellIndex++).setCellValue(winrow.getfR_ratingQualidadeResultadoVisitante());

        }

    }
	
	public void writeProfDataExcelTable(List<ProfRow> dataList, Workbook workbook, String sheetName){
		        
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
        
        for(ProfRow winrow : dataList){
            
        	row = ourSheet.createRow(rowIndex++);

        	cellIndex = 0;
        	
        	row.createCell(cellIndex++).setCellValue(winrow.getData());
            
            row.createCell(cellIndex++).setCellValue(winrow.getHomeTeamName());
            
            row.createCell(cellIndex++).setCellValue(winrow.getAwayTeamName());
            
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQualidadeVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQualidadeVisitante());

            row.createCell(cellIndex++).setCellValue(winrow.getFR_diasDescansoVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_diasDescansoVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_ratingResultadoVisitado());

            row.createCell(cellIndex++).setCellValue(winrow.getFR_ratingResultadoVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_dificuldadeVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_dificuldadeVisistante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_HistoricosVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getFR_HistoricosVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_numeroJogosVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_numeroJogosVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_dificuldadeVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_dificuldadeVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_HistoricosVisitado());
             
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_HistoricosVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_numeroJogos());
            
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_ratingResultado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getResult());

        }

    }
	
	public void writeWorkbookToExcelFile(String path, Workbook workbook){
        //write this workbook in excel file.
        try {
            FileOutputStream fos = new FileOutputStream(filePath+path+".xlsx");
            workbook.write(fos);
            fos.close();

            System.out.println(filePath+path+".xlsx" + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
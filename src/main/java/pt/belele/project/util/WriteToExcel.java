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
	
	private static final String FILE_PATH = "/Users/JRicardoRG/Desktop/";
	
	public void writeOurDataExcelTable(String path, List<OurRow> dataList){
		
		// Using XSSF for xlsx format, for xls use HSSF
        Workbook workbook = new XSSFWorkbook();

        Sheet ourSheet = workbook.createSheet("ourSheet");

        int rowIndex = 0;
        for(OurRow winrow : dataList){
            Row row = ourSheet.createRow(rowIndex++);
            int cellIndex = 0;
            
            row.createCell(cellIndex++).setCellValue(winrow.getJornada());
            
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getHomeTeamName());
            
            row.createCell(cellIndex++).setCellValue(winrow.getAwayTeamName());

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
            
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_ratingResultado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_numeroJogos());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitante());

            row.createCell(cellIndex++).setCellValue(winrow.getQLT_dificuldadeResultadoVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_dificuldadeResultadoVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitadoNoIntervalo());

            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitanteNoIntervalo());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_numeroJogosVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_numeroJogosVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getResult());

        }

        //write this workbook in excel file.
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH+path+".xlsx");
            workbook.write(fos);
            fos.close();

            System.out.println(FILE_PATH+path+".xlsx" + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
	
	public void writeProfDataExcelTable(String path, List<ProfRow> dataList){
		
		// Using XSSF for xlsx format, for xls use HSSF
        Workbook workbook = new XSSFWorkbook();

        Sheet ourSheet = workbook.createSheet("ourSheet");

        int rowIndex = 0;
        for(ProfRow winrow : dataList){
            Row row = ourSheet.createRow(rowIndex++);
            int cellIndex = 0;
            
            row.createCell(cellIndex++).setCellValue(winrow.getJornada());
            
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitante());
            
            row.createCell(cellIndex++).setCellValue(winrow.getHomeTeamName());
            
            row.createCell(cellIndex++).setCellValue(winrow.getAwayTeamName());
            
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
            
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_ratingResultado());
            
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_numeroJogos());
            
            row.createCell(cellIndex++).setCellValue(winrow.getResult());

        }

        //write this workbook in excel file.
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH+path+".xlsx");
            workbook.write(fos);
            fos.close();

            System.out.println(FILE_PATH+path+".xlsx" + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
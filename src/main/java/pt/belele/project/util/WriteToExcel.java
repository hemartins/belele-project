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
            
            //primeira posição da linha é a jornada
            row.createCell(cellIndex++).setCellValue(winrow.getJornada());
            
            //primeira posição da linha é o id do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitado());
            
            //primeira posição da linha é o id do visitante
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitante());
            
            //primeira posição da linha é o nome do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getHomeTeamName());
            
          //primeira posição da linha é o nome do visitante
            row.createCell(cellIndex++).setCellValue(winrow.getAwayTeamName());

            //segunda posição da linha é a qualidade do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getQualidadeVisitado());
            
            //terceira posição da linha é a qualidade do visitante
            row.createCell(cellIndex++).setCellValue(winrow.getQualidadeVisitante());

            //quarta posição da linha são os dias de descanso do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getFR_diasDescansoVisitado());
            
            //quinta posição da linha são os dias de descanso do visitante 
            row.createCell(cellIndex++).setCellValue(winrow.getFR_diasDescansoVisitante());
            
            //sexta posição da linha é o rating de vitórias do visitado nos últimos 5 jogos
            row.createCell(cellIndex++).setCellValue(winrow.getFR_ratingResultadoVisitado());

            //sétima posição da linha é o rating de derrotas do visitante nos últimos 5 jogos
            row.createCell(cellIndex++).setCellValue(winrow.getFR_ratingResultadoVisitante());
            
            //oitava posição da linha é a dificuldade dos últimos 5 jogos do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getFR_dificuldadeVisitado());
            
            //nona posição da linha é a dificuldade dos últimos 5 jogos do visitante
            row.createCell(cellIndex++).setCellValue(winrow.getFR_dificuldadeVisistante());
            
            //décima posição da linha é o número de históricos que o visitado enfrentou nos últimos 5 jogos
            row.createCell(cellIndex++).setCellValue(winrow.getFR_HistoricosVisitado());
            
            //décima primeira posição é o número de históricos com os quais o visitado enfrentou nos últimos 5 jogos
            row.createCell(cellIndex++).setCellValue(winrow.getFR_HistoricosVisitante());
            
            //décima segunda posição é o número de jogos do ciclo do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_numeroJogosVisitado());
            
            //décima terceira posição da linha é o número de jogos do ciclo do visitante 
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_numeroJogosVisitante());
            
            //décima quarta posição da linha é a dificuldade do ciclo do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_dificuldadeVisitado());
            
            //décima quinta posição da linha é a dificuldade do ciclo do visitante 
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_dificuldadeVisitante());
            
            //décima sexta posição da linha é o número de históricos no ciclo do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_HistoricosVisitado());
            
            //décima sétima posição da linha é o número de históricos no ciclo do visitante 
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_HistoricosVisitante());
            
            //décima oitava posição da linha é o rating de vitórias no head 2 head
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_ratingResultado());
            
            //décima nona rta posição da linha é o número de jogos considerados do head 2 head
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_numeroJogos());
            
            //vigésima posição da linha é a percentagem total de vitórias do visitado em casa
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitado());
            
            //vigésima primeira posição da linha é a percentagem total de derrotas do visitante fora
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitante());

            //vigésima segunda posição da linha é a dificuldade de vitórias do visitado em casa
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_dificuldadeResultadoVisitado());
            
            //vigésima terceira posição da linha é a dificuldade das derrotas do visitante
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_dificuldadeResultadoVisitante());
            
            //vigésima quarta posição da linha é a percentagem de vitórias do visitado no intervalo
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitadoNoIntervalo());

            //vigésima quinta posição da linha é a percentagem de derrotas do visitante no intervalo
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_percentagemResultadoVisitanteNoIntervalo());
            
            //vigésima sexta posição da linha é o número de jogos do visitado no intervalo
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_numeroJogosVisitado());
            
            //vigésima sétima posição da linha é o número de jogos do visitante no intervalo
            row.createCell(cellIndex++).setCellValue(winrow.getQLT_numeroJogosVisitante());
            
           //vigésima sétima posição da linha é o número de jogos do visitante no intervalo
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
            
            //primeira posição da linha é a jornada
            row.createCell(cellIndex++).setCellValue(winrow.getJornada());
            
            //primeira posição da linha é o id do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitado());
            
            //primeira posição da linha é o id do visitante
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitante());
            
            //primeira posição da linha é o nome do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getHomeTeamName());
            
          //primeira posição da linha é o nome do visitante
            row.createCell(cellIndex++).setCellValue(winrow.getAwayTeamName());

            //segunda posição da linha é a qualidade do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitado());
            
            //terceira posição da linha é a qualidade do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getIdVisitante());
            
            //quarta posição da linha é a qualidade do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getQualidadeVisitado());
            
            //quinta posição da linha é a qualidade do visitante
            row.createCell(cellIndex++).setCellValue(winrow.getQualidadeVisitante());

            //sexta posição da linha são os dias de descanso do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getFR_diasDescansoVisitado());
            
            //sétima posição da linha são os dias de descanso do visitante 
            row.createCell(cellIndex++).setCellValue(winrow.getFR_diasDescansoVisitante());
            
            //oitava posição da linha é o rating de vitórias do visitado nos últimos 5 jogos
            row.createCell(cellIndex++).setCellValue(winrow.getFR_ratingResultadoVisitado());

            //nona posição da linha é o rating de derrotas do visitante nos últimos 5 jogos
            row.createCell(cellIndex++).setCellValue(winrow.getFR_ratingResultadoVisitante());
            
            //décima posição da linha é a dificuldade dos últimos 5 jogos do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getFR_dificuldadeVisitado());
            
            //décima primeira posição da linha é a dificuldade dos últimos 5 jogos do visitante
            row.createCell(cellIndex++).setCellValue(winrow.getFR_dificuldadeVisistante());
            
            //décima segunda da linha é o número de históricos que o visitado enfrentou nos últimos 5 jogos
            row.createCell(cellIndex++).setCellValue(winrow.getFR_HistoricosVisitado());
            
            //décima terceira posição é o número de históricos com os quais o visitado enfrentou nos últimos 5 jogos
            row.createCell(cellIndex++).setCellValue(winrow.getFR_HistoricosVisitante());
            
            //décima quarta posição é o número de jogos do ciclo do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_numeroJogosVisitado());
            
            //décima quinta posição da linha é o número de jogos do ciclo do visitante 
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_numeroJogosVisitante());
            
            //décima sexta posição da linha é a dificuldade do ciclo do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_dificuldadeVisitado());
            
            //décima sétima posição da linha é a dificuldade do ciclo do visitante 
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_dificuldadeVisitante());
            
            //décima oitava posição da linha é o número de históricos no ciclo do visitado
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_HistoricosVisitado());
            
            //décima nona posição da linha é o número de históricos no ciclo do visitante 
            row.createCell(cellIndex++).setCellValue(winrow.getCiclo_HistoricosVisitante());
            
            //vigésima posição da linha é o rating de vitórias no head 2 head
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_ratingVitorias());
            
            //vigésima primeira posição da linha é o número de jogos considerados do head 2 head
            row.createCell(cellIndex++).setCellValue(winrow.getH2H_numeroJogos());
            
            //vigésima sétima posição da linha é o número de jogos do visitante no intervalo
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
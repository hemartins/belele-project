package pt.belele.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import pt.belele.project.algorithm.ExcelColumnsCalculation;
import pt.belele.project.algorithm.ExcelRow;
import pt.belele.project.algorithm.ProfRow;
import pt.belele.project.controllers.FixtureController;
import pt.belele.project.controllers.OddController;
import pt.belele.project.controllers.SeasonController;
import pt.belele.project.controllers.StandingController;
import pt.belele.project.controllers.TeamController;
import pt.belele.project.controllers.util.H2H;
import pt.belele.project.controllers.util.ResultCycle;
import pt.belele.project.controllers.util.TeamRating;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.FixtureStatus;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Result.ResultType;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;
import pt.belele.project.util.CSVReader;
import pt.belele.project.util.WriteToExcel;

public class Main {

	private static DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy");

	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("database.odb");
		EntityManager em = emf.createEntityManager();
		generateDatabase(em);
		//generateExcelFiles(em);
	}

	private static void generateDatabase(EntityManager em) {
		/*// INGLATERRA - PREMIER LEAGUE
		populateDatabase(em, "E0.csv", "0001", 0);
		populateDatabase(em, "E0.csv", "0102", 1);
		populateDatabase(em, "E0.csv", "0203", 2);
		populateDatabase(em, "E0.csv", "0304", 3);
		populateDatabase(em, "E0.csv", "0405", 4);
		populateDatabase(em, "E0.csv", "0506", 5);
		populateDatabase(em, "E0.csv", "0607", 6);
		populateDatabase(em, "E0.csv", "0708", 7);
		populateDatabase(em, "E0.csv", "0809", 8);
		populateDatabase(em, "E0.csv", "0910", 9);
		populateDatabase(em, "E0.csv", "1011", 10);
		populateDatabase(em, "E0.csv", "1112", 11);
		populateDatabase(em, "E0.csv", "1213", 12);
		populateDatabase(em, "E0.csv", "1314", 13);
		populateDatabase(em, "E0.csv", "1415", 14);

		// INGLATERRA - CHAMPIONSHIP
		populateDatabase(em, "E1.csv", "0001", 0);
		populateDatabase(em, "E1.csv", "0102", 1);
		populateDatabase(em, "E1.csv", "0203", 2);
		populateDatabase(em, "E1.csv", "0304", 3);
		populateDatabase(em, "E1.csv", "0405", 4);
		populateDatabase(em, "E1.csv", "0506", 5);
		populateDatabase(em, "E1.csv", "0607", 6);
		populateDatabase(em, "E1.csv", "0708", 7);
		populateDatabase(em, "E1.csv", "0809", 8);
		populateDatabase(em, "E1.csv", "0910", 9);
		populateDatabase(em, "E1.csv", "1011", 10);
		populateDatabase(em, "E1.csv", "1112", 11);
		populateDatabase(em, "E1.csv", "1213", 12);
		populateDatabase(em, "E1.csv", "1314", 13);
		populateDatabase(em, "E1.csv", "1415", 14);

		// INGLATERRA - LEAGUE 1
		populateDatabase(em, "E2.csv", "0001", 0);
		populateDatabase(em, "E2.csv", "0102", 1);
		populateDatabase(em, "E2.csv", "0203", 2);
		populateDatabase(em, "E2.csv", "0304", 3);
		populateDatabase(em, "E2.csv", "0405", 4);
		populateDatabase(em, "E2.csv", "0506", 5);
		populateDatabase(em, "E2.csv", "0607", 6);
		populateDatabase(em, "E2.csv", "0708", 7);
		populateDatabase(em, "E2.csv", "0809", 8);
		populateDatabase(em, "E2.csv", "0910", 9);
		populateDatabase(em, "E2.csv", "1011", 10);
		populateDatabase(em, "E2.csv", "1112", 11);
		populateDatabase(em, "E2.csv", "1213", 12);
		populateDatabase(em, "E2.csv", "1314", 13);
		populateDatabase(em, "E2.csv", "1415", 14);

		// ESCOCIA - PREMIER LEAGUE
		populateDatabase(em, "SC0.csv", "0001", 0);
		populateDatabase(em, "SC0.csv", "0102", 1);
		populateDatabase(em, "SC0.csv", "0203", 2);
		populateDatabase(em, "SC0.csv", "0304", 3);
		populateDatabase(em, "SC0.csv", "0405", 4);
		populateDatabase(em, "SC0.csv", "0506", 5);
		populateDatabase(em, "SC0.csv", "0607", 6);
		populateDatabase(em, "SC0.csv", "0708", 7);
		populateDatabase(em, "SC0.csv", "0809", 8);
		populateDatabase(em, "SC0.csv", "0910", 9);
		populateDatabase(em, "SC0.csv", "1011", 10);
		populateDatabase(em, "SC0.csv", "1112", 11);
		populateDatabase(em, "SC0.csv", "1213", 12);
		populateDatabase(em, "SC0.csv", "1314", 13);
		populateDatabase(em, "SC0.csv", "1415", 14);

		// ALEMANHA - BUNDESLIGA 1
		populateDatabase(em, "D1.csv", "0001", 0);
		populateDatabase(em, "D1.csv", "0102", 1);
		populateDatabase(em, "D1.csv", "0203", 2);
		populateDatabase(em, "D1.csv", "0304", 3);
		populateDatabase(em, "D1.csv", "0405", 4);
		populateDatabase(em, "D1.csv", "0506", 5);
		populateDatabase(em, "D1.csv", "0607", 6);
		populateDatabase(em, "D1.csv", "0708", 7);
		populateDatabase(em, "D1.csv", "0809", 8);
		populateDatabase(em, "D1.csv", "0910", 9);
		populateDatabase(em, "D1.csv", "1011", 10);
		populateDatabase(em, "D1.csv", "1112", 11);
		populateDatabase(em, "D1.csv", "1213", 12);
		populateDatabase(em, "D1.csv", "1314", 13);
		populateDatabase(em, "D1.csv", "1415", 14);

		// ALEMANHA - BUNDESLIGA 2
		populateDatabase(em, "D2.csv", "0001", 0);
		populateDatabase(em, "D2.csv", "0102", 1);
		populateDatabase(em, "D2.csv", "0203", 2);
		populateDatabase(em, "D2.csv", "0304", 3);
		populateDatabase(em, "D2.csv", "0405", 4);
		populateDatabase(em, "D2.csv", "0506", 5);
		populateDatabase(em, "D2.csv", "0607", 6);
		populateDatabase(em, "D2.csv", "0708", 7);
		populateDatabase(em, "D2.csv", "0809", 8);
		populateDatabase(em, "D2.csv", "0910", 9);
		populateDatabase(em, "D2.csv", "1011", 10);
		populateDatabase(em, "D2.csv", "1112", 11);
		populateDatabase(em, "D2.csv", "1213", 12);
		populateDatabase(em, "D2.csv", "1314", 13);
		populateDatabase(em, "D2.csv", "1415", 14);*/

		// ITALIA - SERIE A
		populateDatabase(em, "I1.csv", "0001", 0);
		populateDatabase(em, "I1.csv", "0102", 1);
		populateDatabase(em, "I1.csv", "0203", 2);
		populateDatabase(em, "I1.csv", "0304", 3);
		populateDatabase(em, "I1.csv", "0405", 4);
		populateDatabase(em, "I1.csv", "0506", 5);
		populateDatabase(em, "I1.csv", "0607", 6);
		populateDatabase(em, "I1.csv", "0708", 7);
		populateDatabase(em, "I1.csv", "0809", 8);
		populateDatabase(em, "I1.csv", "0910", 9);
		populateDatabase(em, "I1.csv", "1011", 10);
		populateDatabase(em, "I1.csv", "1112", 11);
		populateDatabase(em, "I1.csv", "1213", 12);
		populateDatabase(em, "I1.csv", "1314", 13);
		populateDatabase(em, "I1.csv", "1415", 14);

		/*// ITALIA - SERIE B
		populateDatabase(em, "I2.csv", "0001", 0);
		populateDatabase(em, "I2.csv", "0102", 1);
		populateDatabase(em, "I2.csv", "0203", 2);
		populateDatabase(em, "I2.csv", "0304", 3);
		populateDatabase(em, "I2.csv", "0405", 4);
		populateDatabase(em, "I2.csv", "0506", 5);
		populateDatabase(em, "I2.csv", "0607", 6);
		populateDatabase(em, "I2.csv", "0708", 7);
		populateDatabase(em, "I2.csv", "0809", 8);
		populateDatabase(em, "I2.csv", "0910", 9);
		populateDatabase(em, "I2.csv", "1011", 10);
		populateDatabase(em, "I2.csv", "1112", 11);
		populateDatabase(em, "I2.csv", "1213", 12);
		populateDatabase(em, "I2.csv", "1314", 13);
		populateDatabase(em, "I2.csv", "1415", 14);

		// ESPANHA - LA LIGA PRIMERA DIVISION
		populateDatabase(em, "SP1.csv", "0001", 0);
		populateDatabase(em, "SP1.csv", "0102", 1);
		populateDatabase(em, "SP1.csv", "0203", 2);
		populateDatabase(em, "SP1.csv", "0304", 3);
		populateDatabase(em, "SP1.csv", "0405", 4);
		populateDatabase(em, "SP1.csv", "0506", 5);
		populateDatabase(em, "SP1.csv", "0607", 6);
		populateDatabase(em, "SP1.csv", "0708", 7);
		populateDatabase(em, "SP1.csv", "0809", 8);
		populateDatabase(em, "SP1.csv", "0910", 9);
		populateDatabase(em, "SP1.csv", "1011", 10);
		populateDatabase(em, "SP1.csv", "1112", 11);
		populateDatabase(em, "SP1.csv", "1213", 12);
		populateDatabase(em, "SP1.csv", "1314", 13);
		populateDatabase(em, "SP1.csv", "1415", 14);

		// ESPANHA - LA LIGA SEGUNDA DIVISION
		populateDatabase(em, "SP2.csv", "0001", 0);
		populateDatabase(em, "SP2.csv", "0102", 1);
		populateDatabase(em, "SP2.csv", "0203", 2);
		populateDatabase(em, "SP2.csv", "0304", 3);
		populateDatabase(em, "SP2.csv", "0405", 4);
		populateDatabase(em, "SP2.csv", "0506", 5);
		populateDatabase(em, "SP2.csv", "0607", 6);
		populateDatabase(em, "SP2.csv", "0708", 7);
		populateDatabase(em, "SP2.csv", "0809", 8);
		populateDatabase(em, "SP2.csv", "0910", 9);
		populateDatabase(em, "SP2.csv", "1011", 10);
		populateDatabase(em, "SP2.csv", "1112", 11);
		populateDatabase(em, "SP2.csv", "1213", 12);
		populateDatabase(em, "SP2.csv", "1314", 13);
		populateDatabase(em, "SP2.csv", "1415", 14);

		// FRANÇA - LE CHAMPIONNAT
		populateDatabase(em, "F1.csv", "0001", 0);
		populateDatabase(em, "F1.csv", "0102", 1);
		populateDatabase(em, "F1.csv", "0203", 2);
		populateDatabase(em, "F1.csv", "0304", 3);
		populateDatabase(em, "F1.csv", "0405", 4);
		populateDatabase(em, "F1.csv", "0506", 5);
		populateDatabase(em, "F1.csv", "0607", 6);
		populateDatabase(em, "F1.csv", "0708", 7);
		populateDatabase(em, "F1.csv", "0809", 8);
		populateDatabase(em, "F1.csv", "0910", 9);
		populateDatabase(em, "F1.csv", "1011", 10);
		populateDatabase(em, "F1.csv", "1112", 11);
		populateDatabase(em, "F1.csv", "1213", 12);
		populateDatabase(em, "F1.csv", "1314", 13);
		populateDatabase(em, "F1.csv", "1415", 14);

		// FRANÇA - DIVISION2
		populateDatabase(em, "F2.csv", "0001", 0);
		populateDatabase(em, "F2.csv", "0102", 1);
		populateDatabase(em, "F2.csv", "0203", 2);
		populateDatabase(em, "F2.csv", "0304", 3);
		populateDatabase(em, "F2.csv", "0405", 4);
		populateDatabase(em, "F2.csv", "0506", 5);
		populateDatabase(em, "F2.csv", "0607", 6);
		populateDatabase(em, "F2.csv", "0708", 7);
		populateDatabase(em, "F2.csv", "0809", 8);
		populateDatabase(em, "F2.csv", "0910", 9);
		populateDatabase(em, "F2.csv", "1011", 10);
		populateDatabase(em, "F2.csv", "1112", 11);
		populateDatabase(em, "F2.csv", "1213", 12);
		populateDatabase(em, "F2.csv", "1314", 13);
		populateDatabase(em, "F2.csv", "1415", 14);

		// HOLANDA - EREDIVISE
		populateDatabase(em, "N1.csv", "0001", 0);
		populateDatabase(em, "N1.csv", "0102", 1);
		populateDatabase(em, "N1.csv", "0203", 2);
		populateDatabase(em, "N1.csv", "0304", 3);
		populateDatabase(em, "N1.csv", "0405", 4);
		populateDatabase(em, "N1.csv", "0506", 5);
		populateDatabase(em, "N1.csv", "0607", 6);
		populateDatabase(em, "N1.csv", "0708", 7);
		populateDatabase(em, "N1.csv", "0809", 8);
		populateDatabase(em, "N1.csv", "0910", 9);
		populateDatabase(em, "N1.csv", "1011", 10);
		populateDatabase(em, "N1.csv", "1112", 11);
		populateDatabase(em, "N1.csv", "1213", 12);
		populateDatabase(em, "N1.csv", "1314", 13);
		populateDatabase(em, "N1.csv", "1415", 14);

		// BELGICA - JUPILER LEAGUE
		populateDatabase(em, "B1.csv", "0001", 0);
		populateDatabase(em, "B1.csv", "0102", 1);
		populateDatabase(em, "B1.csv", "0203", 2);
		populateDatabase(em, "B1.csv", "0304", 3);
		populateDatabase(em, "B1.csv", "0405", 4);
		populateDatabase(em, "B1.csv", "0506", 5);
		populateDatabase(em, "B1.csv", "0607", 6);
		populateDatabase(em, "B1.csv", "0708", 7);
		populateDatabase(em, "B1.csv", "0809", 8);
		populateDatabase(em, "B1.csv", "0910", 9);
		populateDatabase(em, "B1.csv", "1011", 10);
		populateDatabase(em, "B1.csv", "1112", 11);
		populateDatabase(em, "B1.csv", "1213", 12);
		populateDatabase(em, "B1.csv", "1314", 13);
		populateDatabase(em, "B1.csv", "1415", 14);

		// PORTUGAL - PRIMEIRA LIGA
		populateDatabase(em, "P1.csv", "0001", 0);
		populateDatabase(em, "P1.csv", "0102", 1);
		populateDatabase(em, "P1.csv", "0203", 2);
		populateDatabase(em, "P1.csv", "0304", 3);
		populateDatabase(em, "P1.csv", "0405", 4);
		populateDatabase(em, "P1.csv", "0506", 5);
		populateDatabase(em, "P1.csv", "0607", 6);
		populateDatabase(em, "P1.csv", "0708", 7);
		populateDatabase(em, "P1.csv", "0809", 8);
		populateDatabase(em, "P1.csv", "0910", 9);
		populateDatabase(em, "P1.csv", "1011", 10);
		populateDatabase(em, "P1.csv", "1112", 11);
		populateDatabase(em, "P1.csv", "1213", 12);
		populateDatabase(em, "P1.csv", "1314", 13);
		populateDatabase(em, "P1.csv", "1415", 14);

		// TURQUIA - FUTBOL LIGI 1
		populateDatabase(em, "T1.csv", "0001", 0);
		populateDatabase(em, "T1.csv", "0102", 1);
		populateDatabase(em, "T1.csv", "0203", 2);
		populateDatabase(em, "T1.csv", "0304", 3);
		populateDatabase(em, "T1.csv", "0405", 4);
		populateDatabase(em, "T1.csv", "0506", 5);
		populateDatabase(em, "T1.csv", "0607", 6);
		populateDatabase(em, "T1.csv", "0708", 7);
		populateDatabase(em, "T1.csv", "0809", 8);
		populateDatabase(em, "T1.csv", "0910", 9);
		populateDatabase(em, "T1.csv", "1011", 10);
		populateDatabase(em, "T1.csv", "1112", 11);
		populateDatabase(em, "T1.csv", "1213", 12);
		populateDatabase(em, "T1.csv", "1314", 13);
		populateDatabase(em, "T1.csv", "1415", 14);

		// GRECIA - ETHNIKI KATIGORIA
		populateDatabase(em, "G1.csv", "0001", 0);
		populateDatabase(em, "G1.csv", "0102", 1);
		populateDatabase(em, "G1.csv", "0203", 2);
		populateDatabase(em, "G1.csv", "0304", 3);
		populateDatabase(em, "G1.csv", "0405", 4);
		populateDatabase(em, "G1.csv", "0506", 5);
		populateDatabase(em, "G1.csv", "0607", 6);
		populateDatabase(em, "G1.csv", "0708", 7);
		populateDatabase(em, "G1.csv", "0809", 8);
		populateDatabase(em, "G1.csv", "0910", 9);
		populateDatabase(em, "G1.csv", "1011", 10);
		populateDatabase(em, "G1.csv", "1112", 11);
		populateDatabase(em, "G1.csv", "1213", 12);
		populateDatabase(em, "G1.csv", "1314", 13);
		populateDatabase(em, "G1.csv", "1415", 14);*/
	}

	private static void generateExcelFiles(EntityManager em) {

		SeasonController sc = new SeasonController(em);

		String dir = "/Users/Ricardo/Desktop/";

		/*
		 * //INGLATERRA - PREMIER LEAGUE Season e14 = sc.createSeason("E0", 14);
		 * runAlgorithm(e14, em, dir, true, true);
		 * 
		 * Season e13 = sc.createSeason("E0", 13); runAlgorithm(e13, em, dir,
		 * true, true);
		 * 
		 * Season e12 = sc.createSeason("E0", 12); runAlgorithm(e12, em, dir,
		 * true, true);
		 * 
		 * Season e11 = sc.createSeason("E0", 11); runAlgorithm(e11, em, dir,
		 * true, true);
		 * 
		 * Season e10 = sc.createSeason("E0", 10); runAlgorithm(e10, em, dir,
		 * true, true);
		 * 
		 * // INGLATERRA - PREMIERSHIP Season ee14 = sc.createSeason("E1", 14);
		 * runAlgorithm(ee14, em, dir, true, true);
		 * 
		 * Season ee13 = sc.createSeason("E1", 13); runAlgorithm(ee13, em, dir,
		 * true, true);
		 * 
		 * Season ee12 = sc.createSeason("E1", 12); runAlgorithm(ee12, em, dir,
		 * true, true);
		 * 
		 * Season ee11 = sc.createSeason("E1", 11); runAlgorithm(ee11, em, dir,
		 * true, true);
		 * 
		 * Season ee10 = sc.createSeason("E1", 10); runAlgorithm(ee10, em, dir,
		 * true, true);
		 * 
		 * // INGLATERRA - LEAGUE 1 Season eee14 = sc.createSeason("E2", 14);
		 * runAlgorithm(eee14, em, dir, true, true);
		 * 
		 * Season eee13 = sc.createSeason("E2", 13); runAlgorithm(eee13, em,
		 * dir, true, true);
		 * 
		 * Season eee12 = sc.createSeason("E2", 12); runAlgorithm(eee12, em,
		 * dir, true, true);
		 * 
		 * Season eee11 = sc.createSeason("E2", 11); runAlgorithm(eee11, em,
		 * dir, true, true);
		 * 
		 * Season eee10 = sc.createSeason("E2", 10); runAlgorithm(eee10, em,
		 * dir, true, true);
		 */

		/*
		 * // ESCOCIA - PREMIER LEAGUE Season sc14 = sc.createSeason("SC0", 14);
		 * runAlgorithm(sc14, em, dir, true, true);
		 * 
		 * Season sc13 = sc.createSeason("SC0", 13); runAlgorithm(sc13, em, dir,
		 * true, true);
		 * 
		 * Season sc12 = sc.createSeason("SC0", 12); runAlgorithm(sc12, em, dir,
		 * true, true);
		 * 
		 * Season sc11 = sc.createSeason("SC0", 11); runAlgorithm(sc11, em, dir,
		 * true, true);
		 * 
		 * Season sc10 = sc.createSeason("SC0", 10); runAlgorithm(sc10, em, dir,
		 * true, true);
		 */

		/*
		 * // ALEMANHA - BUNDESLIGA1 Season d14 = sc.createSeason("D1", 14);
		 * runAlgorithm(d14, em, dir, true, true);
		 * 
		 * Season d13 = sc.createSeason("D1", 13); runAlgorithm(d13, em, dir,
		 * true, true);
		 * 
		 * Season d12 = sc.createSeason("D1", 12); runAlgorithm(d12, em, dir,
		 * true, true);
		 * 
		 * Season d11 = sc.createSeason("D1", 11); runAlgorithm(d11, em, dir,
		 * true, true);
		 * 
		 * Season d10 = sc.createSeason("D1", 10); runAlgorithm(d10, em, dir,
		 * true, true);
		 * 
		 * // ALEMANHA - BUNDESLIGA2 Season dd14 = sc.createSeason("D2", 14);
		 * runAlgorithm(dd14, em, dir, true, true);
		 * 
		 * Season dd13 = sc.createSeason("D2", 13); runAlgorithm(dd13, em, dir,
		 * true, true);
		 * 
		 * Season dd12 = sc.createSeason("D2", 12); runAlgorithm(dd12, em, dir,
		 * true, true);
		 * 
		 * Season dd11 = sc.createSeason("D2", 11); runAlgorithm(dd11, em, dir,
		 * true, true);
		 * 
		 * Season dd10 = sc.createSeason("D2", 10); runAlgorithm(dd10, em, dir,
		 * true, true);
		 */

		// ITALIA - SERIE A
		Season i14 = sc.createSeason("I1", 14);
		runAlgorithm(i14, em, dir, true, true);

		Season i13 = sc.createSeason("I1", 13);
		runAlgorithm(i13, em, dir, true, true);

		Season i12 = sc.createSeason("I1", 12);
		runAlgorithm(i12, em, dir, true, true);

		Season i11 = sc.createSeason("I1", 11);
		runAlgorithm(i11, em, dir, true, true);

		Season i10 = sc.createSeason("I1", 10);
		runAlgorithm(i10, em, dir, true, true);

		/*
		 * // ITALIA - SERIE B Season ii14 = sc.createSeason("I2", 14);
		 * runAlgorithm(ii14, em, dir, true, true);
		 * 
		 * Season ii13 = sc.createSeason("I2", 13); runAlgorithm(ii13, em, dir,
		 * true, true);
		 * 
		 * Season ii12 = sc.createSeason("I2", 12); runAlgorithm(ii12, em, dir,
		 * true, true);
		 * 
		 * Season ii11 = sc.createSeason("I2", 11); runAlgorithm(ii11, em, dir,
		 * true, true);
		 * 
		 * Season ii10 = sc.createSeason("I2", 10); runAlgorithm(ii10, em, dir,
		 * true, true);
		 * 
		 * // ESPANHA - LA LIGA PRIMERA DIVISION Season sp14 =
		 * sc.createSeason("SP1", 14); runAlgorithm(sp14, em, dir, true, true);
		 * 
		 * Season sp13 = sc.createSeason("SP1", 13); runAlgorithm(sp13, em, dir,
		 * true, true);
		 * 
		 * Season sp12 = sc.createSeason("SP1", 12); runAlgorithm(sp12, em, dir,
		 * true, true);
		 * 
		 * Season sp11 = sc.createSeason("SP1", 11); runAlgorithm(sp11, em, dir,
		 * true, true);
		 * 
		 * Season sp10 = sc.createSeason("SP1", 10); runAlgorithm(sp10, em, dir,
		 * true, true);
		 * 
		 * // ESPANHA - LA LIGA SEGUNDA DIVISION Season spsp14 =
		 * sc.createSeason("SP2", 14); runAlgorithm(spsp14, em, dir, true,
		 * true);
		 * 
		 * Season spsp13 = sc.createSeason("SP2", 13); runAlgorithm(spsp13, em,
		 * dir, true, true);
		 * 
		 * Season spsp12 = sc.createSeason("SP2", 12); runAlgorithm(spsp12, em,
		 * dir, true, true);
		 * 
		 * Season spsp11 = sc.createSeason("SP2", 11); runAlgorithm(spsp11, em,
		 * dir, true, true);
		 * 
		 * Season spsp10 = sc.createSeason("SP2", 10); runAlgorithm(spsp10, em,
		 * dir, true, true);
		 * 
		 * // FRANÇA - CHAMPIONNAT Season f14 = sc.createSeason("F1", 14);
		 * runAlgorithm(f14, em, dir, true, true);
		 * 
		 * Season f13 = sc.createSeason("F1", 13); runAlgorithm(f13, em, dir,
		 * true, true);
		 * 
		 * Season f12 = sc.createSeason("F1", 12); runAlgorithm(f12, em, dir,
		 * true, true);
		 * 
		 * Season f11 = sc.createSeason("F1", 11); runAlgorithm(f11, em, dir,
		 * true, true);
		 * 
		 * Season f10 = sc.createSeason("F1", 10); runAlgorithm(f10, em, dir,
		 * true, true);
		 * 
		 * // FRANÇA - DIVISION2 Season ff14 = sc.createSeason("F2", 14);
		 * runAlgorithm(ff14, em, dir, true, true);
		 * 
		 * Season ff13 = sc.createSeason("F2", 13); runAlgorithm(ff13, em, dir,
		 * true, true);
		 * 
		 * Season ff12 = sc.createSeason("F2", 12); runAlgorithm(ff12, em, dir,
		 * true, true);
		 * 
		 * Season ff11 = sc.createSeason("F2", 11); runAlgorithm(ff11, em, dir,
		 * true, true);
		 * 
		 * Season ff10 = sc.createSeason("F2", 10); runAlgorithm(ff10, em, dir,
		 * true, true);
		 * 
		 * // HOLANDA - EREDIVISE Season n14 = sc.createSeason("N1", 14);
		 * runAlgorithm(n14, em, dir, true, true);
		 * 
		 * Season n13 = sc.createSeason("N1", 13); runAlgorithm(n13, em, dir,
		 * true, true);
		 * 
		 * Season n12 = sc.createSeason("N1", 12); runAlgorithm(n12, em, dir,
		 * true, true);
		 * 
		 * Season n11 = sc.createSeason("N1", 11); runAlgorithm(n11, em, dir,
		 * true, true);
		 * 
		 * Season n10 = sc.createSeason("N1", 10); runAlgorithm(n10, em, dir,
		 * true, true);
		 * 
		 * // BÉLGICA - JUPILER LEAGUE Season b14 = sc.createSeason("B1", 14);
		 * runAlgorithm(b14, em, dir, true, true);
		 * 
		 * Season b13 = sc.createSeason("B1", 13); runAlgorithm(b13, em, dir,
		 * true, true);
		 * 
		 * Season b12 = sc.createSeason("B1", 12); runAlgorithm(b12, em, dir,
		 * true, true);
		 * 
		 * Season b11 = sc.createSeason("B1", 11); runAlgorithm(b11, em, dir,
		 * true, true);
		 * 
		 * Season b10 = sc.createSeason("B1", 10); runAlgorithm(b10, em, dir,
		 * true, true);
		 * 
		 * // PORTUGAL - PRIMEIRA LIGA Season p14 = sc.createSeason("P1", 14);
		 * runAlgorithm(p14, em, dir, true, true);
		 * 
		 * Season p13 = sc.createSeason("P1", 13); runAlgorithm(p13, em, dir,
		 * true, true);
		 * 
		 * Season p12 = sc.createSeason("P1", 12); runAlgorithm(p12, em, dir,
		 * true, true);
		 * 
		 * Season p11 = sc.createSeason("P1", 11); runAlgorithm(p11, em, dir,
		 * true, true);
		 * 
		 * Season p10 = sc.createSeason("P1", 10); runAlgorithm(p10, em, dir,
		 * true, true);
		 * 
		 * // TURQUIA - FUTBOL LIGI 1 Season t14 = sc.createSeason("T1", 14);
		 * runAlgorithm(t14, em, dir, true, true);
		 * 
		 * Season t13 = sc.createSeason("T1", 13); runAlgorithm(t13, em, dir,
		 * true, true);
		 * 
		 * Season t12 = sc.createSeason("T1", 12); runAlgorithm(t12, em, dir,
		 * true, true);
		 * 
		 * Season t11 = sc.createSeason("T1", 11); runAlgorithm(t11, em, dir,
		 * true, true);
		 * 
		 * Season t10 = sc.createSeason("T1", 10); runAlgorithm(t10, em, dir,
		 * true, true);
		 * 
		 * // GRÉCIA - ETHNIKI KATIGORIA Season g14 = sc.createSeason("G1", 14);
		 * runAlgorithm(g14, em, dir, true, true);
		 * 
		 * Season g13 = sc.createSeason("G1", 13); runAlgorithm(g13, em, dir,
		 * true, true);
		 * 
		 * Season g12 = sc.createSeason("G1", 12); runAlgorithm(g12, em, dir,
		 * true, true);
		 * 
		 * Season g11 = sc.createSeason("G1", 11); runAlgorithm(g11, em, dir,
		 * true, true);
		 * 
		 * Season g10 = sc.createSeason("G1", 10); runAlgorithm(g10, em, dir,
		 * true, true);
		 */

	}

	private static void runAlgorithm(Season s, EntityManager em, String filePath, boolean generateProf,
			boolean generateOurs) {

		WriteToExcel writeToExcelObj = new WriteToExcel(filePath);

		List<ExcelRow> OurWinDataList = new ArrayList<ExcelRow>();
		List<ExcelRow> OurDrawDataList = new ArrayList<ExcelRow>();
		List<ExcelRow> OurLoseDataList = new ArrayList<ExcelRow>();

		List<ProfRow> ProfWinDataList = new ArrayList<ProfRow>();
		List<ProfRow> ProfDrawDataList = new ArrayList<ProfRow>();
		List<ProfRow> ProfLoseDataList = new ArrayList<ProfRow>();

		List<String> historicos = new ArrayList<String>();

		// INGLATERRA
		historicos.add("Chelsea");
		historicos.add("Arsenal");
		historicos.add("Liverpool");
		historicos.add("Man City");
		historicos.add("Man United");

		// ESCOCIA
		historicos.add("Rangers");
		historicos.add("Celtic");

		// ALEMANHA
		historicos.add("Bayern Munich");
		historicos.add("Dortmund");
		historicos.add("Schalke 04");
		// historicos.add("Leverkusen");

		// ITALIA
		historicos.add("Juventus");
		historicos.add("Roma");
		historicos.add("Milan");
		historicos.add("Inter");
		historicos.add("Napoli");

		// ESPANHA
		historicos.add("Ath Madrid");
		historicos.add("Barcelona");
		historicos.add("Real Madrid");
		historicos.add("Valencia");

		// FRANÇA
		historicos.add("Paris SG");
		historicos.add("Marseille");
		historicos.add("Lyon");

		// HOLANDA
		historicos.add("Ajax");
		historicos.add("PSV Eindhoven");

		// BELGICA
		historicos.add("Anderlecht");
		historicos.add("Standard");

		// PORTUGAL
		historicos.add("Benfica");
		historicos.add("Porto");
		historicos.add("Sp Lisbon");

		// TURQUIA
		historicos.add("Fenerbahce");
		historicos.add("Besiktas");
		historicos.add("Galatasaray");

		// GRECIA
		historicos.add("Olympiakos");
		historicos.add("Panathinaikos");
		// historicos.add("PAOK");
		// historicos.add("AEK");

		List<Double> ratings = new ArrayList<Double>();
		ratings.add(0.3);
		ratings.add(0.25);
		ratings.add(0.2);
		ratings.add(0.15);
		ratings.add(0.1);

		List<Double> ratingsH2H = new ArrayList<Double>();
		ratingsH2H.add(0.2);
		ratingsH2H.add(0.19);
		ratingsH2H.add(0.17);
		ratingsH2H.add(0.14);
		ratingsH2H.add(0.1);
		ratingsH2H.add(0.06);
		ratingsH2H.add(0.05);
		ratingsH2H.add(0.04);
		ratingsH2H.add(0.03);
		ratingsH2H.add(0.02);

		double interval = 0.15;

		for (Fixture f : s.getFixtures()) {

			logger.debug(f.toString());

			if (f.getDate().before(formatter.parseDateTime("23/11/" + s.getYear()).toDate()))
				continue;

			ExcelColumnsCalculation homeTeam = new ExcelColumnsCalculation(f.getHomeTeam(), em);
			ExcelColumnsCalculation awayTeam = new ExcelColumnsCalculation(f.getAwayTeam(), em);

			Date data = f.getDate();
			Long idVisitado = f.getHomeTeam().getId();
			Long idVisitante = f.getAwayTeam().getId();
			Double qualidadeVisitado = homeTeam.getTeamQuality(s, f.getDate());
			Double qualidadeVisitante = awayTeam.getTeamQuality(s, f.getDate());

			Double qualidadeVisitadoCasa = homeTeam.getHomeTeamQuality(s, f.getDate());
			Double qualidadeVisitanteFora = awayTeam.getAwayTeamQuality(s, f.getDate());

			Integer fR_diasDescansoVisitado = homeTeam.getRestingDays(f);
			Integer fR_diasDescansoVisitante = awayTeam.getRestingDays(f);
			Double fR_ratingVitoriasVisitado = homeTeam.getLastFixturesRating(f, null, 5, ratings, ResultType.WIN);
			Double fR_ratingDerrotasVisitante = awayTeam.getLastFixturesRating(f, null, 5, ratings, ResultType.LOSE);

			Integer fR_VitoriasVisitado = homeTeam.getLastFixturesResults(f, null, 5, ratings, ResultType.WIN);
			Integer fR_DerrotasVisitante = awayTeam.getLastFixturesResults(f, null, 5, ratings, ResultType.LOSE);

			Double fR_dificuldadeVisitado = homeTeam.getLastFixturesOpponentAverageQuality(f, null, 5);
			Double fR_dificuldadeVisistante = awayTeam.getLastFixturesOpponentAverageQuality(f, null, 5);
			Integer fR_HistoricosVisitado = homeTeam.getLastHardGamesFixturesNumber(f, null, 5, historicos);
			Integer fR_HistoricosVisitante = awayTeam.getLastHardGamesFixturesNumber(f, null, 5, historicos);
			ResultCycle homeWinCycle = homeTeam.getTeamCycle(f, Venue.HOME, ResultType.WIN);
			ResultCycle awayLoseCycle = awayTeam.getTeamCycle(f, Venue.AWAY, ResultType.LOSE);
			Integer homeWinCycle_numeroJogosVisitado = homeWinCycle.getCycle();
			Integer awayLoseCycle_numeroJogosVisitante = awayLoseCycle.getCycle();
			Double homeWinCycle_dificuldadeVisitado = homeTeam.getCycleOpponentAverageQuality(homeWinCycle);
			Double awayLoseCycle_dificuldadeVisitante = awayTeam.getCycleOpponentAverageQuality(awayLoseCycle);
			Integer homeWinCycle_HistoricosVisitado = homeTeam.getCycleHardGamesNumber(homeWinCycle, historicos);
			Integer awayLoseCycle_HistoricosVisitante = awayTeam.getCycleHardGamesNumber(awayLoseCycle, historicos);
			H2H h2hRatings = homeTeam.getH2HRating(f, ratings, Venue.HOME, ResultType.WIN);
			Double h2hWin_rating = h2hRatings.getRating();
			Integer h2hWin_numeroJogos = h2hRatings.getSize();

			Integer winH2hResults = h2hRatings.getNumberResults();

			// Integer h2hWin_numeroJogos = f.getH2h().size();
			ResultType result = homeTeam.getResultType(f);

			Double fR_ratingEmpatesVisitado = homeTeam.getLastFixturesRating(f, null, 5, ratings, ResultType.DRAW);
			Double fR_ratingEmpatesVisitante = awayTeam.getLastFixturesRating(f, null, 5, ratings, ResultType.DRAW);

			Integer fR_EmpatesVisitado = homeTeam.getLastFixturesResults(f, null, 5, ratings, ResultType.DRAW);
			Integer fR_EmpatesVisitante = awayTeam.getLastFixturesResults(f, null, 5, ratings, ResultType.DRAW);

			ResultCycle homeDrawCycle = homeTeam.getTeamCycle(f, Venue.HOME, ResultType.DRAW);
			ResultCycle awayDrawCycle = awayTeam.getTeamCycle(f, Venue.AWAY, ResultType.DRAW);
			Integer homeDrawCycle_numeroJogosVisitado = homeDrawCycle.getCycle();
			Integer awayDrawCycle_numeroJogosVisitante = awayDrawCycle.getCycle();
			Double homeDrawCycle_dificuldadeVisitado = homeTeam.getCycleOpponentAverageQuality(homeDrawCycle);
			Double awayDrawCycle_dificuldadeVisitante = awayTeam.getCycleOpponentAverageQuality(awayDrawCycle);
			Integer homeDrawCycle_HistoricosVisitado = homeTeam.getCycleHardGamesNumber(homeDrawCycle, historicos);
			Integer awayDrawCycle_HistoricosVisitante = awayTeam.getCycleHardGamesNumber(awayDrawCycle, historicos);
			h2hRatings = homeTeam.getH2HRating(f, ratings, Venue.HOME, ResultType.DRAW);
			Double h2hDraw_rating = h2hRatings.getRating();
			Integer h2hDraw_numeroJogos = h2hRatings.getSize();

			Integer drawH2hResults = h2hRatings.getNumberResults();

			Double fR_ratingDerrotasVisitado = homeTeam.getLastFixturesRating(f, null, 5, ratings, ResultType.LOSE);
			Double fR_ratingVitoriasVisitante = awayTeam.getLastFixturesRating(f, null, 5, ratings, ResultType.WIN);

			Integer fR_DerrotasVisitado = homeTeam.getLastFixturesResults(f, null, 5, ratings, ResultType.LOSE);
			Integer fR_VitoriasVisitante = awayTeam.getLastFixturesResults(f, null, 5, ratings, ResultType.WIN);

			ResultCycle homeLoseCycle = homeTeam.getTeamCycle(f, Venue.HOME, ResultType.LOSE);
			ResultCycle awayWinCycle = awayTeam.getTeamCycle(f, Venue.AWAY, ResultType.WIN);
			Integer homeLoseCycle_numeroJogosVisitado = homeLoseCycle.getCycle();
			Integer awayWinCycle_numeroJogosVisitante = awayWinCycle.getCycle();
			Double homeLoseCycle_dificuldadeVisitado = homeTeam.getCycleOpponentAverageQuality(homeLoseCycle);
			Double awayWinCycle_dificuldadeVisitante = awayTeam.getCycleOpponentAverageQuality(awayWinCycle);
			Integer homeLoseCycle_HistoricosVisitado = homeTeam.getCycleHardGamesNumber(homeLoseCycle, historicos);
			Integer awayWinCycle_HistoricosVisitante = awayTeam.getCycleHardGamesNumber(awayWinCycle, historicos);
			h2hRatings = homeTeam.getH2HRating(f, ratings, Venue.HOME, ResultType.LOSE);
			Double h2hLose_rating = h2hRatings.getRating();
			Integer h2hLose_numeroJogos = h2hRatings.getSize();

			Integer loseH2hResults = h2hRatings.getNumberResults();

			// CICLO PERNA

			ResultCycle homeWinCyclePerna = homeTeam.getTeamCyclePerna(f, Venue.HOME, ResultType.WIN);
			ResultCycle awayLoseCyclePerna = awayTeam.getTeamCyclePerna(f, Venue.AWAY, ResultType.LOSE);
			Integer homeWinCyclePerna_numeroJogosVisitado = homeWinCyclePerna.getCycle();
			Integer awayLoseCyclePerna_numeroJogosVisitante = awayLoseCyclePerna.getCycle();
			Double homeWinCyclePerna_dificuldadeVisitado = homeTeam.getCycleOpponentAverageQuality(homeWinCyclePerna);
			Double awayLoseCyclePerna_dificuldadeVisitante = awayTeam
					.getCycleOpponentAverageQuality(awayLoseCyclePerna);
			Integer homeWinCyclePerna_HistoricosVisitado = homeTeam.getCycleHardGamesNumber(homeWinCyclePerna,
					historicos);
			Integer awayLoseCyclePerna_HistoricosVisitante = awayTeam.getCycleHardGamesNumber(awayLoseCyclePerna,
					historicos);

			ResultCycle homeDrawCyclePerna = homeTeam.getTeamCyclePerna(f, Venue.HOME, ResultType.DRAW);
			ResultCycle awayDrawCyclePerna = awayTeam.getTeamCyclePerna(f, Venue.AWAY, ResultType.DRAW);
			Integer homeDrawCyclePerna_numeroJogosVisitado = homeDrawCyclePerna.getCycle();
			Integer awayDrawCyclePerna_numeroJogosVisitante = awayDrawCyclePerna.getCycle();
			Double homeDrawCyclePerna_dificuldadeVisitado = homeTeam.getCycleOpponentAverageQuality(homeDrawCyclePerna);
			Double awayDrawCyclePerna_dificuldadeVisitante = awayTeam
					.getCycleOpponentAverageQuality(awayDrawCyclePerna);
			Integer homeDrawCyclePerna_HistoricosVisitado = homeTeam.getCycleHardGamesNumber(homeDrawCyclePerna,
					historicos);
			Integer awayDrawCyclePerna_HistoricosVisitante = awayTeam.getCycleHardGamesNumber(awayDrawCyclePerna,
					historicos);

			ResultCycle homeLoseCyclePerna = homeTeam.getTeamCyclePerna(f, Venue.HOME, ResultType.LOSE);
			ResultCycle awayWinCyclePerna = awayTeam.getTeamCyclePerna(f, Venue.AWAY, ResultType.WIN);
			Integer homeLoseCyclePerna_numeroJogosVisitado = homeLoseCyclePerna.getCycle();
			Integer awayWinCyclePerna_numeroJogosVisitante = awayWinCyclePerna.getCycle();
			Double homeLoseCyclePerna_dificuldadeVisitado = homeTeam.getCycleOpponentAverageQuality(homeLoseCyclePerna);
			Double awayWinCyclePerna_dificuldadeVisitante = awayTeam.getCycleOpponentAverageQuality(awayWinCyclePerna);
			Integer homeLoseCyclePerna_HistoricosVisitado = homeTeam.getCycleHardGamesNumber(homeLoseCyclePerna,
					historicos);
			Integer awayWinCyclePerna_HistoricosVisitante = awayTeam.getCycleHardGamesNumber(awayWinCyclePerna,
					historicos);

			// FIM CICLO PERNA

			// RATING COM QUALIDADE DO ADVERSARIO

			Double fR_ratingQualidadeVitoriasVisitado = homeTeam.getLastFixturesRatingQuality(f, null, 5, ratings,
					ResultType.WIN);
			Double fR_ratingQualidadeDerrotasVisitante = awayTeam.getLastFixturesRatingQuality(f, null, 5, ratings,
					ResultType.LOSE);
			Double fR_ratingQualidadeEmpatesVisitado = homeTeam.getLastFixturesRatingQuality(f, null, 5, ratings,
					ResultType.DRAW);
			Double fR_ratingQualidadeEmpatesVisitante = awayTeam.getLastFixturesRatingQuality(f, null, 5, ratings,
					ResultType.DRAW);
			Double fR_ratingQualidadeDerrotasVisitado = homeTeam.getLastFixturesRatingQuality(f, null, 5, ratings,
					ResultType.LOSE);
			Double fR_ratingQualidadeVitoriasVisitante = awayTeam.getLastFixturesRatingQuality(f, null, 5, ratings,
					ResultType.WIN);

			// FIM RATING COM QUALIDADE DO ADVERSARIO

			// GOLOS

			Integer golosVisitado = homeTeam.getGoals(s, f.getDate());
			Integer golosContraVisitado = homeTeam.getGoalsAgainst(s, f.getDate());
			Integer diferencaGolosVisitado = homeTeam.getGoalsDifference(s, f.getDate());
			Integer golosVisitante = awayTeam.getGoals(s, f.getDate());
			Integer golosContraVisitante = awayTeam.getGoalsAgainst(s, f.getDate());
			Integer diferencaGolosVisitante = awayTeam.getGoalsDifference(s, f.getDate());
			Integer golosVisitadoCasa = homeTeam.getHomeGoals(s, f.getDate());
			Integer golosContraVisitadoCasa = homeTeam.getHomeGoalsAgainst(s, f.getDate());
			Integer diferencaGolosVisitadoCasa = homeTeam.getHomeGoalsDifference(s, f.getDate());
			Integer golosVisitanteFora = homeTeam.getAwayGoals(s, f.getDate());
			Integer golosContraVisitanteFora = awayTeam.getAwayGoalsAgainst(s, f.getDate());
			Integer diferencaGolosVisitanteFora = awayTeam.getAwayGoalsDifference(s, f.getDate());

			// FIM GOLOS

			// CLASSIFICACAO

			Integer classificacaoVisitado = homeTeam.getClassification(s, f.getDate());
			Integer classificacaoVisitante = awayTeam.getClassification(s, f.getDate());

			// FIM CLASSIFICACAO

			if (generateOurs) {
				TeamRating homeTR = homeTeam.getResultPercentage(f, Venue.HOME, ResultType.WIN, interval);
				TeamRating awayTR = awayTeam.getResultPercentage(f, Venue.AWAY, ResultType.LOSE, interval);
				Integer qLT_homeTeamNumeroJogos = homeTeam.getNumberOfFixtures(f, Venue.HOME);
				Integer qLT_awayTeamNumeroJogos = awayTeam.getNumberOfFixtures(f, Venue.AWAY);
				Double qLT_percentagemVitoriasVisitado = homeTR.getResultPercentage();
				Double qLT_percentagemDerrotasVisitante = awayTR.getResultPercentage();
				Double qLT_dificuldadeVitoriasVisitado = homeTR.getQualityAverage();
				Double qLT_dificuldadeDerrotasVisitante = awayTR.getQualityAverage();
				Double qLT_percentagemVitoriasVisitadoNoIntervalo = homeTR.getResultIntervalPercentage();
				Double qLT_percentagemDerrotasVisitanteNoIntervalo = awayTR.getResultIntervalPercentage();
				Integer qLT_numeroJogosVisitado = homeTR.getResultIntervalGames();
				Integer qLT_numeroJogosVisitante = awayTR.getResultIntervalGames();

				// TROCADO

				TeamRating homeTR2 = homeTeam.getResultPercentage(f, Venue.AWAY, ResultType.WIN, interval);
				TeamRating awayTR2 = awayTeam.getResultPercentage(f, Venue.HOME, ResultType.LOSE, interval);
				Integer qLT_homeTeamNumeroJogos2 = homeTeam.getNumberOfFixtures(f, Venue.AWAY);
				Integer qLT_awayTeamNumeroJogos2 = awayTeam.getNumberOfFixtures(f, Venue.HOME);
				Double qLT_percentagemVitoriasVisitado2 = homeTR.getResultPercentage();
				Double qLT_percentagemDerrotasVisitante2 = awayTR.getResultPercentage();
				Double qLT_dificuldadeVitoriasVisitado2 = homeTR.getQualityAverage();
				Double qLT_dificuldadeDerrotasVisitante2 = awayTR.getQualityAverage();
				Double qLT_percentagemVitoriasVisitadoNoIntervalo2 = homeTR.getResultIntervalPercentage();
				Double qLT_percentagemDerrotasVisitanteNoIntervalo2 = awayTR.getResultIntervalPercentage();
				Integer qLT_numeroJogosVisitado2 = homeTR.getResultIntervalGames();
				Integer qLT_numeroJogosVisitante2 = awayTR.getResultIntervalGames();

				ExcelRow wohwr = new ExcelRow(data, idVisitado, idVisitante, f.getHomeTeam().getName(),
						f.getAwayTeam().getName(), qualidadeVisitado, qualidadeVisitante, fR_diasDescansoVisitado,
						fR_diasDescansoVisitante, fR_ratingVitoriasVisitado, fR_ratingDerrotasVisitante,
						fR_dificuldadeVisitado, fR_dificuldadeVisistante, fR_HistoricosVisitado, fR_HistoricosVisitante,
						homeWinCycle_numeroJogosVisitado, awayLoseCycle_numeroJogosVisitante,
						homeWinCycle_dificuldadeVisitado, awayLoseCycle_dificuldadeVisitante,
						homeWinCycle_HistoricosVisitado, awayLoseCycle_HistoricosVisitante, h2hWin_rating,
						h2hWin_numeroJogos, qLT_percentagemVitoriasVisitado, qLT_percentagemDerrotasVisitante,
						qLT_dificuldadeVitoriasVisitado, qLT_dificuldadeDerrotasVisitante,
						qLT_percentagemVitoriasVisitadoNoIntervalo, qLT_percentagemDerrotasVisitanteNoIntervalo,
						qLT_numeroJogosVisitado, qLT_numeroJogosVisitante, result.equals(ResultType.WIN) ? 1 : 0,
						homeWinCyclePerna_numeroJogosVisitado, awayLoseCyclePerna_numeroJogosVisitante,
						homeWinCyclePerna_dificuldadeVisitado, awayLoseCyclePerna_dificuldadeVisitante,
						homeWinCyclePerna_HistoricosVisitado, awayLoseCyclePerna_HistoricosVisitante,
						fR_ratingQualidadeVitoriasVisitado, fR_ratingQualidadeDerrotasVisitante,
						qLT_homeTeamNumeroJogos, qLT_awayTeamNumeroJogos, qLT_homeTeamNumeroJogos2,
						qLT_awayTeamNumeroJogos2, qLT_percentagemVitoriasVisitado2, qLT_percentagemDerrotasVisitante2,
						qLT_dificuldadeVitoriasVisitado2, qLT_dificuldadeDerrotasVisitante2,
						qLT_percentagemVitoriasVisitadoNoIntervalo2, qLT_percentagemDerrotasVisitanteNoIntervalo2,
						qLT_numeroJogosVisitado2, qLT_numeroJogosVisitante2, winH2hResults, fR_VitoriasVisitado,
						fR_DerrotasVisitante, golosVisitado, golosContraVisitado, diferencaGolosVisitado,
						golosVisitante, golosContraVisitante, diferencaGolosVisitante, golosVisitadoCasa,
						golosContraVisitadoCasa, diferencaGolosVisitadoCasa, golosVisitanteFora,
						golosContraVisitanteFora, diferencaGolosVisitanteFora, classificacaoVisitado,
						classificacaoVisitante, qualidadeVisitadoCasa, qualidadeVisitanteFora);

				OurWinDataList.add(wohwr);

				homeTR = homeTeam.getResultPercentage(f, Venue.HOME, ResultType.DRAW, interval);
				awayTR = awayTeam.getResultPercentage(f, Venue.AWAY, ResultType.DRAW, interval);
				Double qLT_percentagemEmpatesVisitado = homeTR.getResultPercentage();
				Double qLT_percentagemEmpatesVisitante = awayTR.getResultPercentage();
				Double qLT_dificuldadeEmpatesVisitado = homeTR.getQualityAverage();
				Double qLT_dificuldadeEmpatesVisitante = awayTR.getQualityAverage();
				Double qLT_percentagemEmpatesVisitadoNoIntervalo = homeTR.getResultIntervalPercentage();
				Double qLT_percentagemEmpatesVisitanteNoIntervalo = awayTR.getResultIntervalPercentage();
				qLT_numeroJogosVisitado = homeTR.getResultIntervalGames();
				qLT_numeroJogosVisitante = awayTR.getResultIntervalGames();

				// TROCADO

				homeTR2 = homeTeam.getResultPercentage(f, Venue.AWAY, ResultType.DRAW, interval);
				awayTR2 = awayTeam.getResultPercentage(f, Venue.HOME, ResultType.DRAW, interval);
				Double qLT_percentagemEmpatesVisitado2 = homeTR.getResultPercentage();
				Double qLT_percentagemEmpatesVisitante2 = awayTR.getResultPercentage();
				Double qLT_dificuldadeEmpatesVisitado2 = homeTR.getQualityAverage();
				Double qLT_dificuldadeEmpatesVisitante2 = awayTR.getQualityAverage();
				Double qLT_percentagemEmpatesVisitadoNoIntervalo2 = homeTR.getResultIntervalPercentage();
				Double qLT_percentagemEmpatesVisitanteNoIntervalo2 = awayTR.getResultIntervalPercentage();
				qLT_numeroJogosVisitado2 = homeTR.getResultIntervalGames();
				qLT_numeroJogosVisitante2 = awayTR.getResultIntervalGames();

				ExcelRow dohwr = new ExcelRow(data, idVisitado, idVisitante, f.getHomeTeam().getName(),
						f.getAwayTeam().getName(), qualidadeVisitado, qualidadeVisitante, fR_diasDescansoVisitado,
						fR_diasDescansoVisitante, fR_ratingEmpatesVisitado, fR_ratingEmpatesVisitante,
						fR_dificuldadeVisitado, fR_dificuldadeVisistante, fR_HistoricosVisitado, fR_HistoricosVisitante,
						homeDrawCycle_numeroJogosVisitado, awayDrawCycle_numeroJogosVisitante,
						homeDrawCycle_dificuldadeVisitado, awayDrawCycle_dificuldadeVisitante,
						homeDrawCycle_HistoricosVisitado, awayDrawCycle_HistoricosVisitante, h2hDraw_rating,
						h2hDraw_numeroJogos, qLT_percentagemEmpatesVisitado, qLT_percentagemEmpatesVisitante,
						qLT_dificuldadeEmpatesVisitado, qLT_dificuldadeEmpatesVisitante,
						qLT_percentagemEmpatesVisitadoNoIntervalo, qLT_percentagemEmpatesVisitanteNoIntervalo,
						qLT_numeroJogosVisitado, qLT_numeroJogosVisitante, result.equals(ResultType.DRAW) ? 1 : 0,
						homeDrawCyclePerna_numeroJogosVisitado, awayDrawCyclePerna_numeroJogosVisitante,
						homeDrawCyclePerna_dificuldadeVisitado, awayDrawCyclePerna_dificuldadeVisitante,
						homeDrawCyclePerna_HistoricosVisitado, awayDrawCyclePerna_HistoricosVisitante,
						fR_ratingQualidadeEmpatesVisitado, fR_ratingQualidadeEmpatesVisitante, qLT_homeTeamNumeroJogos,
						qLT_awayTeamNumeroJogos, qLT_homeTeamNumeroJogos2, qLT_awayTeamNumeroJogos2,
						qLT_percentagemEmpatesVisitado2, qLT_percentagemEmpatesVisitante2,
						qLT_dificuldadeEmpatesVisitado2, qLT_dificuldadeEmpatesVisitante2,
						qLT_percentagemEmpatesVisitadoNoIntervalo2, qLT_percentagemEmpatesVisitanteNoIntervalo2,
						qLT_numeroJogosVisitado2, qLT_numeroJogosVisitante2, drawH2hResults, fR_EmpatesVisitado,
						fR_EmpatesVisitante, golosVisitado, golosContraVisitado, diferencaGolosVisitado,
						golosVisitante, golosContraVisitante, diferencaGolosVisitante, golosVisitadoCasa,
						golosContraVisitadoCasa, diferencaGolosVisitadoCasa, golosVisitanteFora,
						golosContraVisitanteFora, diferencaGolosVisitanteFora, classificacaoVisitado,
						classificacaoVisitante, qualidadeVisitadoCasa, qualidadeVisitanteFora);

				OurDrawDataList.add(dohwr);

				homeTR = homeTeam.getResultPercentage(f, Venue.HOME, ResultType.LOSE, interval);
				awayTR = awayTeam.getResultPercentage(f, Venue.AWAY, ResultType.WIN, interval);
				Double qLT_percentagemDerrotasVisitado = homeTR.getResultPercentage();
				Double qLT_percentagemVitoriasVisitante = awayTR.getResultPercentage();
				Double qLT_dificuldadeDerrotasVisitado = homeTR.getQualityAverage();
				Double qLT_dificuldadeVitoriasVisitante = awayTR.getQualityAverage();
				Double qLT_percentagemDerrotasVisitadoNoIntervalo = homeTR.getResultIntervalPercentage();
				Double qLT_percentagemVitoriasVisitanteNoIntervalo = awayTR.getResultIntervalPercentage();
				qLT_numeroJogosVisitado = homeTR.getResultIntervalGames();
				qLT_numeroJogosVisitante = awayTR.getResultIntervalGames();

				// TROCADO

				homeTR2 = homeTeam.getResultPercentage(f, Venue.HOME, ResultType.WIN, interval);
				awayTR2 = awayTeam.getResultPercentage(f, Venue.AWAY, ResultType.LOSE, interval);
				Double qLT_percentagemDerrotasVisitado2 = homeTR.getResultPercentage();
				Double qLT_percentagemVitoriasVisitante2 = awayTR.getResultPercentage();
				Double qLT_dificuldadeDerrotasVisitado2 = homeTR.getQualityAverage();
				Double qLT_dificuldadeVitoriasVisitante2 = awayTR.getQualityAverage();
				Double qLT_percentagemDerrotasVisitadoNoIntervalo2 = homeTR.getResultIntervalPercentage();
				Double qLT_percentagemVitoriasVisitanteNoIntervalo2 = awayTR.getResultIntervalPercentage();
				qLT_numeroJogosVisitado2 = homeTR.getResultIntervalGames();
				qLT_numeroJogosVisitante2 = awayTR.getResultIntervalGames();

				ExcelRow lohwr = new ExcelRow(data, idVisitado, idVisitante, f.getHomeTeam().getName(),
						f.getAwayTeam().getName(), qualidadeVisitado, qualidadeVisitante, fR_diasDescansoVisitado,
						fR_diasDescansoVisitante, fR_ratingDerrotasVisitado, fR_ratingVitoriasVisitante,
						fR_dificuldadeVisitado, fR_dificuldadeVisistante, fR_HistoricosVisitado, fR_HistoricosVisitante,
						homeLoseCycle_numeroJogosVisitado, awayWinCycle_numeroJogosVisitante,
						homeLoseCycle_dificuldadeVisitado, awayWinCycle_dificuldadeVisitante,
						homeLoseCycle_HistoricosVisitado, awayWinCycle_HistoricosVisitante, h2hLose_rating,
						h2hLose_numeroJogos, qLT_percentagemDerrotasVisitado, qLT_percentagemVitoriasVisitante,
						qLT_dificuldadeDerrotasVisitado, qLT_dificuldadeVitoriasVisitante,
						qLT_percentagemDerrotasVisitadoNoIntervalo, qLT_percentagemVitoriasVisitanteNoIntervalo,
						qLT_numeroJogosVisitado, qLT_numeroJogosVisitante, result.equals(ResultType.LOSE) ? 1 : 0,
						homeLoseCyclePerna_numeroJogosVisitado, awayWinCyclePerna_numeroJogosVisitante,
						homeLoseCyclePerna_dificuldadeVisitado, awayWinCyclePerna_dificuldadeVisitante,
						homeLoseCyclePerna_HistoricosVisitado, awayWinCyclePerna_HistoricosVisitante,
						fR_ratingQualidadeDerrotasVisitado, fR_ratingQualidadeVitoriasVisitante,
						qLT_homeTeamNumeroJogos, qLT_awayTeamNumeroJogos, qLT_homeTeamNumeroJogos2,
						qLT_awayTeamNumeroJogos2, qLT_percentagemDerrotasVisitado2, qLT_percentagemVitoriasVisitante2,
						qLT_dificuldadeDerrotasVisitado2, qLT_dificuldadeVitoriasVisitante2,
						qLT_percentagemDerrotasVisitadoNoIntervalo2, qLT_percentagemVitoriasVisitanteNoIntervalo2,
						qLT_numeroJogosVisitado2, qLT_numeroJogosVisitante2, loseH2hResults, fR_DerrotasVisitado,
						fR_VitoriasVisitante, golosVisitado, golosContraVisitado, diferencaGolosVisitado,
						golosVisitante, golosContraVisitante, diferencaGolosVisitante, golosVisitadoCasa,
						golosContraVisitadoCasa, diferencaGolosVisitadoCasa, golosVisitanteFora,
						golosContraVisitanteFora, diferencaGolosVisitanteFora, classificacaoVisitado,
						classificacaoVisitante, qualidadeVisitadoCasa, qualidadeVisitanteFora);

				OurLoseDataList.add(lohwr);
			}

			/*
			 * if (generateProf) { ProfRow wphwr = new ProfRow(data, idVisitado,
			 * idVisitante, f.getHomeTeam().getName(),
			 * f.getAwayTeam().getName(), qualidadeVisitado, qualidadeVisitante,
			 * fR_diasDescansoVisitado, fR_diasDescansoVisitante,
			 * fR_ratingVitoriasVisitado, fR_ratingDerrotasVisitante,
			 * fR_dificuldadeVisitado, fR_dificuldadeVisistante,
			 * fR_HistoricosVisitado, fR_HistoricosVisitante,
			 * homeWinCycle_numeroJogosVisitado,
			 * awayLoseCycle_numeroJogosVisitante,
			 * homeWinCycle_dificuldadeVisitado,
			 * awayLoseCycle_dificuldadeVisitante,
			 * homeWinCycle_HistoricosVisitado,
			 * awayLoseCycle_HistoricosVisitante, h2hWin_ratingVitorias,
			 * h2hWin_numeroJogos, result.equals(ResultType.WIN) ? 1 : 0);
			 * 
			 * ProfWinDataList.add(wphwr);
			 * 
			 * ProfRow dphwr = new ProfRow(data, idVisitado, idVisitante,
			 * f.getHomeTeam().getName(), f.getAwayTeam().getName(),
			 * qualidadeVisitado, qualidadeVisitante, fR_diasDescansoVisitado,
			 * fR_diasDescansoVisitante, fR_ratingEmpatesVisitado,
			 * fR_ratingEmpatesVisitante, fR_dificuldadeVisitado,
			 * fR_dificuldadeVisistante, fR_HistoricosVisitado,
			 * fR_HistoricosVisitante, homeDrawCycle_numeroJogosVisitado,
			 * awayDrawCycle_numeroJogosVisitante,
			 * homeDrawCycle_dificuldadeVisitado,
			 * awayDrawCycle_dificuldadeVisitante,
			 * homeDrawCycle_HistoricosVisitado,
			 * awayDrawCycle_HistoricosVisitante, h2hDraw_rating,
			 * h2hDraw_numeroJogos, result.equals(ResultType.DRAW) ? 1 : 0);
			 * 
			 * ProfDrawDataList.add(dphwr);
			 * 
			 * ProfRow lphwr = new ProfRow(data, idVisitado, idVisitante,
			 * f.getHomeTeam().getName(), f.getAwayTeam().getName(),
			 * qualidadeVisitado, qualidadeVisitante, fR_diasDescansoVisitado,
			 * fR_diasDescansoVisitante, fR_ratingDerrotasVisitado,
			 * fR_ratingVitoriasVisitante, fR_dificuldadeVisitado,
			 * fR_dificuldadeVisistante, fR_HistoricosVisitado,
			 * fR_HistoricosVisitante, homeLoseCycle_numeroJogosVisitado,
			 * awayWinCycle_numeroJogosVisitante,
			 * homeLoseCycle_dificuldadeVisitado,
			 * awayWinCycle_dificuldadeVisitante,
			 * homeLoseCycle_HistoricosVisitado,
			 * awayWinCycle_HistoricosVisitante, h2hLose_rating,
			 * h2hLose_numeroJogos, result.equals(ResultType.LOSE) ? 1 : 0);
			 * 
			 * ProfLoseDataList.add(lphwr);
			 * 
			 * }
			 */
		}

		Workbook NossoWorkbook = writeToExcelObj.newWorkbook();

		writeToExcelObj.writeOurDataExcelTable(OurWinDataList, NossoWorkbook, "Vitoria");
		writeToExcelObj.writeOurDataExcelTable(OurDrawDataList, NossoWorkbook, "Empate");
		writeToExcelObj.writeOurDataExcelTable(OurLoseDataList, NossoWorkbook, "Derrota");
		writeToExcelObj.writeWorkbookToExcelFile(/* "Nosso" + */s.getName() + s.getYear(), NossoWorkbook);

		/*
		 * Workbook ProfWorkbook = writeToExcelObj.newWorkbook();
		 * 
		 * writeToExcelObj.writeProfDataExcelTable(ProfWinDataList,
		 * ProfWorkbook, "Vitoria");
		 * writeToExcelObj.writeProfDataExcelTable(ProfDrawDataList,
		 * ProfWorkbook, "Empate");
		 * writeToExcelObj.writeProfDataExcelTable(ProfLoseDataList,
		 * ProfWorkbook, "Derrota");
		 * writeToExcelObj.writeWorkbookToExcelFile("Prof" + s.getName() +
		 * s.getYear(), ProfWorkbook);
		 */
	}

	// A população da base de dados varia conforme o campeonato pois o CSV não é
	// sempre igual, é necessário ver isto
	private static Season populateDatabase(EntityManager em, String competitionFile, String season, Integer year) {
		SeasonController seasonController = new SeasonController(em);
		TeamController teamController = new TeamController(em);
		FixtureController fixtureController = new FixtureController(em);
		StandingController standingController = new StandingController(em);
		OddController oddController = new OddController();

		List<String[]> list = CSVReader
				.readFromCSV("http://www.football-data.co.uk/mmz4281/" + season + "/" + competitionFile);

		Season s = null;
		if (competitionFile.contains("E0") || competitionFile.contains("E1") || competitionFile.contains("E2")
				|| competitionFile.contains("SC0")) {
			for (String[] arr : list) {
				s = seasonController.createSeason(arr[0], year);
				Team t1 = teamController.createTeam(arr[2]);
				Team t2 = teamController.createTeam(arr[3]);
				seasonController.addTeam(s, t1);
				seasonController.addTeam(s, t2);

				Result result = null;
				try {
					// result = new Result(Integer.valueOf(arr[4]),
					// Integer.valueOf(arr[5]), Integer.valueOf(arr[7]),
					// Integer.valueOf(arr[8]));

					result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), null, null);

				} catch (NumberFormatException e) {
					e.printStackTrace(System.out);
					logger.debug(arr[0]);
					logger.debug(arr[1]);
					logger.debug(arr[2]);
					logger.debug(arr[3]);
					logger.debug(arr[4]);
					logger.debug(arr[5]);
					// logger.debug(arr[7]);
					// logger.debug(arr[8]);
					logger.debug(arr[23]);
					logger.debug(arr[24]);
					logger.debug(arr[25]);
					result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), 0, 0);
				}

				Odd odd = null;

				try {
					odd = new Odd(Double.valueOf(arr[23]), Double.valueOf(arr[24]), Double.valueOf(arr[25]));
				} catch (NumberFormatException e) {
					e.printStackTrace(System.out);
					odd = new Odd(0.0, 0.0, 0.0);
				}

				Fixture fixture = fixtureController.createFixture(formatter.parseDateTime(arr[1]).toDate(), s, t1, t2,
						result, odd);
				if (fixture.getStatus().equals(FixtureStatus.FINISHED)) {
					standingController.createStanding(t1, s, fixture);
					standingController.createStanding(t2, s, fixture);
				}
			}
			return s;

		} else if (competitionFile.contains("D1") || competitionFile.contains("I1") || competitionFile.contains("SP1")
				|| competitionFile.contains("F1")) {
			for (String[] arr : list) {
				s = seasonController.createSeason(arr[0], year);
				Team t1 = teamController.createTeam(arr[2]);
				Team t2 = teamController.createTeam(arr[3]);
				seasonController.addTeam(s, t1);
				seasonController.addTeam(s, t2);

				Result result = null;
				try {
					// result = new Result(Integer.valueOf(arr[4]),
					// Integer.valueOf(arr[5]), Integer.valueOf(arr[7]),
					// Integer.valueOf(arr[8]));

					result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), null, null);

				} catch (NumberFormatException e) {
					e.printStackTrace(System.out);
					logger.debug(arr[0]);
					logger.debug(arr[1]);
					logger.debug(arr[2]);
					logger.debug(arr[3]);
					logger.debug(arr[4]);
					logger.debug(arr[5]);
					// logger.debug(arr[7]);
					// logger.debug(arr[8]);
					logger.debug(arr[22]);
					logger.debug(arr[23]);
					logger.debug(arr[24]);
					result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), 0, 0);
				}

				Odd odd = null;

				try {
					odd = new Odd(Double.valueOf(arr[22]), Double.valueOf(arr[23]), Double.valueOf(arr[24]));
				} catch (NumberFormatException e) {
					e.printStackTrace(System.out);
					odd = new Odd(0.0, 0.0, 0.0);
				}

				Fixture fixture = fixtureController.createFixture(formatter.parseDateTime(arr[1]).toDate(), s, t1, t2,
						result, odd);
				if (fixture.getStatus().equals(FixtureStatus.FINISHED)) {
					standingController.createStanding(t1, s, fixture);
					standingController.createStanding(t2, s, fixture);
				}
			}
			return s;

		} else if (competitionFile.contains("D2") || competitionFile.contains("I2") || competitionFile.contains("SP2")
				|| competitionFile.contains("F2") || competitionFile.contains("N1") || competitionFile.contains("B1")
				|| competitionFile.contains("P1") || competitionFile.contains("T1") || competitionFile.contains("G1")) {
			for (String[] arr : list) {
				s = seasonController.createSeason(arr[0], year);
				Team t1 = teamController.createTeam(arr[2]);
				Team t2 = teamController.createTeam(arr[3]);
				seasonController.addTeam(s, t1);
				seasonController.addTeam(s, t2);

				Result result = null;
				try {
					// result = new Result(Integer.valueOf(arr[4]),
					// Integer.valueOf(arr[5]), Integer.valueOf(arr[7]),
					// Integer.valueOf(arr[8]));

					result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), null, null);

				} catch (NumberFormatException e) {
					e.printStackTrace(System.out);
					logger.debug(arr[0]);
					logger.debug(arr[1]);
					logger.debug(arr[2]);
					logger.debug(arr[3]);
					logger.debug(arr[4]);
					logger.debug(arr[5]);
					// logger.debug(arr[7]);
					// logger.debug(arr[8]);
					logger.debug(arr[10]);
					logger.debug(arr[11]);
					logger.debug(arr[12]);
					result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), 0, 0);
				}

				Odd odd = null;

				try {
					odd = new Odd(Double.valueOf(arr[10]), Double.valueOf(arr[11]), Double.valueOf(arr[12]));
				} catch (NumberFormatException e) {
					e.printStackTrace(System.out);
					odd = new Odd(0.0, 0.0, 0.0);
				}

				Fixture fixture = fixtureController.createFixture(formatter.parseDateTime(arr[1]).toDate(), s, t1, t2,
						result, odd);
				if (fixture.getStatus().equals(FixtureStatus.FINISHED)) {
					standingController.createStanding(t1, s, fixture);
					standingController.createStanding(t2, s, fixture);
				}
			}
			return s;
		} else {
			logger.debug("NAO PREENCHEU BEM, MANDA TUDO A BAIXO!!!");
		}
		return s;
	}
}
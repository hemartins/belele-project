/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business.util.footballDataInterface;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pt.belele.project.business.FixtureController;
import pt.belele.project.business.OddController;
import pt.belele.project.business.SeasonController;
import pt.belele.project.business.StandingController;
import pt.belele.project.business.TeamController;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.OddDAO;
import pt.belele.project.persistence.ResultDAO;

/**
 *
 * @author P056913
 */
@Stateless
public class DataInputBean implements DataInputInterface {

    private static final Logger LOG = LogManager.getLogger(DataInputSingleton.class);

    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy");

    @Resource
    private SessionContext context;

    @EJB
    private SeasonController seasonController;

    @EJB
    private TeamController teamController;

    @EJB
    private FixtureController fixtureController;

    @EJB
    private StandingController standingController;

    @EJB
    private OddController oddController;

    @EJB
    private OddDAO oddDAO;

    @EJB
    private ResultDAO resultDAO;

    @Override
    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Future<Void> generateDatabase() {

	// INGLATERRA - PREMIER LEAGUE
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", "1415", 14);

	// INGLATERRA - CHAMPIONSHIP
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", "1415", 14);

	// INGLATERRA - LEAGUE 1
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", "1415", 14);

	// ESCOCIA - PREMIER LEAGUE
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", "1415", 14);

	// ALEMANHA - BUNDESLIGA 1
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", "1415", 14);

	// ALEMANHA - BUNDESLIGA 2
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", "1415", 14);

	// ITALIA - SERIE A
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", "1415", 14);

	// ITALIA - SERIE B
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", "1415", 14);

	// ESPANHA - LA LIGA PRIMERA DIVISION
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", "1415", 14);

	// ESPANHA - LA LIGA SEGUNDA DIVISION
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", "1415", 14);

	// FRANÇA - LE CHAMPIONNAT
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", "1415", 14);

	// FRANÇA - DIVISION2
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", "1415", 14);

	// HOLANDA - EREDIVISE
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", "1415", 14);

	// BELGICA - JUPILER LEAGUE
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", "1415", 14);

	// PORTUGAL - PRIMEIRA LIGA
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", "1415", 14);

	// TURQUIA - FUTBOL LIGI 1
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", "1415", 14);

	// GRECIA - ETHNIKI KATIGORIA
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "0001", 0);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "0102", 1);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "0203", 2);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "0304", 3);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "0405", 4);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "0506", 5);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "0607", 6);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "0708", 7);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "0809", 8);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "0910", 9);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "1011", 10);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "1112", 11);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "1213", 12);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "1314", 13);
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", "1415", 14);

	return new AsyncResult<>(null);
    }

    @Override
    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Schedule(hour = "02", persistent = false, info = "Updating DataBase")
    public Future<Void> updateDatabase() {

	DateTime now = new DateTime();

	Integer year;

	if (now.getMonthOfYear() < 7) {
	    year = now.getYearOfCentury() - 1;
	} else {
	    year = now.getYearOfCentury();
	}

	String yearStr = year.toString() + (year + 1);

	// INGLATERRA - PREMIER LEAGUE
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E0.csv", yearStr, year);

	// INGLATERRA - CHAMPIONSHIP
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E1.csv", yearStr, year);

	// INGLATERRA - LEAGUE 1
	context.getBusinessObject(DataInputInterface.class).populateDatabase("E2.csv", yearStr, year);

	// ESCOCIA - PREMIER LEAGUE
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SC0.csv", yearStr, year);

	// ALEMANHA - BUNDESLIGA 1
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D1.csv", yearStr, year);

	// ALEMANHA - BUNDESLIGA 2
	context.getBusinessObject(DataInputInterface.class).populateDatabase("D2.csv", yearStr, year);

	// ITALIA - SERIE A
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I1.csv", yearStr, year);

	// ITALIA - SERIE B
	context.getBusinessObject(DataInputInterface.class).populateDatabase("I2.csv", yearStr, year);

	// ESPANHA - LA LIGA PRIMERA DIVISION
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP1.csv", yearStr, year);

	// ESPANHA - LA LIGA SEGUNDA DIVISION
	context.getBusinessObject(DataInputInterface.class).populateDatabase("SP2.csv", yearStr, year);

	// FRANÇA - LE CHAMPIONNAT
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F1.csv", yearStr, year);

	// FRANÇA - DIVISION2
	context.getBusinessObject(DataInputInterface.class).populateDatabase("F2.csv", yearStr, year);

	// HOLANDA - EREDIVISE
	context.getBusinessObject(DataInputInterface.class).populateDatabase("N1.csv", yearStr, year);

	// BELGICA - JUPILER LEAGUE
	context.getBusinessObject(DataInputInterface.class).populateDatabase("B1.csv", yearStr, year);

	// PORTUGAL - PRIMEIRA LIGA
	context.getBusinessObject(DataInputInterface.class).populateDatabase("P1.csv", yearStr, year);

	// TURQUIA - FUTBOL LIGI 1
	context.getBusinessObject(DataInputInterface.class).populateDatabase("T1.csv", yearStr, year);

	// GRECIA - ETHNIKI KATIGORIA
	context.getBusinessObject(DataInputInterface.class).populateDatabase("G1.csv", yearStr, year);

	return new AsyncResult<>(null);
    }

    // A população da base de dados varia conforme o campeonato pois o CSV não é sempre igual, é necessário ver isto
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void populateDatabase(String competitionFile, String season, Integer year) {
	LOG.info("Generating data for " + competitionFile + season);
	List<String[]> list = CSVReader.readFromCSV("http://www.football-data.co.uk/mmz4281/" + season + "/" + competitionFile);

	Season s;

	if (competitionFile.contains("E0") || competitionFile.contains("E1") || competitionFile.contains("E2") || competitionFile.contains("SC0")) {
	    for (String[] arr : list) {
		try {
		    s = seasonController.createSeason(arr[0], year);

		    Team t1 = teamController.createTeam(arr[2]);
		    Team t2 = teamController.createTeam(arr[3]);

		    seasonController.addTeam(s, t1);
		    seasonController.addTeam(s, t2);

		    Result result;
		    try {
			result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), Integer.valueOf(arr[7]), Integer.valueOf(arr[8]));
		    } catch (Exception e) {
			LOG.error("Unable to get half time goals!");
			result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), null, null);
		    }

		    result = resultDAO.insert(result);

		    Odd odd;

		    try {
			odd = new Odd(Double.valueOf(arr[23]), Double.valueOf(arr[24]), Double.valueOf(arr[25]));
		    } catch (Exception e) {
			LOG.error("Unable to get odd from file!");
			odd = new Odd(0.0, 0.0, 0.0);
		    }

		    oddController.calculateLayOddsAsBackOdds(odd);
		    odd = oddDAO.insert(odd);

		    Fixture fixture = fixtureController.createFixture(formatter.parseDateTime(arr[1]), s, t1, t2,
			    result, odd);
		    if (fixture.getStatus().equals(Fixture.FixtureStatus.FINISHED)) {
			standingController.createStanding(t1, s, fixture);
			standingController.createStanding(t2, s, fixture);
		    }
		} catch (Exception e) {
		    LOG.error("Something went wrong! Entry\n" + Arrays.toString(arr));
		}
	    }

	} else if (competitionFile.contains("D1") || competitionFile.contains("I1") || competitionFile.contains("SP1") || competitionFile.contains("F1")) {
	    for (String[] arr : list) {
		try {
		    s = seasonController.createSeason(arr[0], year);

		    Team t1 = teamController.createTeam(arr[2]);
		    Team t2 = teamController.createTeam(arr[3]);

		    seasonController.addTeam(s, t1);
		    seasonController.addTeam(s, t2);

		    Result result;
		    try {
			result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), Integer.valueOf(arr[7]), Integer.valueOf(arr[8]));
		    } catch (Exception e) {
			LOG.error("Unable to get half time goals!");
			result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), null, null);
		    }

		    result = resultDAO.insert(result);

		    Odd odd;

		    try {
			odd = new Odd(Double.valueOf(arr[22]), Double.valueOf(arr[23]), Double.valueOf(arr[24]));
		    } catch (Exception e) {
			LOG.error("Unable to get odd from file!");
			odd = new Odd(0.0, 0.0, 0.0);
		    }

		    oddController.calculateLayOddsAsBackOdds(odd);
		    odd = oddDAO.insert(odd);

		    Fixture fixture = fixtureController.createFixture(formatter.parseDateTime(arr[1]), s, t1, t2, result, odd);

		    if (fixture.getStatus().equals(Fixture.FixtureStatus.FINISHED)) {
			standingController.createStanding(t1, s, fixture);
			standingController.createStanding(t2, s, fixture);
		    }
		} catch (Exception e) {
		    LOG.error("Something went wrong! Entry\n" + Arrays.toString(arr));
		}
	    }

	} else if (competitionFile.contains("D2") || competitionFile.contains("I2") || competitionFile.contains("SP2")
		|| competitionFile.contains("F2") || competitionFile.contains("N1") || competitionFile.contains("B1")
		|| competitionFile.contains("P1") || competitionFile.contains("T1") || competitionFile.contains("G1")) {
	    for (String[] arr : list) {
		try {
		    s = seasonController.createSeason(arr[0], year);

		    Team t1 = teamController.createTeam(arr[2]);
		    Team t2 = teamController.createTeam(arr[3]);

		    seasonController.addTeam(s, t1);
		    seasonController.addTeam(s, t2);

		    Result result;
		    try {
			result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), Integer.valueOf(arr[7]), Integer.valueOf(arr[8]));
		    } catch (Exception e) {
			LOG.error("Unable to get half time goals!");
			result = new Result(Integer.valueOf(arr[4]), Integer.valueOf(arr[5]), null, null);
		    }

		    result = resultDAO.insert(result);

		    Odd odd;

		    try {
			odd = new Odd(Double.valueOf(arr[10]), Double.valueOf(arr[11]), Double.valueOf(arr[12]));
		    } catch (Exception e) {
			LOG.error("Unable to get odd from file!");
			odd = new Odd(0.0, 0.0, 0.0);
		    }

		    oddController.calculateLayOddsAsBackOdds(odd);
		    odd = oddDAO.insert(odd);

		    Fixture fixture = fixtureController.createFixture(formatter.parseDateTime(arr[1]), s, t1, t2,
			    result, odd);
		    if (fixture.getStatus().equals(Fixture.FixtureStatus.FINISHED)) {
			standingController.createStanding(t1, s, fixture);
			standingController.createStanding(t2, s, fixture);
		    }
		} catch (Exception e) {
		    LOG.error("Something went wrong! Entry\n" + Arrays.toString(arr));
		}
	    }
	} else {
	    LOG.debug("NAO PREENCHEU BEM, MANDA TUDO A BAIXO!!!");
	}
    }
}

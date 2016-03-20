/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business.ann;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pt.belele.project.business.TeamController;
import pt.belele.project.business.ann.obj.DataSetCalculator;
import pt.belele.project.business.ann.obj.Dataset;
import pt.belele.project.business.util.Triplet;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Result.ResultType;
import pt.belele.project.entities.Team;

/**
 *
 * @author P056913
 */
@Stateless
public class DatasetControllerBean implements DatasetController {

    private final Logger LOG = LogManager.getLogger(DatasetControllerBean.class);

    private final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy");

    @EJB
    private TeamController teamController;
    
    @Override
    public Triplet<List<Dataset>, List<Dataset>, List<Dataset>> generateDatasetForFixtures(List<Fixture> fixtures, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception {

	LOG.info("GENERATING DATASET");
	
	List<Dataset> winDataset = new ArrayList<>();
	List<Dataset> drawDataset = new ArrayList<>();
	List<Dataset> loseDataset = new ArrayList<>();

	for (Fixture f : fixtures) {

	    LOG.trace(f.toString());

	    if (f.getDate().isBefore(formatter.parseDateTime("23/11/" + (f.getSeason().getYear() + 2000)))) {
		continue;
	    }
	    Team homeTeam = f.getHomeTeam();
	    Team awayTeam = f.getAwayTeam();

	    Dataset winRow = calculateVariables(f, homeTeam, awayTeam, winVariables, "1");
	    Dataset drawRow = calculateVariables(f, homeTeam, awayTeam, drawVariables, "X");
	    Dataset loseRow = calculateVariables(f, homeTeam, awayTeam, loseVariables, "2");

	    winDataset.add(winRow);
	    drawDataset.add(drawRow);
	    loseDataset.add(loseRow);

	}

	return new Triplet<>(winDataset, drawDataset, loseDataset);
    }

    private Dataset calculateVariables(Fixture fixture, Team homeTeam, Team awayTeam, List<String> variables, String result) throws Exception {
	LOG.trace("Calculating Variables for fixture: " + fixture.getId());
	Dataset dataset = new Dataset();

	dataset.setDate(fixture.getDate());
	dataset.setHomeTeam(fixture.getHomeTeam().getName());
	dataset.setAwayTeam(fixture.getAwayTeam().getName());
	
	ResultType realResult = teamController.getResultType(homeTeam, fixture);

	switch (result) {
	    case "1":
		dataset.setResult(realResult.equals(ResultType.WIN) ? 1 : 0);
		break;
	    case "X":
		dataset.setResult(realResult.equals(ResultType.DRAW) ? 1 : 0);
		break;
	    case "2":
		dataset.setResult(realResult.equals(ResultType.LOSE) ? 1 : 0);
		break;
	    default:
		// INVALIDO
		return null;
	}

	for (String variable : variables) {
	    Object value;

	    try {
		DataSetCalculator dsCalc = new DataSetCalculator();
		Method method;
		method = dsCalc.getClass().getMethod("get" + variable, Team.class, Team.class, Fixture.class, String.class);
		value = method.invoke(dsCalc, homeTeam, awayTeam, fixture, result);
	    } catch (SecurityException | NoSuchMethodException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
		LOG.error("CALCULATE DATASET: ERROR CALCULATING VARIABLE " + variable);
		throw new Exception(e);
	    }

	    try {
		Method method;
		method = dataset.getClass().getMethod("set" + variable, value.getClass());
		method.invoke(dataset, value);
	    } catch (SecurityException | NoSuchMethodException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
		LOG.error("CALCULATE DATASET: ERROR SETTING VARIABLE " + variable);
		throw new Exception(e);
	    }
	}

	return dataset;
    }
}

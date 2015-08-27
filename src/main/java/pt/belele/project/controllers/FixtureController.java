package pt.belele.project.controllers;

import java.util.Date;

import javax.persistence.NoResultException;

import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.FixtureDAO;

public class FixtureController {
	private FixtureDAO fixtureDAO;

	public FixtureController() {
		fixtureDAO = new FixtureDAO();
	}

	public Fixture createFixture(Date date, Season s, Team home, Team away) {
		try {
			fixtureDAO.findFixture(date, s.getId(), home.getId(), away.getId());
		} catch (NoResultException e) {
			fixtureDAO.insert(new Fixture(date, s, home, away));
		}
		
		return fixtureDAO.findFixture(date, s.getId(), home.getId(), away.getId());
	}

}

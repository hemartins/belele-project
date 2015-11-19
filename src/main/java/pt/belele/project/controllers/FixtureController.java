package pt.belele.project.controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.FixtureDAO;

public class FixtureController {
	private FixtureDAO fixtureDAO;

	public FixtureController(EntityManager em) {
		fixtureDAO = new FixtureDAO(em);
	}

	public Fixture createFixture(Date date, Season s, Team home, Team away,
			Result result, Odd odd) {
		try {
			fixtureDAO.findFixture(date, s.getId(), home.getId(), away.getId());
		} catch (NoResultException e) {
			//CALCULAR BACK E LAY ODS
			OddController oddController = new OddController();
			oddController.calculateLayOddsAsBackOdds(odd);
			Fixture f = new Fixture(date, s, home, away, result, odd);
			f.setH2H(fixtureDAO.getH2H(f.getHomeTeam().getId(), f.getAwayTeam()
					.getId(), f.getDate(),10));
			f.setH2HVenue(fixtureDAO.getH2HVenue(f.getHomeTeam().getId(), f.getAwayTeam()
					.getId(), f.getDate(),10));
			f.setH2hSwitchedVenue(fixtureDAO.getH2HSwitchedVenue(f.getHomeTeam().getId(), f.getAwayTeam()
					.getId(), f.getDate(),10));
			fixtureDAO.insert(f);
		}

		return fixtureDAO.findFixture(date, s.getId(), home.getId(),
				away.getId());
	}

	public Fixture getTeamFixtureBeforeDate(Team t, Season s, Date date) {
		return fixtureDAO.findFixtureBeforeDate(date, s.getId(), t.getId());
	}

	public List<Fixture> getTeamBeforeFixtures(Team t, Season s, Date date,
			Venue venue, Integer numberOfFixtures) {
		return fixtureDAO.findFixturesBeforeDate(date, s.getId(), t.getId(),
				venue, numberOfFixtures);
	}

}

package pt.belele.project.controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Head2Head;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.FixtureDAO;
import pt.belele.project.persistence.Head2HeadDAO;

public class FixtureController {
	private FixtureDAO fixtureDAO;
	private Head2HeadDAO h2hDAO;

	public FixtureController(EntityManager em) {
		fixtureDAO = new FixtureDAO(em);
		h2hDAO = new Head2HeadDAO(em);
	}

	public Fixture createFixture(Date date, Season s, Team home, Team away,
			Result result) {
		try {
			fixtureDAO.findFixture(date, s.getId(), home.getId(), away.getId());
		} catch (NoResultException e) {
			Fixture f = new Fixture(date, s, home, away, result);
			f = updateHead2Head(f);
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

	public Fixture updateHead2Head(Fixture f) {
		List<Fixture> h2hFixtures = fixtureDAO.getH2H(f.getHomeTeam().getId(),
				f.getAwayTeam().getId());

		if (h2hFixtures.isEmpty())
			return f;

		Head2Head h2h = new Head2Head();
		h2h.setFixtures(h2hFixtures);
		h2h.setTimeFrameStart(h2hFixtures.get(h2hFixtures.size() - 1).getDate());
		h2h.setTimeFrameEnd(h2hFixtures.get(0).getDate());
		h2h.setHomeTeamWins(0);
		h2h.setAwayTeamWins(0);
		h2h.setDraws(0);

		h2hDAO.insert(h2h);

		f.setHead2Head(h2h);
		return f;
	}

}

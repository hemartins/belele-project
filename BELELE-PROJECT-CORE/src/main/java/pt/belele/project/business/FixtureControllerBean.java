package pt.belele.project.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.joda.time.DateTime;
import pt.belele.project.business.exception.BeleleException;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.FixtureDAO;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class FixtureControllerBean implements FixtureController {

    @EJB
    private FixtureDAO fixtureDAO;

    @EJB
    private OddController oddController;

    @Override
    public Fixture createFixture(DateTime date, Season s, Team home, Team away, Result result, Odd odd) {
	Fixture fixture;
	try {
	    fixture = fixtureDAO.findFixture(date, s.getId(), home.getId(), away.getId());
	} catch (BeleleException e) {
	    //CALCULAR BACK E LAY ODS
	    oddController.calculateLayOddsAsBackOdds(odd);
	    Fixture f = new Fixture(date, s, home, away, result, odd);
	    f.setH2H(fixtureDAO.getH2H(f.getHomeTeam().getId(), f.getAwayTeam().getId(), f.getDate(), 10));
	    f.setH2HVenue(fixtureDAO.getH2HVenue(f.getHomeTeam().getId(), f.getAwayTeam().getId(), f.getDate(), 10));
	    f.setH2hSwitchedVenue(fixtureDAO.getH2HSwitchedVenue(f.getHomeTeam().getId(), f.getAwayTeam().getId(), f.getDate(), 10));
	    //f.setAnnOdd(calculateAnnOdds(f));
	    fixture = fixtureDAO.insert(f);
	}

	return fixture;
    }

    @Override
    public Fixture getTeamFixtureBeforeDate(Team t, Season s, DateTime date) {
	return fixtureDAO.findFixtureBeforeDate(date, s.getId(), t.getId());
    }

    @Override
    public List<Fixture> getTeamBeforeFixtures(Team t, Season s, DateTime date, Venue venue, Integer numberOfFixtures) {
	return fixtureDAO.findFixturesBeforeDate(date, s.getId(), t.getId(), venue, numberOfFixtures);
    }
}

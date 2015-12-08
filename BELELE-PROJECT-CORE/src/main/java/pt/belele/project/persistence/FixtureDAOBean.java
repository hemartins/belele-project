package pt.belele.project.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.joda.time.DateTime;
import pt.belele.project.business.exception.BeleleException;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class FixtureDAOBean extends GenericDAOBean<Fixture, Long> implements FixtureDAO {

    @Override
    public Fixture findFixture(DateTime date, Long seasonId, Long homeTeam, Long awayTeam) throws BeleleException {
	TypedQuery<Fixture> query = manager.createQuery("SELECT f from Fixture f WHERE f.date=:date AND f.season.id = :seasonId AND f.homeTeam.id = :homeTeam AND f.awayTeam.id = :awayTeam", Fixture.class);
	query.setParameter("date", date);
	query.setParameter("seasonId", seasonId);
	query.setParameter("homeTeam", homeTeam);
	query.setParameter("awayTeam", awayTeam);
	try {
	    return query.getSingleResult();
	} catch (NoResultException e) {
	    throw new BeleleException("Fixture Not Found!", e);
	}
    }

    @Override
    public Fixture findFixtureBeforeDate(DateTime date, Long seasonId, Long team) {
	TypedQuery<Fixture> query = manager.createQuery("SELECT f from Fixture f WHERE f.date < :date AND f.season.id = :seasonId AND (f.homeTeam.id = :team OR f.awayTeam.id = :team) ORDER BY f.date DESC", Fixture.class);
	query.setParameter("date", date);
	query.setParameter("seasonId", seasonId);
	query.setParameter("team", team);
	query.setMaxResults(1);

	return query.getSingleResult();
    }

    @Override
    public List<Fixture> findFixturesBeforeDate(DateTime date, Long seasonId, Long team, Venue venue, Integer numberOfFixtures) {
	String sql = "SELECT f from Fixture f WHERE f.date < :date AND f.season.id = :seasonId ";

	if (venue != null) {
	    switch (venue) {
		case HOME:
		    sql += "AND f.homeTeam.id = :team ";
		    break;
		case AWAY:
		    sql += "AND f.awayTeam.id = :team ";
		    break;
		default:
		    return null;
	    }
	} else {
	    sql += "AND (f.homeTeam.id = :team OR f.awayTeam.id = :team) ";
	}

	sql += "ORDER BY f.date DESC";
	Query query = manager.createQuery(sql);
	query.setParameter("date", date);
	query.setParameter("seasonId", seasonId);
	query.setParameter("team", team);

	if (numberOfFixtures != null) {
	    query.setMaxResults(numberOfFixtures);
	}

	return query.getResultList();
    }

    @Override
    public List<Fixture> getH2H(Long homeTeam, Long awayTeam, DateTime date, Integer numberOfGames) {
	Query query = manager.createQuery("SELECT f FROM Fixture f WHERE (f.homeTeam.id = :home OR f.homeTeam.id = :away) AND (f.awayTeam.id = :away OR f.awayTeam.id = :home) AND f.date < :date ORDER BY f.date DESC");
	query.setParameter("home", homeTeam);
	query.setParameter("away", awayTeam);
	query.setParameter("date", date);
	query.setMaxResults(numberOfGames);
	return query.getResultList();
    }

    @Override
    public List<Fixture> getH2HVenue(Long homeTeam, Long awayTeam, DateTime date, Integer numberOfGames) {
	Query query = manager.createQuery("SELECT f FROM Fixture f WHERE f.homeTeam.id = :home AND f.awayTeam.id = :away AND f.date < :date ORDER BY f.date DESC");
	query.setParameter("home", homeTeam);
	query.setParameter("away", awayTeam);
	query.setParameter("date", date);
	query.setMaxResults(numberOfGames);
	return query.getResultList();
    }

    @Override
    public List<Fixture> getH2HSwitchedVenue(Long homeTeam, Long awayTeam, DateTime date, Integer numberOfGames) {
	Query query = manager.createQuery("SELECT f FROM Fixture f WHERE f.homeTeam.id = :away AND f.awayTeam.id = :home AND f.date < :date ORDER BY f.date DESC");
	query.setParameter("home", homeTeam);
	query.setParameter("away", awayTeam);
	query.setParameter("date", date);
	query.setMaxResults(numberOfGames);
	return query.getResultList();
    }

    @Override
    public List<Fixture> findFixturesBetweenDates(Long seasonId, DateTime begin, DateTime end) {
	StringBuilder sb = new StringBuilder("SELECT f FROM Fixture f WHERE f.season.id = :seasonId");
	Map<String, Object> params = new HashMap<>();

	params.put("seasonId", seasonId);

	if (begin != null) {
	    sb.append(" AND f.date > :begin ");
	    params.put("begin", begin);
	}
	if (end != null) {
	    sb.append(" AND f.date < :end");
	    params.put("end", end);
	}

	Query query = manager.createQuery(sb.toString());

	for (Map.Entry<String, Object> entry : params.entrySet()) {
	    query.setParameter(entry.getKey(), entry.getValue());
	}

	return query.getResultList();
    }

    @Override
    public List<Fixture> findCountryFixturesBetweenDates(String league, DateTime begin, DateTime end) {
	StringBuilder sb = new StringBuilder("SELECT f FROM Fixture f WHERE f.season.name = :league");
	Map<String, Object> params = new HashMap<>();

	params.put("league", league);

	if (begin != null) {
	    sb.append(" AND f.date > :begin ");
	    params.put("begin", begin);
	}
	if (end != null) {
	    sb.append(" AND f.date < :end");
	    params.put("end", end);
	}

	Query query = manager.createQuery(sb.toString());

	for (Map.Entry<String, Object> entry : params.entrySet()) {
	    query.setParameter(entry.getKey(), entry.getValue());
	}

	return query.getResultList();
    }
}

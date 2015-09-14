package pt.belele.project.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;

public class FixtureDAO extends GenericDAO<Fixture> {

	public FixtureDAO(EntityManager em) {
		super(em);
	}

	public Fixture findFixture(Date date, Long seasonId, Long homeTeamId,
			Long awayTeamId) {
		TypedQuery<Fixture> query = em
				.createQuery(
						"SELECT f from Fixture f WHERE f.date=:date AND f.season.id = :seasonId AND f.homeTeam.id = :homeTeamId AND f.awayTeam.id = :awayTeamId",
						Fixture.class);
		query.setParameter("date", date);
		query.setParameter("seasonId", seasonId);
		query.setParameter("homeTeamId", homeTeamId);
		query.setParameter("awayTeamId", awayTeamId);
		return query.getSingleResult();
	}

	public Fixture findFixtureBeforeDate(Date date, Long seasonId, Long teamId) {
		TypedQuery<Fixture> query = em
				.createQuery(
						"SELECT f from Fixture f WHERE f.date < :date AND f.season.id = :seasonId AND (f.homeTeam.id = :teamId OR f.awayTeam.id = :teamId) ORDER BY f.date DESC",
						Fixture.class);
		query.setParameter("date", date);
		query.setParameter("seasonId", seasonId);
		query.setParameter("teamId", teamId);
		query.setMaxResults(1);
		
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Fixture> findFixturesBeforeDate(Date date, Long seasonId,
			Long teamId, Venue venue, Integer numberOfFixtures) {
		String sql = "SELECT f from Fixture f WHERE f.date < :date AND f.season.id = :seasonId ";

		if (venue != null) {
			switch (venue) {
			case HOME:
				sql += "AND f.homeTeam.id = :teamId ";
				break;
			case AWAY:
				sql += "AND f.awayTeam.id = :teamId ";
				break;
			default:
				return null;
			}
		} else {
			sql += "AND (f.homeTeam.id = :teamId OR f.awayTeam.id = :teamId) ";
		}

		sql += "ORDER BY f.date DESC";
		Query query = em.createQuery(sql);
		query.setParameter("date", date);
		query.setParameter("seasonId", seasonId);
		query.setParameter("teamId", teamId);
		
		if(numberOfFixtures != null)
			query.setMaxResults(numberOfFixtures);
		
		List<Fixture> fixtures = query.getResultList();
		return fixtures;
//		if (numberOfFixtures == null)
//			return fixtures;
//		else
//			return fixtures.subList(
//					fixtures.size() - numberOfFixtures > 0 ? fixtures.size()
//							- numberOfFixtures : 0, fixtures.size());
	}
	
	@SuppressWarnings("unchecked")
	public List<Fixture> getH2H(long homeTeamId, long awayTeamId)
	{
		Query query = em.createQuery("SELECT f FROM Fixture f WHERE f.homeTeam.id = :homeId AND f.awayTeam.id = :awayId ORDER BY f.date DESC");
		query.setParameter("homeId", homeTeamId);
		query.setParameter("awayId", awayTeamId);
		return query.getResultList();
	}
}

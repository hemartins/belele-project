package pt.belele.project.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pt.belele.project.entities.Standing;
import pt.belele.project.entities.Team;

public class StandingDAO extends GenericDAO<Standing> {

	public StandingDAO(EntityManager em) {
		super(em);
	}

	public Standing findStanding(long teamId, Date date, long seasonId) {
		TypedQuery<Standing> query = em
				.createQuery(
						"SELECT s from Standing s WHERE s.date=:date AND s.team.id = :teamId AND s.season.id = :seasonId",
						Standing.class);
		query.setParameter("date", date);
		query.setParameter("teamId", teamId);
		query.setParameter("seasonId", seasonId);
		return query.getSingleResult();
	}

	public Standing findNewestByNameAndDate(long teamId, Date date,
			long seasonId) throws NoResultException {
		TypedQuery<Standing> query = em
				.createQuery(
						"SELECT s FROM Standing s WHERE s.team.id = :teamId AND s.season.id = :seasonId  AND s.date < :date ORDER BY s.date DESC",
						Standing.class);
		query.setParameter("teamId", teamId);
		query.setParameter("date", date);
		query.setParameter("seasonId", seasonId);
		query.setMaxResults(1);
		if (query.getResultList().isEmpty())
			return null;
		else
			return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Team> getStandingsByPoints(Date date, long seasonId) {
		Query query = em
				.createQuery("SELECT t FROM Standing s, IN (s.team) t WHERE s.season.id = :seasonId AND s.date < :date GROUP BY t ORDER BY MAX(s.points) DESC");
		query.setParameter("seasonId", seasonId);
		query.setParameter("date", date);
		return query.getResultList();
	}

}

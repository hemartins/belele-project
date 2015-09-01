package pt.belele.project.persistence;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pt.belele.project.entities.Standing;

public class StandingDAO extends GenericDAO<Standing> {
	
	public StandingDAO(EntityManager em)
	{
		super(em);
	}
	
	public Standing findStanding(long teamId, Date date, long seasonId)
	{
		TypedQuery<Standing> query = em.createQuery("SELECT s from Standing s WHERE s.date=:date AND s.team.id = :teamId AND s.season.id = :seasonId", Standing.class);
		query.setParameter("date", date);
		query.setParameter("teamId", teamId);
		query.setParameter("seasonId", seasonId);
		return query.getSingleResult();
	}
	
	public Standing findNewestByNameAndDate(long teamId, Date date, long seasonId) throws NoResultException
	{
		Query query = em.createQuery("SELECT s FROM Standing s WHERE s.team.id = :teamId AND s.season.id = :seasonId  AND s.date < :date ORDER BY s.date DESC");
		query.setParameter("teamId", teamId);
		query.setParameter("date", date);
		query.setParameter("seasonId", seasonId);
		if(query.getResultList().isEmpty())
			return null;
		else
			return (Standing) query.getResultList().get(0);
	}
	

}

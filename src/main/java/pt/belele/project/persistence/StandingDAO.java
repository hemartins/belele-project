package pt.belele.project.persistence;

import java.util.Date;

import javax.persistence.TypedQuery;

import pt.belele.project.entities.Season;
import pt.belele.project.entities.Standing;

public class StandingDAO extends GenericDAO<Standing> {
	
	public StandingDAO()
	{
		super();
	}
	
	public Standing findByNameAndDate(String name, Date date, long seasonId)
	{
		TypedQuery<Standing> query = em.createQuery("SELECT s FROM Standing s WHERE s.name = :name AND s.season.id = :seasonId  AND s.date < :date ORDER BY s.date DESC LIMIT 1", Standing.class);
		query.setParameter("name", name);
		query.setParameter("date", date);
		query.setParameter("seasonId", seasonId);
		return query.getResultList().get(0);
	}

}

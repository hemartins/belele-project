package pt.belele.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pt.belele.project.entities.Week;

public class WeekDAO extends GenericDAO<Week> {

	public WeekDAO(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Week> findProfitWeeks(){
		Query query = em.createQuery("SELECT w FROM Week w WHERE w.earnings > w.investment");
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Week> findAll(){
		Query query = em.createQuery("SELECT w FROM Week w");
		
		return query.getResultList();
	}

}

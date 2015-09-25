package pt.belele.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Bet.BetResult;

public class BetDAO extends GenericDAO<Bet> {

	public BetDAO(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Bet> findBetsByWeekAndBetResult(long weekId, BetResult result)
	{
		Query query = em.createQuery("SELECT b FROM Bet b WHERE b.week.id = :weekId AND b.betResult = :result");
		query.setParameter("weekId", weekId);
		query.setParameter("result", result);
		
		return query.getResultList();
	}

}

package pt.belele.project.persistence;

import javax.persistence.EntityManager;

import pt.belele.project.entities.Result;

public class ResultDAO extends GenericDAO<Result> {

	public ResultDAO(EntityManager em) {
		super(em);
	}
	
//	public Result findByFixtureId(Long fixtureId)
//	{
//		TypedQuery<Result> query = em.createQuery("SELECT r FROM Result r WHERE r.fixture.id = :fixtureId", Result.class);
//		query.setParameter("fixtureId", fixtureId);
//		return query.getSingleResult();
//	}
	
}

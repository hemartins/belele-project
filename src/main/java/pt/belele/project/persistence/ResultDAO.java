package pt.belele.project.persistence;

import javax.persistence.TypedQuery;

import pt.belele.project.entities.Result;

public class ResultDAO extends GenericDAO<Result> {

	public ResultDAO() {
		super();
	}
	
	public Result findByFixtureId(Long fixtureId)
	{
		TypedQuery<Result> query = em.createQuery("SELECT r FROM Result r WHERE r.fixture.id = :fixtureId", Result.class);
		query.setParameter("fixtureId", fixtureId);
		return query.getSingleResult();
	}
	
}

package pt.belele.project.persistence;

import java.util.Date;

import javax.persistence.TypedQuery;

import pt.belele.project.entities.Fixture;

public class FixtureDAO extends GenericDAO<Fixture> {

	public FixtureDAO() {
		super();
	}
	
	
	public Fixture findFixture(Date date, Long seasonId, Long homeTeamId, Long awayTeamId)
	{
		TypedQuery<Fixture> query = em.createQuery("SELECT f from Fixture f WHERE f.date=:date AND f.season.id = :seasonId AND f.homeTeam.id = :homeTeamId AND f.awayTeam.id = :awayTeamId", Fixture.class);
		query.setParameter("date", date);
		query.setParameter("seasonId", seasonId);
		query.setParameter("homeTeamId", homeTeamId);
		query.setParameter("awayTeamId", awayTeamId);
		return query.getSingleResult();
	}

}

package pt.belele.project.persistence;

import javax.persistence.TypedQuery;

import pt.belele.project.entities.Season;

public class SeasonDAO extends GenericDAO<Season> {

	public SeasonDAO()
	{
		super();
	}
	
	public Season findByNameAndYear(String name, Integer year)
	{
		TypedQuery<Season> query = em.createQuery("SELECT s FROM Season s WHERE s.name = :name AND s.year=:year", Season.class);
		query.setParameter("name", name);
		query.setParameter("year", year);
		return query.getSingleResult();
	}
}

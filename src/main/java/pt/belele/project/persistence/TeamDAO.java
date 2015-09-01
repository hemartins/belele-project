package pt.belele.project.persistence;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pt.belele.project.entities.Team;


public class TeamDAO extends GenericDAO<Team> {

	public TeamDAO(EntityManager em) {
		super(em);
	}

	public Team findByName(String name) {
		TypedQuery<Team> t = em.createQuery(
				"SELECT t FROM Team t WHERE t.name=:name", Team.class);
		t.setParameter("name", name);
		return t.getSingleResult();
	}

}

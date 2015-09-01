package pt.belele.project.persistence;

import javax.persistence.EntityManager;

public class GenericDAO<T> {
	
	protected EntityManager em;
	
	public GenericDAO(EntityManager em)
	{
		this.em = em;
	}

	public void insert(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	public void update(T entity)
	{
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}
	
	public void remove(T entity)
	{
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}
}

package pt.belele.project.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO<T> {

	protected EntityManagerFactory emf;

	protected EntityManager em;
	
	public GenericDAO()
	{
		emf = Persistence.createEntityManagerFactory("database.odb");
		em = emf.createEntityManager();
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

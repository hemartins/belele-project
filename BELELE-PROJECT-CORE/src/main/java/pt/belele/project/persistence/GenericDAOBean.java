/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.LockTimeoutException;
import javax.persistence.PersistenceContext;
import javax.persistence.PessimisticLockException;

public abstract class GenericDAOBean<T, PK extends Serializable> implements GenericDAO<T, PK> {

    private final Class<T> persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @PersistenceContext(unitName = "BELELE")
    protected EntityManager manager;

    protected static final String WILDCHAR = "\\\\";
    protected static final String ESCAPE_CLAUSE = " ESCAPE '\\' ";

    @Override
    public void detach(final T entity) {
	manager.detach(entity);
    }

    @Override
    public T findById(final PK entityId) {
	return manager.find(persistentClass, entityId);
    }

    @Override
    public List<T> findAll() {
	return manager.createQuery("FROM " + persistentClass.getName()).getResultList();
    }

    @Override
    public T insert(final T entity) {
	manager.persist(entity);
	return entity;
    }

    @Override
    public void deleteById(final PK entityId) {
	manager.remove(manager.find(persistentClass, entityId));
    }

    @Override
    public void delete(final T entity) {
	manager.remove(entity);
    }

    @Override
    public T update(final T entity) {
	return manager.merge(entity);
    }

    @Override
    public T findByIdWithPessimisticLocking(final PK entityId) {
	try {
	    return manager.find(persistentClass, entityId, LockModeType.PESSIMISTIC_WRITE);
	} catch (PessimisticLockException | LockTimeoutException e) {
	    e.printStackTrace();
	    throw e;
	}
    }

    @Override
    public void lock(final T entity) {
	manager.lock(entity, LockModeType.PESSIMISTIC_WRITE);
    }

    @Override
    public Boolean isManaged(final T entity) {
	return manager.contains(entity);
    }

    @Override
    public void mergeEntity(final T entity) {
	manager.merge(entity);
    }

    @Override
    public void flush() {
	manager.flush();
    }

    public List<T> retriveObjectFromList(final List<Object[]> objectsList, final int objectPosition) {
	final List<T> list = new ArrayList<T>(objectsList.size());
	for (final Object[] objects : objectsList) {
	    list.add((T) objects[objectPosition]);
	}
	return list;
    }

    @Override
    public String escapeWildcardCharacters(final String queryParameter) {
	return queryParameter.replaceAll("%", WILDCHAR + "%").replaceAll("_", WILDCHAR + "_");
    }
}

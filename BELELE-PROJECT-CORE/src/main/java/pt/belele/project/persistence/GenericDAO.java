/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.persistence;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, PK extends Serializable> {

    void detach(final T entity);

    /**
     * @param entityId
     * @deprecated If trying to obtain a widely used entity, avoid using this
     * method. Create/Use a specific DAO method to obtain the exact fields you
     * need.
     * @return entity
     */
    @Deprecated
    T findById(final PK entityId);

    List<T> findAll();

    T insert(final T entity);

    void delete(final T entity);

    void deleteById(final PK entityId);

    T update(final T entity);

    T findByIdWithPessimisticLocking(final PK entityId);

    Boolean isManaged(final T entity);

    void mergeEntity(final T entity);

    void flush();

    String escapeWildcardCharacters(final String queryParameter);

    void lock(final T entity);
}

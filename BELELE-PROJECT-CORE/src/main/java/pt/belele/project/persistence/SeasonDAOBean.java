package pt.belele.project.persistence;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import pt.belele.project.business.exception.BeleleException;
import pt.belele.project.entities.Season;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class SeasonDAOBean extends GenericDAOBean<Season, Long> implements SeasonDAO {

    @Override
    public Season findByNameAndYear(String name, Integer year) throws BeleleException {
	TypedQuery<Season> query = manager.createQuery("SELECT s FROM Season s WHERE s.name = :name AND s.year=:year", Season.class);
	query.setParameter("name", name);
	query.setParameter("year", year);
	try {
	    return query.getSingleResult();
	} catch (NoResultException e) {
	    throw new BeleleException("Season Not Found!", e);
	}
    }
}

package pt.belele.project.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.joda.time.DateTime;
import pt.belele.project.business.exception.BeleleException;
import pt.belele.project.entities.Standing;
import pt.belele.project.entities.Team;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class StandingDAOBean extends GenericDAOBean<Standing, Long> implements StandingDAO {

    @Override
    public Standing findStanding(Long teamId, DateTime date, Long seasonId) throws BeleleException {
	TypedQuery<Standing> query = manager.createQuery("SELECT s from Standing s WHERE s.date=:date AND s.team.id = :team AND s.season.id = :seasonId", Standing.class);
	query.setParameter("date", date);
	query.setParameter("team", teamId);
	query.setParameter("seasonId", seasonId);
	try {
	    return query.getSingleResult();
	} catch (NoResultException e) {
	    throw new BeleleException("Standing Not Found!", e);
	}
    }

    @Override
    public Standing findNewestByNameAndDate(Long teamId, DateTime date, Long seasonId) throws NoResultException {
	TypedQuery<Standing> query = manager.createQuery("SELECT s FROM Standing s WHERE s.team.id = :team AND s.season.id = :seasonId  AND s.date < :date ORDER BY s.date DESC", Standing.class);
	query.setParameter("team", teamId);
	query.setParameter("date", date);
	query.setParameter("seasonId", seasonId);
	query.setMaxResults(1);
	if (query.getResultList().isEmpty()) {
	    return null;
	} else {
	    return query.getSingleResult();
	}
    }

    @Override
    public List<Team> getStandingsByPoints(DateTime date, Long seasonId) {
	Query query = manager.createQuery("SELECT t FROM Standing s, IN (s.team) t WHERE s.season.id = :seasonId AND s.date < :date GROUP BY t ORDER BY MAX(s.points) DESC");
	query.setParameter("seasonId", seasonId);
	query.setParameter("date", date);
	return query.getResultList();
    }

    @Override
    public List<Team> getStandingsByQuality(DateTime date, Long seasonId) {
	Query query = manager.createQuery("SELECT t FROM Standing s, IN (s.team) t WHERE s.season.id = :seasonId AND s.date < :date GROUP BY t ORDER BY MAX(s.points) * 1.0 /MAX(s.playedGames) DESC");
	query.setParameter("seasonId", seasonId);
	query.setParameter("date", date);
	return query.getResultList();
    }
}

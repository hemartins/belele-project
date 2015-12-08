package pt.belele.project.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import pt.belele.project.business.exception.BeleleException;
import pt.belele.project.entities.Team;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TeamDAOBean extends GenericDAOBean<Team, String> implements TeamDAO {

    public Team findByName(String name) throws BeleleException {
	TypedQuery<Team> query = manager.createQuery("SELECT t FROM Team t WHERE t.name=:name", Team.class);
	query.setParameter("name", name);
	try {
	    return query.getSingleResult();
	} catch (NoResultException e) {
	    throw new BeleleException("Team Not Found!", e);
	}
    }
    
    @Override
    public List<Team> findHardTeamsBySeasonId(Long seasonId) {
	TypedQuery<Team> query = manager.createQuery("SELECT t from Season s, IN(s.teams) t WHERE t.isHistoric = true AND  s.id = :seasonId",  Team.class);
	query.setParameter("seasonId", seasonId);
	
	return query.getResultList();
    }

}

package pt.belele.project.persistence;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import pt.belele.project.entities.Bet;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BetDAOBean extends GenericDAOBean<Bet, Long> implements BetDAO {

}

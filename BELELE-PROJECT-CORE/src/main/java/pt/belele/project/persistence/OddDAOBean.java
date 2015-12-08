package pt.belele.project.persistence;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import pt.belele.project.entities.Odd;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class OddDAOBean extends GenericDAOBean<Odd, Long> implements OddDAO {

}

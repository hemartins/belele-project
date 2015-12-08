package pt.belele.project.persistence;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import pt.belele.project.entities.Result;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ResultDAOBean extends GenericDAOBean<Result, Long> implements ResultDAO {

}

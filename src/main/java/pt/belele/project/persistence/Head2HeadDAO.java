package pt.belele.project.persistence;

import javax.persistence.EntityManager;

import pt.belele.project.entities.Head2Head;

public class Head2HeadDAO extends GenericDAO<Head2Head>{

	public Head2HeadDAO(EntityManager em) {
		super(em);
	}
	
	

}

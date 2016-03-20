/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business.util.footballDataInterface;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author P056913
 */
@Singleton
@Startup
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DataInputSingleton {

    @EJB
    private DataInputInterface dataInput;

    @PostConstruct
    public void init() {
	//dataInput.generateDatabase();
	dataInput.updateDatabase();
    }

}

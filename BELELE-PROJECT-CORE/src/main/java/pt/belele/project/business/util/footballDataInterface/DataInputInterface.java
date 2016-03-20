/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business.util.footballDataInterface;

import java.util.concurrent.Future;
import javax.ejb.Local;

/**
 *
 * @author P056913
 */
@Local
public interface DataInputInterface {
    Future<Void> generateDatabase();
    
    Future<Void> updateDatabase();
    
    void populateDatabase(String competitionFile, String season, Integer year);
}

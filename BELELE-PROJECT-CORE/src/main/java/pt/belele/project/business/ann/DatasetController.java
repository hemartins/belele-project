/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business.ann;

import java.util.List;
import javax.ejb.Local;
import pt.belele.project.business.ann.obj.Dataset;
import pt.belele.project.business.util.Triplet;
import pt.belele.project.entities.Fixture;

/**
 *
 * @author P056913
 */
@Local
public interface DatasetController {
    
    public Triplet<List<Dataset>, List<Dataset>, List<Dataset>> generateDatasetForFixtures(List<Fixture> fixtures, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception;
}

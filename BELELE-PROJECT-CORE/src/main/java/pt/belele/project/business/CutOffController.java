/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business;

import java.util.List;
import javax.ejb.Local;
import pt.belele.project.business.util.CutOff;
import pt.belele.project.business.util.Triplet;
import pt.belele.project.entities.Fixture;

/**
 *
 * @author P056913
 */
@Local
public interface CutOffController {

    CutOff getSimpleCutoffForFixtures(List<Fixture> fixtures, Double investedValue, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception;

    Triplet<CutOff, CutOff, CutOff> getMultipleCutOffForFixtures(List<Fixture> fixtures, Double investedValue, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception;
}

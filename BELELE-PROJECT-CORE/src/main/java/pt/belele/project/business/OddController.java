/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business;

import java.util.List;
import javax.ejb.Local;
import pt.belele.project.business.ann.obj.DatasetProperties;
import pt.belele.project.business.util.Triplet;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Odd;

/**
 *
 * @author P056913
 */
@Local
public interface OddController {

    void calculateLayOddsAsBackOdds(Odd odd);

    Odd calculateAnnOddsForFixture(Fixture f, List<Fixture> oldFixtures, DatasetProperties prop);

    Triplet<float[], float[], float[]> calculateAnnOddsForFixtures(List<Fixture> fixtures, List<Fixture> oldFixtures, DatasetProperties prop);
}

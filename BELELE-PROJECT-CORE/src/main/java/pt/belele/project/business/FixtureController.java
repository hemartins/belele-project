/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business;

import java.util.List;
import javax.ejb.Local;
import org.joda.time.DateTime;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Odd;
import pt.belele.project.entities.Result;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;

/**
 *
 * @author P056913
 */
@Local
public interface FixtureController {

    Fixture createFixture(DateTime date, Season s, Team home, Team away, Result result, Odd odd);

    Fixture getTeamFixtureBeforeDate(Team t, Season s, DateTime date);

    List<Fixture> getTeamBeforeFixtures(Team t, Season s, DateTime date, Fixture.Venue venue, Integer numberOfFixtures);
}

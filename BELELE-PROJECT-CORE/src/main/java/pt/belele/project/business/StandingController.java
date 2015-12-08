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
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Standing;
import pt.belele.project.entities.Team;

/**
 *
 * @author P056913
 */
@Local
public interface StandingController {

    Standing createStanding(Team team, Season season, Fixture fixture);

    Standing getTeamStanding(Season season, Team team, DateTime date);

    void calculateStandingValues(Standing standing, Fixture fixture);

    Integer calculatePoints(Fixture fixture, String HomeAway);

    Integer calculateHomePoints(Fixture fixture);

    Integer calculateAwayPoints(Fixture fixture);

    List<Team> getTeamsOrderedByClassification(Season s, DateTime date);

    List<Team> getTeamsOrderedByQuality(Season s, DateTime date);
}

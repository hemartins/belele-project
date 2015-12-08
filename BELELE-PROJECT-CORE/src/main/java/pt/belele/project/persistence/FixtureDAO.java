/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.persistence;

import java.util.List;
import javax.ejb.Local;
import org.joda.time.DateTime;
import pt.belele.project.business.exception.BeleleException;
import pt.belele.project.entities.Fixture;

/**
 *
 * @author P056913
 */
@Local
public interface FixtureDAO extends GenericDAO<Fixture, Long> {

    Fixture findFixture(DateTime date, Long seasonId, Long homeTeam, Long awayTeam) throws BeleleException;

    Fixture findFixtureBeforeDate(DateTime date, Long seasonId, Long team);

    List<Fixture> findFixturesBeforeDate(DateTime date, Long seasonId, Long team, Fixture.Venue venue, Integer numberOfFixtures);

    List<Fixture> getH2H(Long homeTeam, Long awayTeam, DateTime date, Integer numberOfGames);

    List<Fixture> getH2HVenue(Long homeTeam, Long awayTeam, DateTime date, Integer numberOfGames);

    List<Fixture> getH2HSwitchedVenue(Long homeTeam, Long awayTeam, DateTime date, Integer numberOfGames);

    List<Fixture> findFixturesBetweenDates(Long seasonId, DateTime begin, DateTime end);

    List<Fixture> findCountryFixturesBetweenDates(String league, DateTime begin, DateTime end);
}

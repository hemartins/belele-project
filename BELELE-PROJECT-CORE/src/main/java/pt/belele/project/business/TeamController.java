/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business;

import java.util.List;
import javax.ejb.Local;
import org.joda.time.DateTime;
import pt.belele.project.business.util.H2H;
import pt.belele.project.business.util.ResultCycle;
import pt.belele.project.business.util.TeamRating;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Fixture.Venue;
import pt.belele.project.entities.Result.ResultType;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;

/**
 *
 * @author P056913
 */
@Local
public interface TeamController {

    Team createTeam(String name);
    
    Double getTeamQuality(Team team, Season season, DateTime date);
    
    Double getHomeTeamQuality(Team team, Season season, DateTime date);
    
    Double getAwayTeamQuality(Team team, Season season, DateTime date);

    Integer getRestingDays(Team team, Fixture nextFixture);

    Double getLastFixturesRating(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures, List<Double> ratings, ResultType type);

    Integer getFRPontuation(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures);

    Double getFRPontuationQuality(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures);

    Double getFRPontuationQualityAndTime(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures);

    Integer getLastFixturesResults(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures, List<Double> ratings, ResultType type);

    Double[] getRecentFormResultPercentage(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures, Double interval, ResultType type);
    
    Integer[] getHomeAndAwayGames(Team team, Fixture nextFixture, Integer numberOfFixtures, ResultType type);

    Double getLastFixturesOpponentAverageQuality(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures);

    Integer getLastHardGamesFixturesNumber(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures);
    
    ResultCycle getTeamCycle(Team team, Fixture nextFixture, Venue venue, ResultType type);

    ResultCycle getTeamCyclePerna(Team team, Fixture nextFixture, Venue venue, ResultType type);
    
    Double getCycleOpponentAverageQuality(ResultCycle cycle);
    
    Integer getCycleHardGamesNumber(ResultCycle cycle);
    
    H2H getH2HRating(Team team, Fixture nextFixture, List<Double> ratings, Venue venue, ResultType type);
    
    H2H getH2HRatingVenue(Team team, Fixture nextFixture, List<Double> ratings, Venue venue, ResultType type);
    
    H2H getH2HRatingSwitchedVenue(Team team, Fixture nextFixture, List<Double> ratings, Venue venue, ResultType type);
    
    TeamRating getResultPercentage(Team team, Fixture nextFixture, Venue venue, ResultType type, Double interval, Integer numerberOfGames);

    Integer getNumberOfFixtures(Team team, Fixture nextFixture, Venue venue);
    
    Double getLastFixturesRatingQuality(Team team, Fixture nextFixture, Venue venue, Integer numberOfFixtures, List<Double> ratings, ResultType type);
    
    Integer getGoals(Team team, Season season, DateTime date);
    
    Integer getGoalsAgainst(Team team, Season season, DateTime date);
    
    Integer getHomeGoals(Team team, Season season, DateTime date);
    
    Integer getHomeGoalsAgainst(Team team, Season season, DateTime date) ;

    Integer getAwayGoals(Team team, Season season, DateTime date);
    
    Integer getAwayGoalsAgainst(Team team, Season season, DateTime date);
    
    Integer getClassification(Team team, Season season, DateTime date);
    
    Integer getQualityClassification(Team team, Season season, DateTime date);
    
    Double[] averageGoalsLastGames(Team team, Fixture nextFixture, Venue venue, Integer numerberOfGames);

    ResultType getResultType(Team team, Fixture fixture);
}

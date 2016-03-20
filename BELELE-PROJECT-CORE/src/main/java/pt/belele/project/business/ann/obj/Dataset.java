/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business.ann.obj;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.joda.time.DateTime;
import pt.belele.project.util.JsonObjectMapper;

/**
 *
 * @author P056913
 */
public class Dataset {

    //// General variables \\\\
    // Overall
    private DateTime date;
    private String homeTeam, awayTeam;
    private Double homeTeamQuality, awayTeamQuality;
    private Integer homeTeamRestingDays, awayTeamRestingDays;
    private Integer homeTeamPosition, awayTeamPosition;
    private Integer result;
    // Venue
    private Double homeTeamQualityVenue, awayTeamQualityVenue;
    // Switched Venue
    private Double homeTeamQualitySwitchedVenue, awayTeamQualitySwitchedVenue;

    //// Cycle variables \\\\
    // Overall
    private Integer homeTeamCycleNotResultNumberFixtures, awayTeamCycleNotResultNumberFixtures;
    private Double homeTeamCycleNotResultOpponentAverageQuality, awayTeamCycleNotResultOpponentAverageQuality;
    private Integer homeTeamCycleNotResultHardFixturesNumber, awayTeamCycleNotResultHardFixturesNumber;

    private Integer homeTeamCycleNumberFixtures, awayTeamCycleNumberFixtures;
    private Double homeTeamCycleOpponentAverageQuality, awayTeamCycleOpponentAverageQuality;
    private Integer homeTeamCycleHardFixturesNumber, awayTeamCycleHardFixturesNumber;

    // Venue
    private Integer homeTeamCycleNotResultNumberFixturesVenue, awayTeamCycleNotResultNumberFixturesVenue;
    private Double homeTeamCycleNotResultOpponentAverageQualityVenue, awayTeamCycleNotResultOpponentAverageQualityVenue;
    private Integer homeTeamCycleNotResultHardFixturesVenue, awayTeamCycleNotResultHardFixturesVenue;

    private Integer homeTeamCycleNumberFixturesVenue, awayTeamCycleNumberFixturesVenue;
    private Double homeTeamCycleOpponentAverageQualityVenue, awayTeamCycleOpponentAverageQualityVenue;
    private Integer homeTeamCycleHardFixturesNumberVenue, awayTeamCycleHardFixturesNumberVenue;

    // Switched Venue
    private Integer homeTeamCycleNotResultNumberFixturesVenueSwitchedVenue, awayTeamCycleNotResultNumberFixturesVenueSwitchedVenue;
    private Double homeTeamCycleNotResultOpponentAverageQualitySwitchedVenue, awayTeamCycleNotResultOpponentAverageQualitySwitchedVenue;
    private Integer homeTeamCycleNotResultHardFixturesSwitchedVenue, awayTeamCycleNotResultHardFixturesSwitchedVenue;

    private Integer homeTeamCycleNumberFixturesSwitchedVenue, awayTeamCycleNumberFixturesSwitchedVenue;
    private Double homeTeamCycleOpponentAverageQualitySwitchedVenue, awayTeamCycleOpponentAverageQualitySwitchedVenue;
    private Integer homeTeamCycleHardFixturesNumberSwitchedVenue, awayTeamCycleHardFixturesNumberSwitchedVenue;

    //// FR variables \\\\
    // Overall
    private Double homeTeamLastFixturesOpponentAverageQuality, awayTeamLastFixturesOpponentAverageQuality;
    private Integer homeTeamLastFixturesHardFixturesNumber, awayTeamLastFixturesHardFixturesNumber;
    private Double homeTeamLastFixturesRating, awayTeamLastFixturesRating;
    private Integer homeTeamLastFixturesResults, awayTeamLastFixturesResults;
    private Integer homeTeamLastFixturesResultIntervalFixtures, awayTeamLastFixturesResultIntervalFixtures;
    private Double homeTeamLastFixturesResultPercentage, awayTeamLastFixturesResultPercentage;
    private Double homeTeamLastFixturesHomeResultPercentage, awayTeamLastFixturesHomeResultPercentage;
    private Double homeTeamLastFixturesAwayResultPercentage, awayTeamLastFixturesAwayResultPercentage;
    private Double homeTeamLastFixturesResultIntervalPercentage, awayTeamLastFixturesResultIntervalPercentage;
    private Double homeTeamLastFixturesHomeResultIntervalPercentage, awayTeamLastFixturesHomeResultIntervalPercentage;
    private Double homeTeamLastFixturesAwayResultIntervalPercentage, awayTeamLastFixturesAwayResultIntervalPercentage;
    private Integer homeTeamLastFixturesFixturesNumber, awayTeamLastFixturesFixturesNumber;
    private Integer homeTeamLastFixturesGoals, awayTeamLastFixturesGoals;
    private Integer homeTeamLastFixturesGoalsConceded, awayTeamLastFixturesGoalsConceded;
    private Integer homeTeamLastFixturesGoalsDifference, awayTeamLastFixturesGoalsDifference;
    private Double homeTeamLastFixturesGoalsAverage, awayTeamLastFixturesGoalsAverage;
    private Double homeTeamLastFixturesGoalsConcededAverage, awayTeamLastFixturesGoalsConcededAverage;
    private Integer homeTeamLastFixturesHomeGoals, awayTeamLastFixturesAwayGoals;
    private Integer homeTeamLastFixturesHomeGoalsConceded, awayTeamLastFixturesAwayGoalsConceded;
    private Integer homeTeamLastFixturesHomeGoalsDifference, awayTeamLastFixturesAwayGoalsDifference;
    private Double homeTeamLastFixturesHomeGoalsAverage, awayTeamLastFixturesAwayGoalsAverage;
    private Double homeTeamLastFixturesHomeGoalsConcededAverage, awayTeamLastFixturesAwayGoalsConcededAverage;
    private Integer homeTeamLastFixturesAwayGoals, awayTeamLastFixturesHomeGoals;
    private Integer homeTeamLastFixturesAwayGoalsConceded, awayTeamLastFixturesHomeGoalsConceded;
    private Integer homeTeamLastFixturesAwayGoalsDifference, awayTeamLastFixturesHomeGoalsDifference;
    private Double homeTeamLastFixturesAwayGoalsAverage, awayTeamLastFixturesHomeGoalsAverage;
    private Double homeTeamLastFixturesAwayGoalsConcededAverage, awayTeamLastFixturesHimeyGoalsConcededAverage;
    private Integer homeTeamLastFixturesPontuation, awayTeamLastFixturesPontuation;
    private Double homeTeamLastFixturesPontuationQuality, awayTeamLastFixturesPontuationQuality;
    private Double homeTeamLastFixturesPontuationQualityAndTime, awayTeamLastFixturesPontuationQualityAndTime;

    // Venue
    private Double homeTeamLastFixturesOpponentAverageQualityVenue, awayTeamLastFixturesOpponentAverageQualityVenue;
    private Integer homeTeamLastFixturesHardFixturesNumberVenue, awayTeamLastFixturesHardFixturesNumberVenue;
    private Double homeTeamLastFixturesRatingVenue, awayTeamLastFixturesRatingVenue;
    private Integer homeTeamLastFixturesResultsVenue, awayTeamLastFixturesResultsVenue;
    private Integer homeTeamLastFixturesResultIntervalFixturesVenue, awayTeamLastFixturesResultIntervalFixturesVenue;
    private Double homeTeamLastFixturesResultPercentageVenue, awayTeamLastFixturesResultPercentageVenue;
    private Double homeTeamLastFixturesResultIntervalPercentageVenue, awayTeamLastFixturesResultIntervalPercentageVenue;
    private Integer homeTeamLastFixturesGoalsVenue, awayTeamLastFixturesGoalsVenue;
    private Integer homeTeamLastFixturesGoalsConcededVenue, awayTeamLastFixturesGoalsConcededVenue;
    private Integer homeTeamLastFixturesGoalsDifferenceVenue, awayTeamLastFixturesGoalsDifferenceVenue;
    private Double homeTeamLastFixturesGoalsAverageVenue, awayTeamLastFixturesGoalsAverageVenue;
    private Double homeTeamLastFixturesGoalsConcededAverageVenue, awayTeamLastFixturesGoalsConcededAverageVenue;
    private Integer homeTeamLastFixturesPontuationVenue, awayTeamLastFixturesPontuationVenue;
    private Double homeTeamLastFixturesPontuationQualityVenue, awayTeamLastFixturesPontuationQualityVenue;
    private Double homeTeamLastFixturesPontuationQualityAndTimeVenue, awayTeamLastFixturesPontuationQualityAndTimeVenue;

    // Switched Venue
    private Double homeTeamLastFixturesOpponentAverageQualitySwitchedVenue, awayTeamLastFixturesOpponentAverageQualitySwitchedVenue;
    private Integer homeTeamLastFixturesHardFixturesNumberSwitchedVenue, awayTeamLastFixturesHardFixturesNumberSwitchedVenue;
    private Double homeTeamLastFixturesRatingSwitchedVenue, awayTeamLastFixturesRatingSwitchedVenue;
    private Integer homeTeamLastFixturesResultsSwitchedVenue, awayTeamLastFixturesResultsSwitchedVenue;
    private Integer homeTeamLastFixturesResultIntervalFixturesSwitchedVenue, awayTeamLastFixturesResultIntervalFixturesSwitchedVenue;
    private Double homeTeamLastFixturesResultPercentageSwitchedVenue, awayTeamLastFixturesResultPercentageSwitchedVenue;
    private Double homeTeamLastFixturesResultIntervalPercentageSwitchedVenue, awayTeamLastFixturesResultIntervalPercentageSwitchedVenue;
    private Integer homeTeamLastFixturesGoalsSwitchedVenue, awayTeamLastFixturesGoalsSwitchedVenue;
    private Integer homeTeamLastFixturesGoalsConcededSwitchedVenue, awayTeamLastFixturesGoalsConcededSwitchedVenue;
    private Integer homeTeamLastFixturesGoalsDifferenceSwitchedVenue, awayTeamLastFixturesGoalsDifferenceSwitchedVenue;
    private Double homeTeamLastFixturesGoalsAverageSwitchedVenue, awayTeamLastFixturesGoalsAverageSwitchedVenue;
    private Double homeTeamLastFixturesGoalsConcededAverageSwitchedVenue, awayTeamLastFixturesGoalsConcededAverageSwitchedVenue;
    private Integer homeTeamLastFixturesPontuationSwitchedVenue, awayTeamLastFixturesPontuationSwitchedVenue;
    private Double homeTeamLastFixturesPontuationQualitySwitchedVenue, awayTeamLastFixturesPontuationQualitySwitchedVenue;
    private Double homeTeamLastFixturesPontuationQualityAndTimeSwitchedVenue, awayTeamLastFixturesPontuationQualityAndTimeSwitchedVenue;

    //// QLT variables\\\\
    // Overall
    private Integer homeTeamNumberOfFixtures, awayTeamNumberOfFixtures;
    private Double homeTeamResultPercentage, awayTeamResultPercentage;
    private Double homeTeamQualityAverage, awayTeamQualityAverage;
    private Double homeTeamResultDificulty, awayTeamResultDificulty;
    private Double homeTeamResultIntervalPercentage, awayTeamResultIntervalPercentage;
    private Integer homeTeamResultIntervalFixtures, awayTeamResultIntervalFixtures;
    private Integer homeTeamGoals, awayTeamGoals;
    private Integer homeTeamConcededGoals, awayTeamConcededGoals;
    private Integer homeTeamGoalsDifference, awayTeamGoalsDifference;
    private Double homeTeamGoalsAverage, awayTeamGoalsAverage;
    private Double homeTeamConcededGoalsAverage, awayTeamConcededGoalsAverage;

    // Venue
    private Integer homeTeamNumberOfFixturesVenue, awayTeamNumberOfFixturesVenue;
    private Double homeTeamResultPercentageVenue, awayTeamResultPercentageVenue;
    private Double homeTeamQualityAverageVenue, awayTeamQualityAverageVenue;
    private Double homeTeamResultDificultyVenue, awayTeamResultDificultyVenue;
    private Double homeTeamResultIntervalPercentageVenue, awayTeamResultIntervalPercentageVenue;
    private Integer homeTeamResultIntervalFixturesVenue, awayTeamResultIntervalFixturesVenue;
    private Integer homeTeamGoalsVenue, awayTeamGoalsVenue;
    private Integer homeTeamConcededGoalsVenue, awayTeamConcededGoalsVenue;
    private Integer homeTeamGoalsDifferenceVenue, awayTeamGoalsDifferenceVenue;
    private Double homeTeamGoalsAverageVenue, awayTeamGoalsAverageVenue;
    private Double homeTeamConcededGoalsAverageVenue, awayTeamConcededGoalsAverageVenue;

    // Switched Venue
    private Integer homeTeamNumberOfFixturesSwitchedVenue, awayTeamNumberOfFixturesSwitchedVenue;
    private Double homeTeamResultPercentageSwitchedVenue, awayTeamResultPercentageSwitchedVenue;
    private Double homeTeamQualityAverageSwitchedVenue, awayTeamQualityAverageSwitchedVenue;
    private Double homeTeamResultDificultySwitchedVenue, awayTeamResultDificultySwitchedVenue;
    private Double homeTeamResultIntervalPercentageSwitchedVenue, awayTeamResultIntervalPercentageSwitchedVenue;
    private Integer homeTeamResultIntervalFixturesSwitchedVenue, awayTeamResultIntervalFixturesSwitchedVenue;
    private Integer homeTeamGoalsSwitchedVenue, awayTeamGoalsSwitchedVenue;
    private Integer homeTeamConcededGoalsSwitchedVenue, awayTeamConcededGoalsSwitchedVenue;
    private Integer homeTeamGoalsDifferenceSwitchedVenue, awayTeamGoalsDifferenceSwitchedVenue;
    private Double homeTeamGoalsAverageSwitchedVenue, awayTeamGoalsAverageSwitchedVenue;
    private Double homeTeamConcededGoalsAverageSwitchedVenue, awayTeamConcededGoalsAverageSwitchedVenue;

    //// H2H variables \\\\
    // Overall
    private Double h2hRating;
    private Integer h2hFixturesNumber;
    private Integer h2hResultsNumber;
    private Double h2hResultsPercentage;

    // Venue
    private Double h2hRatingVenue;
    private Integer h2hFixturesNumberVenue;
    private Integer h2hResultsNumberVenue;
    private Double h2hResultsPercentageVenue;

    // Switched Venue
    private Double h2hRatingSwitchedVenue;
    private Integer h2hFixturesNumberSwitchedVenue;
    private Integer h2hResultsNumberSwitchedVenue;
    private Double h2hResultsPercentageSwitchedVenue;

    ///////////////////////// Construtor e Getters e Setters \\\\\\\\\\\\\\\\\\\\\\\\\\\
    public Dataset() {
    }

    public DateTime getDate() {
	return date;
    }

    public void setDate(DateTime date) {
	this.date = date;
    }

    public String getHomeTeam() {
	return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
	this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
	return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
	this.awayTeam = awayTeam;
    }

    public Double getHomeTeamQuality() {
	return homeTeamQuality;
    }

    public void setHomeTeamQuality(Double homeTeamQuality) {
	this.homeTeamQuality = homeTeamQuality;
    }

    public Double getAwayTeamQuality() {
	return awayTeamQuality;
    }

    public void setAwayTeamQuality(Double awayTeamQuality) {
	this.awayTeamQuality = awayTeamQuality;
    }

    public Integer getHomeTeamRestingDays() {
	return homeTeamRestingDays;
    }

    public void setHomeTeamRestingDays(Integer homeTeamRestingDays) {
	this.homeTeamRestingDays = homeTeamRestingDays;
    }

    public Integer getAwayTeamRestingDays() {
	return awayTeamRestingDays;
    }

    public void setAwayTeamRestingDays(Integer awayTeamRestingDays) {
	this.awayTeamRestingDays = awayTeamRestingDays;
    }

    public Integer getHomeTeamPosition() {
	return homeTeamPosition;
    }

    public void setHomeTeamPosition(Integer homeTeamPosition) {
	this.homeTeamPosition = homeTeamPosition;
    }

    public Integer getAwayTeamPosition() {
	return awayTeamPosition;
    }

    public void setAwayTeamPosition(Integer awayTeamPosition) {
	this.awayTeamPosition = awayTeamPosition;
    }

    public Integer getResult() {
	return result;
    }

    public void setResult(Integer result) {
	this.result = result;
    }

    public Double getHomeTeamQualityVenue() {
	return homeTeamQualityVenue;
    }

    public void setHomeTeamQualityVenue(Double homeTeamQualityVenue) {
	this.homeTeamQualityVenue = homeTeamQualityVenue;
    }

    public Double getAwayTeamQualityVenue() {
	return awayTeamQualityVenue;
    }

    public void setAwayTeamQualityVenue(Double awayTeamQualityVenue) {
	this.awayTeamQualityVenue = awayTeamQualityVenue;
    }

    public Double getHomeTeamQualitySwitchedVenue() {
	return homeTeamQualitySwitchedVenue;
    }

    public void setHomeTeamQualitySwitchedVenue(Double homeTeamQualitySwitchedVenue) {
	this.homeTeamQualitySwitchedVenue = homeTeamQualitySwitchedVenue;
    }

    public Double getAwayTeamQualitySwitchedVenue() {
	return awayTeamQualitySwitchedVenue;
    }

    public void setAwayTeamQualitySwitchedVenue(Double awayTeamQualitySwitchedVenue) {
	this.awayTeamQualitySwitchedVenue = awayTeamQualitySwitchedVenue;
    }

    public Integer getHomeTeamCycleNotResultNumberFixtures() {
	return homeTeamCycleNotResultNumberFixtures;
    }

    public void setHomeTeamCycleNotResultNumberFixtures(Integer homeTeamCycleNotResultNumberFixtures) {
	this.homeTeamCycleNotResultNumberFixtures = homeTeamCycleNotResultNumberFixtures;
    }

    public Integer getAwayTeamCycleNotResultNumberFixtures() {
	return awayTeamCycleNotResultNumberFixtures;
    }

    public void setAwayTeamCycleNotResultNumberFixtures(Integer awayTeamCycleNotResultNumberFixtures) {
	this.awayTeamCycleNotResultNumberFixtures = awayTeamCycleNotResultNumberFixtures;
    }

    public Double getHomeTeamCycleNotResultOpponentAverageQuality() {
	return homeTeamCycleNotResultOpponentAverageQuality;
    }

    public void setHomeTeamCycleNotResultOpponentAverageQuality(Double homeTeamCycleNotResultOpponentAverageQuality) {
	this.homeTeamCycleNotResultOpponentAverageQuality = homeTeamCycleNotResultOpponentAverageQuality;
    }

    public Double getAwayTeamCycleNotResultOpponentAverageQuality() {
	return awayTeamCycleNotResultOpponentAverageQuality;
    }

    public void setAwayTeamCycleNotResultOpponentAverageQuality(Double awayTeamCycleNotResultOpponentAverageQuality) {
	this.awayTeamCycleNotResultOpponentAverageQuality = awayTeamCycleNotResultOpponentAverageQuality;
    }

    public Integer getHomeTeamCycleNotResultHardFixturesNumber() {
	return homeTeamCycleNotResultHardFixturesNumber;
    }

    public void setHomeTeamCycleNotResultHardFixturesNumber(Integer homeTeamCycleNotResultHardFixturesNumber) {
	this.homeTeamCycleNotResultHardFixturesNumber = homeTeamCycleNotResultHardFixturesNumber;
    }

    public Integer getAwayTeamCycleNotResultHardFixturesNumber() {
	return awayTeamCycleNotResultHardFixturesNumber;
    }

    public void setAwayTeamCycleNotResultHardFixturesNumber(Integer awayTeamCycleNotResultHardFixturesNumber) {
	this.awayTeamCycleNotResultHardFixturesNumber = awayTeamCycleNotResultHardFixturesNumber;
    }

    public Integer getHomeTeamCycleNumberFixtures() {
	return homeTeamCycleNumberFixtures;
    }

    public void setHomeTeamCycleNumberFixtures(Integer homeTeamCycleNumberFixtures) {
	this.homeTeamCycleNumberFixtures = homeTeamCycleNumberFixtures;
    }

    public Integer getAwayTeamCycleNumberFixtures() {
	return awayTeamCycleNumberFixtures;
    }

    public void setAwayTeamCycleNumberFixtures(Integer awayTeamCycleNumberFixtures) {
	this.awayTeamCycleNumberFixtures = awayTeamCycleNumberFixtures;
    }

    public Double getHomeTeamCycleOpponentAverageQuality() {
	return homeTeamCycleOpponentAverageQuality;
    }

    public void setHomeTeamCycleOpponentAverageQuality(Double homeTeamCycleOpponentAverageQuality) {
	this.homeTeamCycleOpponentAverageQuality = homeTeamCycleOpponentAverageQuality;
    }

    public Double getAwayTeamCycleOpponentAverageQuality() {
	return awayTeamCycleOpponentAverageQuality;
    }

    public void setAwayTeamCycleOpponentAverageQuality(Double awayTeamCycleOpponentAverageQuality) {
	this.awayTeamCycleOpponentAverageQuality = awayTeamCycleOpponentAverageQuality;
    }

    public Integer getHomeTeamCycleHardFixturesNumber() {
	return homeTeamCycleHardFixturesNumber;
    }

    public void setHomeTeamCycleHardFixturesNumber(Integer homeTeamCycleHardFixturesNumber) {
	this.homeTeamCycleHardFixturesNumber = homeTeamCycleHardFixturesNumber;
    }

    public Integer getAwayTeamCycleHardFixturesNumber() {
	return awayTeamCycleHardFixturesNumber;
    }

    public void setAwayTeamCycleHardFixturesNumber(Integer awayTeamCycleHardFixturesNumber) {
	this.awayTeamCycleHardFixturesNumber = awayTeamCycleHardFixturesNumber;
    }

    public Integer getHomeTeamCycleNotResultNumberFixturesVenue() {
	return homeTeamCycleNotResultNumberFixturesVenue;
    }

    public void setHomeTeamCycleNotResultNumberFixturesVenue(Integer homeTeamCycleNotResultNumberFixturesVenue) {
	this.homeTeamCycleNotResultNumberFixturesVenue = homeTeamCycleNotResultNumberFixturesVenue;
    }

    public Integer getAwayTeamCycleNotResultNumberFixturesVenue() {
	return awayTeamCycleNotResultNumberFixturesVenue;
    }

    public void setAwayTeamCycleNotResultNumberFixturesVenue(Integer awayTeamCycleNotResultNumberFixturesVenue) {
	this.awayTeamCycleNotResultNumberFixturesVenue = awayTeamCycleNotResultNumberFixturesVenue;
    }

    public Double getHomeTeamCycleNotResultOpponentAverageQualityVenue() {
	return homeTeamCycleNotResultOpponentAverageQualityVenue;
    }

    public void setHomeTeamCycleNotResultOpponentAverageQualityVenue(Double homeTeamCycleNotResultOpponentAverageQualityVenue) {
	this.homeTeamCycleNotResultOpponentAverageQualityVenue = homeTeamCycleNotResultOpponentAverageQualityVenue;
    }

    public Double getAwayTeamCycleNotResultOpponentAverageQualityVenue() {
	return awayTeamCycleNotResultOpponentAverageQualityVenue;
    }

    public void setAwayTeamCycleNotResultOpponentAverageQualityVenue(Double awayTeamCycleNotResultOpponentAverageQualityVenue) {
	this.awayTeamCycleNotResultOpponentAverageQualityVenue = awayTeamCycleNotResultOpponentAverageQualityVenue;
    }

    public Integer getHomeTeamCycleNotResultHardFixturesVenue() {
	return homeTeamCycleNotResultHardFixturesVenue;
    }

    public void setHomeTeamCycleNotResultHardFixturesVenue(Integer homeTeamCycleNotResultHardFixturesVenue) {
	this.homeTeamCycleNotResultHardFixturesVenue = homeTeamCycleNotResultHardFixturesVenue;
    }

    public Integer getAwayTeamCycleNotResultHardFixturesVenue() {
	return awayTeamCycleNotResultHardFixturesVenue;
    }

    public void setAwayTeamCycleNotResultHardFixturesVenue(Integer awayTeamCycleNotResultHardFixturesVenue) {
	this.awayTeamCycleNotResultHardFixturesVenue = awayTeamCycleNotResultHardFixturesVenue;
    }

    public Integer getHomeTeamCycleNumberFixturesVenue() {
	return homeTeamCycleNumberFixturesVenue;
    }

    public void setHomeTeamCycleNumberFixturesVenue(Integer homeTeamCycleNumberFixturesVenue) {
	this.homeTeamCycleNumberFixturesVenue = homeTeamCycleNumberFixturesVenue;
    }

    public Integer getAwayTeamCycleNumberFixturesVenue() {
	return awayTeamCycleNumberFixturesVenue;
    }

    public void setAwayTeamCycleNumberFixturesVenue(Integer awayTeamCycleNumberFixturesVenue) {
	this.awayTeamCycleNumberFixturesVenue = awayTeamCycleNumberFixturesVenue;
    }

    public Double getHomeTeamCycleOpponentAverageQualityVenue() {
	return homeTeamCycleOpponentAverageQualityVenue;
    }

    public void setHomeTeamCycleOpponentAverageQualityVenue(Double homeTeamCycleOpponentAverageQualityVenue) {
	this.homeTeamCycleOpponentAverageQualityVenue = homeTeamCycleOpponentAverageQualityVenue;
    }

    public Double getAwayTeamCycleOpponentAverageQualityVenue() {
	return awayTeamCycleOpponentAverageQualityVenue;
    }

    public void setAwayTeamCycleOpponentAverageQualityVenue(Double awayTeamCycleOpponentAverageQualityVenue) {
	this.awayTeamCycleOpponentAverageQualityVenue = awayTeamCycleOpponentAverageQualityVenue;
    }

    public Integer getHomeTeamCycleHardFixturesNumberVenue() {
	return homeTeamCycleHardFixturesNumberVenue;
    }

    public void setHomeTeamCycleHardFixturesNumberVenue(Integer homeTeamCycleHardFixturesNumberVenue) {
	this.homeTeamCycleHardFixturesNumberVenue = homeTeamCycleHardFixturesNumberVenue;
    }

    public Integer getAwayTeamCycleHardFixturesNumberVenue() {
	return awayTeamCycleHardFixturesNumberVenue;
    }

    public void setAwayTeamCycleHardFixturesNumberVenue(Integer awayTeamCycleHardFixturesNumberVenue) {
	this.awayTeamCycleHardFixturesNumberVenue = awayTeamCycleHardFixturesNumberVenue;
    }

    public Integer getHomeTeamCycleNotResultNumberFixturesVenueSwitchedVenue() {
	return homeTeamCycleNotResultNumberFixturesVenueSwitchedVenue;
    }

    public void setHomeTeamCycleNotResultNumberFixturesVenueSwitchedVenue(Integer homeTeamCycleNotResultNumberFixturesVenueSwitchedVenue) {
	this.homeTeamCycleNotResultNumberFixturesVenueSwitchedVenue = homeTeamCycleNotResultNumberFixturesVenueSwitchedVenue;
    }

    public Integer getAwayTeamCycleNotResultNumberFixturesVenueSwitchedVenue() {
	return awayTeamCycleNotResultNumberFixturesVenueSwitchedVenue;
    }

    public void setAwayTeamCycleNotResultNumberFixturesVenueSwitchedVenue(Integer awayTeamCycleNotResultNumberFixturesVenueSwitchedVenue) {
	this.awayTeamCycleNotResultNumberFixturesVenueSwitchedVenue = awayTeamCycleNotResultNumberFixturesVenueSwitchedVenue;
    }

    public Double getHomeTeamCycleNotResultOpponentAverageQualitySwitchedVenue() {
	return homeTeamCycleNotResultOpponentAverageQualitySwitchedVenue;
    }

    public void setHomeTeamCycleNotResultOpponentAverageQualitySwitchedVenue(Double homeTeamCycleNotResultOpponentAverageQualitySwitchedVenue) {
	this.homeTeamCycleNotResultOpponentAverageQualitySwitchedVenue = homeTeamCycleNotResultOpponentAverageQualitySwitchedVenue;
    }

    public Double getAwayTeamCycleNotResultOpponentAverageQualitySwitchedVenue() {
	return awayTeamCycleNotResultOpponentAverageQualitySwitchedVenue;
    }

    public void setAwayTeamCycleNotResultOpponentAverageQualitySwitchedVenue(Double awayTeamCycleNotResultOpponentAverageQualitySwitchedVenue) {
	this.awayTeamCycleNotResultOpponentAverageQualitySwitchedVenue = awayTeamCycleNotResultOpponentAverageQualitySwitchedVenue;
    }

    public Integer getHomeTeamCycleNotResultHardFixturesSwitchedVenue() {
	return homeTeamCycleNotResultHardFixturesSwitchedVenue;
    }

    public void setHomeTeamCycleNotResultHardFixturesSwitchedVenue(Integer homeTeamCycleNotResultHardFixturesSwitchedVenue) {
	this.homeTeamCycleNotResultHardFixturesSwitchedVenue = homeTeamCycleNotResultHardFixturesSwitchedVenue;
    }

    public Integer getAwayTeamCycleNotResultHardFixturesSwitchedVenue() {
	return awayTeamCycleNotResultHardFixturesSwitchedVenue;
    }

    public void setAwayTeamCycleNotResultHardFixturesSwitchedVenue(Integer awayTeamCycleNotResultHardFixturesSwitchedVenue) {
	this.awayTeamCycleNotResultHardFixturesSwitchedVenue = awayTeamCycleNotResultHardFixturesSwitchedVenue;
    }

    public Integer getHomeTeamCycleNumberFixturesSwitchedVenue() {
	return homeTeamCycleNumberFixturesSwitchedVenue;
    }

    public void setHomeTeamCycleNumberFixturesSwitchedVenue(Integer homeTeamCycleNumberFixturesSwitchedVenue) {
	this.homeTeamCycleNumberFixturesSwitchedVenue = homeTeamCycleNumberFixturesSwitchedVenue;
    }

    public Integer getAwayTeamCycleNumberFixturesSwitchedVenue() {
	return awayTeamCycleNumberFixturesSwitchedVenue;
    }

    public void setAwayTeamCycleNumberFixturesSwitchedVenue(Integer awayTeamCycleNumberFixturesSwitchedVenue) {
	this.awayTeamCycleNumberFixturesSwitchedVenue = awayTeamCycleNumberFixturesSwitchedVenue;
    }

    public Double getHomeTeamCycleOpponentAverageQualitySwitchedVenue() {
	return homeTeamCycleOpponentAverageQualitySwitchedVenue;
    }

    public void setHomeTeamCycleOpponentAverageQualitySwitchedVenue(Double homeTeamCycleOpponentAverageQualitySwitchedVenue) {
	this.homeTeamCycleOpponentAverageQualitySwitchedVenue = homeTeamCycleOpponentAverageQualitySwitchedVenue;
    }

    public Double getAwayTeamCycleOpponentAverageQualitySwitchedVenue() {
	return awayTeamCycleOpponentAverageQualitySwitchedVenue;
    }

    public void setAwayTeamCycleOpponentAverageQualitySwitchedVenue(Double awayTeamCycleOpponentAverageQualitySwitchedVenue) {
	this.awayTeamCycleOpponentAverageQualitySwitchedVenue = awayTeamCycleOpponentAverageQualitySwitchedVenue;
    }

    public Integer getHomeTeamCycleHardFixturesNumberSwitchedVenue() {
	return homeTeamCycleHardFixturesNumberSwitchedVenue;
    }

    public void setHomeTeamCycleHardFixturesNumberSwitchedVenue(Integer homeTeamCycleHardFixturesNumberSwitchedVenue) {
	this.homeTeamCycleHardFixturesNumberSwitchedVenue = homeTeamCycleHardFixturesNumberSwitchedVenue;
    }

    public Integer getAwayTeamCycleHardFixturesNumberSwitchedVenue() {
	return awayTeamCycleHardFixturesNumberSwitchedVenue;
    }

    public void setAwayTeamCycleHardFixturesNumberSwitchedVenue(Integer awayTeamCycleHardFixturesNumberSwitchedVenue) {
	this.awayTeamCycleHardFixturesNumberSwitchedVenue = awayTeamCycleHardFixturesNumberSwitchedVenue;
    }

    public Double getHomeTeamLastFixturesOpponentAverageQuality() {
	return homeTeamLastFixturesOpponentAverageQuality;
    }

    public void setHomeTeamLastFixturesOpponentAverageQuality(Double homeTeamLastFixturesOpponentAverageQuality) {
	this.homeTeamLastFixturesOpponentAverageQuality = homeTeamLastFixturesOpponentAverageQuality;
    }

    public Double getAwayTeamLastFixturesOpponentAverageQuality() {
	return awayTeamLastFixturesOpponentAverageQuality;
    }

    public void setAwayTeamLastFixturesOpponentAverageQuality(Double awayTeamLastFixturesOpponentAverageQuality) {
	this.awayTeamLastFixturesOpponentAverageQuality = awayTeamLastFixturesOpponentAverageQuality;
    }

    public Integer getHomeTeamLastFixturesHardFixturesNumber() {
	return homeTeamLastFixturesHardFixturesNumber;
    }

    public void setHomeTeamLastFixturesHardFixturesNumber(Integer homeTeamLastFixturesHardFixturesNumber) {
	this.homeTeamLastFixturesHardFixturesNumber = homeTeamLastFixturesHardFixturesNumber;
    }

    public Integer getAwayTeamLastFixturesHardFixturesNumber() {
	return awayTeamLastFixturesHardFixturesNumber;
    }

    public void setAwayTeamLastFixturesHardFixturesNumber(Integer awayTeamLastFixturesHardFixturesNumber) {
	this.awayTeamLastFixturesHardFixturesNumber = awayTeamLastFixturesHardFixturesNumber;
    }

    public Double getHomeTeamLastFixturesRating() {
	return homeTeamLastFixturesRating;
    }

    public void setHomeTeamLastFixturesRating(Double homeTeamLastFixturesRating) {
	this.homeTeamLastFixturesRating = homeTeamLastFixturesRating;
    }

    public Double getAwayTeamLastFixturesRating() {
	return awayTeamLastFixturesRating;
    }

    public void setAwayTeamLastFixturesRating(Double awayTeamLastFixturesRating) {
	this.awayTeamLastFixturesRating = awayTeamLastFixturesRating;
    }

    public Integer getHomeTeamLastFixturesResults() {
	return homeTeamLastFixturesResults;
    }

    public void setHomeTeamLastFixturesResults(Integer homeTeamLastFixturesResults) {
	this.homeTeamLastFixturesResults = homeTeamLastFixturesResults;
    }

    public Integer getAwayTeamLastFixturesResults() {
	return awayTeamLastFixturesResults;
    }

    public void setAwayTeamLastFixturesResults(Integer awayTeamLastFixturesResults) {
	this.awayTeamLastFixturesResults = awayTeamLastFixturesResults;
    }

    public Integer getHomeTeamLastFixturesResultIntervalFixtures() {
	return homeTeamLastFixturesResultIntervalFixtures;
    }

    public void setHomeTeamLastFixturesResultIntervalFixtures(Integer homeTeamLastFixturesResultIntervalFixtures) {
	this.homeTeamLastFixturesResultIntervalFixtures = homeTeamLastFixturesResultIntervalFixtures;
    }

    public Integer getAwayTeamLastFixturesResultIntervalFixtures() {
	return awayTeamLastFixturesResultIntervalFixtures;
    }

    public void setAwayTeamLastFixturesResultIntervalFixtures(Integer awayTeamLastFixturesResultIntervalFixtures) {
	this.awayTeamLastFixturesResultIntervalFixtures = awayTeamLastFixturesResultIntervalFixtures;
    }

    public Double getHomeTeamLastFixturesResultPercentage() {
	return homeTeamLastFixturesResultPercentage;
    }

    public void setHomeTeamLastFixturesResultPercentage(Double homeTeamLastFixturesResultPercentage) {
	this.homeTeamLastFixturesResultPercentage = homeTeamLastFixturesResultPercentage;
    }

    public Double getAwayTeamLastFixturesResultPercentage() {
	return awayTeamLastFixturesResultPercentage;
    }

    public void setAwayTeamLastFixturesResultPercentage(Double awayTeamLastFixturesResultPercentage) {
	this.awayTeamLastFixturesResultPercentage = awayTeamLastFixturesResultPercentage;
    }

    public Double getHomeTeamLastFixturesHomeResultPercentage() {
	return homeTeamLastFixturesHomeResultPercentage;
    }

    public void setHomeTeamLastFixturesHomeResultPercentage(Double homeTeamLastFixturesHomeResultPercentage) {
	this.homeTeamLastFixturesHomeResultPercentage = homeTeamLastFixturesHomeResultPercentage;
    }

    public Double getAwayTeamLastFixturesHomeResultPercentage() {
	return awayTeamLastFixturesHomeResultPercentage;
    }

    public void setAwayTeamLastFixturesHomeResultPercentage(Double awayTeamLastFixturesHomeResultPercentage) {
	this.awayTeamLastFixturesHomeResultPercentage = awayTeamLastFixturesHomeResultPercentage;
    }

    public Double getHomeTeamLastFixturesAwayResultPercentage() {
	return homeTeamLastFixturesAwayResultPercentage;
    }

    public void setHomeTeamLastFixturesAwayResultPercentage(Double homeTeamLastFixturesAwayResultPercentage) {
	this.homeTeamLastFixturesAwayResultPercentage = homeTeamLastFixturesAwayResultPercentage;
    }

    public Double getAwayTeamLastFixturesAwayResultPercentage() {
	return awayTeamLastFixturesAwayResultPercentage;
    }

    public void setAwayTeamLastFixturesAwayResultPercentage(Double awayTeamLastFixturesAwayResultPercentage) {
	this.awayTeamLastFixturesAwayResultPercentage = awayTeamLastFixturesAwayResultPercentage;
    }

    public Double getHomeTeamLastFixturesResultIntervalPercentage() {
	return homeTeamLastFixturesResultIntervalPercentage;
    }

    public void setHomeTeamLastFixturesResultIntervalPercentage(Double homeTeamLastFixturesResultIntervalPercentage) {
	this.homeTeamLastFixturesResultIntervalPercentage = homeTeamLastFixturesResultIntervalPercentage;
    }

    public Double getAwayTeamLastFixturesResultIntervalPercentage() {
	return awayTeamLastFixturesResultIntervalPercentage;
    }

    public void setAwayTeamLastFixturesResultIntervalPercentage(Double awayTeamLastFixturesResultIntervalPercentage) {
	this.awayTeamLastFixturesResultIntervalPercentage = awayTeamLastFixturesResultIntervalPercentage;
    }

    public Double getHomeTeamLastFixturesHomeResultIntervalPercentage() {
	return homeTeamLastFixturesHomeResultIntervalPercentage;
    }

    public void setHomeTeamLastFixturesHomeResultIntervalPercentage(Double homeTeamLastFixturesHomeResultIntervalPercentage) {
	this.homeTeamLastFixturesHomeResultIntervalPercentage = homeTeamLastFixturesHomeResultIntervalPercentage;
    }

    public Double getAwayTeamLastFixturesHomeResultIntervalPercentage() {
	return awayTeamLastFixturesHomeResultIntervalPercentage;
    }

    public void setAwayTeamLastFixturesHomeResultIntervalPercentage(Double awayTeamLastFixturesHomeResultIntervalPercentage) {
	this.awayTeamLastFixturesHomeResultIntervalPercentage = awayTeamLastFixturesHomeResultIntervalPercentage;
    }

    public Double getHomeTeamLastFixturesAwayResultIntervalPercentage() {
	return homeTeamLastFixturesAwayResultIntervalPercentage;
    }

    public void setHomeTeamLastFixturesAwayResultIntervalPercentage(Double homeTeamLastFixturesAwayResultIntervalPercentage) {
	this.homeTeamLastFixturesAwayResultIntervalPercentage = homeTeamLastFixturesAwayResultIntervalPercentage;
    }

    public Double getAwayTeamLastFixturesAwayResultIntervalPercentage() {
	return awayTeamLastFixturesAwayResultIntervalPercentage;
    }

    public void setAwayTeamLastFixturesAwayResultIntervalPercentage(Double awayTeamLastFixturesAwayResultIntervalPercentage) {
	this.awayTeamLastFixturesAwayResultIntervalPercentage = awayTeamLastFixturesAwayResultIntervalPercentage;
    }

    public Integer getHomeTeamLastFixturesFixturesNumber() {
	return homeTeamLastFixturesFixturesNumber;
    }

    public void setHomeTeamLastFixturesFixturesNumber(Integer homeTeamLastFixturesFixturesNumber) {
	this.homeTeamLastFixturesFixturesNumber = homeTeamLastFixturesFixturesNumber;
    }

    public Integer getAwayTeamLastFixturesFixturesNumber() {
	return awayTeamLastFixturesFixturesNumber;
    }

    public void setAwayTeamLastFixturesFixturesNumber(Integer awayTeamLastFixturesFixturesNumber) {
	this.awayTeamLastFixturesFixturesNumber = awayTeamLastFixturesFixturesNumber;
    }

    public Integer getHomeTeamLastFixturesGoals() {
	return homeTeamLastFixturesGoals;
    }

    public void setHomeTeamLastFixturesGoals(Integer homeTeamLastFixturesGoals) {
	this.homeTeamLastFixturesGoals = homeTeamLastFixturesGoals;
    }

    public Integer getAwayTeamLastFixturesGoals() {
	return awayTeamLastFixturesGoals;
    }

    public void setAwayTeamLastFixturesGoals(Integer awayTeamLastFixturesGoals) {
	this.awayTeamLastFixturesGoals = awayTeamLastFixturesGoals;
    }

    public Integer getHomeTeamLastFixturesGoalsConceded() {
	return homeTeamLastFixturesGoalsConceded;
    }

    public void setHomeTeamLastFixturesGoalsConceded(Integer homeTeamLastFixturesGoalsConceded) {
	this.homeTeamLastFixturesGoalsConceded = homeTeamLastFixturesGoalsConceded;
    }

    public Integer getAwayTeamLastFixturesGoalsConceded() {
	return awayTeamLastFixturesGoalsConceded;
    }

    public void setAwayTeamLastFixturesGoalsConceded(Integer awayTeamLastFixturesGoalsConceded) {
	this.awayTeamLastFixturesGoalsConceded = awayTeamLastFixturesGoalsConceded;
    }

    public Integer getHomeTeamLastFixturesGoalsDifference() {
	return homeTeamLastFixturesGoalsDifference;
    }

    public void setHomeTeamLastFixturesGoalsDifference(Integer homeTeamLastFixturesGoalsDifference) {
	this.homeTeamLastFixturesGoalsDifference = homeTeamLastFixturesGoalsDifference;
    }

    public Integer getAwayTeamLastFixturesGoalsDifference() {
	return awayTeamLastFixturesGoalsDifference;
    }

    public void setAwayTeamLastFixturesGoalsDifference(Integer awayTeamLastFixturesGoalsDifference) {
	this.awayTeamLastFixturesGoalsDifference = awayTeamLastFixturesGoalsDifference;
    }

    public Double getHomeTeamLastFixturesGoalsAverage() {
	return homeTeamLastFixturesGoalsAverage;
    }

    public void setHomeTeamLastFixturesGoalsAverage(Double homeTeamLastFixturesGoalsAverage) {
	this.homeTeamLastFixturesGoalsAverage = homeTeamLastFixturesGoalsAverage;
    }

    public Double getAwayTeamLastFixturesGoalsAverage() {
	return awayTeamLastFixturesGoalsAverage;
    }

    public void setAwayTeamLastFixturesGoalsAverage(Double awayTeamLastFixturesGoalsAverage) {
	this.awayTeamLastFixturesGoalsAverage = awayTeamLastFixturesGoalsAverage;
    }

    public Double getHomeTeamLastFixturesGoalsConcededAverage() {
	return homeTeamLastFixturesGoalsConcededAverage;
    }

    public void setHomeTeamLastFixturesGoalsConcededAverage(Double homeTeamLastFixturesGoalsConcededAverage) {
	this.homeTeamLastFixturesGoalsConcededAverage = homeTeamLastFixturesGoalsConcededAverage;
    }

    public Double getAwayTeamLastFixturesGoalsConcededAverage() {
	return awayTeamLastFixturesGoalsConcededAverage;
    }

    public void setAwayTeamLastFixturesGoalsConcededAverage(Double awayTeamLastFixturesGoalsConcededAverage) {
	this.awayTeamLastFixturesGoalsConcededAverage = awayTeamLastFixturesGoalsConcededAverage;
    }

    public Integer getHomeTeamLastFixturesHomeGoals() {
	return homeTeamLastFixturesHomeGoals;
    }

    public void setHomeTeamLastFixturesHomeGoals(Integer homeTeamLastFixturesHomeGoals) {
	this.homeTeamLastFixturesHomeGoals = homeTeamLastFixturesHomeGoals;
    }

    public Integer getAwayTeamLastFixturesAwayGoals() {
	return awayTeamLastFixturesAwayGoals;
    }

    public void setAwayTeamLastFixturesAwayGoals(Integer awayTeamLastFixturesAwayGoals) {
	this.awayTeamLastFixturesAwayGoals = awayTeamLastFixturesAwayGoals;
    }

    public Integer getHomeTeamLastFixturesHomeGoalsConceded() {
	return homeTeamLastFixturesHomeGoalsConceded;
    }

    public void setHomeTeamLastFixturesHomeGoalsConceded(Integer homeTeamLastFixturesHomeGoalsConceded) {
	this.homeTeamLastFixturesHomeGoalsConceded = homeTeamLastFixturesHomeGoalsConceded;
    }

    public Integer getAwayTeamLastFixturesAwayGoalsConceded() {
	return awayTeamLastFixturesAwayGoalsConceded;
    }

    public void setAwayTeamLastFixturesAwayGoalsConceded(Integer awayTeamLastFixturesAwayGoalsConceded) {
	this.awayTeamLastFixturesAwayGoalsConceded = awayTeamLastFixturesAwayGoalsConceded;
    }

    public Integer getHomeTeamLastFixturesHomeGoalsDifference() {
	return homeTeamLastFixturesHomeGoalsDifference;
    }

    public void setHomeTeamLastFixturesHomeGoalsDifference(Integer homeTeamLastFixturesHomeGoalsDifference) {
	this.homeTeamLastFixturesHomeGoalsDifference = homeTeamLastFixturesHomeGoalsDifference;
    }

    public Integer getAwayTeamLastFixturesAwayGoalsDifference() {
	return awayTeamLastFixturesAwayGoalsDifference;
    }

    public void setAwayTeamLastFixturesAwayGoalsDifference(Integer awayTeamLastFixturesAwayGoalsDifference) {
	this.awayTeamLastFixturesAwayGoalsDifference = awayTeamLastFixturesAwayGoalsDifference;
    }

    public Double getHomeTeamLastFixturesHomeGoalsAverage() {
	return homeTeamLastFixturesHomeGoalsAverage;
    }

    public void setHomeTeamLastFixturesHomeGoalsAverage(Double homeTeamLastFixturesHomeGoalsAverage) {
	this.homeTeamLastFixturesHomeGoalsAverage = homeTeamLastFixturesHomeGoalsAverage;
    }

    public Double getAwayTeamLastFixturesAwayGoalsAverage() {
	return awayTeamLastFixturesAwayGoalsAverage;
    }

    public void setAwayTeamLastFixturesAwayGoalsAverage(Double awayTeamLastFixturesAwayGoalsAverage) {
	this.awayTeamLastFixturesAwayGoalsAverage = awayTeamLastFixturesAwayGoalsAverage;
    }

    public Double getHomeTeamLastFixturesHomeGoalsConcededAverage() {
	return homeTeamLastFixturesHomeGoalsConcededAverage;
    }

    public void setHomeTeamLastFixturesHomeGoalsConcededAverage(Double homeTeamLastFixturesHomeGoalsConcededAverage) {
	this.homeTeamLastFixturesHomeGoalsConcededAverage = homeTeamLastFixturesHomeGoalsConcededAverage;
    }

    public Double getAwayTeamLastFixturesAwayGoalsConcededAverage() {
	return awayTeamLastFixturesAwayGoalsConcededAverage;
    }

    public void setAwayTeamLastFixturesAwayGoalsConcededAverage(Double awayTeamLastFixturesAwayGoalsConcededAverage) {
	this.awayTeamLastFixturesAwayGoalsConcededAverage = awayTeamLastFixturesAwayGoalsConcededAverage;
    }

    public Integer getHomeTeamLastFixturesAwayGoals() {
	return homeTeamLastFixturesAwayGoals;
    }

    public void setHomeTeamLastFixturesAwayGoals(Integer homeTeamLastFixturesAwayGoals) {
	this.homeTeamLastFixturesAwayGoals = homeTeamLastFixturesAwayGoals;
    }

    public Integer getAwayTeamLastFixturesHomeGoals() {
	return awayTeamLastFixturesHomeGoals;
    }

    public void setAwayTeamLastFixturesHomeGoals(Integer awayTeamLastFixturesHomeGoals) {
	this.awayTeamLastFixturesHomeGoals = awayTeamLastFixturesHomeGoals;
    }

    public Integer getHomeTeamLastFixturesAwayGoalsConceded() {
	return homeTeamLastFixturesAwayGoalsConceded;
    }

    public void setHomeTeamLastFixturesAwayGoalsConceded(Integer homeTeamLastFixturesAwayGoalsConceded) {
	this.homeTeamLastFixturesAwayGoalsConceded = homeTeamLastFixturesAwayGoalsConceded;
    }

    public Integer getAwayTeamLastFixturesHomeGoalsConceded() {
	return awayTeamLastFixturesHomeGoalsConceded;
    }

    public void setAwayTeamLastFixturesHomeGoalsConceded(Integer awayTeamLastFixturesHomeGoalsConceded) {
	this.awayTeamLastFixturesHomeGoalsConceded = awayTeamLastFixturesHomeGoalsConceded;
    }

    public Integer getHomeTeamLastFixturesAwayGoalsDifference() {
	return homeTeamLastFixturesAwayGoalsDifference;
    }

    public void setHomeTeamLastFixturesAwayGoalsDifference(Integer homeTeamLastFixturesAwayGoalsDifference) {
	this.homeTeamLastFixturesAwayGoalsDifference = homeTeamLastFixturesAwayGoalsDifference;
    }

    public Integer getAwayTeamLastFixturesHomeGoalsDifference() {
	return awayTeamLastFixturesHomeGoalsDifference;
    }

    public void setAwayTeamLastFixturesHomeGoalsDifference(Integer awayTeamLastFixturesHomeGoalsDifference) {
	this.awayTeamLastFixturesHomeGoalsDifference = awayTeamLastFixturesHomeGoalsDifference;
    }

    public Double getHomeTeamLastFixturesAwayGoalsAverage() {
	return homeTeamLastFixturesAwayGoalsAverage;
    }

    public void setHomeTeamLastFixturesAwayGoalsAverage(Double homeTeamLastFixturesAwayGoalsAverage) {
	this.homeTeamLastFixturesAwayGoalsAverage = homeTeamLastFixturesAwayGoalsAverage;
    }

    public Double getAwayTeamLastFixturesHomeGoalsAverage() {
	return awayTeamLastFixturesHomeGoalsAverage;
    }

    public void setAwayTeamLastFixturesHomeGoalsAverage(Double awayTeamLastFixturesHomeGoalsAverage) {
	this.awayTeamLastFixturesHomeGoalsAverage = awayTeamLastFixturesHomeGoalsAverage;
    }

    public Double getHomeTeamLastFixturesAwayGoalsConcededAverage() {
	return homeTeamLastFixturesAwayGoalsConcededAverage;
    }

    public void setHomeTeamLastFixturesAwayGoalsConcededAverage(Double homeTeamLastFixturesAwayGoalsConcededAverage) {
	this.homeTeamLastFixturesAwayGoalsConcededAverage = homeTeamLastFixturesAwayGoalsConcededAverage;
    }

    public Double getAwayTeamLastFixturesHimeyGoalsConcededAverage() {
	return awayTeamLastFixturesHimeyGoalsConcededAverage;
    }

    public void setAwayTeamLastFixturesHimeyGoalsConcededAverage(Double awayTeamLastFixturesHimeyGoalsConcededAverage) {
	this.awayTeamLastFixturesHimeyGoalsConcededAverage = awayTeamLastFixturesHimeyGoalsConcededAverage;
    }

    public Integer getHomeTeamLastFixturesPontuation() {
	return homeTeamLastFixturesPontuation;
    }

    public void setHomeTeamLastFixturesPontuation(Integer homeTeamLastFixturesPontuation) {
	this.homeTeamLastFixturesPontuation = homeTeamLastFixturesPontuation;
    }

    public Integer getAwayTeamLastFixturesPontuation() {
	return awayTeamLastFixturesPontuation;
    }

    public void setAwayTeamLastFixturesPontuation(Integer awayTeamLastFixturesPontuation) {
	this.awayTeamLastFixturesPontuation = awayTeamLastFixturesPontuation;
    }

    public Double getHomeTeamLastFixturesPontuationQuality() {
	return homeTeamLastFixturesPontuationQuality;
    }

    public void setHomeTeamLastFixturesPontuationQuality(Double homeTeamLastFixturesPontuationQuality) {
	this.homeTeamLastFixturesPontuationQuality = homeTeamLastFixturesPontuationQuality;
    }

    public Double getAwayTeamLastFixturesPontuationQuality() {
	return awayTeamLastFixturesPontuationQuality;
    }

    public void setAwayTeamLastFixturesPontuationQuality(Double awayTeamLastFixturesPontuationQuality) {
	this.awayTeamLastFixturesPontuationQuality = awayTeamLastFixturesPontuationQuality;
    }

    public Double getHomeTeamLastFixturesPontuationQualityAndTime() {
	return homeTeamLastFixturesPontuationQualityAndTime;
    }

    public void setHomeTeamLastFixturesPontuationQualityAndTime(Double homeTeamLastFixturesPontuationQualityAndTime) {
	this.homeTeamLastFixturesPontuationQualityAndTime = homeTeamLastFixturesPontuationQualityAndTime;
    }

    public Double getAwayTeamLastFixturesPontuationQualityAndTime() {
	return awayTeamLastFixturesPontuationQualityAndTime;
    }

    public void setAwayTeamLastFixturesPontuationQualityAndTime(Double awayTeamLastFixturesPontuationQualityAndTime) {
	this.awayTeamLastFixturesPontuationQualityAndTime = awayTeamLastFixturesPontuationQualityAndTime;
    }

    public Double getHomeTeamLastFixturesOpponentAverageQualityVenue() {
	return homeTeamLastFixturesOpponentAverageQualityVenue;
    }

    public void setHomeTeamLastFixturesOpponentAverageQualityVenue(Double homeTeamLastFixturesOpponentAverageQualityVenue) {
	this.homeTeamLastFixturesOpponentAverageQualityVenue = homeTeamLastFixturesOpponentAverageQualityVenue;
    }

    public Double getAwayTeamLastFixturesOpponentAverageQualityVenue() {
	return awayTeamLastFixturesOpponentAverageQualityVenue;
    }

    public void setAwayTeamLastFixturesOpponentAverageQualityVenue(Double awayTeamLastFixturesOpponentAverageQualityVenue) {
	this.awayTeamLastFixturesOpponentAverageQualityVenue = awayTeamLastFixturesOpponentAverageQualityVenue;
    }

    public Integer getHomeTeamLastFixturesHardFixturesNumberVenue() {
	return homeTeamLastFixturesHardFixturesNumberVenue;
    }

    public void setHomeTeamLastFixturesHardFixturesNumberVenue(Integer homeTeamLastFixturesHardFixturesNumberVenue) {
	this.homeTeamLastFixturesHardFixturesNumberVenue = homeTeamLastFixturesHardFixturesNumberVenue;
    }

    public Integer getAwayTeamLastFixturesHardFixturesNumberVenue() {
	return awayTeamLastFixturesHardFixturesNumberVenue;
    }

    public void setAwayTeamLastFixturesHardFixturesNumberVenue(Integer awayTeamLastFixturesHardFixturesNumberVenue) {
	this.awayTeamLastFixturesHardFixturesNumberVenue = awayTeamLastFixturesHardFixturesNumberVenue;
    }

    public Double getHomeTeamLastFixturesRatingVenue() {
	return homeTeamLastFixturesRatingVenue;
    }

    public void setHomeTeamLastFixturesRatingVenue(Double homeTeamLastFixturesRatingVenue) {
	this.homeTeamLastFixturesRatingVenue = homeTeamLastFixturesRatingVenue;
    }

    public Double getAwayTeamLastFixturesRatingVenue() {
	return awayTeamLastFixturesRatingVenue;
    }

    public void setAwayTeamLastFixturesRatingVenue(Double awayTeamLastFixturesRatingVenue) {
	this.awayTeamLastFixturesRatingVenue = awayTeamLastFixturesRatingVenue;
    }

    public Integer getHomeTeamLastFixturesResultsVenue() {
	return homeTeamLastFixturesResultsVenue;
    }

    public void setHomeTeamLastFixturesResultsVenue(Integer homeTeamLastFixturesResultsVenue) {
	this.homeTeamLastFixturesResultsVenue = homeTeamLastFixturesResultsVenue;
    }

    public Integer getAwayTeamLastFixturesResultsVenue() {
	return awayTeamLastFixturesResultsVenue;
    }

    public void setAwayTeamLastFixturesResultsVenue(Integer awayTeamLastFixturesResultsVenue) {
	this.awayTeamLastFixturesResultsVenue = awayTeamLastFixturesResultsVenue;
    }

    public Integer getHomeTeamLastFixturesResultIntervalFixturesVenue() {
	return homeTeamLastFixturesResultIntervalFixturesVenue;
    }

    public void setHomeTeamLastFixturesResultIntervalFixturesVenue(Integer homeTeamLastFixturesResultIntervalFixturesVenue) {
	this.homeTeamLastFixturesResultIntervalFixturesVenue = homeTeamLastFixturesResultIntervalFixturesVenue;
    }

    public Integer getAwayTeamLastFixturesResultIntervalFixturesVenue() {
	return awayTeamLastFixturesResultIntervalFixturesVenue;
    }

    public void setAwayTeamLastFixturesResultIntervalFixturesVenue(Integer awayTeamLastFixturesResultIntervalFixturesVenue) {
	this.awayTeamLastFixturesResultIntervalFixturesVenue = awayTeamLastFixturesResultIntervalFixturesVenue;
    }

    public Double getHomeTeamLastFixturesResultPercentageVenue() {
	return homeTeamLastFixturesResultPercentageVenue;
    }

    public void setHomeTeamLastFixturesResultPercentageVenue(Double homeTeamLastFixturesResultPercentageVenue) {
	this.homeTeamLastFixturesResultPercentageVenue = homeTeamLastFixturesResultPercentageVenue;
    }

    public Double getAwayTeamLastFixturesResultPercentageVenue() {
	return awayTeamLastFixturesResultPercentageVenue;
    }

    public void setAwayTeamLastFixturesResultPercentageVenue(Double awayTeamLastFixturesResultPercentageVenue) {
	this.awayTeamLastFixturesResultPercentageVenue = awayTeamLastFixturesResultPercentageVenue;
    }

    public Double getHomeTeamLastFixturesResultIntervalPercentageVenue() {
	return homeTeamLastFixturesResultIntervalPercentageVenue;
    }

    public void setHomeTeamLastFixturesResultIntervalPercentageVenue(Double homeTeamLastFixturesResultIntervalPercentageVenue) {
	this.homeTeamLastFixturesResultIntervalPercentageVenue = homeTeamLastFixturesResultIntervalPercentageVenue;
    }

    public Double getAwayTeamLastFixturesResultIntervalPercentageVenue() {
	return awayTeamLastFixturesResultIntervalPercentageVenue;
    }

    public void setAwayTeamLastFixturesResultIntervalPercentageVenue(Double awayTeamLastFixturesResultIntervalPercentageVenue) {
	this.awayTeamLastFixturesResultIntervalPercentageVenue = awayTeamLastFixturesResultIntervalPercentageVenue;
    }

    public Integer getHomeTeamLastFixturesGoalsVenue() {
	return homeTeamLastFixturesGoalsVenue;
    }

    public void setHomeTeamLastFixturesGoalsVenue(Integer homeTeamLastFixturesGoalsVenue) {
	this.homeTeamLastFixturesGoalsVenue = homeTeamLastFixturesGoalsVenue;
    }

    public Integer getAwayTeamLastFixturesGoalsVenue() {
	return awayTeamLastFixturesGoalsVenue;
    }

    public void setAwayTeamLastFixturesGoalsVenue(Integer awayTeamLastFixturesGoalsVenue) {
	this.awayTeamLastFixturesGoalsVenue = awayTeamLastFixturesGoalsVenue;
    }

    public Integer getHomeTeamLastFixturesGoalsConcededVenue() {
	return homeTeamLastFixturesGoalsConcededVenue;
    }

    public void setHomeTeamLastFixturesGoalsConcededVenue(Integer homeTeamLastFixturesGoalsConcededVenue) {
	this.homeTeamLastFixturesGoalsConcededVenue = homeTeamLastFixturesGoalsConcededVenue;
    }

    public Integer getAwayTeamLastFixturesGoalsConcededVenue() {
	return awayTeamLastFixturesGoalsConcededVenue;
    }

    public void setAwayTeamLastFixturesGoalsConcededVenue(Integer awayTeamLastFixturesGoalsConcededVenue) {
	this.awayTeamLastFixturesGoalsConcededVenue = awayTeamLastFixturesGoalsConcededVenue;
    }

    public Integer getHomeTeamLastFixturesGoalsDifferenceVenue() {
	return homeTeamLastFixturesGoalsDifferenceVenue;
    }

    public void setHomeTeamLastFixturesGoalsDifferenceVenue(Integer homeTeamLastFixturesGoalsDifferenceVenue) {
	this.homeTeamLastFixturesGoalsDifferenceVenue = homeTeamLastFixturesGoalsDifferenceVenue;
    }

    public Integer getAwayTeamLastFixturesGoalsDifferenceVenue() {
	return awayTeamLastFixturesGoalsDifferenceVenue;
    }

    public void setAwayTeamLastFixturesGoalsDifferenceVenue(Integer awayTeamLastFixturesGoalsDifferenceVenue) {
	this.awayTeamLastFixturesGoalsDifferenceVenue = awayTeamLastFixturesGoalsDifferenceVenue;
    }

    public Double getHomeTeamLastFixturesGoalsAverageVenue() {
	return homeTeamLastFixturesGoalsAverageVenue;
    }

    public void setHomeTeamLastFixturesGoalsAverageVenue(Double homeTeamLastFixturesGoalsAverageVenue) {
	this.homeTeamLastFixturesGoalsAverageVenue = homeTeamLastFixturesGoalsAverageVenue;
    }

    public Double getAwayTeamLastFixturesGoalsAverageVenue() {
	return awayTeamLastFixturesGoalsAverageVenue;
    }

    public void setAwayTeamLastFixturesGoalsAverageVenue(Double awayTeamLastFixturesGoalsAverageVenue) {
	this.awayTeamLastFixturesGoalsAverageVenue = awayTeamLastFixturesGoalsAverageVenue;
    }

    public Double getHomeTeamLastFixturesGoalsConcededAverageVenue() {
	return homeTeamLastFixturesGoalsConcededAverageVenue;
    }

    public void setHomeTeamLastFixturesGoalsConcededAverageVenue(Double homeTeamLastFixturesGoalsConcededAverageVenue) {
	this.homeTeamLastFixturesGoalsConcededAverageVenue = homeTeamLastFixturesGoalsConcededAverageVenue;
    }

    public Double getAwayTeamLastFixturesGoalsConcededAverageVenue() {
	return awayTeamLastFixturesGoalsConcededAverageVenue;
    }

    public void setAwayTeamLastFixturesGoalsConcededAverageVenue(Double awayTeamLastFixturesGoalsConcededAverageVenue) {
	this.awayTeamLastFixturesGoalsConcededAverageVenue = awayTeamLastFixturesGoalsConcededAverageVenue;
    }

    public Integer getHomeTeamLastFixturesPontuationVenue() {
	return homeTeamLastFixturesPontuationVenue;
    }

    public void setHomeTeamLastFixturesPontuationVenue(Integer homeTeamLastFixturesPontuationVenue) {
	this.homeTeamLastFixturesPontuationVenue = homeTeamLastFixturesPontuationVenue;
    }

    public Integer getAwayTeamLastFixturesPontuationVenue() {
	return awayTeamLastFixturesPontuationVenue;
    }

    public void setAwayTeamLastFixturesPontuationVenue(Integer awayTeamLastFixturesPontuationVenue) {
	this.awayTeamLastFixturesPontuationVenue = awayTeamLastFixturesPontuationVenue;
    }

    public Double getHomeTeamLastFixturesPontuationQualityVenue() {
	return homeTeamLastFixturesPontuationQualityVenue;
    }

    public void setHomeTeamLastFixturesPontuationQualityVenue(Double homeTeamLastFixturesPontuationQualityVenue) {
	this.homeTeamLastFixturesPontuationQualityVenue = homeTeamLastFixturesPontuationQualityVenue;
    }

    public Double getAwayTeamLastFixturesPontuationQualityVenue() {
	return awayTeamLastFixturesPontuationQualityVenue;
    }

    public void setAwayTeamLastFixturesPontuationQualityVenue(Double awayTeamLastFixturesPontuationQualityVenue) {
	this.awayTeamLastFixturesPontuationQualityVenue = awayTeamLastFixturesPontuationQualityVenue;
    }

    public Double getHomeTeamLastFixturesPontuationQualityAndTimeVenue() {
	return homeTeamLastFixturesPontuationQualityAndTimeVenue;
    }

    public void setHomeTeamLastFixturesPontuationQualityAndTimeVenue(Double homeTeamLastFixturesPontuationQualityAndTimeVenue) {
	this.homeTeamLastFixturesPontuationQualityAndTimeVenue = homeTeamLastFixturesPontuationQualityAndTimeVenue;
    }

    public Double getAwayTeamLastFixturesPontuationQualityAndTimeVenue() {
	return awayTeamLastFixturesPontuationQualityAndTimeVenue;
    }

    public void setAwayTeamLastFixturesPontuationQualityAndTimeVenue(Double awayTeamLastFixturesPontuationQualityAndTimeVenue) {
	this.awayTeamLastFixturesPontuationQualityAndTimeVenue = awayTeamLastFixturesPontuationQualityAndTimeVenue;
    }

    public Double getHomeTeamLastFixturesOpponentAverageQualitySwitchedVenue() {
	return homeTeamLastFixturesOpponentAverageQualitySwitchedVenue;
    }

    public void setHomeTeamLastFixturesOpponentAverageQualitySwitchedVenue(Double homeTeamLastFixturesOpponentAverageQualitySwitchedVenue) {
	this.homeTeamLastFixturesOpponentAverageQualitySwitchedVenue = homeTeamLastFixturesOpponentAverageQualitySwitchedVenue;
    }

    public Double getAwayTeamLastFixturesOpponentAverageQualitySwitchedVenue() {
	return awayTeamLastFixturesOpponentAverageQualitySwitchedVenue;
    }

    public void setAwayTeamLastFixturesOpponentAverageQualitySwitchedVenue(Double awayTeamLastFixturesOpponentAverageQualitySwitchedVenue) {
	this.awayTeamLastFixturesOpponentAverageQualitySwitchedVenue = awayTeamLastFixturesOpponentAverageQualitySwitchedVenue;
    }

    public Integer getHomeTeamLastFixturesHardFixturesNumberSwitchedVenue() {
	return homeTeamLastFixturesHardFixturesNumberSwitchedVenue;
    }

    public void setHomeTeamLastFixturesHardFixturesNumberSwitchedVenue(Integer homeTeamLastFixturesHardFixturesNumberSwitchedVenue) {
	this.homeTeamLastFixturesHardFixturesNumberSwitchedVenue = homeTeamLastFixturesHardFixturesNumberSwitchedVenue;
    }

    public Integer getAwayTeamLastFixturesHardFixturesNumberSwitchedVenue() {
	return awayTeamLastFixturesHardFixturesNumberSwitchedVenue;
    }

    public void setAwayTeamLastFixturesHardFixturesNumberSwitchedVenue(Integer awayTeamLastFixturesHardFixturesNumberSwitchedVenue) {
	this.awayTeamLastFixturesHardFixturesNumberSwitchedVenue = awayTeamLastFixturesHardFixturesNumberSwitchedVenue;
    }

    public Double getHomeTeamLastFixturesRatingSwitchedVenue() {
	return homeTeamLastFixturesRatingSwitchedVenue;
    }

    public void setHomeTeamLastFixturesRatingSwitchedVenue(Double homeTeamLastFixturesRatingSwitchedVenue) {
	this.homeTeamLastFixturesRatingSwitchedVenue = homeTeamLastFixturesRatingSwitchedVenue;
    }

    public Double getAwayTeamLastFixturesRatingSwitchedVenue() {
	return awayTeamLastFixturesRatingSwitchedVenue;
    }

    public void setAwayTeamLastFixturesRatingSwitchedVenue(Double awayTeamLastFixturesRatingSwitchedVenue) {
	this.awayTeamLastFixturesRatingSwitchedVenue = awayTeamLastFixturesRatingSwitchedVenue;
    }

    public Integer getHomeTeamLastFixturesResultsSwitchedVenue() {
	return homeTeamLastFixturesResultsSwitchedVenue;
    }

    public void setHomeTeamLastFixturesResultsSwitchedVenue(Integer homeTeamLastFixturesResultsSwitchedVenue) {
	this.homeTeamLastFixturesResultsSwitchedVenue = homeTeamLastFixturesResultsSwitchedVenue;
    }

    public Integer getAwayTeamLastFixturesResultsSwitchedVenue() {
	return awayTeamLastFixturesResultsSwitchedVenue;
    }

    public void setAwayTeamLastFixturesResultsSwitchedVenue(Integer awayTeamLastFixturesResultsSwitchedVenue) {
	this.awayTeamLastFixturesResultsSwitchedVenue = awayTeamLastFixturesResultsSwitchedVenue;
    }

    public Integer getHomeTeamLastFixturesResultIntervalFixturesSwitchedVenue() {
	return homeTeamLastFixturesResultIntervalFixturesSwitchedVenue;
    }

    public void setHomeTeamLastFixturesResultIntervalFixturesSwitchedVenue(Integer homeTeamLastFixturesResultIntervalFixturesSwitchedVenue) {
	this.homeTeamLastFixturesResultIntervalFixturesSwitchedVenue = homeTeamLastFixturesResultIntervalFixturesSwitchedVenue;
    }

    public Integer getAwayTeamLastFixturesResultIntervalFixturesSwitchedVenue() {
	return awayTeamLastFixturesResultIntervalFixturesSwitchedVenue;
    }

    public void setAwayTeamLastFixturesResultIntervalFixturesSwitchedVenue(Integer awayTeamLastFixturesResultIntervalFixturesSwitchedVenue) {
	this.awayTeamLastFixturesResultIntervalFixturesSwitchedVenue = awayTeamLastFixturesResultIntervalFixturesSwitchedVenue;
    }

    public Double getHomeTeamLastFixturesResultPercentageSwitchedVenue() {
	return homeTeamLastFixturesResultPercentageSwitchedVenue;
    }

    public void setHomeTeamLastFixturesResultPercentageSwitchedVenue(Double homeTeamLastFixturesResultPercentageSwitchedVenue) {
	this.homeTeamLastFixturesResultPercentageSwitchedVenue = homeTeamLastFixturesResultPercentageSwitchedVenue;
    }

    public Double getAwayTeamLastFixturesResultPercentageSwitchedVenue() {
	return awayTeamLastFixturesResultPercentageSwitchedVenue;
    }

    public void setAwayTeamLastFixturesResultPercentageSwitchedVenue(Double awayTeamLastFixturesResultPercentageSwitchedVenue) {
	this.awayTeamLastFixturesResultPercentageSwitchedVenue = awayTeamLastFixturesResultPercentageSwitchedVenue;
    }

    public Double getHomeTeamLastFixturesResultIntervalPercentageSwitchedVenue() {
	return homeTeamLastFixturesResultIntervalPercentageSwitchedVenue;
    }

    public void setHomeTeamLastFixturesResultIntervalPercentageSwitchedVenue(Double homeTeamLastFixturesResultIntervalPercentageSwitchedVenue) {
	this.homeTeamLastFixturesResultIntervalPercentageSwitchedVenue = homeTeamLastFixturesResultIntervalPercentageSwitchedVenue;
    }

    public Double getAwayTeamLastFixturesResultIntervalPercentageSwitchedVenue() {
	return awayTeamLastFixturesResultIntervalPercentageSwitchedVenue;
    }

    public void setAwayTeamLastFixturesResultIntervalPercentageSwitchedVenue(Double awayTeamLastFixturesResultIntervalPercentageSwitchedVenue) {
	this.awayTeamLastFixturesResultIntervalPercentageSwitchedVenue = awayTeamLastFixturesResultIntervalPercentageSwitchedVenue;
    }

    public Integer getHomeTeamLastFixturesGoalsSwitchedVenue() {
	return homeTeamLastFixturesGoalsSwitchedVenue;
    }

    public void setHomeTeamLastFixturesGoalsSwitchedVenue(Integer homeTeamLastFixturesGoalsSwitchedVenue) {
	this.homeTeamLastFixturesGoalsSwitchedVenue = homeTeamLastFixturesGoalsSwitchedVenue;
    }

    public Integer getAwayTeamLastFixturesGoalsSwitchedVenue() {
	return awayTeamLastFixturesGoalsSwitchedVenue;
    }

    public void setAwayTeamLastFixturesGoalsSwitchedVenue(Integer awayTeamLastFixturesGoalsSwitchedVenue) {
	this.awayTeamLastFixturesGoalsSwitchedVenue = awayTeamLastFixturesGoalsSwitchedVenue;
    }

    public Integer getHomeTeamLastFixturesGoalsConcededSwitchedVenue() {
	return homeTeamLastFixturesGoalsConcededSwitchedVenue;
    }

    public void setHomeTeamLastFixturesGoalsConcededSwitchedVenue(Integer homeTeamLastFixturesGoalsConcededSwitchedVenue) {
	this.homeTeamLastFixturesGoalsConcededSwitchedVenue = homeTeamLastFixturesGoalsConcededSwitchedVenue;
    }

    public Integer getAwayTeamLastFixturesGoalsConcededSwitchedVenue() {
	return awayTeamLastFixturesGoalsConcededSwitchedVenue;
    }

    public void setAwayTeamLastFixturesGoalsConcededSwitchedVenue(Integer awayTeamLastFixturesGoalsConcededSwitchedVenue) {
	this.awayTeamLastFixturesGoalsConcededSwitchedVenue = awayTeamLastFixturesGoalsConcededSwitchedVenue;
    }

    public Integer getHomeTeamLastFixturesGoalsDifferenceSwitchedVenue() {
	return homeTeamLastFixturesGoalsDifferenceSwitchedVenue;
    }

    public void setHomeTeamLastFixturesGoalsDifferenceSwitchedVenue(Integer homeTeamLastFixturesGoalsDifferenceSwitchedVenue) {
	this.homeTeamLastFixturesGoalsDifferenceSwitchedVenue = homeTeamLastFixturesGoalsDifferenceSwitchedVenue;
    }

    public Integer getAwayTeamLastFixturesGoalsDifferenceSwitchedVenue() {
	return awayTeamLastFixturesGoalsDifferenceSwitchedVenue;
    }

    public void setAwayTeamLastFixturesGoalsDifferenceSwitchedVenue(Integer awayTeamLastFixturesGoalsDifferenceSwitchedVenue) {
	this.awayTeamLastFixturesGoalsDifferenceSwitchedVenue = awayTeamLastFixturesGoalsDifferenceSwitchedVenue;
    }

    public Double getHomeTeamLastFixturesGoalsAverageSwitchedVenue() {
	return homeTeamLastFixturesGoalsAverageSwitchedVenue;
    }

    public void setHomeTeamLastFixturesGoalsAverageSwitchedVenue(Double homeTeamLastFixturesGoalsAverageSwitchedVenue) {
	this.homeTeamLastFixturesGoalsAverageSwitchedVenue = homeTeamLastFixturesGoalsAverageSwitchedVenue;
    }

    public Double getAwayTeamLastFixturesGoalsAverageSwitchedVenue() {
	return awayTeamLastFixturesGoalsAverageSwitchedVenue;
    }

    public void setAwayTeamLastFixturesGoalsAverageSwitchedVenue(Double awayTeamLastFixturesGoalsAverageSwitchedVenue) {
	this.awayTeamLastFixturesGoalsAverageSwitchedVenue = awayTeamLastFixturesGoalsAverageSwitchedVenue;
    }

    public Double getHomeTeamLastFixturesGoalsConcededAverageSwitchedVenue() {
	return homeTeamLastFixturesGoalsConcededAverageSwitchedVenue;
    }

    public void setHomeTeamLastFixturesGoalsConcededAverageSwitchedVenue(Double homeTeamLastFixturesGoalsConcededAverageSwitchedVenue) {
	this.homeTeamLastFixturesGoalsConcededAverageSwitchedVenue = homeTeamLastFixturesGoalsConcededAverageSwitchedVenue;
    }

    public Double getAwayTeamLastFixturesGoalsConcededAverageSwitchedVenue() {
	return awayTeamLastFixturesGoalsConcededAverageSwitchedVenue;
    }

    public void setAwayTeamLastFixturesGoalsConcededAverageSwitchedVenue(Double awayTeamLastFixturesGoalsConcededAverageSwitchedVenue) {
	this.awayTeamLastFixturesGoalsConcededAverageSwitchedVenue = awayTeamLastFixturesGoalsConcededAverageSwitchedVenue;
    }

    public Integer getHomeTeamLastFixturesPontuationSwitchedVenue() {
	return homeTeamLastFixturesPontuationSwitchedVenue;
    }

    public void setHomeTeamLastFixturesPontuationSwitchedVenue(Integer homeTeamLastFixturesPontuationSwitchedVenue) {
	this.homeTeamLastFixturesPontuationSwitchedVenue = homeTeamLastFixturesPontuationSwitchedVenue;
    }

    public Integer getAwayTeamLastFixturesPontuationSwitchedVenue() {
	return awayTeamLastFixturesPontuationSwitchedVenue;
    }

    public void setAwayTeamLastFixturesPontuationSwitchedVenue(Integer awayTeamLastFixturesPontuationSwitchedVenue) {
	this.awayTeamLastFixturesPontuationSwitchedVenue = awayTeamLastFixturesPontuationSwitchedVenue;
    }

    public Double getHomeTeamLastFixturesPontuationQualitySwitchedVenue() {
	return homeTeamLastFixturesPontuationQualitySwitchedVenue;
    }

    public void setHomeTeamLastFixturesPontuationQualitySwitchedVenue(Double homeTeamLastFixturesPontuationQualitySwitchedVenue) {
	this.homeTeamLastFixturesPontuationQualitySwitchedVenue = homeTeamLastFixturesPontuationQualitySwitchedVenue;
    }

    public Double getAwayTeamLastFixturesPontuationQualitySwitchedVenue() {
	return awayTeamLastFixturesPontuationQualitySwitchedVenue;
    }

    public void setAwayTeamLastFixturesPontuationQualitySwitchedVenue(Double awayTeamLastFixturesPontuationQualitySwitchedVenue) {
	this.awayTeamLastFixturesPontuationQualitySwitchedVenue = awayTeamLastFixturesPontuationQualitySwitchedVenue;
    }

    public Double getHomeTeamLastFixturesPontuationQualityAndTimeSwitchedVenue() {
	return homeTeamLastFixturesPontuationQualityAndTimeSwitchedVenue;
    }

    public void setHomeTeamLastFixturesPontuationQualityAndTimeSwitchedVenue(Double homeTeamLastFixturesPontuationQualityAndTimeSwitchedVenue) {
	this.homeTeamLastFixturesPontuationQualityAndTimeSwitchedVenue = homeTeamLastFixturesPontuationQualityAndTimeSwitchedVenue;
    }

    public Double getAwayTeamLastFixturesPontuationQualityAndTimeSwitchedVenue() {
	return awayTeamLastFixturesPontuationQualityAndTimeSwitchedVenue;
    }

    public void setAwayTeamLastFixturesPontuationQualityAndTimeSwitchedVenue(Double awayTeamLastFixturesPontuationQualityAndTimeSwitchedVenue) {
	this.awayTeamLastFixturesPontuationQualityAndTimeSwitchedVenue = awayTeamLastFixturesPontuationQualityAndTimeSwitchedVenue;
    }

    public Integer getHomeTeamNumberOfFixtures() {
	return homeTeamNumberOfFixtures;
    }

    public void setHomeTeamNumberOfFixtures(Integer homeTeamNumberOfFixtures) {
	this.homeTeamNumberOfFixtures = homeTeamNumberOfFixtures;
    }

    public Integer getAwayTeamNumberOfFixtures() {
	return awayTeamNumberOfFixtures;
    }

    public void setAwayTeamNumberOfFixtures(Integer awayTeamNumberOfFixtures) {
	this.awayTeamNumberOfFixtures = awayTeamNumberOfFixtures;
    }

    public Double getHomeTeamResultPercentage() {
	return homeTeamResultPercentage;
    }

    public void setHomeTeamResultPercentage(Double homeTeamResultPercentage) {
	this.homeTeamResultPercentage = homeTeamResultPercentage;
    }

    public Double getAwayTeamResultPercentage() {
	return awayTeamResultPercentage;
    }

    public void setAwayTeamResultPercentage(Double awayTeamResultPercentage) {
	this.awayTeamResultPercentage = awayTeamResultPercentage;
    }

    public Double getHomeTeamQualityAverage() {
	return homeTeamQualityAverage;
    }

    public void setHomeTeamQualityAverage(Double homeTeamQualityAverage) {
	this.homeTeamQualityAverage = homeTeamQualityAverage;
    }

    public Double getAwayTeamQualityAverage() {
	return awayTeamQualityAverage;
    }

    public void setAwayTeamQualityAverage(Double awayTeamQualityAverage) {
	this.awayTeamQualityAverage = awayTeamQualityAverage;
    }

    public Double getHomeTeamResultDificulty() {
	return homeTeamResultDificulty;
    }

    public void setHomeTeamResultDificulty(Double homeTeamResultDificulty) {
	this.homeTeamResultDificulty = homeTeamResultDificulty;
    }

    public Double getAwayTeamResultDificulty() {
	return awayTeamResultDificulty;
    }

    public void setAwayTeamResultDificulty(Double awayTeamResultDificulty) {
	this.awayTeamResultDificulty = awayTeamResultDificulty;
    }

    public Double getHomeTeamResultIntervalPercentage() {
	return homeTeamResultIntervalPercentage;
    }

    public void setHomeTeamResultIntervalPercentage(Double homeTeamResultIntervalPercentage) {
	this.homeTeamResultIntervalPercentage = homeTeamResultIntervalPercentage;
    }

    public Double getAwayTeamResultIntervalPercentage() {
	return awayTeamResultIntervalPercentage;
    }

    public void setAwayTeamResultIntervalPercentage(Double awayTeamResultIntervalPercentage) {
	this.awayTeamResultIntervalPercentage = awayTeamResultIntervalPercentage;
    }

    public Integer getHomeTeamResultIntervalFixtures() {
	return homeTeamResultIntervalFixtures;
    }

    public void setHomeTeamResultIntervalFixtures(Integer homeTeamResultIntervalFixtures) {
	this.homeTeamResultIntervalFixtures = homeTeamResultIntervalFixtures;
    }

    public Integer getAwayTeamResultIntervalFixtures() {
	return awayTeamResultIntervalFixtures;
    }

    public void setAwayTeamResultIntervalFixtures(Integer awayTeamResultIntervalFixtures) {
	this.awayTeamResultIntervalFixtures = awayTeamResultIntervalFixtures;
    }

    public Integer getHomeTeamGoals() {
	return homeTeamGoals;
    }

    public void setHomeTeamGoals(Integer homeTeamGoals) {
	this.homeTeamGoals = homeTeamGoals;
    }

    public Integer getAwayTeamGoals() {
	return awayTeamGoals;
    }

    public void setAwayTeamGoals(Integer awayTeamGoals) {
	this.awayTeamGoals = awayTeamGoals;
    }

    public Integer getHomeTeamConcededGoals() {
	return homeTeamConcededGoals;
    }

    public void setHomeTeamConcededGoals(Integer homeTeamConcededGoals) {
	this.homeTeamConcededGoals = homeTeamConcededGoals;
    }

    public Integer getAwayTeamConcededGoals() {
	return awayTeamConcededGoals;
    }

    public void setAwayTeamConcededGoals(Integer awayTeamConcededGoals) {
	this.awayTeamConcededGoals = awayTeamConcededGoals;
    }

    public Integer getHomeTeamGoalsDifference() {
	return homeTeamGoalsDifference;
    }

    public void setHomeTeamGoalsDifference(Integer homeTeamGoalsDifference) {
	this.homeTeamGoalsDifference = homeTeamGoalsDifference;
    }

    public Integer getAwayTeamGoalsDifference() {
	return awayTeamGoalsDifference;
    }

    public void setAwayTeamGoalsDifference(Integer awayTeamGoalsDifference) {
	this.awayTeamGoalsDifference = awayTeamGoalsDifference;
    }

    public Double getHomeTeamGoalsAverage() {
	return homeTeamGoalsAverage;
    }

    public void setHomeTeamGoalsAverage(Double homeTeamGoalsAverage) {
	this.homeTeamGoalsAverage = homeTeamGoalsAverage;
    }

    public Double getAwayTeamGoalsAverage() {
	return awayTeamGoalsAverage;
    }

    public void setAwayTeamGoalsAverage(Double awayTeamGoalsAverage) {
	this.awayTeamGoalsAverage = awayTeamGoalsAverage;
    }

    public Double getHomeTeamConcededGoalsAverage() {
	return homeTeamConcededGoalsAverage;
    }

    public void setHomeTeamConcededGoalsAverage(Double homeTeamConcededGoalsAverage) {
	this.homeTeamConcededGoalsAverage = homeTeamConcededGoalsAverage;
    }

    public Double getAwayTeamConcededGoalsAverage() {
	return awayTeamConcededGoalsAverage;
    }

    public void setAwayTeamConcededGoalsAverage(Double awayTeamConcededGoalsAverage) {
	this.awayTeamConcededGoalsAverage = awayTeamConcededGoalsAverage;
    }

    public Integer getHomeTeamNumberOfFixturesVenue() {
	return homeTeamNumberOfFixturesVenue;
    }

    public void setHomeTeamNumberOfFixturesVenue(Integer homeTeamNumberOfFixturesVenue) {
	this.homeTeamNumberOfFixturesVenue = homeTeamNumberOfFixturesVenue;
    }

    public Integer getAwayTeamNumberOfFixturesVenue() {
	return awayTeamNumberOfFixturesVenue;
    }

    public void setAwayTeamNumberOfFixturesVenue(Integer awayTeamNumberOfFixturesVenue) {
	this.awayTeamNumberOfFixturesVenue = awayTeamNumberOfFixturesVenue;
    }

    public Double getHomeTeamResultPercentageVenue() {
	return homeTeamResultPercentageVenue;
    }

    public void setHomeTeamResultPercentageVenue(Double homeTeamResultPercentageVenue) {
	this.homeTeamResultPercentageVenue = homeTeamResultPercentageVenue;
    }

    public Double getAwayTeamResultPercentageVenue() {
	return awayTeamResultPercentageVenue;
    }

    public void setAwayTeamResultPercentageVenue(Double awayTeamResultPercentageVenue) {
	this.awayTeamResultPercentageVenue = awayTeamResultPercentageVenue;
    }

    public Double getHomeTeamQualityAverageVenue() {
	return homeTeamQualityAverageVenue;
    }

    public void setHomeTeamQualityAverageVenue(Double homeTeamQualityAverageVenue) {
	this.homeTeamQualityAverageVenue = homeTeamQualityAverageVenue;
    }

    public Double getAwayTeamQualityAverageVenue() {
	return awayTeamQualityAverageVenue;
    }

    public void setAwayTeamQualityAverageVenue(Double awayTeamQualityAverageVenue) {
	this.awayTeamQualityAverageVenue = awayTeamQualityAverageVenue;
    }

    public Double getHomeTeamResultDificultyVenue() {
	return homeTeamResultDificultyVenue;
    }

    public void setHomeTeamResultDificultyVenue(Double homeTeamResultDificultyVenue) {
	this.homeTeamResultDificultyVenue = homeTeamResultDificultyVenue;
    }

    public Double getAwayTeamResultDificultyVenue() {
	return awayTeamResultDificultyVenue;
    }

    public void setAwayTeamResultDificultyVenue(Double awayTeamResultDificultyVenue) {
	this.awayTeamResultDificultyVenue = awayTeamResultDificultyVenue;
    }

    public Double getHomeTeamResultIntervalPercentageVenue() {
	return homeTeamResultIntervalPercentageVenue;
    }

    public void setHomeTeamResultIntervalPercentageVenue(Double homeTeamResultIntervalPercentageVenue) {
	this.homeTeamResultIntervalPercentageVenue = homeTeamResultIntervalPercentageVenue;
    }

    public Double getAwayTeamResultIntervalPercentageVenue() {
	return awayTeamResultIntervalPercentageVenue;
    }

    public void setAwayTeamResultIntervalPercentageVenue(Double awayTeamResultIntervalPercentageVenue) {
	this.awayTeamResultIntervalPercentageVenue = awayTeamResultIntervalPercentageVenue;
    }

    public Integer getHomeTeamResultIntervalFixturesVenue() {
	return homeTeamResultIntervalFixturesVenue;
    }

    public void setHomeTeamResultIntervalFixturesVenue(Integer homeTeamResultIntervalFixturesVenue) {
	this.homeTeamResultIntervalFixturesVenue = homeTeamResultIntervalFixturesVenue;
    }

    public Integer getAwayTeamResultIntervalFixturesVenue() {
	return awayTeamResultIntervalFixturesVenue;
    }

    public void setAwayTeamResultIntervalFixturesVenue(Integer awayTeamResultIntervalFixturesVenue) {
	this.awayTeamResultIntervalFixturesVenue = awayTeamResultIntervalFixturesVenue;
    }

    public Integer getHomeTeamGoalsVenue() {
	return homeTeamGoalsVenue;
    }

    public void setHomeTeamGoalsVenue(Integer homeTeamGoalsVenue) {
	this.homeTeamGoalsVenue = homeTeamGoalsVenue;
    }

    public Integer getAwayTeamGoalsVenue() {
	return awayTeamGoalsVenue;
    }

    public void setAwayTeamGoalsVenue(Integer awayTeamGoalsVenue) {
	this.awayTeamGoalsVenue = awayTeamGoalsVenue;
    }

    public Integer getHomeTeamConcededGoalsVenue() {
	return homeTeamConcededGoalsVenue;
    }

    public void setHomeTeamConcededGoalsVenue(Integer homeTeamConcededGoalsVenue) {
	this.homeTeamConcededGoalsVenue = homeTeamConcededGoalsVenue;
    }

    public Integer getAwayTeamConcededGoalsVenue() {
	return awayTeamConcededGoalsVenue;
    }

    public void setAwayTeamConcededGoalsVenue(Integer awayTeamConcededGoalsVenue) {
	this.awayTeamConcededGoalsVenue = awayTeamConcededGoalsVenue;
    }

    public Integer getHomeTeamGoalsDifferenceVenue() {
	return homeTeamGoalsDifferenceVenue;
    }

    public void setHomeTeamGoalsDifferenceVenue(Integer homeTeamGoalsDifferenceVenue) {
	this.homeTeamGoalsDifferenceVenue = homeTeamGoalsDifferenceVenue;
    }

    public Integer getAwayTeamGoalsDifferenceVenue() {
	return awayTeamGoalsDifferenceVenue;
    }

    public void setAwayTeamGoalsDifferenceVenue(Integer awayTeamGoalsDifferenceVenue) {
	this.awayTeamGoalsDifferenceVenue = awayTeamGoalsDifferenceVenue;
    }

    public Double getHomeTeamGoalsAverageVenue() {
	return homeTeamGoalsAverageVenue;
    }

    public void setHomeTeamGoalsAverageVenue(Double homeTeamGoalsAverageVenue) {
	this.homeTeamGoalsAverageVenue = homeTeamGoalsAverageVenue;
    }

    public Double getAwayTeamGoalsAverageVenue() {
	return awayTeamGoalsAverageVenue;
    }

    public void setAwayTeamGoalsAverageVenue(Double awayTeamGoalsAverageVenue) {
	this.awayTeamGoalsAverageVenue = awayTeamGoalsAverageVenue;
    }

    public Double getHomeTeamConcededGoalsAverageVenue() {
	return homeTeamConcededGoalsAverageVenue;
    }

    public void setHomeTeamConcededGoalsAverageVenue(Double homeTeamConcededGoalsAverageVenue) {
	this.homeTeamConcededGoalsAverageVenue = homeTeamConcededGoalsAverageVenue;
    }

    public Double getAwayTeamConcededGoalsAverageVenue() {
	return awayTeamConcededGoalsAverageVenue;
    }

    public void setAwayTeamConcededGoalsAverageVenue(Double awayTeamConcededGoalsAverageVenue) {
	this.awayTeamConcededGoalsAverageVenue = awayTeamConcededGoalsAverageVenue;
    }

    public Integer getHomeTeamNumberOfFixturesSwitchedVenue() {
	return homeTeamNumberOfFixturesSwitchedVenue;
    }

    public void setHomeTeamNumberOfFixturesSwitchedVenue(Integer homeTeamNumberOfFixturesSwitchedVenue) {
	this.homeTeamNumberOfFixturesSwitchedVenue = homeTeamNumberOfFixturesSwitchedVenue;
    }

    public Integer getAwayTeamNumberOfFixturesSwitchedVenue() {
	return awayTeamNumberOfFixturesSwitchedVenue;
    }

    public void setAwayTeamNumberOfFixturesSwitchedVenue(Integer awayTeamNumberOfFixturesSwitchedVenue) {
	this.awayTeamNumberOfFixturesSwitchedVenue = awayTeamNumberOfFixturesSwitchedVenue;
    }

    public Double getHomeTeamResultPercentageSwitchedVenue() {
	return homeTeamResultPercentageSwitchedVenue;
    }

    public void setHomeTeamResultPercentageSwitchedVenue(Double homeTeamResultPercentageSwitchedVenue) {
	this.homeTeamResultPercentageSwitchedVenue = homeTeamResultPercentageSwitchedVenue;
    }

    public Double getAwayTeamResultPercentageSwitchedVenue() {
	return awayTeamResultPercentageSwitchedVenue;
    }

    public void setAwayTeamResultPercentageSwitchedVenue(Double awayTeamResultPercentageSwitchedVenue) {
	this.awayTeamResultPercentageSwitchedVenue = awayTeamResultPercentageSwitchedVenue;
    }

    public Double getHomeTeamQualityAverageSwitchedVenue() {
	return homeTeamQualityAverageSwitchedVenue;
    }

    public void setHomeTeamQualityAverageSwitchedVenue(Double homeTeamQualityAverageSwitchedVenue) {
	this.homeTeamQualityAverageSwitchedVenue = homeTeamQualityAverageSwitchedVenue;
    }

    public Double getAwayTeamQualityAverageSwitchedVenue() {
	return awayTeamQualityAverageSwitchedVenue;
    }

    public void setAwayTeamQualityAverageSwitchedVenue(Double awayTeamQualityAverageSwitchedVenue) {
	this.awayTeamQualityAverageSwitchedVenue = awayTeamQualityAverageSwitchedVenue;
    }

    public Double getHomeTeamResultDificultySwitchedVenue() {
	return homeTeamResultDificultySwitchedVenue;
    }

    public void setHomeTeamResultDificultySwitchedVenue(Double homeTeamResultDificultySwitchedVenue) {
	this.homeTeamResultDificultySwitchedVenue = homeTeamResultDificultySwitchedVenue;
    }

    public Double getAwayTeamResultDificultySwitchedVenue() {
	return awayTeamResultDificultySwitchedVenue;
    }

    public void setAwayTeamResultDificultySwitchedVenue(Double awayTeamResultDificultySwitchedVenue) {
	this.awayTeamResultDificultySwitchedVenue = awayTeamResultDificultySwitchedVenue;
    }

    public Double getHomeTeamResultIntervalPercentageSwitchedVenue() {
	return homeTeamResultIntervalPercentageSwitchedVenue;
    }

    public void setHomeTeamResultIntervalPercentageSwitchedVenue(Double homeTeamResultIntervalPercentageSwitchedVenue) {
	this.homeTeamResultIntervalPercentageSwitchedVenue = homeTeamResultIntervalPercentageSwitchedVenue;
    }

    public Double getAwayTeamResultIntervalPercentageSwitchedVenue() {
	return awayTeamResultIntervalPercentageSwitchedVenue;
    }

    public void setAwayTeamResultIntervalPercentageSwitchedVenue(Double awayTeamResultIntervalPercentageSwitchedVenue) {
	this.awayTeamResultIntervalPercentageSwitchedVenue = awayTeamResultIntervalPercentageSwitchedVenue;
    }

    public Integer getHomeTeamResultIntervalFixturesSwitchedVenue() {
	return homeTeamResultIntervalFixturesSwitchedVenue;
    }

    public void setHomeTeamResultIntervalFixturesSwitchedVenue(Integer homeTeamResultIntervalFixturesSwitchedVenue) {
	this.homeTeamResultIntervalFixturesSwitchedVenue = homeTeamResultIntervalFixturesSwitchedVenue;
    }

    public Integer getAwayTeamResultIntervalFixturesSwitchedVenue() {
	return awayTeamResultIntervalFixturesSwitchedVenue;
    }

    public void setAwayTeamResultIntervalFixturesSwitchedVenue(Integer awayTeamResultIntervalFixturesSwitchedVenue) {
	this.awayTeamResultIntervalFixturesSwitchedVenue = awayTeamResultIntervalFixturesSwitchedVenue;
    }

    public Integer getHomeTeamGoalsSwitchedVenue() {
	return homeTeamGoalsSwitchedVenue;
    }

    public void setHomeTeamGoalsSwitchedVenue(Integer homeTeamGoalsSwitchedVenue) {
	this.homeTeamGoalsSwitchedVenue = homeTeamGoalsSwitchedVenue;
    }

    public Integer getAwayTeamGoalsSwitchedVenue() {
	return awayTeamGoalsSwitchedVenue;
    }

    public void setAwayTeamGoalsSwitchedVenue(Integer awayTeamGoalsSwitchedVenue) {
	this.awayTeamGoalsSwitchedVenue = awayTeamGoalsSwitchedVenue;
    }

    public Integer getHomeTeamConcededGoalsSwitchedVenue() {
	return homeTeamConcededGoalsSwitchedVenue;
    }

    public void setHomeTeamConcededGoalsSwitchedVenue(Integer homeTeamConcededGoalsSwitchedVenue) {
	this.homeTeamConcededGoalsSwitchedVenue = homeTeamConcededGoalsSwitchedVenue;
    }

    public Integer getAwayTeamConcededGoalsSwitchedVenue() {
	return awayTeamConcededGoalsSwitchedVenue;
    }

    public void setAwayTeamConcededGoalsSwitchedVenue(Integer awayTeamConcededGoalsSwitchedVenue) {
	this.awayTeamConcededGoalsSwitchedVenue = awayTeamConcededGoalsSwitchedVenue;
    }

    public Integer getHomeTeamGoalsDifferenceSwitchedVenue() {
	return homeTeamGoalsDifferenceSwitchedVenue;
    }

    public void setHomeTeamGoalsDifferenceSwitchedVenue(Integer homeTeamGoalsDifferenceSwitchedVenue) {
	this.homeTeamGoalsDifferenceSwitchedVenue = homeTeamGoalsDifferenceSwitchedVenue;
    }

    public Integer getAwayTeamGoalsDifferenceSwitchedVenue() {
	return awayTeamGoalsDifferenceSwitchedVenue;
    }

    public void setAwayTeamGoalsDifferenceSwitchedVenue(Integer awayTeamGoalsDifferenceSwitchedVenue) {
	this.awayTeamGoalsDifferenceSwitchedVenue = awayTeamGoalsDifferenceSwitchedVenue;
    }

    public Double getHomeTeamGoalsAverageSwitchedVenue() {
	return homeTeamGoalsAverageSwitchedVenue;
    }

    public void setHomeTeamGoalsAverageSwitchedVenue(Double homeTeamGoalsAverageSwitchedVenue) {
	this.homeTeamGoalsAverageSwitchedVenue = homeTeamGoalsAverageSwitchedVenue;
    }

    public Double getAwayTeamGoalsAverageSwitchedVenue() {
	return awayTeamGoalsAverageSwitchedVenue;
    }

    public void setAwayTeamGoalsAverageSwitchedVenue(Double awayTeamGoalsAverageSwitchedVenue) {
	this.awayTeamGoalsAverageSwitchedVenue = awayTeamGoalsAverageSwitchedVenue;
    }

    public Double getHomeTeamConcededGoalsAverageSwitchedVenue() {
	return homeTeamConcededGoalsAverageSwitchedVenue;
    }

    public void setHomeTeamConcededGoalsAverageSwitchedVenue(Double homeTeamConcededGoalsAverageSwitchedVenue) {
	this.homeTeamConcededGoalsAverageSwitchedVenue = homeTeamConcededGoalsAverageSwitchedVenue;
    }

    public Double getAwayTeamConcededGoalsAverageSwitchedVenue() {
	return awayTeamConcededGoalsAverageSwitchedVenue;
    }

    public void setAwayTeamConcededGoalsAverageSwitchedVenue(Double awayTeamConcededGoalsAverageSwitchedVenue) {
	this.awayTeamConcededGoalsAverageSwitchedVenue = awayTeamConcededGoalsAverageSwitchedVenue;
    }

    public Double getH2hRating() {
	return h2hRating;
    }

    public void setH2hRating(Double h2hRating) {
	this.h2hRating = h2hRating;
    }

    public Integer getH2hFixturesNumber() {
	return h2hFixturesNumber;
    }

    public void setH2hFixturesNumber(Integer h2hFixturesNumber) {
	this.h2hFixturesNumber = h2hFixturesNumber;
    }

    public Integer getH2hResultsNumber() {
	return h2hResultsNumber;
    }

    public void setH2hResultsNumber(Integer h2hResultsNumber) {
	this.h2hResultsNumber = h2hResultsNumber;
    }

    public Double getH2hResultsPercentage() {
	return h2hResultsPercentage;
    }

    public void setH2hResultsPercentage(Double h2hResultsPercentage) {
	this.h2hResultsPercentage = h2hResultsPercentage;
    }

    public Double getH2hRatingVenue() {
	return h2hRatingVenue;
    }

    public void setH2hRatingVenue(Double h2hRatingVenue) {
	this.h2hRatingVenue = h2hRatingVenue;
    }

    public Integer getH2hFixturesNumberVenue() {
	return h2hFixturesNumberVenue;
    }

    public void setH2hFixturesNumberVenue(Integer h2hFixturesNumberVenue) {
	this.h2hFixturesNumberVenue = h2hFixturesNumberVenue;
    }

    public Integer getH2hResultsNumberVenue() {
	return h2hResultsNumberVenue;
    }

    public void setH2hResultsNumberVenue(Integer h2hResultsNumberVenue) {
	this.h2hResultsNumberVenue = h2hResultsNumberVenue;
    }

    public Double getH2hResultsPercentageVenue() {
	return h2hResultsPercentageVenue;
    }

    public void setH2hResultsPercentageVenue(Double h2hResultsPercentageVenue) {
	this.h2hResultsPercentageVenue = h2hResultsPercentageVenue;
    }

    public Double getH2hRatingSwitchedVenue() {
	return h2hRatingSwitchedVenue;
    }

    public void setH2hRatingSwitchedVenue(Double h2hRatingSwitchedVenue) {
	this.h2hRatingSwitchedVenue = h2hRatingSwitchedVenue;
    }

    public Integer getH2hFixturesNumberSwitchedVenue() {
	return h2hFixturesNumberSwitchedVenue;
    }

    public void setH2hFixturesNumberSwitchedVenue(Integer h2hFixturesNumberSwitchedVenue) {
	this.h2hFixturesNumberSwitchedVenue = h2hFixturesNumberSwitchedVenue;
    }

    public Integer getH2hResultsNumberSwitchedVenue() {
	return h2hResultsNumberSwitchedVenue;
    }

    public void setH2hResultsNumberSwitchedVenue(Integer h2hResultsNumberSwitchedVenue) {
	this.h2hResultsNumberSwitchedVenue = h2hResultsNumberSwitchedVenue;
    }

    public Double getH2hResultsPercentageSwitchedVenue() {
	return h2hResultsPercentageSwitchedVenue;
    }

    public void setH2hResultsPercentageSwitchedVenue(Double h2hResultsPercentageSwitchedVenue) {
	this.h2hResultsPercentageSwitchedVenue = h2hResultsPercentageSwitchedVenue;
    }

    public String getDatasetJson() {
	String json = null;
	try {
	    json = new JsonObjectMapper().writeValueAsString(this);
	} catch (JsonProcessingException e) {
	    e.printStackTrace();
	}

	return json;
    }
}

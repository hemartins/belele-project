package pt.belele.project.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.joda.time.DateTime;

@Entity
@Table(name = "standing", indexes = {
    @Index(name = "standing_find_index",  columnList="standing_team_id,standing_season_id,standing_date", unique = true)
})
@NamedQueries({})
@SequenceGenerator(name = "standing_sequence", sequenceName = "standing_sequence_id_seq")
public class Standing implements Serializable {

    private static final long serialVersionUID = -1647420510440393361L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "standing_sequence")
    @Column(name = "standing_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "standing_played_games", nullable = false)
    private Integer playedGames;

    @Column(name = "standing_home_played_games", nullable = false)
    private Integer homePlayedGames;

    @Column(name = "standing_away_played_games", nullable = false)
    private Integer awayPlayedGames;

    @Column(name = "standing_points", nullable = false)
    private Integer points;

    @Column(name = "standing_home_points", nullable = false)
    private Integer homePoints;

    @Column(name = "standing_away_points", nullable = false)
    private Integer awayPoints;

    @Column(name = "standing_goals", nullable = false)
    private Integer goals;

    @Column(name = "standing_against_goals", nullable = false)
    private Integer goalsAgainst;

    @Column(name = "standing_home_goals", nullable = false)
    private Integer homeGoals;

    @Column(name = "standing_home_against_goals", nullable = false)
    private Integer homeGoalsAgainst;

    @Column(name = "standing_away_goals", nullable = false)
    private Integer awayGoals;

    @Column(name = "standing_away_against_goals", nullable = false)
    private Integer awayGoalsAgainst;

    @Column(name = "standing_date", nullable = false)
    private DateTime date;

    @JoinColumn(name = "standing_team_id", referencedColumnName = "team_id", nullable = false, updatable = false)
    @ManyToOne(optional = false)
    private Team team;

    @JoinColumn(name = "standing_season_id", referencedColumnName = "season_id", nullable = false, updatable = false)
    @ManyToOne(optional = false)
    private Season season;

    public Standing() {
    }

    public Standing(Season season, Team team, DateTime date) {
	this.season = season;
	this.team = team;
	this.date = date;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public int getPlayedGames() {
	return playedGames;
    }

    public void setPlayedGames(int playedGames) {
	this.playedGames = playedGames;
    }

    public int getHomePlayedGames() {
	return homePlayedGames;
    }

    public void setHomePlayedGames(int homePlayedGames) {
	this.homePlayedGames = homePlayedGames;
    }

    public int getAwayPlayedGames() {
	return awayPlayedGames;
    }

    public void setAwayPlayedGames(int awayPlayedGames) {
	this.awayPlayedGames = awayPlayedGames;
    }

    public int getPoints() {
	return points;
    }

    public void setPoints(int points) {
	this.points = points;
    }

    public int getHomePoints() {
	return homePoints;
    }

    public void setHomePoints(int homePoints) {
	this.homePoints = homePoints;
    }

    public int getAwayPoints() {
	return awayPoints;
    }

    public void setAwayPoints(int awayPoints) {
	this.awayPoints = awayPoints;
    }

    public int getGoals() {
	return goals;
    }

    public void setGoals(int goals) {
	this.goals = goals;
    }

    public int getGoalsAgainst() {
	return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
	this.goalsAgainst = goalsAgainst;
    }

    public int getHomeGoals() {
	return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
	this.homeGoals = homeGoals;
    }

    public int getHomeGoalsAgainst() {
	return homeGoalsAgainst;
    }

    public void setHomeGoalsAgainst(int homeGoalsAgainst) {
	this.homeGoalsAgainst = homeGoalsAgainst;
    }

    public int getAwayGoals() {
	return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
	this.awayGoals = awayGoals;
    }

    public int getAwayGoalsAgainst() {
	return awayGoalsAgainst;
    }

    public void setAwayGoalsAgainst(int awayGoalsAgainst) {
	this.awayGoalsAgainst = awayGoalsAgainst;
    }

    public Team getTeam() {
	return team;
    }

    public void setTeam(Team team) {
	this.team = team;
    }

    public Season getSeason() {
	return season;
    }

    public void setSeason(Season season) {
	this.season = season;
    }

    public DateTime getDate() {
	return date;
    }

    public void setDate(DateTime date) {
	this.date = date;
    }

}

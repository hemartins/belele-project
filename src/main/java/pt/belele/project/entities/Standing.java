package pt.belele.project.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Standing implements Serializable {

	private static final long serialVersionUID = -1647420510440393361L;

	@Id
	@GeneratedValue
	private long id;

	private int playedGames;
	
	private int homePlayedGames;
	
	private int awayPlayedGames;

	private int points;
	
	private int homePoints;
	
	private int awayPoints;

	private int goals;

	private int goalsAgainst;
	
	private int homeGoals;

	private int homeGoalsAgainst;
	
	private int awayGoals;

	private int awayGoalsAgainst;
	
	private Date date;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Team team;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Season season;

	public Standing() {
	}
	
	public Standing(Season season, Team team, Date date) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

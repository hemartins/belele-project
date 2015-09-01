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

	private int points;

	private int goals;

	private int goalsAgainst;

	private int goalsDifference;
	
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
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

	public int getGoalsDifference() {
		return goalsDifference;
	}

	public void setGoalsDifference(int goalsDifference) {
		this.goalsDifference = goalsDifference;
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

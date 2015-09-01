package pt.belele.project.controllers.util;

import java.util.List;

import org.joda.time.DateTime;

import pt.belele.project.entities.Result.ResultType;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;

public class ResultCycle {
	private Season season;
	private ResultType type;
	private List<Team> teams;
	private Integer cycle;
	private DateTime date;

	public ResultCycle(Season season, ResultType type, List<Team> teams,
			Integer cycle, DateTime date) {
		this.season = season;
		this.type = type;
		this.teams = teams;
		this.cycle = cycle;
		this.date = date;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public ResultType getType() {
		return type;
	}

	public void setType(ResultType type) {
		this.type = type;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Integer getCycle() {
		return cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

}

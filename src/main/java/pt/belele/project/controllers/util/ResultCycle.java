package pt.belele.project.controllers.util;

import java.util.List;

import pt.belele.project.entities.Result.ResultType;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;

public class ResultCycle {
	private Season season;
	private ResultType type;
	private List<Team> teams;
	private Integer cycle;
	private Integer matchday;

	public ResultCycle(Season season, ResultType type, List<Team> teams,
			Integer cycle, Integer matchday) {
		this.season = season;
		this.type = type;
		this.teams = teams;
		this.cycle = cycle;
		this.matchday = matchday;
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

	public Integer getMatchday() {
		return matchday;
	}

	public void setMatchday(Integer matchday) {
		this.matchday = matchday;
	}

}

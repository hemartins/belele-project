package pt.belele.project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LeagueTable implements Serializable {

	private static final long serialVersionUID = 3360821180624100808L;

	@Id
	@GeneratedValue
	private long id;

	private int matchday;

	@OneToMany(mappedBy = "season")
	private List<Standing> standings;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Season season;

	public LeagueTable() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getMatchday() {
		return matchday;
	}

	public void setMatchday(int matchday) {
		this.matchday = matchday;
	}

	public List<Standing> getStandings() {
		return standings;
	}

	public void setStandings(List<Standing> standings) {
		this.standings = standings;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
}

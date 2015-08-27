package pt.belele.project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Season implements Serializable {

	private static final long serialVersionUID = -8607685167439707791L;

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private int year;

	@OneToMany(mappedBy = "season")
	private List<Fixture> fixtures;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "id")
	private List<Team> teams;

	public Season() {
	}

	public Season(String name, Integer year) {
		this.name = name;
		this.year = year;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Fixture> getFixtures() {
		return fixtures;
	}

	public void setFixtures(List<Fixture> fixtures) {
		this.fixtures = fixtures;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}

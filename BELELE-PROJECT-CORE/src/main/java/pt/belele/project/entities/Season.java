package pt.belele.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "season", indexes = {
    @Index(name = "season_name_year_index", columnList="season_name,season_year")
})
@NamedQueries({})
@SequenceGenerator(name = "season_sequence", sequenceName = "season_sequence_id_seq")
public class Season implements Serializable {

    private static final long serialVersionUID = -8607685167439707791L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "season_sequence")
    @Column(name = "season_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "season_name", nullable = false)
    private String name;

    @Column(name = "season_year", nullable = false)
    private Integer year;

    @OneToMany(mappedBy = "season")
    private List<Fixture> fixtures;

    @ManyToMany
    @JoinTable(name = "season_teams", joinColumns = @JoinColumn(name = "season_id", unique = false), inverseJoinColumns = @JoinColumn(name = "team_id", unique = false))
    private List<Team> teams;

    public Season() {
    }

    public Season(String name, Integer year) {
	this.name = name;
	this.year = year;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
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

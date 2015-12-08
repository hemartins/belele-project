package pt.belele.project.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "team", indexes = {
    @Index(name = "team_name_index",  columnList="team_name", unique = true)
})
@NamedQueries({})
@SequenceGenerator(name = "team_sequence", sequenceName = "team_sequence_id_seq")
public class Team implements Serializable {

    private static final long serialVersionUID = -117417908450338924L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_sequence")
    @Column(name = "team_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "team_name", nullable = false, unique = true)
    private String name;

    @Column(name = "team_is_historic", columnDefinition = "boolean default false")
    private Boolean isHistoric;

    public Team() {
    }

    public Team(String name) {
	this.name = name;
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

    public Boolean getIsHistoric() {
	return isHistoric;
    }

    public void setIsHistoric(Boolean isHistoric) {
	this.isHistoric = isHistoric;
    }

    @Override
    public String toString() {
	return "Team [name=" + name + "]";
    }
}

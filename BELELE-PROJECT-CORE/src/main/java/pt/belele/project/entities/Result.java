package pt.belele.project.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "fixture_result")
@NamedQueries({})
@SequenceGenerator(name = "fixture_result_sequence", sequenceName = "fixture_result_sequence_id_seq")
public class Result implements Serializable {

    public static enum ResultType {
	WIN(0), DRAW(1), LOSE(2);

	private final int value;

	private ResultType(int value) {
	    this.value = value;
	}

	public int getValue() {
	    return value;
	}

	public static ResultType parse(final int id) {
	    ResultType type = null; // Default
	    for (final ResultType item : ResultType.values()) {
		if (item.getValue() == id) {
		    type = item;
		    break;
		}
	    }
	    return type;
	}
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fixture_result_sequence")
    @Column(name = "fixture_result_id", nullable = false, updatable = false)
    private Long id;

    private Integer fullTimeHomeTeamGoals;

    private Integer fullTimeAwayTeamGoals;

    private Integer halfTimeHomeTeamGoals;

    private Integer halfTimeAwayTeamGoals;

    @OneToOne(mappedBy = "result")
    private Fixture fixture;

    public Result() {
    }

    public Result(Integer fullTimeHomeTeamGoals, Integer fullTimeAwayTeamGoals,
	    Integer halfTimeHomeTeamGoals, Integer halfTimeAwayTeamGoals) {
	this.fullTimeHomeTeamGoals = fullTimeHomeTeamGoals;
	this.fullTimeAwayTeamGoals = fullTimeAwayTeamGoals;
	this.halfTimeHomeTeamGoals = halfTimeHomeTeamGoals;
	this.halfTimeAwayTeamGoals = halfTimeAwayTeamGoals;
    }

    public Fixture getFixture() {
	return fixture;
    }

    public void setFixture(Fixture fixture) {
	this.fixture = fixture;
    }

    public Integer getFullTimeHomeTeamGoals() {
	return fullTimeHomeTeamGoals;
    }

    public void setFullTimeHomeTeamGoals(Integer fullTimeHomeTeamGoals) {
	this.fullTimeHomeTeamGoals = fullTimeHomeTeamGoals;
    }

    public Integer getFullTimeAwayTeamGoals() {
	return fullTimeAwayTeamGoals;
    }

    public void setFullTimeAwayTeamGoals(Integer fullTimeAwayTeamGoals) {
	this.fullTimeAwayTeamGoals = fullTimeAwayTeamGoals;
    }

    public Integer getHalfTimeHomeTeamGoals() {
	return halfTimeHomeTeamGoals;
    }

    public void setHalfTimeHomeTeamGoals(Integer halfTimeHomeTeamGoals) {
	this.halfTimeHomeTeamGoals = halfTimeHomeTeamGoals;
    }

    public Integer getHalfTimeAwayTeamGoals() {
	return halfTimeAwayTeamGoals;
    }

    public void setHalfTimeAwayTeamGoals(Integer halfTimeAwayTeamGoals) {
	this.halfTimeAwayTeamGoals = halfTimeAwayTeamGoals;
    }

    public ResultType getResultType() {
	if (fullTimeHomeTeamGoals > fullTimeAwayTeamGoals) {
	    return ResultType.WIN;
	} else if (fullTimeAwayTeamGoals > fullTimeHomeTeamGoals) {
	    return ResultType.LOSE;
	} else {
	    return ResultType.DRAW;
	}
    }
}

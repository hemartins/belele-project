package pt.belele.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Result implements Serializable {

	private static final long serialVersionUID = -6193187044927697467L;
	
	public static enum ResultType {
		WIN(0), DRAW(1), LOSE(2);

		private int value;

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
	@GeneratedValue
	private long id;

	private int fullTimeHomeTeamGoals;

	private int fullTimeAwayTeamGoals;

	private int halfTimeHomeTeamGoals;

	private int halfTimeAwayTeamGoals;

	@OneToOne(optional = false)
	@JoinColumn(name = "id", nullable = false)
	private Fixture fixture;

	public Result() {
	}

	public Result(int fullTimeHomeTeamGoals, int fullTimeAwayTeamGoals,
			int halfTimeHomeTeamGoals, int halfTimeAwayTeamGoals,
			Fixture fixture) {
		this.fullTimeHomeTeamGoals = fullTimeHomeTeamGoals;
		this.fullTimeAwayTeamGoals = fullTimeAwayTeamGoals;
		this.halfTimeHomeTeamGoals = halfTimeHomeTeamGoals;
		this.halfTimeAwayTeamGoals = halfTimeAwayTeamGoals;
		this.fixture = fixture;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFullTimeHomeTeamGoals() {
		return fullTimeHomeTeamGoals;
	}

	public void setFullTimeHomeTeamGoals(int fullTimeHomeTeamGoals) {
		this.fullTimeHomeTeamGoals = fullTimeHomeTeamGoals;
	}

	public int getFullTimeAwayTeamGoals() {
		return fullTimeAwayTeamGoals;
	}

	public void setFullTimeAwayTeamGoals(int fullTimeAwayTeamGoals) {
		this.fullTimeAwayTeamGoals = fullTimeAwayTeamGoals;
	}

	public int getHalfTimeHomeTeamGoals() {
		return halfTimeHomeTeamGoals;
	}

	public void setHalfTimeHomeTeamGoals(int halfTimeHomeTeamGoals) {
		this.halfTimeHomeTeamGoals = halfTimeHomeTeamGoals;
	}

	public int getHalfTimeAwayTeamGoals() {
		return halfTimeAwayTeamGoals;
	}

	public void setHalfTimeAwayTeamGoals(int halfTimeAwayTeamGoals) {
		this.halfTimeAwayTeamGoals = halfTimeAwayTeamGoals;
	}

	public Fixture getFixture() {
		return fixture;
	}

	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}
}

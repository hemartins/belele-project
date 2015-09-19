package pt.belele.project.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Result {
	
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
	
	private Integer fullTimeHomeTeamGoals;

	private Integer fullTimeAwayTeamGoals;

	private Integer halfTimeHomeTeamGoals;

	private Integer halfTimeAwayTeamGoals;

	public Result() {
	}

	public Result(Integer fullTimeHomeTeamGoals, Integer fullTimeAwayTeamGoals,
			Integer halfTimeHomeTeamGoals, Integer halfTimeAwayTeamGoals) {
		this.fullTimeHomeTeamGoals = fullTimeHomeTeamGoals;
		this.fullTimeAwayTeamGoals = fullTimeAwayTeamGoals;
		this.halfTimeHomeTeamGoals = halfTimeHomeTeamGoals;
		this.halfTimeAwayTeamGoals = halfTimeAwayTeamGoals;
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
}

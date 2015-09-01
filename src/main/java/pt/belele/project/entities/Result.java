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
	
	private int fullTimeHomeTeamGoals;

	private int fullTimeAwayTeamGoals;

	private int halfTimeHomeTeamGoals;

	private int halfTimeAwayTeamGoals;

	public Result() {
	}

	public Result(int fullTimeHomeTeamGoals, int fullTimeAwayTeamGoals,
			int halfTimeHomeTeamGoals, int halfTimeAwayTeamGoals) {
		this.fullTimeHomeTeamGoals = fullTimeHomeTeamGoals;
		this.fullTimeAwayTeamGoals = fullTimeAwayTeamGoals;
		this.halfTimeHomeTeamGoals = halfTimeHomeTeamGoals;
		this.halfTimeAwayTeamGoals = halfTimeAwayTeamGoals;
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
}

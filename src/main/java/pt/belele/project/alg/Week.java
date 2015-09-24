package pt.belele.project.alg;

import java.util.ArrayList;

public class Week {
	
	int weekNumber;
	ArrayList<Bet> betsList = new ArrayList<Bet>();
	
	public int getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}
	public ArrayList<Bet> getBetsList() {
		return betsList;
	}
	public void setBetsList(ArrayList<Bet> betsList) {
		this.betsList = betsList;
	}

}

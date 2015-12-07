package pt.belele.project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Week implements Serializable {

	private static final long serialVersionUID = -7224285180625792982L;

	@Id
	@GeneratedValue
	private long id;

	private int weekNumber;

	private double investment;
	
	private double earnings;

	@OneToMany(mappedBy = "week")
	private List<Bet> bets;

	public Week() {

	}

	public Week(long id, int weekNumber, double earnings, double investment, List<Bet> betList) {
		this.id = id;
		this.weekNumber = weekNumber;
		this.earnings = earnings;
		this.investment = investment;
		this.bets = betList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	public double getEarnings() {
		return earnings;
	}

	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}

	public double getInvestment() {
		return investment;
	}

	public void setInvestment(double investment) {
		this.investment = investment;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> betList) {
		this.bets = betList;
	}
}

package pt.belele.project.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class MultipleBet {
	
	public static enum BetType {
		 DOUBLE(0), TRIPLE(1), MULTIPLE(2);

		private int betType;

		private BetType(int bettype) {
			this.betType = bettype;
		}

		public int getBettype() {
			return betType;
		}
	}
	
	public static enum BetResult {
		OPEN(0), WON(1), LOST(2), VOID(3);

		private int betResult;

		private BetResult(int betresult) {
			this.betResult = betresult;
		}

		public int getBetResult() {
			return betResult;
		}
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	private BetResult betResult;
	
	private double investedValue;

	private double odd;
	
	private BetType betType;
	
	@ManyToMany(targetEntity = Bet.class, mappedBy = "bets")
	private List<Bet> betsList;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Week week;

	public BetResult getBetResult() {
		return betResult;
	}

	public void setBetResult(BetResult betResult) {
		this.betResult = betResult;
	}

	public double getInvestedValue() {
		return investedValue;
	}

	public void setInvestedValue(double investedValue) {
		this.investedValue = investedValue;
	}

	public double getOdd() {
		return odd;
	}

	public void setOdd(double odd) {
		this.odd = odd;
	}

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public List<Bet> getBetsList() {
		return betsList;
	}

	public void setBetsList(List<Bet> betsList) {
		this.betsList = betsList;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}
	
}
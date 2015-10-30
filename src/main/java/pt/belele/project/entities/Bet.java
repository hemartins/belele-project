package pt.belele.project.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bet implements Serializable {

	private static final long serialVersionUID = 5229534133139860265L;

	// public static enum BetType {
	// SIMPLE(0), DOUBLE(1), TRIPLE(2), MULTIPLE(3);
	//
	// private int betType;
	//
	// private BetType(int bettype) {
	// this.betType = bettype;
	// }
	//
	// public int getBettype() {
	// return betType;
	// }
	// }

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

	public static enum MatchOddBet {
		WIN(0), DRAW(1), LOSE(2), DONOTWIN(3), DONOTDRAW(4), DONOTLOSE(5);

		private int matchOddsBet;

		private MatchOddBet(int matchOddsBet) {
			this.matchOddsBet = matchOddsBet;
		}

		public int getMatchOddsBet() {
			return matchOddsBet;
		}
	}

	@Id
	@GeneratedValue
	private long id;

	// private BetType betType;

	private BetResult betResult;

	private MatchOddBet matchOddBet;

	private double investedValue;

	private double odd;

	// @ManyToMany(targetEntity = Fixture.class, mappedBy = "bets")
	// private List<Fixture> fixtures;

	@Embedded
	private Fixture fixture;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Week week;

	public Bet() {

	}

	// public Bet(BetType betType, BetResult betResult, double investedValue,
	// double odd, List<Fixture> fixtures, Week week) {
	// this.betType = betType;
	// this.betResult = betResult;
	// this.investedValue = investedValue;
	// this.odd = odd;
	// this.fixtures = fixtures;
	// this.week = week;
	// }

	public Bet(BetResult betResult, MatchOddBet matchOddBet, double investedValue, double odd, Fixture fixture,
			Week week) {
		super();
		this.betResult = betResult;
		this.matchOddBet = matchOddBet;
		this.investedValue = investedValue;
		this.odd = odd;
		this.fixture = fixture;
		this.week = week;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public BetType getBetType() {
//		return betType;
//	}
//
//	public void setBetType(BetType betType) {
//		this.betType = betType;
//	}

	public BetResult getBetResult() {
		return betResult;
	}

	public void setBetResult(BetResult betResult) {
		this.betResult = betResult;
	}

	public MatchOddBet getMatchOddBet() {
		return matchOddBet;
	}

	public void setMatchOddBet(MatchOddBet matchOddBet) {
		this.matchOddBet = matchOddBet;
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

//	public List<Fixture> getFixtures() {
//		return fixtures;
//	}
//
//	public void setFixtures(List<Fixture> fixtures) {
//		this.fixtures = fixtures;
//	}

	public Fixture getFixture() {
		return fixture;
	}

	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

//	@Override
//	public String toString() {
//		return "Bet [betType=" + betType + ", betResult=" + betResult + ", matchOddBet=" + matchOddBet
//				+ ", investedValue=" + investedValue + ", odd=" + odd + "]";
//	}

}
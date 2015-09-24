package pt.belele.project.alg;

import pt.belele.project.entities.Result.ResultType;

public class Bet {
	
	double investedValue;
	double odd;
	
	public static enum BetType {
		SIMPLE(0), MULTIPLE(1);

		private int bettype;

		private BetType(int bettype) {
			this.bettype = bettype;
		}

		public int getBettype() {
			return bettype;
		}
	}
	
	public static enum BetResult {
		OPEN(0), WON(1), LOST(2), VOID(3);

		private int betresult;

		private BetResult(int betresult) {
			this.betresult = betresult;
		}

		public int getBetResult() {
			return betresult;
		}
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

	public Bet(){
		
	}

}

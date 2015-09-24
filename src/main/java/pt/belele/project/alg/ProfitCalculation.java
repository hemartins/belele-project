package pt.belele.project.alg;

import java.util.ArrayList;

public class ProfitCalculation {

	ArrayList<Week> weeksList = new ArrayList<Week>();
	double[] profit;
	double[] percentualProfit;
	double[] totalInvestment;
	double[] totalWinnings;
	double[] effectiveness;
	double balance;
	double[] totalBets;
	double[] winningBets;
	
	public ArrayList<Week> getWeeksList() {
		return weeksList;
	}

	public void setWeeksList(ArrayList<Week> weeksList) {
		this.weeksList = weeksList;
	}

	public double[] getProfit() {
		return profit;
	}

	public void setProfit(double[] profit) {
		this.profit = profit;
	}

	public double[] getPercentualProfit() {
		return percentualProfit;
	}

	public void setPercentualProfit(double[] percentualProfit) {
		this.percentualProfit = percentualProfit;
	}

	public double[] getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(double[] totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	public double[] getTotalWinnings() {
		return totalWinnings;
	}

	public void setTotalWinnings(double[] totalWinnings) {
		this.totalWinnings = totalWinnings;
	}

	public double[] getEffectiveness() {
		return effectiveness;
	}

	public void setEffectiveness(double[] effectiveness) {
		this.effectiveness = effectiveness;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double[] getTotalBets() {
		return totalBets;
	}

	public void setTotalBets(double[] totalBets) {
		this.totalBets = totalBets;
	}

	public double[] getWinningBets() {
		return winningBets;
	}

	public void setWinningBets(double[] winningBets) {
		this.winningBets = winningBets;
	}

	/* PONTO 1 */
	public void displayTotalInvestmentActivity() {
		/*
		 * fazer o display das seguintes variaveis: winningBets investment
		 * effectivness totalWinnings profit percentualProfit balance
		 */
	}

	/* PONTO 2 */
	public void displayInvestmentActivityPerWeek() {
		/*
		 * fazer o display das seguintes variaveis:
		 * 
		 */
	}
	
	/* PONTO 3 */
	public void calculateWinningAndTotalBets(){
		
		for(Week week : weeksList){
			winningBets[week.getWeekNumber()] = 0;
			totalBets[week.getWeekNumber()] = 0;
			for (Bet bet : week.getBetsList()){
				if (/*bet.getBetResult.equals(WON)*/){
					winningBets[week.getWeekNumber()]++;
				}
				totalBets[week.getWeekNumber()] += 1;
			}	
		}
	}

	/* PONTO 4, 6, 13 e 14 */
	public void calculateTotalWinningsAndTotalInvestment(){
		
		for(Week week : weeksList){
			
			totalWinnings[week.getWeekNumber()] = 0;
			totalInvestment[week.getWeekNumber()] = 0;
			
			for (Bet bet : week.getBetsList()){
				if (/*bet.getBetResult.equals(WON)*/){
					totalWinnings[week.getWeekNumber()] += bet.getInvestedValue() * (bet.getOdd() + 1);
				}
				totalInvestment[week.getWeekNumber()] += bet.getInvestedValue() * (bet.getOdd() + 1);
			}	
		}
	}

	/* PONTO 5 e 16*/
	public void calculateEffectiveness(){
		for(Week week : weeksList){
			effectiveness[week.getWeekNumber()] = winningBets[week.getWeekNumber()] / totalBets[week.getWeekNumber()];
		}
	}
	
	/* PONTO 7, 8 e 15*/
	public void calculateProfitandPercentualProfit(){
		for(Week week : weeksList){
			profit[week.getWeekNumber()] = totalWinnings[week.getWeekNumber()] - totalInvestment[week.getWeekNumber()];
			//percentualProfit[week.getWeekNumber()] = profit[week.getWeekNumber()] * 10 / 100;
		}
	}
	
	/* PONTO 9 */
	public void calculateBalance(){
		
		int weeksWithBets = 0;
		int weeksWithProfits = 0;
		
		for(Week week : weeksList){
			
			int weekBalance = 0;
			
			if (week.getBetsList().size() != 0){
				weeksWithBets += 1;
			}
			for (Bet bet : week.getBetsList()){
				weekBalance += bet.getInvestedValue() * (bet.getOdd() + 1);
			}
			if (weekBalance > 0){
				weeksWithProfits += 1;
			}	
		}
		
		balance = weeksWithProfits / weeksWithBets;
	}
}

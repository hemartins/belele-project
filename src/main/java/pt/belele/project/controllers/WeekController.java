package pt.belele.project.controllers;

import javax.persistence.EntityManager;

import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Bet.BetResult;
import pt.belele.project.entities.Week;
import pt.belele.project.persistence.BetDAO;
import pt.belele.project.persistence.WeekDAO;

public class WeekController {
	
	private WeekDAO weekDAO;
	private BetDAO betDAO;

	public WeekController(EntityManager em) {
		weekDAO = new WeekDAO(em);
		betDAO = new BetDAO(em);
	}

	public int calculateWinningBets(Week week) {
		return betDAO.findBetsByWeekAndBetResult(week.getId(), BetResult.WON).size();
	}

	public double calculateEffectiveness(Week week) {
		return betDAO.findBetsByWeekAndBetResult(week.getId(), BetResult.WON).size() / week.getInvestment();
	}

	public double calculateBalance() {
		return weekDAO.findProfitWeeks().size() / weekDAO.findAll().size();
	}
	
	//VAI SER USADA NA ADIÇÂO DE NOVAS WEEKS
	private double calculateTotalEarnings(Week week) {
		double totalEarnings = 0;
		for (Bet bet : betDAO.findBetsByWeekAndBetResult(week.getId(), BetResult.WON)) {
			totalEarnings += bet.getInvestedValue() * bet.getOdd();
		}
		return totalEarnings;
	}
}

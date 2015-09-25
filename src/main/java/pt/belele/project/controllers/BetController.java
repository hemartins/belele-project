package pt.belele.project.controllers;

import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Result.ResultType;

public class BetController {
	public Double calculateOdd(Bet bet, ResultType result) {
		switch (bet.getBetType()) {
		case SIMPLE:
			switch (result) {
			case WIN:
				return bet.getFixtures().get(0).getBackOdd().getHomeWin();
			case DRAW:
				return bet.getFixtures().get(0).getBackOdd().getDraw();
			case LOSE:
				return bet.getFixtures().get(0).getBackOdd().getAwayWin();
			}
		default:
			return null;
		}
	}
}

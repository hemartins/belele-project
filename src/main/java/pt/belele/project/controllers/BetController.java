package pt.belele.project.controllers;

import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Bet.BetType;
import pt.belele.project.entities.Bet.MatchOddBet;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.Week;

public class BetController {
	public Double calculateOdd(Bet bet, MatchOddBet matchOddsBet) {
		switch (bet.getBetType()) {
		case SIMPLE:
			switch (matchOddsBet) {
			case WIN:
				return bet.getFixtures().get(0).getOdd().getBackHomeWin();
			case DRAW:
				return bet.getFixtures().get(0).getOdd().getBackDraw();
			case LOSE:
				return bet.getFixtures().get(0).getOdd().getBackAwayWin();
			case DONOTWIN:
				return bet.getFixtures().get(0).getOdd().getLayHomeWin();
			case DONOTDRAW:
				return bet.getFixtures().get(0).getOdd().getLayDraw();
			case DONOTLOSE:
				return bet.getFixtures().get(0).getOdd().getLayAwayWin();
			}
		default:
			return null;
		}
	}
}

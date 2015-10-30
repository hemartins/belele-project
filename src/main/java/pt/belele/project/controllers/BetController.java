package pt.belele.project.controllers;

import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Bet.MatchOddBet;

public class BetController {
	public Double calculateOdd(Bet bet, MatchOddBet matchOddsBet) {
		switch (matchOddsBet) {
		case WIN:
			return bet.getFixture().getOdd().getBackHomeWin();
		case DRAW:
			return bet.getFixture().getOdd().getBackDraw();
		case LOSE:
			return bet.getFixture().getOdd().getBackAwayWin();
		case DONOTWIN:
			return bet.getFixture().getOdd().getLayHomeWin();
		case DONOTDRAW:
			return bet.getFixture().getOdd().getLayDraw();
		case DONOTLOSE:
			return bet.getFixture().getOdd().getLayAwayWin();
		}
		return null;
	}
}

package pt.belele.project.controllers;

import pt.belele.project.entities.Odd;

public class OddController {
	
	public OddController(){
		
	}
	
	public void calculateLayOddsAsBackOdds(Odd odd){
		Double layHomeWin = odd.getBackHomeWin() / (odd.getBackHomeWin() - 1);
		odd.setLayHomeWin(layHomeWin);
		Double layDraw = odd.getBackDraw() / (odd.getBackDraw() - 1);
		odd.setLayDraw(layDraw);
		Double layAwayWin = odd.getBackAwayWin() / (odd.getBackAwayWin() - 1);
		odd.setLayAwayWin(layAwayWin);
	}

}

package pt.belele.project.controllers;

import pt.belele.project.entities.Odd;

public class OddController {
	
	public OddController(){
		
	}
	
	public void calculateLayOddsAsBackOdds(Odd odd){
		Double layHomeWin = (odd.getBackHomeWin()+0.05) / ((odd.getBackHomeWin()+0.05) - 1);
		odd.setLayHomeWin(layHomeWin);
		Double layDraw = (odd.getBackDraw()+0.05) / ((odd.getBackDraw()+0.05) - 1);
		odd.setLayDraw(layDraw);
		Double layAwayWin = (odd.getBackAwayWin()+0.05) / ((odd.getBackAwayWin()+0.05) - 1);
		odd.setLayAwayWin(layAwayWin);
	}
}

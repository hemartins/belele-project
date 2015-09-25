package pt.belele.project.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Odd {

	private Double homeWin;
	private Double draw;
	private Double awayWin;
	
	public Odd() {

	}

	public Double getHomeWin() {
		return homeWin;
	}

	public void setHomeWin(Double homeWin) {
		this.homeWin = homeWin;
	}

	public Double getDraw() {
		return draw;
	}

	public void setDraw(Double draw) {
		this.draw = draw;
	}

	public Double getAwayWin() {
		return awayWin;
	}

	public void setAwayWin(Double awayWin) {
		this.awayWin = awayWin;
	}
}

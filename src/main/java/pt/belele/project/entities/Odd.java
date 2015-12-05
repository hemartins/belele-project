package pt.belele.project.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Odd {

	private Double backHomeWin;
	private Double backDraw;
	private Double backAwayWin;
	private Double layHomeWin;
	private Double layDraw;
	private Double layAwayWin;
	
	public Odd() {

	}
	
	public Odd(Double backHomeWin, Double backDraw, Double backAwayWin, Double layHomeWin, Double layDraw,
			Double layAwayWin) {
		super();
		this.backHomeWin = backHomeWin;
		this.backDraw = backDraw;
		this.backAwayWin = backAwayWin;
		this.layHomeWin = layHomeWin;
		this.layDraw = layDraw;
		this.layAwayWin = layAwayWin;
	}

	public Odd(Double backHomeWin, Double backDraw, Double backAwayWin) {
		this.backHomeWin = backHomeWin;
		this.backDraw = backDraw;
		this.backAwayWin = backAwayWin;
	}

	public Double getBackHomeWin() {
		return backHomeWin;
	}

	public void setBackHomeWin(Double backHomeWin) {
		this.backHomeWin = backHomeWin;
	}

	public Double getBackDraw() {
		return backDraw;
	}

	public void setBackDraw(Double backDraw) {
		this.backDraw = backDraw;
	}

	public Double getBackAwayWin() {
		return backAwayWin;
	}

	public void setBackAwayWin(Double awayWin) {
		this.backAwayWin = awayWin;
	}

	public Double getLayHomeWin() {
		return layHomeWin;
	}

	public void setLayHomeWin(Double layHomeWin) {
		this.layHomeWin = layHomeWin;
	}

	public Double getLayDraw() {
		return layDraw;
	}

	public void setLayDraw(Double layDraw) {
		this.layDraw = layDraw;
	}

	public Double getLayAwayWin() {
		return layAwayWin;
	}

	public void setLayAwayWin(Double layAwayWin) {
		this.layAwayWin = layAwayWin;
	}

	@Override
	public String toString() {
		return "Odd [backHomeWin=" + backHomeWin + ", backDraw=" + backDraw
				+ ", backAwayWin=" + backAwayWin + ", layHomeWin=" + layHomeWin
				+ ", layDraw=" + layDraw + ", layAwayWin=" + layAwayWin + "]";
	}
	
}

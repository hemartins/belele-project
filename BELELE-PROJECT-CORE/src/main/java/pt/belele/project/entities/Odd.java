package pt.belele.project.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "odd")
@NamedQueries({})
@SequenceGenerator(name = "odd_sequence", sequenceName = "odd_sequence_id_seq")
public class Odd implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odd_sequence")
    @Column(name = "odd_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "odd_back_home_win", nullable = false)
    private Double backHomeWin;

    @Column(name = "odd_back_draw", nullable = false)
    private Double backDraw;

    @Column(name = "odd_back_away_win", nullable = false)
    private Double backAwayWin;

    @Column(name = "odd_lay_home_win", nullable = false)
    private Double layHomeWin;

    @Column(name = "odd_lay_draw", nullable = false)
    private Double layDraw;

    @Column(name = "odd_lay_away_win", nullable = false)
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

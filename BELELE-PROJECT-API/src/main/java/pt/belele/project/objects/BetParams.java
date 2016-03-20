/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.objects;

import java.util.List;

/**
 *
 * @author P056913
 */
public class BetParams {

    private Long seasonId;
    private String begin;
    private String end;
    private Double investedValue;
    private List<String> winVariables;
    private List<String> drawVariables;
    private List<String> loseVariables;

    public BetParams() {
    }

    public Long getSeasonId() {
	return seasonId;
    }

    public void setSeasonId(Long seasonId) {
	this.seasonId = seasonId;
    }

    public String getBegin() {
	return begin;
    }

    public void setBegin(String begin) {
	this.begin = begin;
    }

    public String getEnd() {
	return end;
    }

    public void setEnd(String end) {
	this.end = end;
    }

    public Double getInvestedValue() {
	return investedValue;
    }

    public void setInvestedValue(Double investedValue) {
	this.investedValue = investedValue;
    }

    public List<String> getWinVariables() {
	return winVariables;
    }

    public void setWinVariables(List<String> winVariables) {
	this.winVariables = winVariables;
    }

    public List<String> getDrawVariables() {
	return drawVariables;
    }

    public void setDrawVariables(List<String> drawVariables) {
	this.drawVariables = drawVariables;
    }

    public List<String> getLoseVariables() {
	return loseVariables;
    }

    public void setLoseVariables(List<String> loseVariables) {
	this.loseVariables = loseVariables;
    }

}

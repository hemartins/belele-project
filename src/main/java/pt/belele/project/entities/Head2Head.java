package pt.belele.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Head2Head implements Serializable {

	private static final long serialVersionUID = 3097032153758675514L;

	@Id
	@GeneratedValue
	private long id;

	private Date timeFrameStart;

	private Date timeFrameEnd;

	private Integer homeTeamWins;

	private Integer awayTeamWins;

	private Integer draws;

	@OneToMany(mappedBy="head2Head")
	private List<Fixture> fixtures;

	public Head2Head() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTimeFrameStart() {
		return timeFrameStart;
	}

	public void setTimeFrameStart(Date timeFrameStart) {
		this.timeFrameStart = timeFrameStart;
	}

	public Date getTimeFrameEnd() {
		return timeFrameEnd;
	}

	public void setTimeFrameEnd(Date timeFrameEnd) {
		this.timeFrameEnd = timeFrameEnd;
	}

	public Integer getHomeTeamWins() {
		return homeTeamWins;
	}

	public void setHomeTeamWins(Integer homeTeamWins) {
		this.homeTeamWins = homeTeamWins;
	}

	public Integer getAwayTeamWins() {
		return awayTeamWins;
	}

	public void setAwayTeamWins(Integer awayTeamWins) {
		this.awayTeamWins = awayTeamWins;
	}

	public Integer getDraws() {
		return draws;
	}

	public void setDraws(Integer draws) {
		this.draws = draws;
	}

	public List<Fixture> getFixtures() {
		return fixtures;
	}

	public void setFixtures(List<Fixture> fixtures) {
		this.fixtures = fixtures;
	}
}

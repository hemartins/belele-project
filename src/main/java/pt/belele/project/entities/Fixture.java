package pt.belele.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Embeddable
@Entity
public class Fixture implements Serializable {

	private static final long serialVersionUID = 9137456889270960212L;

	public static enum Venue {
		HOME(0), AWAY(1);

		private int value;

		private Venue(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static Venue parse(final int id) {
			Venue venue = null; // Default
			for (final Venue item : Venue.values()) {
				if (item.getValue() == id) {
					venue = item;
					break;
				}
			}
			return venue;
		}
	}

	public static enum FixtureStatus {
		SCHEDULED(0), FINISHED(1);

		private int value;

		private FixtureStatus(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static FixtureStatus parse(final int id) {
			FixtureStatus type = null; // Default
			for (final FixtureStatus item : FixtureStatus.values()) {
				if (item.getValue() == id) {
					type = item;
					break;
				}
			}
			return type;
		}
	}

	@Id
	@GeneratedValue
	private long id;

	private Date date;

	private FixtureStatus status;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Season season;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id", nullable = false)
	private Team homeTeam;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id", nullable = false)
	private Team awayTeam;

	@ManyToMany(targetEntity = Bet.class)
	private List<Bet> bets;

	@Embedded
	private Result result;

	/*
	 * @Embedded private Odd backOdd;
	 * 
	 * @Embedded private Odd layOdd;
	 */

	@Embedded
	private Odd odd;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "id")
	private List<Fixture> h2h;

	public Fixture() {
	}

	public Fixture(Date date, Season season, Team homeTeam, Team awayTeam,
			Result result,
			/* Odd backOdd, Odd layOdd */Odd odd) {
		this.date = date;
		this.season = season;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.result = result;
		this.status = FixtureStatus.FINISHED;
		/*
		 * this.backOdd = backOdd; this.layOdd = layOdd;
		 */
		this.odd = odd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public FixtureStatus getStatus() {
		return status;
	}

	public void setStatus(FixtureStatus status) {
		this.status = status;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public List<Fixture> getH2h() {
		return h2h;
	}

	public void setH2h(List<Fixture> h2h) {
		this.h2h = h2h;
	}

	/*
	 * public Odd getBackOdd() { return backOdd; }
	 * 
	 * public void setBackOdd(Odd backOdd) { this.backOdd = backOdd; }
	 * 
	 * public Odd getLayOdd() { return layOdd; }
	 * 
	 * public void setLayOdd(Odd layOdd) { this.layOdd = layOdd; }
	 */

	public Odd getOdd() {
		return odd;
	}

	public void setOdd(Odd odd) {
		this.odd = odd;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	@Override
	public String toString() {
		return "Fixture [date=" + date + " homeTeam=" + homeTeam
				+ ", awayTeam=" + awayTeam + "result="+ result.getResultType().name() +"]";
	}

}

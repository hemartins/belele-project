package pt.belele.project.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	@Embedded
	private Result result;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id", nullable = true)
	private Head2Head head2Head;

	public Fixture() {
	}

	public Fixture(Date date, Season season, Team homeTeam, Team awayTeam, Result result) {
		this.date = date;
		this.season = season;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.result = result;
		this.status = FixtureStatus.FINISHED;
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

	public Head2Head getHead2Head() {
		return head2Head;
	}

	public void setHead2Head(Head2Head head2Head) {
		this.head2Head = head2Head;
	}

	@Override
	public String toString() {
		return "Fixture [id=" + id + ", date=" + date + ", status=" + status
				+ ", season=" + season + ", homeTeam=" + homeTeam
				+ ", awayTeam=" + awayTeam + ", result=" + result
				+ ", head2Head=" + head2Head + "]";
	}

}

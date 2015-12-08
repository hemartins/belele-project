package pt.belele.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.joda.time.DateTime;

@Entity
@Table(name = "fixture", indexes = {
    @Index(name = "fixture_find_index", columnList="fixture_date,fixture_season_id,fixture_home_team_id,fixture_away_team_id")
})
@NamedQueries({})
@SequenceGenerator(name = "fixture_sequence", sequenceName = "fixture_sequence_id_seq")
public class Fixture implements Serializable {

    private static final long serialVersionUID = 9137456889270960212L;

    public static enum Venue {
	HOME(0), AWAY(1);

	private final int value;

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

	private final int value;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fixture_sequence")
    @Column(name = "fixture_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "fixture_date", nullable = false)
    private DateTime date;

    @Column(name = "fixture_status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private FixtureStatus status;

    @JoinColumn(name = "fixture_season_id", referencedColumnName = "season_id", nullable = false, updatable = false)
    @ManyToOne(optional = false)
    private Season season;

    @JoinColumn(name = "fixture_home_team_id", referencedColumnName = "team_id", nullable = false, updatable = false)
    @ManyToOne(optional = false)
    private Team homeTeam;

    @JoinColumn(name = "fixture_away_team_id", referencedColumnName = "team_id", nullable = false, updatable = false)
    @ManyToOne(optional = false)
    private Team awayTeam;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fixture")
    private List<Bet> bets;

    @OneToOne
    @JoinColumn(name = "fixutre_result_id", referencedColumnName = "fixture_result_id", nullable = true, updatable = true)
    private Result result;

    @OneToOne
    @JoinColumn(name = "fixture_odd_id", referencedColumnName = "odd_id", nullable = true, updatable = true)
    private Odd odd;

    @OneToOne
    @JoinColumn(name = "fixutre_ann_odd_id", referencedColumnName = "odd_id", nullable = true, updatable = true)
    private Odd annOdd;

    @ManyToMany
    @JoinTable(name = "fixture_h2h", joinColumns = @JoinColumn(name = "fixture_id"), inverseJoinColumns = @JoinColumn(name = "h2h_fixture_id"))
    private List<Fixture> H2H;

    @ManyToMany
    @JoinTable(name = "fixture_h2h_venue", joinColumns = @JoinColumn(name = "fixture_id"), inverseJoinColumns = @JoinColumn(name = "h2h_fixture_id"))
    private List<Fixture> H2HVenue;

    @ManyToMany
    @JoinTable(name = "fixture_h2h_switched_venue", joinColumns = @JoinColumn(name = "fixture_id"), inverseJoinColumns = @JoinColumn(name = "h2h_fixture_id"))
    private List<Fixture> H2HSwitchedVenue;

    public Fixture() {
    }

    public Fixture(DateTime date, Season season, Team homeTeam, Team awayTeam, Result result, Odd odd) {
	this.date = date;
	this.season = season;
	this.homeTeam = homeTeam;
	this.awayTeam = awayTeam;
	this.result = result;
	this.status = FixtureStatus.FINISHED;
	this.odd = odd;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public DateTime getDate() {
	return date;
    }

    public void setDate(DateTime date) {
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
	return H2H;
    }

    public void setH2H(List<Fixture> h2h) {
	this.H2H = h2h;
    }

    public List<Fixture> getH2HVenue() {
	return H2HVenue;
    }

    public void setH2HVenue(List<Fixture> h2hVenue) {
	this.H2HVenue = h2hVenue;
    }

    public List<Fixture> getH2HSwitchedVenue() {
	return H2HSwitchedVenue;
    }

    public void setH2hSwitchedVenue(List<Fixture> h2hSwitchedVenue) {
	this.H2HSwitchedVenue = h2hSwitchedVenue;
    }

    public Odd getOdd() {
	return odd;
    }

    public void setOdd(Odd odd) {
	this.odd = odd;
    }

    public Odd getAnnOdd() {
	return annOdd;
    }

    public void setAnnOdd(Odd annOdd) {
	this.annOdd = annOdd;
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
		+ ", awayTeam=" + awayTeam + "result="
		+ result.getResultType().name() + "]";
    }

    public String printFixuteOdds() {
	return "Fixture [date=" + date + " homeTeam=" + homeTeam
		+ ", awayTeam=" + awayTeam + ", odds=" + odd + ", result="
		+ result.getResultType().name() + "]";
    }

}

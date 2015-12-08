package pt.belele.project.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bet")
@NamedQueries({})
@SequenceGenerator(name = "bet_sequence", sequenceName = "bet_sequence_id_seq")
public class Bet implements Serializable {

    private static final long serialVersionUID = 5229534133139860265L;

    public static enum BetResult {
	OPEN(0), WON(1), LOST(2), VOID(3);

	private final int betResult;

	private BetResult(int betresult) {
	    this.betResult = betresult;
	}

	public int getBetResult() {
	    return betResult;
	}
    }

    public static enum MatchOddBet {
	WIN(0), DRAW(1), LOSE(2), DONOTWIN(3), DONOTDRAW(4), DONOTLOSE(5);

	private final int matchOddsBet;

	private MatchOddBet(int matchOddsBet) {
	    this.matchOddsBet = matchOddsBet;
	}

	public int getMatchOddsBet() {
	    return matchOddsBet;
	}
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bet_sequence")
    @Column(name = "bet_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "bet_result", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private BetResult betResult;

    @Column(name = "bet_match_odd", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private MatchOddBet matchOddBet;

    @Column(name = "bet_invested_value", nullable = true)
    private Double investedValue;

    @Column(name = "bet_odd", nullable = true)
    private Double odd;

    @JoinColumn(name = "bet_fixture_id", referencedColumnName = "fixture_id", nullable = true, updatable = false)
    @ManyToOne(optional = true)
    private Fixture fixture;

    public Bet() {

    }

    public Bet(BetResult betResult, MatchOddBet matchOddBet, double investedValue, double odd, Fixture fixture) {
	super();
	this.betResult = betResult;
	this.matchOddBet = matchOddBet;
	this.investedValue = investedValue;
	this.odd = odd;
	this.fixture = fixture;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public BetResult getBetResult() {
	return betResult;
    }

    public void setBetResult(BetResult betResult) {
	this.betResult = betResult;
    }

    public MatchOddBet getMatchOddBet() {
	return matchOddBet;
    }

    public void setMatchOddBet(MatchOddBet matchOddBet) {
	this.matchOddBet = matchOddBet;
    }

    public double getInvestedValue() {
	return investedValue;
    }

    public void setInvestedValue(double investedValue) {
	this.investedValue = investedValue;
    }

    public double getOdd() {
	return odd;
    }

    public void setOdd(double odd) {
	this.odd = odd;
    }

    public Fixture getFixture() {
	return fixture;
    }

    public void setFixture(Fixture fixture) {
	this.fixture = fixture;
    }

    @Override
    public String toString() {
	return "Bet [id=" + id + ", betResult=" + betResult + ", matchOddBet="
		+ matchOddBet + ", investedValue=" + investedValue + ", odd="
		+ odd + ", fixture=" + fixture + "]";
    }

}

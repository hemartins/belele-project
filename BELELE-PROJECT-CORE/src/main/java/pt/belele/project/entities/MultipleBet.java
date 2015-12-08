package pt.belele.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import pt.belele.project.entities.Bet.BetResult;

@Entity
@Table(name = "multiple_bet")
@NamedQueries({})
@SequenceGenerator(name = "multiple_bet_sequence", sequenceName = "multiple_bet_sequence_id_seq")
public class MultipleBet implements Serializable {

    public static enum MultipleBetType {
	DOUBLE(0), TRIPLE(1), MULTIPLE(2);

	private final int betType;

	private MultipleBetType(int bettype) {
	    this.betType = bettype;
	}

	public int getBettype() {
	    return betType;
	}
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "multiple_bet_sequence")
    @Column(name = "multiple_bet_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "multiple_bet_result", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private BetResult betResult;

    @Column(name = "multiple_bet_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private MultipleBetType betType;

    @Column(name = "multiple_bet_invested_value", nullable = true)
    private Double investedValue;

    @Column(name = "multiple_bet_odd", nullable = true)
    private Double odd;

    @ManyToMany
    @JoinTable(name = "multiple_bet_bet_list", joinColumns = {
	@JoinColumn(name = "bet_id")}, inverseJoinColumns = {
	@JoinColumn(name = "multiple_bet_id")})
    private List<Bet> betsList;

    public MultipleBet() {
    }

    public BetResult getBetResult() {
	return betResult;
    }

    public void setBetResult(BetResult betResult) {
	this.betResult = betResult;
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

    public MultipleBetType getBetType() {
	return betType;
    }

    public void setBetType(MultipleBetType betType) {
	this.betType = betType;
    }

    public List<Bet> getBetsList() {
	return betsList;
    }

    public void setBetsList(List<Bet> betsList) {
	this.betsList = betsList;
    }

    @Override
    public String toString() {
	return "MultipleBet [id=" + id + ", betResult=" + betResult
		+ ", investedValue=" + investedValue + ", odd=" + odd
		+ ", betType=" + betType + ", betsList=" + betsList + "]";
    }
}

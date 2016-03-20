/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business;

import java.util.List;
import javax.ejb.Local;
import org.joda.time.DateTime;
import pt.belele.project.business.util.CutOff;
import pt.belele.project.entities.Bet;
import pt.belele.project.entities.Fixture;
import pt.belele.project.entities.MultipleBet;
import pt.belele.project.entities.Season;

/**
 *
 * @author P056913
 */
@Local
public interface BetController {

    Double calculateOdd(Bet bet, Bet.MatchOddBet matchOddsBet);

    List<Bet> calculateSimpleBetForFixtures(List<Fixture> fixtures, CutOff cutOffSimple, Double investedValue);

    List<MultipleBet> calculateMultipleBetForFixtures(List<Fixture> fixtures, CutOff cutOffDouble, CutOff cutOffTriple, CutOff cutOffMultiple, Double investedValue);

    List<Bet> doSimpleBetsForSeason(DateTime begin, DateTime end, Season s, Double investedValue, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception;

    List<MultipleBet> doMultipleBetsForSeason(DateTime begin, DateTime end, Season s, Double investedValue, List<String> winVariables, List<String> drawVariables, List<String> loseVariables) throws Exception;
}

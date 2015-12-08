/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.persistence;

import javax.ejb.Local;
import pt.belele.project.entities.Bet;

/**
 *
 * @author P056913
 */
@Local
public interface BetDAO extends GenericDAO<Bet, Long> {

}

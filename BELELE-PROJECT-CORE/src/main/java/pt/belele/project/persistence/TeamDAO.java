/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.persistence;

import java.util.List;
import javax.ejb.Local;
import pt.belele.project.business.exception.BeleleException;
import pt.belele.project.entities.Team;

/**
 *
 * @author P056913
 */
@Local
public interface TeamDAO extends GenericDAO<Team, String> {

    Team findByName(String name) throws BeleleException;
    
    List<Team> findHardTeamsBySeasonId(Long seasonId);
}

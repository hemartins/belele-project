/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.persistence;

import java.util.List;
import javax.ejb.Local;
import javax.persistence.NoResultException;
import org.joda.time.DateTime;
import pt.belele.project.business.exception.BeleleException;
import pt.belele.project.entities.Standing;
import pt.belele.project.entities.Team;

/**
 *
 * @author P056913
 */
@Local
public interface StandingDAO extends GenericDAO<Standing, Long> {

    Standing findStanding(Long teamId, DateTime date, Long seasonId) throws BeleleException;
    
    Standing findNewestByNameAndDate(Long teamId, DateTime date, Long seasonId) throws NoResultException;
    
    List<Team> getStandingsByPoints(DateTime date, Long seasonId);
    
    List<Team> getStandingsByQuality(DateTime date, Long seasonId);
}

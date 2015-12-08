/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business;

import javax.ejb.Local;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;

/**
 *
 * @author P056913
 */
@Local
public interface SeasonController {

    Season createSeason(String name, int year);

    void addTeam(Season s, Team t);
}

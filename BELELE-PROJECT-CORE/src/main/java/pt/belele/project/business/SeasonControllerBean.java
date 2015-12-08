package pt.belele.project.business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import pt.belele.project.business.exception.BeleleException;
import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.SeasonDAO;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class SeasonControllerBean implements SeasonController {

    @EJB
    private SeasonDAO seasonDAO;

    @Override
    public Season createSeason(String name, int year) {
	Season s;
	try {
	    s = seasonDAO.findByNameAndYear(name, year);
	} catch (BeleleException e) {
	    s = seasonDAO.insert(new Season(name, year));
	}
	
	return s;
    }

    @Override
    public void addTeam(Season s, Team t) {
	List<Team> teams = s.getTeams();
	if (teams == null) {
	    teams = new ArrayList<>();
	}
	if (!teams.contains(t)) {
	    teams.add(t);
	    s.setTeams(teams);
	    seasonDAO.update(s);
	}
    }

}

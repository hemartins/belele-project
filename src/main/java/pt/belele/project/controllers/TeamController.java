package pt.belele.project.controllers;

import javax.persistence.NoResultException;

import pt.belele.project.entities.Team;
import pt.belele.project.persistence.TeamDAO;

public class TeamController {
	private TeamDAO teamDAO;
	
	public TeamController()
	{
		teamDAO = new TeamDAO();
	}
	
	public Team createTeam(String name)
	{
		try{
			teamDAO.findByName(name);
		} catch(NoResultException e)
		{
			teamDAO.insert(new Team(name));
		}
		return teamDAO.findByName(name);
	}
}

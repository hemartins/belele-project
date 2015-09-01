package pt.belele.project.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import pt.belele.project.entities.Season;
import pt.belele.project.entities.Team;
import pt.belele.project.persistence.SeasonDAO;


public class SeasonController
{
	private SeasonDAO seasonDAO;
	
	public SeasonController(EntityManager em)
	{
			seasonDAO = new SeasonDAO(em);
	}
	
	public Season createSeason(String name, int year)
	{
		try{
			seasonDAO.findByNameAndYear(name, year);
		} catch(NoResultException e)
		{
			seasonDAO.insert(new Season(name, year));
		}
		return seasonDAO.findByNameAndYear(name, year);
	}
	
	public void addTeam(Season s, Team t)
	{
		List<Team> teams = s.getTeams();
		if(teams==null)
			teams = new ArrayList<Team>();
		if(!teams.contains(t))
		{
			teams.add(t);
			s.setTeams(teams);
			seasonDAO.update(s);
		}
	}
}

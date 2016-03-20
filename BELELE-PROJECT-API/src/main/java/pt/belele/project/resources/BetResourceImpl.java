/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.resources;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.ws.rs.core.Response;
import org.joda.time.DateTime;
import pt.belele.project.business.BetController;
import pt.belele.project.entities.Bet;
import pt.belele.project.entities.MultipleBet;
import pt.belele.project.entities.Season;
import pt.belele.project.objects.BetParams;
import pt.belele.project.persistence.SeasonDAO;

/**
 *
 * @author P056913
 */
@Stateless
public class BetResourceImpl implements BetResource {

    @EJB
    private BetController betController;

    @EJB
    private SeasonDAO seasonDAO;
    
    @Override
    public Response doSimpleBet(BetParams params) {
	try {
	    InitialContext ctx=new InitialContext();
	    seasonDAO = (SeasonDAO) ctx.lookup("java:global/BELELE-PROJECT-EAR/BELELE-PROJECT-CORE/SeasonDAOBean!pt.belele.project.persistence.SeasonDAO");
	    betController = (BetController) ctx.lookup("java:global/BELELE-PROJECT-EAR/BELELE-PROJECT-CORE/BetControllerBean!pt.belele.project.business.BetController");
	    
	    Season s = seasonDAO.findById(params.getSeasonId());
	    List<Bet> bets = betController.doSimpleBetsForSeason(new DateTime(params.getBegin()), new DateTime(params.getEnd()), s, params.getInvestedValue(), params.getWinVariables(), params.getDrawVariables(), params.getLoseVariables());
	    return Response.ok(bets).build();
	} catch (Exception e) {
	    return Response.serverError().entity(e.getMessage()).build();
	}
    }

    @Override
    public Response doMultipleBet(BetParams params) {
	Season s = seasonDAO.findById(params.getSeasonId());

	try {
	    List<MultipleBet> bets = betController.doMultipleBetsForSeason(new DateTime(params.getBegin()), new DateTime(params.getEnd()), s, params.getInvestedValue(), params.getWinVariables(), params.getDrawVariables(), params.getLoseVariables());
	    return Response.ok(bets).build();
	} catch (Exception e) {
	    return Response.serverError().build();
	}
    }

}

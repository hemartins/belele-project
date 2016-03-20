/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.resources;

import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Response;
import pt.belele.project.entities.Season;
import pt.belele.project.persistence.SeasonDAO;

/**
 *
 * @author P056913
 */
public class SeasonResourceImpl implements SeasonResource {

    private SeasonDAO seasonDao;
    
    @Override
    public Response getAllSeasons() {
	
	try {
	    InitialContext ctx=new InitialContext();
	    seasonDao = (SeasonDAO) ctx.lookup("java:global/BELELE-PROJECT-EAR/BELELE-PROJECT-CORE/SeasonDAOBean!pt.belele.project.persistence.SeasonDAO");
	    
	    List<Season> seasons = seasonDao.findAll();
	    
	    return Response.ok(seasons).build();
	} catch (NamingException ex) {
	    return Response.serverError().entity(ex).build();
	}
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.resources;

import javax.ejb.Local;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pt.belele.project.objects.BetParams;

/**
 *
 * @author P056913
 */
@Local
@Path("/bet")
@Produces(MediaType.APPLICATION_JSON)
public interface BetResource {
    
    @POST
    @Path("/simple")
    Response doSimpleBet(BetParams params);
    
    @POST
    @Path("/multiple")
    Response doMultipleBet(BetParams params);
}

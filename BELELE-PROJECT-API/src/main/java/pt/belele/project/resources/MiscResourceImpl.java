/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author P056913
 */
@Path("/marino")
@Produces(MediaType.APPLICATION_JSON)
public class MiscResourceImpl {

    @GET
    public Response tasFora() {
	return Response.ok("Tás Fora!").build();
    }

}

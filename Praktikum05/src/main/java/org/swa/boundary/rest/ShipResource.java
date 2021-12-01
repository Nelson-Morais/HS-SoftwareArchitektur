package org.swa.boundary.rest;


import org.swa.boundary.entity.ShipDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ships")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShipResource {


    @GET
    @Path("{id}")
    public Response getShip(int id){

        return Response.ok().build();
    }

    @POST
    public Response createShip(ShipDTO shipDTO){

        return Response.ok().build();
    }

}

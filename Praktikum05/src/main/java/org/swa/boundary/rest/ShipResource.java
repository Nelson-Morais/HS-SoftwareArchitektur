package org.swa.boundary.rest;


import org.swa.boundary.entity.ShipDTO;
import org.swa.ships.al.ShipController;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;

@Path("/ships")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShipResource {

    @Context
    UriInfo uriInfo;

    @Inject
    ShipController shipController;

    @GET
    public Response getShips(){
        return Response.ok().entity(shipController.getShips()).build();
    }


    @GET
    @Path("{id}")
    public Response getShip(@PathParam("id") int id){
        if(shipController.getShip(id) != null){

            return Response.ok(shipController.getShip(id)).build();
        }
        return Response.noContent().build();
    }

    @POST
    public Response createShip(ShipDTO shipDTO){
        shipController.createShip(shipDTO);
        return Response.ok().build();
    }

}

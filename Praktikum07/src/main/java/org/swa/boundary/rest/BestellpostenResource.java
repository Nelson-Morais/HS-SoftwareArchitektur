package org.swa.boundary.rest;

import io.quarkus.security.identity.SecurityIdentity;
import org.swa.al.bestellposten.BestellpostenService;
import org.swa.bl.entity.Bestellposten;
import org.swa.boundary.DTO.BestellpostenDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/bestellposten")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class BestellpostenResource {

    @Inject
    BestellpostenService bestellpostenService;

    @Inject
    SecurityIdentity sc;


    @GET
    public Response listBestellposten(){
        //return Response.ok().entity(bestellpostenService.listBestellposten()).build();
        return Response.noContent().build();
    }

    @POST
    public Response addBestellposten(Bestellposten bestellposten){
        bestellpostenService.addBestellposten(bestellposten);
        return Response.ok().build();

    }

}

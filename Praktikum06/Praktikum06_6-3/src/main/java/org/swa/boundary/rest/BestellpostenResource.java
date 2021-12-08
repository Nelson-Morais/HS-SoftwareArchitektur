package org.swa.boundary.rest;

import org.swa.al.bestellposten.BestellpostenService;
import org.swa.boundary.DTO.BestellpostenDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/bestellposten")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BestellpostenResource {

    @Inject
    BestellpostenService bestellpostenService;

    @GET
    public Response listBestellposten(){
        return Response.ok().entity(bestellpostenService.listBestellposten(0)).build();
    }

    @POST
    public Response addBestellposten(BestellpostenDTO bestellpostenDTO){
        bestellpostenService.addBestellposten(bestellpostenDTO);
        return Response.ok().build();

    }

}

package org.swa.boundary.rest;


import org.swa.al.kunden.KundenService;
import org.swa.bl.catalogs.KundenCatalog;
import org.swa.bl.entity.Adresse;
import org.swa.boundary.DTO.KundeDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kunde")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KundenResource {

    @Inject
    KundenService kundenService;


    @GET
    public Response listKunden(){
        return Response.ok().entity(kundenService.listKunden()).build();
    }

    @POST
    public Response addKunde(KundeDTO kundeDTO){
        kundenService.addKunde(kundeDTO);
        return Response.ok().build();
    }

    @PUT
    @Path("/{kundennummer}")
    public Response addAdresse(@PathParam("kundennummer") long kundennumer, Adresse adresse){
        if(kundenService.addAdresse(kundennumer, adresse)){
            return Response.ok().build();
        }
        return Response.notModified().build();
    }

}

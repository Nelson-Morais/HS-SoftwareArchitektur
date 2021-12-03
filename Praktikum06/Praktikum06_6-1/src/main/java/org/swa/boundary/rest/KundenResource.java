package org.swa.boundary.rest;


import org.swa.control.KundenService;
import org.swa.entity.Adresse;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/kunden")
public class KundenResource {

    @Inject
    KundenService kundenService;


    @GET
    public Response kundenAbfragen(){

        return Response.ok().entity(kundenService.kundenAbfragen()).build();
    }

    @GET
    @Path("{kundennr}")
    public Response kundeAbfragen(@PathParam("kundennr")long kundennr){
        if(kundenService.kundeAbfragen(kundennr) != null){
            return Response.ok().entity(kundenService.kundeAbfragen(kundennr)).build();
        }
        return Response.noContent().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{kundennr}/adresse")
    public Response adresseAbfragen(@PathParam("kundennr")long kundennr){
        if(kundenService.adresseAbfragen(kundennr) != null ){
            return Response.ok().entity(kundenService.adresseAbfragen(kundennr)).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Path("{name}")
    public Response kundeAnlegen(@PathParam("name")String name){
        kundenService.kundenAnlegen(name);
        return Response.ok().build();
    }

    @POST
    @Path("{kundennr}/adresse")
    public Response adresseAnlegen(@PathParam("kundennr")long kundennr, Adresse adresse){
        kundenService.adresseAnlegen(kundennr,adresse);
        return Response.ok().build();
    }

    @PUT
    @Path("{kundennr}/adresse")
    public Response adresseAendern(@PathParam("kundennr")long kundennr, Adresse adresse){
        kundenService.adresseAendern(kundennr,adresse);
        return Response.ok().build();
    }

    @DELETE
    @Path("{kundennr}")
    public Response kundenLoeschen(@PathParam("kundennr")long kundennr){
        if(kundenService.kundenLoeschen(kundennr)){
            return Response.ok().build();
        }
        return Response.noContent().build();
    }

    @DELETE
    @Path("{kundennr}/adresse")
    public Response adresseLoeschen(@PathParam("kundennr")long kundennr){
        if(kundenService.adresseLoeschen(kundennr)){

            return Response.ok().build();
        }
        return Response.notModified().build();
    }


}

package org.swa.boundary.rest;


import org.swa.entity.Adresse;
import org.swa.gateway.KundenRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/kunden")
public class KundenResource {

    @Inject
    KundenRepository kundenRepository;


    @GET
    public Response kundenAbfragen(){

        return Response.ok().entity(kundenRepository.kundenAbfragen()).build();
    }

    @GET
    @Path("{kundennr}")
    public Response kundeAbfragen(@PathParam("kundennr")long kundennr){
        if(kundenRepository.kundeAbfragen(kundennr) != null){
            return Response.ok().entity(kundenRepository.kundeAbfragen(kundennr)).build();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("{kundennr}/adresse")
    public Response adresseAbfragen(@PathParam("kundennr")long kundennr){

        if(kundenRepository.adresseAbfragen(kundennr) != null){
            return Response.ok().entity(kundenRepository.adresseAbfragen(kundennr)).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Path("{name}")
    public Response kundeAnlegen(@PathParam("name")String name){
        kundenRepository.kundenAnlegen(name);
        return Response.ok().build();
    }

    @POST
    @Path("{kundennr}/adresse")
    public Response adresseAnlegen(@PathParam("kundennr")long kundennr, Adresse adresse){
        kundenRepository.adresseAnlegen(kundennr,adresse);
        return Response.ok().build();
    }

    @PUT
    @Path("{kundennr}/adresse")
    public Response adresseAendern(@PathParam("kundennr")long kundennr, Adresse adresse){
        kundenRepository.adresseAendern(kundennr,adresse);
        return Response.ok().build();
    }

    @DELETE
    @Path("{kundennr}")
    public Response kundenLoeschen(@PathParam("kundennr")long kundennr){
        if(kundenRepository.kundenLoeschen(kundennr)){
            return Response.ok().build();
        }
        return Response.noContent().build();
    }

    @DELETE
    @Path("{kundennr}/adresse")
    public Response adresseLoeschen(@PathParam("kundennr")long kundennr){
        if(kundenRepository.adresseLoeschen(kundennr)){

            return Response.ok().build();
        }
        return Response.notModified().build();
    }


}

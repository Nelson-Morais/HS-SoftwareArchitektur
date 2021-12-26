package org.swa.boundary.rest;


import org.swa.al.kunden.KundenService;
import org.swa.bl.catalogs.KundenCatalog;
import org.swa.bl.entity.Adresse;
import org.swa.boundary.DTO.KundeDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kunde")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KundenResource {

    @Inject
    KundenService kundenService;


    @GET
    public Response listKunden(){
        return Response.ok().entity(kundenService.listKunden()).build();
    }

    @POST
    @Transactional
    public Response addKunde(@QueryParam("vn") String vn,@QueryParam("nn") String nn){
        kundenService.addKunde(new KundeDTO(vn,nn));
        return Response.ok().build();
    }

    @PUT
    @Path("/{kundennummer}")
    public Response addAdresse(@PathParam("kundennummer") long kundennumer,
                               @QueryParam("straße") String straße, @QueryParam("nr") String nr,
                               @QueryParam("ort") String ort, @QueryParam("plz") String plz){
        if(kundenService.addAdresse(kundennumer, new Adresse(straße,nr,ort,plz))){
            return Response.ok().build();
        }
        return Response.notModified().build();
    }

}

package org.swa.boundary.rest;


import io.quarkus.oidc.UserInfo;
import io.quarkus.security.identity.SecurityIdentity;
import org.swa.al.kunden.KundenService;

import org.swa.bl.catalogs.KundenCatalog;
import org.swa.bl.entity.Adresse;
import org.swa.bl.entity.Kunde;
import org.swa.boundary.DTO.KundeDTO;


import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/kunde")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KundenResource {

    @Inject
    KundenService kundenService;

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    KundenCatalog kc;

    @PostConstruct
    public void init(){
        Kunde k = kc.getKundeByName(securityIdentity.getPrincipal().getName());
        if( k == null){
            k = createKunde();
        }
    }

    @GET
    @RolesAllowed("admin")
    public Response listKunden(){
        return Response.ok().entity(kundenService.listKunden()).build();
    }

    @GET
    @Path("/me")
    @RolesAllowed("user")
    public Response getKunde(){
    	Map<String,String> m = new HashMap<>();
        m.put("username",securityIdentity.getPrincipal().getName());
        return Response.ok(m).build();
    }



    @POST
    @RolesAllowed("admin")
    @Transactional
    public Response addKunde(@QueryParam("vn") String vn){
        kundenService.addKunde(new KundeDTO(vn));
        return Response.ok().build();
    }

    @PUT
    @Path("/{kundennummer}")
    @RolesAllowed("user")
    public Response addAdresse(@PathParam("kundennummer") long kundennumer,
                               @QueryParam("straße") String straße, @QueryParam("nr") String nr,
                               @QueryParam("ort") String ort, @QueryParam("plz") String plz){
        if(kundenService.addAdresse(kundennumer, new Adresse(straße,nr,ort,plz))){
            return Response.ok().build();
        }
        return Response.notModified().build();
    }


    @Transactional
    public Kunde createKunde(){
        Kunde k = new Kunde(securityIdentity.getPrincipal().getName());
        kc.addKunde(k);
        return k;
    }

}

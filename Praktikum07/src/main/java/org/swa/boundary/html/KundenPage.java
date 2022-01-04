package org.swa.boundary.html;


import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.identity.SecurityIdentity;
import org.swa.bl.catalogs.BestellungCatalog;
import org.swa.bl.catalogs.KundenCatalog;
import org.swa.bl.entity.Adresse;
import org.swa.bl.entity.Bestellung;
import org.swa.bl.entity.Kunde;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;


@Path("/kunden")
@Produces(MediaType.TEXT_HTML)
public class KundenPage {

    @Inject
    SecurityIdentity sc;

    @Inject
    KundenCatalog kc;

    @Inject
    BestellungCatalog bc;

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance kunden();
        public static native TemplateInstance kunde();
    }

    @PostConstruct
    public void init(){
        Kunde k = kc.getKundeByName(sc.getPrincipal().getName());
        if( k == null){
            k = createKunde();
        }
    }



    @GET
    @RolesAllowed("admin")
    public Response getKunden(){
        return Response.ok(Templates.kunden().data("kunden",kc.listKunden())).build();
    }

    @POST
    @RolesAllowed("user")
    @Path("/me")
    @Transactional
    public Response addBestellung(){
        Kunde k = kc.getKundeByName(sc.getPrincipal().getName());
        Bestellung b = new Bestellung();
        k.addBestellung(b);
        b.persist();
        return Response.seeOther(UriBuilder.fromResource(KundenPage.class).path(KundenPage.class,"getKunde").build()).build();
    }

    /*@POST
    @Path("add")
    @RolesAllowed("admin")
    public Response addKunde(){

    }*/

    @GET
    @Path("/me")
    @RolesAllowed("user")
    public Response getKunde(){
        return Response.ok(Templates.kunde().data("kunde",kc.getKundeByName(sc.getPrincipal().getName()))).build();
    }

    @POST
    @Path("/me/adresse")
    @RolesAllowed("user")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postAdresse(@FormParam("strasse") String strasse, @FormParam("hausnummer") String hausnummer, @FormParam("ort") String ort, @FormParam("plz") String plz) {
        Kunde k = kc.getKundeByName(sc.getPrincipal().getName());
        Adresse adr = new Adresse();
        adr.setHausNummer(hausnummer);
        adr.setOrt(ort);
        adr.setStrasse(strasse);
        adr.setPlz(plz);
        k.setAdresse(adr);
        k.persist();

        return Response.seeOther(UriBuilder.fromResource(KundenPage.class).path(KundenPage.class, "getKunde").build()).build();
    }



    @Transactional
    public Kunde createKunde(){
        Kunde k = new Kunde(sc.getPrincipal().getName());
        kc.addKunde(k);
        return k;
    }
}

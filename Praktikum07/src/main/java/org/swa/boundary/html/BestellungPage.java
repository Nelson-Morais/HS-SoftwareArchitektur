package org.swa.boundary.html;


import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.identity.SecurityIdentity;
import org.swa.bl.catalogs.BestellpostenCatalog;
import org.swa.bl.catalogs.BestellungCatalog;
import org.swa.bl.catalogs.KundenCatalog;
import org.swa.bl.catalogs.PizzaCatalog;
import org.swa.bl.entity.Kunde;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bestellungen")
@Produces(MediaType.TEXT_HTML)
public class BestellungPage {

    @Inject
    KundenCatalog kc;

    @Inject
    SecurityIdentity sc;

    @Inject
    BestellungCatalog bc;

    @Inject
    BestellpostenCatalog bpc;

    @Inject
    PizzaCatalog pc;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance bestellung();
        public static native TemplateInstance bestellungen();
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
    public Response getBestellungen(){
        return Response.ok(Templates.bestellungen().data("bestellungen",bc.listBestellungen())).build();
    }

    @GET
    @RolesAllowed("user")
    @Path("{id}")
    public Response getBestellung(@PathParam("id") int id){
        return Response.ok(Templates.bestellung().data("pizzas",pc.listPizzas()).data("bestellung",kc.getKundeByName(sc.getPrincipal().getName()).getBestellungen().get(id))).build();
    }



    @Transactional
    public Kunde createKunde(){
        Kunde k = new Kunde(sc.getPrincipal().getName());
        kc.addKunde(k);
        return k;
    }

}

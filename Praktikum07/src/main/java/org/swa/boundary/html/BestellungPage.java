package org.swa.boundary.html;


import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.identity.SecurityIdentity;
import org.swa.bl.catalogs.BestellpostenCatalog;
import org.swa.bl.catalogs.BestellungCatalog;
import org.swa.bl.catalogs.KundenCatalog;
import org.swa.bl.catalogs.PizzaCatalog;
import org.swa.bl.entity.Bestellposten;
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

    @CheckedTemplate(requireTypeSafeExpressions = false)
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
        return Response.ok(Templates.bestellung().data("pizzen",pc.listPizzas()).data("bestellung",bc.listBestellung(id))).build();
    }

    @POST
    @RolesAllowed("user")
    @Transactional
    @Path("bestellposten/{id}")
    public Response editBestellposten(@PathParam("id") long id, @FormParam("menge") int menge){
        Bestellposten b = bpc.listBestellposte(id);
        b.setMenge(menge);
        b.setPreis(b.getPizza().getPreis()*menge);
        b.persist();

        return Response.seeOther(UriBuilder.fromResource(KundenPage.class).path(KundenPage.class, "getKunde").build(id)).build();
    }


    @POST
    @RolesAllowed("user")
    @Transactional
    @Path("{id}/bestellposten%7D")
    public Response addBestellposten(@PathParam("id") long id, @FormParam("pizzaname") String name, @FormParam("menge") int menge){
        Bestellung b = bc.listBestellung(id);
        Bestellposten b_post = new Bestellposten();
        b_post.setPizza(pc.findPizzaByName(name));
        b_post.setMenge(menge);
        b_post.persist();
        b.addBestellposten(b_post);
        b.persist();
        return Response.seeOther(UriBuilder.fromResource(BestellungPage.class).path(BestellungPage.class, "getBestellung").build(id)).build();
    }



    @Transactional
    public Kunde createKunde(){
        Kunde k = new Kunde(sc.getPrincipal().getName());
        kc.addKunde(k);
        return k;
    }

}

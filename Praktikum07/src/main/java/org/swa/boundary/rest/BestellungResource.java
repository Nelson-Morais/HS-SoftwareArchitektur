package org.swa.boundary.rest;

import io.quarkus.security.identity.SecurityIdentity;
import org.swa.bl.catalogs.BestellpostenCatalog;
import org.swa.bl.catalogs.KundenCatalog;
import org.swa.bl.catalogs.PizzaCatalog;
import org.swa.bl.entity.Bestellposten;
import org.swa.bl.entity.Bestellung;
import org.swa.bl.entity.Kunde;
import org.swa.bl.entity.Pizza;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bestellung")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BestellungResource {

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    KundenCatalog kc;

    @Inject
    PizzaCatalog pc;

    @Inject
    BestellpostenCatalog bestellpostenCatalog;


    @GET
    @RolesAllowed("user")
    public Response getBestellungen(){

        return Response.ok(getKundenBestellung()).build();
    }

    @GET
    @RolesAllowed("user")
    @Path("/{index}")
    public Response getBestellungByID(@PathParam("index") long id){
        List<Bestellung> bestellungs = getKundenBestellung();
        if(bestellungs == null || id >= bestellungs.size()){
            return Response.noContent().build();
        }
        return Response.ok(bestellungs.get((int)id)).build();
    }

    @POST
    @Transactional
    @RolesAllowed("user")
    public Response newBestellung(){
        Kunde k = kc.getKundeByName(securityIdentity.getPrincipal().getName());
        if(k == null){
            k = createKunde();
        }
        Bestellung bestellung = new Bestellung();
        bestellung.persist();
        k.addBestellung(bestellung);
        return Response.ok().build();
    }

    @POST
    @Transactional
    @RolesAllowed("user")
    @Path("/{index}")
    public Response addPizzaToBestellung(@PathParam("{index}") int index, @QueryParam("name") String name, @QueryParam("menge") int menge){
        Kunde k = kc.getKundeByName(securityIdentity.getPrincipal().getName());
        if(k==null){
            return Response.noContent().build();
        }
        if(index >= k.getBestellungen().size()){
            return Response.noContent().build();
        }
        Pizza p = pc.findPizzaByName(name);
        if(p==null){
            return Response.noContent().build();
        }
        Bestellung b = k.getBestellungen().get(index);
        Bestellposten bestellposten = new Bestellposten(p,menge);
        bestellpostenCatalog.addBestellposte(bestellposten);
        b.addBestellposten(bestellposten);
        b.persist();
        return Response.ok(b).build();
    }

    @PUT
    @Transactional
    @Path("/{index}")
    @RolesAllowed("user")
    public Response editBestellposten(@PathParam("index") int index, @QueryParam("bID") int bID, @QueryParam("menge") int menge){
        Kunde k = kc.getKundeByName(securityIdentity.getPrincipal().getName());
        if(k==null){
            return Response.noContent().build();
        }
        if(index >= k.getBestellungen().size()){
            return Response.noContent().build();
        }
        if(bID >= k.getBestellungen().get(index).getBestellposten().size()){
            return Response.noContent().build();
        }
        Bestellposten bp = k.getBestellungen().get(index).getBestellposten().get(bID);
        bp.setMenge(menge);
        bp.setPreis(bp.getPizza().getPreis()*menge);
        bp.persist();
        return Response.ok(bp).build();
    }


    private List<Bestellung> getKundenBestellung(){
        Kunde k = kc.getKundeByName(securityIdentity.getPrincipal().getName());
        if( k == null){
            k = createKunde();
        }
        List<Bestellung> bestellungs = k.getBestellungen();
        return bestellungs;
    }

    @Transactional
    public Kunde createKunde(){
        Kunde k = new Kunde(securityIdentity.getPrincipal().getName());
        kc.addKunde(k);
        return k;
    }

}

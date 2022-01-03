package org.swa.boundary.html;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import org.swa.bl.catalogs.PizzaCatalog;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pizzen")
@Produces(MediaType.TEXT_HTML)
public class PizzaPage {

    @Inject
    PizzaCatalog pc;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance formpizza();
        public static native TemplateInstance pizzen();
        public static native TemplateInstance pizza();
    }

    @GET
    @PermitAll
    public Response listPizzas(){
        return Response.ok(Templates.pizzen().data("pizzen",pc.listPizzas())).build();
    }

    @GET
    @PermitAll
    @Path("{id}")
    public Response getPizza(@PathParam("id") long id){
        return Response.ok(Templates.pizza().data("pizza",pc.listPizza(id))).build();
    }

    @GET
    @RolesAllowed("admin")
    @Path("add")
    public Response pizzaFormular(){
        return Response.ok().build();
    }

}

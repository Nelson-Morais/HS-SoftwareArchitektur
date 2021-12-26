package org.swa.boundary.rest;


import org.swa.al.pizza.PizzaService;
import org.swa.boundary.DTO.PizzaDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pizza")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class PizzaResource {

    @Inject
    PizzaService pizzaService;

    @GET
    public Response listPizzas(){

        return Response.ok().entity(pizzaService.listPizzas()).build();
    }

    @POST
    @Transactional
    public Response addPizza(@QueryParam("name") String name, @QueryParam("desc") String beschreibung, @QueryParam("preis") long preis){
        pizzaService.addPizza(new PizzaDTO(name,beschreibung,preis));
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePizza(@PathParam("id") long id){
        if(pizzaService.deletePizza(id)){
            return Response.ok().build();
        }
        return Response.notModified().build();
    }

}

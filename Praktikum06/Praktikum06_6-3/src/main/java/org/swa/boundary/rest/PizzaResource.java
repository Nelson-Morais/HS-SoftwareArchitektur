package org.swa.boundary.rest;


import org.swa.al.pizza.PizzaService;
import org.swa.boundary.DTO.PizzaDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pizza")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class PizzaResource {

    @Inject
    PizzaService pizzaService;

    @GET
    public Response listPizzas(){

        return Response.ok().entity(pizzaService.listPizzas()).build();
    }

    @POST
    public Response addPizza(PizzaDTO pizzaDTO){
        pizzaService.addPizza(pizzaDTO);
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

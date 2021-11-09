package org.swa.rest;

import org.swa.al.MocktailController;
import org.swa.bl.Mocktail;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;



@Path("/mocktails")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MocktailResource {

    @Inject
    MocktailController mocktailController;

    @GET
    public Collection<Mocktail> getMocktails(){
        return mocktailController.listMocktails();
    }

    @GET @Path("{id}")
    public Response getMocktailDetails(@PathParam("id")int id){
        Mocktail mocktail = mocktailController.listMocktail(id);
        if (mocktail != null){
            return Response.ok(mocktail).build();
        }else{
            return Response.noContent().build();
        }
    }

    @POST
    public Response submitMocktail(@QueryParam("id") int id,
                                   @QueryParam(""))
}

package org.swa.boundary.rest;
import org.swa.al.MocktailController;
import org.swa.bl.Mocktail;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static javax.ws.rs.core.Response.status;


@Path("/mocktails")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MocktailResource {

    @Inject
    MocktailController mocktailController;

    @GET
    public Collection<Mocktail> getMocktails(){
        return mocktailController.getMocktails();
    }

    @GET @Path("{id}")
    public Response getMocktailDetails(@PathParam("id")final int id){
        Mocktail mocktail = mocktailController.getMocktail(id);
        if (mocktail != null){
            return Response.ok(mocktail).build();
        }else{
            return Response.noContent().build();
        }
    }

    @GET @Path("{name}")
    public Response getMocktailDetails(@PathParam("name")final String name){
        Mocktail mocktail = mocktailController.getMocktail(name);
        if (mocktail != null){
            return Response.ok(mocktail).build();
        }else{
            return Response.noContent().build();
        }
    }

    @POST
    public Response submitMocktail(@QueryParam("id") final int id,
                                   @QueryParam("name")final String name) {

        if(id != 0 && name != null){
            if(mocktailController.addMocktail(id, name)){
                return Response.ok().build();
            }else{
                return Response.notModified().build();
            }
        }
        return status(Response.Status.BAD_REQUEST).build();
    }

    @POST @Path("{id}")
    public Response submitIngredient(@PathParam("id") final int id,
                                     @QueryParam("ingredient") final String ingredient,
                                     @QueryParam("quantity") final int quantity ){
        if(ingredient != null && quantity != 0){
            if(mocktailController.addIngredient(id,ingredient,quantity)){
                return Response.ok().build();
            }else {
                return Response.notModified().build();
            }
        }
        return status(Response.Status.BAD_REQUEST).build();
    }

    @PUT @Path("{id}")
    public Response updateMocktail(@PathParam("id") final int id,
                                   @QueryParam("name") final String name){

        if(name != null){
            if(mocktailController.updateMocktail(id,name)){
                return Response.ok().build();
            }else {
                return Response.notModified().build();
            }
        }
        return status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE @Path("{id}")
    public Response deleteMocktail(@PathParam("id") final int id){
        if(mocktailController.deleteMocktail(id)){
            return Response.ok().build();
        }else{
            return Response.notModified().build();
        }
    }

    @DELETE @Path("{id}/{ingredient}")
    public Response deleteIngredient(@PathParam("id") final int id,
                                     @PathParam("ingredient")String ingredient){
        if(ingredient!= null){
            if(mocktailController.deleteIngredient(id, ingredient)){
                return Response.ok().build();
            }else{
                return Response.notModified().build();
            }
        }
        return status(Response.Status.BAD_REQUEST).build();
    }


    //todo: fragen wo daten verarbeitet werden sollen, controller, Management(service), oder vielleicht ein zwischen klasse zwichen manager und repository in BL ?
    //todo: list übergeben nicht möglich? JSON die lösung ?
    //todo: double DELETE mit path id aber unterschuiedliche QueryParam nicht möglich ?

}

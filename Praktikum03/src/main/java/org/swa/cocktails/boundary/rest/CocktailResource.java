package org.swa.cocktails.boundary.rest;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.swa.cocktails.control.CocktailController;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/cocktails")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CocktailResource {

    private static final Logger LOG = Logger.getLogger(CocktailResource.class);


    @Inject

    CocktailController cocktailController;


    @GET
    @Path("{name}")
    public JsonObject getCocktailByName(@PathParam("name") final String name) {
        LOG.debug(System.currentTimeMillis() + "CocktailResource getCocktailById() started");
        LOG.debug(System.currentTimeMillis() + "CocktailResource getCocktailById() ended");
        return cocktailController.getCocktailByName(name);
    }

    @GET
    @Path("ingredient/{id}")
    public JsonObject getIngredientById(@PathParam("id") final int id) {
        LOG.debug(System.currentTimeMillis() + "CocktailResource getCocktailById() started");
        LOG.debug(System.currentTimeMillis() + "CocktailResource getCocktailById() ended");
        return cocktailController.getIngredientById(id);
    }

    @GET
    @Path("ingredient/{name}")
    public JsonObject getIngredientByName(@PathParam("name") final String name) {
        LOG.debug(System.currentTimeMillis() + "CocktailResource getCocktailById() started");
        LOG.debug(System.currentTimeMillis() + "CocktailResource getCocktailById() ended");
        return cocktailController.getIngredientByName(name);
    }


}

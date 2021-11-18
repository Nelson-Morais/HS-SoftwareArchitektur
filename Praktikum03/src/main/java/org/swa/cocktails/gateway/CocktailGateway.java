package org.swa.cocktails.gateway;

import javax.enterprise.context.Dependent;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v1/1")
@Produces(MediaType.APPLICATION_JSON)
@Dependent
public interface CocktailGateway {

    @GET
    @Path("/search.php")
    JsonObject getCocktailByName(@QueryParam("s")String name);

    @GET
    @Path("/lookup.php")
    JsonObject getIngredientById(@QueryParam("i")int id);

    @GET
    @Path("/search.php")
    JsonObject getIngredientByName(@QueryParam("i")String name);


}

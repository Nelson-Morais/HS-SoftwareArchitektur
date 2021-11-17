package org.mocktails.boundary.rest;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.logging.Logger;
import org.mocktails.al.MocktailController;
import org.mocktails.bl.Mocktail;
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


    private static final Logger LOG = Logger.getLogger(MocktailResource.class);

    @Inject
    MocktailController mocktailController;

    @Retry(maxRetries = 5)
    @Timeout(250)
    @Counted(name = "mocktailListsGiven", description = "how many times the Mocktails were listed.")
    @Timed(name = "mocktailListTimer", description = "how long it takes to retrieve the list", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "get all Mocktails", description = "Returns all the Mocktails in the DB")
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class))))

    @GET
    public Collection<Mocktail> getMocktails(){
        LOG.debug(System.currentTimeMillis() + " MocktailResource getMocktails() started");
        LOG.info("getting mocktails");

        LOG.debug(System.currentTimeMillis() + " MocktailResource getMocktails() ended");
        return mocktailController.getMocktails();
    }

    @Fallback(fallbackMethod = "fallBackMethod")
    @Retry(maxRetries = 5)
    @Timeout(250)
    @Counted(name = "mocktaiDetailId", description = "how many times a Mocktail was listed.")
    @Timed(name = "mocktailIdTimer", description = "how long it takes to retrieve the Mocktail", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "get a Mocktail", description = "Returns the Mocktail matching the ID")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class))),
            @APIResponse(responseCode = "404", description = "Mocktail not found")

    })
    @GET @Path("{id}")
    public Response getMocktailDetails(@PathParam("id")final int id){
        LOG.debug(System.currentTimeMillis() + " MocktailResource getMocktailDetails(int) started");

        Mocktail mocktail = mocktailController.getMocktail(id);

        LOG.info("getting mocktail");
        LOG.debug(System.currentTimeMillis() + " MocktailResource getMocktailDetails(int) ended");
        if (mocktail != null){
            return Response.ok(mocktail).build();
        }else{
            return status(Response.Status.NO_CONTENT).build();
        }
    }

    @Fallback(fallbackMethod = "fallBackMethod")
    @Retry(maxRetries = 5)
    @Timeout(250)
    @Counted(name = "mocktaiDetailName", description = "how many times a Mocktail was listed.")
    @Timed(name = "mocktailNameTimer", description = "how long it takes to retrieve the Mocktail", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "get a Mocktail", description = "Returns the Mocktail matching the name")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mocktail.class))),
            @APIResponse(responseCode = "404", description = "Mocktail not found")

    })
    @GET @Path("{name}")
    public Response getMocktailDetails(@PathParam("name")final String name){
        LOG.debug(System.currentTimeMillis() + " MocktailResource getMocktailDetails(string) started");
        Mocktail mocktail = mocktailController.getMocktail(name);

        LOG.info("getting mocktail");
        LOG.debug(System.currentTimeMillis() + " MocktailResource getMocktailDetails(string) ended");
        if (mocktail != null){
            return Response.ok(mocktail).build();
        }else{
            return status(Response.Status.NO_CONTENT).build();
        }
    }

    @Retry(maxRetries = 5)
    @Timeout(250)
    @Counted(name = "mocktaiSubmition", description = "how many times a Mocktail was added.")
    @Timed(name = "mocktailSubmitionTimer", description = "how long it takes to add the Mocktail", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "submit a Mocktail", description = "Submits a new Mocktail do the DB")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success"),
            @APIResponse(responseCode = "304", description = "Mocktail already exists"),
            @APIResponse(responseCode = "400", description = "Missing parameters")
    })
    @POST
    public Response submitMocktail(@QueryParam("id") final int id,
                                   @QueryParam("name")final String name) {
        LOG.debug(System.currentTimeMillis() + "MocktailResource submitMocktail() started");

        if(id != 0 && name != null){
            LOG.info("submiting Mocktail");
            LOG.debug(System.currentTimeMillis() + "MocktailResource submitMocktail endede");
            if(mocktailController.addMocktail(id, name)){
                return Response.ok().build();
            }else{
                return Response.notModified().build();
            }
        }
        LOG.debug(System.currentTimeMillis() + "MocktailResource submitMocktail endede");
        return status(Response.Status.BAD_REQUEST).build();
    }

    @Retry(maxRetries = 5)
    @Timeout(250)
    @Counted(name = "ingredientSubmition", description = "how many times an Ingredient was added.")
    @Timed(name = "ingredientSubmitionTimer", description = "how long it takes to add an Ingredient", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "submit an Ingredient", description = "Submits a new Ingredient to a Mocktail")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success"),
            @APIResponse(responseCode = "304", description = "Mocktail does not exist"),
            @APIResponse(responseCode = "400", description = "Missing parameters")
    })
    @POST @Path("{id}")
    public Response submitIngredient(@PathParam("id") final int id,
                                     @QueryParam("ingredient") final String ingredient,
                                     @QueryParam("quantity") final int quantity ){

        LOG.debug(System.currentTimeMillis() + "MocktailResource submitIngredient() started");
        if(ingredient != null && quantity != 0){
            LOG.info("adding Ingredient");
            LOG.debug(System.currentTimeMillis() + "MocktailLResource submitIngredient() ended");
            if(mocktailController.addIngredient(id,ingredient,quantity)){
                return Response.ok().build();
            }else {
                return Response.notModified().build();
            }
        }
        LOG.debug(System.currentTimeMillis() + "MocktailLResource submitIngredient() ended");
        return status(Response.Status.BAD_REQUEST).build();
    }

    @Retry(maxRetries = 5)
    @Timeout(250)
    @Counted(name = "mocktailEdit", description = "how many times a Mocktail was edited.")
    @Timed(name = "mocktailEditTimer", description = "how long it takes to edit a Mocktail", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "change a Mocktail", description = "changes a Mocktail in the DB")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success"),
            @APIResponse(responseCode = "304", description = "Mocktail does not exist"),
            @APIResponse(responseCode = "400", description = "Missing parameters")
    })
    @PUT @Path("{id}")
    public Response updateMocktail(@PathParam("id") final int id,
                                   @QueryParam("name") final String name){
        LOG.debug(System.currentTimeMillis() + "MocktailResource updateMocktail() stated");
        if(name != null){
            LOG.info("updating Mocktail");
            LOG.debug(System.currentTimeMillis() + "MocktailResource updateMocktail() ended");
            if(mocktailController.updateMocktail(id,name)){
                return Response.ok().build();
            }else {
                return Response.notModified().build();
            }
        }
        LOG.debug(System.currentTimeMillis() + "MocktailResource updateMocktail() ended");
        return status(Response.Status.BAD_REQUEST).build();
    }

    @Retry(maxRetries = 5)
    @Timeout(250)
    @Counted(name = "mocktailDeletion", description = "how many times a Mocktail was deleted.")
    @Timed(name = "mocktailDeletionTimer", description = "how long it takes to delete a Mocktail", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "deletes a Mocktail", description = "deletes a Mocktail from the DB")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success"),
            @APIResponse(responseCode = "304", description = "Mocktail does not exist")
    })
    @DELETE @Path("{id}")
    public Response deleteMocktail(@PathParam("id") final int id){
        LOG.debug(System.currentTimeMillis() + "MocktailResource deleteMocktail() started");
        LOG.info("deleting Mocktail");
        LOG.debug(System.currentTimeMillis() + "MocktailResource deleteMocktail() ended");
        if(mocktailController.deleteMocktail(id)){
            return Response.ok().build();
        }else{
            return Response.notModified().build();
        }
    }

    @Retry(maxRetries = 5)
    @Timeout(250)
    @Counted(name = "ingredientDeletion", description = "how many times an Ingredient was deleted.")
    @Timed(name = "ingredientDeletionTimer", description = "how long it takes to delete an Ingredient", unit = MetricUnits.MILLISECONDS)
    @Operation(summary = "delete an Ingredient", description = "deletes an Ingredient from a Mocktail on the DB")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success"),
            @APIResponse(responseCode = "304", description = "Mocktail does not exist"),
            @APIResponse(responseCode = "400", description = "Missing parameters")
    })
    @DELETE @Path("{id}/{ingredient}")
    public Response deleteIngredient(@PathParam("id") final int id,
                                     @PathParam("ingredient")String ingredient){
        LOG.debug(System.currentTimeMillis() + "MocktailResouce deleteIngredient() started");
        if(ingredient!= null){
            LOG.info("deleting Ingredient");
            LOG.debug(System.currentTimeMillis() + "MocktailResource deleteIngredient() ended");
            if(mocktailController.deleteIngredient(id, ingredient)){
                return Response.ok().build();
            }else{
                return Response.notModified().build();
            }
        }
        LOG.debug(System.currentTimeMillis() + "MocktailResource deleteIngredient() ended");
        return status(Response.Status.BAD_REQUEST).build();
    }


    private Mocktail fallBackMethod(){

        return (new Mocktail("SugaSugaFallBackBuga"));
    }


    //todo: fragen wo daten verarbeitet werden sollen, controller, Management(service), oder vielleicht ein zwischen klasse zwichen manager und repository in BL ?
    //todo: list übergeben nicht möglich? JSON die lösung ?
    //todo: double DELETE mit path id aber unterschuiedliche QueryParam nicht möglich ?

}

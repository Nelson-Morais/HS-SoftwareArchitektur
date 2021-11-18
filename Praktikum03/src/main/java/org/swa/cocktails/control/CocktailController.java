package org.swa.cocktails.control;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.swa.cocktails.gateway.CocktailGateway;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.json.JsonObject;
import javax.ws.rs.ApplicationPath;

@ApplicationScoped
public class CocktailController {


    @Inject
    @RestClient
    CocktailGateway client;


    public JsonObject getCocktailByName(String name) {
        return client.getCocktailByName(name);
    }


    public JsonObject getIngredientById(int id) {
        return client.getIngredientById(id);
    }


    public JsonObject getIngredientByName(String name) {
        return null;
    }
}

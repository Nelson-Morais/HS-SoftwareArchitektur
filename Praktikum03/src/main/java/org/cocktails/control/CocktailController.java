package org.cocktails.control;

import org.cocktails.gateway.CocktailGateway;

import javax.json.JsonObject;

public class CocktailController implements CocktailGateway {


    @Override
    public JsonObject getCocktailByName(String name) {
        return this.getCocktailByName(name);
    }

    @Override
    public JsonObject getIngredientById(int id) {
        return null;
    }

    @Override
    public JsonObject getIngredientByName(String name) {
        return null;
    }
}

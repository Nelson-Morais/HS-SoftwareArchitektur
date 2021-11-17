package org.mocktails.bl;

import java.util.ArrayList;

public class Mocktail {

    private ArrayList<Ingredient> ingredients;
    String name;

    public Mocktail(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients){
        this.ingredients = ingredients;

    }

}

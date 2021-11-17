package org.mocktails.al;

import org.mocktails.bl.Ingredient;
import org.mocktails.bl.Catalog;
import org.mocktails.bl.Mocktail;
import org.mocktails.dal.MocktailRepository;

import java.util.ArrayList;
import java.util.Collection;

public class MocktailManagement {

    Catalog catalog = new MocktailRepository();

    Mocktail getMocktail(String name) {
        return catalog.searchMocktail(name);
    }

    Mocktail getMocktail(int id) {
        return catalog.searchMocktail(id);
    }

    Collection<Mocktail> getMocktails() {
        return catalog.listMocktails();
    }

    void addMocktail(int id, String name) {
        catalog.addMocktail(id, new Mocktail(name));
    }

    void addIngredient(int id, String ingredient, int quantity){
        getMocktail(id).getIngredients().add(new Ingredient(ingredient, quantity));
    }

    Mocktail deleteMocktail(int id) {
        return catalog.deleteMocktail(id);
    }

    boolean updateMocktail(int id, String name) {
        Mocktail mocktail = new Mocktail(name);
        mocktail.setIngredients(getMocktail(id).getIngredients());
        return catalog.updateMocktail(id, mocktail);
    }

    boolean deleteIngredient(int id, String ingredient){
        ArrayList<Ingredient> tmpArr = getMocktail(id).getIngredients();

        for(Ingredient el : tmpArr){
            if(el.getName().equals(ingredient)){
                tmpArr.remove(el);
                return true;
            }
        }
        return false;
    }

}

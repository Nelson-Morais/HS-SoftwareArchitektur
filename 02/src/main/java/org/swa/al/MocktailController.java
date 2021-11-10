package org.swa.al;

import org.swa.bl.Ingredient;
import org.swa.bl.Mocktail;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;



@Singleton

public class MocktailController implements MocktailList, MocktailEdit, MocktailSubmit {

    MocktailManagement mocktailManagement = new MocktailManagement();

    @Override
    public Mocktail listMocktail(int id) {
        return mocktailManagement.searchMocktail(id);
    }

    @Override
    public Mocktail listMocktail(String name) {
        return mocktailManagement.searchMocktail(name);
    }

    @Override
    public Collection<Mocktail> listMocktails() {
        return mocktailManagement.listMocktails();
    }

    @Override
    public void addMocktail(int id, String name )  {

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        Mocktail mocktail = new Mocktail(name,ingredients);

        mocktailManagement.addMocktail(id,mocktail);
    }

    @Override
    public void deleteMocktail(int id) {
        mocktailManagement.deleteMocktail(id);
    }

    @Override
    public void updateMocktail(int id, Mocktail mocktail) {
        mocktailManagement.updateMocktail(id, mocktail);
    }
}

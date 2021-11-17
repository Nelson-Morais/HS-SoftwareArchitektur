package org.swa.al;

import org.swa.bl.Mocktail;

import javax.inject.Singleton;
import java.util.Collection;

@Singleton
public class MocktailController implements MocktailList, MocktailEdit, MocktailSubmit {

    MocktailManagement mocktailManagement = new MocktailManagement();

    @Override
    public Mocktail getMocktail(int id) {
        return mocktailManagement.getMocktail(id);
    }

    @Override
    public Mocktail getMocktail(String name) {
        return mocktailManagement.getMocktail(name);
    }

    @Override
    public Collection<Mocktail> getMocktails() {
        return mocktailManagement.getMocktails();
    }

    @Override
    public boolean addMocktail(int id, String name) {
        if (getMocktail(id) == null) {
            mocktailManagement.addMocktail(id, name);
            return true;
        }
        return false;
    }

    @Override
    public boolean addIngredient(int id, String ingredient, int quantity) {
        if (getMocktail(id) != null) {
            mocktailManagement.addIngredient(id, ingredient, quantity);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMocktail(int id, String name) {
        if (getMocktail(id) != null) {
            return mocktailManagement.updateMocktail(id, name);
        }
        return false;
    }

    @Override
    public boolean deleteMocktail(int id) {
        return mocktailManagement.deleteMocktail(id) != null;
    }

    @Override
    public boolean deleteIngredient(int id, String ingredient) {
        if(getMocktail(id) != null) {
            return mocktailManagement.deleteIngredient(id, ingredient);
        }
        return false;
    }


}

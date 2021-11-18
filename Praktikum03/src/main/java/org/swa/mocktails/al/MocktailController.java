package org.swa.mocktails.al;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.swa.mocktails.bl.Mocktail;

import javax.inject.Singleton;
import java.util.Collection;

@Singleton
public class MocktailController implements MocktailList, MocktailEdit, MocktailSubmit {

    MocktailManagement mocktailManagement = new MocktailManagement();

    @Override
    @CircuitBreaker(requestVolumeThreshold = 4)
    public Mocktail getMocktail(int id) {
        return mocktailManagement.getMocktail(id);
    }

    @Override
    @CircuitBreaker(requestVolumeThreshold = 4)
    public Mocktail getMocktail(String name) {
        return mocktailManagement.getMocktail(name);
    }

    @Override
    @CircuitBreaker(requestVolumeThreshold = 4)
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

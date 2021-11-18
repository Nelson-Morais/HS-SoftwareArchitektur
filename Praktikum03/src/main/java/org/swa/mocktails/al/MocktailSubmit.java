package org.swa.mocktails.al;

public interface MocktailSubmit {
    boolean addMocktail(int id, String name );
    boolean addIngredient(int id, String ingredient, int quantity );
}



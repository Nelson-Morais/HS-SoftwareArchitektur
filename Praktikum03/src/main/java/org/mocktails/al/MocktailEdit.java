package org.mocktails.al;


public interface MocktailEdit {
    boolean updateMocktail(int id, String name);
    boolean deleteMocktail(int id);
    boolean deleteIngredient(int id, String ingredient);
}

package org.swa.bl;

import java.util.Collection;

public interface Katalog {


    Mocktail searchMocktail(String name);
    Mocktail searchMocktail(int id);
    Collection<Mocktail> listMocktails();
    Mocktail deleteMocktail(int id);
    void addMocktail(int id, Mocktail mocktail);
    boolean updateMocktail(int id, Mocktail mocktail);


}

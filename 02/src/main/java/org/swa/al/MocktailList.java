package org.swa.al;

import org.swa.bl.Mocktail;

import java.util.Collection;

public interface MocktailList {

    Collection<Mocktail> listMocktails();

    Mocktail listMocktail(int id);

    Mocktail listMocktail(String name);

}

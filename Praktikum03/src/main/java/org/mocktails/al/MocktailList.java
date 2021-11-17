package org.mocktails.al;
import org.mocktails.bl.Mocktail;
import java.util.Collection;

public interface MocktailList {

    Collection<Mocktail> getMocktails();
    Mocktail getMocktail(int id);
    Mocktail getMocktail(String name);

}

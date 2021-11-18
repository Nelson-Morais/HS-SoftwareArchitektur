package org.swa.mocktails.al;
import org.swa.mocktails.bl.Mocktail;
import java.util.Collection;

public interface MocktailList {

    Collection<Mocktail> getMocktails();
    Mocktail getMocktail(int id);
    Mocktail getMocktail(String name);

}

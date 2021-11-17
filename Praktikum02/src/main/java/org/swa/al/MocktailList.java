package org.swa.al;
import org.swa.bl.Mocktail;
import java.util.Collection;

public interface MocktailList {

    Collection<Mocktail> getMocktails();
    Mocktail getMocktail(int id);
    Mocktail getMocktail(String name);

}

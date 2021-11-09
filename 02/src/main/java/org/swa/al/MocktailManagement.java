package org.swa.al;

import org.swa.bl.Katalog;
import org.swa.bl.Mocktail;
import org.swa.dal.MockTailRepository;

import java.util.Collection;

public class MocktailManagement {

    Katalog katalog = new MockTailRepository();

    Mocktail searchMocktail(String name) {
        return katalog.searchMocktail(name);
    }

    Mocktail searchMocktail(int id) {
        return katalog.searchMocktail(id);
    }

    Collection<Mocktail> listMocktails() {
        return katalog.listMocktails();
    }

    Mocktail deleteMocktail(int id) {
        return katalog.deleteMocktail(id);
    }

    void addMocktail(int id, Mocktail mocktail) {
        katalog.addMocktail(id, mocktail);
    }

    boolean updateMocktail(int id, Mocktail mocktail) {
        return katalog.updateMocktail(id, mocktail);
    }

}

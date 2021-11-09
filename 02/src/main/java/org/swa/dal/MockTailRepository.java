package org.swa.dal;

import org.swa.bl.Mocktail;
import org.swa.bl.Katalog;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MockTailRepository implements Katalog, Serializable {

    private final Map<Integer, Mocktail> mocktails = new ConcurrentHashMap<>();


    @Override
    public Mocktail searchMocktail(String name) {

        for (Mocktail object : mocktails.values()) {
            if (object.getName().equals(name)) {
                return object;
            }
        }
        return null;
    }

    @Override
    public Mocktail searchMocktail(int id) {
        if (mocktails.get(id) != null) {
            return mocktails.get(id);
        } else {
            return null;
        }

    }

    @Override
    public Collection<Mocktail> listMocktails() {
        return mocktails.values();
    }


    @Override
    public Mocktail deleteMocktail(int id) {
        //returns the value if successful or null if not.
        return mocktails.remove(id);

    }

    @Override
    public void addMocktail(int id, Mocktail mocktail) {
        mocktails.put(id, mocktail);
    }

    @Override
    public boolean updateMocktail(int id, Mocktail mocktail) {
        //returns true if value was replaced
        return mocktails.replace(id, mocktails.get(id), mocktail);
    }
}

package org.swa.bl.catalogs;

import org.swa.bl.entity.Bestellposten;

import java.util.Collection;

public interface BestellpostenCatalog {

    Collection<Bestellposten> listBestellposten();
    Bestellposten listBestellposte(long BestellpostenId);
    void addBestellposte(Bestellposten bestellposten);
    void deleteBestellposten(long BestellpostenId);
}

package org.swa.bl.catalogs;

import org.swa.bl.entity.Bestellung;

import java.util.Collection;

public interface BestellungCatalog {

    Collection<Bestellung> listBestellungen();
    Bestellung listBestellung(long BestellungId);
    void addBestellung(Bestellung bestellung);
    void deleteBestellung(long BestellungId);

}

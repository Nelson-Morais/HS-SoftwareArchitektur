package org.swa.bl.catalogs;

import org.swa.bl.entity.Bestellung;
import org.swa.bl.entity.Kunde;

import java.util.Collection;

public interface BestellungCatalog {

    Collection<Bestellung> listBestellungen();
    Bestellung listBestellung(long BestellungId);
    void addBestellung(Kunde k);
    void deleteBestellung(long BestellungId);

}

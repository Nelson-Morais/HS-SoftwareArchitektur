package org.swa.bl.catalogs;

import org.swa.bl.entity.Kunde;

import java.util.Collection;

public interface KundenCatalog {

    Collection<Kunde> listKunden();
    Kunde listKunde(long kundennumer);
    void addKunde(Kunde kunde);
    void deleteKunde(long kundennummer);
}

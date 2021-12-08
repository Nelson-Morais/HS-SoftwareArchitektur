package org.swa.bl.catalogs;

import org.swa.bl.entity.Kunde;

import java.util.List;

public interface KundenCatalog {

    List<Kunde> listKunden();
    Kunde getKunde(long kundennumer);
    void addKunde(Kunde kunde);
    boolean deleteKunde(long kundennummer);
}

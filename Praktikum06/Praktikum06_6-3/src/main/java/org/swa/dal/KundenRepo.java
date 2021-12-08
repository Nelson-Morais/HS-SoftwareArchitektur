package org.swa.dal;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.swa.bl.catalogs.KundenCatalog;
import org.swa.bl.entity.Kunde;

import java.util.Collection;

public class KundenRepo implements KundenCatalog, PanacheRepository<Kunde> {


    @Override
    public Collection<Kunde> listKunden() {
        return listAll();
    }

    @Override
    public Kunde listKunde(long kundennumer) {
        return listKunde(kundennumer);
    }

    @Override
    public void addKunde(Kunde kunde) {
        kunde.persist();
    }

    @Override
    public void deleteKunde(long kundennummer) {
        deleteById(kundennummer);
    }
}

package org.swa.dal;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.swa.bl.catalogs.KundenCatalog;
import org.swa.bl.entity.Kunde;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class KundenRepo implements KundenCatalog, PanacheRepository<Kunde> {


    @Override
    public List<Kunde> listKunden() {
        return listAll();
    }

    @Override
    public Kunde getKunde(long kundennumer) {
        return getKunde(kundennumer);
    }


    @Override
    public void addKunde(Kunde kunde) {
        kunde.persist();
    }

    @Override
    public boolean deleteKunde(long kundennummer) {
        return deleteById(kundennummer);
    }


    @Override
    public Kunde getKundeByName(String name) {
        return find("username",name).firstResult();
    }
}

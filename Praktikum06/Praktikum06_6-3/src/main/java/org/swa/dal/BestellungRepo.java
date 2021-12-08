package org.swa.dal;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.swa.bl.catalogs.BestellungCatalog;
import org.swa.bl.entity.Bestellung;

import javax.enterprise.context.RequestScoped;
import java.util.Collection;

@RequestScoped
public class BestellungRepo implements BestellungCatalog, PanacheRepository<Bestellung> {

    @Override
    public Collection<Bestellung> listBestellungen() {
        return listAll();
    }

    @Override
    public Bestellung listBestellung(long BestellungId) {
        return findById(BestellungId);
    }

    @Override
    public void addBestellung(Bestellung bestellung) {
        bestellung.persist();
    }

    @Override
    public void deleteBestellung(long BestellungId) {
        deleteById(BestellungId);
    }
}

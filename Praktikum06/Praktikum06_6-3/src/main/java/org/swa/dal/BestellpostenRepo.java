package org.swa.dal;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.swa.bl.catalogs.BestellpostenCatalog;
import org.swa.bl.entity.Bestellposten;

import javax.enterprise.context.RequestScoped;
import java.util.Collection;

@RequestScoped
public class BestellpostenRepo implements BestellpostenCatalog, PanacheRepository<Bestellposten> {


    @Override
    public Collection<Bestellposten> listBestellposten() {
        return listAll();
    }

    @Override
    public Bestellposten listBestellposte(long BestellpostenId) {
        return findById(BestellpostenId);
    }

    @Override
    public void addBestellposte(Bestellposten bestellposten) {
        bestellposten.persist();
    }

    @Override
    public void deleteBestellposten(long BestellpostenId) {
        deleteById(BestellpostenId);

    }
}

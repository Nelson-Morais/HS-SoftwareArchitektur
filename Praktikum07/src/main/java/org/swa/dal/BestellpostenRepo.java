package org.swa.dal;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.jboss.logging.Logger;
import org.swa.bl.catalogs.BestellpostenCatalog;
import org.swa.bl.entity.Bestellposten;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;

@RequestScoped
public class BestellpostenRepo implements BestellpostenCatalog, PanacheRepository<Bestellposten> {


    @Inject
    Logger log;

    @Override
    public Collection<Bestellposten> listBestellposten() {
        return listAll();
    }

    @Override
    public Bestellposten listBestellposte(long BestellpostenId) {
        return findById(BestellpostenId);
    }

    @Transactional
    @Override
    public void addBestellposte(Bestellposten bestellposten) {
        bestellposten.getPizza().persist();
        bestellposten.persist();
        log.info(bestellposten.getMenge());
    }
    @Transactional
    @Override
    public boolean deleteBestellposten(long BestellpostenId) {
       return deleteById(BestellpostenId);

    }
}

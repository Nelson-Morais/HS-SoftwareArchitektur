package org.swa.al.bestellposten;

import org.jboss.logging.Logger;
import org.swa.bl.catalogs.BestellpostenCatalog;
import org.swa.bl.entity.Bestellposten;
import org.swa.boundary.DTO.BestellpostenDTO;
import org.swa.dal.BestellpostenRepo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@RequestScoped
public class BestellpostenService implements AddBestellposten, ListBestellposten, ModifyBestellposten{

    @Inject
    BestellpostenCatalog bestellpostenRepo;

    @Inject
    Logger Log;

    @Override
    public void addBestellposten(Bestellposten bestellposten) {

        bestellpostenRepo.addBestellposte(bestellposten);
    }

    @Override
    public Collection<Bestellposten> listBestellposten(long id) {
        return bestellpostenRepo.listBestellposten();
    }

    @Override
    public Bestellposten getBestellposten(long id) {
        return bestellpostenRepo.listBestellposte(id);
    }

    @Override
    public boolean deleteBestellposten(long id) {
        return bestellpostenRepo.deleteBestellposten(id);
    }
}

package org.swa.al.bestellposten;

import org.jboss.logging.Logger;
import org.swa.bl.entity.Bestellposten;
import org.swa.boundary.DTO.BestellpostenDTO;
import org.swa.dal.BestellpostenRepo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@RequestScoped
public class BestellpostenService implements AddBestellposten, ListBestellposten, ModifyBestellposten{

    @Inject
    BestellpostenRepo bestellpostenRepo;

    @Inject
    Logger Log;

    @Override
    public void addBestellposten(BestellpostenDTO bestellpostenDTO) {

        bestellpostenRepo.addBestellposte(BestellpostenDTO.BestellpostenConverter.toBestellposten(bestellpostenDTO));
    }

    @Override
    public Collection<Bestellposten> listBestellposten(long id) {
        return bestellpostenRepo.listAll();
    }

    @Override
    public Bestellposten getBestellposten(long id) {
        return bestellpostenRepo.findById(id);
    }

    @Override
    public boolean deleteBestellposten(long id) {
        return bestellpostenRepo.deleteBestellposten(id);
    }
}

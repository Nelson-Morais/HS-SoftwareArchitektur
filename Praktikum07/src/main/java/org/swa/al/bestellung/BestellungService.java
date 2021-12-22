package org.swa.al.bestellung;

import org.swa.bl.catalogs.BestellungCatalog;
import org.swa.bl.entity.Bestellung;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class BestellungService implements AddBestellung, ListBestellung{


    @Inject
    BestellungCatalog bestellungCatalog;


    @Override
    public void addBestellung(Bestellung bestellung) {
        bestellungCatalog.addBestellung(bestellung);
    }

    @Override
    public Bestellung getBestellung(long id) {
        return bestellungCatalog.listBestellung(id);
    }
}

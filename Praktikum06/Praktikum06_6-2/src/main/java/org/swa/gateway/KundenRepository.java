package org.swa.gateway;


import org.swa.control.KundenService;
import org.swa.entity.Adresse;
import org.swa.entity.Kunde;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class KundenRepository implements KundenService {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public void kundenAnlegen(String name) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList(name.split(",")));
        Kunde kunde;
        if (names.size() != 2) {
            kunde = new Kunde("John", "Doe");
        } else {
            kunde = new Kunde(names.get(0), names.get(1));
        }
        entityManager.persist(kunde);
    }

    @Override
    public List kundenAbfragen() {
        return entityManager.createQuery( "from Kunde").getResultList();
    }

    @Override
    public Kunde kundeAbfragen(long kundennr) {
        return entityManager.find(Kunde.class, kundennr);
    }

    @Override
    public boolean kundenLoeschen(long kundennr) {
        Kunde kunde =kundeAbfragen(kundennr);
        if(kunde != null){
            entityManager.remove(kunde);
            return true;
        }
        return false;
    }

    @Override
    public void adresseAnlegen(long kundennr, Adresse adresse) {
        Kunde kunde = kundeAbfragen(kundennr);
        if(kunde != null && kunde.getAdresse() == null){
            kunde.setAdresse(adresse);
        }
    }

    @Override
    public void adresseAendern(long kundennr, Adresse adresse) {
        Kunde kunde = kundeAbfragen(kundennr);
        if(kunde != null){
            kunde.setAdresse(adresse);
        }
    }

    @Override
    public Adresse adresseAbfragen(long kundennr) {
        return kundeAbfragen(kundennr).getAdresse();
    }

    @Override
    public boolean adresseLoeschen(long kundennr) {
        Kunde kunde = kundeAbfragen(kundennr);
        if(kunde != null && kunde.getAdresse() != null){
            kundeAbfragen(kundennr).setAdresse(null);
            return true;
        }
        return false;
    }
}

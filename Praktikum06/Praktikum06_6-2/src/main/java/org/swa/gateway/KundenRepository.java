package org.swa.gateway;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.swa.control.KundenService;
import org.swa.entity.Adresse;
import org.swa.entity.Kunde;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestScoped
public class KundenRepository implements KundenService {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public void kundenAnlegen(String name) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList(name.split(",")));
        Kunde kunde;
        if (names.size() == 2) {

            kunde = new Kunde(names.get(0), names.get(1));
            entityManager.persist(kunde);
        }

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
    @Transactional
    public boolean kundenLoeschen(long kundennr) {
        Kunde kunde =kundeAbfragen(kundennr);
        if(kunde != null){
            entityManager.remove(kunde);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void adresseAnlegen(long kundennr, Adresse adresse) {
        Kunde kunde = kundeAbfragen(kundennr);
        if(kunde != null && kunde.getAdresse() == null){
            kunde.setAdresse(adresse);
        }
    }

    @Override
    @Transactional
    public void adresseAendern(long kundennr, Adresse adresse) {
        Kunde kunde = kundeAbfragen(kundennr);
        if(kunde != null){
            kunde.setAdresse(adresse);
        }
    }

    @Override
    public Adresse adresseAbfragen(long kundennr) {
        Kunde kunde = kundeAbfragen(kundennr);
        if(kunde != null){

            return kundeAbfragen(kundennr).getAdresse();
        }
        return null;
    }

    @Override
    @Transactional
    public boolean adresseLoeschen(long kundennr) {
        Kunde kunde = kundeAbfragen(kundennr);
        if(kunde != null && kunde.getAdresse() != null){
            kundeAbfragen(kundennr).setAdresse(null);
            return true;
        }
        return false;
    }
}

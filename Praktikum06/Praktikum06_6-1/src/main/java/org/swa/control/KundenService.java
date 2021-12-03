package org.swa.control;


import org.swa.entity.Adresse;
import org.swa.entity.Kunde;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class KundenService {

    Map<Long, Kunde> kunden = new ConcurrentHashMap<>();
    private static long kundennr = 1;

    public void kundenAnlegen(String name) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList(name.split(",")));
        if (names.size() == 2) {
            kunden.put(kundennr, new Kunde(kundennr, names.get(0), names.get(1)));
            kundennr++;
        }
    }

    public Collection<Kunde> kundenAbfragen() {
        return kunden.values();
    }

    public Kunde kundeAbfragen(long kundennr) {
        return kunden.get(kundennr);
    }

    public boolean kundenLoeschen(long kundennr) {
        return kunden.remove(kundennr) != null;
    }

    public void adresseAnlegen(long kundennr, Adresse adresse) {

        Kunde kunde = kundeAbfragen(kundennr);
        if(kunde != null){

            kunden.get(kundennr).setAdresse(adresse);
        }

    }

    public void adresseAendern(long kundennr, Adresse adresse) {
        Kunde kunde = kundeAbfragen(kundennr);
        if(kunde != null){

            kunden.get(kundennr).setAdresse(adresse);
        }
    }

    public Adresse adresseAbfragen(long kundennr) {
        Kunde kunde = kundeAbfragen(kundennr);
        if(kunde != null){

            return kunde.getAdresse();
        }
        return null;
    }

    public boolean adresseLoeschen(long kundennr) {
        if (kundeAbfragen(kundennr) != null){
            kunden.get(kundennr).setAdresse(null);
            return true;
        }
        return false;
    }

}

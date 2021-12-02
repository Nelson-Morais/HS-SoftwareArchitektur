package org.swa.control;


import org.swa.entity.Adresse;
import org.swa.entity.Kunde;

import javax.enterprise.context.ApplicationScoped;
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
        if (names.size() != 2) {
            kunden.put(kundennr++, new Kunde("John", "Doe"));
        } else {
            kunden.put(kundennr++, new Kunde(names.get(0), names.get(1)));
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
        if (kunden.get(kundennr).getAdresse() == null) {
            kunden.get(kundennr).setAdresse(adresse);
        }
    }

    public void adresseAendern(long kundennr, Adresse adresse) {
        kunden.get(kundennr).setAdresse(adresse);
    }

    public Adresse adresseAbfragen(long kundennr) {

        return kunden.get(kundennr).getAdresse();
    }

    public boolean adresseLoeschen(long kundennr) {
        if (kunden.get(kundennr).getAdresse() != null) {
            kunden.get(kundennr).setAdresse(null);
            return true;
        }
        return false;
    }

}

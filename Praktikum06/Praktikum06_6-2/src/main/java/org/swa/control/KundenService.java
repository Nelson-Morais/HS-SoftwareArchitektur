package org.swa.control;


import org.swa.entity.Adresse;
import org.swa.entity.Kunde;

import java.util.Collection;


public interface KundenService {

    void kundenAnlegen(String name);

    Collection<Kunde> kundenAbfragen();

    Kunde kundeAbfragen(long kundennr);

    boolean kundenLoeschen(long kundennr);

    void adresseAnlegen(long kundennr, Adresse adresse);

    void adresseAendern(long kundennr, Adresse adresse);

    Adresse adresseAbfragen(long kundennr);

    boolean adresseLoeschen(long kundennr);

}

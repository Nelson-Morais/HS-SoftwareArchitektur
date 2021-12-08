package org.swa.al.kunden;

import org.swa.bl.entity.Kunde;

import java.util.List;

public interface ListKunden {

    List<Kunde> listKunden();
    Kunde getKunde(long kundennummer);
}

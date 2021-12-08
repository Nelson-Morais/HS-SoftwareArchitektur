package org.swa.al.kunden;

import org.swa.bl.entity.Adresse;

public interface ModifyKunden {
    boolean addAdresse(long kundennummer, Adresse adresse);
    boolean deleteKunde(long kundennummer);
}

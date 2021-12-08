package org.swa.al.kunden;

import org.swa.al.bestellung.ListBestellung;
import org.swa.bl.catalogs.KundenCatalog;
import org.swa.bl.entity.Adresse;
import org.swa.bl.entity.Kunde;
import org.swa.boundary.DTO.KundeDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class KundenService implements AddKunden, ListKunden, ModifyKunden {


    @Inject
    KundenCatalog kundenCatalog;

    @Override
    public void addKunde(KundeDTO kundeDTO) {
        kundenCatalog.addKunde(KundeDTO.ConverterKundeDTO.toKunde(kundeDTO));
    }

    @Override
    public List<Kunde> listKunden() {
        return kundenCatalog.listKunden();
    }

    @Override
    public Kunde getKunde(long kundennummer) {
        return kundenCatalog.getKunde(kundennummer);
    }

    @Override
    public boolean addAdresse(long kundennummer, Adresse adresse) {
        Kunde kunde =  getKunde(kundennummer);
        if(kunde != null){

            kunde.setAdresse(adresse);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteKunde(long kundennummer) {
        return kundenCatalog.deleteKunde(kundennummer);
    }
}

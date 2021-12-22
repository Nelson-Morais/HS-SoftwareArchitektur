package org.swa.boundary.DTO;

import org.swa.bl.entity.Adresse;
import org.swa.bl.entity.Kunde;

public class KundeDTO {

    private String vorname;
    private String nachname;

    public KundeDTO(){}

    public KundeDTO(String vorname, String nachname){

    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }


    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public static class ConverterKundeDTO{

        public static KundeDTO toDTO(Kunde kunde){
            return new KundeDTO(kunde.getVorname(), kunde.getVorname());
        }

        public static Kunde toKunde(KundeDTO kundeDTO){
            return new Kunde(kundeDTO.getVorname(),kundeDTO.getNachname());
        }
    }
}

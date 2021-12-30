package org.swa.boundary.DTO;

import org.swa.bl.entity.Adresse;
import org.swa.bl.entity.Kunde;

public class KundeDTO {

    private String name;


    public KundeDTO(){}

    public KundeDTO(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String vorname) {
        this.name = vorname;
    }

    public static class ConverterKundeDTO{

        public static KundeDTO toDTO(Kunde kunde){
            return new KundeDTO(kunde.getUsername());
        }

        public static Kunde toKunde(KundeDTO kundeDTO){
            return new Kunde(kundeDTO.getName());
        }
    }
}

package org.swa.bl.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

    private String strasse;
    private String hausNummer;
    private String ort;
    private String plz;

    public Adresse(){}

    public Adresse(String strasse, String hausNummer, String ort, String plz){
        setHausNummer(hausNummer);
        setOrt(ort);
        setPlz(plz);
        setStrasse(strasse);
    }

    public String getStrasse() {
        return strasse;
    }

    public String getPlz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }

    public String getHausNummer() {
        return hausNummer;
    }


    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public void setHausNummer(String hausNummer) {
        this.hausNummer = hausNummer;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}

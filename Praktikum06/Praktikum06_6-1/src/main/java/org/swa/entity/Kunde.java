package org.swa.entity;

import javax.enterprise.context.Dependent;

@Dependent
public class Kunde {

    private String vorname;
    private String nachname;
    private Adresse adresse;

    public Kunde(){}

    public Kunde(String vorname, String nachname){
        setVorname(vorname);
        setNachname(nachname);
        adresse = null;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public Adresse getAdresse() {
        return adresse;
    }


}

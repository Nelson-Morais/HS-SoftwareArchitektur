package org.swa.entity;

import javax.enterprise.context.Dependent;

@Dependent
public class Kunde {

    private String vorname;
    private String nachname;
    private Adresse adresse;
    private long id;

    public Kunde(){}

    public Kunde(long id, String vorname, String nachname){
        setVorname(vorname);
        setNachname(nachname);
        setId(id);
        adresse = new Adresse();
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

    public void setId(long id) {
        this.id = id;
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

    public long getId() {
        return id;
    }
}

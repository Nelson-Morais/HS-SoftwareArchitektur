package org.swa.entity;

import org.hibernate.annotations.Cache;

import javax.enterprise.context.Dependent;
import javax.persistence.*;

@Dependent
@Entity
public class Kunde {

    private String vorname;
    private String nachname;

    private Adresse adresse;
    private Long id;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="adress", nullable = true)
    public Adresse getAdresse() {
        return adresse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}

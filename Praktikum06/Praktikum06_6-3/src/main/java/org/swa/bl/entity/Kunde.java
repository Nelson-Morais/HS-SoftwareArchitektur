package org.swa.bl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Kunde extends PanacheEntityBase {

    private long kundennummer;
    private String vorname;
    private String nachname;

    @Embedded
    private Adresse adresse;


    private List<Bestellung> bestellungen;


    public Kunde(){
        bestellungen = new ArrayList<>();
    }

    public Kunde(String vorname, String nachname){
        setVorname(vorname);
        setNachname(nachname);
    }



    @Id
    @SequenceGenerator(
            name = "kundenNummer",
            sequenceName = "kundenNummer_id_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kundenNummer")
    public long getKundennummer() {
        return kundennummer;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    @OneToMany(targetEntity = Bestellung.class, fetch = FetchType.EAGER)

    public List<Bestellung> getBestellungen() {
        return bestellungen;
    }


    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setBestellungen(List<Bestellung> bestellungen) {
        this.bestellungen = bestellungen;
    }
}

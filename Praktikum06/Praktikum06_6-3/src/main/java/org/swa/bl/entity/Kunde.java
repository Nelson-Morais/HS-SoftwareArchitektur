package org.swa.bl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Kunde extends PanacheEntity {

    private long kundennummer;
    @Embedded
    private Adresse adresse;
    @OneToMany
    private Collection<Bestellung> bestellungen;


    public Kunde(){
        bestellungen = new ArrayList<>();
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

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
    }

    public Adresse getAdresse() {
        return adresse;
    }


    public Collection<Bestellung> getBestellungen() {
        return bestellungen;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setBestellungen(Collection<Bestellung> bestellungen) {
        this.bestellungen = bestellungen;
    }
}

package org.swa.bl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Bestellung extends PanacheEntity {


    private long bestellungID;
    @OneToMany
    private Collection<Bestellposten> bestellposten;


    public Bestellung(){}


    @Id
    @SequenceGenerator(
            name = "bestellNummer",
            sequenceName = "bestellnummer_id_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bestellNummer")
    public long getBestellungID() {
        return bestellungID;
    }

    public Collection<Bestellposten> getBestellposten() {
        return bestellposten;
    }

    public void setBestellungID(long bestellungID) {
        this.bestellungID = bestellungID;
    }

    public void setBestellposten(Collection<Bestellposten> bestellposten) {
        this.bestellposten = bestellposten;
    }
}

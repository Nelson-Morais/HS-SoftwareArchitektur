package org.swa.bl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Bestellung extends PanacheEntityBase {


    private long bestellungID;


    private List<Bestellposten> bestellposten;


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

    @OneToMany(targetEntity = Bestellposten.class, fetch = FetchType.EAGER)
    public List<Bestellposten> getBestellposten() {
        return bestellposten;
    }

    public void setBestellungID(long bestellungID) {
        this.bestellungID = bestellungID;
    }

    public void setBestellposten(List<Bestellposten> bestellposten) {
        this.bestellposten = bestellposten;
    }
}

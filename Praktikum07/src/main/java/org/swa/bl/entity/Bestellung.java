package org.swa.bl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Bestellung extends PanacheEntityBase {


    private long bestellungID;

    @OneToMany
    private List<Bestellposten> bestellposten;

    private long gesamtpreis = 0;


    public Bestellung(){
        bestellposten = new ArrayList<>();
    }



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
        calculatePreis();
    }

    public void addBestellposten(Bestellposten bestellposten){
        this.bestellposten.add(bestellposten);
        calculatePreis();
    }

    private void calculatePreis(){
        gesamtpreis = 0;
        for(int i = 0; i < getBestellposten().size(); i++){
            gesamtpreis += getBestellposten().get(i).getPreis();
        }
    }

    public long getGesamtpreis() {
        return gesamtpreis;
    }

    public void setGesamtpreis(long gesamtpreis) {
        this.gesamtpreis = gesamtpreis;
    }
}

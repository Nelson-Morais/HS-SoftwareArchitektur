package org.swa.bl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class Bestellposten extends PanacheEntityBase {

    private long BestellpostenID;

    private Pizza pizza;
    private int menge;

    public Bestellposten(){}

    public Bestellposten(Pizza pizza, int menge){
        setMenge(menge);
        setPizza(pizza);
    }

    public int getMenge() {
        return menge;
    }

    @ManyToOne
    public Pizza getPizza() {
        return pizza;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Id
    @SequenceGenerator(
            name = "bestellpostenNummer",
            sequenceName = "bestellpostenNummer_id_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bestellpostenNummer")
    public long getBestellpostenID() {
        return BestellpostenID;
    }

    public void setBestellpostenID(long bestellpostenID) {
        BestellpostenID = bestellpostenID;
    }
}

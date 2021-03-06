package org.swa.bl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class Pizza extends PanacheEntityBase {

    private long id;
    private String name;
    private String beschreibung;

    public Pizza(){}

    public Pizza(String name, String beschreibung){
        setBeschreibung(beschreibung);
        setName(name);
    }

    @Id
    @SequenceGenerator(
            name = "pizzaSequence",
            sequenceName = "pizza_id_sequence",
            allocationSize = 1,
            initialValue = 1

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizzaSequence")
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}

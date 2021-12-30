package org.swa.bl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Kunde extends PanacheEntityBase {

    private long kundennummer;
    private String username;


    @Embedded
    private Adresse adresse;

    @OneToMany
    private List<Bestellung> bestellungen;


    public Kunde(){
        bestellungen = new ArrayList<>();
    }

    public Kunde(String name){
        setUsername(name);

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


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void addBestellung(Bestellung bestellungen) {
        this.bestellungen.add(bestellungen);
    }
}

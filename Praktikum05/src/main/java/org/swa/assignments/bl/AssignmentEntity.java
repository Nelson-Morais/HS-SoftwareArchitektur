package org.swa.assignments.bl;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URI;
import java.time.LocalDate;

@Entity
public class AssignmentEntity{

    @Id
    @GeneratedValue private long id;
    private String description;
    private LocalDate date;
    private URI ship;


    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public URI getShip() {
        return ship;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setShip(URI ship) {
        this.ship = ship;
    }
}

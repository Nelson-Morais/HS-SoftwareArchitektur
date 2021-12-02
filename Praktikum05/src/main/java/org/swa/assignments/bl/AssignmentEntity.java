package org.swa.assignments.bl;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.net.URI;
import java.time.LocalDate;

@Entity
public class AssignmentEntity{

    @Id
    @SequenceGenerator(
            name = "assignmentGenerator",
            sequenceName = "assignment_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assignmentGenerator")
    private long id;
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

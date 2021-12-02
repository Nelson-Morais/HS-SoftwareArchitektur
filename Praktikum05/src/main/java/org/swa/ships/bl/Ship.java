package org.swa.ships.bl;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class Ship extends PanacheEntityBase {


    @Id
    @SequenceGenerator(
            name = "shipSequence",
            sequenceName = "ship_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipSequence")
    private long id;
    private String name;
    private boolean assignmentState;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAssignmentState() {
        return assignmentState;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssignmentState(boolean assignmentState) {
        this.assignmentState = assignmentState;
    }
}

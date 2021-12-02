package org.swa.ships.bl;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ship {


    @Id @GeneratedValue private long id;
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

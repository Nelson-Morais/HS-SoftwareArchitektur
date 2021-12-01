package org.swa.ships.bl;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Ship extends PanacheEntity {

    private int id;
    private String name;
    private boolean assignmentState;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAssignmentState() {
        return assignmentState;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssignmentState(boolean assignmentState) {
        this.assignmentState = assignmentState;
    }
}

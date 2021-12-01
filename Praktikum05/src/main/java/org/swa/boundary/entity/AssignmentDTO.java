package org.swa.boundary.entity;

import org.swa.assignments.bl.AssignmentEntity;

import java.net.URI;
import java.time.LocalDate;

public class AssignmentDTO {

    private int id;
    private String description;
    private LocalDate date;
    private URI ship;


    public AssignmentDTO(int id, String description, LocalDate date, URI ship){
        setId(id);
        setDescription(description);
        setDate(date);
        setShip(ship);

    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public URI getShip() {
        return ship;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShip(URI ship) {
        this.ship = ship;
    }


    public static class AssignmentDTOConvertet{

        public static AssignmentEntity toAssignment(AssignmentDTO assignmentDTO){
            AssignmentEntity assignmentEntity= new AssignmentEntity();
            assignmentEntity.setId(assignmentDTO.getId());
            assignmentEntity.setDate(assignmentDTO.getDate());
            assignmentEntity.setDescription(assignmentDTO.getDescription());
            assignmentEntity.setShip(assignmentDTO.getShip());
            return assignmentEntity;

        }

        public static AssignmentDTO toDTO(AssignmentEntity assignment){
            return new AssignmentDTO(assignment.getId(), assignment.getDescription(), assignment.getDate(), assignment.getShip());
        }



    }

}

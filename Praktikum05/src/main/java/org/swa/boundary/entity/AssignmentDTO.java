package org.swa.boundary.entity;

import io.quarkus.logging.Log;
import org.swa.assignments.bl.AssignmentEntity;

import java.net.URI;
import java.time.LocalDate;

public class AssignmentDTO {

    private long id;
    private String description;
    private LocalDate date;
    private URI ship;

    public AssignmentDTO(){}

    public AssignmentDTO(long id, String description, LocalDate date, URI ship){
        setId(id);
        setDescription(description);
        setDate(date);
        setShip(ship);

    }

    public long getId() {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setShip(URI ship) {
        this.ship = ship;
    }


    public static class AssignmentDTOConverter {

        public static AssignmentEntity toAssignment(AssignmentDTO assignmentDTO){
            AssignmentEntity assignmentEntity= new AssignmentEntity();

            assignmentEntity.setDate(LocalDate.now());
            assignmentEntity.setDescription(assignmentDTO.getDescription());
            assignmentEntity.setShip(null);

            return assignmentEntity;

        }

        public static AssignmentDTO toDTO(AssignmentEntity assignment){
            Log.info("AssignmentDTOConverter toDTO");
            return new AssignmentDTO(assignment.getId(), assignment.getDescription(), assignment.getDate(), assignment.getShip());
        }



    }

}

package org.swa.boundary.entity;

import org.swa.ships.bl.Ship;

public class ShipDTO {

    private long id;
    private String name;
    private boolean AssignmentStatus;


    public ShipDTO(){}

    public ShipDTO(long id, String name, boolean assignmentState){
        setId(id);
        setName(name);
        setAssignmentState(assignmentState);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAssignmentStatus() {
        return AssignmentStatus;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssignmentState(boolean assignmentStatus) {
        AssignmentStatus = assignmentStatus;
    }


    public static class ShipDTOConverter{

        public static Ship toShip(ShipDTO shipDTO){
            Ship ship = new Ship();
            ship.setName(shipDTO.getName());
            ship.setAssignmentState(false);
            return ship;
        }

        public static ShipDTO toDTO(Ship ship){
            return new ShipDTO(ship.getId(), ship.getName(), ship.isAssignmentState());
        }
    }
}

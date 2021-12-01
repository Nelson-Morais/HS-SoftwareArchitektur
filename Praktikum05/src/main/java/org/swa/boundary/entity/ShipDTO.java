package org.swa.boundary.entity;

import org.swa.ships.bl.Ship;

public class ShipDTO {

    private int id;
    private String name;
    private boolean AssignmentStatus;


    public ShipDTO(int id, String name, boolean assignmentState){
        setId(id);
        setName(name);
        setAssignmentState(assignmentState);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAssignmentStatus() {
        return AssignmentStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssignmentState(boolean assignmentStatus) {
        AssignmentStatus = assignmentStatus;
    }


    public static class ShipDTOConverter{

        public static ShipDTO toDTO(Ship ship){

            return new ShipDTO(ship.getId(), ship.getName(), ship.isAssignmentState());
        }

        public static Ship toShip(ShipDTO shipDTO){
            Ship ship = new Ship();
            ship.setId(shipDTO.getId());
            ship.setName(shipDTO.getName());
            ship.setAssignmentState(shipDTO.isAssignmentStatus());
            return ship;
        }

    }
}

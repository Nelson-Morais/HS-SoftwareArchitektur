package org.swa.ships.bl;

public interface ShipCatalog {

    Ship getShip(int id);
    void createShip(Ship ship);
}

package org.swa.ships.bl;

import java.util.Collection;

public interface ShipCatalog {

    Collection<Ship> getShips();
    Ship getShip(long id);
    void createShip(Ship ship);
}

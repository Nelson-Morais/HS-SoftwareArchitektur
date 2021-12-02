package org.swa.ships.al;

import org.swa.boundary.entity.ShipDTO;

import java.util.Collection;

public interface ListShip {

    Collection<ShipDTO> getShips();
    ShipDTO getShip(long id);
}

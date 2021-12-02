package org.swa.ships.al;

import org.swa.boundary.entity.ShipDTO;
import org.swa.ships.bl.Ship;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class ShipController implements addShip, ListShip{


    @Inject
    ShipService shipService;

    @Override
    public Collection<ShipDTO> getShips(){
       return shipService.getShips();
    }
    @Override
    public ShipDTO getShip(long id) {
    return shipService.getShip(id);
    }

    @Override
    public void createShip(ShipDTO shipDTO) {
        shipService.createShip(shipDTO);


    }
}

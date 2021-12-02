package org.swa.ships.al;

import io.quarkus.logging.Log;
import org.swa.boundary.entity.ShipDTO;
import org.swa.dal.ShipRepo;
import org.swa.ships.bl.Ship;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class ShipService {

    @Inject
    Event<Ship> shipEvent;

    @Inject
    ShipRepo shipRepo;

    public Collection<ShipDTO> getShips(){
        Log.info("ShipService getShips()");
        List<ShipDTO> ships = new ArrayList<>();

        for(Ship el : shipRepo.getShips()){
            ships.add(ShipDTO.ShipDTOConverter.toDTO(el));
        }
        return ships;
    }

    public ShipDTO getShip(long id){
        Log.info("ShipService getShip()");
        if(shipRepo.getShip(id) != null){
            return ShipDTO.ShipDTOConverter.toDTO(shipRepo.getShip(id));
        }
        return null;
    }

    @Transactional
    public void createShip(ShipDTO shipDTO){
        Log.info("ShipService createShips()");
        Ship ship = ShipDTO.ShipDTOConverter.toShip(shipDTO);
        shipEvent.fire(ship);
    }


}

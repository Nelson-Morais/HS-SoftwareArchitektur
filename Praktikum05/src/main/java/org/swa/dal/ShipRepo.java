package org.swa.dal;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.logging.Log;
import org.swa.ships.bl.Ship;
import org.swa.ships.bl.ShipCatalog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class ShipRepo implements ShipCatalog, PanacheRepository<Ship> {


    @Override
    public Collection<Ship> getShips(){
        Log.info("ShipRepo getShips()");
        return listAll();
    }

    @Override
    public Ship getShip(long id) {
        Log.info("ShipRepo getShip()");
        return findById(id);
    }

    @Transactional(Transactional.TxType.MANDATORY)
    @Override
    public void createShip(@Observes Ship ship) {
        Log.info("ShipRepo createShips()");
        persist(ship);
    }
}

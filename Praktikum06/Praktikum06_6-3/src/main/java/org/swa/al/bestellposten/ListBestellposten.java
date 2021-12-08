package org.swa.al.bestellposten;

import org.swa.bl.entity.Bestellposten;

import java.util.Collection;

public interface ListBestellposten {

    Collection<Bestellposten> listBestellposten(long id);
    Bestellposten getBestellposten(long id);
}

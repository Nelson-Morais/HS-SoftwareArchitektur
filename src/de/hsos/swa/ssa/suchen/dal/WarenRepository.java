package de.hsos.swa.ssa.suchen.dal;

import de.hsos.swa.ssa.suchen.bl.Katalog;
import de.hsos.swa.ssa.suchen.bl.SuchAlgorithmus;
import de.hsos.swa.ssa.suchen.bl.Ware;



public class WarenRepository implements Katalog {

    private SuchAlgorithmus algo;
    //private static final String URL = "jdbc:derby:WareDB";

    WarenRepository(){

    };

    @Override
    public void legeSuchalgorithmusFest(SuchAlgorithmus algo) {
        this.algo = algo;
    }

    @Override
    public Ware[] suchen(String warenname) {
        return new Ware[0];
    }

    @Override
    public Ware[] suchen(long warenNummer) {
        return new Ware[0];
    }

    @Override
    public void gebeProduktinformation(Ware ware) {

    }
}

package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.bl.Ware;

public class SuchController implements SucheWare{
    @Override
    public Ware[] sucheWare(String warenname) {
        return new Ware[0];
    }

    @Override
    public Ware sucheWare(long warennummer) {
        return null;
    }
}

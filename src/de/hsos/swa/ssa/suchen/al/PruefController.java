package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class PruefController implements PruefeWare{
    @Override
    public Produktinformation[] holeDetailinformation(Ware ware) {
        return new Produktinformation[0];
    }
}

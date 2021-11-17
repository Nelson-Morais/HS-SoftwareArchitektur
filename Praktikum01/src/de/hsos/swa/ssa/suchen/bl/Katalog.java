package de.hsos.swa.ssa.suchen.bl;

public interface Katalog {

    public void legeSuchalgorithmusFest(SuchAlgorithmus algo);

    public Ware[] suchen(String warenname);

    public Ware[] suchen(long warenNummer);

    public void gebeProduktinformation(Ware ware);
}

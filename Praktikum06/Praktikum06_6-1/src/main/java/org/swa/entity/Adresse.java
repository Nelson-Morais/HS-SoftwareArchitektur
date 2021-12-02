package org.swa.entity;

import javax.enterprise.context.Dependent;

@Dependent
public class Adresse {

    private String plz;
    private String ort;
    private String strasse;
    private String hausnr;

    public Adresse(){}

    public Adresse(String plz, String ort, String strasse, String hausnr){
        setHausnr(hausnr);
        setOrt(ort);
        setPlz(plz);
        setStrasse(strasse);

    }

    public void setHausnr(String hausnr) {
        this.hausnr = hausnr;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnr() {
        return hausnr;
    }

    public String getOrt() {
        return ort;
    }

    public String getPlz() {
        return plz;
    }

    public String getStrasse() {
        return strasse;
    }

}

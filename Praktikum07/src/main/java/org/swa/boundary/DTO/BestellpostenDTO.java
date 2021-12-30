package org.swa.boundary.DTO;

import org.swa.bl.entity.Bestellposten;
import org.swa.bl.entity.Pizza;

public class BestellpostenDTO {

    private String name;
    private int menge;
    private long preis;

    public BestellpostenDTO(){}

    public BestellpostenDTO(Pizza pizza, int menge){
        setMenge(menge);
        setPizzaname(pizza.getName());
        setPreis(pizza.getPreis()*menge);
    }


   public String getPizzaname() {
        return name;
    }


    public void setPizzaname(String name) {
        this.name = name;
    }

   public int getMenge() {
       return menge;
   }
    public void setMenge(int menge) {
        this.menge = menge;
    }

    public long getPreis() {
        return preis;
    }

    public void setPreis(long preis) {
        this.preis = preis;
    }

    public static class BestellpostenConverter{

        public static BestellpostenDTO toDTO(Bestellposten bestellposten){
            return new BestellpostenDTO(bestellposten.getPizza(), bestellposten.getMenge());
        }

        /*public static Bestellposten toBestellposten(BestellpostenDTO bestellpostenDTO){
            return new Bestellposten(bestellpostenDTO.getPizzaname(), bestellpostenDTO.getMenge());
        }*/


    }
}


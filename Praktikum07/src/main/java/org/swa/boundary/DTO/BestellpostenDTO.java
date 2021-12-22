package org.swa.boundary.DTO;

import org.swa.bl.entity.Bestellposten;
import org.swa.bl.entity.Pizza;

public class BestellpostenDTO {

    private PizzaDTO pizza;
    private int menge;

    public BestellpostenDTO(){}

    public BestellpostenDTO(Pizza pizza, int menge){
        setMenge(menge);
        setPizza(pizza);
    }


   public PizzaDTO getPizza() {
        return pizza;
    }


    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

   public int getMenge() {
       return menge;
   }
    public void setMenge(int menge) {
        this.menge = menge;
    }

    public static class BestellpostenConverter{

        public static BestellpostenDTO toDTO(Bestellposten bestellposten){
            return new BestellpostenDTO(bestellposten.getPizza(), bestellposten.getMenge());
        }

        public static Bestellposten toBestellposten(BestellpostenDTO bestellpostenDTO){
            return new Bestellposten(bestellpostenDTO.getPizza(), bestellpostenDTO.getMenge());
        }


    }
}


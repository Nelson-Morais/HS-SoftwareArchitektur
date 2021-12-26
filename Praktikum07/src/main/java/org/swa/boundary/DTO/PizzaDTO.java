package org.swa.boundary.DTO;

import org.swa.bl.entity.Pizza;

public class PizzaDTO {

    private String beschreibung;
    private String name;
    private long preis;

    public PizzaDTO(){}

    public PizzaDTO(String name, String beschreibung, long preis){
        setBeschreibung(beschreibung);
        setName(name);
        setPreis(preis);
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getName() {
        return name;

    }

    public long getPreis() {
        return preis;
    }

    public void setPreis(long preis) {
        this.preis = preis;
    }


    public static class PizzaDTOConverter{

        public static PizzaDTO toDTO(Pizza pizza){
            return new PizzaDTO(pizza.getName(), pizza.getBeschreibung(), pizza.getPreis());
        }

        public static Pizza toPizza(PizzaDTO pizzaDTO){
            return new Pizza(pizzaDTO.getName(),pizzaDTO.getBeschreibung(), pizzaDTO.getPreis());

        }
    }

}

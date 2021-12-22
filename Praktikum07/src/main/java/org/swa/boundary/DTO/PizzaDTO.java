package org.swa.boundary.DTO;

import org.swa.bl.entity.Pizza;

public class PizzaDTO {

    private String beschreibung;
    private String name;

    public PizzaDTO(){}

    public PizzaDTO(String name, String beschreibung){
        setBeschreibung(beschreibung);
        setName(name);
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


    public static class PizzaDTOConverter{

        public static PizzaDTO toDTO(Pizza pizza){
            return new PizzaDTO(pizza.getName(), pizza.getBeschreibung());
        }

        public static Pizza toPizza(PizzaDTO pizzaDTO){
            return new Pizza(pizzaDTO.getName(),pizzaDTO.getBeschreibung());

        }
    }

}

package org.mocktails.bl;

public class Ingredient {

    String name;
    float quantity;


    public Ingredient(){

    }

    public Ingredient(String name, float quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public float getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
}

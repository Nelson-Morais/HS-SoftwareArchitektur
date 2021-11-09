package org.swa.bl;

public class Ingredient {

    String name;
    float menge;


    Ingredient(String name, float menge) {
        this.name = name;
        this.menge = menge;
    }

    public float getMenge() {
        return menge;
    }

    public String getName() {
        return name;
    }

    public void setMenge(float menge) {
        this.menge = menge;
    }

    public void setName(String name) {
        this.name = name;
    }
}

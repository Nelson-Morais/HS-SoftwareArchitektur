package org.swa.bl.catalogs;

import org.swa.bl.entity.Pizza;

import java.util.Collection;

public interface PizzaCatalog {

    Collection<Pizza> listPizzas();
    Pizza listPizza(long PizzaId);
    void addPizza(Pizza pizza);
    boolean deletePizza(long PizzaId);
    Pizza findPizzaByName(String name);

}

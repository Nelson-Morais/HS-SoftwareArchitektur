package org.swa.al.pizza;

import org.swa.bl.entity.Pizza;

import java.util.Collection;

public interface ListPizza {

    Collection<Pizza> listPizzas();
    Pizza getPizza(long id);
}

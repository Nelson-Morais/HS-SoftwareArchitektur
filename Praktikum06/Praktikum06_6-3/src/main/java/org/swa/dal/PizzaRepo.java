package org.swa.dal;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.swa.bl.catalogs.PizzaCatalog;
import org.swa.bl.entity.Pizza;

import java.util.Collection;

public class PizzaRepo implements PizzaCatalog, PanacheRepository<Pizza> {


    @Override
    public Collection<Pizza> listPizzas() {
        return listAll();
    }

    @Override
    public Pizza listPizza(long PizzaId) {
        return findById(PizzaId);
    }

    @Override
    public void addPizza(Pizza pizza) {
        pizza.persist();
    }

    @Override
    public void deletePizza(long PizzaId) {
        deleteById(PizzaId);
    }
}

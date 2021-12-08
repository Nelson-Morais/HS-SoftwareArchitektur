package org.swa.al.pizza;

import org.swa.bl.catalogs.PizzaCatalog;
import org.swa.bl.entity.Pizza;
import org.swa.boundary.DTO.PizzaDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@RequestScoped
public class PizzaService implements AddPizza, ListPizza, ModifyPizza {


    @Inject
    PizzaCatalog pizzaCatalog;

    @Override
    public void addPizza(PizzaDTO pizzaDTO) {
    pizzaCatalog.addPizza(PizzaDTO.PizzaDTOConverter.toPizza(pizzaDTO));
    }

    @Override
    public Collection<Pizza> listPizzas() {
        return pizzaCatalog.listPizzas();
    }

    @Override
    public Pizza getPizza(long id) {
        return pizzaCatalog.listPizza(id);
    }

    @Override
    public boolean deletePizza(long id) {
        return pizzaCatalog.deletePizza(id);
    }
}

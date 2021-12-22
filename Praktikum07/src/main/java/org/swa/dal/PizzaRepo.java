package org.swa.dal;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.swa.bl.catalogs.PizzaCatalog;
import org.swa.bl.entity.Pizza;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.Collection;

@RequestScoped
public class PizzaRepo implements PizzaCatalog, PanacheRepository<Pizza> {


    @Override
    public Collection<Pizza> listPizzas() {
        return listAll();
    }

    @Override
    public Pizza listPizza(long PizzaId) {
        return findById(PizzaId);
    }

    @Transactional
    @Override
    public void addPizza(Pizza pizza) {
        pizza.persist();
    }

    @Transactional
    @Override
    public boolean deletePizza(long PizzaId) {
       return deleteById(PizzaId);
    }
}

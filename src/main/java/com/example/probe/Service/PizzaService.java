package com.example.probe.Service;

import com.example.probe.Entity.Pizza;
import com.example.probe.Repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
 public class PizzaService {
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }


    public List<Pizza> getAllPizza(){
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(Long id){
        return pizzaRepository.findById(id).orElse(null);
    }
    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

        public Pizza updatePizza(Long pizzaId, Pizza updatePizza) {
        Pizza pizza1 = pizzaRepository.findById(pizzaId).orElse(null);
        if (pizza1 != null){
            pizza1.setNamePizza(updatePizza.getNamePizza());
            pizza1.setQuantity(updatePizza.getQuantity());
            pizza1.setIngredients(updatePizza.getIngredients());
            pizza1.setSize(updatePizza.getSize());
            pizza1.setPrice(updatePizza.getPrice());
            return pizzaRepository.save(pizza1);
        }
        return null;
    }

    public void deletePizza(Long pizzaId){
        pizzaRepository.deleteById(pizzaId);


    }}




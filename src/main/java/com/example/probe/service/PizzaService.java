package com.example.probe.service;

import com.example.probe.entity.Pizza;
import com.example.probe.repository.PizzaRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
 public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizza(){
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(Long id){return pizzaRepository.findById(id).orElse(null);}
    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

        public Pizza updatePizza(Long id, Pizza updatePizza) {
        Pizza pizza1 = pizzaRepository.findById(id).orElse(null);
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

    public void deletePizza(Long id){
        pizzaRepository.deleteById(id);


    }}




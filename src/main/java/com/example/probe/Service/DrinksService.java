package com.example.probe.Service;

import com.example.probe.Entity.Drinks;
import com.example.probe.Repository.DrinksRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor

@Service
public class DrinksService {
    private final DrinksRepository drinksRepository;

public List<Drinks> getAllDrinks(){return drinksRepository.findAll();
    }
    public Drinks getDrinksById(Long id){
        return drinksRepository.findById( id).orElse(null);
    }
    public  Drinks createDrinks(Drinks drinks){return drinksRepository.save(drinks);}
    public Drinks updateDrinks(Long drinksId, Drinks updateDrinks){
        Drinks drinks = drinksRepository.findById(drinksId).orElse(null);
        if (drinks != null){
            drinks.setId(updateDrinks.getId());
            drinks.setNameDrink(updateDrinks.getNameDrink());
            drinks.setDrinkIngredients(updateDrinks.getDrinkIngredients());
            drinks.setDrink_size(updateDrinks.getDrink_size());
            drinks.setDrinkQuantity(updateDrinks.getDrinkQuantity());
            drinks.setPrice(updateDrinks.getPrice());
            drinks.setSailed(updateDrinks.getSailed());
            return drinksRepository.save(drinks);
        }
        return null;

    }
    public void deleteDrinks(Long id){
        drinksRepository.deleteById(id);
        }
    }


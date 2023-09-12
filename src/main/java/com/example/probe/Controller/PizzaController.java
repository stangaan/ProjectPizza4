package com.example.probe.Controller;

import com.example.probe.Entity.Pizza;
import com.example.probe.Service.PizzaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
@GetMapping("/pizza")
public List<Pizza> getAllPizza(){
        return pizzaService.getAllPizza();
}
    @GetMapping("/pizza{id}")
    public Pizza getPizzaById(@PathVariable Long id){
        return pizzaService.getPizzaById(id);
    }
    @PostMapping ("/new-pizza")
    public Pizza createPizza(@RequestBody Pizza pizza){

        return pizzaService.createPizza(pizza);
    }
    @PutMapping("/update{id}")
    public Pizza updatePizza(@PathVariable Long id, @RequestBody Pizza updatePizza){
        return pizzaService.updatePizza(id, updatePizza);
    }
    @DeleteMapping("/delete{id}")
    public void deletePizza(@PathVariable Long id){
        pizzaService.deletePizza(id);
    }


}

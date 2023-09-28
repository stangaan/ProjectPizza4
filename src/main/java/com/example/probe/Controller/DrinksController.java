package com.example.probe.Controller;


import com.example.probe.Entity.Drinks;
import com.example.probe.Service.DrinksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.DataInput;
import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/api/drinks")
public class DrinksController {
    private final DrinksService drinksService;
    @GetMapping("/all-drinks")
    public List<Drinks> getAllDrinks(){return drinksService.getAllDrinks();}
    @GetMapping("/drink{id}")
    public Drinks getDrinksById(@PathVariable Long id){return drinksService.getDrinksById(id);}
    @PostMapping("/new-drink")
    public Drinks createDrink(@RequestBody Drinks drinks){return drinksService.createDrinks(drinks);}
    @PutMapping ("/update{id}")
    public Drinks updateDrink(@PathVariable Long id, @RequestBody Drinks updateDrinks){return drinksService.updateDrinks(id, updateDrinks);}
    @DeleteMapping("/delete{id}")
    public void deleteDrink(@PathVariable Long id){drinksService.deleteDrinks(id);}
}

package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;



@Entity
@Data
@Table(name = "drinks")
public class Drinks {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_drink")
    private String NameDrink;

    @Column(name = "drink_ingredients")
    private String DrinkIngredients;
    @Column(name = "drink_size")
    private int drink_size;

    @Column(name = "drink_quantity")
    private int drinkQuantity;

    @Column(name = "price")

    private int price;
    @Column(name = "sailed")

    private int sailed;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

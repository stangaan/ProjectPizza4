package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id")
    private Long PizzaId;

    @Column(name = "name_pizza")
    private String NamePizza;

    @Column(name = "ingredients")
    private String Ingredients;

    @Column(name = "size")
    private int size;

    @Column(name = "price")

    private int price;
    @Column(name = "quantity")
    private String quantity;
    @jakarta.persistence.Id
    @GeneratedValue
    private Long pizzaid;

}





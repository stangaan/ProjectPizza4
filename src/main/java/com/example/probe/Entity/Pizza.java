package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Entity
@Data
@Table(name = "pizza")
public class Pizza {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Long id;

    public Pizza(){}


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}





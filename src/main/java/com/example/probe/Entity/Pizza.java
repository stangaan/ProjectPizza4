package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table
public class Pizza {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="pizza_Id")
    private Long pizzaId;

    @Column(name = "name_Pizza")
    private String namePizza;

    private String ingredients;

    private int size;

    private int price;

    private String quantity;





    public void setId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

;

}





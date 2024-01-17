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
    private Long id;

    private String namePizza;

    private String ingredients;

    private int size;

    private int price;

    private String quantity;





    public void setId(Long id) {
        this.id = id;
    }

;

}





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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String namePizza;

    private String ingredients;

    private int size;

    private int price;

    private String quantity;





    public void setId(Long id) {
        this.id = id;
    }

    //@ManyToOne
    //@JoinColumn(name = "user_id")
    //private User user;

    //@ManyToOne
    //@JoinColumn(name = "caffeId")
    //private Caffe caffe;

}





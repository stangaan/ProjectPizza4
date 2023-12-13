package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Caffe {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private Long caffeId;

    private String nameCaffe;

    private String city;

    private String address;

    private String email;

    private Long phone;

    private Time open_at;

    private Time closed_at;


//@OneToMany(mappedBy= "caffe")
 //private List<Pizza> pizzas;
//@OneToMany
 //@JoinColumn(name = "user_id")
//private List<User> users;
//@OneToMany
  //@JoinColumn(name = "id")
//private List<RegisterUsers> registerUsers;//
}

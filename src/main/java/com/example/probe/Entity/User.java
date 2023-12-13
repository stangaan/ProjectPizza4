package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.*;




@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long user_id;

    public String firstName;

    public String lastName;

    public String roll;

    public String station;


   // @OneToMany(mappedBy = "user")
   // private List<Pizza> pizza;

    //@OneToOne(mappedBy = "user")
    //private RegisterUsers registerUsers;
}


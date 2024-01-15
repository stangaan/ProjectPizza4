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
public class Cafe {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private Long cafeId;

    private String nameCafe;

    private String city;

    private String address;

    private String email;

    private Long phone;

    private Time open_at;

    private Time closed_at;
//
//@OneToMany
//@JoinColumn(name = "id")
//    private Users users;
}

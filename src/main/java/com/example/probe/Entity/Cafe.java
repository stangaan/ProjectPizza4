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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "cafe_Id")
    private Long cafeId;
    @Column(name = "name_cafe")
    private String nameCafe;

    private String city;

    private String address;

    private String email;

    private Long phone;
    @Column(name = "open_at")
    private Time openAt;
    @Column(name = "closed_at")
    private Time closedAt;
//
//@OneToMany
//@JoinColumn(name = "id")
//    private Users users;
}

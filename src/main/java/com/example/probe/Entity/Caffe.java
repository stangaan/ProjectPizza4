package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.User;

import java.sql.Time;
import java.util.List;


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
//
//@OneToMany
//@JoinColumn(name = "id")
//    private Users users;
}

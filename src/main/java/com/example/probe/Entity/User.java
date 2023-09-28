package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
@Entity
@Table(name = "User")
public class User {


    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long UserId;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "roll")
    public String roll;
    @Column(name = "station")
    public String station;


}

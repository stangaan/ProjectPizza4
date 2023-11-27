package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "User")
public class User {

    public Long getUserId() {
        return UserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRoll() {
        return roll;
    }

    public String getStation() {
        return station;
    }

    public String getPassword() {
        return password;
    }

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

    @Column(name = "password")
    public String password;

}

package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;




@Entity
@Getter
@Setter
@Table
public class RegisterUsers {
    @Id
    public Long id;

    public String username;

    public String password;

    public String roles;
   // @OneToOne
     //    @JoinColumn(name= "user_id")
    //private User user;
}

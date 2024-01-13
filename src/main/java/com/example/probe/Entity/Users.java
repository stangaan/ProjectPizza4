package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;




@Entity
@Getter
@Setter
@Table
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String username;
    public String password;
    public String roles;{
        UserRoles userRoles;
    }
    public String firstName;
    public String lastName;
    public String station;
    public String e_mail;
   // @OneToOne
     //    @JoinColumn(name= "user_id")
    //private User user;
}

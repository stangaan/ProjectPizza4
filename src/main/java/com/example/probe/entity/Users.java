package com.example.probe.entity;

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
    @Column(name = "user_id")
    public Long userId;
    @Column(name = "user_name")
    public String userName;
    public String password;
    public String roles;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    public String lastName;
    public String station;
    @Column(name = "e_mail")
    public String eMail;
    @ManyToOne
      @JoinColumn(name= "cafe_id")
    private Cafe cafe;
}

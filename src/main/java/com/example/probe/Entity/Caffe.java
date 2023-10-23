package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "caffe")
public class Caffe {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
   private Long caffeId;
    @Column (name = "name_caffe")
    private String nameCaffe;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private Long phone;
    @Column(name = "open_at")
    private Time openAt;
    @Column(name = "closed_at")
    private Time closed_at;

 public Caffe(long l, String s) {
 }
}

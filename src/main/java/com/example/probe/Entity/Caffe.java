package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Entity
@Data
@Table(name = "caffe")
public class Caffe {


    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long caffeId;
    @Column(name = "name_caffe")
    private String NameCaffe;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "price")
    private int price;


    public void setCaffeId(Long caffeId) {
        this.caffeId = caffeId;
    }

    public Long getCaffeId() {
        return caffeId;
    }
}


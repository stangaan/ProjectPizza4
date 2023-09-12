package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Entity
@Data
@Table(name = "caffe")
public class Caffe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "caffe_id")
    private Long CaffeId;

    @Column(name = "name_caffe")
    private String NameCaffe;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "price")
    private int price;
    @jakarta.persistence.Id
    private Long id_caffe;

    public Caffe() {

    }


    public void setId(Long id) {
        this.CaffeId = id;
    }

    public Long getId() {
        return CaffeId;
    }
}


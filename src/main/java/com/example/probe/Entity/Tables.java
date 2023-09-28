package com.example.probe.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "tables")
public class Tables {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "building_name")
    private String BuildingName;

    @Column(name = "number_table")
    private int NumberTable;
    @Column(name = "visitors")
    private int Visitors;

    @Column(name = "creating")
    private LocalDate Creating;
    @Column(name = "quantity_orders")
    private int QuantityOrders;
    @Column(name = "orders")
    private String Orders;

    @jakarta.persistence.Id
    private Long tableID;


    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public Long getTableID() {
        return tableID;
    }
}

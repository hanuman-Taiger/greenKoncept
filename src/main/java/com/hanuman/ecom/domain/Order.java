package com.hanuman.ecom.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "hanuman_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "orderTime", nullable = false)
    private Timestamp orderTime;

    @Column(name = "amount", nullable = false)
    private float amount;

    @Column(name = "details", nullable = false)
    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}

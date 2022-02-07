package com.lushiqi.kinokocrm.entity.data;

import lombok.Data;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customers {

    @Column(name = "customerID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int customerID;

    @Column(name = "customer_name")
    String customerName;

    @Column(name = "customer_phone")
    String customerPhone;

    @Column(name = "customer_address")
    String customerAddress;

    @Column(name = "customer_email")
    String customerEmail;

    @JoinColumn(name = "customerClassID")
    @ManyToOne
    CustomerClasses customerClasses;
}


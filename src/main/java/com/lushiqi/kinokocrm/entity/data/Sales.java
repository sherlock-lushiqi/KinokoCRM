package com.lushiqi.kinokocrm.entity.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "sales")
public class Sales {

    @Column(name = "saleID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int SaleID;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "customerID")
    int customerID;

    @Column(name = "productID")
    int productID;

    @Column(name = "employeeID")
    int employeeID;

    @Column(name = "sale_date")
    Date saleDate;

}

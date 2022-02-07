package com.lushiqi.kinokocrm.entity.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Products {
    @Column(name = "productID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int productID;

    @Column(name = "product_name")
    String productName;

    @Column(name = "product_model_name")
    String productModelName;

    @Column(name = "product_price")
    int price;

}

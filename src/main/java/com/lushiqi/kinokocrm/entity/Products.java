package com.lushiqi.kinokocrm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Products {
    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.AUTO)//主键生成策略
    @Column(name="productid")
    private Integer productid;
    @Column(name="product_price")
    private Integer productPrice;
    @Column(name="product_model_name")
    private String productModelName;
    @Column(name="product_name")
    private String productName;
}

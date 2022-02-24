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
@Table(name="customers")
public class Customers {
    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.AUTO)//主键生成策略
    @Column(name="customerid")
    private Integer customerid;
    @Column(name="customer_address")
    private String customerAddress;
    @Column(name="customer_class")
    private String customerClass;
    @Column(name="customer_email")
    private String customerEmail;
    @Column(name="customer_name")
    private String customerName;
    @Column(name="customer_phone")
    private String customerPhone;
}

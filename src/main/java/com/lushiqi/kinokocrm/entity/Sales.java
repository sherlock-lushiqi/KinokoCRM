package com.lushiqi.kinokocrm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sales")
public class Sales {
    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.AUTO)//主键生成策略
    @Column(name="saleid")
    private Integer saleid;
    @Column(name="quantity")
    private Integer quantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name="sale_date")
    private Date saleDate;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customerid",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private Customers customers;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "employeeid",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private Employees employees;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "productid",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private Products products;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "progress")
    private String progress;
}

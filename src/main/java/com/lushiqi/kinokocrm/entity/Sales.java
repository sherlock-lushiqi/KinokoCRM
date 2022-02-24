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
    @Column(name="customerid")
    private Integer customerid;
    @Column(name="employeeid")
    private Integer employeeid;
    @Column(name="productid")
    private Integer productid;
    @Column(name="quantity")
    private Integer quantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name="sale_date")
    private Date saleDate;
}

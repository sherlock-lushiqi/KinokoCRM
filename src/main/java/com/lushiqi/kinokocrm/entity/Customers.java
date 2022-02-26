package com.lushiqi.kinokocrm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Data
@Accessors(chain = true)
@Entity
@NoArgsConstructor
@Table(name="customers")
public class Customers {
    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.AUTO)//主键生成策略
    @Column(name="customerid")
    private Integer customerid;
    @Column(name="customer_address")
    private String customerAddress;
    @Column(name="customer_email")
    private String customerEmail;
    @Column(name="customer_name")
    private String customerName;
    @Column(name="customer_phone")
    private String customerPhone;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="customer_class_id",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private CustomerClass customerClassEntity;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "employeeid",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private Employees employeeEntity;
    @Column(name="employee_name")
    private String employeeName;

    @Column(name="customer_class_name")
    private String customerClassName;

}

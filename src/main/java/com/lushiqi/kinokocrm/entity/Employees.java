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
@Table(name="employees")
public class Employees {
    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.AUTO)//主键生成策略
    @Column(name="employeeid")
    private Integer employeeid  ;
//    @Column(name="employee_department")
//    private String employeeDepartment;
    @Column(name="employee_name")
    private String employeeName;
    @Column(name="employee_email")
    private String employeeEmail;
    @Column(name="employee_phone")
    private String employeePhone;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="departmentid",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private Department department;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "accountid",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private Accounts accounts;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customerid",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private Customers customers;

    @Column(name="employee_department")
    private String employeeDepartment;

}

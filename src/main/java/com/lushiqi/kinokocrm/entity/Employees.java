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
    @Column(name="employee_department")
    private String employeeDepartment;
    @Column(name="employee_name")
    private String employeeName;
    @Column(name="employee_email")
    private String employeeEmail;
    @Column(name="employee_phone")
    private String employeePhone;

//    @OneToOne(mappedBy = "accountid")
//    @JoinColumn(name = "accountid",referencedColumnName = "accountid")
//    private Accounts accountid;
//
//    @OneToOne(mappedBy = "customerid")
//    @JoinColumn(name = "customerid",referencedColumnName = "customerid")
//    private Customers customerid;

}

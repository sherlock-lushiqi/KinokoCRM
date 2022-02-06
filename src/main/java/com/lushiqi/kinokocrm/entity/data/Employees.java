package com.lushiqi.kinokocrm.entity.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employees {

    @Column(name = "employeeID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int employeeID;

    @Column(name = "employee_name")
    String employeeName;

    @Column(name = "employee_department")
    String employeeDepartments;

    @Column(name = "employee_phone")
    String employee_phone;

    @Column(name = "employee_email")
    String employee_email;

}

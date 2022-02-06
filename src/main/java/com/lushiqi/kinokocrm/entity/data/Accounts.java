package com.lushiqi.kinokocrm.entity.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class Accounts {

    @Column(name = "accountID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int accountID;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @JoinColumn(name = "employeeID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Employees employees;

}

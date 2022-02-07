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
    private int accountID;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Accounts() {

    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

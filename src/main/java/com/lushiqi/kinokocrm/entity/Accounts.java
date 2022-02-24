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
@Table(name="accounts")
public class Accounts {
    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.AUTO)//主键生成策略
    @Column(name="accountid")
    private Integer accountid;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

}

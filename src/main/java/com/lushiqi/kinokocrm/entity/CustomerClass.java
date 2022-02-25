package com.lushiqi.kinokocrm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * TODO:
 *
 * @author chenyu
 * @version 1.0
 * @date 2022/2/25 17:09
 **/
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_class")
public class CustomerClass {
    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.AUTO)//主键生成策略
    @Column(name="customer_class_id")
    private Integer customerClassId;
    @Column(name="customer_class_name")
    private String customerClassName;
}

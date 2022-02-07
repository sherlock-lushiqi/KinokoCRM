package com.lushiqi.kinokocrm.entity.data;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customerclasses")
public class CustomerClasses {

    @Column(name = "customerClassID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int customerClassID;

    @Column(name = "customer_class_name")
    String customerClassName;

}

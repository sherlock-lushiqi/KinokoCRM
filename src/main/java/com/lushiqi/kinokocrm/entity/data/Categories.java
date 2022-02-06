package com.lushiqi.kinokocrm.entity.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class Categories {

    @Column(name = "categoryID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int categoryID;

    @Column(name = "category_name")
    String categoryName;
}

package com.lushiqi.kinokocrm.dao;

import com.lushiqi.kinokocrm.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Integer> {
}

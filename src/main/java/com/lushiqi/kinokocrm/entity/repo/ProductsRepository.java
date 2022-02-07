package com.lushiqi.kinokocrm.entity.repo;

import com.lushiqi.kinokocrm.entity.data.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
}

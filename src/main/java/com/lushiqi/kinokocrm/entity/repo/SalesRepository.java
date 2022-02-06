package com.lushiqi.kinokocrm.entity.repo;

import com.lushiqi.kinokocrm.entity.data.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {
}

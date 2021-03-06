package com.lushiqi.kinokocrm.dao;

import com.lushiqi.kinokocrm.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales,Integer> {

    @Query(value = "SELECT DISTINCT customerid FROM customers ORDER BY customerid DESC LIMIT 5", nativeQuery = true)
    List<Integer> selectRecentCustomers();

}

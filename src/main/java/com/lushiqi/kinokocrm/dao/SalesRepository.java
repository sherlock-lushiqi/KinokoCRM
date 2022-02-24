package com.lushiqi.kinokocrm.dao;

import com.lushiqi.kinokocrm.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales,Integer> {

    @Query(value = "select DISTINCT customerid sale_date from sales ORDER BY sale_date LIMIT 10 ", nativeQuery = true)
    List<Integer> selectRecentCustomids();

}

package com.lushiqi.kinokocrm.dao;

import com.lushiqi.kinokocrm.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers,Integer> {
}

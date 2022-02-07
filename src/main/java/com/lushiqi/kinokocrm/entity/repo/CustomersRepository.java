package com.lushiqi.kinokocrm.entity.repo;

import com.lushiqi.kinokocrm.entity.data.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
}

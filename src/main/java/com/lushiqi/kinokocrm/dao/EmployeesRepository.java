package com.lushiqi.kinokocrm.dao;

import com.lushiqi.kinokocrm.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
}

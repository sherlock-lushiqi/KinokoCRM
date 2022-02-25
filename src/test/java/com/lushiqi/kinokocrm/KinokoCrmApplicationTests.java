package com.lushiqi.kinokocrm;

import com.lushiqi.kinokocrm.dao.CustomersRepository;
import com.lushiqi.kinokocrm.dao.EmployeesRepository;
import com.lushiqi.kinokocrm.dao.SalesRepository;
import com.lushiqi.kinokocrm.entity.Customers;
import com.lushiqi.kinokocrm.entity.Employees;
import com.lushiqi.kinokocrm.entity.Sales;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KinokoCrmApplicationTests {

    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    EmployeesRepository employeesRepository;


    @Test
    void customersRepository() {
        List<Customers> all = customersRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void salesRepository() {
        List<Sales> all = salesRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void employeesRepository() {
        List<Employees> all = employeesRepository.findAll();
        all.forEach(System.out::println);
    }



}


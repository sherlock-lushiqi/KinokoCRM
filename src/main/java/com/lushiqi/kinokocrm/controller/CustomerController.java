package com.lushiqi.kinokocrm.controller;

import com.lushiqi.kinokocrm.entity.data.Customers;
import com.lushiqi.kinokocrm.entity.repo.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@RequiredArgsConstructor
@Controller
public class CustomerController {

    private final CustomersRepository repository;

    @GetMapping("/customers")
    public String showList(Model model) {
        model.addAttribute("customers", repository.findAll());
        return "customers";
    }

}

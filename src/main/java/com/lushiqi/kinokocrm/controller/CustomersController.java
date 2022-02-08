package com.lushiqi.kinokocrm.controller;

import com.lushiqi.kinokocrm.entity.data.Customers;
import com.lushiqi.kinokocrm.entity.repo.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class CustomersController {

    private final CustomersRepository repository;

    @GetMapping("/customers")
    public String showList(Model model) {
        List<Customers> all = repository.findAll();
        model.addAttribute("customers", all);
//        System.out.println("customers的值是=========");
//        for (Customers customer : all) {
//            System.out.println("customer======"+customer.toString());
//        }
        return "customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/customers";
    }

}

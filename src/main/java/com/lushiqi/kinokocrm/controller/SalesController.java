package com.lushiqi.kinokocrm.controller;

import com.lushiqi.kinokocrm.entity.data.Sales;
import com.lushiqi.kinokocrm.entity.repo.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SalesController {

    private final SalesRepository repository;

    @GetMapping("/sales")
    public String showList(Model model) {
        List<Sales> all = repository.findAll();
        model.addAttribute("sales", all);
        return "sales";
    }
}

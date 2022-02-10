package com.lushiqi.kinokocrm.controller;

import com.lushiqi.kinokocrm.entity.data.Products;
import com.lushiqi.kinokocrm.entity.repo.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductsController {

    private final ProductsRepository repository;

    @RequestMapping("/products")
    public String showList(Model model) {
        List<Products> all = repository.findAll();
        model.addAttribute("products", all);
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProducts(@PathVariable Integer id) {
        repository.deleteById(id);
        return "redirect:/products";
    }
}

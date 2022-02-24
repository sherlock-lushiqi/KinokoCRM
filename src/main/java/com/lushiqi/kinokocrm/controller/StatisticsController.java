package com.lushiqi.kinokocrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticsController {
    @RequestMapping("/statistics")
    public String statistics(Model model) {

        return "index";
    }
}

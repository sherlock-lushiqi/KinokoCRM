package com.lushiqi.kinokocrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    @RequestMapping("/project.html")
    public String list() {
        return "project";
    }
}

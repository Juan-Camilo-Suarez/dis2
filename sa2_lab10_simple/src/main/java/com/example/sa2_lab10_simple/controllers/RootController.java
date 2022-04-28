package com.example.sa2_lab10_simple.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("tex", "111");
        return "index";
    }
}

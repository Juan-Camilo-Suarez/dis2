package ru.itis.s2_lab7.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.s2_lab7.repositories.UserRepository;


@Controller
public class RootController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("user", "user");
        return "index";
    }
}
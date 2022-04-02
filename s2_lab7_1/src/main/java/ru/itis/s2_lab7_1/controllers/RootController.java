package ru.itis.s2_lab7_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Controller
public class RootController {

    @GetMapping("/")
    public String getIndex(Model model) {
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("lab7");
        emf.close();
        model.addAttribute("user", "user");
        return "index";
    }
}

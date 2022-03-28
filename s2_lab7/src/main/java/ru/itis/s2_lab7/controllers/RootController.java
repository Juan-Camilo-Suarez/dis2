package ru.itis.s2_lab7.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@Controller
public class RootController {


    @GetMapping("/")
    public String getIndex(Model model) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("lab7");
        enf.close();
        model.addAttribute("user", "user");
        return "index";
    }
}
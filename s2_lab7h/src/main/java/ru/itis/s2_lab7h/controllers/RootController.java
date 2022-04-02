package ru.itis.s2_lab7h.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.s2_lab7h.models.Role;
import ru.itis.s2_lab7h.models.User;
import ru.itis.s2_lab7h.repositories.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RootController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("user", "user");
        return "index";
    }
    @GetMapping(path = "/save")
    public String save( Model model) {

        User user = new User();
        user.setName("camilo");
        user.setPassword("juan");

        Role role = new Role();
        role.setName_role("teacher");
        role.setResource("www.hdsjfhsk.com");
        user.setRole(role);



        //userData = repository.save(userData);

        user = repository.save(user);

        model.addAttribute("user", user);

        return "result";
    }
}

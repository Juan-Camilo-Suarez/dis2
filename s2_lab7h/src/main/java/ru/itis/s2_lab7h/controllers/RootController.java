package ru.itis.s2_lab7h.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.s2_lab7h.models.Role;
import ru.itis.s2_lab7h.models.User;
import ru.itis.s2_lab7h.repositories.UserRepository;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static ru.itis.s2_lab7h.repositories.UserRepository.findAll;

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
        user.setId(5L);
        user.setName("camilo");
        user.setPassword("juan");

        Role role = new Role();
        role.setId(5L);
        role.setName_role("teacher");
        role.setResource("www.hdsjfhsk.com");
        user.setRole(role);


        user = repository.save(user);

        model.addAttribute("user", user);

        return "result";
    }
    @RequestMapping(value = "/findall")
    @ResponseBody
    public List getall(Model model){
        model.addAttribute("user", "user");
        return findAll();


    }
}

package ru.itis.demo_lab7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.demo_lab7.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Controller
public class RootController {
    static EntityManagerFactory enf = Persistence.createEntityManagerFactory("lab7");
    public static EntityManager getEntityManager() {
        return enf.createEntityManager();
    }
    @RequestMapping(value = "/")
    @ResponseBody
    public String getIndex(Model model) {
        model.addAttribute("user", "user");
        return "index";
    }
    @RequestMapping(value = "/save")
    @ResponseBody
    public String addmodel(Model model) {
        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();
        User ca = new User();
        ca.setId(5L);
        ca.setName("camilo");
        entityMgr.persist(ca);
        model.addAttribute("user", "user");
        entityMgr.getTransaction().commit();

        entityMgr.clear();
        System.out.println("Record Successfully Inserted In The Database");
        return "ok";
    }
}

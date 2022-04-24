package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.demo.models.Role;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static ru.itis.demo.jpaej.insertu;

@Controller
public class RootController {
    static EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("demo");

    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("user", "user");
        return "index";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String save( Model model) {

        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        User ca = new User();
        ca.setName("camilo");
        ca.setPassword("juan");
        Role a = new Role();
        a.setName_role("segundfggfo");
        a.setResource("resource");
        ca.setRole(a);
        //entityMgr.persist(ca);
        entityMgr.getTransaction().commit();

        entityMgr.clear();
        System.out.println("Record Successfully Inserted In The Database");

        return ca.getName();
    }
}

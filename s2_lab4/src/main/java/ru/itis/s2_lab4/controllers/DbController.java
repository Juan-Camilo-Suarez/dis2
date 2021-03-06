package ru.itis.s2_lab4.controllers;


import models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.s2_lab4.orm.EntityManager;
import ru.itis.s2_lab4.orm.EntityManagerFactory;

import java.io.IOException;
import java.sql.SQLException;

@Controller
public class DbController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @RequestMapping("/")
    public void writer(java.io.Writer writer) throws IOException {
        writer.write(entityManagerFactory.testDbWork());
    }


    @RequestMapping("/add")
    public void add(java.io.Writer writer) throws Exception {

        Users user = new Users();
        user.setName("camilo");
        user.setPassword("juan");
        user.setRole("student");
        user.setGroup_id(10);
        EntityManager em = entityManagerFactory.getEntityManager();
        entityManagerFactory.closeEntityManager();

        writer.write(em.persist(user));
    }

    @RequestMapping("/edit")
    public void edit(@RequestParam("id") Long id) throws IOException, SQLException {

        EntityManager em = entityManagerFactory.getEntityManager();
        System.out.println(id);

        Users user = em.find(Users.class, id);
        System.out.println(user);
        user.setName("kevin");
        //System.out.println(user);
        em.merge(user, id);



        entityManagerFactory.closeEntityManager();

    }
    @RequestMapping(value = "/remove")
    @ResponseBody
    public String getBarBySimplePathWithRequestParam(@RequestParam("id") long id) throws SQLException {
        EntityManager em = entityManagerFactory.getEntityManager();
        System.out.println(id);

        Users user = em.find(Users.class, id);
        System.out.println(user);
        em.remove(user);

        return "this elemen was deleted id=" + id;


    }}

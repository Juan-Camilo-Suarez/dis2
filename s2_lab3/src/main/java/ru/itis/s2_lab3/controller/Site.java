package ru.itis.s2_lab3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

import static ru.itis.s2_lab3.Verify.Compi.verify;


@RestController
public class Site {
    @RequestMapping("/hello")
    public String hello() throws SQLException {
        String url = "jdbc:postgresql://localhost/orm";
        String user = "postgres";
        String password = "Jcss2002";
        return verify(url,user,password);}


    /*
    public List<String> hello() throws SQLException {
        String url = "jdbc:postgresql://localhost/orm";
        String user = "postgres";
        String password = "Jcss2002";
        return gettablesbd(url,user,password);


     */
}


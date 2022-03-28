package ru.itis.s2_lab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class S2Lab3Application {

    public static void main(String[] args) {
        SpringApplication.run(S2Lab3Application.class, args);
    }


}

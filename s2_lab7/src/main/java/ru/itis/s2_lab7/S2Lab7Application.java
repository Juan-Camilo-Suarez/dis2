package ru.itis.s2_lab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class S2Lab7Application {

    public static void main(String[] args) {
        SpringApplication.run(S2Lab7Application.class, args);
    }

}

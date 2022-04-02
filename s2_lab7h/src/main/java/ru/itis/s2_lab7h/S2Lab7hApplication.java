package ru.itis.s2_lab7h;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class S2Lab7hApplication {

    public static void main(String[] args) {
        SpringApplication.run(S2Lab7hApplication.class, args);
    }

}

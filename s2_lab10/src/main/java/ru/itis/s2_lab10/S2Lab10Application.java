package ru.itis.s2_lab10;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import ru.itis.s2_lab10.service.CreateDefaultUser;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class S2Lab10Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(S2Lab10Application.class, args);

        ((CreateDefaultUser)context.getBean("createDefaultUser")).createUser();
    }

}

package ru.itis.pruebitas_lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itis.pruebitas_lab3.model.Contacto;
import ru.itis.pruebitas_lab3.repo.ContactoRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PruebitasLab3Application {
    @Autowired
    private ContactoRepository contactoRepository;

    @PostConstruct
    void init(){
        Contacto a = new Contacto();
        a.setId(1);
        a.setName("camilo");
        a.setCelular("123456789012345");
        a.setEmail("camilo.@gmail.com");
        contactoRepository.save(a);


        contactoRepository.findAll().forEach(c -> System.out.println(c.getName()));
    }

    public static void main(String[] args) {
        SpringApplication.run(PruebitasLab3Application.class, args);
    }

}

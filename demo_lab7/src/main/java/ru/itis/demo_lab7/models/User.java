package ru.itis.demo_lab7.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}

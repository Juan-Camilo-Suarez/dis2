package ru.itis.demo.models;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @SequenceGenerator(name = "personIdGenerator", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "personIdGenerator")

    private Long id;

    private String name_role;

    private String resource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_role() {
        return name_role;
    }

    public void setName_role(String name_role) {
        this.name_role = name_role;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}

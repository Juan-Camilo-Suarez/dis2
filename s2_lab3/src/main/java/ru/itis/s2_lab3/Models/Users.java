package ru.itis.s2_lab3.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Users {
    @Id
    Long id;
    @Column
    String name;
    @Column
    String password;
    @Column
    String role;
    @ManyToOne
    Groups group_id;

}

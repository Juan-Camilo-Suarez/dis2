package ru.itis.s2_lab3.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cars {
    @Id
    Long id_car;
    @Column
    String mark;
    @Column
    String country;
}

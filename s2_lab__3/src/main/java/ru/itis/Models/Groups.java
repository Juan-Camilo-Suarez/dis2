package ru.itis.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Groups{
    @Id
    Long id;
    @Column
    String number;
}


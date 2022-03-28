package ru.itis.s2_lab7.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class UserRepository {
    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("lab7");
    }
}

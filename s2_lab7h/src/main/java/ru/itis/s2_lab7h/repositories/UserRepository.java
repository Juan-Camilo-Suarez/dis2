package ru.itis.s2_lab7h.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.s2_lab7h.models.Role;
import ru.itis.s2_lab7h.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("lab7");
    }
    private List<User> users = new ArrayList<>();

    public List<User> findAll () {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select u from User u");
        List<User> users = query.getResultList();
        return users;
    }

    public User findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        return user;
    }

    public void removeUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.remove(user);
    }

    public User save(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println(user.getId());
        System.out.println(user);
        if (user.getId() != null) {
            User tmp = entityManager.find(User.class, user.getId());
            if (tmp != null) {
                entityManager.merge(user);
                return user;
            }
        }
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        return user;
    }

    public Role save(Role role) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        if (role.getId() != null) {
            Role tmp = entityManager.find(Role.class, role.getId());
            if (tmp != null) {
                entityManager.merge(role);
                return role;
            }
        }
        entityManager.persist(role);
        entityManager.getTransaction().commit();
        return role;
    }
}

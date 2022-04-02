package ru.itis.s2_lab7.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.s2_lab7.models.User;
import ru.itis.s2_lab7.models.UserData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private static EntityManagerFactory entMgrFactory;

    static {
        entMgrFactory =
                Persistence.createEntityManagerFactory("lab7");
    }

    private List<User> users = new ArrayList<>();

    public List<User> findAll () {
        EntityManager entityManager = entMgrFactory.createEntityManager();
        Query query = entityManager.createQuery("select u from User u");
        List<User> users = query.getResultList();
        return users;
    }

    public User findById(Long id) {
        EntityManager entityManager = entMgrFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        return user;
    }

    public void removeUser(User user) {
        EntityManager entityManager = entMgrFactory.createEntityManager();
        entityManager.remove(user);
    }

    public User save(User user) {
        EntityManager entityManager = entMgrFactory.createEntityManager();
        entityManager.getTransaction().begin();
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

    public UserData save(UserData userData) {
        EntityManager entityManager = entMgrFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println(userData.getId());
        /*
        if (userData.getId() != null) {
            UserData tmp = entityManager.find(UserData.class, userData.getId());
            if (tmp != null) {
                entityManager.merge(userData);
                return userData;
            }
        }
        entityManager.persist(userData);

         */
        entityManager.getTransaction().commit();
        return userData;
    }
}

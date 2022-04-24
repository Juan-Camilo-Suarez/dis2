package ru.itis.demo.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.demo.models.Role;
import ru.itis.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class UserRepository {
    static EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("demo");

    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }

    public User save(User user) {
        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();
        /*
        System.out.println(user);
        if (user.getId() != null) {
            User tmp = entityManager.find(User.class, user.getId());
            System.out.println("paso");
            if (tmp != null) {
                entityManager.merge(user);
                return user;
            }
        }

         */
        entityMgr.persist(user);
        entityMgr.getTransaction().commit();

        entityMgr.clear();
        System.out.println("Record Successfully Inserted In The Database");

        return user;
    }

//    public Role save(Role role) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        if (role.getId() != null) {
//            Role tmp = entityManager.find(Role.class, role.getId());
//            if (tmp != null) {
//                entityManager.merge(role);
//                return role;
//            }
//        }
//        entityManager.persist(role);
//        entityManager.getTransaction().commit();
//        return role;
//    }
}

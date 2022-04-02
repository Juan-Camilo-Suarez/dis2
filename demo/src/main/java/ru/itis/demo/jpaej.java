package ru.itis.demo;

import ru.itis.demo.models.Farmer;
import ru.itis.demo.models.Role;
import ru.itis.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaej {
    static EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("demo");

    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }

    public static void main(String[] args) {

        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

//        Farmer farmObj = new Farmer();
//        farmObj.setId(101);
//        farmObj.setName("Harry Potter");
//        farmObj.setVillage("Scottish Highlands");
//        entityMgr.persist(farmObj);
        User ca = new User();
        ca.setName("camilo");
        ca.setPassword("juan");
        Role a = new Role();
        a.setName_role("segundfggfo");
        a.setResource("resource");
        ca.setRole(a);
        entityMgr.persist(ca);




        entityMgr.getTransaction().commit();

        entityMgr.clear();
        System.out.println("Record Successfully Inserted In The Database");
    }

}

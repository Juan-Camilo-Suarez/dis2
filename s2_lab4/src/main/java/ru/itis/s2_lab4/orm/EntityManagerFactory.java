package ru.itis.s2_lab4.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.itis.s2_lab4.ScanDB.getTables;
import static ru.itis.s2_lab4.ScanDB.getmap;

public class EntityManagerFactory {

    private CharSequence url;

    private Connection connection;

    private Map<Long, EntityManager> entityManagerMap = new HashMap<>();

    private Map<String, Map<String, Class>> structureDB = new HashMap<>();

    public EntityManagerFactory() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void scanDB() throws SQLException {
        try (Connection connection = getConnection()) {

            List<String> tbls = getTables(connection);
            //tbls.forEach(System.out::println);
            for (int i = 0; i < tbls.size(); i++) {
                structureDB.put(tbls.get(i), getmap(connection, tbls.get(i)));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(structureDB);

    }

    public EntityManagerFactory(CharSequence url) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.url = url;
    }

    public Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }
        connection = DriverManager.getConnection((String) url, "postgres", "Jcss2002");
        return connection;
    }

    public EntityManager getEntityManager() throws SQLException {
        Long id = Thread.currentThread().getId();
        EntityManager em = entityManagerMap.get(id);
        if (em == null) {
            em = new EntityManagerImpl(getConnection());
        }
        return em;
    }

    public void closeEntityManager() {
        Long id = Thread.currentThread().getId();
        entityManagerMap.remove(id);
    }

    public String testDbWork() {
        return this.toString();
    }

    public void destroy() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            System.out.println("DbWork destroed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

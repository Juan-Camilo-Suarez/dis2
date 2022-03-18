package ru.itis.s2_lab4.orm;

import ru.itis.s2_lab4.orm.exceptions.NoEntityException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import static ru.itis.s2_lab4.ScanDB.getConnection;
import static ru.itis.s2_lab4.orm.queries.Queries.getattributes;

public class EntityManagerImpl implements EntityManager {

    private Set<Object> objects = new HashSet<>();
    private Connection connection;

    public EntityManagerImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String persist(Object var1) throws Exception {
        int id = 0;
        // la clase limpia
        String[] splitteda = var1.getClass().getName().toLowerCase(Locale.ROOT).split("\\.");
        String table_name = String.format("%s", splitteda[splitteda.length - 1].toLowerCase());
        System.out.println(table_name);

        //los atributos
        String attributes = getattributes(var1);
        //System.out.println(attributes);

        //los valores de los atriibutos
        String values = var1.toString();
        //System.out.println(values);
        try (Connection connection = getConnection()) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO " + table_name + " ( " + attributes + " ) "
                    + "VALUES" + " ( " + values + " ) RETURNING id;");
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
                System.out.println(resultSet.getInt(1));
            }


        }

        return var1.toString() + "  this is id: " + id;
    }


    @Override
    public <T> T merge(T var1, Object var2) {
        int id = 0;
        //System.out.println(var1);
        String[] splitteda = var1.getClass().getName().toLowerCase(Locale.ROOT).split("\\.");
        String table_name = String.format("%s", splitteda[splitteda.length - 1].toLowerCase());
        //System.out.println(table_name);
        String attributes = getattributes(var1);
        List<String>splitatrr = List.of(getattributes(var1).split(","));
        List<String>splitavalu = List.of(var1.toString().split(","));
        StringBuilder set = new StringBuilder();


        //System.out.println(splitatrr);
        //System.out.println(splitavalu);
        for (int i = 0; i <splitatrr.size(); i++) {
            set.append(splitatrr.get(i)).append("=").append(splitavalu.get(i) + ",");
        }
        String set1 = String.valueOf(set).substring(0, set.length()-1);
        System.out.println(set1);


        if (objects.contains(var1)){
            //return NoEntityException;
           try (Connection connection = getConnection()) {

               PreparedStatement st = connection.prepareStatement("UPDATE " + table_name + " SET "
                       + set1 + " WHERE id =" + var2 + "returning name");
               ResultSet resultSet = st.executeQuery();
               if (resultSet.next()) {
                   id = resultSet.getInt(1);
                   System.out.println(resultSet.getInt(1));
               }


           } catch (SQLException | ClassNotFoundException e) {
               e.printStackTrace();
           }
        }

        return var1;
    }

    @Override
    public void remove(Object var1) {
        /*
            if (!objects.contains(var1)) new throws ...
            var1.class -> table name -> SQL: delete from tableName where pkName = var1.getId()
            objects.remove(var1);
         */
    }

    @Override
    public <T> T find(Class<T> var1, Object var2) {

        String[] splitteda = var1.getName().toLowerCase(Locale.ROOT).split("\\.");

        String table_name = String.format("%s", splitteda[splitteda.length - 1].toLowerCase());
        //System.out.println(table_name);

        try (Connection connection = getConnection()) {
            PreparedStatement st = connection.prepareStatement("SELECT * from " + table_name + " where id = "
                    + var2);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                /*
                System.out.println(resultSet.getInt("id") + resultSet.getString("name")+ resultSet.getString("password") +
                        resultSet.getString("role") + resultSet.getInt("group_id"));

                 */

                Object object = ((Class<?>) var1).getDeclaredConstructor().newInstance();
                for (Field field : object.getClass().getDeclaredFields()) {
                    String dbColumn_name = field.getName();
                    //System.out.println("*****" +  dbColumn_name + "   " + field.getType());
                    field.setAccessible(true);
                    if (field.getType().equals(String.class))
                        field.set(object, resultSet.getString(dbColumn_name));
                    else if (field.getType().equals(int.class))
                        field.set(object, resultSet.getInt(dbColumn_name));
                    else if (field.getType().equals(java.lang.Long.class))
                        field.set(object, resultSet.getLong(dbColumn_name));

                }
                objects.add((T) object);
                //System.out.println(var1);
                //System.out.println(object);
                return (T) object;

            }


        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        /*
            var2 - id (primary key value)
            var1 - type of Object
            var1 -> pk name (default 'id')
            var1 -> table name -> SQL: select * from tableName where pkName = var2
            T result = var1.newInstance()
            resultSet -> <fielName, value> -> class fields set value
            objects.put(var1);
            return result;
         */
        return null;
    }

}

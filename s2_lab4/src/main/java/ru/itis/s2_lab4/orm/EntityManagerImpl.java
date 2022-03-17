package ru.itis.s2_lab4.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.Set;
import static ru.itis.s2_lab4.ScanDB.getConnection;
import static ru.itis.s2_lab4.orm.queries.Queries.getattributes;

public class EntityManagerImpl implements EntityManager {

    private Set<Object> objects;
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
        try (Connection connection = getConnection()){
            PreparedStatement st = connection.prepareStatement("INSERT INTO " + table_name + " ( " + attributes + " ) "
                    + "VALUES" + " ( " + values + " ) RETURNING id;");
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                id=resultSet.getInt(1);
                System.out.println(resultSet.getInt(1));
            }


        }

        return var1.toString() + "  this is id: " + id;
    }


    @Override
    public <T> T merge(T var1) {

        /*
            if (!objects.contains(var1)) new throws ...
            var1 -> fields
            var1.class -> table name -> SQL:
             update tableName set field1=value1,...;
         */

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

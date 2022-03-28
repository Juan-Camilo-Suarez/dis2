package ru.itis.s2_lab4;

import java.sql.*;
import java.util.*;

public class ScanDB {
    private static Connection connection;

    public static void main(String[] args) {
        // Структура для хранения имен таблиц и полей (в HashSet)
        Map<String, Map<String, Class>> structureDB = new HashMap<>();


        try (Connection connection = getConnection()) {

            //System.out.println("Список таблиц:");
            List<String> tbls = getTables(connection);
            //tbls.forEach(System.out::println);
            for (int i = 0; i <tbls.size(); i++) {
                structureDB.put(tbls.get(i),getmap(connection, tbls.get(i)));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(structureDB);

    }

    public static Map<String, Class> getmap(Connection connection, String table) throws SQLException {
        Map<String, Class> map = new HashMap<String, Class>();
        List<String> fields = getFields(connection, table);
        List<String> types = gettype(connection, table);
        for (int i = 0; i < fields.size(); i++) {
            if (Objects.equals(types.get(i), "bigint")) {

                map.put(fields.get(i), Long.class);

            } else if (Objects.equals(types.get(i), "character varying")) {

                map.put(fields.get(i), String.class);
            }

        }
        return map;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }

        Class.forName("org.postgresql.Driver");
        String dbURL = "jdbc:postgresql://localhost/orm";
        connection = DriverManager.getConnection(dbURL, "postgres", "Jcss2002");

        return connection;
    }

    public static List<String> getTables(Connection connection) throws SQLException {

        List<String> lst = new ArrayList<>();

        PreparedStatement st = connection.prepareStatement(
                "SELECT table_name FROM information_schema.tables " +
                        "WHERE table_type = 'BASE TABLE' AND" +
                        " table_schema NOT IN ('pg_catalog', 'information_schema')");

        ResultSet resultSet = st.executeQuery();

        while (resultSet.next()) {
            String s = resultSet.getString("table_name");
            lst.add(s);
        }

        st.close();
        return lst;
    }

    public static List<String> getFields(Connection connection, String tableName) throws SQLException {

        List<String> lst = new ArrayList<>();

        PreparedStatement st = connection.prepareStatement(
                "SELECT a.attname " +
                        "FROM pg_catalog.pg_attribute a " +
                        "WHERE a.attrelid = (SELECT c.oid FROM pg_catalog.pg_class c " +
                        "LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace " +
                        " WHERE pg_catalog.pg_table_is_visible(c.oid) AND c.relname = ? )" +
                        " AND a.attnum > 0 AND NOT a.attisdropped");

        st.setString(1, tableName);
        ResultSet resultSet = st.executeQuery();

        while (resultSet.next()) {
            String s = resultSet.getString("attname");
            lst.add(s);
        }

        st.close();
        return lst;
    }

    public static List<String> gettype(Connection connection, String tableName) throws SQLException {

        List<String> lst = new ArrayList<>();
        String a = String.format("'%s'", tableName.toLowerCase());
        PreparedStatement st = connection.prepareStatement(
                "select COLUMN_NAME, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, \n" +
                        "       NUMERIC_PRECISION, DATETIME_PRECISION, \n" +
                        "       IS_NULLABLE \n" +
                        "from INFORMATION_SCHEMA.COLUMNS\n" +
                        "where TABLE_NAME= " + a);


        ResultSet resultSet = st.executeQuery();
        while (resultSet.next()) {
            String s = resultSet.getString("DATA_TYPE");
            lst.add(s);
        }

        st.close();
        return lst;
    }

}

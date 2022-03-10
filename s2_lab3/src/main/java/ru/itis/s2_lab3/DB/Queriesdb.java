package ru.itis.s2_lab3.DB;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Queriesdb {
    public static List<String> gettablesbd(String url, String user, String password) throws SQLException {
        List<String> listtables = new ArrayList<String>();
        Connection conn = DriverManager.getConnection(url, user, "Jcss2002");
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_type = 'BASE TABLE' AND table_schema NOT IN ('pg_catalog', 'information_schema')\n");

        while (rs.next()) {
            listtables.add(rs.getString("table_name"));
        }

        return listtables;
    }
    public static List<String> getattrusers(String url, String user, String password) throws SQLException {
        List<String> listtables = new ArrayList<String>();
        Connection conn = DriverManager.getConnection(url, user, "Jcss2002");
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT a.attname FROM pg_catalog.pg_attribute a WHERE a.attrelid = (SELECT c.oid FROM pg_catalog.pg_class c LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace WHERE pg_catalog.pg_table_is_visible(c.oid) AND c.relname = 'users') AND a.attnum > 0 AND NOT a.attisdropped");


        while (rs.next()) {
            listtables.add(rs.getString("attname"));
        }


        return listtables;

    }
    public static List<String> getattrgroups(String url, String user, String password) throws SQLException {
        List<String> listtables = new ArrayList<String>();
        Connection conn = DriverManager.getConnection(url, user, "Jcss2002");
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT a.attname FROM pg_catalog.pg_attribute a WHERE a.attrelid = (SELECT c.oid FROM pg_catalog.pg_class c LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace WHERE pg_catalog.pg_table_is_visible(c.oid) AND c.relname = 'groups') AND a.attnum > 0 AND NOT a.attisdropped");


        while (rs.next()) {
            listtables.add(rs.getString("attname"));
        }


        return listtables;

    }
    public static List<String> getattrcars(String url, String user, String password) throws SQLException {
        List<String> listtables = new ArrayList<String>();
        Connection conn = DriverManager.getConnection(url, user, "Jcss2002");
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT a.attname FROM pg_catalog.pg_attribute a WHERE a.attrelid = (SELECT c.oid FROM pg_catalog.pg_class c LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace WHERE pg_catalog.pg_table_is_visible(c.oid) AND c.relname = 'cars') AND a.attnum > 0 AND NOT a.attisdropped");


        while (rs.next()) {
            listtables.add(rs.getString("attname"));
        }


        return listtables;

    }


}



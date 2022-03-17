package ru.itis.s2_lab4.orm.queries;

import models.Users;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Queries {

    public static String getattributes(Object o){
        StringBuilder attributes = new StringBuilder();
        List<Field> fields = new ArrayList<>();
        fields = List.of(o.getClass().getDeclaredFields());
        for (int i = 1; i <fields.size(); i++) {
            String[] split = fields.get(i).getName().toLowerCase(Locale.ROOT).split(" ");
            //System.out.println(splitteda[splitteda.length-1]);
            attributes.append(split[split.length - 1] + ",");
        }
        String a = String.valueOf(attributes).substring(0, attributes.length() - 1);
        return a;
    }
}

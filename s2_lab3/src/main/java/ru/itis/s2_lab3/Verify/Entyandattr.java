package ru.itis.s2_lab3.Verify;

import ru.itis.s2_lab3.Models.Cars;
import ru.itis.s2_lab3.Models.Groups;
import ru.itis.s2_lab3.Models.Users;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Entyandattr {
    public static List<String> getlistentity() {
        List<String> list = new ArrayList<String>();
        Class a = Users.class;
        String[] splitteda = a.getName().toLowerCase(Locale.ROOT).split("\\.");
        Class b = Groups.class;
        String[] splittedb = b.getName().toLowerCase(Locale.ROOT).split("\\.");
        Class c = Cars.class;
        String[] splittedc = c.getName().toLowerCase(Locale.ROOT).split("\\.");
        list.add(splittedc[splittedc.length - 1]);
        list.add(splittedb[splittedb.length - 1]);
        list.add(splitteda[splitteda.length - 1]);

        return list;
    }

    public static List<String> getlistatrr(Class a) {
        List<String> list = new ArrayList<String>();
        List<Field> fields = Arrays.asList(a.getDeclaredFields());
        for (Field x : fields) {

            String[] splitteda = x.getName().toLowerCase(Locale.ROOT).split(" ");
            //System.out.println(splitteda[splitteda.length-1]);
            list.add(splitteda[splitteda.length - 1]);
        }

        return list;

    }
}

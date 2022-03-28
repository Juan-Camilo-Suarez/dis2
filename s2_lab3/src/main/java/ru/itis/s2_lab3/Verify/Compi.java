package ru.itis.s2_lab3.Verify;

import ru.itis.s2_lab3.Models.Cars;
import ru.itis.s2_lab3.Models.Groups;
import ru.itis.s2_lab3.Models.Users;

import java.sql.SQLException;
import java.util.Objects;

import static ru.itis.s2_lab3.DB.Queriesdb.*;
import static ru.itis.s2_lab3.Verify.Entyandattr.getlistatrr;
import static ru.itis.s2_lab3.Verify.Entyandattr.getlistentity;

public class Compi {
    public static String verify(String url, String user, String password) throws SQLException {
        int count = 0;
        String a = "";
        if (gettablesbd(url, user, password).size() == getlistentity().size()) {
            for (int i = 0; i < getlistentity().size(); i++) {
                if ((Objects.equals(gettablesbd(url, user, password).get(i), getlistentity().get(i)))) {

                    count++;
                }
            }
        }
        if (count == getlistentity().size()) {
             a = "true: " + gettablesbd(url, user, password).toString() + " is equal " + getlistentity().toString();
        } else {
             a = "false " + gettablesbd(url, user, password).toString() + " not is equal " + getlistentity().toString();
        }
        count = 0;
        Class first = Cars.class;
        if (getattrcars(url, user, password).size() ==getlistatrr(first).size()){
            for (int i = 0; i < getlistatrr(first).size(); i++) {
                if ((Objects.equals(getattrcars(url, user, password).get(i), getlistatrr(first).get(i)))) {

                    count++;
                }
            }

        }
        if (count==getlistatrr(first).size()){
            a = a + " attributes car is true : " + getattrcars(url, user, password).toString() + " is equal " + getlistatrr(first).toString();
        }else{
            a = a + " attributes car is false : " + getattrcars(url, user, password).toString() + " is not equal " + getlistatrr(first).toString();
        }
        count = 0;
        Class second = Groups.class;
        if (getattrgroups(url, user, password).size() ==getlistatrr(second).size()){
            for (int i = 0; i < getlistatrr(second).size(); i++) {
                if ((Objects.equals(getattrgroups(url, user, password).get(i), getlistatrr(second).get(i)))) {

                    count++;
                }
            }

        }
        if (count==getlistatrr(second).size()){
            a = a + " attributes groups is true : " + getattrgroups(url, user, password).toString() + " is equal " + getlistatrr(second).toString();
        }else{
            a = a + " attributes groups is false : " + getattrgroups(url, user, password).toString() + " is not equal " + getlistatrr(second).toString() + " \n ";
        }
        count = 0;
        Class third = Users.class;
        if (getattrusers(url, user, password).size() ==getlistatrr(third).size()){
            for (int i = 0; i < getlistatrr(third).size(); i++) {
                if ((Objects.equals(getattrusers(url, user, password).get(i), getlistatrr(third).get(i)))) {

                    count++;
                }
            }

        }
        if (count==getlistatrr(third).size()){
            a = a + " attributes users is true : " + getattrusers(url, user, password).toString() + " is equal " + getlistatrr(third).toString();
        }else{
            a = a + " attributes users is false : " + getattrusers(url, user, password).toString() + " is not equal " + getlistatrr(third).toString() + " \n ";
        }


        return a;

    }

}

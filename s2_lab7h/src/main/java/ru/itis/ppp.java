package ru.itis;

import org.mindrot.jbcrypt.BCrypt;

public class ppp {
    public static void main(String[] args) {
        System.out.println(hashPassword("camilo"));

    }
    public static String hashPassword(String password_plaintext) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return(hashed_password);
    }
}

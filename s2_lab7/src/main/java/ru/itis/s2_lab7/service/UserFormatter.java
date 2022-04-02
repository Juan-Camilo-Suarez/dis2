package ru.itis.s2_lab7.service;

import ru.itis.s2_lab7.models.User;

public class UserFormatter {
    public String format(User user) {
        return "id:" + user.getId() + ", name: " + user.getName();
    }
}

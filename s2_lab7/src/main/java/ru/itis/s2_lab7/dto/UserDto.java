package ru.itis.s2_lab7.dto;

import lombok.Data;

@Data
public class UserDto {
    private String userName;
    private String password;
    private String passport;
    private String email;
}
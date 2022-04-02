package ru.itis.s2_lab7h.dto;


import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String password;
    private String name_role;
    private String resource;
    private Long role_id;
}
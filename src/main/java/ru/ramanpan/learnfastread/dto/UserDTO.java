package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long id;
    private LocalDate registerDate;
    private LocalDate changesDate;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String icon;
    private String role;
    private Integer taskInDay;
}

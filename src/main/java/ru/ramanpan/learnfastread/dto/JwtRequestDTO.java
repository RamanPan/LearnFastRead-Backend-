package ru.ramanpan.learnfastread.dto;

import lombok.Data;

@Data
public class JwtRequestDTO {
    private String usernameOrEmail;
    private String password;
}

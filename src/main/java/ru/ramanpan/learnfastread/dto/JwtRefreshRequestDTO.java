package ru.ramanpan.learnfastread.dto;

import lombok.Data;

@Data
public class JwtRefreshRequestDTO {
    private String refreshToken;
}

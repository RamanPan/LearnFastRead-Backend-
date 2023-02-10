package ru.ramanpan.learnfastread.dto;

import lombok.Data;

@Data
public class JwtResponseDTO {
    private static final String TYPE = "Bearer";
    private Long id;
    private String accessToken;
    private String refreshToken;
}

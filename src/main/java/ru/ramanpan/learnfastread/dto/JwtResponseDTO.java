package ru.ramanpan.learnfastread.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponseDTO {
    private static final String TYPE = "Bearer";
    private Long id;
    private String accessToken;
    private String refreshToken;
}

package ru.ramanpan.learnfastread.services;

import lombok.NonNull;
import ru.ramanpan.learnfastread.dto.JwtRequestDTO;
import ru.ramanpan.learnfastread.dto.JwtResponseDTO;
import ru.ramanpan.learnfastread.security.JwtAuthentication;


public interface AuthService {
    JwtResponseDTO login(@NonNull JwtRequestDTO authRequest);

    JwtResponseDTO getAccessToken(@NonNull String refreshToken);

    JwtResponseDTO getRefreshToken(@NonNull String refreshToken);

    JwtAuthentication getAuthInfo();
}


package ru.ramanpan.learnfastread.services.impl;

import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ramanpan.learnfastread.dto.JwtRequestDTO;
import ru.ramanpan.learnfastread.dto.JwtResponseDTO;
import ru.ramanpan.learnfastread.models.User;
import ru.ramanpan.learnfastread.models.enums.Status;
import ru.ramanpan.learnfastread.security.JwtAuthentication;
import ru.ramanpan.learnfastread.security.JwtProvider;
import ru.ramanpan.learnfastread.services.AuthService;
import ru.ramanpan.learnfastread.services.UserService;

import javax.security.auth.message.AuthException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final JwtProvider jwtProvider;
    private final BCryptPasswordEncoder encoder;

    @SneakyThrows
    @Override
    public JwtResponseDTO login(@NonNull JwtRequestDTO authRequest) {
        User user = userService.findByEmailOrLogin(authRequest.getUsernameOrEmail());
        if (Status.ACTIVE.equals(user.getStatus())) {
            if (user.getPassword().equals(encoder.encode(authRequest.getPassword()))) {
                String accessToken = jwtProvider.generateAccessToken(user);
                String refreshToken = jwtProvider.generateRefreshToken(user);
                user.setRefreshToken(refreshToken);
                return new JwtResponseDTO(user.getId(), accessToken, refreshToken);
            } else throw new AuthException("Wrong password");
        } else throw new AuthException("User has been deleted");
    }

    @Override
    public JwtResponseDTO getAccessToken(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            String email = claims.getSubject();
            String savedRefreshToken = userService.findByEmailOrLogin(email).getRefreshToken();
            if (savedRefreshToken != null && savedRefreshToken.equals(refreshToken)) {
                User user = userService.findByEmailOrLogin(email);
                return new JwtResponseDTO(user.getId(), jwtProvider.generateAccessToken(user), null);
            }
        }
        return new JwtResponseDTO(null, null, null);
    }

    @SneakyThrows
    @Override
    public JwtResponseDTO getRefreshToken(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            String email = claims.getSubject();
            String savedRefreshToken = userService.findByEmailOrLogin(email).getRefreshToken();
            if (savedRefreshToken != null && savedRefreshToken.equals(refreshToken)) {
                User user = userService.findByEmailOrLogin(email);
                String accessToken = jwtProvider.generateAccessToken(user);
                String newRefreshToken = jwtProvider.generateRefreshToken(user);
                user.setRefreshToken(newRefreshToken);
                return new JwtResponseDTO(user.getId(), accessToken, refreshToken);
            }
        }
        throw new AuthException("Invalid refresh token");
    }

    @Override
    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}

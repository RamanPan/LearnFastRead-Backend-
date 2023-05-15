package ru.ramanpan.learnfastread.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ramanpan.learnfastread.dto.JwtRefreshRequestDTO;
import ru.ramanpan.learnfastread.dto.JwtRequestDTO;
import ru.ramanpan.learnfastread.dto.JwtResponseDTO;
import ru.ramanpan.learnfastread.services.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthControllerV1 {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody JwtRequestDTO authRequest) {
        return ResponseEntity.ok(authService.login(authRequest));
    }

    @PostMapping("/access")
    public ResponseEntity<JwtResponseDTO> getAccessToken(@RequestBody JwtRefreshRequestDTO refreshRequest) {
        return ResponseEntity.ok(authService.getAccessToken(refreshRequest.getRefreshToken()));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponseDTO> getRefreshToken(@RequestBody JwtRefreshRequestDTO refreshRequest) {
        return ResponseEntity.ok(authService.getRefreshToken(refreshRequest.getRefreshToken()));
    }
}

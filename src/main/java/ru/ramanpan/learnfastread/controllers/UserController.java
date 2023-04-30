package ru.ramanpan.learnfastread.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import ru.ramanpan.learnfastread.dto.UserDTO;
import ru.ramanpan.learnfastread.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity.BodyBuilder registration(@RequestBody @NotNull UserDTO userDTO) {
        userService.registration(userDTO);
        return ResponseEntity.ok();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity.BodyBuilder deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok();
    }

    @PostMapping("/updatePassword")
    public ResponseEntity.BodyBuilder updatePassword(@RequestBody UserDTO u) {
        userService.updatePassword(u);
        return ResponseEntity.ok();
    }


    @RequestMapping("/logout")
    public ResponseEntity.BodyBuilder logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
        return ResponseEntity.ok();
    }

}

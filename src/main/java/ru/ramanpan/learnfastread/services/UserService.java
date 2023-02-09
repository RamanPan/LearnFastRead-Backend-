package ru.ramanpan.learnfastread.services;

import ru.ramanpan.learnfastread.dto.UserDTO;
import ru.ramanpan.learnfastread.models.User;

import java.util.List;

public interface UserService {
    Long registration(UserDTO u);

    User findByEmailOrLogin(String data);

    void updatePassword(UserDTO u);

    User findById(Long id);

    void delete(Long id);

    List<User> findAll();

    List<User> findAllByFirstname(String firstname);

    List<User> findAllByLastname(String lastname);
}

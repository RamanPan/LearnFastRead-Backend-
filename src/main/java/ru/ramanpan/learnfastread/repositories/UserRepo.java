package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String value);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findAllByFirstname(String firstname);

    List<User> findAllByLastname(String lastname);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}

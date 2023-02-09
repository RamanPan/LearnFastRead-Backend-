package ru.ramanpan.learnfastread.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ramanpan.learnfastread.dto.UserDTO;
import ru.ramanpan.learnfastread.exceptions.NotFoundException;
import ru.ramanpan.learnfastread.models.User;
import ru.ramanpan.learnfastread.models.enums.Role;
import ru.ramanpan.learnfastread.models.enums.Status;
import ru.ramanpan.learnfastread.repositories.UserRepo;
import ru.ramanpan.learnfastread.services.UserService;
import ru.ramanpan.learnfastread.utils.Constants;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder encoder;


    @Override
    public Long registration(UserDTO u) {
        User user = new User();
        user.setEmail(u.getEmail());
        user.setFirstname(u.getFirstname());
        user.setLastname(u.getLastname());
        user.setUsername(u.getUsername());
        if ("ADMIN".equals(u.getRole())) user.setRole(Role.ADMIN);
        else user.setRole(Role.USUAL_USER);
        user.setRegisterDate(LocalDate.now());
        user.setPassword(encoder.encode(u.getPassword()));
        user.setStatus(Status.ACTIVE);
        return userRepo.save(user).getId();
    }

    @Override
    public User findByEmailOrLogin(String data) {
        return userRepo.findByUsernameOrEmail(data, data).orElseThrow(() -> new NotFoundException(Constants.DATA_NOT_FOUND));
    }

    @Override
    public void updatePassword(UserDTO u) {
        User user = findById(u.getId());
        user.setPassword(encoder.encode(u.getPassword()));
        userRepo.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException(Constants.DATA_NOT_FOUND));
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);
        user.setStatus(Status.DELETED);
        userRepo.save(user);

    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public List<User> findAllByFirstname(String firstname) {
        return userRepo.findAllByFirstname(firstname);
    }

    @Override
    public List<User> findAllByLastname(String lastname) {
        return userRepo.findAllByLastname(lastname);
    }
}

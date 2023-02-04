package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.UserDaily;

public interface UserDailyRepo extends JpaRepository<UserDaily,Long> {
}

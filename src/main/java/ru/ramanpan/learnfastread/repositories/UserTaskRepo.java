package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.UserTasks;

public interface UserTaskRepo extends JpaRepository<UserTasks,Long> {
}

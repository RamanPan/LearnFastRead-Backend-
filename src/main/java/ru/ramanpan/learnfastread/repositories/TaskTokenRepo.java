package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.taskattributes.TaskToken;

public interface TaskTokenRepo extends JpaRepository<TaskToken, Long> {
}
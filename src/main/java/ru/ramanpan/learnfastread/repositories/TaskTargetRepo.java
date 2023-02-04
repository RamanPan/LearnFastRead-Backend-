package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.taskattributes.TaskTarget;

public interface TaskTargetRepo extends JpaRepository<TaskTarget, Long> {
}
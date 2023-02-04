package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.taskattributes.TaskType;

public interface TaskTypeRepo extends JpaRepository<TaskType, Long> {
}
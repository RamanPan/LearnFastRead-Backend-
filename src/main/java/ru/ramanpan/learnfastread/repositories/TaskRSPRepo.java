package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.taskattributes.TaskRSP;

public interface TaskRSPRepo extends JpaRepository<TaskRSP, Long> {
}
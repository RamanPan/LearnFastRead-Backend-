package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.TaskItems;

public interface TaskItemsRepo extends JpaRepository<TaskItems, Long> {
}
package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.taskattributes.TaskTargetAudience;

public interface TaskTargetAudienceRepo extends JpaRepository<TaskTargetAudience, Long> {
}
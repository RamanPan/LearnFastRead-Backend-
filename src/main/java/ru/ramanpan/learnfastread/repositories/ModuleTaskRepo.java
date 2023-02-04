package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.ModuleTask;

public interface ModuleTaskRepo extends JpaRepository<ModuleTask, Long> {
}
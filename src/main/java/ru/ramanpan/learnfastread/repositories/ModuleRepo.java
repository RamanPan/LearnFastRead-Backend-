package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.Module;

public interface ModuleRepo extends JpaRepository<Module, Long> {
}
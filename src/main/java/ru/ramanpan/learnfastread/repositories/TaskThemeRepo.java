package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.taskattributes.TaskTheme;

public interface TaskThemeRepo extends JpaRepository<TaskTheme, Long> {
}
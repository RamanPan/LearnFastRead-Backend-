package ru.ramanpan.learnfastread.services;

import ru.ramanpan.learnfastread.dto.TaskDTO;
import ru.ramanpan.learnfastread.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Long save(TaskDTO taskDTO);

    Long update(TaskDTO taskDTO);

}

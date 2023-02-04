package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findAllByAuthor(String author);

    Optional<Task> findByTitle(String title);

    List<Task> findAllByAdaptivity(Boolean adaptivity);

    List<Task> findAllByControl(Boolean control);

    List<Task> findAllByIndividual(Boolean individual);

    List<Task> findAllByToQER(Boolean toQER);

    List<Task> findAllByToAA(Boolean toAA);

    List<Task> findAllByToBOFI(Boolean toBOFI);

    List<Task> findAllByToVM(Boolean toVM);

    List<Task> findAllByToVMWP(Boolean toVMWP);

    List<Task> findAllByToLM(Boolean toLM);
}

package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.Item;
import ru.ramanpan.learnfastread.models.Question;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Long> {
    List<Question> findAllByItem(Item item);
}

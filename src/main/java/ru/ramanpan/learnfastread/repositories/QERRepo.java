package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.indicators.QER;

public interface QERRepo extends JpaRepository<QER, Long> {
}
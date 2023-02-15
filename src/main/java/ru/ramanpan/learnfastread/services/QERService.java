package ru.ramanpan.learnfastread.services;

import ru.ramanpan.learnfastread.dto.QerDTO;
import ru.ramanpan.learnfastread.models.indicators.QER;

public interface QERService {
    QER findById(Long id);

    Long save(QerDTO qerDTO);
}

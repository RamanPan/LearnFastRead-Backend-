package ru.ramanpan.learnfastread.services;

import ru.ramanpan.learnfastread.dto.IndicatorsDTO;
import ru.ramanpan.learnfastread.models.indicators.VM;

public interface VMService {
    VM findById(Long id);

    Long save(IndicatorsDTO indicatorsDTO);
}

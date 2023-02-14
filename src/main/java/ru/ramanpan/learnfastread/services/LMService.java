package ru.ramanpan.learnfastread.services;

import ru.ramanpan.learnfastread.dto.IndicatorsDTO;
import ru.ramanpan.learnfastread.models.indicators.LM;

public interface LMService {
    LM findById(Long id);

    Long save(IndicatorsDTO indicatorsDTO);
}

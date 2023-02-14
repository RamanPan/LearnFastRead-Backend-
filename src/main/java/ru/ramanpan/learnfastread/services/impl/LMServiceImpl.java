package ru.ramanpan.learnfastread.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ramanpan.learnfastread.dto.IndicatorsDTO;
import ru.ramanpan.learnfastread.exceptions.NotFoundException;
import ru.ramanpan.learnfastread.models.indicators.LM;
import ru.ramanpan.learnfastread.repositories.LMRepo;
import ru.ramanpan.learnfastread.services.LMService;
import ru.ramanpan.learnfastread.services.UserService;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class LMServiceImpl implements LMService {
    private final LMRepo lmRepo;
    private final UserService userService;

    @Override
    public LM findById(Long id) {
        return lmRepo.findById(id).orElseThrow(() -> new NotFoundException("LM not found"));
    }

    @Override
    public Long save(IndicatorsDTO indicatorsDTO) {
        LM lm = new LM();
        lm.setUser(userService.findById(indicatorsDTO.getIdUser()));
        lm.setLm(indicatorsDTO.getValue());
        lm.setRegisterDate(LocalDate.now());
        return lmRepo.save(lm).getId();
    }
}

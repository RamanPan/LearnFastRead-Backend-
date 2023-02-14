package ru.ramanpan.learnfastread.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ramanpan.learnfastread.dto.IndicatorsDTO;
import ru.ramanpan.learnfastread.exceptions.NotFoundException;
import ru.ramanpan.learnfastread.models.indicators.AA;
import ru.ramanpan.learnfastread.repositories.AARepo;
import ru.ramanpan.learnfastread.services.AAService;
import ru.ramanpan.learnfastread.services.UserService;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class AAServiceImpl implements AAService {
    private final AARepo aaRepo;
    private final UserService userService;

    @Override
    public AA findById(Long id) {
        return aaRepo.findById(id).orElseThrow(() -> new NotFoundException("AA not found"));
    }

    @Override
    public Long save(IndicatorsDTO indicatorsDTO) {
        AA a = new AA();
        a.setAa(indicatorsDTO.getValue());
        a.setRegisterDate(LocalDate.now());
        a.setUser(userService.findById(indicatorsDTO.getIdUser()));
        return aaRepo.save(a).getId();
    }
}

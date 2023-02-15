package ru.ramanpan.learnfastread.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ramanpan.learnfastread.dto.QerDTO;
import ru.ramanpan.learnfastread.exceptions.NotFoundException;
import ru.ramanpan.learnfastread.models.indicators.QER;
import ru.ramanpan.learnfastread.repositories.QERRepo;
import ru.ramanpan.learnfastread.services.QERService;
import ru.ramanpan.learnfastread.services.UserService;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class QERServiceImpl implements QERService {
    private final QERRepo qerRepo;
    private final UserService userService;

    @Override
    public QER findById(Long id) {
        return qerRepo.findById(id).orElseThrow(() -> new NotFoundException("QER not found"));
    }

    @Override
    public Long save(QerDTO qerDTO) {
        QER qer = new QER();
        qer.setQer(qerDTO.getQer());
        qer.setQu(qerDTO.getQu());
        qer.setWpm(qerDTO.getWpm());
        qer.setUser(userService.findById(qerDTO.getUserId()));
        qer.setRegisterDate(LocalDate.now());
        return qerRepo.save(qer).getId();
    }
}

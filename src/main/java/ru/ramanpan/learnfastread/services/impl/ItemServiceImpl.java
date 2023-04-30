package ru.ramanpan.learnfastread.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ramanpan.learnfastread.dto.ItemDTO;
import ru.ramanpan.learnfastread.exceptions.NotFoundException;
import ru.ramanpan.learnfastread.models.Item;
import ru.ramanpan.learnfastread.repositories.ItemRepo;
import ru.ramanpan.learnfastread.services.ItemService;
import ru.ramanpan.learnfastread.utils.Constants;
import ru.ramanpan.learnfastread.utils.Logging;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepo itemRepo;

    @Override
    public Long save(ItemDTO itemDTO) {
        Item item = new Item();
        item.setContent(itemDTO.getContent());
        item.setFile(itemDTO.getFile());
        item.setTitle(itemDTO.getTitle());
        item.setRegisterDate(LocalDate.now());
        Logging.logInfoMessage("New item created");
        return itemRepo.save(item).getId();
    }

    @Override
    public Long update(ItemDTO itemDTO) {
        Item item = getItemById(itemDTO.getId());
        item.setContent(itemDTO.getContent());
        item.setFile(itemDTO.getFile());
        item.setTitle(itemDTO.getTitle());
        item.setChangesDate(LocalDate.now());
        Logging.logInfoMessage("Item " + itemDTO.getId() + " updated");
        return itemRepo.save(item).getId();
    }

    @Override
    public void delete(Long id) {
        Logging.logInfoMessage("Item " + id + " deleted");
        itemRepo.deleteById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepo.findById(id).orElseThrow(() -> new NotFoundException(Constants.DATA_NOT_FOUND));
    }
}

package ru.ramanpan.learnfastread.services;

import ru.ramanpan.learnfastread.dto.ItemDTO;
import ru.ramanpan.learnfastread.models.Item;

import java.util.List;

public interface ItemService {
    Long save(ItemDTO itemDTO);

    Long update(ItemDTO itemDTO);

    void delete(Long id);

    List<Item> getAllItems();

    Item getItemById(Long id);
}

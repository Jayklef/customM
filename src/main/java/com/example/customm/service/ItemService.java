package com.example.customm.service;

import com.example.customm.dto.ItemDto;
import com.example.customm.entity.Item;

import java.util.List;

public interface ItemService {
    Item saveItem(ItemDto itemDto);

    List<Item> getAllItems();

    Item getItem(Long id);

    void deleteItem(Long id);
}

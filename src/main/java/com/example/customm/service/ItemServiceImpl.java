package com.example.customm.service;

import com.example.customm.dto.ItemDto;
import com.example.customm.entity.Item;
import com.example.customm.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Item saveItem(ItemDto itemDto) {

        Item newItem = new Item();
        newItem.setName(itemDto.getName());
        newItem.setPrice(itemDto.getPrice());
        newItem.setQuantity(itemDto.getQuantity());

        return itemRepository.save(newItem);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.get();
    }

    @Override
    public void deleteItem(Long id) {
        Item item = getItem(id);
        itemRepository.deleteById(item.getId());
    }
}

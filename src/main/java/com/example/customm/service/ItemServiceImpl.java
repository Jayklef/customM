package com.example.customm.service;

import com.example.customm.dto.ItemDto;
import com.example.customm.entity.Item;
import com.example.customm.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public Item updateItem(Long id, ItemDto itemDto) {

        Item itemInDb = itemRepository.findById(id).get();

        if (Objects.nonNull(itemDto.getName()) &&
        !"".equalsIgnoreCase(itemDto.getName())){
            itemInDb.setName(itemDto.getName());
        }

        if (Objects.nonNull(itemDto.getQuantity()) &&
        !"".equalsIgnoreCase(itemDto.getQuantity().toString())){
            itemInDb.setQuantity(itemDto.getQuantity());
        }

        if (Objects.nonNull(itemDto.getPrice()) &&
        !"".equalsIgnoreCase(itemDto.getPrice().toString())){
            itemInDb.setPrice(itemDto.getPrice());
        }

        return itemRepository.save(itemInDb);
    }
}

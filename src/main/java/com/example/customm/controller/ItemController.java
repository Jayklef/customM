package com.example.customm.controller;

import com.example.customm.dto.ItemDto;
import com.example.customm.entity.Item;
import com.example.customm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @PostMapping("/save")
    public ResponseEntity<Item> saveItem(@RequestBody ItemDto itemDto){
        Item item = itemService.saveItem(itemDto);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") Long id,
                                           @RequestBody ItemDto itemDto){
        Item itemToUpdate = itemService.updateItem(id, itemDto);
        return new ResponseEntity<>(itemToUpdate, HttpStatus.OK);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id") Long id){
        Item item = itemService.getItem(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStatus> deleteItem(@PathVariable("id") Long id){
      itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

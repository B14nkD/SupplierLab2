package com.example.myapp.controller;

import com.example.myapp.model.Item;
import com.example.myapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item itemDetails) {
        Item item = itemService.findById(id);
        if (item == null) {
            return null;
        }
        item.setName(itemDetails.getName());
        item.setCategory(itemDetails.getCategory());
        item.setDescription(itemDetails.getDescription());
        item.setImageUrl(itemDetails.getImageUrl());
        item.setPrice(itemDetails.getPrice());
        item.setDiscount(itemDetails.getDiscount());
        item.setSupplierId(itemDetails.getSupplierId());
        return itemService.save(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable String id) {
        itemService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

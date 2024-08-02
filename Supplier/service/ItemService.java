package com.example.myapp.service;

import com.example.myapp.model.Item;
import com.example.myapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item findById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        itemRepository.deleteById(id);
    }
}

package com.example.myapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {

    @Id
    private String id;
    private String name;
    private String category;
    private String description;
    private String imageUrl;
    private double price;
    private double discount;
    private String supplierId; // Reference to Supplier

    public Item(String id) {
        this.id = id;
    }

    // Getters and setters
}

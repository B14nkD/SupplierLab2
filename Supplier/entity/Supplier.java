package com.example.myapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suppliers")
public class Supplier {

    @Id
    private String id;
    private String name;
    private String origin;
    private String description;

    // Getters and setters
}

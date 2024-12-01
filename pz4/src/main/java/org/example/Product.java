package org.example;

import lombok.Data;

@Data
public abstract class Product {
    private String name; // Це поле має бути доступним для успадкування
}

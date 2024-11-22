package org.example;
import lombok.Builder;

public class Clothing extends Product {
    @Builder
    public Clothing(String name, Double price, String description) {
        super(name, price, description);
    }
}

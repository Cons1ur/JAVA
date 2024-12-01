package org.example;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Builder;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Clothing extends Product {
    private String name; // Додаємо name для builder
    private String size;
    private String color;
}

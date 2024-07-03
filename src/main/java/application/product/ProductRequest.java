package application.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private String unit;
    private String description;
    private int amount;
    private double price;
}

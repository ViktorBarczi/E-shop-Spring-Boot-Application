package application.cart;

import application.list.ItemListResponse;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
public class ShoppingCartRequest {

    private Long id;
    private String userName;
    private List<ItemListResponse> product;
    private boolean payed;
}
package application.cart;

import lombok.Getter;
import application.list.ItemList;
import application.list.ItemListResponse;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ShoppingCartResponse {


    private Long id;
    private List<ItemListResponse> shoppingList;

    private boolean payed;

    public ShoppingCartResponse(ShoppingCart c) {
        this.id = c.getId();
        this.shoppingList = new ArrayList<>();
        this.payed = c.isPayed();
        for(ItemList iList : c.getShoppingItemList()){
            ItemListResponse newItem = new ItemListResponse(iList.getProdId(), iList.getAmount());
            shoppingList.add(newItem);
        }
    }
}
package application.cart;

import java.util.List;

public interface IShoppingCartService {
    List<ShoppingCart> getAll();
    ShoppingCart addToCart(long productId, long cartId, long amount);
    ShoppingCart createCart();
    ShoppingCart getAllById(Long id);
    void deleteCart(Long id);
    double pay(long id);
}


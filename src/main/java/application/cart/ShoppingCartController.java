package application.cart;

import java.util.List;
import java.util.stream.Collectors;

import application.product.ProductRequest;
import application.utils.NameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import application.list.ItemListRequest;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

  @Autowired
  private ShoppingCartService service;

  @GetMapping()
  public List<ShoppingCartResponse> getAllCart() {
    return this.service.getAll().stream().map(ShoppingCartResponse::new)
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public ShoppingCartResponse getAllCartsById(@PathVariable Long id) {
    return new ShoppingCartResponse(this.service.getAllById(id));
  }

  @GetMapping("/{id}/pay")
  public ResponseEntity<String> payCart(@PathVariable("id") long cartId) {
    String resp = String.valueOf(this.service.pay(cartId));
    return new ResponseEntity<>(resp, HttpStatus.OK);

  }

  @PostMapping("/new")
  public ResponseEntity<ShoppingCartResponse> addCart(@RequestBody NameRequest request) {
    return new ResponseEntity<>(new ShoppingCartResponse(this.service.createCart(request)),
        HttpStatus.CREATED);
  }

  @PostMapping("/{id}/add")
  public ResponseEntity<ShoppingCartResponse> addProductToCart(@PathVariable("id") long cartId,
      @RequestBody ItemListRequest shoppingListRequest) {
    return new ResponseEntity<>(new ShoppingCartResponse(this.service
        .addToCart(shoppingListRequest.getProductId(), cartId, shoppingListRequest.getAmount())),
        HttpStatus.OK);
  }


  @DeleteMapping("/{id}")
  public void deleteCart(@PathVariable("id") Long cartId) {
    this.service.deleteCart(cartId);
  }

}

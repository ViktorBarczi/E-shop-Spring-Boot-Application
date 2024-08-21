package application.page;

import application.product.IProductService;
import application.product.Product;
import application.product.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeResource {
  @Autowired
  private IProductService service;

  @GetMapping("/welcome")
  public String welcome() {
    return "<h2>Welcome to my back-end application! A new \"test\" entity has been added to the database.</h2>";
  }

  // Adding a "test" product to the database
  @PostMapping("/resource")
  public Product resource() {
    ProductRequest productRequest = new ProductRequest();
    productRequest.setName("test");
    productRequest.setDescription("test Description");
    productRequest.setUnit("test Unit");
    productRequest.setAmount(4);
    productRequest.setPrice(4.44);
    return service.createNewProduct(productRequest);
  }


}

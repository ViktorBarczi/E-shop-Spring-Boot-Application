package application.page;

import application.product.IProductService;
import application.product.Product;
import application.product.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeResource {
  @Autowired
  private IProductService service;

  @GetMapping("/")
  public String welcome() {
    ProductRequest productRequest = new ProductRequest();
    productRequest.setName("test");
    productRequest.setDescription("test Description");
    productRequest.setUnit("test Unit");
    productRequest.setAmount(4);
    productRequest.setPrice(4.44);
    service.createNewProduct(productRequest);
    return ("<h1>Welcome to my back-end application !<h1>");
  }


}

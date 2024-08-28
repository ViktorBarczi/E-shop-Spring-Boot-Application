package application.page;

import application.product.IProductService;
import application.product.Product;
import application.product.ProductRequest;
import application.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WelcomeResource {
  @Autowired
  private IProductService service;

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);


  @GetMapping("/welcome")
  public String welcome() {
    LOGGER.info("Welcome page was open");
    return "<h2>Welcome to my back-end application!</h2>";
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
    LOGGER.info("A new \"test\" entity has been added to the database");
    return service.createNewProduct(productRequest);
  }

  @DeleteMapping("/resource")
  public void delete(){
    List<Product> list = service.getAll();
    for(Product product : list){
      if(product.getName().equals("test"))
        LOGGER.info("The \"test\" entity has been deleted from the database");
        service.deleteProduct(product.getId());
    }
  }


}

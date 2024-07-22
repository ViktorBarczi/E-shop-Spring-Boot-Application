package application.product;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

  @Autowired
  ProductService productService;

//   @BeforeEach
//   void init() {
//   }

  @Test
  void testCreateNewProduct() {
    ProductRequest productRequest = new ProductRequest();
    productRequest.setName("test Name");
    productRequest.setDescription("test Description");
    productRequest.setUnit("test Unit");
    productRequest.setAmount(4);
    productRequest.setPrice(4.44);

    Product response = productService.createNewProduct(productRequest);

    assertEquals(productRequest.getName(), response.getName());
    assertEquals(productRequest.getDescription(), response.getDescription());
    assertEquals(productRequest.getUnit(), response.getUnit());
    assertEquals(productRequest.getAmount(), response.getAmount());
    assertEquals(productRequest.getPrice(), response.getPrice());
    assertEquals(1L,response.getId());

    response = productService.getProduct(1L);

    assertEquals(productRequest.getName(),response.getName());
    assertEquals(1L,response.getId());
  }
}

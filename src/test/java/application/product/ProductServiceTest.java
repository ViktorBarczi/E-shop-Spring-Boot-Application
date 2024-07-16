package application.product;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {
  ProductService productService = new ProductService(new RepositoryStub());
  // Product product = new Product();
  // ProductResponse productResponse;

  // @BeforeEach
  // void init() {
  //   product.setId(1L);
  //   product.setName("test");
  //   product.setDescription("test Description");
  //   product.setUnit("test Unit");
  //   product.setAmount(4);
  //   product.setPrice(4.44);
  //   productResponse = new ProductResponse(product);
  // }


  @Test
  void testCreateNewProduct() {
    ProductRequest productRequest = new ProductRequest();
    productRequest.setName("test");
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
  }
}

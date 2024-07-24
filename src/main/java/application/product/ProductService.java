package application.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import application.utils.AmountRequest;
import application.utils.AmountResponse;

@Service
public class ProductService implements IProductService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

  private final IProductRepository repository;

  public ProductService(IProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Product> getAll() {
    return this.repository.findAll();
  }

  @Override
  public Product updateProduct(Long id, ProductRequest request) {
    Product pById = repository.findById(id).orElseThrow();

    if (request.getName() != null)
      pById.setName(request.getName());
    if (request.getDescription() != null)
      pById.setDescription(request.getDescription());

    LOGGER.info("Product has been updated");
    return this.repository.save(pById);
  }

  @Override
  public Product getProduct(Long id) {
    return this.repository.findById(id).orElseThrow();
  }



  @Override
  public void deleteProduct(Long id) {
    LOGGER.info("Product has been deleted");
    this.repository.delete(this.repository.findById(id).orElseThrow());
  }


  @Override
  public AmountResponse addAmountToProduct(Long id, AmountRequest request) {
    Product product = this.repository.findById(id).orElseThrow();
    int amount = request.getAmount() + product.getAmount();
    product.setAmount(amount);
    this.repository.save(product);
    LOGGER.info("Amount has been added to the product");
    return new AmountResponse(product.getAmount());
  }

  @Override
  public int getAmountFromProduct(Long id) {
    Product product = this.repository.findById(id).orElseThrow();
    return product.getAmount();
  }

  @Override
  public void amountDecrease(Long id, int amount) {
    Product productToFind = this.repository.findById(id).orElseThrow();
    productToFind.setAmount(productToFind.getAmount() - amount);
    this.repository.save(productToFind);
    LOGGER.info("Amount has been decreased");
  }

  @Override
  public Product createNewProduct(ProductRequest requestProduct) {
    Product product = new Product();

    product.setAmount(requestProduct.getAmount());
    product.setPrice(requestProduct.getPrice());
    product.setName(requestProduct.getName());
    product.setUnit(requestProduct.getUnit());
    product.setDescription(requestProduct.getDescription());

    List<Product> list = this.repository.findAll();

    for (Product currentProd : list) {
      if (currentProd.getName().equals(product.getName())) {
        LOGGER.warn("The product name \"{}\" already exists in the database", product.getName());
        return null;
      }
    }
    LOGGER.info("New product has been created");
    return this.repository.save(product);
  }

}

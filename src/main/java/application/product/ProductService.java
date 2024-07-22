package application.product;

import java.util.List;
import org.springframework.stereotype.Service;
import application.utils.AmountRequest;
import application.utils.AmountResponse;

@Service
public class ProductService implements IProductService {

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

    return this.repository.save(pById);
  }

  @Override
  public Product getProduct(Long id) {
    return this.repository.findById(id).orElseThrow();
  }



  @Override
  public void deleteProduct(Long id) {
    this.repository.delete(this.repository.findById(id).orElseThrow());
  }


  @Override
  public AmountResponse addAmountToProduct(Long id, AmountRequest request) {
    Product product = this.repository.findById(id).orElseThrow();
    int amount = request.getAmount() + product.getAmount();
    product.setAmount(amount);
    this.repository.save(product);
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
        try {
          throw new IOException("Product already exists with the this name: " + product.getName());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }

    return this.repository.save(product);
  }

}

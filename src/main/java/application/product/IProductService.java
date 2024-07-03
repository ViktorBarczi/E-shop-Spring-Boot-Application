package application.product;


import application.amount.*;


import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product createNewProduct(ProductRequest request);
    Product getProduct(Long id);
    Product updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);
    int getAmountFromProduct(Long id);
    AmountResponse addAmountToProduct(Long id, AmountRequest request);
    void amountDecrease(Long id, int amount);

}

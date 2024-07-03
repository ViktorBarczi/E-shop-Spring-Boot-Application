package application.cart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findById(Long id);
    List<ShoppingCart> findAll();
}

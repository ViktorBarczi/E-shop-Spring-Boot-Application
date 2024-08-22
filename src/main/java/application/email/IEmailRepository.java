package application.email;

import application.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmailRepository extends JpaRepository<Email, Long> {
    List<Email> findAll();
}

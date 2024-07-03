package application.list;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemListRepository extends CrudRepository<ItemList, Long> {
    List<ItemList> findAll();
    Optional<ItemList> findById(Long id);
}
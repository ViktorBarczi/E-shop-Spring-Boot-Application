package application.product;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

public class RepositoryStub implements IProductRepository {

  @Override
  public void deleteAllByIdInBatch(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
  }

  @Override
  public void deleteAllInBatch() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
  }

  @Override
  public void deleteAllInBatch(Iterable<Product> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
  }

  @Override
  public List<Product> findAll(Sort sort) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends Product> List<S> findAll(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public List<Product> findAllById(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
  }

  @Override
  public void flush() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'flush'");
  }

  @Override
  public Product getById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
  }

  @Override
  public Product getOne(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOne'");
  }

  @Override
  public Product getReferenceById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
  }

  @Override
  public <S extends Product> List<S> saveAll(Iterable<S> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
  }

  @Override
  public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
  }

  @Override
  public <S extends Product> S saveAndFlush(S entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
  }

  @Override
  public Page<Product> findAll(Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public long count() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'count'");
  }

  @Override
  public void delete(Product entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public void deleteAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
  }

  @Override
  public void deleteAll(Iterable<? extends Product> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
  }

  @Override
  public void deleteAllById(Iterable<? extends Long> ids) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
  }

  @Override
  public void deleteById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }

  @Override
  public boolean existsById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'existsById'");
  }

  @Override
  public Optional<Product> findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public <S extends Product> S save(S entity) {
    // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'save'");
    return entity;
  }

  @Override
  public <S extends Product> long count(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'count'");
  }

  @Override
  public <S extends Product> boolean exists(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'exists'");
  }

  @Override
  public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends Product, R> R findBy(Example<S> example,
      Function<FetchableFluentQuery<S>, R> queryFunction) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findBy'");
  }

  @Override
  public <S extends Product> Optional<S> findOne(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findOne'");
  }

  @Override
  public List<Product> findAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

}

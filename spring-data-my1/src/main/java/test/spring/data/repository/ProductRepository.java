package test.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import test.spring.data.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	
}

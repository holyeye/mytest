package test.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import test.spring.data.domain.BuyProduct;

public interface BuyProductRepository extends CrudRepository<BuyProduct, Long> {

	
}

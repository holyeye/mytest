package test.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import test.spring.data.domain.BuyProduct;
import test.spring.data.oneone.Board;
import test.spring.data.oneone.BoardPK;
import test.spring.data.oneone.Listing;

public interface ListingRepository extends CrudRepository<Listing, Long> {

	
}

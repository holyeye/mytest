package test.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import test.spring.data.domain.BuyProduct;
import test.spring.data.oneone.Board;
import test.spring.data.oneone.BoardDetail;
import test.spring.data.oneone.BoardPK;

public interface BoardDetailRepository extends CrudRepository<BoardDetail, Long> {

	
}

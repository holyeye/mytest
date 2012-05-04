package test.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import test.spring.data.oneone.join.BoardA;

public interface BoardARepository extends CrudRepository<BoardA, Long> {

	
}

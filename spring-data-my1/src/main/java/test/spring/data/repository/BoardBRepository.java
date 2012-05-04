package test.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import test.spring.data.oneone.join.BoardB;

public interface BoardBRepository extends CrudRepository<BoardB, Long> {

	
}

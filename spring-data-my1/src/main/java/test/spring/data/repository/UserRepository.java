package test.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import test.spring.data.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	
}

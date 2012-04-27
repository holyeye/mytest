package test.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import test.spring.data.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findByLoginId(String loginId);
	User findByName(String name);

}

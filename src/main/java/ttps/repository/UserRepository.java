package ttps.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import ttps.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	List<User> findByName(String Name);

}

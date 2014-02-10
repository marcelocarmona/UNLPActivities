package ttps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByName(String name);
	
	User findByUsername(String userName);

}

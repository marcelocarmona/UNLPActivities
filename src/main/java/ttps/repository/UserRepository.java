package ttps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ttps.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByName(String name);
	
	User findByUsername(String userName);
	
//	@Query("select u from User u inner join u.role r where r.role='MODERATOR'")
//	List<User> findModerators();

}

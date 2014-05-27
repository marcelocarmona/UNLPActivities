package ttps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.model.Tag;
import ttps.model.User;

public interface TagRepository extends JpaRepository<Tag, Long>{
	
	Tag findByName(String name);

}

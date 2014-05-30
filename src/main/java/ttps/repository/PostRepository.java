package ttps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ttps.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	@Query("select p from Post p where p.category.id=:id")
	List<Post> findPostsByIdCategory(@Param("id") Long id);

}

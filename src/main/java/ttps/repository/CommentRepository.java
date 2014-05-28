package ttps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.model.Comment;
import ttps.model.Post;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByPost(Post post);
	
}

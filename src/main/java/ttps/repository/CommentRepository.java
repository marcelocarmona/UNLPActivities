package ttps.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.model.Comment;
import ttps.model.Post;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	Set<Comment> findByPost(Post post);
	
}

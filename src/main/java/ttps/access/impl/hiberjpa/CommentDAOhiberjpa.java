package ttps.access.impl.hiberjpa;

import ttps.model.Comment;
import ttps.access.api.CommentDAO;

public class CommentDAOhiberjpa extends GenericDAOhiberjpa<Comment> implements CommentDAO {
	
	public CommentDAOhiberjpa() {
		super(Comment.class);
	}

	
}

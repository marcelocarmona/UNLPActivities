package ttps.access.impl.hiberjpa;

import ttps.model.Post;
import ttps.access.api.PostDAO;

public class PostDAOhiberjpa extends GenericDAOhiberjpa<Post> implements PostDAO {

	public PostDAOhiberjpa(){
		super(Post.class);
	}
}

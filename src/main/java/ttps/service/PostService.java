package ttps.service;

import java.util.List;

import ttps.model.Post;
import ttps.repository.PostRepository;

/**
 * @author mclo
 */
public interface PostService extends PostRepository {

	/**
	 * Se guarda un Post y si se verifica si estan los tags o no en la base para guardarlos
	 * @param post a post
	 * @param tagStrings a tag string
	 */
	void savePostWithTags(Post post, String... tagStrings);

}

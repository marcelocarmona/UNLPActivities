package ttps.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.model.Post;
import ttps.model.Tag;
import ttps.repository.PostRepository;
import ttps.repository.TagRepository;
import ttps.service.PostService;

@Service
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

	@Resource
	private PostRepository postRepository;

	@Resource
	private TagRepository tagRepository;

	public long count() {
		return postRepository.count();
	}

	public void deleteAllInBatch() {
		postRepository.deleteAllInBatch();
	}

	public void deleteInBatch(Iterable<Post> arg0) {
		postRepository.deleteInBatch(arg0);
	}

	public boolean exists(Long id) {
		return postRepository.exists(id);
	}

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public List<Post> findAll(Iterable<Long> arg0) {
		return postRepository.findAll(arg0);
	}

	public Page<Post> findAll(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	public List<Post> findAll(Sort arg0) {
		return postRepository.findAll(arg0);
	}

	public Post findOne(Long id) {
		return postRepository.findOne(id);
	}

	public void flush() {
		postRepository.flush();
	}

	public <S extends Post> List<S> save(Iterable<S> arg0) {
		return postRepository.save(arg0);
	}

	public <S extends Post> S save(S entity) {
		return postRepository.save(entity);
	}

	public Post saveAndFlush(Post arg0) {
		return postRepository.saveAndFlush(arg0);
	}

	public void delete(Long id) {
		postRepository.delete(id);
	}

	public void delete(Post entity) {
		postRepository.delete(entity);
	}

	public void delete(Iterable<? extends Post> entities) {
		postRepository.delete(entities);
	}

	public void deleteAll() {
		postRepository.deleteAll();
	}

	
	public void saveWithTags(Post post) {


	}

	/* (non-Javadoc)
	 * @see ttps.service.PostService#savePostWithTags(ttps.model.Post, java.lang.String[])
	 */
	@Override
	@Transactional(readOnly = false)
	public void savePostWithTags(Post post, String... tagStrings) {
		for (String string : tagStrings) {
			
			if(string == null)System.out.println("----> ES Nuloooooooooooo");
			else if (string == "") System.out.println("--------> Esta vacio");
			System.out.println("--->"+string);
			Tag tag = tagRepository.findByName(string);
			if (tag == null) {
				tag = new Tag();
				tag.setName(string);
			}
			post.getTags().add(tag);
		}
		postRepository.save(post);
		
//		Tag tag = tagRepository.findByName("tag2");
//		if (tag == null) {
//			tag = new Tag();
//			tag.setName("tag2");
//		}
//		System.out.println("---------------->" + tag.getId());
//		post.getTags().add(tag);
//		// tag.getPosts().add(post);
//		postRepository.save(post);
	}

}

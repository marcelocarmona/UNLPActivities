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
import ttps.repository.CommentRepository;
import ttps.repository.PostRepository;
import ttps.repository.TagRepository;
import ttps.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Resource
	private PostRepository postRepository;

	@Resource
	private TagRepository tagRepository;
	
	@Resource
	private CommentRepository commentRepository;

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
		Post post=postRepository.findOne(id);
		post.setComments(commentRepository.findByPost(post));
		return post;
	}

	public void flush() {
		postRepository.flush();
	}

	public <S extends Post> List<S> save(Iterable<S> arg0) {
		return postRepository.save(arg0);
	}

	public <S extends Post> S save(S post) {
		return postRepository.save(post);
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

	@Override
	public void savePostWithTags(Post post, String... tagStrings) {
		
		for (String string : tagStrings) {
			Tag tag = tagRepository.findByName(string);
			if (tag == null) {
				tag = new Tag();
				tag.setName(string);
				tagRepository.save(tag); //save transienst tag
			}
			post.getTags().add(tag);
		}
		postRepository.save(post);

	}

}

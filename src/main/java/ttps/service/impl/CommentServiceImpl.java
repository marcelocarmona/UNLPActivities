package ttps.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ttps.model.Comment;
import ttps.model.Post;
import ttps.repository.CommentRepository;
import ttps.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentRepository commentRepository;

	public List<Comment> findByPost(Post post) {
		return commentRepository.findByPost(post);
	}

	public <S extends Comment> S save(S entity) {
		return commentRepository.save(entity);
	}

	public Page<Comment> findAll(Pageable pageable) {
		return commentRepository.findAll(pageable);
	}

	public Comment findOne(Long id) {
		return commentRepository.findOne(id);
	}

	public boolean exists(Long id) {
		return commentRepository.exists(id);
	}

	public long count() {
		return commentRepository.count();
	}

	public void delete(Long id) {
		commentRepository.delete(id);
	}

	public void delete(Comment entity) {
		commentRepository.delete(entity);
	}

	public void delete(Iterable<? extends Comment> entities) {
		commentRepository.delete(entities);
	}

	public void deleteAll() {
		commentRepository.deleteAll();
	}

	public void deleteAllInBatch() {
		commentRepository.deleteAllInBatch();
	}

	public void deleteInBatch(Iterable<Comment> arg0) {
		commentRepository.deleteInBatch(arg0);
	}

	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	public List<Comment> findAll(Iterable<Long> arg0) {
		return commentRepository.findAll(arg0);
	}

	public List<Comment> findAll(Sort arg0) {
		return commentRepository.findAll(arg0);
	}

	public void flush() {
		commentRepository.flush();
	}

	public <S extends Comment> List<S> save(Iterable<S> arg0) {
		return commentRepository.save(arg0);
	}

	public Comment saveAndFlush(Comment arg0) {
		return commentRepository.saveAndFlush(arg0);
	}
	
	
}

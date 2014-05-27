package ttps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.model.Tag;
import ttps.repository.TagRepository;
import ttps.service.TagService;

@Service
@Transactional(readOnly = true)
public class TagServiceImpl implements TagService {

	@Autowired
	TagRepository tagRepository;

	public Tag findByName(String name) {
		return tagRepository.findByName(name);
	}

	public <S extends Tag> S save(S entity) {
		return tagRepository.save(entity);
	}

	public Page<Tag> findAll(Pageable pageable) {
		return tagRepository.findAll(pageable);
	}

	public Tag findOne(Long id) {
		return tagRepository.findOne(id);
	}

	public boolean exists(Long id) {
		return tagRepository.exists(id);
	}

	public long count() {
		return tagRepository.count();
	}

	public void delete(Long id) {
		tagRepository.delete(id);
	}

	public void delete(Tag entity) {
		tagRepository.delete(entity);
	}

	public void delete(Iterable<? extends Tag> entities) {
		tagRepository.delete(entities);
	}

	public void deleteAll() {
		tagRepository.deleteAll();
	}

	public void deleteAllInBatch() {
		tagRepository.deleteAllInBatch();
	}

	public void deleteInBatch(Iterable<Tag> arg0) {
		tagRepository.deleteInBatch(arg0);
	}

	public List<Tag> findAll() {
		return tagRepository.findAll();
	}

	public List<Tag> findAll(Iterable<Long> arg0) {
		return tagRepository.findAll(arg0);
	}

	public List<Tag> findAll(Sort arg0) {
		return tagRepository.findAll(arg0);
	}

	public void flush() {
		tagRepository.flush();
	}

	public <S extends Tag> List<S> save(Iterable<S> arg0) {
		return tagRepository.save(arg0);
	}

	public Tag saveAndFlush(Tag arg0) {
		return tagRepository.saveAndFlush(arg0);
	}

}

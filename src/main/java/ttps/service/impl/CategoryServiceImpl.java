package ttps.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.model.Category;
import ttps.repository.CategoryRepository;
import ttps.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Resource
	private CategoryRepository categoryRepository;

	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}

	@Transactional(readOnly=false)
	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	public Category findOne(Long id) {
		return categoryRepository.findOne(id);
	}

	public boolean exists(Long id) {
		return categoryRepository.exists(id);
	}

	public long count() {
		return categoryRepository.count();
	}

	@Transactional(readOnly=false)
	public void delete(Long id) {
		categoryRepository.delete(id);
	}

	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	public void delete(Iterable<? extends Category> entities) {
		categoryRepository.delete(entities);
	}

	public void deleteAll() {
		categoryRepository.deleteAll();
	}

	public void deleteAllInBatch() {
		categoryRepository.deleteAllInBatch();
	}

	public void deleteInBatch(Iterable<Category> arg0) {
		categoryRepository.deleteInBatch(arg0);
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public List<Category> findAll(Iterable<Long> arg0) {
		return categoryRepository.findAll(arg0);
	}

	public List<Category> findAll(Sort arg0) {
		return categoryRepository.findAll(arg0);
	}

	public void flush() {
		categoryRepository.flush();
	}

	public <S extends Category> List<S> save(Iterable<S> arg0) {
		return categoryRepository.save(arg0);
	}

	public Category saveAndFlush(Category arg0) {
		return categoryRepository.saveAndFlush(arg0);
	}

}

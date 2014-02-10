package ttps.pruebas;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;

public class CrudService2<T extends CrudRepository<D, Long>,D> implements CrudRepository<D, Long>{
	
	@Resource
	private T repository;

	@Override
	public <S extends D> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public <S extends D> Iterable<S> save(Iterable<S> entities) {
		return repository.save(entities);
	}

	@Override
	public D findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public boolean exists(Long id) {
		return repository.exists(id);
	}

	@Override
	public Iterable<D> findAll() {
		return repository.findAll();
	}

	@Override
	public Iterable<D> findAll(Iterable<Long> ids) {
		return repository.findAll(ids);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public void delete(D entity) {
		repository.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends D> entities) {
		repository.delete(entities);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}
}

package ttps.pruebas;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public class PagingAndSortingService<T extends PagingAndSortingRepository<D, Long>,D > extends CrudService<CrudRepository<D,Long>, D> implements PagingAndSortingRepository<D, Long> {

	@Resource
	private T repository;

	@Override
	public Iterable<D> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public Page<D> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}

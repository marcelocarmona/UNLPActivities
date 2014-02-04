package ttps.service;

import java.util.List;

public interface GenericService<T> {
	  T save(T entity);
	  void delete(long id);
	  List<T> findAll();
	  T update(T entity);
	  T findById(long id);
}

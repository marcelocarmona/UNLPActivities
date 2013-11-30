package ttps.access.api;

import java.util.List;

public interface GenericDAO<T>{
	
	List <T> list();
	
	void persist(T entity);
	
	void remove(long id); 
	
//	void remove(T entity); 
	
	T find(long id);

	void merge(T entity);

}
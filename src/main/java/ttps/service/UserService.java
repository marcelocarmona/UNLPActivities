package ttps.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.config.WebAppConfig;
import ttps.model.User;
import ttps.repository.UserRepository;

@Service
public class UserService implements GenericService<User> {//extends PagingAndSortingService<UserRepository, User>
		//implements UserRepository {

	@Resource
	private UserRepository repository;

//	@Override
//	public List<User> findByName(String name) {
//		return repository.findByName(name);
//	}
	
	@Override
	@Transactional
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
//	public static void main(String[] args) {
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
//				WebAppConfig.class);
//		UserService userService = context.getBean(UserService.class);
//		System.out.println(userService.findAll());
//	}

}

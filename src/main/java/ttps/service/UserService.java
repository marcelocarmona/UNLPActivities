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
@Transactional(readOnly = true)
public class UserService implements GenericService<User> {//extends PagingAndSortingService<UserRepository, User>
		//implements UserRepository {

	@Resource
	private UserRepository repository;

//	@Override
//	public List<User> findByName(String name) {
//		return repository.findByName(name);
//	}
	
	@Override
	@Transactional(readOnly = false)
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(long id) {
		repository.delete(id);
		
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public User update(User user) {
		User updatedUser = repository.findOne(user.getId());
		updatedUser.setName(user.getName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setName(user.getName());
		updatedUser.setPassword(user.getPassword());
		return updatedUser;
	}

	@Override
	public User findById(long id) {
		return repository.findOne(id);
	}
	
	
	
//	public static void main(String[] args) {
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
//				WebAppConfig.class);
//		UserService userService = context.getBean(UserService.class);
//		System.out.println(userService.findAll());
//	}

}

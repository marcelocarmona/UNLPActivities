package ttps.service;

import java.util.List;

import javax.annotation.Resource;

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
public class UserService extends PagingAndSortingService<UserRepository, User>
		implements UserRepository {

	@Resource
	private UserRepository repository;

	@Override
	public List<User> findByName(String name) {
		return repository.findByName(name);
	}
	
	
	
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				WebAppConfig.class);
		UserService userService = context.getBean(UserService.class);
		System.out.println(userService.findAll());
	}

}

package ttps.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.model.User;
import ttps.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserService implements ttps.service.UserService , UserDetailsService {

	@Resource
	private UserRepository userRepository;
	
	
	@Override
	public List<User> findByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public User findByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findAll(Sort sort) {
		return userRepository.findAll(sort);
	}

	@Override
	public List<User> findAll(Iterable<Long> ids) {
		return userRepository.findAll(ids);
	}

	@Override
	public <S extends User> List<S> save(Iterable<S> entities) {
		return userRepository.save(entities);
	}

	@Override
	public void flush() {
		userRepository.flush();
	}

	@Override
	public User saveAndFlush(User entity) {
		return userRepository.saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<User> entities) {
		userRepository.deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch() {
		userRepository.deleteAllInBatch();
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public <S extends User> S save(S entity) {
		return userRepository.save(entity);
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public boolean exists(Long id) {
		return userRepository.exists(id);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends User> entities) {
		userRepository.delete(entities);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return findByUsername(username);
	}

}

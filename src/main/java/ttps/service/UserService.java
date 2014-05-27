package ttps.service;

import org.springframework.security.core.userdetails.UserDetails;

import ttps.model.User;
import ttps.repository.UserRepository;

public interface UserService extends UserRepository {

	UserDetails loadUserByUsername(String username);

}

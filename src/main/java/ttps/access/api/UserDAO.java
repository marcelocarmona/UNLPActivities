package ttps.access.api;


import ttps.model.User;

public interface UserDAO extends GenericDAO<User> {
	
	User find(String name);
	
}

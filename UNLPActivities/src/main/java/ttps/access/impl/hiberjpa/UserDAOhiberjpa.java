package ttps.access.impl.hiberjpa;

import java.util.List;

import javax.persistence.TypedQuery;
import ttps.access.api.UserDAO;
import ttps.model.User;

public class UserDAOhiberjpa extends GenericDAOhiberjpa<User> implements UserDAO {

	public UserDAOhiberjpa() {
		super(User.class);
	}
	

	public User find(String name) {
		TypedQuery<User> q = EMF.getEMF().createEntityManager().createQuery("SELECT u FROM User u WHERE u.name = :name", getType());
		q.setParameter("name",name);	
		List<User> results = q.getResultList();
		
		if(!results.isEmpty()){
			// ignores multiple results
			return results.get(0);
		}
		
		return null;
	}

}

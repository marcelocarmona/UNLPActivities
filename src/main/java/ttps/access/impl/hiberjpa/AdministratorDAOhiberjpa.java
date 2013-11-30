package ttps.access.impl.hiberjpa;

import ttps.model.Administrator;
import ttps.access.api.AdministratorDAO;

public class AdministratorDAOhiberjpa extends GenericDAOhiberjpa<Administrator> implements AdministratorDAO {

	public AdministratorDAOhiberjpa() {
		super(Administrator.class);
		// TODO Auto-generated constructor stub
	}
}

package ttps.access.impl.hiberjpa;

import ttps.model.Guest;
import ttps.access.api.GuestDAO;

public class GuestDAOhiberjpa extends GenericDAOhiberjpa<Guest> implements GuestDAO {

	public GuestDAOhiberjpa() {
		super(Guest.class);
	}
}

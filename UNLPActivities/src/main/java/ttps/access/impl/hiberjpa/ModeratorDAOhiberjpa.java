package ttps.access.impl.hiberjpa;

import ttps.model.Moderator;
import ttps.access.api.ModeratorDAO;

public class ModeratorDAOhiberjpa extends GenericDAOhiberjpa<Moderator> implements ModeratorDAO {

	public ModeratorDAOhiberjpa() {
		super(Moderator.class);
	}

}

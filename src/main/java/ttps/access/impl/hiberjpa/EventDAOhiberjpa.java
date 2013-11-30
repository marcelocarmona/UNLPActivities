package ttps.access.impl.hiberjpa;

import ttps.model.Event;
import ttps.access.api.EventDAO;

public class EventDAOhiberjpa extends GenericDAOhiberjpa<Event> implements EventDAO {

	public EventDAOhiberjpa() {
		super(Event.class);
	}
}

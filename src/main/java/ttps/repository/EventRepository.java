package ttps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}

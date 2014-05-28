package ttps.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.model.Event;
import ttps.repository.EventRepository;
import ttps.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Resource
	private EventRepository eventRepository;

	@Transactional(readOnly = false)
	public <S extends Event> S save(S entity) {
		return eventRepository.save(entity);
	}

	public Page<Event> findAll(Pageable pageable) {
		return eventRepository.findAll(pageable);
	}

	public Event findOne(Long id) {
		return eventRepository.findOne(id);
	}

	public boolean exists(Long id) {
		return eventRepository.exists(id);
	}

	public long count() {
		return eventRepository.count();
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		eventRepository.delete(id);
	}

	public void delete(Event entity) {
		eventRepository.delete(entity);
	}

	public void delete(Iterable<? extends Event> entities) {
		eventRepository.delete(entities);
	}

	@Transactional(readOnly = false)
	public void deleteAll() {
		eventRepository.deleteAll();
	}

	@Transactional(readOnly = false)
	public void deleteAllInBatch() {
		eventRepository.deleteAllInBatch();
	}

	@Transactional(readOnly = false)
	public void deleteInBatch(Iterable<Event> arg0) {
		eventRepository.deleteInBatch(arg0);
	}

	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	public List<Event> findAll(Iterable<Long> arg0) {
		return eventRepository.findAll(arg0);
	}

	public List<Event> findAll(Sort arg0) {
		return eventRepository.findAll(arg0);
	}

	public void flush() {
		eventRepository.flush();
	}

	@Transactional(readOnly = false)
	public <S extends Event> List<S> save(Iterable<S> arg0) {
		return eventRepository.save(arg0);
	}

	@Transactional(readOnly = false)
	public Event saveAndFlush(Event arg0) {
		return eventRepository.saveAndFlush(arg0);
	}

}

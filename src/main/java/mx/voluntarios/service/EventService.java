package mx.voluntarios.service;

import mx.voluntarios.domain.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {

	Page<Event> getEvents(Pageable pageable);

	Event getEvent(Long id);

	Page<Event> getCurrentEvents(Pageable pageable);

	// List<Volunteer> getVolunteers(Long id);
	
	void insertOrUpdateEvent(Event event);

	void disableEvent(Long id);
	
	void deleteEvent(Long id);

}

package mx.voluntarios.service;

import mx.voluntarios.domain.Event;
import mx.voluntarios.repository.EventRepository;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("eventService")
public class EventProvider implements EventService {

	static final Logger LOG = LoggerFactory
			.getLogger(EventProvider.class);

	@Autowired
	EventRepository eventRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<Event> getEvents(Pageable pageable) {

		LOG.debug("Eventos: {}", eventRepository.findAll(pageable));

		return eventRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Event getEvent(Long id) {
		return eventRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Event> getCurrentEvents(Pageable pageable) {
		return eventRepository.findByDateAfter(DateTime.now().toDate(),
				pageable);
	}

	@Override
	public void insertOrUpdateEvent(Event event) {
		eventRepository.save(event);
	}

	@Override
	public void disableEvent(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteEvent(Long id) {
		eventRepository.delete(id);
	}

}

package mx.voluntarios.web.controllers.rest;

import java.util.List;
import java.util.stream.Collectors;

import mx.voluntarios.domain.Event;
import mx.voluntarios.repository.EventRepository;
import mx.voluntarios.repository.VolunteerRepository;
import mx.voluntarios.web.resources.EventResource;
import mx.voluntarios.web.resources.VolunteerResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventRestController {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	VolunteerRepository volunteerRepository;

	@RequestMapping(method = RequestMethod.GET)
	public PagedResources<EventResource> getEvents(Pageable pageable) {
		List<EventResource> eventsResourceList = eventRepository.findAll(pageable)
				.getContent()
				.stream()
				.map(EventResource::new)
				.collect(Collectors.toList());

		PageMetadata pageMetaData = new PageMetadata(
				pageable.getPageSize(),
				pageable.getPageNumber(), 
				eventRepository.count());

		return new PagedResources<EventResource>(eventsResourceList, pageMetaData);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EventResource getEvent(@PathVariable Long id) {
		return new EventResource(eventRepository.findOne(id));
	}
	
	@RequestMapping(value = "/{id}/volunteers", method = RequestMethod.GET)
	public Resources<VolunteerResource> getEventVolunteers(@PathVariable Long id) {
		List<VolunteerResource> volunteersResourceList = volunteerRepository.findByEvent(id)
				.stream()
				.map(VolunteerResource::new)
				.collect(Collectors.toList());

		return new Resources<VolunteerResource>(volunteersResourceList);
	}

}

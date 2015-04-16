package mx.voluntarios.web.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import mx.voluntarios.domain.Event;
import mx.voluntarios.web.controllers.rest.EventRestController;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class EventResource extends ResourceSupport {
	
	private final Event event;

	public EventResource(Event event) {
		this.event = event;
		add(new Link("/events/" + event.getId()).withSelfRel());
		add(new Link("/events/" + event.getId() + "/ong", "event-ong"));
		add(new Link("events/" + event.getId() + "/volunteers", "event-volunteers"));

		add(linkTo(methodOn(EventRestController.class)
				.getEventVolunteers(event.getId()))
				.withRel("event-vols"));
	}

	public Event getEvent() {
		return event;
	}

}

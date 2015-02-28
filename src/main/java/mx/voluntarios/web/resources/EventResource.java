package mx.voluntarios.web.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import mx.voluntarios.domain.Event;
import mx.voluntarios.web.controllers.rest.EventRestController;
import mx.voluntarios.web.controllers.rest.OngRestController;

import org.springframework.hateoas.ResourceSupport;

public class EventResource extends ResourceSupport {
	
	private final Event event;

	public EventResource(Event event) {
		this.event = event;
		add(linkTo(methodOn(EventRestController.class)
				.getEvent(event.getId()))
				.withSelfRel());
		add(linkTo(methodOn(OngRestController.class)
				.getOng(event.getOng().getId()))
				.withRel("ong"));
		add(linkTo(methodOn(EventRestController.class)
				.getEventVolunteers(event.getId()))
				.withRel("event-volunteers"));
	}

	public Event getEvent() {
		return event;
	}

}

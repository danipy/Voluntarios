package mx.voluntarios.web.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import mx.voluntarios.domain.Volunteer;
import mx.voluntarios.web.controllers.rest.VolunteerRestController;

import org.springframework.hateoas.ResourceSupport;

public class VolunteerResource extends ResourceSupport {
	
	private final Volunteer volunteer;

	public VolunteerResource(Volunteer volunteer) {
		this.volunteer = volunteer;
		add(linkTo(methodOn(VolunteerRestController.class)
				.getVolunteer(volunteer.getId()))
				.withSelfRel());
		add(linkTo(methodOn(VolunteerRestController.class)
				.getVolunteerOngs(volunteer.getId()))
				.withRel("volunteer-ongs"));
		add(linkTo(methodOn(VolunteerRestController.class)
				.getVolunteerEvents(volunteer.getId()))
				.withRel("volunteer-events"));
	}

	public Volunteer getVolunteer() {
		return volunteer;
	}

}
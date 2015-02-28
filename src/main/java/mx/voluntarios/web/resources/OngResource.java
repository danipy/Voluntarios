package mx.voluntarios.web.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import mx.voluntarios.domain.Ong;
import mx.voluntarios.web.controllers.rest.OngRestController;

import org.springframework.hateoas.ResourceSupport;

public class OngResource extends ResourceSupport {
	
	private final Ong ong;

	public OngResource(Ong ong) {
		this.ong = ong;
		add(linkTo(methodOn(OngRestController.class)
				.getOng(ong.getId()))
				.withRel("ong"));
		add(linkTo(methodOn(OngRestController.class)
				.getOngEvents(ong.getId()))
				.withRel("ong-events"));
		add(linkTo(methodOn(OngRestController.class)
				.getOngVolunteers(ong.getId()))
				.withRel("ong-volunteers"));
	}

	public Ong getOng() {
		return ong;
	}

}
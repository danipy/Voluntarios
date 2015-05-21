package mx.voluntarios.web.controllers.rest;

import java.util.List;
import java.util.stream.Collectors;

import mx.voluntarios.domain.Ong;
import mx.voluntarios.repository.EventRepository;
import mx.voluntarios.repository.OngRepository;
import mx.voluntarios.repository.VolunteerRepository;
import mx.voluntarios.web.resources.EventResource;
import mx.voluntarios.web.resources.OngResource;
import mx.voluntarios.web.resources.VolunteerResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ongs", produces = MediaType.APPLICATION_JSON_VALUE)
public class OngRestController {

	@Autowired
	OngRepository ongRepository;

	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	VolunteerRepository volunteerRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Resources<OngResource> getOngs() {
		List<OngResource> ongResourceList = ongRepository.findAll()
				.stream()
				.map(OngResource::new)
				.collect(Collectors.toList());

		return new Resources<OngResource>(ongResourceList);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Ong putOng(@RequestBody @Validated Ong ong) {
		return ongRepository.save(ong);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public OngResource getOng(@PathVariable Long id) {
		return new OngResource(ongRepository.findOne(id));
	}
	
	@RequestMapping(value = "/{id}/events", method = RequestMethod.GET)
	public Resources<EventResource> getOngEvents(@PathVariable Long id) {
		List<EventResource> ongEventsResourceList = eventRepository.findByOngId(id)
				.stream()
				.map(EventResource::new)
				.collect(Collectors.toList());

		return new Resources<EventResource>(ongEventsResourceList);
	}
	
	@RequestMapping(value = "/{id}/volunteers", method = RequestMethod.GET)
	public Resources<VolunteerResource> getOngVolunteers(@PathVariable Long id) {
		List<VolunteerResource> ongVolunteersResourceList = volunteerRepository.findByOng(id)
				.stream()
				.map(VolunteerResource::new)
				.collect(Collectors.toList());

		return new Resources<VolunteerResource>(ongVolunteersResourceList);
	}
}

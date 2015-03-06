package mx.voluntarios.web.controllers.rest;

import java.util.List;
import java.util.stream.Collectors;

import mx.voluntarios.repository.EventRepository;
import mx.voluntarios.repository.OngRepository;
import mx.voluntarios.repository.VolunteerRepository;
import mx.voluntarios.web.resources.EventResource;
import mx.voluntarios.web.resources.OngResource;
import mx.voluntarios.web.resources.VolunteerResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(value = "/volunteers", produces = MediaType.APPLICATION_JSON_VALUE)
public class VolunteerRestController {

	@Autowired
	VolunteerRepository volunteerRepository;

	@Autowired
	OngRepository ongRepository;

	@Autowired
	EventRepository eventRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Resources<VolunteerResource> getVolunteers() {
		List<VolunteerResource> volunteerResourceList = volunteerRepository.findAll()
				.stream()
				.map(VolunteerResource::new)
				.collect(Collectors.toList());
		return new Resources<VolunteerResource>(volunteerResourceList);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public VolunteerResource getVolunteer(@PathVariable Long id) {
		return new VolunteerResource(volunteerRepository.findOne(id));
	}
	
	@RequestMapping(value = "/{id}/events", method = RequestMethod.GET)
	public Resources<EventResource> getVolunteerEvents(@PathVariable Long id) {
		List<EventResource> volunteerEventsResourceList = eventRepository.findByVolunteer(id)
				.stream()
				.map(EventResource::new)
				.collect(Collectors.toList());

		return new Resources<EventResource>(volunteerEventsResourceList);
	}
	
	@RequestMapping(value = "/{id}/ongs", method = RequestMethod.GET)
	public Resources<OngResource> getVolunteerOngs(@PathVariable Long id) {
		List<OngResource> volunteerOngsResourceList = ongRepository.findByVolunteer(id)
				.stream()
				.map(OngResource::new)
				.collect(Collectors.toList());

		return new Resources<OngResource>(volunteerOngsResourceList);
	}

}

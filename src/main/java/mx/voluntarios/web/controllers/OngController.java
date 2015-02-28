package mx.voluntarios.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ongs")
public class OngController {

	@RequestMapping(method = RequestMethod.GET)
	public String ongsView() {
		return "ongs";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String ongView() {
		return "ong";
	}

	@RequestMapping(value = "/{id}/events", method = RequestMethod.GET)
	public String ongEventsView() {
		return "events";
	}

	@RequestMapping(value = "/{id}/volunteers", method = RequestMethod.GET)
	public String ongVolunteersView() {
		return "volunteers";
	}
}

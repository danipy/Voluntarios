package mx.voluntarios.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/events")
public class EventController {

	@RequestMapping(method = RequestMethod.GET)
	public String eventsView() {
		return "events";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String eventView() {
		return "event";
	}
}

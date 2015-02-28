package mx.voluntarios.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/volunteers")
public class VolunteerController {

	@RequestMapping(method = RequestMethod.GET)
	public String volunteersView() {
		return "volunteers";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String volunteerView() {
		return "volunteer";
	}
}

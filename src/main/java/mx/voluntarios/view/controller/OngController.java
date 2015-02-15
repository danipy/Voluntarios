package mx.voluntarios.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ongs")
public class OngController {

	@RequestMapping(method = RequestMethod.GET)
	public String orgs() {
		return "ong";
	}
}

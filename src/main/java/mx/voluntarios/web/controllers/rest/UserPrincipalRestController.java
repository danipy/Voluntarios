package mx.voluntarios.web.controllers.rest;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPrincipalRestController {

	@RequestMapping("/user")
	public Principal principal(Principal principal) {
		return principal;
	}

}

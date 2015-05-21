package mx.voluntarios.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public final class SecurityUtils {

	public static String getCurrentUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		UserDetails user = null;
		String username = null;
		if (authentication != null) {
			if (authentication.getPrincipal() instanceof UserDetails) {
				user = (UserDetails) authentication.getPrincipal();
				username = user.getUsername();
			} else if (authentication.getPrincipal() instanceof String) {
				username = (String) authentication.getPrincipal();
			}
		}
		return username;
	}
}

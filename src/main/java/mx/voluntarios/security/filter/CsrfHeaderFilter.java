package mx.voluntarios.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

public class CsrfHeaderFilter extends OncePerRequestFilter {

	private static final String TOKEN_NAME = "XSRF-TOKEN";
	private static final String CONTEXT_PATH = "/Voluntarios/";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		CsrfToken csfr = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		
		if(csfr != null) {
			Cookie cookie = WebUtils.getCookie(request, TOKEN_NAME);
			String token = csfr.getToken();
			if(cookie == null || token != null && !token.equals(cookie.getValue())) {
				cookie = new Cookie(TOKEN_NAME, token);
				cookie.setPath(CONTEXT_PATH);
				response.addCookie(cookie);
			}
		}
		filterChain.doFilter(request, response);
	}

}

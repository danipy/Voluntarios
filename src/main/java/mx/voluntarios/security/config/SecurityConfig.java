package mx.voluntarios.security.config;

import mx.voluntarios.web.filter.CsrfHeaderFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	        .inMemoryAuthentication()
	        	.withUser("vol").password("pass").roles("VOL")
        	.and()
	        	.withUser("ong").password("pass").roles("ONG");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
				.authorizeRequests()
				.antMatchers("/resources/**", "/partials/**", "/login")
				.permitAll()
				.anyRequest().authenticated()
			.and()
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
				.csrf().csrfTokenRepository(csrfTokenRepository());
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}

}

package mx.voluntarios.security;

import mx.voluntarios.domain.Ong;
import mx.voluntarios.domain.Volunteer;
import mx.voluntarios.repository.OngRepository;
import mx.voluntarios.repository.VolunteerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsService implements
		org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	OngRepository ongRepository;

	@Autowired
	VolunteerRepository volunteerRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		Ong ong = ongRepository.findOneByUsername(username.toLowerCase());
		Volunteer vol = volunteerRepository.findOneByUsername(username.toLowerCase());

		if (ong != null)
			return ong;
		if (vol != null)
			return vol;

		throw new UsernameNotFoundException("EL usuario no puede ser econtrado");
	}

}

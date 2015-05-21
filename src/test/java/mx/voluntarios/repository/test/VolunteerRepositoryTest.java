package mx.voluntarios.repository.test;

import java.util.List;

import mx.voluntarios.config.ApplicationContext;
import mx.voluntarios.domain.Volunteer;
import mx.voluntarios.repository.VolunteerRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ApplicationContext.class })
public class VolunteerRepositoryTest {

	private static Logger LOG = LoggerFactory
			.getLogger(VolunteerRepositoryTest.class);

	@Autowired
	VolunteerRepository volunteerRepository;

	@Test
	@Transactional(readOnly = true)
	public void getVolunteersTest() {
		List<Volunteer> vols = volunteerRepository.findAll();
		
		System.out.println("------ Voluntarios --------");
		for (Volunteer vol : vols) {
			System.out.println(vol.getName() + vol.getSurname() + " - "
					+ vol.getUsername());
		}
	}

	@Test
	@Transactional(readOnly = true)
	public void getVolunteersByOngTest() {
		final long id = 1L;  
		List<Volunteer> vols = volunteerRepository.findByOng(id);

		System.out.println("------ Voluntarios de Ong - " + id + " --------");

		for (Volunteer vol : vols) {
			System.out.println(vol.getName() + vol.getSurname() + " - "
					+ vol.getUsername());
		}
	}

}

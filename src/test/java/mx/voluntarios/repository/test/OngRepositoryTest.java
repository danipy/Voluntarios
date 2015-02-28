package mx.voluntarios.repository.test;
import java.util.Date;
import java.util.List;

import mx.voluntarios.config.ApplicationContext;
import mx.voluntarios.domain.Ong;
import mx.voluntarios.repository.OngRepository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ApplicationContext.class })
public class OngRepositoryTest {

	private static Logger LOG = LoggerFactory
			.getLogger(OngRepositoryTest.class);

	@Autowired
	OngRepository ongRepository;

	@Ignore
	@Test
	@Modifying
	@Transactional
	public void saveEventsTest() {
		
		LOG.trace(">> saveEventsTest()");

		Ong ong = new Ong();
		ong.setId(1000L);
		ong.setName("FilantroposMX");
		ong.setDescription("Organizacion no gubernamental sin fines de lucro");
		ong.setCv((short) 1);
		ong.setDateCreated(new Date());
		
		ongRepository.save(ong);
		
		Ong ongDb = ongRepository.getOne(1000L);
		System.out.println("---------------- Ong -----------------");
		System.out.println(ongDb);
	}

	@Test
	@Transactional(readOnly = true)
	public void getVolunteersTest() {
		List<Ong> ongs = ongRepository.findAll();

		System.out.println("------ Ongs --------");
		for (Ong ong : ongs) {
			System.out.println(ong.getName() + " - " + ong.getId());
		}
	}

}

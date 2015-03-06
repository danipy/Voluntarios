package mx.voluntarios.repository.test;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.voluntarios.config.ApplicationContext;
import mx.voluntarios.domain.Event;
import mx.voluntarios.domain.Ong;
import mx.voluntarios.repository.EventRepository;
import mx.voluntarios.repository.OngRepository;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ApplicationContext.class })
public class EventRepositoryTest {

	private static Logger LOG = LoggerFactory
			.getLogger(EventRepositoryTest.class);

	@Autowired
	EventRepository eventRepository;

	@Autowired
	OngRepository ongRepository;

	@Test
	@Transactional(readOnly = true)
	public void findAllPageRequestTest() {
		Page<Event> events = eventRepository.findAll(new PageRequest(0, 10));

		System.out.println("---------------- Eventos -----------------");
		for (Event event : events) {
			System.out.println(event.getId() + " " + event.getName() + " - "
					+ event.getOng().getName());
		}
	}

	@Test
	@Transactional(readOnly = true)
	public void findAllTest() {
		List<Event> events = eventRepository.findAll();

		System.out.println("---------------- Eventos -----------------");
		for (Event event : events) {
			System.out.println(event.getName() + " - " + event.getId());
		}
	}

	@Test
	@Transactional(readOnly = true)
	public void findByOngIdTest() {
		List<Event> ongEvents = eventRepository.findByOngId(2L);

		System.out.println("---------------- OngEvents -----------------");
		for (Event event : ongEvents) {
			System.out.println(event.getId() + " - " + event.getName());
		}
	}

	@Test
	@Transactional(readOnly = true)
	public void findByDateAfter() {
		String fecha = "2013-06-30T01:20"; // Iso datetime format
		Page<Event> ongEvents = eventRepository.findByDateAfter(DateTime
				.parse(fecha)
				.toDate(), new PageRequest(0, 10));

		System.out.println("---------------- OngEvents -----------------");
		for (Event event : ongEvents) {
			System.out.println(event.getId() + " - " + event.getName() + " - "
					+ event.getDate());
		}
	}

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
		
		List<Event> events = new ArrayList<Event>(0);
		
		Event e1 = new Event();
		Event e2 = new Event();
		Event e3 = new Event();
		Event e4 = new Event();
		Event e5 = new Event();
		Event e6 = new Event();
		Event e7 = new Event();
		Event e8 = new Event();
		Event e9 = new Event();
		Event e10 = new Event();

		e1.setId(1L);
		e2.setId(2L);
		e3.setId(3L);
		e4.setId(4L);
		e5.setId(5L);
		e6.setId(6L);
		e7.setId(7L);
		e8.setId(8L);
		e9.setId(9L);
		e10.setId(10L);

		e1.setName("Evento 1");
		e2.setName("Evento 2");
		e3.setName("Evento 3");
		e4.setName("Evento 4");
		e5.setName("Evento 5");
		e6.setName("Evento 6");
		e7.setName("Evento 7");
		e8.setName("Evento 8");
		e9.setName("Evento 9");
		e10.setName("Evento 10");

		e1.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		e2.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		e3.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		e4.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		e5.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		e6.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		e7.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		e8.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		e9.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		e10.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");

		e1.setOng(ong);
		e2.setOng(ong);
		e3.setOng(ong);
		e4.setOng(ong);
		e5.setOng(ong);
		e6.setOng(ong);
		e7.setOng(ong);
		e8.setOng(ong);
		e9.setOng(ong);
		e10.setOng(ong);

		e1.setDate(new DateTime().toDate());
		e2.setDate(new DateTime().withDate(2014, 12, 24).toDate());
		e3.setDate(new DateTime().withDate(2015, 1, 10).toDate());
		e4.setDate(new DateTime().withDate(2015, 2, 9).toDate());
		e5.setDate(new DateTime().withDate(2015, 3, 1).toDate());
		e6.setDate(new DateTime().withDate(2015, 7, 2).toDate());
		e7.setDate(new DateTime().withDate(2015, 5, 25).toDate());
		e8.setDate(new DateTime().withDate(2015, 12, 24).toDate());
		e9.setDate(new DateTime().toDate());
		e10.setDate(new DateTime().withDate(2016, 4, 30).toDate());

		e1.setTime("5:00");
		e2.setTime("5:00");
		e3.setTime("5:00");
		e4.setTime("5:00");
		e5.setTime("5:00");
		e6.setTime("5:00");
		e7.setTime("5:00");
		e8.setTime("5:00");
		e9.setTime("5:00");
		e10.setTime("5:00");

		e1.setAddress("Sereno #80, Colinas del Sur C.P. 01430");
		e2.setAddress("Sereno #80, Colinas del Sur C.P. 01430");
		e3.setAddress("Sereno #80, Colinas del Sur C.P. 01430");
		e4.setAddress("Sereno #80, Colinas del Sur C.P. 01430");
		e5.setAddress("Sereno #80, Colinas del Sur C.P. 01430");
		e6.setAddress("Sereno #80, Colinas del Sur C.P. 01430");
		e7.setAddress("Sereno #80, Colinas del Sur C.P. 01430");
		e8.setAddress("Sereno #80, Colinas del Sur C.P. 01430");
		e9.setAddress("Sereno #80, Colinas del Sur C.P. 01430");
		e10.setAddress("Sereno #80, Colinas del Sur C.P. 01430");

		e1.setLat("33.92837");
		e2.setLat("33.92837");
		e3.setLat("33.92837");
		e4.setLat("33.92837");
		e5.setLat("33.92837");
		e6.setLat("33.92837");
		e7.setLat("33.92837");
		e8.setLat("33.92837");
		e9.setLat("33.92837");
		e10.setLat("33.92837");

		e1.setLng("33.92837");
		e2.setLng("33.92837");
		e3.setLng("33.92837");
		e4.setLng("33.92837");
		e5.setLng("33.92837");
		e6.setLng("33.92837");
		e7.setLng("33.92837");
		e8.setLng("33.92837");
		e9.setLng("33.92837");
		e10.setLng("33.92837");
		
		events.add(e1);
		events.add(e2);
		events.add(e3);
		events.add(e4);
		events.add(e5);
		events.add(e6);
		events.add(e7);
		events.add(e8);
		events.add(e9);
		events.add(e10);

		eventRepository.save(events);
		
		// List<Event> eventos = eventRepository.findAll();
		Page<Event> eventos = eventRepository.findByDateAfter(new Date(),
				new PageRequest(0, 10));
		
		for (Event evnt : eventos) {
			LOG.debug("Evento: {} - {}, fecha: {}", evnt.getName(),
					evnt.getOng(), evnt.getDate());
		}

		assertTrue("Deben de ser 10", eventos.getSize() == 10);
	}

}

package mx.voluntarios.view.controller;

import mx.voluntarios.domain.Event;
import mx.voluntarios.service.EventService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/events")
public class EventController {
	
	final static Logger LOG = LoggerFactory
			.getLogger(EventController.class);

	@Autowired
	EventService eventService;

	@RequestMapping(method = RequestMethod.GET)
	public String events() {
		return "events";
	}

	@RequestMapping(value = "content/events", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Event> getEvents(@RequestParam int page, @RequestParam int size) {

		Page<Event> eventsPage = eventService.getEvents(new PageRequest(page, size));

		LOG.debug("Eventos: {}", eventsPage);

		return eventsPage;

		// List<Event> events = new ArrayList<Event>(0);
		//
		// Event e1 = new Event();
		// Event e2 = new Event();
		// Event e3 = new Event();
		// Event e4 = new Event();
		// Event e5 = new Event();
		// Event e6 = new Event();
		// Event e7 = new Event();
		// Event e8 = new Event();
		// Event e9 = new Event();
		// Event e10 = new Event();
		//
		// e1.setName("Evento 1");
		// e2.setName("Evento 2");
		// e3.setName("Evento 3");
		// e4.setName("Evento 4");
		// e5.setName("Evento 5");
		// e6.setName("Evento 6");
		// e7.setName("Evento 7");
		// e8.setName("Evento 8");
		// e9.setName("Evento 9");
		// e10.setName("Evento 10");
		//
		// e1.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		// e2.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		// e3.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		// e4.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		// e5.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		// e6.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		// e7.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		// e8.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		// e9.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		// e10.setDescription("But we've met before. That was a long time ago, I was a kid at St. Swithin's, It used to be funded by the Wayne Foundation.");
		//
		// e1.setOngName("FilantroposMX");
		// e2.setOngName("Voluntarios YMCA");
		// e3.setOngName("Voluntarios de Mexico");
		// e4.setOngName("Voluntarios en el Mundo");
		// e5.setOngName("Voluntarios México");
		// e6.setOngName("Fundacion Mark");
		// e7.setOngName("Amevol");
		// e8.setOngName("Fundacion Infantia");
		// e9.setOngName("NPH - México");
		// e10.setOngName("Nosotros los Jóvenes");
		//
		// e1.setDate(new Date());
		// e2.setDate(new Date());
		// e3.setDate(new Date());
		// e4.setDate(new Date());
		// e5.setDate(new Date());
		// e6.setDate(new Date());
		// e7.setDate(new Date());
		// e8.setDate(new Date());
		// e9.setDate(new Date());
		// e10.setDate(new Date());
		//
		// e1.setTime("5:00 p.m. UTC");
		// e2.setTime("5:00 p.m. UTC");
		// e3.setTime("5:00 p.m. UTC");
		// e4.setTime("5:00 p.m. UTC");
		// e5.setTime("5:00 p.m. UTC");
		// e6.setTime("5:00 p.m. UTC");
		// e7.setTime("5:00 p.m. UTC");
		// e8.setTime("5:00 p.m. UTC");
		// e9.setTime("5:00 p.m. UTC");
		// e10.setTime("5:00 p.m. UTC");
		//
		// e1.setLocation("Sereno #80, Colinas del Sur C.P. 01430");
		// e2.setLocation("Sereno #80, Colinas del Sur C.P. 01430");
		// e3.setLocation("Sereno #80, Colinas del Sur C.P. 01430");
		// e4.setLocation("Sereno #80, Colinas del Sur C.P. 01430");
		// e5.setLocation("Sereno #80, Colinas del Sur C.P. 01430");
		// e6.setLocation("Sereno #80, Colinas del Sur C.P. 01430");
		// e7.setLocation("Sereno #80, Colinas del Sur C.P. 01430");
		// e8.setLocation("Sereno #80, Colinas del Sur C.P. 01430");
		// e9.setLocation("Sereno #80, Colinas del Sur C.P. 01430");
		// e10.setLocation("Sereno #80, Colinas del Sur C.P. 01430");
		//
		// e1.setLat("33.92837");
		// e2.setLat("33.92837");
		// e3.setLat("33.92837");
		// e4.setLat("33.92837");
		// e5.setLat("33.92837");
		// e6.setLat("33.92837");
		// e7.setLat("33.92837");
		// e8.setLat("33.92837");
		// e9.setLat("33.92837");
		// e10.setLat("33.92837");
		//
		// e1.setLng("33.92837");
		// e2.setLng("33.92837");
		// e3.setLng("33.92837");
		// e4.setLng("33.92837");
		// e5.setLng("33.92837");
		// e6.setLng("33.92837");
		// e7.setLng("33.92837");
		// e8.setLng("33.92837");
		// e9.setLng("33.92837");
		// e10.setLng("33.92837");
		//
		// events.add(e1);
		// events.add(e2);
		// events.add(e3);
		// events.add(e4);
		// events.add(e5);
		// events.add(e6);
		// events.add(e7);
		// events.add(e8);
		// events.add(e9);
		// events.add(e10);
		//
		// try {
		// Thread.sleep(1500);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// return events;
	}

	@RequestMapping(value = "{id}")
	@ResponseBody
	public Event getEvent(@PathVariable Long id) {
		return eventService.getEvent(id);
	}
}

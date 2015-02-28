package mx.voluntarios.view.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import mx.voluntarios.config.ApplicationContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContext.class)
public class ControllerTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	private MediaType contentType = new MediaType(
			MediaType.APPLICATION_JSON.getType());

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void getEventsTest() throws Exception {
		this.mockMvc
				.perform(
						get("/events/content/events").param("page", "1")
						.param("size", "10"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType));
	}
	
	@Test
	public void getEventTest() throws Exception {
		this.mockMvc
				.perform(
						get("/events/1"))
						.andExpect(status().isOk());
	}

	@Test
	public void getOngTest() throws Exception {
		this.mockMvc
				.perform(get("/resources/ongs/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType));
	}

	@Test
	public void getRestOngs() throws Exception {
		this.mockMvc
				.perform(get("/resources/ongs"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType));
	}
}

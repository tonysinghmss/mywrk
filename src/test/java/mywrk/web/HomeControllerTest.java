package mywrk.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import mywrk.config.WebAppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration
public class HomeControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void testHome_ShouldRenderHomePage() throws Exception {
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("home"))
		.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
		.andExpect(content().string(containsString("Welcome to MyWrk")))
		;
	}
}

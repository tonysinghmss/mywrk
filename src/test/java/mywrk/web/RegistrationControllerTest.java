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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import mywrk.config.WebAppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration
public class RegistrationControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		//Mockito.reset(mocks);
		mockMvc = webAppContextSetup(this.wac).build();

	}

	@Test
	public void testShowRegistrationForm_ShouldCreateUsersObjectAndRenderRegistrationForm() throws Exception {
		mockMvc.perform(get("/"+RegistrationController.VIEW_REGISTER_USER))
				.andExpect(status().isOk())
				.andExpect(view().name(RegistrationController.VIEW_REGISTER_USER))
				.andExpect(model().attribute("user", hasProperty("userName", nullValue())))
				.andExpect(model().attribute("user", hasProperty("firstName", isEmptyOrNullString())))
				.andExpect(model().attribute("user", hasProperty("lastName", isEmptyOrNullString())))
				.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
				//.andExpect(content().string(containsString(substring)))
				//.andReturn();
				//result.getResponse()
				
				;		
	}
	
	/*@Test
	public void testProcessRegistration_EmptyUserEntry_ShouldRenderRegistrationFormAndReturnValidationError() throws Exception{
		mockMvc.perform(post(RegistrationController.VIEW_REGISTER_USER)
					.contentType(MediaType.APPLICATION_FORM_URLENCODED)
					//.sessionAttr(name, value)
					)
				.andExpect(status().isOk());
	}*/

}

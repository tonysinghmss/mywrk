package mywrk.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.view.ThymeleafView;

import mywrk.config.WebAppConfig;
import mywrk.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration
public class RegistrationControllerTest {
	private MockMvc mockMvc;
	
	@InjectMocks
	private RegistrationController regstrCtlr;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(regstrCtlr)
					.setViewResolvers(viewResolver())
					.build();

	}
	
	private InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates/");
		viewResolver.setSuffix(".html");
		return viewResolver;
	}

	@Test
	public void testShowRegistrationForm() throws Exception {
		mockMvc.perform(get("/registerform"))
				.andExpect(status().isOk())
				.andExpect(view().name(RegistrationController.VIEW_REGISTER_USER))
				.andExpect(model().attribute("user", hasProperty("userName", nullValue())))
				.andExpect(model().attribute("user", hasProperty("firstName", isEmptyOrNullString())))
				.andExpect(model().attribute("user", hasProperty("lastName", isEmptyOrNullString())))
				//.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
				//.andExpect(content().string(containsString(substring)))
				//.andReturn();
				//result.getResponse()
				
				;		
	}
	
	@Test
	public void testProcessRegistrationWithOutErrors() throws Exception{
		mockMvc.perform(post("/register")
					.contentType(MediaType.APPLICATION_FORM_URLENCODED)
					.sessionAttr("user", new User())
					.param("userName", "DUMMYserName")
					.param("password", "dummyPassword")
					.param("firstName", "dummyFirstName")
					.param("email", "DUMMYEMAIL@WAL.MAIL")
					)
				//.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name(RegistrationController.VIEW_HOME))
				;
	}
	
	@Test
	public void testProcessRegistrationWithErrors() throws Exception{
		mockMvc.perform(post("/register")
					.contentType(MediaType.APPLICATION_FORM_URLENCODED)
					.sessionAttr("user", new User())
					.param("userName", "")
					.param("password", "ab")
					)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name(RegistrationController.VIEW_REGISTER_USER))
				;
	}

}

package com.maty.j2ee.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Maty Chen
 * @date 2013-1-15上午11:22:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest extends Controller {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void loginSuccess() throws Exception {
		this.mockMvc
		.perform(get("/loginSuccess"))
		.andExpect(status().is(404))
		.andExpect(content().string(""));
		
		this.mockMvc
		.perform(post("/loginSuccess"))
		.andExpect(status().is(404))
		.andExpect(content().string(""));

	}
}

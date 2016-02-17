package com.spring.controllers.test;

import static org.junit.Assert.*;

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


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml",
		"classpath:com/spring/config/test/spring-config.xml",
		"classpath:com/spring/configs/security-context.xml"})
@WebAppConfiguration(value = "WebContent")
public class UnitTestControllers {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

	@Before
	public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testDummy() {
		assertEquals("Dummy test", 1, 1);
	}

	@Test
	public void testShowPropertyList() throws Exception {
		mockMvc.perform(get("/showPropertyList"))  
		.andExpect(status().isOk())
		.andExpect(view().name("PropertyList"))
		.andExpect(forwardedUrl("PropertyList.jsp"))
		.andReturn();
	}
	
}

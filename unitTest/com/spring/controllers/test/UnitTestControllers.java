package com.spring.controllers.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.spring.domain.PropertyBld;
import com.spring.domain.test.PropertyBldBuilder;
import com.spring.service.PropertyBldServiceImp;
import org.hamcrest.core.IsCollectionContaining;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml",
		"classpath:com/spring/config/test/spring-config.xml",
		"classpath:com/spring/configs/security-context.xml"})
@WebAppConfiguration(value = "WebContent")
public class UnitTestControllers {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
	@Autowired
	PropertyBldServiceImp prptSvMock;
	@Autowired
	PropertyBldServiceImp prptSv;

	
	@Before
	public void setUp(){
		Mockito.reset(prptSvMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testDummy() {
		assertEquals("Dummy test", 1, 1);
	}

	@Test
	public void testShowPropertyList() throws Exception {
		
		MvcResult result = mockMvc.perform(get("/showPropertyList"))  
		.andExpect(status().isOk())
		.andExpect(view().name("PropertyList"))
		.andExpect(forwardedUrl("PropertyList.jsp"))
		.andReturn();
		
		Assert.assertNotNull(result.getModelAndView().getModel().get("propertyList"));		
	}
	
	
	@Test
	public void testPropertyValueInList() throws Exception {
		//prptSvMock = Mockito.mock(PropertyBldServiceImp.class);
		PropertyBld bld1 = new PropertyBldBuilder()
				.setPropertyId(101)
				.setPropertyName("UnitT1")
				.setRent_sale("Rent")
				.build();
		PropertyBld bld2 = new PropertyBldBuilder()
				.setPropertyId(102)
				.setPropertyName("UnitT2")
				.setRent_sale("Rent")
				.build();

		List<PropertyBld> prptLst = new ArrayList<PropertyBld>();
		prptLst.add(bld1);
		prptLst.add(bld2);
		Mockito.when(prptSvMock.getPropertyList()).thenReturn(prptLst);

		Assert.assertEquals(2, prptSvMock.getPropertyList().size());
		Assert.assertThat(prptSvMock.getPropertyList(), contains(bld1,bld2));
		Assert.assertThat(prptSvMock.getPropertyList(), IsCollectionContaining.<PropertyBld>hasItem(
				allOf(
						hasProperty("propertyId", is(101)),
						hasProperty("propertyName", equalTo("UnitT1"))
					  )));
	}
}

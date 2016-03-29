package unitTest.spring.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.spring.controllers.ProptCntl;
import com.spring.domain.PropertyBld;
//import com.spring.service.UserService;
import com.spring.service.PropertyBldServiceImp;

import unitTest.spring.domain.PropertyBldBuilder;

import org.hamcrest.core.IsCollectionContaining;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml",
		"classpath:unitTest/spring/config/spring-config.xml",
		"classpath:com/spring/configs/security-context.xml"})

@WebAppConfiguration(value = "WebContent")

public class UnitTestControllers {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    PropertyBldServiceImp prptSvImpMock;

/*//For standalone unit test env setup   
    @Mock
    PropertyBldServiceImp prptSvImpMock;

    @InjectMocks
    ProptCntl mockPrptCntl;
*/
    
	@Before
	public void setUp(){
/*//For standalone unit test 
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(mockPrptCntl).build();
*/		
        Mockito.reset(prptSvImpMock);
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
		//.andExpect(forwardedUrl("PropertyList"))
		.andReturn();
		
		Assert.assertNotNull(result.getModelAndView().getModel().get("propertyList"));		
	}
	
	
	@Test
	public void testPropertyValueInList() throws Exception {
		//PropertyBldService prptSvImpMock = Mockito.mock(PropertyBldService.class);
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
		Mockito.when(prptSvImpMock.getPropertyList()).thenReturn(prptLst);

		Assert.assertEquals(2, prptSvImpMock.getPropertyList().size());
		Assert.assertThat(prptSvImpMock.getPropertyList(), contains(bld1,bld2));
		Assert.assertThat(prptSvImpMock.getPropertyList(), IsCollectionContaining.<PropertyBld>hasItem(
				allOf(
						hasProperty("propertyId", is(101)),
						hasProperty("propertyName", equalTo("UnitT1"))
					  )));

/*The testing fails*/		
		mockMvc.perform(get("/showPropertyList"))  
		.andExpect(status().isOk())
		.andExpect(view().name("PropertyList"))
		.andExpect(forwardedUrl("PropertyList.jsp"))
		//.andExpect(forwardedUrl("PropertyList"))
		.andExpect(model().attribute("propertyList", org.hamcrest.Matchers.hasItem(
			allOf(
					hasProperty("propertyId", is(101)),
					hasProperty("propertyName", equalTo("UnitT1"))
			)
		)));
/*The testing fails*/
	}
	
}

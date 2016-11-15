package com.microservice.widget.controllerTest;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.microservice.widget.controller.WidgetServiceAPIController;
import com.microservice.widget.model.Widget;
import com.microservice.widget.service.WidgetCollectionsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(WidgetServiceAPIController.class)
public class WidgetServiceAPIControllerTest {

	//@Test
	//public void contextLoads() {
	//}

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private WidgetCollectionsService widgetCollectionsService;
	
	@Test
	public void test() throws Exception{
		final int widgetID=2;
		final Widget w=new Widget();
		w.setName("widget");
		
		widgetCollectionsService.getWidgetByID(widgetID);
		when(String.valueOf(RETURNS_MOCKS));
		
		
		mvc.perform(get(WidgetServiceAPIController.testURL, widgetID).accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk()).andExpect(content().string("widget"));
		
		verify(widgetCollectionsService).getWidgetByID(widgetID);
	}
	
	


	/*
	 * Testing Conditon(s): Default
	 */
/*	@Test
	public void test_method_getAll_0_branch_0()
	{
		System.out.println("Now Testing Method:getAll Branch:0");
		
		//Constructor
		WidgetServiceAPIController instance = 
		
		//Get expected result and result
		Object expResult = ;
		Object result = instance.getAll();
		
		//Check Return value
		assertEquals(expResult, result);
		
		//Check Test Verification Points
		assertEquals(, instance.);
		
	}

	/*
	 * Testing Conditon(s): Default
	 */
/*	@Test
	public void test_method_getWidget_1_branch_0()
	{
		System.out.println("Now Testing Method:getWidget Branch:0");
		
		//Constructor
		WidgetServiceAPIController instance = 
		
		//Get expected result and result
		Object expResult = ;
		Object result = instance.getWidget();
		
		//Check Return value
		assertEquals(expResult, result);
		
		//Check Test Verification Points
		assertEquals(, instance.);
		
	}

	/*
	 * Testing Conditon(s): Default
	 */
/*	@Test
	public void test_method_submitWidget_2_branch_0()
	{
		System.out.println("Now Testing Method:submitWidget Branch:0");
		
		//Constructor
		WidgetServiceAPIController instance = 
		
		//Get expected result and result
		Object expResult = ;
		Object result = instance.submitWidget(, );
		
		//Check Return value
		assertEquals(expResult, result);
		
		//Check Test Verification Points
		assertEquals(, instance.);
		
	}

	/*
	 * Testing Conditon(s): Default
	 */
/*	@Test
	public void test_method_updateWidget_3_branch_0()
	{
		System.out.println("Now Testing Method:updateWidget Branch:0");
		
		//Constructor
		WidgetServiceAPIController instance = 
		
		//Get expected result and result
		Object expResult = ;
		Object result = instance.updateWidget(, );
		
		//Check Return value
		assertEquals(expResult, result);
		
		//Check Test Verification Points
		assertEquals(, instance.);
		
	}
*/
}

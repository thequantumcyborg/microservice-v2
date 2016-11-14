package com.microservice.widget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.widget.model.Widget;
import com.microservice.widget.service.WidgetCollectionsService;

@RestController
@RequestMapping
public class WidgetServiceAPIController {

	
	@Autowired
	private WidgetCollectionsService widgetCollectionsService;
	
	@GetMapping("/widgets")
	public java.util.List<Widget> getAll(){
		
		return widgetCollectionsService.getAll();
	}
	
	@GetMapping("/widgets/{id}")
	public String getWidget(@PathVariable int id){
		
		return widgetCollectionsService.getWidgetByID(id);
	}
}

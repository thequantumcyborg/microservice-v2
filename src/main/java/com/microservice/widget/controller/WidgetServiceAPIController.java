package com.microservice.widget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.widget.model.Widget;
import com.microservice.widget.service.WidgetCollectionsService;

@RestController
@RequestMapping
public class WidgetServiceAPIController {

	@Autowired
	private WidgetCollectionsService widgetCollectionsService;

	@GetMapping("/widgets")
	public java.util.List<Widget> getAll() {

		return widgetCollectionsService.getAll();
	}

	@GetMapping("/widgets/{id}")
	public String getWidget(@PathVariable int id) {

		return widgetCollectionsService.getWidgetByID(id);
	}

	@RequestMapping(value = "/widgets/add/api", method = RequestMethod.POST)
	public String submitWidget(@ModelAttribute Widget widget, Model model) {
		
		Widget w = widgetCollectionsService.addWidget(widget.getName(), widget.getDescription());
		model.addAttribute("widget", w);

		String apiurlBuilder = "{\"location\" : \"/widgets/" + w.getId() + "\"}";
		return apiurlBuilder;
	}
	
	@RequestMapping(value = "/widgets/update/api/{id}", method = RequestMethod.PUT)
	public Widget updateWidget(@PathVariable("id") int id,@RequestBody Widget widget) {
		
		Widget w = widgetCollectionsService.updateWidget(widget.getName(), widget.getDescription(),widget.getId());
		

		
		return w;
	}
}

package com.microservice.widget.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.widget.model.Widget;
import com.microservice.widget.service.WidgetCollectionsService;


@RequestMapping
@Controller
public class WidgetServiceViewController {
	
	
	@Autowired
	private WidgetCollectionsService widgetCollectionsService;

	
	@RequestMapping(value="/widgets/in",method=RequestMethod.GET)
	public String signWidget(@ModelAttribute Widget widget,Model model) {
	
	
  
      model.addAttribute("widget", widget);
		
        return "dashboard";
     }
	
	@RequestMapping(value="/widgets/add",method=RequestMethod.POST)
	public String submitWidget(@ModelAttribute Widget widget,Model model) {
	
	  
      Widget w= widgetCollectionsService.addWidget(widget.getName(),widget.getDescription());
       model.addAttribute("widget", w);
		
        return "add/newwidget";
     }

}

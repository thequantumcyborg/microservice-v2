package com.microservice.widget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.widget.dao.WidgetRepositoryJDBCImpl;
import com.microservice.widget.model.Widget;

@Service
public class WidgetCollectionsService {
	
	@Autowired
	private WidgetRepositoryJDBCImpl widgetRepositoryJDBC;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public java.util.List<Widget> getAll(){
		return widgetRepositoryJDBC.findAll();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public String getWidgetByID(int id){
		java.util.List <Widget> wlist=widgetRepositoryJDBC.findWidget(id);
		String name=wlist.get(0).getName();
		return name;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Widget addWidget(String name,String description){
		
		Widget addedWidget=widgetRepositoryJDBC.save(name,description);
		
		return addedWidget;
	} 
	
}

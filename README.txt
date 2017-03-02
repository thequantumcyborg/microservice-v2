/*
 * Copyright 2016 Jump Technologies, Inc. - All Rights Reserved
 * Proprietary and Confidential
 * Unauthorized copying of this file, via any medium, is strictly prohibited without permission.
*/

Welcome to the Jump Technologies, Inc. code test.  This is a simple RESTful server which deals with fictional "Widgets".  

This project uses gradle as its build system.  Either install gradle or use the gradlew program in the project folder to build.

To start the server, run:
./gradlew run

Go to http://localhost:8080/widgets/hello to hit the example endpoint.  You should see "hello world" in your browser.  
This endpoint does not require authentication but any additional resource methods will require the Basic Authentication of: jumpdeveloper/bojangles.  

Demo Spec

1) Implement the WidgetResource methods (as defined in the next section)
2) Make sure all existing tests pass
3) Optionally implement your own WidgetDaoInterface and replace the supplied WidgetDaoJdbi along with tests (Use WidgetDaoTest as a start)
	See CodeTestApplication.java for more information
4) Optionally implement your own AuthenticationFilter and replace the supplied Base64AuthFilter
	See CodeTestApplication.java for more information
	You can hard-code the jumpdeveloper/bojangles credentials into the filter and not require the use of a data store.
	

The Widget class is represented by the following JSON structure:
{
	"id" : 1,
	"name" : "Widget",
	"description" : "a cool widget"
}

You will need to implement a service class which supports the following operations:
	GET /widgets - returns an array of widgets
	
	GET /widgets/{id} - returns a specific widget
	
	POST /widgets 
		request data:
			{
				"name" : "Widget",
				"description" : "a cool widget"
			}
		ressponse data:
			{
				"location" : "/widgets/{id}"
			}
			
	
	
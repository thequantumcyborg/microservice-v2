
To start the server, run:
./gradlew run

Go to http://localhost:8080/widgets/hello to hit the example endpoint.  You should see "hello world" in your browser.  
 
Demo Spec

1) Implement the WidgetResource methods (as defined in the next section)
2)  Mockito & Unit Tests
3)  implement WidgetDaoInterface and replace the supplied WidgetDaoJdbi along with tests
4)  implement  AuthenticationFilter
	

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
			
	
	
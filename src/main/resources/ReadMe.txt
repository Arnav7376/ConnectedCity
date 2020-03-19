								MASTERCARD CODE CHALLENGE 
							================================
  You’re asked to write a program using Spring Boot & Java (1.8 or above) which determines if two cities are connected.  
  Two cities are considered connected if there’s a series of roads that can be traveled from one city to another.   
  List of roads is available in a file. The file contains a list of city pairs (one pair per line, comma separated), which indicates that 
  there’s a road between those cities.   
  
  It will be deployed as a Spring Boot App and expose one endpoint: http://localhost:8080/connected?origin=city1&destination=city2   
  Your program should respond with ‘yes’ if city1 is connected to city2, ’no’ if city1 is not connected to city2. 
  Any unexpected input should result in a ’no’ response. 
  For Example: 
 city.txt content is: Boston, New York Philadelphia, Newark Newark, Boston Trenton, Albany   
 http://localhost:8080/connected?origin=Boston&destination=Newark 
 	Should return yes 
 
 http://localhost:8080/connected?origin=Boston&destination=Philadelphia 
 	Should return yes 
 
 http://localhost:8080/connected?origin=Philadelphia&destination=Albany 
 	Should return no

===============================================================================================================
										===	Connected application summary ===
===============================================================================================================

"Connected" is an application developed to return the routes found between given two cities. 
This solution is implemented with Java Spring Boot RESTfull service.

Application has provided city.txt file configured in application.properties.
This file contains one or more records, each line has two city separated with comma.
	
Application has three basic functionalities.

		1)Data			2)Data Loader			3) Processor
		========		===============		    =================
		= File = ===>	= Data Loader =	===>	= Search Engine =
		========		===============			=================

1. File is having data to be processed.
2. Data Loader loads data from file and make it available for search engine.
3. Search Engine processes data to find routes between two cities.   

Connected application exposes API as an resource over HTTP. This could be enhanced to provide API documentation(Swagger), 
exposing service over cloud, register with Service Registry(Netflix Eureka) to locate the service, load balance and Auto Scaling cloud architecture. 
Service can be protected through API Gateway.

 
Combination of Resource URLs and corresponding responses are as below. 
e.g
a)
	http://localhost:8080/connected?origin=Philadelphia&destination=New%20York
	http://localhost:8080/connected?origin=Philadelphia&destination=New York
	
	output:
	[Philadelphia > Newark > Newark > Boston > Boston > New York, Philadelphia > New York]
b)
	http://localhost:8080/connected?origin=Boston&destination=New%20York

	output:
	[Boston > New York]

c)
	http://localhost:8080/connected?origin=&destination=New%20York
	http://localhost:8080/connected?origin=&destination=

	output:
	(No connectivity found for requested route)

d)
	http://localhost:8080/connected
	http://localhost:8080/connected?destination=New%20York
	
	output:
	(Origin/Destination missing in uri path)

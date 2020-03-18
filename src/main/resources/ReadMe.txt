								MASTERCARD CODE CHALLENGE 
							================================
  You’re asked to write a program using Spring Boot & Java (1.8 or above) which determines if two cities are connected.  Two cities are considered connected if there’s a series of roads that can be traveled from one city to another.   List of roads is available in a file. The file contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities.   
  
  It will be deployed as a Spring Boot App and expose one endpoint: http://localhost:8080/connected?origin=city1&destination=city2   
  Your program should respond with ‘yes’ if city1 is connected to city2, ’no’ if city1 is not connected to city2. Any unexpected input should result in a ’no’ response. 
  For Example: 
 city.txt content is: Boston, New York Philadelphia, Newark Newark, Boston Trenton, Albany   http://localhost:8080/connected?origin=Boston&destination=Newark Should return yes http://localhost:8080/connected?origin=Boston&destination=Philadelphia Should return yes http://localhost:8080/connected?origin=Philadelphia&destination=Albany Should return no

Connected resource application is returning the routes identified for elected Cities.

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

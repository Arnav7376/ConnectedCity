package com.rest.connect.connected;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityConnect {
	
	List<List<String>> totalRouts=null;
	List<String> initializeRoute;
	
	@Autowired
	CityConnectivityService connectivityService;
	
	 @Value("${spring.file.name}") 
	 private String fileName; 

	
	@GetMapping(path="/connected")
	public String getConnectivity(@PathParam("origin") String origin, @PathParam("destination") String destination) throws Exception{
		//Initialize route to empty for each request;
		Route route = connectivityService.getRoute();
		route.setPathList(initializeRoute);
		totalRouts = connectivityService.getCitiesConnectivityData(fileName);
		
		if(totalRouts == null)
			throw new Exception("Cities connectivity service could not load the data.");
		
		if(origin!=null && destination!=null) {
			connectivityService.match(origin, destination, totalRouts); 
		}else {
			//throw new Exception("Origin/Destination missing in uri path");
			return "Origin/Destination missing in uri path";
		}
		System.out.println("getFoundMessage :"+route.getFoundMessage());
			
		return route.getPathList()!=null? route.getPathList().toString():"No connectivity found for requested route";
	}
	
}

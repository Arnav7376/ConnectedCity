package com.rest.connect.connected;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
* The CityConnectivityService provides services API to load file and prepared data for finding 
* routes connecting given cities.
* @author Santosh
* @version 1.0 
*/
@Service
public class CityConnectivityService {

	private List<List<String>> citiesConnectivity;
	private static CityConnectivityService connectivityService;
	
	StringBuffer fullPath;
	public static final String FOUND = "Route Found";
	List<String> fullPathList;

	private Route route = new Route();
	
	/**
	 * getCitiesConnectivityData(String fileName) is reading file passed as an argument and returns List of arrays of cities.
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public List<List<String>> getCitiesConnectivityData(String fileName) throws Exception{
		fullPathList = new ArrayList();
		fullPath = new StringBuffer();
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
			System.out.println("Path Found :"+path);
			if(Files.exists(path)) {
				try(Stream<String> lines = Files.lines(path)){
					citiesConnectivity = lines
							.map( line -> Arrays.asList(line.split(",")))
							.collect(Collectors.toList());
					System.out.println("citiesConnectivity Data :"+citiesConnectivity);
				}
			}
		} catch (URISyntaxException | IOException e) {
			throw new Exception("File access could not be reached");
		}
		return citiesConnectivity;
	}
	
	/**
	 * match(String from, String to, List<List<String>> routes) function is able to search routes between two cities(from,to) from List of data passed.
	 * and sets result to Route bean.
	 * @param from
	 * @param to
	 * @param routes
	 * @throws Exception 
	 */
	public void match(String from, String to, List<List<String>> routes) throws Exception {
		String nextOrigin="";
		if(routes==null || from == null || to == null)
			throw new Exception("Please correct search criteria");
		
		for(int i=0; i<routes.size(); i++) {
			List<String> routeRecord = routes.get(i);
			if(routeRecord.size()==2) {
				if(routeRecord.get(0).trim().equals(from.trim())) {
					fullPath.append(from +" > ");
					nextOrigin = routeRecord.get(1).trim().equals(to.trim()) ? FOUND : routeRecord.get(1).trim();
					if(!nextOrigin.equals("Route Found")) {
						fullPath.append(nextOrigin +" > ");
						match(nextOrigin, to, routes);
					}else {
						route.setFoundMessage("Route Found");
						fullPathList.add(fullPath.append(to).toString());
						route.setPathList(fullPathList);	
						fullPath= new StringBuffer();
						break;
					}
				}
			}
		}
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	
}

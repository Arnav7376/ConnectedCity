package com.rest.connect.connected;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CityConnectivityServiceTest {
	CityConnectivityService service;
	List<List<String>> cityRouts;
    private String fileName; 
	 
	@BeforeEach
	void setUp() throws Exception {
		service = new CityConnectivityService();
		fileName="city.txt";
	}

	@Test
	void testGetCitiesConnectivityData() throws Exception {
		List<List<String>> cityRouts = service.getCitiesConnectivityData(fileName);		
		assertNotNull(cityRouts);
	}

	@Test
	void testMatch() throws Exception {		
		service.match("Philadelphia", "New York", service.getCitiesConnectivityData(fileName));		
		//System.out.println("3333##### "+service.getRoute().getPathList());
		assertNotNull(service.getRoute().getPathList());
	}

	@Test
	void testMatch_EmptySearch() throws Exception {		
		service.match("AAA", "BBB", service.getCitiesConnectivityData(fileName));		
		//System.out.println("123##### "+service.getRoute().getPathList());
		assertNull(service.getRoute().getPathList());
	}
}

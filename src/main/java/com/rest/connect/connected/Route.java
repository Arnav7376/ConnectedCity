package com.rest.connect.connected;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Santosh
 * this class is used to specify if Route exist and path it has.
 */
public class Route {

	private String foundMessage;
	List<String> pathList;
	
	public String getFoundMessage() {
		return foundMessage;
	}
	public void setFoundMessage(String foundMessage) {
		this.foundMessage = foundMessage;
	}

	public List<String> getPathList() {
		return pathList;
	}
	public void setPathList(List<String> pathList) {
		this.pathList=pathList;
	}
}

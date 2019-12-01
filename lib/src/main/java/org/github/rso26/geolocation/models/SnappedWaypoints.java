package org.github.rso26.geolocation.models;

import java.util.List;

public class SnappedWaypoints{
	private List<List<Double>> coordinates;
	private String type;

	public void setCoordinates(List<List<Double>> coordinates){
		this.coordinates = coordinates;
	}

	public List<List<Double>> getCoordinates(){
		return coordinates;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"SnappedWaypoints{" + 
			"coordinates = '" + coordinates + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}
package org.github.rso26.geolocation.models;

import java.util.List;

public class Route{
	private double distance;
	private List<Double> bbox;
	private String routeUuid;
	private int time;
	private SnappedWaypoints snappedWaypoints;
	private Points points;

	public void setDistance(double distance){
		this.distance = distance;
	}

	public double getDistance(){
		return distance;
	}

	public void setBbox(List<Double> bbox){
		this.bbox = bbox;
	}

	public List<Double> getBbox(){
		return bbox;
	}

	public void setRouteUuid(String routeUuid){
		this.routeUuid = routeUuid;
	}

	public String getRouteUuid(){
		return routeUuid;
	}

	public void setTime(int time){
		this.time = time;
	}

	public int getTime(){
		return time;
	}

	public void setSnappedWaypoints(SnappedWaypoints snappedWaypoints){
		this.snappedWaypoints = snappedWaypoints;
	}

	public SnappedWaypoints getSnappedWaypoints(){
		return snappedWaypoints;
	}

	public void setPoints(Points points){
		this.points = points;
	}

	public Points getPoints(){
		return points;
	}

	@Override
 	public String toString(){
		return 
			"Route{" + 
			"distance = '" + distance + '\'' + 
			",bbox = '" + bbox + '\'' + 
			",routeUuid = '" + routeUuid + '\'' + 
			",time = '" + time + '\'' + 
			",snapped_waypoints = '" + snappedWaypoints + '\'' + 
			",points = '" + points + '\'' + 
			"}";
		}
}
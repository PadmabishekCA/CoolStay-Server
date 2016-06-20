package com.cool.stay.server.dto;

public class Itinerary {
	private String id;
	private String name;
	private String description;
	private String image;
	private String route;
	private String vehicleTypes;
	private String maxNumbers;
	private String userId;

	public Itinerary(String id, String name, String description, String image, String route, String vehicleTypes,
			String maxNumbers, String userId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.route = route;
		this.vehicleTypes = vehicleTypes;
		this.maxNumbers = maxNumbers;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getVehicleTypes() {
		return vehicleTypes;
	}

	public void setVehicleTypes(String vehicleTypes) {
		this.vehicleTypes = vehicleTypes;
	}

	public String getMaxNumbers() {
		return maxNumbers;
	}

	public void setMaxNumbers(String maxNumbers) {
		this.maxNumbers = maxNumbers;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}

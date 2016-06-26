package com.cool.stay.server.dto;

import java.util.Map;

public class Cuisine {
	private String id;
	private String name;
	private String description;
	private String image;
	private String priority;
	private String userId;
	private Double amount;

	

	public Cuisine(String id, String name, String description, String image, String priority, String userId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.priority = priority;
		this.userId = userId;
	}

	public Cuisine(String id, String name, String description){
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	
	public Cuisine(Map cuisineDetail){
		this.name=cuisineDetail.get("cuisineName").toString();
		this.description=cuisineDetail.get("cuisineDesc").toString();
		this.amount=Double.parseDouble(cuisineDetail.get("cuisineAmount").toString());
	}
	
	public Cuisine(String id){
		this.id = id;
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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}

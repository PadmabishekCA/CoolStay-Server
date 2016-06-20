package com.cool.stay.server.dto;

import java.util.Map;

public class CuisineOrder {
	private int id;
	private String cuisineName;
	private String quantity;
	private String userName;
	private String foodType;
public CuisineOrder()
{
	
}
	public CuisineOrder(int id,String cuisineName,String quantity,String userName,String foodType)
	{
		this.id=id;
		this.cuisineName=cuisineName;
		this.quantity=quantity;
		this.userName=userName;
		this.foodType=foodType;
	}
	
	public CuisineOrder(Map map){
		this.cuisineName=map.get("fname").toString();
		this.quantity=map.get("quantity").toString();
		this.userName=map.get("nameOfUserOrdering").toString();
		this.foodType=map.get("fType").toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuisineName() {
		return cuisineName;
	}

	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
}

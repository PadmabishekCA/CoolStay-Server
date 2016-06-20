package com.cool.stay.server.dto;

public class OrderDetail {

	private int userId;
	private int cuisineId;
	private double amount;
	 
	public OrderDetail(int userId, int cuisineId, double amount)
	{
		this.userId=userId;
		this.cuisineId=cuisineId;
		this.amount=amount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCuisineId() {
		return cuisineId;
	}

	public void setCuisineId(int cuisineId) {
		this.cuisineId = cuisineId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}

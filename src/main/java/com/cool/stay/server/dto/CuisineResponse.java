package com.cool.stay.server.dto;



public class CuisineResponse {

	private String username;
	private String cuisineName;
	private double amount;
	private String date;
	
	public CuisineResponse(String username, String cuisineName, double amount,String date){
		this.username=username;
		this.cuisineName=cuisineName;
		this.amount=amount;
		this.date=date;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCuisineName() {
		return cuisineName;
	}

	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}

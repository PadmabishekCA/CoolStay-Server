package com.cool.stay.server.dto;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class GamesBooking {
	private String userName;
	private Date bookingDate;
	private String gameName;
	
	public GamesBooking(String userName,Date bookingDate,String gameName){
		this.userName=userName;
		this.bookingDate=bookingDate;
		this.gameName=gameName;
	}
	
	public GamesBooking(Map checkingSlot){
		this.userName=checkingSlot.get("nameOfUserBooking").toString();
		this.gameName=checkingSlot.get("gamesName").toString();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date=null;
		try {
			date = sdf.parse(checkingSlot.get("gamesDate").toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
       System.out.println("Date in constructor"+date);
        java.sql.Date sqlDate = new Date(date.getTime());
        System.out.println("date in sql formatted form "+sqlDate);
        this.bookingDate=sqlDate;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
}

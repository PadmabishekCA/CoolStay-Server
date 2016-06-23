package com.cool.stay.server.dto;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class GamesSlotDetail {
	
	private int referenceId;
	private int slotId;
	private String gameName;
	private String userName;
	private  Date bookingDate;
	private String slotIntreval;
	

	public GamesSlotDetail(Map bookInfoMap,String slotId){
		System.out.println("Slot id inside constructor"+slotId);
		this.slotId=Integer.parseInt(slotId);
		this.gameName=bookInfoMap.get("gameNameForJson").toString();
		this.userName=bookInfoMap.get("userNameForJson").toString();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date=null;
		try {
			date = sdf.parse(bookInfoMap.get("bookingdateForJson").toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
       System.out.println("Date in constructor1"+date);
        java.sql.Date sqlDate = new Date(date.getTime());
        System.out.println("date in sql formatted form 1"+sqlDate);
        this.bookingDate=sqlDate;
	
		
	}
	
	public GamesSlotDetail(String slotIntreval,String gameName, Date bookeddate){
		this.slotIntreval=slotIntreval;
		this.gameName=gameName;
		this.bookingDate=bookeddate;
	}
	
	public int getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
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
	

	public String getSlotIntreval() {
		return slotIntreval;
	}

	public void setSlotIntreval(String slotIntreval) {
		this.slotIntreval = slotIntreval;
	}
}

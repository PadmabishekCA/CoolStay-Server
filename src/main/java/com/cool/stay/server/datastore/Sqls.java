package com.cool.stay.server.datastore;

public final class Sqls {
	public static final String getUsers = "select *from user_table";
	public static final String addUser = "insert into user_table values (null, ?, ?, ?)";
	public static final String deleteUser = "delete from user_table where name = ?";
	public static final String confirmUser = "select password,rolename from user_table where name = ?";
	
	
	public static final String getCuisines = "select *from t_mst_cuisine";
	public static final String addCuisine = "insert into t_mst_cuisine(name,description) values (?, ?)";
	public static final String addCuisineAmount="insert into t_mst_amount(name,amount) values(?,?)";
	public static final String deleteCuisine = "delete from t_mst_cuisine where id= ?";
	
	public static final String addCuisineOrder = "insert into t_dtl_cuisine (cuisineId,quantity,userId,type,amount,paystatus) values (?, ?, ?, ?,?,?)";
	public static final String getInfoForCuisineOrder="select distinct t1.id as cusine_id,t3.id as user_id,t2.amount from t_mst_cuisine t1,t_mst_amount t2,user_table t3 where t3.name =? and t1.name=? and t2.name =?";
	public static final String getOrderInfoOfUser = "select t1.name as username, t2.name as cuisinename, t3.amount as totalamount , t3.update_time as date from user_table t1,t_mst_cuisine t2,t_dtl_cuisine t3 where t1.name=? and t1.id=t3.userId and t3.cuisineId = t2.id ";
	
	
	
	public static final String checkGameStatus="select id,Intreval from t_mst_slot where id not in (select slotId from t_dtl_slot where gameName=? and slotdate =?)";
	public static final String bookGameSlot="insert into t_dtl_slot(slotId,gameName,userName,slotdate) values(?,?,?,?)";
	public static final String slotBookingStatusOfUser="select t1.Intreval as intreval, t2.gameName as gamename , t2.slotdate as bookeddate from t_mst_slot t1,t_dtl_slot t2 where t1.id=t2.slotId and t2.userName =?";
	
	public static final String getGamess = "select *from t_mst_games";
	public static final String addGames = "insert into t_mst_games(name,description) values(?, ?)";
	public static final String deleteGames = "delete from t_mst_games where id = ?";
	
	public static final String getGamesBooking = "select *from games_booking";
	public static final String addGamesBooking = "insert into games_booking values (null, ?, ?, ?, ?, ?, ?, ?)";
	public static final String deleteGamesBooking = "delete from games_booking where description = ?";
	
	public static final String getItineraries = "select *from itinerary";
	public static final String addItinerary = "insert into itinerary values (null, ?, ?, ?, ?, ?, ?, ?)";
	public static final String deleteItinerary = "delete from itinerary where name = ?";
	
	public static final String getSlots = "select *from slot";
	public static final String addSlot = "insert into slot values (?, ?)";
	public static final String deleteSlot = "delete from slot where start_time = ?";
}
;
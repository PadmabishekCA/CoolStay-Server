package com.cool.stay.server.datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cool.stay.server.dto.CuisineOrder;
import com.cool.stay.server.dto.GamesBooking;
import com.cool.stay.server.dto.GamesSlotDetail;
import com.cool.stay.server.dto.OrderDetail;

public class ConnectionManager {
	private static Connection conn;

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		if (null == conn) {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/ht", "rms_app", "rmsapp123");
		}

		return conn;
	}

	public int executeUpdate(String sql) throws ClassNotFoundException, SQLException {
		Statement stmt = getConnection().createStatement();
		return stmt.executeUpdate(sql);
	}

	public ResultSet executeQuery(String sql) throws SQLException, ClassNotFoundException {
		Statement stmt = getConnection().createStatement();
		return stmt.executeQuery(sql);
	}
	public ResultSet executeQuery(String sql,String username) throws SQLException, ClassNotFoundException {
		ResultSet rs=null;
		PreparedStatement confirmEmp = getConnection().prepareStatement(sql);
		confirmEmp.setString(1, username);
		rs =confirmEmp.executeQuery();
		return rs;
	}
	
	public ResultSet executeQuery(String sql, GamesBooking bookingInfo) throws SQLException, ClassNotFoundException {
		ResultSet rs=null;
		System.out.println("Booking date : "+bookingInfo.getBookingDate());
		System.out.println("Game Name : "+bookingInfo.getGameName());
		PreparedStatement checkSlot = getConnection().prepareStatement(sql);
		checkSlot.setString(1, bookingInfo.getGameName());
		checkSlot.setDate(2, bookingInfo.getBookingDate());
		rs=checkSlot.executeQuery();
		return rs;
	}
	public ResultSet executeQuery(String sql,CuisineOrder c) throws SQLException, ClassNotFoundException {
		ResultSet rs=null;
		PreparedStatement confirmEmp = getConnection().prepareStatement(sql);
		confirmEmp.setString(1, c.getUserName());
		confirmEmp.setString(2, c.getCuisineName());
		confirmEmp.setString(3, c.getCuisineName());
		rs =confirmEmp.executeQuery();
		return rs;
	}
	public int executeUpdate (String sql , GamesSlotDetail slot)throws SQLException, ClassNotFoundException {
		int rs=0;
		PreparedStatement bookSlot = getConnection().prepareStatement(sql);
		bookSlot.setInt(1, slot.getSlotId());
		bookSlot.setString(2, slot.getGameName());
		bookSlot.setString(3, slot.getUserName());
		bookSlot.setDate(4, slot.getBookingDate());
		rs=bookSlot.executeUpdate();
		return rs;
	}
	
	
	
	public int executeUpdate(String sql, OrderDetail o,CuisineOrder l) throws ClassNotFoundException, SQLException {
		System.out.println("Inside Connection manager");
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, o.getCuisineId());
		pstmt.setInt(2,Integer.parseInt(l.getQuantity()));
		pstmt.setInt(3, o.getUserId());
		pstmt.setString(4,l.getFoodType());
		pstmt.setDouble(5, Integer.parseInt(l.getQuantity())*o.getAmount());
		pstmt.setString(6, "N");
		return pstmt.executeUpdate();
	}
	
	
	
	public int executeUpdate(String sql, Object... args) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		int ctr = 1;
		for (Object arg : args) {
			pstmt.setString(ctr, arg.toString());
			++ctr;
		}

		return pstmt.executeUpdate();
	}
}

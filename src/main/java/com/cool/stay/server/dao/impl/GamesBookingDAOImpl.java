package com.cool.stay.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cool.stay.server.datastore.ConnectionManager;
import com.cool.stay.server.datastore.Sqls;
import com.cool.stay.server.dto.GamesBooking;

public class GamesBookingDAOImpl {
	private static ConnectionManager conMgr = new ConnectionManager();;

	public List<GamesBooking> getGamesBookings() throws ClassNotFoundException, SQLException {
		ResultSet rs = conMgr.executeQuery(Sqls.getGamesBooking);
		List<GamesBooking> lst = new ArrayList<GamesBooking>();

		while (rs.next()) {
			GamesBooking user = new GamesBooking(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			lst.add(user);
		}

		return lst;
	}

	public void addGamesBooking(GamesBooking user) {
		try {
			conMgr.executeUpdate(Sqls.addGamesBooking, user.getId(), user.getGamesId(), user.getUserId(),
					user.getSlotId(), user.getUpdateDate(), user.getDescription(), user.getUsername(), user.getSaved());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteGamesBooking(GamesBooking user) {
		System.out.println("user name " + user.getDescription());
		try {
			conMgr.executeUpdate(Sqls.deleteGamesBooking, user.getDescription());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
